package com.devepos.adt.atm.ui.internal.search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.model.abaptags.TagInfoType;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.preferences.ITaggedObjectSearchPrefs;
import com.devepos.adt.atm.ui.internal.tree.TagFilter;
import com.devepos.adt.atm.ui.internal.tree.TagLabelProvider;
import com.devepos.adt.atm.ui.internal.tree.TagTreeContentProvider;
import com.devepos.adt.tools.base.destinations.DestinationUtil;
import com.devepos.adt.tools.base.project.IAbapProjectProvider;
import com.devepos.adt.tools.base.project.ProjectUtil;
import com.devepos.adt.tools.base.ui.project.ProjectInput;
import com.devepos.adt.tools.base.util.StatusUtil;

public class TaggedObjectSearchPage extends DialogPage implements ISearchPage {

	public static final String PAGE_ID = "com.devepos.adt.atm.ui.searchpage.tags"; //$NON-NLS-1$
	private static final String LAST_PROJECT_PREF = "com.devepos.adt.abaptags.ui.taggedObjectSearch.lastProject"; //$NON-NLS-1$
	private ISearchPageContainer container;
	private CheckboxTreeViewer tagsTreeViewer;
	private final ITagList tagList = IAbapTagsFactory.eINSTANCE.createTagList();
	private Tree tagsTree;
	private final Set<ITag> checkedTags;
	private Composite mainComposite;
	private ProjectInput projectInput;
	private IAbapProjectProvider projectProvider;
	private Composite statusArea;
	private Label searchStatusImageLabel;
	private Label searchStatusTextLabel;
	private IStatus currentStatus;
	private IProject currentProject;
	private AggregateValidationStatus projectAggrValStatus;
	private Job loadTagsJob;
	private Text filterText;
	private final TagFilter patternFilter;
	private Button matchAllTagsButton;
	private final IPreferenceStore prefStore;
	private List<String> previouslyCheckedTagIds;

	public TaggedObjectSearchPage() {
		this.prefStore = AbapTagsUIPlugin.getDefault().getPreferenceStore();
		this.prefStore.setDefault(LAST_PROJECT_PREF, ""); //$NON-NLS-1$
		this.prefStore.setDefault(ITaggedObjectSearchPrefs.MAX_RESULTS, 50);
		this.checkedTags = new HashSet<>();
		this.patternFilter = new TagFilter();
	}

	@Override
	public void createControl(final Composite parent) {
		initializeDialogUnits(parent);
		this.mainComposite = new SearchComposite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(this.mainComposite);
		GridLayoutFactory.swtDefaults().applyTo(this.mainComposite);
		setControl(this.mainComposite);

		createTagsTree(this.mainComposite);
		final Label separator = new Label(this.mainComposite, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setVisible(false);
		GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 5).grab(true, false).applyTo(separator);

		createProjectInput(this.mainComposite);
		createStatusArea(this.mainComposite);
		createBindings(this.mainComposite);

		setInitialData();
		updateOKStatus();

		if (this.tagsTree != null && !this.tagsTree.isDisposed()) {
			this.tagsTree.setFocus();
		}
	}

	public void setInputFromPreviousQuery(final TaggedObjectSearchQuery query) {
		this.projectInput.setProjectName(query.getProjectProvider().getProjectName());
		this.matchAllTagsButton.setSelection(query.getSearchParams().isMatchesAllTags());
		this.previouslyCheckedTagIds = query.getSearchParams().getTagIds();
	}

	@Override
	public boolean performAction() {
		if (this.currentStatus != null && this.currentStatus.getSeverity() == IStatus.ERROR) {
			setStatus(this.currentStatus);
			updateOKStatus();
			return false;
		}
		if (this.checkedTags.isEmpty()) {
			updateOKStatus();
			return false;
		}
		this.prefStore.setValue(LAST_PROJECT_PREF, this.projectProvider.getProjectName());

		final ITaggedObjectSearchParams searchParams = IAbapTagsFactory.eINSTANCE.createTaggedObjectSearchParams();
		searchParams.setMaxResults(this.prefStore.getInt(ITaggedObjectSearchPrefs.MAX_RESULTS));
		searchParams.setWithTagInfo(true);
		searchParams.setTagInfoType(TagInfoType.CHILDREN);

		this.checkedTags.forEach(tag -> searchParams.addTag(tag));
		searchParams.setMatchesAllTags(this.matchAllTagsButton.getSelection());

		final TaggedObjectSearchQuery searchQuery = new TaggedObjectSearchQuery(searchParams);
		searchQuery.setProjectProvider(this.projectProvider);

		NewSearchUI.runQueryInBackground(searchQuery);
		return true;
	}

