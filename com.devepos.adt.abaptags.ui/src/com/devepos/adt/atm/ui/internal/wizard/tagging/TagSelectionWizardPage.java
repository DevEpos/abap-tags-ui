package com.devepos.adt.atm.ui.internal.wizard.tagging;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.PatternFilter;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.model.validation.TagListValidator;
import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.tagging.IAdtObjTaggingService;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.ImageUtil;
import com.devepos.adt.atm.ui.internal.help.HelpContexts;
import com.devepos.adt.atm.ui.internal.help.HelpUtil;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.preferences.IObjectTaggingPrefs;
import com.devepos.adt.atm.ui.internal.tree.TagFilter;
import com.devepos.adt.atm.ui.internal.tree.TagLabelProvider;
import com.devepos.adt.atm.ui.internal.tree.TagTreeContentProvider;
import com.devepos.adt.atm.ui.internal.util.TagParentCollector;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.event.KeyEventUtil;
import com.devepos.adt.base.ui.wizard.AbstractBaseWizardPage;
import com.devepos.adt.base.util.StringUtil;

public class TagSelectionWizardPage extends AbstractBaseWizardPage {
  public static final String PAGE_NAME = TaggableObjectSelectionWizardPage.class.getCanonicalName();

  private final Set<ITag> checkedTags = new HashSet<>();
  private final Set<ITag> preCheckedTags = new HashSet<>();
  private final Set<ITag> uncheckableTags = new HashSet<>();
  private final List<ITag> newTags = new ArrayList<>();
  private boolean isParentObjectSelectionPossible;
  private int objectCount;
  private String owner;

  private final PatternFilter patternFilter;
  private TreeViewerLabelProvider treeLabelProvider;
  private TagTreeContentProvider treeContentProvider;

  private Tree tagsTree;
  private CheckboxTreeViewer checkBoxViewer;
  private Text filterText;
  private ToolItem removeTagButton;
  private Combo tagTypeCombo;
  private ToolBar treeToolbar;
  private Label selectionInfo;
  private ToolItem deselectAll;

  public TagSelectionWizardPage() {
    super(PAGE_NAME);
    setTitle(Messages.TagSelectionWizardPage_Title_xtit);
    patternFilter = new TagFilter();
    patternFilter.setIncludeLeadingWildcard(true);
  }

  private class TextEditingSupport extends EditingSupport {

    public TextEditingSupport(final ColumnViewer viewer) {
      super(viewer);
    }

    @Override
    public CheckboxTreeViewer getViewer() {
      return (CheckboxTreeViewer) super.getViewer();
    }

    @Override
    protected boolean canEdit(final Object element) {
      return StringUtil.isEmpty(((ITag) element).getId());
    }

    @Override
    protected CellEditor getCellEditor(final Object element) {
      return new TextCellEditor(getViewer().getTree());
    }

    @Override
    protected Object getValue(final Object element) {
      return ((ITag) element).getName();
    }

    @Override
    protected void setValue(final Object element, final Object value) {
      ((ITag) element).setName((String) value);
      getViewer().update(element, null);
      validatePage();
    }

  }

  private class TreeViewerLabelProvider extends TagLabelProvider {
    public TreeViewerLabelProvider() {
      super(false, false);
    }

    @Override
    protected void appendCounterText(final ITag tag, final StyledString text) {
      if (!StringUtil.isEmpty(tag.getId()) && objectCount > 1) {
        // CHECK: Could look strange if objects have multiple parents (e.g. 4 of 2)
        text.append(" (" + tag.getTaggedObjectCount() + " of " + objectCount + ")", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            StyledString.COUNTER_STYLER);
      }
    }

