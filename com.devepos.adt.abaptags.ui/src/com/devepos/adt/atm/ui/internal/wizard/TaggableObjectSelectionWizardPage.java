package com.devepos.adt.atm.ui.internal.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.DataBindingContext;
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
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.tools.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.tools.base.project.ProjectUtil;
import com.devepos.adt.tools.base.ui.project.ProjectInput;
import com.devepos.adt.tools.base.util.AdtTypeUtil;
import com.devepos.adt.tools.base.wizard.AbstractBaseWizardPage;
import com.sap.adt.ris.search.ui.AdtRepositorySearchServiceUIFactory;
import com.sap.adt.ris.search.ui.IAdtRepositorySearchServiceUIParameters;
import com.sap.adt.ris.search.ui.IAdtRepositorySearchServiceUIResult;
import com.sap.adt.ris.search.ui.internal.preferences.SearchPreferences;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Wizard page for selecting the objects that should be tagged
 *
 * @author stockbal
 */
public class TaggableObjectSelectionWizardPage extends AbstractBaseWizardPage {
	public static final String PAGE_NAME = TaggableObjectSelectionWizardPage.class.getCanonicalName();
	private final ProjectInput projectInput;
	private final List<ObjectToBeTagged> objects = new ArrayList<>();
	private final DataBindingContext dbc;
	private TableViewer objectsViewer;
	private AggregateValidationStatus projectAggrValStatus;
	private Button removeObjectsButton;
	private Button selectObjectsButton;

	private enum ValidationSource {
		PROJECT,
		OBJECTS
	}

	public TaggableObjectSelectionWizardPage() {
		super(PAGE_NAME);
		setTitle(Messages.TaggableObjectSelectionWizardPage_Title_xtit);
		setDescription(Messages.TaggableObjectSelectionWizardPage_Description_xmsg);
		this.projectInput = new ProjectInput();
		this.dbc = new DataBindingContext();
	}

	@Override
	public ITagObjectsWizard getWizard() {
		return (ITagObjectsWizard) super.getWizard();
	}

	@Override
	public void createControl(final Composite parent) {
		final Composite root = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().applyTo(root);
		this.projectInput.createControl(root);
		this.projectInput.getProjectProvider().setProject(getWizard().getProject());
		createObjectsList(root);
		this.objectsViewer.setInput(this.objects);

		this.projectInput.addProjectValidator((project) -> {
			final IStatus loggedOnStatus = ProjectUtil.ensureLoggedOnToProject(project);
			if (!loggedOnStatus.isOK()) {
				return loggedOnStatus;
			}
			return AbapTagsServiceFactory.createTagsService().testTagsFeatureAvailability(project);
		});
		createBindings(parent);
		setControl(root);

		setPageComplete(false);
	}

	@Override
	public void setVisible(final boolean visible) {
		if (visible && !isPageComplete()) {
			getWizard().completePreviousPage(this);
		}
		super.setVisible(visible);
	}

	@Override
	public void completePage() {
		// clear any available tag preview information, as it has to be reloaded
		getWizard().setCurrentTagPreviewInfo(null);
		final List<IAdtObjRef> adtObjRefList = getWizard().getSelectedObjects().getObjectReferences();
		adtObjRefList.clear();
		for (final ObjectToBeTagged objToBeTagged : this.objects) {
			final IAdtObjectReference objRef = objToBeTagged.getRef();
			final IAdtObjRef adtObjRef = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
			adtObjRef.setUri(objRef.getUri());
			adtObjRefList.add(adtObjRef);
		}
		setDirty(false);
	}

	private void createObjectsList(final Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(container);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(container);

		final Label objectsViewerLabel = new Label(container, SWT.NONE);
		objectsViewerLabel.setText(Messages.TaggableObjectSelectionWizardPage_SelectedObjectsTableTitle_xtit);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).span(2, 1).grab(true, false).applyTo(objectsViewerLabel);

