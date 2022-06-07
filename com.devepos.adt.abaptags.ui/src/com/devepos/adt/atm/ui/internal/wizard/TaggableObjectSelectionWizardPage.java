package com.devepos.adt.atm.ui.internal.wizard;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.help.HelpContexts;
import com.devepos.adt.atm.ui.internal.help.HelpUtil;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.ui.project.ProjectInput;
import com.devepos.adt.base.ui.search.AdtRisSearchUtil;
import com.devepos.adt.base.ui.search.IAdtRisSearchResultProxy;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.ui.wizard.AbstractBaseWizardPage;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Wizard page for selecting the objects that should be tagged
 *
 * @author stockbal
 */
public class TaggableObjectSelectionWizardPage extends AbstractBaseWizardPage {
  private enum ValidationSource {
    PROJECT,
    OBJECTS
  }

  public static final String PAGE_NAME = TaggableObjectSelectionWizardPage.class.getCanonicalName();
  private ProjectInput projectInput;
  private final List<ObjectToBeTagged> objects = new ArrayList<>();
  private TableViewer objectsViewer;

  private Button removeObjectsButton;

  private Button selectObjectsButton;

  public TaggableObjectSelectionWizardPage() {
    super(PAGE_NAME);
    setTitle(Messages.TaggableObjectSelectionWizardPage_Title_xtit);
    setDescription(Messages.TaggableObjectSelectionWizardPage_Description_xmsg);

  }

  @Override
  public void completePage() {
    // clear any available tag preview information, as it has to be reloaded
    getWizard().setCurrentTagPreviewInfo(null);
    final List<IAdtObjRef> adtObjRefList = getWizard().getSelectedObjects().getObjectReferences();
    adtObjRefList.clear();
    for (final ObjectToBeTagged objToBeTagged : objects) {
      final IAdtObjectReference objRef = objToBeTagged.getRef();
      final IAdtObjRef adtObjRef = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
      adtObjRef.setUri(objRef.getUri());
      adtObjRefList.add(adtObjRef);
    }
    setDirty(false);
  }

  @Override
  public void createControl(final Composite parent) {
    final Composite root = new Composite(parent, SWT.NONE);
    HelpUtil.setHelp(root, HelpContexts.TAG_WIZARD_OBJECT_SELECTION);
    GridLayoutFactory.swtDefaults().applyTo(root);

    createProjectInput(root);
    createObjectsList(root);

    setControl(root);

    setPageComplete(false);
  }

  @Override
  public ITagObjectsWizard getWizard() {
    return (ITagObjectsWizard) super.getWizard();
  }

  @Override
  public void setVisible(final boolean visible) {
    if (visible && !isPageComplete()) {
      getWizard().completePreviousPage(this);
    }
    super.setVisible(visible);
  }

  protected void createProjectInput(final Composite root) {
    projectInput = new ProjectInput(true);
    projectInput.createControl(root);
    projectInput.addProjectValidator(project -> AbapTagsServiceFactory.createTagsService()
        .testTagsFeatureAvailability(project));
    projectInput.addStatusChangeListener(status -> {
      if (status.isOK()) {
        final IProject newProject = projectInput.getProjectProvider().getProject();
        final IProject oldProject = getWizard().getProject();
        if (newProject != oldProject) {
          objects.clear();
          objectsViewer.refresh();
          getWizard().setProject(newProject);
        }
      }
      validatePage(status, ValidationSource.PROJECT);
    });
    IProject currentProject = getWizard().getProject();
    if (currentProject != null) {
      projectInput.setProjectName(currentProject.getName());
    }
  }

  private void createObjectsList(final Composite parent) {
    final Composite container = new Composite(parent, SWT.NONE);
    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(container);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(container);

    final Label objectsViewerLabel = new Label(container, SWT.NONE);
    objectsViewerLabel.setText(
        Messages.TaggableObjectSelectionWizardPage_SelectedObjectsTableTitle_xtit);
    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.CENTER)
        .span(2, 1)
        .grab(true, false)
        .applyTo(objectsViewerLabel);