    @Override
    protected void appendTagName(final ITag tag, final StyledString text) {
      if (!StringUtil.isEmpty(tag.getId())) {
        /*
         * hierarchical tags can be assigned multiple times, so a tagged object count > objectCount
         * does not always mean that all selected objects are tagged
         * CHECK: should an entry be made bold only if a single object is selected for tagging
         */
        if (tag.getTaggedObjectCount() >= objectCount) {
          text.append(tag.getName(), StylerFactory.BOLD_STYLER);
        } else {
          text.append(tag.getName());
        }
      } else {
        text.append(tag.getName(), StylerFactory.ITALIC_STYLER);
        text.append(" **", StylerFactory.BOLD_STYLER); //$NON-NLS-1$
      }
    }

  }

  @Override
  public boolean canFlipToNextPage() {
    return isPageComplete() && StringUtil.isEmpty(getErrorMessage())
        && isParentObjectSelectionPossible;
  }

  @Override
  public void completePage() {
    if (!isDirty()) {
      return;
    }
    var wizard = getWizard();
    wizard.getSelectedTags().clear();
    wizard.getSelectedTags().addAll(checkedTags);
    wizard.getTaggedObjectList().getTaggedObjects().clear();

    final List<IAdtObjRef> objectsToBeTagged = wizard.getCurrentTagPreviewInfo().getAdtObjectRefs();
    for (final IAdtObjRef adtObjRef : objectsToBeTagged) {
      final ITaggedObject taggedObject = IAbapTagsFactory.eINSTANCE.createTaggedObject();
      final IAdtObjRef objRefNew = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
      objRefNew.setUri(adtObjRef.getUri());
      objRefNew.setName(adtObjRef.getName());
      objRefNew.setType(adtObjRef.getType());
      objRefNew.setParentName(adtObjRef.getParentName());
      taggedObject.setObjectRef(objRefNew);
      for (final ITag selectedTag : checkedTags) {
        final IAdtObjectTag objectTag = IAbapTagsFactory.eINSTANCE.createAdtObjectTag();
        objectTag.setId(selectedTag.getId());
        objectTag.setName(selectedTag.getName());
        objectTag.setOwner(selectedTag.getOwner());
        objectTag.setImage(ImageUtil.getImageForTag(selectedTag, false));
        final EObject parent = selectedTag.eContainer();
        if (parent instanceof ITag) {
          ITag parentTag = (ITag) parent;
          objectTag.setParentTagId(parentTag.getId());
          objectTag.setParentTagName(parentTag.getName());
          objectTag.getPossibleParentTags()
              .addAll(TagParentCollector.collectParentTagIds(parentTag));
          objectTag.setCorrectParentTag(parentTag);
        }
        taggedObject.getTags().add(objectTag);
      }
      wizard.getTaggedObjectList().getTaggedObjects().add(taggedObject);
    }
    setDirty(false);
  }

  @Override
  public void createControl(final Composite parent) {
    final Composite root = new Composite(parent, SWT.NONE);
    HelpUtil.setHelp(root, HelpContexts.TAG_WIZARD_TAG_SELECTION);
    GridLayoutFactory.swtDefaults().applyTo(root);

    createTreeHeaderArea(root);
    createTagsCheckBoxTree(root);
    createSelectionInfo(root);
    setControl(root);
    setPageComplete(false);
  }

  @Override
  public TagObjectsWizard getWizard() {
    return (TagObjectsWizard) super.getWizard();
  }

  @Override
  public boolean isPageComplete() {
    return getErrorMessage() == null && !checkedTags.isEmpty();
  }

  @Override
  public void setVisible(final boolean visible) {
    final boolean previousPageIsDirty = getWizard().isPreviousPageDirty(this);
    if (visible && (!isPageComplete() || previousPageIsDirty)) {
      if (previousPageIsDirty) {
        clearCheckedTags();
        owner = null;
        newTags.clear();
        isParentObjectSelectionPossible = false;
        getWizard().setCanFinish(false);
      }
      getWizard().completePreviousPage(this);

      if (!getWizard().getCurrentTagPreviewInfo().getTags().isEmpty()) {
        fillTagsFromPreviewInfo();
      } else if (getWizard().getCurrentTagPreviewInfo().getTags().isEmpty() && !getWizard()
          .getSelectedObjects()
          .getObjectReferences()
          .isEmpty()) {
        loadTagPreviewInfo();
      }
    } else {
      validatePage();
    }
    super.setVisible(visible);
  }

