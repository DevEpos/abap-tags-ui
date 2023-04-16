package com.devepos.adt.atm.ui.internal.wizard.taggedobjectsdeletion;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.tagging.IAdtObjTaggingService;
import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.tags.IAbapTagsService;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.help.HelpContexts;
import com.devepos.adt.atm.ui.internal.help.HelpUtil;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.tree.TagLabelProvider;
import com.devepos.adt.atm.ui.internal.tree.TagSelectionTree;
import com.devepos.adt.atm.ui.internal.tree.TagTreeContentProvider;
import com.devepos.adt.atm.ui.internal.wizard.tagging.TaggableObjectSelectionWizardPage;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.base.ui.project.ProjectInput;
import com.devepos.adt.base.ui.wizard.AbstractBaseWizardPage;

public class TagSelectionWizardPage extends AbstractBaseWizardPage {
  public static final String PAGE_NAME = TaggableObjectSelectionWizardPage.class.getCanonicalName();

  private Job tagLoadingJob;

  private final IAbapTagsService tagsService;
  private final IAdtObjTaggingService taggingService;
  private ProjectInput projectInput;
  private boolean projectInvalid;

  private TagSelectionTree tagSelectionTree;
  private Combo tagTypeCombo;
  private ToolBar toolBar;
  private Label selectionInfo;

  private Action selectSubTreeAction;

  private TagTreeContentProvider treeContentProvider;
  private TreeViewerLabelProvider treeLabelProvider;

  protected TagSelectionWizardPage() {
    super(PAGE_NAME);
    setTitle(Messages.TagSelectionWizardPage_SelectionPage_xtit);
    tagsService = AbapTagsServiceFactory.createTagsService();
    taggingService = AdtObjTaggingServiceFactory.createTaggingService();
  }

  private class TreeViewerLabelProvider extends TagLabelProvider {
    public TreeViewerLabelProvider() {
      super(false, false);
    }

    @Override
    protected void appendCounterText(final ITag tag, final StyledString text) {
      if (tag.getTaggedObjectCount() == 0) {
        return;
      }
      super.appendCounterText(tag, text);
    }

    @Override
    protected void appendTagName(final ITag tag, final StyledString text) {
      super.appendTagName(tag, text);
    }

  }

  private enum ValidationSource {
    PROJECT,
    TAGS
  }

  @Override
  public void completePage() {
    if (!isDirty()) {
      return;
    }
    var selectedTags = tagSelectionTree.getCheckedTags();
    var wizard = getWizard();
    var taggedObjectListRequest = wizard.getTaggedObjectListRequest();
    taggedObjectListRequest.getTaggedObjectIds().clear();
    taggedObjectListRequest.getTaggedObjectInfos().clear();
    taggedObjectListRequest.getTagIds().clear();

    selectedTags.forEach(t -> taggedObjectListRequest.getTagIds().add(t.getId()));

    setDirty(false);
  }

  @Override
  public void createControl(final Composite parent) {
    final var root = new Composite(parent, SWT.NONE);
    HelpUtil.setHelp(root, HelpContexts.UNASSIGN_TAGS_WIZARD_TAG_SELECTION);
    GridLayoutFactory.swtDefaults().applyTo(root);

    createProjectInput(root);
    createTagsCheckBoxTree(root);
    createViewerContextMenu();

    var treeActionsComposite = new Composite(tagSelectionTree.getTreeFilterComposite(), SWT.NONE);
    GridLayoutFactory.swtDefaults().margins(0, 0).numColumns(2).applyTo(treeActionsComposite);
    GridDataFactory.fillDefaults().applyTo(treeActionsComposite);

    createTagScopeCombo(treeActionsComposite);
    createTreeToolbar(treeActionsComposite);

    setControl(root);
    setPageComplete(false);
  }

  @Override
  public DeleteTaggedObjectsWizard getWizard() {
    return (DeleteTaggedObjectsWizard) super.getWizard();
  }

  @Override
  public void setVisible(final boolean visible) {
    if (visible && !isPageComplete()) {
      getWizard().completePreviousPage(this);
      refreshTags();
      validatePage(null, ValidationSource.TAGS);
      tagSelectionTree.setFocus();
    }
    super.setVisible(visible);
  }

