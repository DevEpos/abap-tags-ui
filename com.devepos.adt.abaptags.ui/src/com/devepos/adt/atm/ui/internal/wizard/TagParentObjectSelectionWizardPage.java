package com.devepos.adt.atm.ui.internal.wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.ui.internal.ImageUtil;
import com.devepos.adt.atm.ui.internal.dialogs.ParentObjectFilterDialog;
import com.devepos.adt.atm.ui.internal.help.HelpContexts;
import com.devepos.adt.atm.ui.internal.help.HelpUtil;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.tree.TaggedObjectTreeContentProvider;
import com.devepos.adt.atm.ui.internal.util.TagParentCollector;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.base.ui.celleditor.ExtendedDialogCellEditor;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.ui.wizard.AbstractBaseWizardPage;

public class TagParentObjectSelectionWizardPage extends AbstractBaseWizardPage {
  public static final String PAGE_NAME = TagParentObjectSelectionWizardPage.class
      .getCanonicalName();
  private final List<IAdtObjectTag> adtObjectTags = new ArrayList<>();
  private Tree parentObjectSelectionTree;
  private TreeViewer treeViewer;

  private boolean multipleSelectionMode = true;

  public TagParentObjectSelectionWizardPage() {
    super(PAGE_NAME);
    setTitle(Messages.TagParentObjectSelectionWizardPage_Title_xtit);
    setDescription(Messages.TagParentObjectSelectionWizardPage_Description_xmsg);
  }

  /**
   * Label provider for a single column in this TreeViewer
   *
   * @author stockbal
   */
  static class ColumnLabelProvider extends CellLabelProvider implements
      DelegatingStyledCellLabelProvider.IStyledLabelProvider, ILabelProvider {

    private final Column column;

    public ColumnLabelProvider(final Column column) {
      this.column = column;
    }

    @Override
    public Image getImage(final Object element) {
      Image image = null;
      if (column == Column.OBJECT_NAME) {
        image = getObjectNameColImage(element);
      } else if (element instanceof IAdtObjectTag) {
        final IAdtObjectTag objectTag = (IAdtObjectTag) element;
        if (column == Column.PARENT_TAG) {
          return objectTag.getImage();
        }
        if (column == Column.PARENT_OBJECT) {
          image = getAdtObjectTypeImage(objectTag.getParentObjectType());
        }
      }
      return image;
    }

    @Override
    public StyledString getStyledText(final Object element) {
      final StyledString text = new StyledString();

      switch (column) {
      case OBJECT_NAME:
        setObjectNameText(element, text);
        break;
      case PARENT_OBJECT:
        if (element instanceof IAdtObjectTag) {
          final IAdtObjectTag objectTag = (IAdtObjectTag) element;
          final String parentObject = objectTag.getParentObjectName();
          if (parentObject != null && !parentObject.isEmpty()) {
            text.append(parentObject);
          } else {
            text.append(Messages.TagParentObjectSelectionWizardPage_ParentObjectAssignPrompt_xmsg,
                StyledString.QUALIFIER_STYLER);
          }
        }
        break;
      case PARENT_TAG:
        if (element instanceof IAdtObjectTag) {
          final IAdtObjectTag objectTag = (IAdtObjectTag) element;
          text.append(objectTag.getParentTagName());
        }
        break;
      }
      return text;
    }

    @Override
    public String getText(final Object element) {
      if (element instanceof IAdtObjectTag) {
        final IAdtObjectTag objectTag = (IAdtObjectTag) element;
        return objectTag.getParentObjectName();
      }
      return null;
    }

    @Override
    public void update(final ViewerCell cell) {
    }

    private Image getAdtObjectTypeImage(final String type) {
      if (type == null || type.isEmpty()) {
        return null;
      }
      return AdtTypeUtil.getInstance().getTypeImage(type);
    }

    private Image getObjectNameColImage(final Object element) {
      if (element instanceof ITaggedObject) {
        final ITaggedObject taggedObject = (ITaggedObject) element;
        final IAdtObjRef objRef = taggedObject.getObjectRef();
        return getAdtObjectTypeImage(objRef.getType());
      }
      if (element instanceof IAdtObjectTag) {
        return ((IAdtObjectTag) element).getImage();
      }
      return null;
    }

    private void setObjectNameText(final Object element, final StyledString text) {
      if (element instanceof ITaggedObject) {
        final ITaggedObject taggedObject = (ITaggedObject) element;
        text.append(taggedObject.getObjectRef().getName() == null ? "" //$NON-NLS-1$
            : taggedObject.getObjectRef().getName());
      } else if (element instanceof IAdtObjectTag) {
        final IAdtObjectTag objectTag = (IAdtObjectTag) element;
        text.append(objectTag.getName() == null ? "" : objectTag.getName()); //$NON-NLS-1$
      }
    }
  }