  private void addTag(final boolean userTag) {
    resetAllFilters();
    final var newTag = IAbapTagsFactory.eINSTANCE.createTag();
    newTag.setName(Messages.TagSelectionWizardPage_NewTagDefaultName_xmsg);
    if (userTag) {
      newTag.setOwner(getDestinationOwner());
    }
    getWizard().getCurrentTagPreviewInfo().getTags().add(newTag);
    newTags.add(newTag);
    checkBoxViewer.refresh();
    checkBoxViewer.setChecked(newTag, true);
    checkedTags.add(newTag);
    checkBoxViewer.setSelection(new StructuredSelection(newTag));
    checkBoxViewer.editElement(newTag, 0);
    setMessage(null);
  }

  private void clearCheckedTags() {
    checkedTags.clear();
    preCheckedTags.clear();
  }

  private void createFilterText(final Composite parent) {
    filterText = new Text(parent, SWT.SINGLE | SWT.BORDER | SWT.SEARCH | SWT.ICON_CANCEL);
    GridDataFactory.fillDefaults().grab(true, false).hint(200, SWT.DEFAULT).applyTo(filterText);
    filterText.setMessage(Messages.TagSelectionWizardPage_TagFilterPrompt_xmsg);

    filterText.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {
        // on a CR we want to transfer focus to the list
        final boolean hasItems = tagsTree.getItemCount() > 0;
        if (hasItems && e.keyCode == SWT.ARROW_DOWN) {
          tagsTree.setFocus();
        } else if (e.character == SWT.CR) {
        } else if (KeyEventUtil.isDefaultFindKeyStroke(e)) {
          filterText.setFocus();
        }
      }
    });
    filterText.addModifyListener(e -> {
      patternFilter.setPattern(filterText.getText());

      Display.getDefault().timerExec(500, (Runnable) () -> {
        checkBoxViewer.expandAll();
        tagsTree.showSelection();
      });
      checkBoxViewer.refresh();
      setCheckedElements();
    });

  }

  private void createSelectionInfo(final Composite parent) {
    selectionInfo = new Label(parent, SWT.NONE);
    GridDataFactory.fillDefaults().applyTo(selectionInfo);
  }

  private void createTagsCheckBoxTree(final Composite parent) {
    checkBoxViewer = new CheckboxTreeViewer(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
    tagsTree = checkBoxViewer.getTree();
    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.FILL)
        .grab(true, true)
        .minSize(250, 300)
        .hint(SWT.DEFAULT, tagsTree.getItemHeight() * 20)
        .applyTo(tagsTree);
    checkBoxViewer.addFilter(patternFilter);
    treeLabelProvider = new TreeViewerLabelProvider();
    treeContentProvider = new TagTreeContentProvider();
    checkBoxViewer.setContentProvider(treeContentProvider);

    final var nameColumn = new TreeViewerColumn(checkBoxViewer, SWT.FULL_SELECTION, SWT.NONE);
    nameColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(treeLabelProvider));
    nameColumn.setEditingSupport(new TextEditingSupport(checkBoxViewer));
    nameColumn.getColumn().setWidth(400);

    checkBoxViewer.addCheckStateListener(event -> {
      setMessage(null);
      final ITag tag = (ITag) event.getElement();
      if (!event.getChecked() && uncheckableTags.contains(tag)) {
        event.getCheckable().setChecked(tag, true);
        setMessage(NLS.bind(Messages.TagSelectionWizardPage_TagSelectionNotReversable_xmsg, tag
            .getName()), INFORMATION);
        return;
      }
      if (event.getChecked()) {
        checkedTags.add((ITag) event.getElement());
      } else {
        checkedTags.remove(event.getElement());
      }
      deselectAll.setEnabled(!checkedTags.isEmpty());
      setDirty(true);
      validatePage();
    });
    tagsTree.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {
        if (e.keyCode == SWT.CR) {
          final IStructuredSelection sel = checkBoxViewer.getStructuredSelection();
          if (sel.isEmpty()) {
            return;
          }
          final ITag selectedTag = (ITag) sel.getFirstElement();
          if (StringUtil.isEmpty(selectedTag.getId())) {
            checkBoxViewer.editElement(selectedTag, 0);
          }
        } else if (KeyEventUtil.isDefaultFindKeyStroke(e)) {
          filterText.setFocus();
        }
      }
    });

    checkBoxViewer.addSelectionChangedListener(e -> {
      updateRemoveTagEnabled();
    });
  }

  private void createTagScopeCombo(final Composite parent) {
    final var tagScopeContainer = new Composite(parent, SWT.NONE);
    GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).applyTo(tagScopeContainer);
    final var tagScopeLabel = new Label(tagScopeContainer, SWT.NONE);
    tagScopeLabel.setText(Messages.TagSelectionWizardPage_TagScope_xlbl);
    tagTypeCombo = new Combo(tagScopeContainer, SWT.READ_ONLY);
    tagTypeCombo.setItems(Stream.of(TagSearchScope.values()).map(scope -> {
      switch (scope) {
      case ALL:
        return Messages.TagSelectionWizardPage_TagScopeAll_xlbl;
      case GLOBAL:
        return Messages.TagSelectionWizardPage_TagScopeGlobal_xlbl;
      case USER:
        return Messages.TagSelectionWizardPage_TagScopeUser_xlbl;
      case SHARED:
        return Messages.TagSelectionWizardPage_TagScopeShared_xlbl;
      default:
        return ""; //$NON-NLS-1$
      }
    }).toArray(String[]::new));
    tagTypeCombo.select(0);
    tagTypeCombo.addModifyListener(e -> {
      var selectedScope = tagTypeCombo.getItem(tagTypeCombo.getSelectionIndex());
      treeContentProvider.setVisbleTagScope(TagSearchScope.getByName(selectedScope.toUpperCase()));
      checkBoxViewer.refresh();
      setCheckedElements();
    });
  }

  private void createTreeHeaderArea(Composite parent) {
    var headerArea = new Composite(parent, SWT.NONE);
    GridLayoutFactory.swtDefaults().margins(0, 0).numColumns(3).applyTo(headerArea);
    GridDataFactory.fillDefaults().applyTo(headerArea);

    createFilterText(headerArea);
    createTagScopeCombo(headerArea);
    createTreeToolbar(headerArea);
  }

  private void createTreeToolbar(final Composite parent) {
    treeToolbar = new ToolBar(parent, SWT.FLAT | SWT.HORIZONTAL);
    GridDataFactory.fillDefaults().align(SWT.END, SWT.END).applyTo(treeToolbar);

    new ToolItem(treeToolbar, SWT.SEPARATOR);

    final var expandAll = new ToolItem(treeToolbar, SWT.PUSH);
    expandAll.setToolTipText(Messages.TagSelectionWizardPage_ExpandAll_xbut);
    expandAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.EXPAND_ALL));
    expandAll.addSelectionListener(widgetSelectedAdapter(l -> {
      checkBoxViewer.expandAll();
    }));

    final var collapseAll = new ToolItem(treeToolbar, SWT.PUSH);
    collapseAll.setToolTipText(Messages.TagSelectionWizardPage_CollapseAll_xbut);
    collapseAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.COLLAPSE_ALL));
    collapseAll.addSelectionListener(widgetSelectedAdapter(l -> checkBoxViewer.collapseAll()));

    new ToolItem(treeToolbar, SWT.SEPARATOR);

    deselectAll = new ToolItem(treeToolbar, SWT.PUSH);
    deselectAll.setEnabled(false);
    deselectAll.setToolTipText(AdtBaseUIResources.getString(IAdtBaseStrings.DeselectAll_xlbl));
    deselectAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.UNCHECK_ALL));
    deselectAll.addSelectionListener(widgetSelectedAdapter(l -> uncheckAllTags()));

    new ToolItem(treeToolbar, SWT.SEPARATOR);

    final var addTag = new ToolItem(treeToolbar, SWT.PUSH);
    addTag.setToolTipText(Messages.TagSelectionWizardPage_AddGlobalTag_xbut);
    addTag.setImage(AbapTagsUIPlugin.getDefault().getImage(IImages.NEW_GLOBAL_TAG));
    addTag.addSelectionListener(widgetSelectedAdapter(l -> addTag(false)));

    final var addUserTag = new ToolItem(treeToolbar, SWT.PUSH);
    addUserTag.setToolTipText(Messages.TagSelectionWizardPage_AddUserTag_xbut);
    addUserTag.setImage(AbapTagsUIPlugin.getDefault().getImage(IImages.NEW_USER_TAG));
    addUserTag.addSelectionListener(widgetSelectedAdapter(l -> addTag(true)));

    new ToolItem(treeToolbar, SWT.SEPARATOR);

    removeTagButton = new ToolItem(treeToolbar, SWT.PUSH);
    removeTagButton.setToolTipText(Messages.TagSelectionWizardPage_RemoveTag_xbut);
    removeTagButton.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.DELETE_ROW));
    removeTagButton.addSelectionListener(widgetSelectedAdapter(l -> removeTag()));
    removeTagButton.setEnabled(false);
  }

  private void determinePreCheckedTags(final EList<ITag> tags) {
    for (final var tag : tags) {
      if (tag.getTaggedObjectCount() > 0) {
        if (!StringUtil.isEmpty(tag.getParentTagId())) {
          continue;
        }
        preCheckedTags.add(tag);
        if (tag.getTaggedObjectCount() == objectCount) {
          uncheckableTags.add(tag);
        }
      }
      determinePreCheckedTags(tag.getChildTags());
    }
  }

  private void fillTagsFromPreviewInfo() {
    final var previewInfo = getWizard().getCurrentTagPreviewInfo();
    if (previewInfo != null) {
      objectCount = previewInfo.getAdtObjectRefs().size();
      if (objectCount > 1) {
        ((Wizard) getWizard()).setWindowTitle(NLS.bind(
            Messages.TagObjectsWizard_MultipleObjectsWizardTitle_xtit, objectCount));
      } else {
        ((Wizard) getWizard()).setWindowTitle(Messages.TagObjectsWizard_SingleObjectWizardTitle_xtit
            + previewInfo.getAdtObjectRefs().get(0).getName());
      }
      determinePreCheckedTags(previewInfo.getTags());
      checkBoxViewer.setInput(previewInfo.getTags());
      if (AbapTagsUIPlugin.getDefault()
          .getPreferenceStore()
          .getBoolean(IObjectTaggingPrefs.AUTO_EXPAND_TAGS)) {
        checkBoxViewer.expandAll();
      }
      setCheckedElements();
      validatePage();
    }
  }

  private String getDestinationOwner() {
    if (owner == null) {
      final String destinationId = DestinationUtil.getDestinationId(getWizard().getProject());
      owner = DestinationUtil.getDestinationData(destinationId).getUser();
    }
    return owner;
  }

  private void loadTagPreviewInfo() {
    final var project = getWizard().getProject();
    if (project == null) {
      return;
    }
    final String destinationId = DestinationUtil.getDestinationId(project);
    try {
      getContainer().run(true, false, monitor -> {
        monitor.beginTask(Messages.TagPreviewLoadingJob_JobTitle_xmsg, -1);
        final IAdtObjTaggingService taggingService = AdtObjTaggingServiceFactory
            .createTaggingService();

        // read current tags from project
        try {
          final var previewInfo = taggingService.getInformationForTagging(destinationId, getWizard()
              .getSelectedObjects());
          Display.getDefault().asyncExec(() -> {
            if (previewInfo == null || previewInfo.getTags().size() == 0) {
              setMessage(Messages.TaggingObjectWizard_NoTagsAvailableMessage_xmsg, INFORMATION);
              setPageComplete(false);
            }
            getWizard().setCurrentTagPreviewInfo(previewInfo);
            fillTagsFromPreviewInfo();
          });
        } catch (final CoreException e) {
          Display.getDefault().asyncExec(() -> {
            setErrorMessage(e.getMessage());
          });
        }
      });
    } catch (final InvocationTargetException e) {
      if (e.getTargetException() instanceof RuntimeException) {
        throw (RuntimeException) e.getTargetException();
      }
    } catch (final InterruptedException e) {

    }

  }

  private void removeTag() {
    final var sel = (IStructuredSelection) checkBoxViewer.getSelection();
    final ITag selectedTag = (ITag) sel.getFirstElement();
    getWizard().getCurrentTagPreviewInfo().getTags().remove(selectedTag);
    newTags.remove(selectedTag);
    checkedTags.remove(selectedTag);
    checkBoxViewer.refresh();
    validatePage();
  }

  private void resetAllFilters() {
    if (!StringUtil.isEmpty(filterText.getText())) {
      filterText.setText(""); //$NON-NLS-1$
    }
    tagTypeCombo.select(0);
    checkBoxViewer.refresh();
  }

  private void setCheckedElements() {
    for (final Object checkedItem : checkedTags) {
      checkBoxViewer.setChecked(checkedItem, true);
    }
    for (final Object checkedItem : uncheckableTags) {
      checkBoxViewer.setChecked(checkedItem, true);
    }
  }

  private void uncheckAllTags() {
    for (var tag : checkedTags) {
      checkBoxViewer.setChecked(tag, false);
    }
    checkedTags.clear();
    deselectAll.setEnabled(false);
    validatePage();
  }

  private void updateCheckedLabel() {
    if (selectionInfo == null) {
      return;
    }
    var checkedCount = checkedTags.size();

    selectionInfo.setText(String.format(Messages.TagSelectionWizardPage_TagSelectionFormat_xmsg,
        checkedCount == 0 ? Messages.General_No_xlbl : String.valueOf(checkedCount),
        checkedCount == 1 ? "" : "s", Messages.DeleteTagsWizardPage_Selected_xlbl));
  }

  private void updateRemoveTagEnabled() {
    boolean removeEnabled = false;
    final IStructuredSelection sel = (IStructuredSelection) TagSelectionWizardPage.this.checkBoxViewer
        .getSelection();
    if (sel != null && !sel.isEmpty()) {
      final ITag selectedTag = (ITag) sel.getFirstElement();
      removeEnabled = StringUtil.isEmpty(selectedTag.getId());
    }
    TagSelectionWizardPage.this.removeTagButton.setEnabled(removeEnabled);
  }

  @SuppressWarnings("unchecked")
  private void validatePage() {
    IStatus pageStatus = null;
    if (!newTags.isEmpty()) {
      pageStatus = new TagListValidator((List<ITag>) checkBoxViewer.getInput()).validate(true,
          false);
    }
    isParentObjectSelectionPossible = false;
    if (pageStatus == null || pageStatus.isOK()) {
      if (checkedTags.isEmpty()) {
        pageStatus = new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID, IStatus.INFO,
            Messages.TagSelectionWizardPage_NoTagsSelectedInfo_xmsg, null);
      } else {
        pageStatus = Status.OK_STATUS;
        for (final ITag tag : checkedTags) {
          final EObject parent = tag.eContainer();
          if (parent instanceof ITag) {
            isParentObjectSelectionPossible = true;
            break;
          }
        }
      }
    }
    updatePageCompletedStatus(pageStatus);
    updateCheckedLabel();
    getWizard().setCanFinish(isPageComplete());
    getContainer().updateButtons();
  }
}
