package com.devepos.adt.atm.ui.internal.views;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.model.abaptags.TagInfoType;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.tagging.IAdtObjTaggingService;
import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.tags.IAbapTagsService;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.ImageUtil;
import com.devepos.adt.atm.ui.internal.TagFolder;
import com.devepos.adt.atm.ui.internal.TagFolderType;
import com.devepos.adt.atm.ui.internal.TagFolders;
import com.devepos.adt.atm.ui.internal.dialogs.EditTagDataDialog;
import com.devepos.adt.atm.ui.internal.help.HelpContexts;
import com.devepos.adt.atm.ui.internal.help.HelpUtil;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.preferences.ITagManagerPrefs;
import com.devepos.adt.atm.ui.internal.preferences.ITaggedObjectSearchPrefs;
import com.devepos.adt.atm.ui.internal.search.TaggedObjectSearchQuery;
import com.devepos.adt.atm.ui.internal.wizard.DeleteTagsWizard;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.IUser;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.ContextHelper;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.IGeneralCommandConstants;
import com.devepos.adt.base.ui.IGeneralContextConstants;
import com.devepos.adt.base.ui.IGeneralMenuConstants;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.ViewDescriptionLabel;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.base.ui.action.CollapseAllTreeNodesAction;
import com.devepos.adt.base.ui.action.CommandFactory;
import com.devepos.adt.base.ui.action.ExpandAllAction;
import com.devepos.adt.base.ui.controls.FilterableComposite;
import com.devepos.adt.base.ui.project.AbapProjectProviderAccessor;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.tree.FilterableTree;
import com.devepos.adt.base.ui.tree.IFilterableView;
import com.devepos.adt.base.ui.userinfo.IUserServiceUI;
import com.devepos.adt.base.ui.userinfo.UserServiceUIFactory;
import com.devepos.adt.base.util.StringUtil;

/**
 * View to manage, explore ABAP Tags
 *
 * @author stockbal
 */
public class AbapTagManagerView extends ViewPart implements IFilterableView {

  public static final String VIEW_ID = "com.devepos.adt.atm.ui.views.AbapTagManager"; //$NON-NLS-1$
  private static final String MENU_SEP_GROUP_SHARE = "group.share"; //$NON-NLS-1$
  protected ISelection lastSelection;
  private Action convertTagAction;
  private Action createGlobalTagAction;
  private Action createSubTagAction;
  private Action createUserTagAction;
  private Action deleteTagsAction;
  private Action editTagAction;
  private Action collapseAllAction;
  private Action removeTaggedObjectsAction;
  private TriggerTagSearchAction searchForSelectedTags;
  private TriggerTagSearchAction searchForAllSelectedTags;
  private ExpandAllAction expandAllAction;
  private IProject lastProject;
  private Composite mainComposite;
  private final IPreferenceStore prefStore;
  private Action refreshAction;