  private enum Column {
    OBJECT_NAME(280, Messages.TagParentObjectSelectionWizardPage_ObjectTagColumn_xlbl),
    PARENT_TAG(150, Messages.TagParentObjectSelectionWizardPage_ParentTagColumn_xlbl),
    PARENT_OBJECT(300, Messages.TagParentObjectSelectionWizardPage_ParentObject_xlbl);

    public final int defaultWidth;

    public final String tooltip;

    public final String headerText;

    Column(final int width, final String headerText) {
      this(width, headerText, headerText);
    }

    Column(final int width, final String headerText, final String tooltip) {
      defaultWidth = width;
      this.headerText = headerText;
      this.tooltip = tooltip;
    }
  }

  private class ParentObjectSelectionTreeEditingSupport extends EditingSupport {

    public ParentObjectSelectionTreeEditingSupport(final TreeViewer viewer) {
      super(viewer);
    }

    @Override
    public TreeViewer getViewer() {
      return (TreeViewer) super.getViewer();
    }

    @Override
    protected boolean canEdit(final Object element) {
      return element instanceof IAdtObjectTag;
    }

    @Override
    protected CellEditor getCellEditor(final Object element) {
      if (!(element instanceof IAdtObjectTag)) {
        return null;
      }
      return new ExtendedDialogCellEditor(getViewer().getTree()) {

        @Override
        protected Object openDialogBox(final Control cellEditorWindow) {
          final IProject project = getWizard().getProject();
          final String destinationId = DestinationUtil.getDestinationId(project);

          final IAdtObjectTag tag = (IAdtObjectTag) element;
          final ParentObjectFilterDialog filterDialog = new ParentObjectFilterDialog(getShell(),
              destinationId, tag.getPossibleParentTags());
          filterDialog.open();
          final ITaggedObject selectedObj = filterDialog.getFirstResult();
          if (selectedObj != null) {
            return selectedObj;
          }
          return null;
        }
      };
    }

    @Override
    protected Object getValue(final Object element) {
      if (element instanceof IAdtObjectTag) {
        return ((IAdtObjectTag) element).getParentObjectName();
      }
      return null;
    }

    @Override
    protected void setValue(final Object element, final Object value) {
      if (element instanceof IAdtObjectTag && value instanceof ITaggedObject) {
        final IAdtObjectTag objectTag = (IAdtObjectTag) element;
        final ITaggedObject taggedParentObject = (ITaggedObject) value;

        final IAdtObjRef parentObjRef = taggedParentObject.getObjectRef();
        objectTag.setParentObjectName(parentObjRef.getName());
        objectTag.setParentObjectType(parentObjRef.getType());
        objectTag.setParentObjectUri(parentObjRef.getUri());

        // check if tag also changed
        IAdtObjectTag newParentTag = taggedParentObject.getTags().get(0);
        objectTag.setParentTagId(newParentTag.getId());
        objectTag.setParentTagName(newParentTag.getName());

        getViewer().update(element, null);
      }
    }

  }

  @Override
  public void completePage() {
    if (multipleSelectionMode) {
      final Map<String, IAdtObjectTag> tagMap = adtObjectTags.stream()
          .collect(Collectors.toMap(IAdtObjectTag::getId, Function.identity()));

      for (final ITaggedObject taggedObj : getWizard().getTaggedObjectList().getTaggedObjects()) {
        for (final IAdtObjectTag tag : taggedObj.getTags()) {
          final IAdtObjectTag tagWithParentObject = tagMap.get(tag.getId());
          if (tagWithParentObject == null) {
            continue;
          }
          tag.setParentObjectName(tagWithParentObject.getParentObjectName());
          tag.setParentObjectType(tagWithParentObject.getParentObjectType());
          tag.setParentTagId(tagWithParentObject.getParentTagId());
          tag.setParentObjectUri(tagWithParentObject.getParentObjectUri());
        }
      }
    }
  }

  @Override
  public void createControl(final Composite parent) {
    final Composite root = new Composite(parent, SWT.NONE);
    HelpUtil.setHelp(root, HelpContexts.TAG_WIZARD_PARENT_OBJECT_SELECTION);
    GridLayoutFactory.swtDefaults().applyTo(root);

    createSelectionModeComposite(root);
    createParentObjectSelectionTree(root);
    hookContextMenu();
    setControl(root);

    setPageComplete(false);
  }

  @Override
  public ITagObjectsWizard getWizard() {
    return (ITagObjectsWizard) super.getWizard();
  }

