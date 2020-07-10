package com.devepos.adt.atm.ui.internal.views;

import java.util.ArrayList;
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
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.ViewPart;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.tags.IAbapTagsService;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.dialogs.EditTagDataDialog;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.util.IImages;
import com.devepos.adt.tools.base.AdtToolsBaseResources;
import com.devepos.adt.tools.base.IAdtToolsBaseImages;
import com.devepos.adt.tools.base.IAdtToolsBaseStrings;
import com.devepos.adt.tools.base.destinations.DestinationUtil;
import com.devepos.adt.tools.base.project.ProjectUtil;
import com.devepos.adt.tools.base.ui.IGeneralContextMenuConstants;
import com.devepos.adt.tools.base.ui.StylerFactory;
import com.devepos.adt.tools.base.ui.ViewDescriptionLabel;
import com.devepos.adt.tools.base.ui.action.ActionUtil;
import com.devepos.adt.tools.base.util.StringUtil;

/**
 * View to manage all available tags of a given ABAP project
 * 
 * @author stockbal
 */
public class AbapTagsView extends ViewPart {

	public static final String VIEW_ID = "com.devepos.adt.atm.ui.views.AbapTags"; //$NON-NLS-1$
	private Composite mainComposite;
	private Action refreshAction;
	private Action createUserTagAction;
	private Action createGlobalTagAction;
	private Action deleteTagsAction;
	private Action editTagAction;
	private Action createSubTagAction;
	private Action convertTagAction;
	private ViewDescriptionLabel viewLabel;
	private Tree tree;
	private Job tagLoadingJob;
	private final TagFolder[] treeInput;

	private TreeViewer treeViewer;

	private IProject lastProject;
	protected ISelection lastSelection;

	private final IAbapTagsService tagsService;

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

	public AbapTagsView() {
		this.tagsService = AbapTagsServiceFactory.createTagsService();
		this.treeInput = new TagFolder[2];
		this.treeInput[0] = new TagFolder(true);
		this.treeInput[1] = new TagFolder(false);
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

	@Override
	public void dispose() {
		getSite().getPage().removePostSelectionListener(this.selectionListener);
		super.dispose();
	}

	@Override
	public void createPartControl(final Composite parent) {
		this.mainComposite = new Composite(parent, SWT.NONE);
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

	private void clearInput() {
		this.treeViewer.setInput(null);
		this.treeViewer.refresh();
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

	private void showTagsOfLastSelectedProject() {
		final IProject project = ProjectUtil.getCurrentAbapProject(this.lastSelection);
		if (project != this.lastProject) {
			this.lastProject = project;
			loadViewInput();
		}
		this.lastSelection = null;
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

	private void fillContextMenu(final IMenuManager menu) {
		final IStructuredSelection sel = this.treeViewer.getStructuredSelection();
		if (sel.isEmpty()) {
			return;
		}
		menu.add(new Separator(IGeneralContextMenuConstants.GROUP_NEW));
		menu.add(new Separator(IGeneralContextMenuConstants.GROUP_EDIT));

		if (sel.size() == 1) {
			final Object selObj = sel.getFirstElement();
			if (selObj instanceof TagFolder) {
				if (((TagFolder) selObj) == this.treeInput[0]) {
					menu.appendToGroup(IGeneralContextMenuConstants.GROUP_NEW, this.createUserTagAction);
				} else {
					menu.appendToGroup(IGeneralContextMenuConstants.GROUP_NEW, this.createGlobalTagAction);
				}
				return;
			}
			menu.appendToGroup(IGeneralContextMenuConstants.GROUP_EDIT, this.editTagAction);
			final ITag tag = (ITag) selObj;
			if (!(tag.eContainer() instanceof ITag) && !StringUtil.isEmpty(tag.getOwner())) {
				menu.appendToGroup(IGeneralContextMenuConstants.GROUP_EDIT, this.convertTagAction);
			}
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

	private void initializeActions() {
		this.refreshAction = ActionUtil.createAction(AdtToolsBaseResources.getString(IAdtToolsBaseStrings.Refresh),
			AdtToolsBaseResources.getImageDescriptor(IAdtToolsBaseImages.REFRESH), this::handleRefresh);
		this.createGlobalTagAction = ActionUtil.createAction(Messages.AbapTagsView_NewGlobalTagAction_xtol,
			AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.NEW_GLOBAL_TAG), () -> handleCreateTag(false));
		this.createUserTagAction = ActionUtil.createAction(Messages.AbapTagsView_NewUserTagAction_xtol,
			AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.NEW_USER_TAG), () -> handleCreateTag(true));
		this.deleteTagsAction = ActionUtil.createAction(Messages.AbapTagsView_DeleteTagsAction_xmit,
			PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE),
			this::handleDeleteTags);
		this.editTagAction = ActionUtil.createAction(Messages.AbapTagsView_EditTagAction_xmit,
			AdtToolsBaseResources.getImageDescriptor(IAdtToolsBaseImages.EDIT_ACTION), () -> handleEditTag(null));
		this.createSubTagAction = ActionUtil.createAction(Messages.AbapTagsView_AddSubTagAction_xmit,
			PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ADD),
			this::handleCreateTagOnSelectedNode);
		this.convertTagAction = ActionUtil.createAction(Messages.AbapTagsView_ConvertToGlobalTagAction_xmit,
			PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD),
			this::handleConvertTag);
	}

	private void initToolbar(final IActionBars actionBars) {
		actionBars.setGlobalActionHandler(ActionFactory.REFRESH.getId(), this.refreshAction);

		final IToolBarManager tbm = actionBars.getToolBarManager();
		tbm.add(this.refreshAction);
		tbm.add(new Separator());
		tbm.add(this.createUserTagAction);
		tbm.add(this.createGlobalTagAction);
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
			this.viewLabel
				.updateLabel(NLS.bind(Messages.AbapTagsView_TagsNotLoadedInProject_xmsg, this.lastProject.getName()));
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
			this.viewLabel
				.updateLabel(NLS.bind(Messages.AbapTagsView_TagListInProject_xmsg, this.lastProject.getName()));
			return true;
		}
	}

