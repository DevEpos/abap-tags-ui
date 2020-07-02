package com.devepos.adt.atm.ui.internal.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.ViewPart;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.tags.IAbapTagsService;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.util.IImages;
import com.devepos.adt.tools.base.AdtToolsBaseResources;
import com.devepos.adt.tools.base.IAdtToolsBaseImages;
import com.devepos.adt.tools.base.IAdtToolsBaseStrings;
import com.devepos.adt.tools.base.destinations.DestinationUtil;
import com.devepos.adt.tools.base.project.ProjectUtil;
import com.devepos.adt.tools.base.ui.StylerFactory;
import com.devepos.adt.tools.base.ui.ViewDescriptionLabel;
import com.devepos.adt.tools.base.ui.action.ActionUtil;
import com.devepos.adt.tools.base.ui.tree.ITreeNode;
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
	private Action cancelRefreshAction;
	private Action createUserTagAction;
	private Action createGlobalTagAction;
	private ViewDescriptionLabel viewLabel;
	private Tree tree;
	private Job tagLoadingJob;

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
				// check whether the selection change is on the AbapGit Repositories view
				if (AbapTagsView.this == part) {
					return;
				}
				// update selection
				AbapTagsView.this.lastSelection = selection;
				// check whether AbapGit Repositories view is visible in the workbench
				if (!getViewSite().getPage().isPartVisible(AbapTagsView.this)) {
					return;
				}
				// refresh view
				final IProject project = ProjectUtil.getCurrentAbapProject(AbapTagsView.this.lastSelection);
				if (project != AbapTagsView.this.lastProject) {
					AbapTagsView.this.lastProject = project;
					loadViewInput();
				}
			} finally {
				this.isUpdatingSelection = false;
			}
		}
	};

	public AbapTagsView() {
		this.tagsService = AbapTagsServiceFactory.createTagsService();

	}

	@Override
	public void setFocus() {
		if (this.tree != null && !this.tree.isDisposed()) {
			this.tree.setFocus();
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
	}

	private void hookContextMenu() {
		// TODO Auto-generated method stub
	}

	private void initializeActions() {
		this.refreshAction = ActionUtil.createAction(AdtToolsBaseResources.getString(IAdtToolsBaseStrings.Refresh),
			AdtToolsBaseResources.getImageDescriptor(IAdtToolsBaseImages.REFRESH), this::onRefreshInput);
		this.createGlobalTagAction = ActionUtil.createAction("New Global Tag",
			AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.NEW_GLOBAL_TAG), this::onCreateGlobalTag);
		this.createUserTagAction = ActionUtil.createAction("New User Tag",
			AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.NEW_USER_TAG), this::onCreateUserTag);
		this.cancelRefreshAction = ActionUtil.createAction("Cancel",
			PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_STOP),
			this::onCancelRefresh);
		this.cancelRefreshAction.setEnabled(false);
	}

	private void initToolbar(final IActionBars actionBars) {
		actionBars.setGlobalActionHandler(ActionFactory.REFRESH.getId(), this.refreshAction);

		final IToolBarManager tbm = actionBars.getToolBarManager();
		tbm.add(this.refreshAction);
		tbm.add(this.cancelRefreshAction);
		tbm.add(new Separator());
		tbm.add(this.createUserTagAction);
		tbm.add(this.createGlobalTagAction);
	}

	private boolean checkProjectStatus(final boolean ensureLogon) {
		boolean projectStatusUnknown = false;
		if (this.lastProject == null) {
			this.viewLabel.updateLabel("No ABAP Project available");
			clearInput();
			return false;
		}
		// check if the user is logged on to the project
		if (ensureLogon) {
			if (!ProjectUtil.ensureLoggedOnToProject(this.lastProject).isOK()) {
				projectStatusUnknown = true;
			}
		} else {
			if (!ProjectUtil.isLoggedOnToProject(this.lastProject)) {
				projectStatusUnknown = true;
			}
		}
		if (projectStatusUnknown) {
			this.viewLabel.updateLabel("ABAP Tags in Project " + this.lastProject.getName()
				+ " are not loaded, yet. Press Refresh to load the available tags");
			clearInput();
			return false;
		}
		final IStatus tagFeatureStatus = this.tagsService.testTagsFeatureAvailability(this.lastProject);
		if (!tagFeatureStatus.isOK()) {
			this.viewLabel.updateLabel(tagFeatureStatus.getMessage());
			clearInput();
			return false;
		} else {
			this.viewLabel.updateLabel("ABAP Tags in Project " + this.lastProject.getName());
			return true;
		}
	}

	private void loadViewInput() {
		if (!checkProjectStatus(true)) {
			return;
		}
		refreshTags();
	}

	private void refreshTags() {
		if (this.tagLoadingJob != null && this.tagLoadingJob.getResult() == null) {
			this.tagLoadingJob.cancel();
		}
		this.tagLoadingJob = Job.create("Loading ABAP Tags...", monitor -> {
			final ITagList tagList = this.tagsService.readTags(DestinationUtil.getDestinationId(this.lastProject),
				TagSearchScope.ALL, true);
			final TagFolder[] input = new TagFolder[2];
			input[0] = new TagFolder(true);
			input[1] = new TagFolder(false);

			for (final ITag tag : tagList.getTags()) {
				if (StringUtil.isEmpty(tag.getOwner())) {
					input[1].addTag(tag);
				} else {
					input[0].addTag(tag);
				}
			}
			Display.getDefault().asyncExec(() -> {
				AbapTagsView.this.treeViewer.setInput(input);
				AbapTagsView.this.treeViewer.refresh();
				AbapTagsView.this.treeViewer.expandAll();
			});
			monitor.done();
		});
		this.tagLoadingJob.addJobChangeListener(new JobChangeAdapter() {
			@Override
			public void running(final IJobChangeEvent event) {
				AbapTagsView.this.cancelRefreshAction.setEnabled(true);
			}

			@Override
			public void done(final IJobChangeEvent event) {
				AbapTagsView.this.cancelRefreshAction.setEnabled(false);
			}
		});
		this.tagLoadingJob.schedule();
	}

	private void onCancelRefresh() {
		if (this.tagLoadingJob != null && this.tagLoadingJob.getResult() == null) {
			this.tagLoadingJob.cancel();
			this.tagLoadingJob = null;
		}
	}

	private void onRefreshInput() {
		if (!checkProjectStatus(true)) {
			return;
		}
		refreshTags();
	}

	private void onCreateUserTag() {

	}

	private void onCreateGlobalTag() {

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
			return this.hasUserTags ? "User Tags" : "Global Tags";
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
			final ITreeNode searchResult = (ITreeNode) element;

			return searchResult.getName();
		}
	}
}