	@Override
	public void setContainer(final ISearchPageContainer container) {
		this.container = container;
	}

	private void setInitialData() {
		if (this.projectInput != null) {
			String projectName = null;

			final IProject currentAbapProject = ProjectUtil.getCurrentAbapProject();
			if (currentAbapProject != null) {
				projectName = currentAbapProject.getName();
			}
			if (projectName == null || projectName.isEmpty()) {
				projectName = this.prefStore.getString(LAST_PROJECT_PREF);
			}
			this.projectInput.setProjectName(projectName);
		}
	}

	private void createProjectInput(final Composite parent) {
		this.projectInput = new ProjectInput();
		this.projectProvider = this.projectInput.getProjectProvider();

		this.projectInput.createControl(parent);
		this.projectInput.addProjectValidator(project -> {
			final IStatus loggedOnStatus = ProjectUtil.ensureLoggedOnToProject(project);
			if (!loggedOnStatus.isOK()) {
				return loggedOnStatus;
			}
			return AbapTagsServiceFactory.createTagsService().testTagsFeatureAvailability(project);
		});
	}

	private void createTagsTree(final Composite parent) {
		final Group tagsGroup = new Group(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(tagsGroup);
		GridLayoutFactory.swtDefaults().applyTo(tagsGroup);
		tagsGroup.setText(Messages.TaggedObjectSearchPage_TagsGroup_xtit);

		createFilterText(tagsGroup);

		this.tagsTreeViewer = new CheckboxTreeViewer(tagsGroup, SWT.V_SCROLL | SWT.MULTI | SWT.BORDER);
		this.tagsTree = this.tagsTreeViewer.getTree();
		this.tagsTreeViewer.addFilter(this.patternFilter);
		this.tagsTreeViewer.setContentProvider(new TagTreeContentProvider());
		this.tagsTreeViewer
			.setLabelProvider(new DelegatingStyledCellLabelProvider(new TagLabelProvider(false, true, false)));
		this.tagsTreeViewer.setInput(this.tagList);
		this.tagsTree.setBackgroundMode(SWT.INHERIT_DEFAULT);
		GridDataFactory.fillDefaults().grab(true, true).hint(1, 150).applyTo(this.tagsTree);

		this.tagsTreeViewer.addCheckStateListener(e -> {
			if (e.getChecked()) {
				this.checkedTags.add((ITag) e.getElement());
			} else {
				this.checkedTags.remove(e.getElement());
			}
			updateOKStatus();
		});

		this.matchAllTagsButton = new Button(tagsGroup, SWT.CHECK);
		this.matchAllTagsButton.setText(Messages.TaggedObjectSearchPage_MatchAllTags_xckl);
		GridDataFactory.fillDefaults().applyTo(this.matchAllTagsButton);
	}

	private void createFilterText(final Composite parent) {
		this.filterText = new Text(parent, SWT.SINGLE | SWT.BORDER | SWT.SEARCH | SWT.ICON_CANCEL);
		GridDataFactory.fillDefaults().grab(true, false).indent(SWT.DEFAULT, 10).applyTo(this.filterText);
		this.filterText.setMessage(Messages.TaggedObjectSearchPage_TagsTreeFilterText_xmsg);

		this.filterText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				// on a CR we want to transfer focus to the list
				final boolean hasItems = TaggedObjectSearchPage.this.tagsTree.getItemCount() > 0;
				if (hasItems && e.keyCode == SWT.ARROW_DOWN) {
					TaggedObjectSearchPage.this.tagsTree.setFocus();
				} else if (e.character == SWT.CR) {
					return;
				}
			}
		});
		this.filterText.addModifyListener(e -> {
			this.patternFilter.setPattern(this.filterText.getText());
			this.tagsTreeViewer.refresh();
			setCheckedElements();
		});

	}

	private void determineCheckedTagsFromPreviousSearch() {
		if (this.previouslyCheckedTagIds == null || this.previouslyCheckedTagIds.isEmpty()) {
			return;
		}
		if (this.tagList != null && !this.tagList.getTags().isEmpty()) {
			this.tagList.getTags().stream().forEach(this::findAndSetTagAsChecked);
			if (!this.checkedTags.isEmpty()) {
				setCheckedElements();
				this.tagsTreeViewer.refresh();
				updateOKStatus();
			}
		}
		this.previouslyCheckedTagIds = null;
	}

	private void findAndSetTagAsChecked(final ITag tag) {
		if (this.previouslyCheckedTagIds.contains(tag.getId())) {
			this.checkedTags.add(tag);
		}
		for (final ITag childTag : tag.getChildTags()) {
			findAndSetTagAsChecked(childTag);
		}
	}

	private void setCheckedElements() {
		for (final Object checkedItem : this.checkedTags) {
			this.tagsTreeViewer.setChecked(checkedItem, true);
		}
	}

	private void createStatusArea(final Composite parent) {
		this.statusArea = new Composite(parent, SWT.NONE);

		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(this.statusArea);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(this.statusArea);

		this.searchStatusImageLabel = new Label(this.statusArea, SWT.NONE);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.CENTER).applyTo(this.searchStatusImageLabel);

		this.searchStatusTextLabel = new Label(this.statusArea, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(this.searchStatusTextLabel);
	}

	private void createBindings(final Composite parent) {
		final DataBindingContext projectContext = this.projectInput.createBindings();

		/*
		 * create aggregation status to collect max severity status and do some further
		 * validation for the page
		 */
		this.projectAggrValStatus = new AggregateValidationStatus(projectContext,
			AggregateValidationStatus.MAX_SEVERITY);
		this.projectAggrValStatus.addValueChangeListener(e -> {
			if (this.projectAggrValStatus.getValue().isOK()) {
				final IProject newProject = this.projectInput.getProjectProvider().getProject();
				final IProject oldProject = this.currentProject;
				if (newProject != oldProject) {
					this.tagList.getTags().clear();
					this.tagsTreeViewer.refresh();
					loadTags(newProject);
				}
				this.currentProject = newProject;
			} else {
				this.currentProject = null;
				this.tagList.getTags().clear();
				this.tagsTreeViewer.refresh();
			}
			setStatus(this.projectAggrValStatus.getValue());
			updateOKStatus();

		});
		parent.addDisposeListener(e -> {
			this.projectAggrValStatus.dispose();
		});

	}

	private void loadTags(final IProject project) {
		if (this.loadTagsJob != null && this.loadTagsJob.getResult() == null) {
			this.loadTagsJob.cancel();
		}
		this.loadTagsJob = Job.create(Messages.TaggedObjectSearchPage_LoadingTagsJob_xmsg, monitor -> {
			final ITagList tagList = AbapTagsServiceFactory.createTagsService()
				.readTags(DestinationUtil.getDestinationId(project), TagSearchScope.ALL, false);
			monitor.done();
			if (tagList != null) {
				this.tagList.getTags().clear();
				this.tagList.getTags().addAll(tagList.getTags());
				Display.getDefault().asyncExec(() -> {
					this.tagsTreeViewer.refresh();
					determineCheckedTagsFromPreviousSearch();
				});
				this.loadTagsJob = null;
			}
		});
		this.loadTagsJob.setSystem(true);
		this.loadTagsJob.schedule();
	}

	private void setStatus(final IStatus status) {
		this.currentStatus = status;
		Display.getDefault().asyncExec(() -> {
			if (this.mainComposite.isDisposed() || this.searchStatusImageLabel == null
				|| this.searchStatusTextLabel == null) {
				return;
			}
			if (status.getSeverity() == IStatus.OK) {
				this.searchStatusImageLabel.setImage(null);
				this.searchStatusTextLabel.setText(""); //$NON-NLS-1$
			} else {
				this.searchStatusImageLabel.setImage(StatusUtil.getImageForStatus(status.getSeverity()));
				this.searchStatusTextLabel.setText(status.getMessage());
				this.searchStatusTextLabel.setToolTipText(status.getMessage());
				this.searchStatusTextLabel.pack(true);
				this.searchStatusTextLabel.getParent().layout(true);
				getShell().pack(true);
			}
		});
	}

	private void updateOKStatus() {
		Display.getDefault().asyncExec(() -> {
			if (getControl().isDisposed()) {
				return;
			}
			boolean isError = false;
			if (this.currentStatus != null) {
				isError = IStatus.ERROR == this.currentStatus.getSeverity();
			}
			this.container.setPerformActionEnabled(!this.checkedTags.isEmpty() && !isError);
		});
	}

	/**
	 * The search view will override the layout data of the pages control so this
	 * class is there to prevent this behavior
	 *
	 * @author stockbal
	 */
	private static class SearchComposite extends Composite {
		public SearchComposite(final Composite parent, final int style) {
			super(parent, style);
		}

		@Override
		public void setLayoutData(final Object layoutData) {
			if (getLayoutData() == null) {
				super.setLayoutData(layoutData);
			}
		}
	}
}
