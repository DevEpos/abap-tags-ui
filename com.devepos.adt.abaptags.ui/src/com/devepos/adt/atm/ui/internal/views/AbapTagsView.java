package com.devepos.adt.atm.ui.internal.views;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
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
import org.eclipse.osgi.util.NLS;
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
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
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
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.IUser;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.IGeneralContextMenuConstants;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.ViewDescriptionLabel;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.userinfo.IUserService;
import com.devepos.adt.base.ui.userinfo.UserServiceFactory;
import com.devepos.adt.base.util.StringUtil;

/**
 * View to manage all available tags of a given ABAP project
 *
 * @author stockbal
 */
public class AbapTagsView extends ViewPart {

    public static final String VIEW_ID = "com.devepos.adt.atm.ui.views.AbapTags"; //$NON-NLS-1$
    private static final String MENU_SEP_GROUP_SHARE = "group.share"; //$NON-NLS-1$
    protected ISelection lastSelection;
    private Action convertTagAction;
    private Action createGlobalTagAction;
    private Action createSubTagAction;
    private Action createUserTagAction;
    private Action deleteTagsAction;
    private Action editTagAction;
    private IProject lastProject;
    private Composite mainComposite;
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
                if (AbapTagsView.this == part) {
                    return;
                }
                // update selection
                lastSelection = selection;
                // Further processing will only be done if this view is visible
                if (!getViewSite().getPage().isPartVisible(AbapTagsView.this)) {
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

    private Tree tree;

    private TreeViewer treeViewer;
    private ViewDescriptionLabel viewLabel;
    private String lastDestinationOwner = ""; //$NON-NLS-1$
    private boolean tagsSharingPossible;

    public AbapTagsView() {
        tagsService = AbapTagsServiceFactory.createTagsService();
        tagFolders = new TagFolders();
    }

    @Override
    public void createPartControl(final Composite parent) {
        mainComposite = new Composite(parent, SWT.NONE);
        HelpUtil.setHelp(mainComposite, HelpContexts.TAGS);
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
    }

    @Override
    public void dispose() {
        getSite().getPage().removePostSelectionListener(selectionListener);
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

    private boolean checkProjectStatus(final boolean ensureLogon) {
        boolean tagsFeatureStatusUnknown = false;
        if (lastProject == null) {
            viewLabel.updateLabel(Messages.AbapTagsView_NoProjectAvailable_xmsg);
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
            viewLabel.updateLabel(NLS.bind(Messages.AbapTagsView_TagsNotLoadedInProject_xmsg, lastProject.getName()));
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
        setControlsEnabled(true);
        viewLabel.updateLabel(NLS.bind(Messages.AbapTagsView_TagListInProject_xmsg, lastProject.getName()));
        return true;
    }

    private void clearInput() {
        treeViewer.setInput(null);
        treeViewer.refresh();
    }

    private void createOrUpdateTag(final ITag newTag, final boolean isUserTag) {
        final ITagList updateList = IAbapTagsFactory.eINSTANCE.createTagList();
        updateList.getTags().add(newTag);

        if (!ProjectUtil.ensureLoggedOnToProject(lastProject).isOK()) {
            return;
        }
        final Job updateJob = Job.create(Messages.AbapTagsView_UpdateTagJobTitle_xmsg, monitor -> {
            final IStatus status = tagsService.updateTags(updateList, DestinationUtil.getDestinationId(lastProject),
                isUserTag ? TagSearchScope.USER : TagSearchScope.GLOBAL);
            if (!status.isOK()) {
                Display.getDefault().asyncExec(() -> {
                    MessageDialog.openError(getSite().getShell(), Messages.AbapTagsView_ErrorMessageTitle_xtit,
                        Messages.AbapTagsView_ErrorDuringTagUpdate_xmsg + status.getMessage());
                });
            }
            refreshTags();
            monitor.done();
        });
        updateJob.schedule();
    }

    private void createViewer(final Composite parent) {
        treeViewer = new TreeViewer(parent, SWT.V_SCROLL | SWT.MULTI);
        tree = treeViewer.getTree();
        GridDataFactory.fillDefaults().grab(true, true).applyTo(tree);
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
        menu.add(new Separator(IGeneralContextMenuConstants.GROUP_NEW));
        menu.add(new Separator(IGeneralContextMenuConstants.GROUP_EDIT));
        menu.add(new Separator(MENU_SEP_GROUP_SHARE));

        if (sel.size() == 1) {
            final Object selObj = sel.getFirstElement();
            if (selObj instanceof TagFolder) {
                final TagFolder folder = (TagFolder) selObj;
                if (folder.getType() == TagFolderType.USER) {
                    menu.appendToGroup(IGeneralContextMenuConstants.GROUP_NEW, createUserTagAction);
                } else if (folder.getType() == TagFolderType.GLOBAL) {
                    menu.appendToGroup(IGeneralContextMenuConstants.GROUP_NEW, createGlobalTagAction);
                }
                return;
            }
            final ITag tag = (ITag) selObj;
            if (tag.isEditable()) {
                menu.appendToGroup(IGeneralContextMenuConstants.GROUP_EDIT, editTagAction);
            }
            if (!(tag.eContainer() instanceof ITag) && !StringUtil.isEmpty(tag.getOwner()) && tag.isEditable()) {
                menu.appendToGroup(IGeneralContextMenuConstants.GROUP_EDIT, convertTagAction);
                if (tagsSharingPossible) {
                    menu.appendToGroup(MENU_SEP_GROUP_SHARE, shareTagAction);
                    if (tag.isShared()) {
                        unshareTagAction.setText(Messages.AbapTagsView_UnshareTagAction_xmit);
                        menu.appendToGroup(MENU_SEP_GROUP_SHARE, unshareTagAction);
                    }
                }
            }
            if (tag.isEditable()) {
                deleteTagsAction.setText(Messages.AbapTagsView_DeleteTagAction_xmit);
                menu.appendToGroup(IGeneralContextMenuConstants.GROUP_EDIT, deleteTagsAction);
                menu.appendToGroup(IGeneralContextMenuConstants.GROUP_NEW, createSubTagAction);
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
                deleteTagsAction.setText(Messages.AbapTagsView_DeleteTagsAction_xmit);
                menu.appendToGroup(IGeneralContextMenuConstants.GROUP_EDIT, deleteTagsAction);
                if (atLeastOneSharedTag && tagsSharingPossible) {
                    unshareTagAction.setText(Messages.AbapTagsView_UnshareTagsAction_xmit);
                    menu.appendToGroup(MENU_SEP_GROUP_SHARE, unshareTagAction);
                }
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

    private ITagList buildNewTagListFromSelection(final Predicate<ITag> tagConditionCheck) {
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
                final ITag tag = IAbapTagsFactory.eINSTANCE.createTag();
                tag.setId(((ITag) selectedObj).getId());
                newTagList.getTags().add(tag);
            }

        }
        return newTagList;
    }

    private void handleConvertTag() {
        final ITag tag = getSelectedTag();
        if (tag == null) {
            return;
        }
        if (!MessageDialog.openQuestion(getSite().getShell(), Messages.AbapTagsView_ConvertToGlobalTagAction_xmit, NLS
            .bind(Messages.AbapTagsView_ConvertToGlobalTagPrompt_xmsg, tag.getName()))) {
            return;
        }
        if (!ProjectUtil.ensureLoggedOnToProject(lastProject).isOK()) {
            return;
        }
        final ITagList userTagList = IAbapTagsFactory.eINSTANCE.createTagList();
        userTagList.getTags().add(tag);
        final Job job = Job.create(Messages.AbapTagsView_ConvertToGlobalTagJobTitle_xmsg, monitor -> {
            final IStatus serviceStatus = tagsService.makeTagsGlobal(DestinationUtil.getDestinationId(lastProject),
                userTagList);
            if (!serviceStatus.isOK()) {
                Display.getDefault().asyncExec(() -> {
                    MessageDialog.openError(getSite().getShell(), Messages.AbapTagsView_ErrorMessageTitle_xtit,
                        Messages.AbapTagsView_ErrorDuringTagConversion_xmsg + serviceStatus.getMessage());
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
        final List<ITag> tagList = tagFolders.getFolderByType(isUserTag ? TagFolderType.USER : TagFolderType.GLOBAL)
            .getTags();
        if (isUserTag) {
            newTag.setOwner(DestinationUtil.getDestinationOwner(lastProject));
        }
        tagList.add(newTag);
        final EditTagDataDialog createDialog = new EditTagDataDialog(getSite().getShell(), newTag, tagList, isUserTag);
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
        final EditTagDataDialog createDialog = new EditTagDataDialog(getSite().getShell(), newTag, tagList, isUserTag);
        if (createDialog.open() == Window.OK) {
            createOrUpdateTag(newTag, isUserTag);
        } else {
            tagList.remove(newTag);
        }
    }

    private void handleDeleteTags() {
        final ITagList tagList = buildNewTagListFromSelection(null);
        if (!MessageDialog.openQuestion(getSite().getShell(), Messages.AbapTagsView_DeleteTagsMsgTitle_xtit,
            Messages.AbapTagsView_DeleteTagsPrompt_xmsg)) {
            return;
        }

        if (!ProjectUtil.ensureLoggedOnToProject(lastProject).isOK()) {
            return;
        }
        final Job deleteJob = Job.create(Messages.AbapTagsView_DeleteTagsJobTitle_xmsg, monitor -> {
            final IStatus status = tagsService.deleteTags(tagList, DestinationUtil.getDestinationId(lastProject),
                TagSearchScope.ALL);
            if (!status.isOK()) {
                MessageDialog.openError(getSite().getShell(), Messages.AbapTagsView_ErrorMessageTitle_xtit,
                    Messages.AbapTagsView_ErrorDuringTagDeletion_xmsg + status.getMessage());
            }
            refreshTags();
            monitor.done();
        });
        deleteJob.schedule();
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
            tagList = tagFolders.getFolderByType(isUserTag ? TagFolderType.USER : TagFolderType.GLOBAL).getTags();
        }
        final EditTagDataDialog createDialog = new EditTagDataDialog(getSite().getShell(), tag, tagList, isUserTag);
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

    private void handleUnshareTag() {
        final ITagList sharedTagList = buildNewTagListFromSelection(t -> t.isShared() && t.isEditable());
        final Job job = Job.create(Messages.AbapTagsView_UnshareTagsJob_xmsg, monitor -> {
            final IStatus serviceStatus = tagsService.unshareTags(DestinationUtil.getDestinationId(lastProject),
                sharedTagList);
            if (!serviceStatus.isOK()) {
                Display.getDefault().asyncExec(() -> {
                    MessageDialog.openError(getSite().getShell(), Messages.AbapTagsView_ErrorMessageTitle_xtit,
                        Messages.AbapTagsView_ErrorDuringUnsharing_xmsg + serviceStatus.getMessage());
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
        final Control viewerControl = tree;
        final Menu menu = menuMgr.createContextMenu(viewerControl);
        viewerControl.setMenu(menu);
        getSite().registerContextMenu(getViewSite().getId(), menuMgr, treeViewer);
    }

    private void initializeActions() {
        refreshAction = ActionFactory.createAction(AdtBaseUIResources.getString(IAdtBaseStrings.Refresh),
            AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.REFRESH), this::handleRefresh);
        createGlobalTagAction = ActionFactory.createAction(Messages.AbapTagsView_NewGlobalTagAction_xtol,
            AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.NEW_GLOBAL_TAG), () -> handleCreateTag(false));
        createUserTagAction = ActionFactory.createAction(Messages.AbapTagsView_NewUserTagAction_xtol, AbapTagsUIPlugin
            .getDefault()
            .getImageDescriptor(IImages.NEW_USER_TAG), () -> handleCreateTag(true));
        deleteTagsAction = ActionFactory.createAction(Messages.AbapTagsView_DeleteTagsAction_xmit, PlatformUI
            .getWorkbench()
            .getSharedImages()
            .getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE), this::handleDeleteTags);
        editTagAction = ActionFactory.createAction(Messages.AbapTagsView_EditTagAction_xmit, AdtBaseUIResources
            .getImageDescriptor(IAdtBaseImages.EDIT_ACTION), () -> handleEditTag(null));
        createSubTagAction = ActionFactory.createAction(Messages.AbapTagsView_AddSubTagAction_xmit, PlatformUI
            .getWorkbench()
            .getSharedImages()
            .getImageDescriptor(ISharedImages.IMG_OBJ_ADD), this::handleCreateTagOnSelectedNode);
        convertTagAction = ActionFactory.createAction(Messages.AbapTagsView_ConvertToGlobalTagAction_xmit, PlatformUI
            .getWorkbench()
            .getSharedImages()
            .getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD), this::handleConvertTag);
        shareTagAction = new ShareTagsAction();
        unshareTagAction = ActionFactory.createAction(Messages.AbapTagsView_UnshareTagAction_xmit, AdtBaseUIResources
            .getImageDescriptor(IAdtBaseImages.UNSHARE), this::handleUnshareTag);
    }

    private void initToolbar(final IActionBars actionBars) {
        actionBars.setGlobalActionHandler(org.eclipse.ui.actions.ActionFactory.REFRESH.getId(), refreshAction);

        final IToolBarManager tbm = actionBars.getToolBarManager();
        tbm.add(refreshAction);
        tbm.add(new Separator());
        tbm.add(createUserTagAction);
        tbm.add(createGlobalTagAction);
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
        tagLoadingJob = Job.create(Messages.AbapTagsView_TagsLoadingJobTitle_xmsg, monitor -> {
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
                AbapTagsView.this.treeViewer.setInput(tagFolders.getFolders(tagsSharingPossible));
                AbapTagsView.this.treeViewer.refresh();
                AbapTagsView.this.treeViewer.expandAll();
            });
            monitor.done();
        });
        tagLoadingJob.schedule();
    }

    private void setControlsEnabled(final boolean enabled) {
        createGlobalTagAction.setEnabled(enabled);
        createUserTagAction.setEnabled(enabled);
        refreshAction.setEnabled(enabled);
    }

    private void showTagsOfLastSelectedProject() {
        final IProject project = ProjectUtil.getCurrentAbapProject(lastSelection);
        if (project != lastProject) {
            lastProject = project;
            loadViewInput();
        }
        lastSelection = null;
    }

    private class ShareTagsAction extends Action {

        private List<String> userIdsOfSharedTag;
        private ITag tag;
        private String destinationId;

        public ShareTagsAction() {
            super(Messages.AbapTagsView_ShareTagAction_xmit, AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.SHARE));
        }

        @Override
        public void run() {
            tag = getSelectedTag();
            if (tag == null) {
                return;
            }
            destinationId = DestinationUtil.getDestinationId(lastProject);
            userIdsOfSharedTag = null;
            beforeSharingTag();
        }

        private void beforeSharingTag() {

            final Job fetchUserJob = new Job(Messages.AbapTagsView_FetchingUsersOfSharedTagJob_xmsg) {
                @Override
                protected IStatus run(final IProgressMonitor monitor) {
                    List<IUser> usersOfSharedTag = tagsService.getSharedUsers(destinationId, tag.getId());
                    if (usersOfSharedTag != null) {
                        userIdsOfSharedTag = usersOfSharedTag.stream().map(IUser::getName).collect(Collectors.toList());
                    }
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

        private void afterFetchingUsersOfSharedTag() {
            final IUserService userService = UserServiceFactory.createUserService();

            final List<String> usersForSharing = userService.showUserSelectionDialog(getSite().getShell(),
                Messages.AbapTagsView_SharedUserSelectionDialog_xtit, true, userIdsOfSharedTag, List.of(
                    lastDestinationOwner), destinationId);
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
            final Job job = Job.create(Messages.AbapTagsView_ShareTagsJob_xmsg, monitor -> {
                final IStatus serviceStatus = tagsService.shareTags(DestinationUtil.getDestinationId(lastProject),
                    sharedTagList);
                if (!serviceStatus.isOK()) {
                    Display.getDefault().asyncExec(() -> {
                        MessageDialog.openError(getSite().getShell(), Messages.AbapTagsView_ErrorMessageTitle_xtit,
                            Messages.AbapTagsView_ErrorDuringSharing_xmsg + serviceStatus.getMessage());
                    });
                }
                refreshTags();
                monitor.done();
            });
            job.schedule();
        }

    }

    private class TreeContentProvider implements ITreeContentProvider {

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

    /**
     * Custom view label provider for the Result Tree
     *
     * @author stockbal
     */
    private class ViewLabelProvider extends LabelProvider implements ILabelProvider, IStyledLabelProvider {

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
                        StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR, null));
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
}