    objectsViewer = new TableViewer(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.VIRTUAL);
    objectsViewer.setContentProvider(new ArrayContentProvider());
    objectsViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(
        new AdtObjectLabelProvider()));

    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.FILL)
        .grab(true, true)
        .minSize(250, 300)
        .applyTo(objectsViewer.getControl());

    final Composite buttonComposite = new Composite(container, SWT.NONE);
    GridLayoutFactory.swtDefaults()
        .numColumns(1)
        .margins(0, 0)
        .extendedMargins(2, 2, 0, 2)
        .applyTo(buttonComposite);
    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.BEGINNING)
        .grab(false, true)
        .applyTo(buttonComposite);

    selectObjectsButton = new Button(buttonComposite, SWT.PUSH);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(selectObjectsButton);
    selectObjectsButton.setText(Messages.TaggableObjectSelectionWizardPage_SelectObjects_xbut);
    selectObjectsButton.setEnabled(getWizard().getProject() != null);
    selectObjectsButton.addSelectionListener(widgetSelectedAdapter(e -> {
      final IAdtRisSearchResultProxy result = AdtRisSearchUtil.searchAdtObjectViaDialog(
          Messages.TaggableObjectSelectionWizardPage_SelectObjectsDialogTitle_xtit, true,
          getWizard().getProject());
      if (result == null) {
        return;
      }
      for (final IAdtObjectReference ref : result.getAllSelectedResults()) {
        objects.add(new ObjectToBeTagged(ref));
      }
      objectsViewer.refresh();
      validatePage(null, ValidationSource.OBJECTS);
    }));

    removeObjectsButton = new Button(buttonComposite, SWT.PUSH);
    removeObjectsButton.setText(Messages.TaggableObjectSelectionWizardPage_RemoveSelected_xbut);
    removeObjectsButton.setEnabled(false);
    removeObjectsButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        removeSelectedObjects();
        validatePage(null, ValidationSource.OBJECTS);
      }
    });
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(removeObjectsButton);

    objectsViewer.setInput(objects);
    objectsViewer.addSelectionChangedListener(e -> {
      final ISelection sel = e.getSelection();
      removeObjectsButton.setEnabled(sel != null && !sel.isEmpty());
    });
  }

  private void removeSelectedObjects() {
    final IStructuredSelection sel = (IStructuredSelection) objectsViewer.getSelection();
    if (sel.isEmpty()) {
      return;
    }

    for (final Object selObject : sel.toList()) {
      objects.remove(selObject);
    }
    objectsViewer.refresh();
  }

  private void updatePageStatus(final IStatus pageStatus) {
    boolean pageComplete = true;
    if (pageStatus == null || pageStatus.isOK()) {
      setErrorMessage(null);
      setMessage(null);
    } else if (pageStatus.getSeverity() == IStatus.ERROR) {
      if (pageStatus.getCode() == IStatus.INFO) {
        setErrorMessage(null);
        setMessage(pageStatus.getMessage(), INFORMATION);
      } else {
        setErrorMessage(pageStatus.getMessage());
      }
      pageComplete = false;
    } else if (pageStatus.getSeverity() == IStatus.WARNING) {
      setErrorMessage(null);
      setMessage(pageStatus.getMessage(), WARNING);
    } else if (pageStatus.getSeverity() == IStatus.INFO) {
      setErrorMessage(null);
      setMessage(pageStatus.getMessage(), INFORMATION);
    }
    setPageComplete(pageComplete);
  }

  private void validatePage(final IStatus status, final ValidationSource source) {
    setDirty(true);
    IStatus pageStatus = status;
    boolean validateObjects = false;

    if (source == ValidationSource.PROJECT) {
      if (!pageStatus.isOK()) {
        if (objects != null) {
          objects.clear();
        }
        objectsViewer.refresh();
      }
      if (selectObjectsButton != null) {
        selectObjectsButton.setEnabled(pageStatus.isOK());
      }
      // if project validation is successful continue with objects validation
      if (pageStatus.isOK()) {
        validateObjects = true;
      }
    } else if (source == ValidationSource.OBJECTS) {
      validateObjects = true;
    }
    if (validateObjects) {
      if (objects == null || objects.isEmpty()) {
        pageStatus = new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID, IStatus.INFO,
            Messages.TaggableObjectSelectionWizardPage_NoObjectSelectedWarning_xmsg, null);
      } else {
        pageStatus = Status.OK_STATUS;
      }
    }
    updatePageStatus(pageStatus);
  }

  class AdtObjectLabelProvider extends LabelProvider implements ILabelProvider,
      IStyledLabelProvider {

    @Override
    public Image getImage(final Object element) {
      final ObjectToBeTagged selectedObj = (ObjectToBeTagged) element;
      final IAdtObjectReference ref = selectedObj.getRef();
      return AdtTypeUtil.getInstance().getTypeImage(ref.getType());
    }

    @Override
    public StyledString getStyledText(final Object element) {
      final StyledString text = new StyledString();
      final ObjectToBeTagged objectToBeTagged = (ObjectToBeTagged) element;
      final IAdtObjectReference ref = objectToBeTagged.getRef();

      text.append(ref.getName());
      String typeLabel = AdtTypeUtil.getInstance().getTypeDescription(ref.getType());
      if (typeLabel == null) {
        typeLabel = AdtTypeUtil.getInstance()
            .getTypeDescriptionByProject(ref.getType(), getWizard().getProject());
      }
      if (typeLabel != null) {
        text.append(" (" + typeLabel + ")", StyledString.QUALIFIER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
      }

      return text;
    }

    @Override
    public String getText(final Object element) {
      final ObjectToBeTagged objectToBeTagged = (ObjectToBeTagged) element;
      final IAdtObjectReference ref = objectToBeTagged.getRef();
      return ref.getName();
    }
  }

  class ObjectToBeTagged {
    private final IAdtObjectReference ref;

    public ObjectToBeTagged(final IAdtObjectReference ref) {
      this.ref = ref;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj instanceof ObjectToBeTagged) {
        return ((ObjectToBeTagged) obj).ref.getUri().equals(ref.getUri());
      }
      return super.equals(obj);
    }

    /**
     * @return the ref
     */
    public IAdtObjectReference getRef() {
      return ref;
    }
  }
}