		this.objectsViewer = new TableViewer(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.VIRTUAL);
		this.objectsViewer.setContentProvider(new ArrayContentProvider());
		this.objectsViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new AdtObjectLabelProvider()));

		GridDataFactory.fillDefaults()
			.align(SWT.FILL, SWT.FILL)
			.grab(true, true)
			.minSize(250, 300)
			.applyTo(this.objectsViewer.getControl());

		final Composite buttonComposite = new Composite(container, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(1).margins(0, 0).extendedMargins(2, 2, 0, 2).applyTo(buttonComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(false, true).applyTo(buttonComposite);

		this.selectObjectsButton = new Button(buttonComposite, SWT.PUSH);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(this.selectObjectsButton);
		this.selectObjectsButton.setText(Messages.TaggableObjectSelectionWizardPage_SelectObjects_xbut);
		this.selectObjectsButton.setEnabled(getWizard().getProject() != null);
		this.selectObjectsButton.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("restriction")
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final IAdtRepositorySearchServiceUIParameters parameters = AdtRepositorySearchServiceUIFactory
					.createAdtRepositorySearchServiceUIParameters();
				parameters.setTitle(Messages.TaggableObjectSelectionWizardPage_SelectObjectsDialogTitle_xtit);
				parameters.setFixedProject(getWizard().getProject());
				parameters.setDescriptionVisible(true);
				parameters.setSearchPreferences(new SearchPreferences());
				final IAdtRepositorySearchServiceUIResult result = AdtRepositorySearchServiceUIFactory
					.createAdtRepositorySearchServiceUI()
					.openDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), parameters);

				if (result == null) {
					return;
				}

				for (final IAdtObjectReference ref : result.getAllSelectedObjectReferences()) {
					TaggableObjectSelectionWizardPage.this.objects.add(new ObjectToBeTagged(ref));
				}
				TaggableObjectSelectionWizardPage.this.objectsViewer.refresh();
				validatePage(null, ValidationSource.OBJECTS);
			}
		});

		this.removeObjectsButton = new Button(buttonComposite, SWT.PUSH);
		this.removeObjectsButton.setText(Messages.TaggableObjectSelectionWizardPage_RemoveSelected_xbut);
		this.removeObjectsButton.setEnabled(false);
		this.removeObjectsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				removeSelectedObjects();
				validatePage(null, ValidationSource.OBJECTS);
			}
		});
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(this.removeObjectsButton);
	}

	private void createBindings(final Composite parent) {
		final DataBindingContext projectContext = this.projectInput.createBindings();

		/*
		 * create aggregation status to collect max severity status and do some further
		 * validation for the page
		 */
		this.projectAggrValStatus = new AggregateValidationStatus(projectContext, AggregateValidationStatus.MAX_SEVERITY);
		this.projectAggrValStatus.addValueChangeListener(e -> {
			if (this.projectAggrValStatus.getValue().isOK()) {
				final IProject newProject = this.projectInput.getProjectProvider().getProject();
				final IProject oldProject = getWizard().getProject();
				if (newProject != oldProject) {
					this.objects.clear();
					this.objectsViewer.refresh();
					getWizard().setProject(newProject);
				}
			}
			validatePage(this.projectAggrValStatus.getValue(), ValidationSource.PROJECT);

		});
		parent.addDisposeListener(e -> {
			this.projectAggrValStatus.dispose();
			this.dbc.dispose();
		});

		this.objectsViewer.addSelectionChangedListener(e -> {
			final ISelection sel = e.getSelection();
			this.removeObjectsButton.setEnabled(sel != null && !sel.isEmpty());
		});

	}

	private void validatePage(final IStatus status, final ValidationSource source) {
		setDirty(true);
		IStatus pageStatus = status;
		boolean validateObjects = false;

		if (source == ValidationSource.PROJECT) {
			if (!pageStatus.isOK()) {
				if (this.objects != null) {
					this.objects.clear();
				}
				this.objectsViewer.refresh();
			}
			this.selectObjectsButton.setEnabled(pageStatus.isOK());
			// if project validation is successful continue with objects validation
			if (pageStatus.isOK()) {
				validateObjects = true;
			}
		} else if (source == ValidationSource.OBJECTS) {
			validateObjects = true;
		}
		if (validateObjects) {
			if (this.objects == null || this.objects.isEmpty()) {
				pageStatus = new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID, IStatus.INFO,
					Messages.TaggableObjectSelectionWizardPage_NoObjectSelectedWarning_xmsg, null);
			} else {
				pageStatus = Status.OK_STATUS;
			}
		}
		updatePageStatus(pageStatus);
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

	private void removeSelectedObjects() {
		final IStructuredSelection sel = (IStructuredSelection) this.objectsViewer.getSelection();
		if (sel.isEmpty()) {
			return;
		}

		for (final Object selObject : sel) {
			this.objects.remove(selObject);
		}
		this.objectsViewer.refresh();
	}

	class AdtObjectLabelProvider extends LabelProvider implements ILabelProvider, IStyledLabelProvider {

		@Override
		public String getText(final Object element) {
			final ObjectToBeTagged objectToBeTagged = (ObjectToBeTagged) element;
			final IAdtObjectReference ref = objectToBeTagged.getRef();
			return ref.getName();
		}

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
				typeLabel = AdtTypeUtil.getInstance().getTypeDescriptionByProject(ref.getType(), getWizard().getProject());
			}
			if (typeLabel != null) {
				text.append(" (" + typeLabel + ")", StyledString.QUALIFIER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
			}

			return text;
		}
	}

	class ObjectToBeTagged {
		private final IAdtObjectReference ref;

		public ObjectToBeTagged(final IAdtObjectReference ref) {
			this.ref = ref;
		}

		/**
		 * @return the ref
		 */
		public IAdtObjectReference getRef() {
			return this.ref;
		}

		@Override
		public boolean equals(final Object obj) {
			if (obj != null && obj instanceof ObjectToBeTagged) {
				return ((ObjectToBeTagged) obj).ref.getUri().equals(this.ref.getUri());
			}
			return super.equals(obj);
		}
	}
}