  private void createProjectInput(final Composite parent) {
    projectInput = new ProjectInput(true);

    var projectComposite = new Composite(parent, SWT.NONE);
    GridDataFactory.fillDefaults().span(2, 1).grab(true, false).applyTo(projectComposite);
    GridLayoutFactory.swtDefaults().applyTo(projectComposite);
    projectInput.createControl(projectComposite);

    projectInput.addProjectValidator(project -> {
      var tagFeatureStatus = tagsService.testTagsFeatureAvailability(project);
      return tagFeatureStatus.isOK() ? taggingService.testTaggedObjectDeletionFeatureAvailability(
          project) : tagFeatureStatus;
    });
    projectInput.addStatusChangeListener(status -> {
      projectInvalid = !status.isOK();
      if (status.isOK()) {
        var wizard = getWizard();
        final var newProject = projectInput.getProjectProvider().getProject();
        final var oldProject = wizard.getProject();
        wizard.setProject(newProject);
        if (newProject != oldProject || tagSelectionTree != null && !tagSelectionTree
            .hasViewerInput()) {
          tagSelectionTree.setCheckedTags(null);
          refreshTags();
        }
      }
      validatePage(status, ValidationSource.PROJECT);
    });
    var currentProject = getWizard().getProject();
    if (currentProject != null) {
      projectInput.setProjectName(currentProject.getName());
    }
  }

  private void createSelectionInfo(final Composite parent) {
    selectionInfo = new Label(parent, SWT.NONE);
    GridDataFactory.fillDefaults().applyTo(selectionInfo);
  }

  private void createTagsCheckBoxTree(final Composite parent) {
    var group = new Group(parent, SWT.NONE);
    group.setText(Messages.General_Tags_xlbl);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(group);
    GridLayoutFactory.swtDefaults().applyTo(group);

    tagSelectionTree = new TagSelectionTree() {
      @Override
      protected void applyTreeLayoutData(final Tree tree) {
        GridDataFactory.fillDefaults()
            .align(SWT.FILL, SWT.FILL)
            .grab(true, true)
            .minSize(250, 200)
            .hint(SWT.DEFAULT, tree.getItemHeight() * 10)
            .applyTo(tree);
        super.applyTreeLayoutData(tree);
      }
    };

    treeLabelProvider = new TreeViewerLabelProvider();
    treeContentProvider = new TagTreeContentProvider();
    tagSelectionTree.setContentProvider(treeContentProvider);
    tagSelectionTree.setLabelProvider(treeLabelProvider);
    tagSelectionTree.addCheckStateListener(l -> {
      validatePage(null, ValidationSource.TAGS);
    });
    tagSelectionTree.createControl(group);
    tagSelectionTree.addKeyListenerForFilterFocus();

    createSelectionInfo(group);
  }