  private final ISelectionListener selectionListener = new ISelectionListener() {
    private boolean isUpdatingSelection = false;

    @Override
    public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
      // check whether another refresh job is running
      if (isUpdatingSelection) {
        return;
      }
      try {
        isUpdatingSelection = true;
        // check whether the selection change is on this view
        if (AbapTagManagerView.this == part) {
          return;
        }
        // update selection
        lastSelection = selection;
        // Further processing will only be done if this view is visible
        if (!getViewSite().getPage().isPartVisible(AbapTagManagerView.this)) {
          return;
        }
        // refresh view
        showTagsOfLastSelectedProject();
      } finally {
        isUpdatingSelection = false;
      }
    }

  };
  private Action shareTagAction;
  private Action unshareTagAction;

  private final TagFolders tagFolders;

  private Job tagLoadingJob;
  private final IAbapTagsService tagsService;
  private final IAdtObjTaggingService objTaggingService;

  private FilterableComposite<TreeViewer, Tree> tree;

  private TreeViewer treeViewer;
  private ViewDescriptionLabel viewLabel;
  private String lastDestinationOwner = ""; //$NON-NLS-1$
  private boolean tagsSharingPossible;
  private boolean tagDeletionCheckPossible;
  private ContextHelper contextHelper;

  public AbapTagManagerView() {
    tagsService = AbapTagsServiceFactory.createTagsService();
    objTaggingService = AdtObjTaggingServiceFactory.createTaggingService();
    tagFolders = new TagFolders();
    prefStore = AbapTagsUIPlugin.getDefault().getPreferenceStore();
  }

  private class ShareTagsAction extends Action {

    private List<IUser> usersOfSharedTag;
    private ITag tag;
    private String destinationId;

    public ShareTagsAction() {
      super(Messages.AbapTagManagerView_ShareTagAction_xmit, AdtBaseUIResources.getImageDescriptor(
          IAdtBaseImages.SHARE));
    }

    @Override
    public void run() {
      tag = getSelectedTag();
      if (tag == null) {
        return;
      }
      destinationId = DestinationUtil.getDestinationId(lastProject);
      usersOfSharedTag = null;
      beforeSharingTag();
    }

    private void afterFetchingUsersOfSharedTag() {
      final IUserServiceUI userService = UserServiceUIFactory.createUserService();

      final List<String> usersForSharing = userService.showUserSelectionDialog(getSite().getShell(),
          Messages.AbapTagManagerView_SharedUserSelectionDialog_xtit, true, usersOfSharedTag, List
              .of(lastDestinationOwner), destinationId);
      if (usersForSharing == null || usersForSharing.isEmpty()) {
        return;
      }
      final ITagList sharedTagList = IAbapTagsFactory.eINSTANCE.createTagList();
      final ITag sharedTag = IAbapTagsFactory.eINSTANCE.createTag();
      sharedTag.setId(tag.getId());
      sharedTagList.getTags().add(sharedTag);
      usersForSharing.forEach(u -> {
        final IUser user = IAdtBaseFactory.eINSTANCE.createUser();
        user.setName(u);
        sharedTag.getSharedUsers().add(user);
      });
      final Job job = Job.create(Messages.AbapTagManagerView_ShareTagsJob_xmsg, monitor -> {
        final IStatus serviceStatus = tagsService.shareTags(DestinationUtil.getDestinationId(
            lastProject), sharedTagList);
        if (!serviceStatus.isOK()) {
          Display.getDefault().asyncExec(() -> {
            MessageDialog.openError(getSite().getShell(),
                Messages.AbapTagManagerView_ErrorMessageTitle_xtit,
                Messages.AbapTagManagerView_ErrorDuringSharing_xmsg + serviceStatus.getMessage());
          });
        }
        refreshTags();
        monitor.done();
      });
      job.schedule();
    }

    private void beforeSharingTag() {

      final Job fetchUserJob = new Job(
          Messages.AbapTagManagerView_FetchingUsersOfSharedTagJob_xmsg) {
        @Override
        protected IStatus run(final IProgressMonitor monitor) {
          usersOfSharedTag = tagsService.getSharedUsers(destinationId, tag.getId());
          monitor.done();
          return Status.OK_STATUS;
        }
      };
      fetchUserJob.addJobChangeListener(new JobChangeAdapter() {
        @Override
        public void done(final IJobChangeEvent event) {
          Display.getDefault().asyncExec(() -> {
            afterFetchingUsersOfSharedTag();
          });
        }
      });
      fetchUserJob.schedule();
    }

  }

  private static class TreeContentProvider implements ITreeContentProvider {

    private TagFolder[] input;

    @Override
    public Object[] getChildren(final Object parentElement) {
      if (parentElement instanceof TagFolder) {
        return ((TagFolder) parentElement).getTags().toArray();
      }
      if (parentElement instanceof ITag) {
        return ((ITag) parentElement).getChildTags().toArray();
      }
      return null;
    }

    @Override
    public Object[] getElements(final Object inputElement) {
      return (Object[]) inputElement;
    }

    @Override
    public Object getParent(final Object element) {
      if (element instanceof ITag) {
        final EObject container = ((ITag) element).eContainer();
        if (container instanceof ITag) {
          return container;
        }
        return findParentInTopLevelNodes((ITag) element);
      }
      return null;
    }

    @Override
    public boolean hasChildren(final Object element) {
      if (element instanceof TagFolder) {
        return ((TagFolder) element).hasTags();
      }
      if (element instanceof ITag) {
        return !((ITag) element).getChildTags().isEmpty();
      }
      return false;
    }

    @Override
    public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
      if (newInput instanceof TagFolder[]) {
        input = (TagFolder[]) newInput;
      } else {
        input = null;
      }
    }

    private Object findParentInTopLevelNodes(final ITag element) {
      if (input == null) {
        return null;
      }
      for (final TagFolder folder : input) {
        if (folder.getTags().contains(element)) {
          return folder;
        }
      }
      return null;
    }

  }

  private class TriggerTagSearchAction extends Action {
    private final boolean matchAllTags;

    public TriggerTagSearchAction(final String name, final boolean matchAllTags) {
      super(name, AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.SEARCH));
      this.matchAllTags = matchAllTags;
    }

    @Override
    public void run() {
      List<ITag> selectedTags = getSelectedTags();
      if (selectedTags.isEmpty()) {
        return;
      }
      final ITaggedObjectSearchParams searchParams = IAbapTagsFactory.eINSTANCE
          .createTaggedObjectSearchParams();
      searchParams.setMaxResults(prefStore.getInt(ITaggedObjectSearchPrefs.MAX_RESULTS));
      searchParams.setWithTagInfo(true);
      searchParams.setTagInfoType(TagInfoType.CHILDREN);

      selectedTags.forEach(tag -> searchParams.addTag(tag));
      searchParams.setMatchesAllTags(matchAllTags);

      final TaggedObjectSearchQuery searchQuery = new TaggedObjectSearchQuery(searchParams);
      searchQuery.setProjectProvider(AbapProjectProviderAccessor.getProviderForDestination(
          DestinationUtil.getDestinationId(lastProject)));

      NewSearchUI.runQueryInBackground(searchQuery);
    }

    private List<ITag> getSelectedTags() {
      List<ITag> tags = new ArrayList<>();
      IStructuredSelection selection = treeViewer.getStructuredSelection();
      for (Object object : selection.toArray()) {
        if (object instanceof ITag) {
          tags.add((ITag) object);
        }
      }
      return tags;
    }
  }

  /**
   * Custom view label provider for the Result Tree
   *
   * @author stockbal
   */
  private static class ViewLabelProvider extends LabelProvider implements ILabelProvider,
      IStyledLabelProvider {

    @Override
    public Image getImage(final Object element) {
      if (element instanceof TagFolder) {
        return ((TagFolder) element).getImage();
      }
      if (element instanceof ITag) {
        return ImageUtil.getImageForTag((ITag) element, true);
      }
      return null;
    }

    @Override
    public StyledString getStyledText(final Object element) {
      final StyledString text = new StyledString();

      if (element instanceof TagFolder) {
        text.append(((TagFolder) element).getName());
      } else if (element instanceof ITag) {
        final ITag tag = (ITag) element;
        text.append(tag.getName());

        if (tag.getTaggedObjectCount() > 0) {
          text.append(" (" + tag.getTaggedObjectCount() + ")", StyledString.COUNTER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
        }

        final String description = tag.getDescription();
        if (!StringUtil.isEmpty(description)) {
          text.append("  " + description + "  ", //$NON-NLS-1$ //$NON-NLS-2$
              StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR,
                  null));
        }
      }

      return text;
    }

    @Override
    public String getText(final Object element) {
      if (element instanceof TagFolder) {
        return ((TagFolder) element).getName();
      }
      if (element instanceof ITag) {
        return ((ITag) element).getName();
      }
      return ""; //$NON-NLS-1$
    }
  }

  @Override
  public void createPartControl(final Composite parent) {
    mainComposite = new Composite(parent, SWT.NONE);
    HelpUtil.setHelp(mainComposite, HelpContexts.TAG_MANAGER);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(mainComposite);
    GridLayoutFactory.swtDefaults().margins(0, 0).applyTo(mainComposite);

    createViewer(mainComposite);
    viewLabel = new ViewDescriptionLabel(mainComposite);
    clearInput();

    initializeActions();

    initToolbar(getViewSite().getActionBars());
    hookContextMenu();

    getSite().setSelectionProvider(treeViewer);
    getSite().getPage().addPostSelectionListener(selectionListener);
    checkProjectStatus(false);

    contextHelper = ContextHelper.createForServiceLocator(getSite());
    contextHelper.activateAbapContext();
    contextHelper.activateContext(IGeneralContextConstants.FILTERABLE_VIEWS);
  }

  @Override
  public void dispose() {
    getSite().getPage().removePostSelectionListener(selectionListener);
    if (contextHelper != null) {
      contextHelper.deactivateAllContexts();
    }
    super.dispose();
  }

  @Override
  public void init(final IViewSite site) throws PartInitException {
    super.init(site);
    lastSelection = getSite().getPage().getSelection();
  }

  @Override
  public void setFocus() {
    if (tree != null && !tree.isDisposed()) {
      tree.setFocus();
    }
    if (lastSelection != null) {
      showTagsOfLastSelectedProject();
    }
  }

  @Override
  public void toggleInlineFilter() {
    if (treeViewer.getInput() != null) {
      tree.toggleFilterVisiblity();
    }
  }

  private ITagList buildNewTagListFromSelection(final Predicate<ITag> tagConditionCheck,
      final boolean includeBasicTagProperties) {
    ITagList newTagList = IAbapTagsFactory.eINSTANCE.createTagList();
    final IStructuredSelection sel = treeViewer.getStructuredSelection();
    if (sel == null || sel.isEmpty()) {
      return newTagList;
    }
    for (final Object selectedObj : sel.toList()) {
      if (selectedObj instanceof ITag) {
        if (tagConditionCheck != null && !tagConditionCheck.test((ITag) selectedObj)) {
          continue;
        }
        final var tag = IAbapTagsFactory.eINSTANCE.createTag();
        final var selectedTag = (ITag) selectedObj;
        tag.setId(selectedTag.getId());
        if (includeBasicTagProperties) {
          tag.setName(selectedTag.getName());
          tag.setOwner(selectedTag.getOwner());
          tag.setShared(selectedTag.isShared());
          tag.setSharedForMe(selectedTag.isSharedForMe());
        }
        newTagList.getTags().add(tag);
      }

    }
    return newTagList;
  }

  private boolean checkProjectStatus(final boolean ensureLogon) {
    boolean tagsFeatureStatusUnknown = false;
    if (lastProject == null) {
      viewLabel.updateLabel(Messages.AbapTagManagerView_NoProjectAvailable_xmsg);
      clearInput();
      setControlsEnabled(false);
      return false;
    }
    // check if the user is logged on to the project
    if (ensureLogon) {
      if (!ProjectUtil.ensureLoggedOnToProject(lastProject).isOK()) {
        tagsFeatureStatusUnknown = true;
      }
    } else {
      if (!ProjectUtil.isLoggedOnToProject(lastProject)) {
        tagsFeatureStatusUnknown = true;
      }
    }
    if (tagsFeatureStatusUnknown) {
      viewLabel.updateLabel(NLS.bind(Messages.AbapTagManagerView_TagsNotLoadedInProject_xmsg,
          lastProject.getName()));
      clearInput();
      setControlsEnabled(true);
      return false;
    }
    final IStatus tagFeatureStatus = tagsService.testTagsFeatureAvailability(lastProject);
    if (!tagFeatureStatus.isOK()) {
      viewLabel.updateLabel(tagFeatureStatus.getMessage());
      clearInput();
      setControlsEnabled(false);
      return false;
    }
    tagsSharingPossible = tagsService.testShareTagsFeatureAvailability(lastProject).isOK();
    tagDeletionCheckPossible = tagsService.testTagDeletionCheckFeatureAvailability(lastProject)
        .isOK();
    setControlsEnabled(true);
    viewLabel.updateLabel(NLS.bind(Messages.AbapTagManagerView_TagListInProject_xmsg, lastProject
        .getName()));
    return true;
  }

  private void clearInput() {
    treeViewer.setInput(null);
    treeViewer.refresh();
    tree.resetFilter();
    tree.setFilterVisible(false);
  }

  private void createOrUpdateTag(final ITag newTag, final boolean isUserTag) {
    final ITagList updateList = IAbapTagsFactory.eINSTANCE.createTagList();
    updateList.getTags().add(newTag);

    if (!ProjectUtil.ensureLoggedOnToProject(lastProject).isOK()) {
      return;
    }
    final Job updateJob = Job.create(Messages.AbapTagManagerView_UpdateTagJobTitle_xmsg,
        monitor -> {
          final IStatus status = tagsService.updateTags(updateList, DestinationUtil
              .getDestinationId(lastProject), isUserTag ? TagSearchScope.USER
                  : TagSearchScope.GLOBAL);
          if (!status.isOK()) {
            Display.getDefault().asyncExec(() -> {
              MessageDialog.openError(getSite().getShell(),
                  Messages.AbapTagManagerView_ErrorMessageTitle_xtit,
                  Messages.AbapTagManagerView_ErrorDuringTagUpdate_xmsg + status.getMessage());
            });
          }
          refreshTags();
          monitor.done();
        });
    updateJob.schedule();
  }

  private void createViewer(final Composite parent) {
    tree = new FilterableTree(parent, Messages.AbapTagManagerView_ViewerFilterText_xmsg, true);
    tree.setElementMatcher(element -> {
      if (element instanceof ITag) {
        final ITag tag = (ITag) element;

        return tree.getWordMatcher().matchesWord(tag.getName()) || tree.getWordMatcher()
            .matchesWord(tag.getDescription());
      }
      return false;
    });
    treeViewer = new TreeViewer(tree, SWT.V_SCROLL | SWT.MULTI);
    tree.setViewer(treeViewer);
    treeViewer.setContentProvider(new TreeContentProvider());
    treeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new ViewLabelProvider()));
    treeViewer.setUseHashlookup(true);
    treeViewer.addOpenListener(e -> {
      final ISelection sel = e.getSelection();
      if (sel == null || sel.isEmpty() || !(sel instanceof IStructuredSelection)) {
        return;
      }
      final IStructuredSelection structeredSel = (IStructuredSelection) sel;
      if (structeredSel.size() > 1) {
        return;
      }
      final Object selObj = structeredSel.getFirstElement();
      if (selObj instanceof ITag && ((ITag) selObj).isEditable()) {
        handleEditTag((ITag) selObj);
      }
    });
  }

  private void fillContextMenu(final IMenuManager menu) {
    final IStructuredSelection sel = treeViewer.getStructuredSelection();
    if (sel.isEmpty()) {
      return;
    }
    menu.add(new Separator(IGeneralMenuConstants.GROUP_NEW));
    menu.add(new Separator(IGeneralMenuConstants.GROUP_EDIT));
    menu.add(new Separator(MENU_SEP_GROUP_SHARE));
    menu.add(new Separator(IGeneralMenuConstants.GROUP_SEARCH));

    int selectedTagCount = 0;
    if (sel.size() == 1) {
      final Object selObj = sel.getFirstElement();
      if (selObj instanceof TagFolder) {
        final TagFolder folder = (TagFolder) selObj;
        if (folder.getType() == TagFolderType.USER) {
          menu.appendToGroup(IGeneralMenuConstants.GROUP_NEW, createUserTagAction);
        } else if (folder.getType() == TagFolderType.GLOBAL) {
          menu.appendToGroup(IGeneralMenuConstants.GROUP_NEW, createGlobalTagAction);
        }
        return;
      }
      final ITag tag = (ITag) selObj;
      selectedTagCount += 1;
      if (tag.isEditable()) {
        menu.appendToGroup(IGeneralMenuConstants.GROUP_EDIT, editTagAction);
      }
      if (!(tag.eContainer() instanceof ITag) && !StringUtil.isEmpty(tag.getOwner()) && tag
          .isEditable()) {
        menu.appendToGroup(IGeneralMenuConstants.GROUP_EDIT, convertTagAction);
        if (tagsSharingPossible) {
          menu.appendToGroup(MENU_SEP_GROUP_SHARE, shareTagAction);
          if (tag.isShared()) {
            unshareTagAction.setText(Messages.AbapTagManagerView_UnshareTagAction_xmit);
            menu.appendToGroup(MENU_SEP_GROUP_SHARE, unshareTagAction);
          }
        }
      }
      if (tag.isEditable()) {
        deleteTagsAction.setText(Messages.AbapTagManagerView_DeleteTagAction_xmit);
        menu.appendToGroup(IGeneralMenuConstants.GROUP_EDIT, deleteTagsAction);
        menu.appendToGroup(IGeneralMenuConstants.GROUP_EDIT, removeTaggedObjectsAction);
        menu.appendToGroup(IGeneralMenuConstants.GROUP_NEW, createSubTagAction);
      }
    } else {
      boolean massEditingPossible = true;
      boolean atLeastOneSharedTag = false;
      for (final Object selObj : sel.toList()) {
        if (selObj instanceof TagFolderType) {
          massEditingPossible = false;
          break;
        }
        if (selObj instanceof ITag) {
          selectedTagCount += 1;
          ITag selectedTag = (ITag) selObj;
          if (!selectedTag.isEditable()) {
            massEditingPossible = false;
            break;
          }
          if (selectedTag.isShared()) {
            atLeastOneSharedTag = true;
          }
        }
      }
      if (massEditingPossible) {
        deleteTagsAction.setText(Messages.AbapTagManagerView_DeleteTagsAction_xmit);
        menu.appendToGroup(IGeneralMenuConstants.GROUP_EDIT, deleteTagsAction);
        menu.appendToGroup(IGeneralMenuConstants.GROUP_EDIT, removeTaggedObjectsAction);
        if (atLeastOneSharedTag && tagsSharingPossible) {
          unshareTagAction.setText(Messages.AbapTagManagerView_UnshareTagsAction_xmit);
          menu.appendToGroup(MENU_SEP_GROUP_SHARE, unshareTagAction);
        }
      }
    }

    if (selectedTagCount > 0) {
      menu.appendToGroup(IGeneralMenuConstants.GROUP_SEARCH, searchForSelectedTags);
      if (selectedTagCount > 1) {
        menu.appendToGroup(IGeneralMenuConstants.GROUP_SEARCH, searchForAllSelectedTags);
      }
    }
  }

  private ITag getSelectedTag() {
    final IStructuredSelection sel = treeViewer.getStructuredSelection();
    if (sel.isEmpty() || sel.size() > 1) {
      return null;
    }
    return (ITag) sel.getFirstElement();
  }

  private void handleConvertTag() {
    final ITag tag = getSelectedTag();
    if (tag == null || !MessageDialog.openQuestion(getSite().getShell(),
        Messages.AbapTagManagerView_ConvertToGlobalTagAction_xmit, NLS.bind(
            Messages.AbapTagManagerView_ConvertToGlobalTagPrompt_xmsg, tag.getName()))
        || !ProjectUtil.ensureLoggedOnToProject(lastProject).isOK()) {
      return;
    }
    final ITagList userTagList = IAbapTagsFactory.eINSTANCE.createTagList();
    userTagList.getTags().add(tag);
    final Job job = Job.create(Messages.AbapTagManagerView_ConvertToGlobalTagJobTitle_xmsg,
        monitor -> {
          final IStatus serviceStatus = tagsService.makeTagsGlobal(DestinationUtil.getDestinationId(
              lastProject), userTagList);
          if (!serviceStatus.isOK()) {
            Display.getDefault().asyncExec(() -> {
              MessageDialog.openError(getSite().getShell(),
                  Messages.AbapTagManagerView_ErrorMessageTitle_xtit,
                  Messages.AbapTagManagerView_ErrorDuringTagConversion_xmsg + serviceStatus
                      .getMessage());
            });
          }
          refreshTags();
          monitor.done();
        });
    job.schedule();
  }

  private void handleCreateTag(final boolean isUserTag) {
    if (treeViewer.getInput() == null) {
      return;
    }
    final ITag newTag = IAbapTagsFactory.eINSTANCE.createTag();
    final List<ITag> tagList = tagFolders.getFolderByType(isUserTag ? TagFolderType.USER
        : TagFolderType.GLOBAL).getTags();
    if (isUserTag) {
      newTag.setOwner(DestinationUtil.getDestinationOwner(lastProject));
    }
    tagList.add(newTag);
    final EditTagDataDialog createDialog = new EditTagDataDialog(getSite().getShell(), newTag,
        tagList, isUserTag);
    if (createDialog.open() == Window.OK) {
      createOrUpdateTag(newTag, isUserTag);
    } else {
      tagList.remove(newTag);
    }

  }

  private void handleCreateTagOnSelectedNode() {
    final ITag tag = getSelectedTag();
    if (tag == null) {
      return;
    }
    final ITag newTag = IAbapTagsFactory.eINSTANCE.createTag();
    newTag.setParentTagId(tag.getId());
    newTag.setOwner(tag.getOwner());
    final boolean isUserTag = !StringUtil.isEmpty(tag.getOwner());
    final List<ITag> tagList = tag.getChildTags();
    tagList.add(newTag);
    final EditTagDataDialog createDialog = new EditTagDataDialog(getSite().getShell(), newTag,
        tagList, isUserTag);
    if (createDialog.open() == Window.OK) {
      createOrUpdateTag(newTag, isUserTag);
    } else {
      tagList.remove(newTag);
    }
  }

  private void handleDeleteTags() {
    final var tagList = buildNewTagListFromSelection(null, true);

    if (!ProjectUtil.ensureLoggedOnToProject(lastProject).isOK()) {
      return;
    }

    if (tagDeletionCheckPossible) {
      var wizard = new DeleteTagsWizard(tagList);
      wizard.setProject(lastProject);
      final var dialog = new WizardDialog(PlatformUI.getWorkbench()
          .getActiveWorkbenchWindow()
          .getShell(), wizard);
      dialog.open();

      if (wizard.hasDeletionOccurred()) {
        refreshTags();
      }
    } else {
      // Fallback logic if deletion check not available in backend
      if (MessageDialog.open(MessageDialog.WARNING, getSite().getShell(),
          Messages.AbapTagManagerView_DeleteTagsMsgTitle_xtit,
          Messages.AbapTagManagerView_DeleteTagsPrompt_xmsg, SWT.NONE, new String[] {
              IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL }) != 0) {
        return;
      }
      final Job deleteJob = Job.create(Messages.AbapTagManagerView_DeleteTagsJobTitle_xmsg,
          monitor -> {
            final IStatus status = tagsService.deleteTags(tagList, DestinationUtil.getDestinationId(
                lastProject), TagSearchScope.ALL);
            if (!status.isOK()) {
              MessageDialog.openError(getSite().getShell(),
                  Messages.AbapTagManagerView_ErrorMessageTitle_xtit,
                  Messages.AbapTagManagerView_ErrorDuringTagDeletion_xmsg + status.getMessage());
            }
            refreshTags();
            monitor.done();
          });
      deleteJob.schedule();
    }
  }

  private void handleEditTag(final ITag t) {
    final ITag tag = t != null ? t : getSelectedTag();
    if (tag == null) {
      return;
    }
    final boolean isUserTag = !StringUtil.isEmpty(tag.getOwner());
    List<ITag> tagList = null;
    if (tag.eContainer() instanceof ITag) {
      tagList = ((ITag) tag.eContainer()).getChildTags();
    } else {
      tagList = tagFolders.getFolderByType(isUserTag ? TagFolderType.USER : TagFolderType.GLOBAL)
          .getTags();
    }
    final EditTagDataDialog createDialog = new EditTagDataDialog(getSite().getShell(), tag, tagList,
        isUserTag);
    if (createDialog.open() == Window.OK) {
      createOrUpdateTag(tag, isUserTag);
    }
  }

  private void handleRefresh() {
    if (!checkProjectStatus(true)) {
      return;
    }
    refreshTags();
  }

  private void handleRemoveAllTaggedObjects() {
    final ITaggedObjectList tgobjList = IAbapTagsFactory.eINSTANCE.createTaggedObjectList();
    final ITaggedObject tgobj = IAbapTagsFactory.eINSTANCE.createTaggedObject();
    tgobjList.getTaggedObjects().add(tgobj);

    final IStructuredSelection sel = treeViewer.getStructuredSelection();
    if (sel == null || sel.isEmpty()) {
      return;
    }
    for (final Object selectedObj : sel.toList()) {
      if (selectedObj instanceof ITag) {
        final IAdtObjectTag objTag = IAbapTagsFactory.eINSTANCE.createAdtObjectTag();
        objTag.setId(((ITag) selectedObj).getId());
        tgobj.getTags().add(objTag);
      }
    }
    if (MessageDialog.open(MessageDialog.WARNING, getSite().getShell(),
        Messages.AbapTagManagerView_unassignTagsMessage_xtit,
        Messages.AbapTagManagerView_unassignTagsMessage_xmsg, SWT.NONE, new String[] {
            IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL }) != 0 || !ProjectUtil
                .ensureLoggedOnToProject(lastProject)
                .isOK()) {
      return;
    }
    final Job deleteJob = Job.create(Messages.AbapTagManagerView_unassignTagsJob_xtit, monitor -> {
      objTaggingService.deleteTags(DestinationUtil.getDestinationId(lastProject), tgobjList);
      refreshTags();
      monitor.done();
    });
    deleteJob.schedule();
  }

  private void handleUnshareTag() {
    final ITagList sharedTagList = buildNewTagListFromSelection(t -> t.isShared() && t.isEditable(),
        false);
    final Job job = Job.create(Messages.AbapTagManagerView_UnshareTagsJob_xmsg, monitor -> {
      final IStatus serviceStatus = tagsService.unshareTags(DestinationUtil.getDestinationId(
          lastProject), sharedTagList);
      if (!serviceStatus.isOK()) {
        Display.getDefault().asyncExec(() -> {
          MessageDialog.openError(getSite().getShell(),
              Messages.AbapTagManagerView_ErrorMessageTitle_xtit,
              Messages.AbapTagManagerView_ErrorDuringUnsharing_xmsg + serviceStatus.getMessage());
        });
      }
      refreshTags();
      monitor.done();
    });
    job.schedule();
  }

  private void hookContextMenu() {
    final MenuManager menuMgr = new MenuManager();
    menuMgr.setRemoveAllWhenShown(true);

    menuMgr.addMenuListener(menu -> {
      fillContextMenu(menu);
    });
    final Control viewerControl = treeViewer.getControl();
    final Menu menu = menuMgr.createContextMenu(viewerControl);
    viewerControl.setMenu(menu);
    getSite().registerContextMenu(getViewSite().getId(), menuMgr, treeViewer);
  }

  private void initializeActions() {
    collapseAllAction = new CollapseAllTreeNodesAction(treeViewer);
    expandAllAction = new ExpandAllAction();
    expandAllAction.setTreeViewer(treeViewer);
    searchForSelectedTags = new TriggerTagSearchAction(
        Messages.AbapTagManagerView_FindTaggedObjectsAction_xmit, false);
    searchForAllSelectedTags = new TriggerTagSearchAction(
        Messages.AbapTagManagerView_FindTaggedObjectsActionMatchAllTags_xmit, true);
    refreshAction = ActionFactory.createAction(AdtBaseUIResources.getString(
        IAdtBaseStrings.Refresh), AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.REFRESH),
        this::handleRefresh);
    createGlobalTagAction = ActionFactory.createAction(
        Messages.AbapTagManagerView_NewGlobalTagAction_xtol, AbapTagsUIPlugin.getDefault()
            .getImageDescriptor(IImages.NEW_GLOBAL_TAG), () -> handleCreateTag(false));
    createUserTagAction = ActionFactory.createAction(
        Messages.AbapTagManagerView_NewUserTagAction_xtol, AbapTagsUIPlugin.getDefault()
            .getImageDescriptor(IImages.NEW_USER_TAG), () -> handleCreateTag(true));
    deleteTagsAction = ActionFactory.createAction(Messages.AbapTagManagerView_DeleteTagsAction_xmit,
        PlatformUI.getWorkbench()
            .getSharedImages()
            .getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE), this::handleDeleteTags);
    removeTaggedObjectsAction = ActionFactory.createAction(
        Messages.AbapTagManagerView_removeAssignedObjectsAction_xmit, null,
        this::handleRemoveAllTaggedObjects);
    editTagAction = ActionFactory.createAction(Messages.AbapTagManagerView_EditTagAction_xmit,
        AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.EDIT_ACTION), () -> handleEditTag(
            null));
    createSubTagAction = ActionFactory.createAction(
        Messages.AbapTagManagerView_AddSubTagAction_xmit, PlatformUI.getWorkbench()
            .getSharedImages()
            .getImageDescriptor(ISharedImages.IMG_OBJ_ADD), this::handleCreateTagOnSelectedNode);
    convertTagAction = ActionFactory.createAction(
        Messages.AbapTagManagerView_ConvertToGlobalTagAction_xmit, PlatformUI.getWorkbench()
            .getSharedImages()
            .getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD), this::handleConvertTag);
    shareTagAction = new ShareTagsAction();
    unshareTagAction = ActionFactory.createAction(Messages.AbapTagManagerView_UnshareTagAction_xmit,
        AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.UNSHARE), this::handleUnshareTag);
  }

  private void initToolbar(final IActionBars actionBars) {
    actionBars.setGlobalActionHandler(org.eclipse.ui.actions.ActionFactory.REFRESH.getId(),
        refreshAction);

    final IToolBarManager tbm = actionBars.getToolBarManager();
    tbm.add(refreshAction);
    tbm.add(new Separator());
    tbm.add(expandAllAction);
    tbm.add(collapseAllAction);
    tbm.add(new Separator());
    tbm.add(createUserTagAction);
    tbm.add(createGlobalTagAction);

    actionBars.getMenuManager()
        .add(CommandFactory.createContribItemById(
            IGeneralCommandConstants.TOGGLE_VIEWER_TEXT_FILTER, false, null));
  }

  private void loadViewInput() {
    if (!checkProjectStatus(false)) {
      return;
    }
    refreshTags();
  }

  private void refreshTags() {
    if (tagLoadingJob != null && tagLoadingJob.getResult() == null) {
      tagLoadingJob.cancel();
    }
    tagLoadingJob = Job.create(Messages.AbapTagManagerView_TagsLoadingJobTitle_xmsg, monitor -> {
      final ITagList tagList = tagsService.readTags(DestinationUtil.getDestinationId(lastProject),
          TagSearchScope.ALL, true);

      tagFolders.clearTags();
      lastDestinationOwner = DestinationUtil.getDestinationOwner(lastProject);

      if (tagList != null) {
        for (final ITag tag : tagList.getTags()) {
          if (StringUtil.isEmpty(tag.getOwner())) {
            tagFolders.getFolderByType(TagFolderType.GLOBAL).getTags().add(tag);
          } else if (tag.getOwner().equals(lastDestinationOwner)) {
            tagFolders.getFolderByType(TagFolderType.USER).getTags().add(tag);
          } else if (tag.isShared()) {
            tagFolders.getFolderByType(TagFolderType.SHARED).getTags().add(tag);
          }
        }
      }
      Display.getDefault().asyncExec(() -> {
        // TODO: cache old selected tag/folder and find correct object via folder name/tag id
        // so the user can continue working from the previously selected object
        var folders = tagFolders.getFolders(tagsSharingPossible);
        treeViewer.setInput(folders);
        treeViewer.refresh();
        if (prefStore.getBoolean(ITagManagerPrefs.AUTO_EXPAND_TAGS)) {
          treeViewer.expandAll();
        } else {
          treeViewer.expandToLevel(2);
        }
      });
      monitor.done();
    });
    tagLoadingJob.schedule();
  }

  private void setControlsEnabled(final boolean enabled) {
    createGlobalTagAction.setEnabled(enabled);
    createUserTagAction.setEnabled(enabled);
    refreshAction.setEnabled(enabled);
    collapseAllAction.setEnabled(enabled);
    expandAllAction.setEnabled(enabled);
  }

  private void showTagsOfLastSelectedProject() {
    final IProject project = ProjectUtil.getCurrentAbapProject(lastSelection);
    if (project != lastProject && project != null) {
      lastProject = project;
      loadViewInput();
    }
    lastSelection = null;
  }

}