	private void setControlsEnabled(final boolean enabled) {
		this.createGlobalTagAction.setEnabled(enabled);
		this.createUserTagAction.setEnabled(enabled);
		this.refreshAction.setEnabled(enabled);
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

			this.treeInput[0].getTags().clear();
			this.treeInput[1].getTags().clear();

			for (final ITag tag : tagList.getTags()) {
				if (StringUtil.isEmpty(tag.getOwner())) {
					this.treeInput[1].addTag(tag);
				} else {
					this.treeInput[0].addTag(tag);
				}
			}
			Display.getDefault().asyncExec(() -> {
				AbapTagsView.this.treeViewer.setInput(this.treeInput);
				AbapTagsView.this.treeViewer.refresh();
				AbapTagsView.this.treeViewer.expandAll();
			});
			monitor.done();
		});
		this.tagLoadingJob.schedule();
	}

	private void handleRefresh() {
		if (!checkProjectStatus(true)) {
			return;
		}
		refreshTags();
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
			final IStatus serviceStatus = this.tagsService
				.makeTagsGlobal(DestinationUtil.getDestinationId(this.lastProject), userTagList);
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
		final List<ITag> tagList = isUserTag ? this.treeInput[0].getTags() : this.treeInput[1].getTags();
		if (isUserTag) {
			final String destinationId = DestinationUtil.getDestinationId(this.lastProject);
			newTag.setOwner(DestinationUtil.getDestinationData(destinationId).getUser());
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

	private void createOrUpdateTag(final ITag newTag, final boolean isUserTag) {
		final ITagList updateList = IAbapTagsFactory.eINSTANCE.createTagList();
		updateList.getTags().add(newTag);

		if (!ProjectUtil.ensureLoggedOnToProject(this.lastProject).isOK()) {
			return;
		}
		final Job updateJob = Job.create(Messages.AbapTagsView_UpdateTagJobTitle_xmsg, monitor -> {
			final IStatus status = this.tagsService.updateTags(updateList,
				DestinationUtil.getDestinationId(this.lastProject),
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
			tagList = isUserTag ? this.treeInput[0].getTags() : this.treeInput[1].getTags();
		}
		final EditTagDataDialog createDialog = new EditTagDataDialog(getSite().getShell(), tag, tagList, isUserTag);
		if (createDialog.open() == Window.OK) {
			createOrUpdateTag(tag, isUserTag);
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
			final IStatus status = this.tagsService.deleteTags(tagList,
				DestinationUtil.getDestinationId(this.lastProject), TagSearchScope.ALL);
			if (!status.isOK()) {
				MessageDialog.openError(getSite().getShell(), Messages.AbapTagsView_ErrorMessageTitle_xtit,
					Messages.AbapTagsView_ErrorDuringTagDeletion_xmsg + status.getMessage());
			}
			refreshTags();
			monitor.done();
		});
		deleteJob.schedule();
	}

	private ITag getSelectedTag() {
		final IStructuredSelection sel = this.treeViewer.getStructuredSelection();
		if (sel.isEmpty() || sel.size() > 1) {
			return null;
		}
		return (ITag) sel.getFirstElement();
	}

	private class TagFolder {
		private final boolean hasUserTags;
		private final List<ITag> tags;

		public TagFolder(final boolean hasUserTags) {
			this.tags = new ArrayList<>();
			this.hasUserTags = hasUserTags;
		}

		public void addTag(final ITag tag) {
			this.tags.add(tag);
		}

		public String getName() {
			return this.hasUserTags ? Messages.AbapTagsView_UserTagsFolder_xlbl
				: Messages.AbapTagsView_GlobalTagsFolder_xlbl;
		}

		public Image getImage() {
			return AbapTagsUIPlugin.getDefault()
				.getImage(this.hasUserTags ? IImages.USER_TAGS_FOLDER : IImages.GLOBAL_TAGS_FOLDER);
		}

		public List<ITag> getTags() {
			return this.tags;
		}

		public boolean hasTags() {
			return !this.tags.isEmpty();
		}

	}

	private class TreeContentProvider implements ITreeContentProvider {

		private TagFolder[] input;

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