  private void createTagScopeCombo(final Composite parent) {
    final var tagScopeContainer = new Composite(parent, SWT.NONE);
    GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).applyTo(tagScopeContainer);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(tagScopeContainer);
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
      tagSelectionTree.refresh();
      tagSelectionTree.setCheckedElementsInTree();
    });
  }

  private void createTreeToolbar(final Composite parent) {
    toolBar = new ToolBar(parent, SWT.FLAT | SWT.HORIZONTAL);
    toolBar.setEnabled(false);
    GridDataFactory.fillDefaults().align(SWT.END, SWT.END).applyTo(toolBar);

    new ToolItem(toolBar, SWT.SEPARATOR);

    var expandAll = new ToolItem(toolBar, SWT.PUSH);
    expandAll.setToolTipText(Messages.TagSelectionWizardPage_ExpandAll_xbut);
    expandAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.EXPAND_ALL));
    expandAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagSelectionTree.expandAll();
    }));

    final var collapseAll = new ToolItem(toolBar, SWT.PUSH);
    collapseAll.setToolTipText(Messages.TagSelectionWizardPage_CollapseAll_xbut);
    collapseAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.COLLAPSE_ALL));
    collapseAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagSelectionTree.collapseAll();
    }));

    new ToolItem(toolBar, SWT.SEPARATOR);

    final var uncheckAll = new ToolItem(toolBar, SWT.PUSH);
    uncheckAll.setToolTipText(AdtBaseUIResources.getString(IAdtBaseStrings.DeselectAll_xlbl));

    uncheckAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.UNCHECK_ALL));
    uncheckAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagSelectionTree.setCheckedTags(null);
      validatePage(null, ValidationSource.TAGS);
    }));
  }

  private void createViewerContextMenu() {
    final var menuMgr = new MenuManager();
    menuMgr.setRemoveAllWhenShown(true);

    menuMgr.addMenuListener(menu -> {
      fillContextMenu(menu);
    });
    tagSelectionTree.hookContextMenu(menuMgr);
  }

  private void fillContextMenu(final IMenuManager menu) {
    var selection = tagSelectionTree.getViewerSelection();
    if (selection == null || selection.isEmpty()) {
      return;
    }

    if (Stream.of(selection.toArray()).anyMatch(selObj -> {
      if (selObj instanceof ITag) {
        return !((ITag) selObj).getChildTags().isEmpty();
      }
      return false;
    })) {
      if (selectSubTreeAction == null) {
        selectSubTreeAction = ActionFactory.createAction(
            Messages.TagSelectionWizardPage_SelectSubTreeAction_xmit, AdtBaseUIResources
                .getImageDescriptor(IAdtBaseImages.CHECK), () -> {
                  var selectedTags = tagSelectionTree.getViewerSelection();
                  for (var selObj : selectedTags.toArray()) {
                    tagSelectionTree.setTagChecked((ITag) selObj, true, true);
                  }
                  validatePage(null, ValidationSource.TAGS);
                });
      }
      menu.add(selectSubTreeAction);
    }
  }

  private void refreshTags() {
    if (projectInvalid) {
      return;
    }
    final var project = getWizard().getProject();
    if (project == null) {
      return;
    }
    if (tagLoadingJob != null && tagLoadingJob.getResult() == null) {
      tagLoadingJob.cancel();
    }
    tagLoadingJob = Job.create(Messages.AbapTagManagerView_TagsLoadingJobTitle_xmsg, monitor -> {
      final var tagList = tagsService.readTags(DestinationUtil.getDestinationId(project),
          TagSearchScope.ALL, true);

      Display.getDefault().asyncExec(() -> {
        tagSelectionTree.setTags(tagList.getTags(), true);
        tagSelectionTree.expandAll();
        tagSelectionTree.refresh();
        tagSelectionTree.selectFirstItem();
        tagSelectionTree.setFocus();

        if (toolBar != null) {
          toolBar.setEnabled(tagSelectionTree.hasViewerInput());
        }
      });
      monitor.done();
    });
    tagLoadingJob.schedule();
  }

  private void updateCheckedLabel() {
    if (selectionInfo == null) {
      return;
    }
    var checkedCount = tagSelectionTree.getCheckedTags().size();

    selectionInfo.setText(String.format(Messages.TagSelectionWizardPage_TagSelectionFormat_xmsg,
        checkedCount == 0 ? Messages.General_No_xlbl : String.valueOf(checkedCount),
        checkedCount == 1 ? "" : "s", //$NON-NLS-1$ //$NON-NLS-2$
        Messages.DeleteTagsWizardPage_Selected_xlbl));
  }

  private void validatePage(final IStatus status, final ValidationSource source) {
    setDirty(true);
    getWizard().setCanFinish(false);
    IStatus pageStatus = status;
    boolean validateTags = false;

    if (source == ValidationSource.PROJECT) {
      if (!pageStatus.isOK()) {
        if (tagSelectionTree != null && tagSelectionTree.hasViewerInput()) {
          tagSelectionTree.setTags(null, false);
        }
        if (toolBar != null) {
          toolBar.setEnabled(false);
        }
      } else {
        if (toolBar != null) {
          toolBar.setEnabled(true);
        }
        // if project validation is successful continue with Tags validation
        validateTags = true;
      }
    } else if (source == ValidationSource.TAGS) {
      validateTags = true;
    }

    if (validateTags) {
      var selectedTags = tagSelectionTree != null ? tagSelectionTree.getCheckedTags() : null;
      if (selectedTags == null || selectedTags.isEmpty()) {
        pageStatus = new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID, IStatus.INFO,
            Messages.TagSelectionWizardPage_NoTagsSelectedInfo_xmsg, null);
      } else {
        pageStatus = Status.OK_STATUS;
      }
    }
    updateCheckedLabel();
    updatePageCompletedStatus(pageStatus);
  }

}
