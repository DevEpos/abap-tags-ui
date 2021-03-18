package com.devepos.adt.atm.ui.internal.views;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
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
import com.devepos.adt.atm.ui.internal.TagFolder;
import com.devepos.adt.atm.ui.internal.dialogs.EditTagDataDialog;
import com.devepos.adt.atm.ui.internal.help.HelpContexts;
import com.devepos.adt.atm.ui.internal.help.HelpUtil;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.util.IImages;
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
//	private static final String MENU_SEP_GROUP_SHARE = "group.share"; //$NON-NLS-1$
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
			if (this.isUpdatingSelection) {
				return;
			}
			try {
				this.isUpdatingSelection = true;
				// check whether the selection change is on this view
				if (AbapTagsView.this == part) {
					return;
				}
				// update selection
				AbapTagsView.this.lastSelection = selection;
				// Further processing will only be done if this view is visible
				if (!getViewSite().getPage().isPartVisible(AbapTagsView.this)) {
					return;
				}
				// refresh view
				showTagsOfLastSelectedProject();
			} finally {
				this.isUpdatingSelection = false;
			}
		}

	};
//	private Action shareTagAction;
//	private Action unshareTagAction;

	private final TagFolder[] tagFolders;

	private Job tagLoadingJob;
	private final IAbapTagsService tagsService;

	private Tree tree;

	private TreeViewer treeViewer;
	private ViewDescriptionLabel viewLabel;

	public AbapTagsView() {
		this.tagsService = AbapTagsServiceFactory.createTagsService();
		this.tagFolders = TagFolder.values();
	}

	@Override
	public void createPartControl(final Composite parent) {
		this.mainComposite = new Composite(parent, SWT.NONE);
		HelpUtil.setHelp(this.mainComposite, HelpContexts.TAGS);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(this.mainComposite);
		GridLayoutFactory.swtDefaults().margins(0, 0).applyTo(this.mainComposite);

		createViewer(this.mainComposite);
		this.viewLabel = new ViewDescriptionLabel(this.mainComposite);
		clearInput();

		initializeActions();

		initToolbar(getViewSite().getActionBars());
		hookContextMenu();

		getSite().setSelectionProvider(this.treeViewer);
		getSite().getPage().addPostSelectionListener(this.selectionListener);
		checkProjectStatus(false);
	}

	@Override
	public void dispose() {
		getSite().getPage().removePostSelectionListener(this.selectionListener);
		super.dispose();
	}

	@Override
	public void init(final IViewSite site) throws PartInitException {
		super.init(site);
		this.lastSelection = getSite().getPage().getSelection();
	}

	@Override
	public void setFocus() {
		if (this.tree != null && !this.tree.isDisposed()) {
			this.tree.setFocus();
		}
		if (this.lastSelection != null) {
			showTagsOfLastSelectedProject();
		}
	}

	private boolean checkProjectStatus(final boolean ensureLogon) {
		boolean tagsFeatureStatusUnknown = false;
		if (this.lastProject == null) {
			this.viewLabel.updateLabel(Messages.AbapTagsView_NoProjectAvailable_xmsg);
			clearInput();
			setControlsEnabled(false);
			return false;
		}
		// check if the user is logged on to the project
		if (ensureLogon) {
			if (!ProjectUtil.ensureLoggedOnToProject(this.lastProject).isOK()) {
				tagsFeatureStatusUnknown = true;
			}
		} else {
			if (!ProjectUtil.isLoggedOnToProject(this.lastProject)) {
				tagsFeatureStatusUnknown = true;
			}
		}
		if (tagsFeatureStatusUnknown) {
			this.viewLabel.updateLabel(NLS.bind(Messages.AbapTagsView_TagsNotLoadedInProject_xmsg, this.lastProject.getName()));
			clearInput();
			setControlsEnabled(true);
			return false;
		}
		final IStatus tagFeatureStatus = this.tagsService.testTagsFeatureAvailability(this.lastProject);
		if (!tagFeatureStatus.isOK()) {
			this.viewLabel.updateLabel(tagFeatureStatus.getMessage());
			clearInput();
			setControlsEnabled(false);
			return false;
		} else {
			setControlsEnabled(true);
			this.viewLabel.updateLabel(NLS.bind(Messages.AbapTagsView_TagListInProject_xmsg, this.lastProject.getName()));
			return true;
		}
	}

	private void clearInput() {
		this.treeViewer.setInput(null);
		this.treeViewer.refresh();
	}

	private void createOrUpdateTag(final ITag newTag, final boolean isUserTag) {
		final ITagList updateList = IAbapTagsFactory.eINSTANCE.createTagList();
		updateList.getTags().add(newTag);

		if (!ProjectUtil.ensureLoggedOnToProject(this.lastProject).isOK()) {
			return;
		}
		final Job updateJob = Job.create(Messages.AbapTagsView_UpdateTagJobTitle_xmsg, monitor -> {
			final IStatus status = this.tagsService.updateTags(updateList, DestinationUtil.getDestinationId(this.lastProject),
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
		this.treeViewer = new TreeViewer(parent, SWT.V_SCROLL | SWT.MULTI);
		this.tree = this.treeViewer.getTree();
		GridDataFactory.fillDefaults().grab(true, true).applyTo(this.tree);
		this.treeViewer.setContentProvider(new TreeContentProvider());
		this.treeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new ViewLabelProvider()));
		this.treeViewer.setUseHashlookup(true);
		this.treeViewer.addOpenListener(e -> {
			final ISelection sel = e.getSelection();
			if (sel == null || sel.isEmpty() || !(sel instanceof IStructuredSelection)) {
				return;
			}
			final IStructuredSelection structeredSel = (IStructuredSelection) sel;
			if (structeredSel.size() > 1) {
				return;
			}
			final Object selObj = structeredSel.getFirstElement();
			if (selObj instanceof ITag) {
				handleEditTag((ITag) selObj);
			}
		});
	}

	private void fillContextMenu(final IMenuManager menu) {
		final IStructuredSelection sel = this.treeViewer.getStructuredSelection();
		if (sel.isEmpty()) {
			return;
		}
		menu.add(new Separator(IGeneralContextMenuConstants.GROUP_NEW));
		menu.add(new Separator(IGeneralContextMenuConstants.GROUP_EDIT));
//		menu.add(new Separator(MENU_SEP_GROUP_SHARE));

		if (sel.size() == 1) {
			final Object selObj = sel.getFirstElement();
			if (selObj instanceof TagFolder) {
				final TagFolder folder = (TagFolder) selObj;
				if (folder == TagFolder.USER) {
					menu.appendToGroup(IGeneralContextMenuConstants.GROUP_NEW, this.createUserTagAction);
				} else if (folder == TagFolder.GLOBAL) {
					menu.appendToGroup(IGeneralContextMenuConstants.GROUP_NEW, this.createGlobalTagAction);
				}
				return;
			}
			menu.appendToGroup(IGeneralContextMenuConstants.GROUP_EDIT, this.editTagAction);
			final ITag tag = (ITag) selObj;
//			if (!(tag.eContainer() instanceof ITag) && !StringUtil.isEmpty(tag.getOwner())) {
//				menu.appendToGroup(IGeneralContextMenuConstants.GROUP_EDIT, this.convertTagAction);
//				menu.appendToGroup(MENU_SEP_GROUP_SHARE, this.shareTagAction);
//				if (tag.isShared()) {
//					menu.appendToGroup(MENU_SEP_GROUP_SHARE, this.unshareTagAction);
//				}
//			}
			this.deleteTagsAction.setText(Messages.AbapTagsView_DeleteTagAction_xmit);
			menu.appendToGroup(IGeneralContextMenuConstants.GROUP_EDIT, this.deleteTagsAction);
			menu.appendToGroup(IGeneralContextMenuConstants.GROUP_NEW, this.createSubTagAction);
		} else {
			for (final Object selObj : sel.toList()) {
				if (selObj instanceof TagFolder) {
					return;
				}
			}
			this.deleteTagsAction.setText(Messages.AbapTagsView_DeleteTagsAction_xmit);
			menu.appendToGroup(IGeneralContextMenuConstants.GROUP_EDIT, this.deleteTagsAction);
		}
	}

	private ITag getSelectedTag() {
		final IStructuredSelection sel = this.treeViewer.getStructuredSelection();
		if (sel.isEmpty() || sel.size() > 1) {
			return null;
		}
		return (ITag) sel.getFirstElement();
	}

	private void handleConvertTag() {
		final ITag tag = getSelectedTag();
		if (tag == null) {
			return;
		}
		if (!MessageDialog.openQuestion(getSite().getShell(), Messages.AbapTagsView_ConvertToGlobalTagAction_xmit,
			NLS.bind(Messages.AbapTagsView_ConvertToGlobalTagPrompt_xmsg, tag.getName()))) {
			return;
		}
		if (!ProjectUtil.ensureLoggedOnToProject(this.lastProject).isOK()) {
			return;
		}
		final ITagList userTagList = IAbapTagsFactory.eINSTANCE.createTagList();
		userTagList.getTags().add(tag);
		final Job job = Job.create(Messages.AbapTagsView_ConvertToGlobalTagJobTitle_xmsg, monitor -> {
			final IStatus serviceStatus = this.tagsService.makeTagsGlobal(DestinationUtil.getDestinationId(this.lastProject),
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
		if (this.treeViewer.getInput() == null) {
			return;
		}
		final ITag newTag = IAbapTagsFactory.eINSTANCE.createTag();
		final List<ITag> tagList = isUserTag ? TagFolder.USER.getTags() : TagFolder.GLOBAL.getTags();
		if (isUserTag) {
			newTag.setOwner(DestinationUtil.getDestinationOwner(this.lastProject));
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
		final ITagList tagList = IAbapTagsFactory.eINSTANCE.createTagList();
		final IStructuredSelection sel = this.treeViewer.getStructuredSelection();
		for (final Object selectedObj : sel.toList()) {
			if (selectedObj instanceof ITag) {
				final ITag tag = IAbapTagsFactory.eINSTANCE.createTag();
				tag.setId(((ITag) selectedObj).getId());
				tagList.getTags().add(tag);
			}

		}
		if (!MessageDialog.openQuestion(getSite().getShell(), Messages.AbapTagsView_DeleteTagsMsgTitle_xtit,
			Messages.AbapTagsView_DeleteTagsPrompt_xmsg)) {
			return;
		}

		if (!ProjectUtil.ensureLoggedOnToProject(this.lastProject).isOK()) {
			return;
		}
		final Job deleteJob = Job.create(Messages.AbapTagsView_DeleteTagsJobTitle_xmsg, monitor -> {
			final IStatus status = this.tagsService.deleteTags(tagList, DestinationUtil.getDestinationId(this.lastProject),
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
			tagList = isUserTag ? this.tagFolders[0].getTags() : this.tagFolders[1].getTags();
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

//	private void handleShareTag() {
//		final ITag tag = getSelectedTag();
//		if (tag == null) {
//			return;
//		}
//		final IUserService userService = UserServiceFactory.createUserService();
//		final List<String> usersForSharing = userService.showUserSelectionDialog(getSite().getShell(), "Select Users for Sharing",
//			true, null, DestinationUtil.getDestinationId(this.lastProject));
//		if (usersForSharing == null || usersForSharing.isEmpty()) {
//			return;
//		}
//		final ITagList sharedTagList = IAbapTagsFactory.eINSTANCE.createTagList();
//		final ITag sharedTag = IAbapTagsFactory.eINSTANCE.createTag();
//		sharedTag.setId(tag.getId());
//		sharedTagList.getTags().add(sharedTag);
//		usersForSharing.forEach(u -> {
//			final IUser user = IAdtBaseFactory.eINSTANCE.createUser();
//			user.setName(u);
//			sharedTag.getSharedUsers().add(user);
//		});
//		final Job job = Job.create("Share Tag...", monitor -> {
//			final IStatus serviceStatus = this.tagsService.shareTags(DestinationUtil.getDestinationId(this.lastProject),
//				sharedTagList);
//			if (!serviceStatus.isOK()) {
//				Display.getDefault().asyncExec(() -> {
//					MessageDialog.openError(getSite().getShell(), Messages.AbapTagsView_ErrorMessageTitle_xtit,
//						"During sharing the tag, the following error occurred\n\nError:\n" + serviceStatus.getMessage());
//				});
//			}
//			refreshTags();
//			monitor.done();
//		});
//		job.schedule();
//	}

	private void handleUnshareTag() {
		final ITag tag = getSelectedTag();
		if (tag == null) {
			return;
		}
	}

	private void hookContextMenu() {
		final MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);

		menuMgr.addMenuListener(menu -> {
			fillContextMenu(menu);
		});
		final Control viewerControl = this.tree;
		final Menu menu = menuMgr.createContextMenu(viewerControl);
		viewerControl.setMenu(menu);
		getSite().registerContextMenu(getViewSite().getId(), menuMgr, this.treeViewer);
	}

	private void initializeActions() {
		this.refreshAction = ActionFactory.createAction(AdtBaseUIResources.getString(IAdtBaseStrings.Refresh),
			AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.REFRESH), this::handleRefresh);
		this.createGlobalTagAction = ActionFactory.createAction(Messages.AbapTagsView_NewGlobalTagAction_xtol,
			AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.NEW_GLOBAL_TAG), () -> handleCreateTag(false));
		this.createUserTagAction = ActionFactory.createAction(Messages.AbapTagsView_NewUserTagAction_xtol,
			AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.NEW_USER_TAG), () -> handleCreateTag(true));
		this.deleteTagsAction = ActionFactory.createAction(Messages.AbapTagsView_DeleteTagsAction_xmit,
			PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE),
			this::handleDeleteTags);
		this.editTagAction = ActionFactory.createAction(Messages.AbapTagsView_EditTagAction_xmit,
			AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.EDIT_ACTION), () -> handleEditTag(null));
		this.createSubTagAction = ActionFactory.createAction(Messages.AbapTagsView_AddSubTagAction_xmit,
			PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ADD),
			this::handleCreateTagOnSelectedNode);
		this.convertTagAction = ActionFactory.createAction(Messages.AbapTagsView_ConvertToGlobalTagAction_xmit,
			PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD),
			this::handleConvertTag);
//		this.shareTagAction = ActionFactory.createAction("Share Tag...",
//			AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.SHARE), this::handleShareTag);
//		this.unshareTagAction = ActionFactory.createAction("Unshare Tag",
//			AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.UNSHARE), this::handleShareTag);
	}

	private void initToolbar(final IActionBars actionBars) {
		actionBars.setGlobalActionHandler(org.eclipse.ui.actions.ActionFactory.REFRESH.getId(), this.refreshAction);

		final IToolBarManager tbm = actionBars.getToolBarManager();
		tbm.add(this.refreshAction);
		tbm.add(new Separator());
		tbm.add(this.createUserTagAction);
		tbm.add(this.createGlobalTagAction);
	}

	private void loadViewInput() {
		if (!checkProjectStatus(false)) {
			return;
		}
		refreshTags();
	}

	private void refreshTags() {
		if (this.tagLoadingJob != null && this.tagLoadingJob.getResult() == null) {
			this.tagLoadingJob.cancel();
		}
		this.tagLoadingJob = Job.create(Messages.AbapTagsView_TagsLoadingJobTitle_xmsg, monitor -> {
			final ITagList tagList = this.tagsService.readTags(DestinationUtil.getDestinationId(this.lastProject),
				TagSearchScope.ALL, true);

			for (final TagFolder folder : TagFolder.values()) {
				folder.getTags().clear();
			}

			final String destinationOwner = DestinationUtil.getDestinationOwner(this.lastProject);

			for (final ITag tag : tagList.getTags()) {
				if (StringUtil.isEmpty(tag.getOwner())) {
					TagFolder.GLOBAL.getTags().add(tag);
				} else if (tag.getOwner().equals(destinationOwner)) {
					TagFolder.USER.getTags().add(tag);
//				} else if (tag.isShared()) {
//					TagFolder.SHARED.getTags().add(tag);
				}
			}
			Display.getDefault().asyncExec(() -> {
				AbapTagsView.this.treeViewer.setInput(this.tagFolders);
				AbapTagsView.this.treeViewer.refresh();
				AbapTagsView.this.treeViewer.expandAll();
			});
			monitor.done();
		});
		this.tagLoadingJob.schedule();
	}

	private void setControlsEnabled(final boolean enabled) {
		this.createGlobalTagAction.setEnabled(enabled);
		this.createUserTagAction.setEnabled(enabled);
		this.refreshAction.setEnabled(enabled);
	}

	private void showTagsOfLastSelectedProject() {
		final IProject project = ProjectUtil.getCurrentAbapProject(this.lastSelection);
		if (project != this.lastProject) {
			this.lastProject = project;
			loadViewInput();
		}
		this.lastSelection = null;
	}

	private class TreeContentProvider implements ITreeContentProvider {

		private TagFolder[] input;

		@Override
		public Object[] getChildren(final Object parentElement) {
			if (parentElement instanceof TagFolder) {
				return ((TagFolder) parentElement).getTags().toArray();
			} else if (parentElement instanceof ITag) {
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
				if (container != null && container instanceof ITag) {
					return container;
				} else {
					return findParentInTopLevelNodes((ITag) element);
				}
			}
			return null;
		}

		@Override
		public boolean hasChildren(final Object element) {
			if (element instanceof TagFolder) {
				return ((TagFolder) element).hasTags();
			} else if (element instanceof ITag) {
				return !((ITag) element).getChildTags().isEmpty();
			}
			return false;
		}

		@Override
		public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
			if (newInput instanceof TagFolder[]) {
				this.input = (TagFolder[]) newInput;
			} else {
				this.input = null;
			}
		}

		private Object findParentInTopLevelNodes(final ITag element) {
			if (this.input == null) {
				return null;
			}
			for (final TagFolder folder : this.input) {
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
			} else if (element instanceof ITag) {
				final ITag tag = (ITag) element;
				return AbapTagsUIPlugin.getDefault()
					.getImage(!StringUtil.isEmpty(tag.getOwner()) ? IImages.USER_TAG : IImages.TAG);
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
			} else if (element instanceof ITag) {
				return ((ITag) element).getName();
			}
			return ""; //$NON-NLS-1$
		}
	}
}