  @Override
  public void setVisible(final boolean visible) {
    final boolean previousPageDirty = getWizard().isPreviousPageDirty(this);
    if (visible && (!isPageComplete() || previousPageDirty)) {
      getWizard().completePreviousPage(this);
      final List<ITag> selectedTags = getWizard().getSelectedTags();

      if (previousPageDirty) {
        // fill map of tag id to parent name
        adtObjectTags.clear();
        for (final ITag selectedTag : selectedTags) {
          final EObject parent = selectedTag.eContainer();
          if (parent instanceof ITag) {
            final ITag parentTag = (ITag) parent;

            final IAdtObjectTag objectTag = IAbapTagsFactory.eINSTANCE.createAdtObjectTag();
            objectTag.setId(selectedTag.getId());
            objectTag.setName(selectedTag.getName());
            objectTag.setOwner(selectedTag.getOwner());
            objectTag.setImage(ImageUtil.getImageForTag(parentTag, false));
            objectTag.setCorrectParentTag(parentTag);
            objectTag.setParentTagId(parentTag.getId());
            objectTag.setParentTagName(parentTag.getName());
            objectTag.getPossibleParentTags()
                .addAll(TagParentCollector.collectParentTagIds(parentTag));
            adtObjectTags.add(objectTag);
          }
        }
        updateTreeInput();
      }

    }
    super.setVisible(visible);
  }

  private TreeViewerColumn createColumn(final TreeViewer treeViewer, final Column column,
      final ColumnLabelProvider cellLabelProvider) {
    final TreeViewerColumn viewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
    viewerColumn.getColumn().setText(column.headerText);
    viewerColumn.getColumn().setToolTipText(column.tooltip);
    viewerColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(cellLabelProvider));
    viewerColumn.getColumn().setWidth(column.defaultWidth);
    viewerColumn.getColumn().setMoveable(false);
    return viewerColumn;
  }

  private void createParentObjectSelectionTree(final Composite root) {

    parentObjectSelectionTree = new Tree(root, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE
        | SWT.FULL_SELECTION);
    parentObjectSelectionTree.setHeaderVisible(true);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(parentObjectSelectionTree);
    treeViewer = new TreeViewer(parentObjectSelectionTree);
    treeViewer.setContentProvider(new TaggedObjectTreeContentProvider());

    for (final Column col : Column.values()) {
      final ColumnLabelProvider labelProvider = new ColumnLabelProvider(col);
      final TreeViewerColumn tvc = createColumn(treeViewer, col, labelProvider);
      if (col == Column.PARENT_OBJECT) {
        tvc.setEditingSupport(new ParentObjectSelectionTreeEditingSupport(treeViewer));
      }
    }
  }

  private void createSelectionModeComposite(final Composite root) {
    final Composite modeComposite = new Composite(root, SWT.NONE);
    GridLayoutFactory.swtDefaults().applyTo(modeComposite);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(modeComposite);

    final Button groupSelectionButton = new Button(modeComposite, SWT.RADIO);
    groupSelectionButton.setText(
        Messages.TagParentObjectSelectionWizardPage_MultipleSelectionMode_xrbl);
    groupSelectionButton.setSelection(true);
    groupSelectionButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        multipleSelectionMode = groupSelectionButton.getSelection();
        updateTreeInput();
      }
    });

    final Button singleSelectionButton = new Button(modeComposite, SWT.RADIO);
    singleSelectionButton.setText(
        Messages.TagParentObjectSelectionWizardPage_SingleSelectionMode_xrbl);
  }

  private void fillContextMenu(final IMenuManager menu) {
    // add action to remove current parent object assignment
    menu.add(ActionFactory.createAction(
        Messages.TagParentObjectSelectionWizardPage_removeParentObjAction_xmit, null, () -> {
          IStructuredSelection sel = treeViewer.getStructuredSelection();
          if (sel == null || sel.isEmpty()) {
            return;
          }
          for (Object selItem : sel) {
            if (selItem instanceof IAdtObjectTag) {
              IAdtObjectTag objectTag = (IAdtObjectTag) selItem;
              resetParentTag(objectTag);
            } else if (selItem instanceof ITaggedObject) {
              ITaggedObject taggedObject = (ITaggedObject) selItem;
              // clear all objects of the contained tags
              for (IAdtObjectTag objectTag : taggedObject.getTags()) {
                resetParentTag(objectTag);
              }
            }
          }
          treeViewer.refresh();
        }));
  }

  private void hookContextMenu() {
    final MenuManager menuMgr = new MenuManager();
    menuMgr.setRemoveAllWhenShown(true);

    menuMgr.addMenuListener(menu -> {
      fillContextMenu(menu);
    });
    final Control viewerControl = parentObjectSelectionTree;
    final Menu menu = menuMgr.createContextMenu(viewerControl);
    viewerControl.setMenu(menu);
  }

  private void resetParentTag(final IAdtObjectTag objectTag) {
    objectTag.setParentObjectUri(null);
    objectTag.setParentObjectType(null);
    objectTag.setParentObjectName(null);
    objectTag.setParentTagId(objectTag.getCorrectParentTag().getId());
    objectTag.setParentTagName(objectTag.getCorrectParentTag().getName());
  }

  private void updateTreeInput() {
    if (multipleSelectionMode) {
      treeViewer.setInput(adtObjectTags);
    } else {
      treeViewer.setInput(getWizard().getTaggedObjectList());
    }
    treeViewer.refresh();
    treeViewer.expandAll();
  }

}
