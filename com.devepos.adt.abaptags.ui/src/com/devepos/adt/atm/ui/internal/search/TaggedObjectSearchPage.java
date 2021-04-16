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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.model.abaptags.TagInfoType;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.help.HelpContexts;
import com.devepos.adt.atm.ui.internal.help.HelpUtil;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.preferences.ITaggedObjectSearchPrefs;
import com.devepos.adt.atm.ui.internal.tree.TagFilter;
import com.devepos.adt.atm.ui.internal.tree.TagLabelProvider;
import com.devepos.adt.atm.ui.internal.tree.TagTreeContentProvider;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.project.ProjectInput;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.search.IChangeableSearchPage;
import com.devepos.adt.base.ui.search.SearchPageUtil;
import com.devepos.adt.base.ui.tree.FilterableTree;
import com.devepos.adt.base.ui.util.StatusUtil;

public class TaggedObjectSearchPage extends DialogPage implements ISearchPage,
    IChangeableSearchPage<TaggedObjectSearchQuery> {

    public static final String PAGE_ID = "com.devepos.adt.atm.ui.searchpage.tags"; //$NON-NLS-1$
    private static final String LAST_PROJECT_PREF = "com.devepos.adt.abaptags.ui.taggedObjectSearch.lastProject"; //$NON-NLS-1$
    private ISearchPageContainer container;
    private CheckboxTreeViewer tagsTreeViewer;
    private final ITagList tagList = IAbapTagsFactory.eINSTANCE.createTagList();
    private FilterableTree tagsTree;
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
    private final TagFilter patternFilter;
    private Button matchAllTagsButton;
    private final IPreferenceStore prefStore;
    private List<String> previouslyCheckedTagIds;

    public TaggedObjectSearchPage() {
        prefStore = AbapTagsUIPlugin.getDefault().getPreferenceStore();
        prefStore.setDefault(LAST_PROJECT_PREF, ""); //$NON-NLS-1$
        prefStore.setDefault(ITaggedObjectSearchPrefs.MAX_RESULTS, 50);
        checkedTags = new HashSet<>();
        patternFilter = new TagFilter();
    }

    @Override
    public void createControl(final Composite parent) {
        initializeDialogUnits(parent);
        mainComposite = new SearchComposite(parent, SWT.NONE);
        HelpUtil.setHelp(mainComposite, HelpContexts.TAGGED_OBJECT_SEARCH);
        GridDataFactory.fillDefaults().grab(true, true).applyTo(mainComposite);
        GridLayoutFactory.swtDefaults().applyTo(mainComposite);
        setControl(mainComposite);

        createTagsTree(mainComposite);
        final Label separator = new Label(mainComposite, SWT.SEPARATOR | SWT.HORIZONTAL);
        separator.setVisible(false);
        GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 5).grab(true, false).applyTo(separator);

        createProjectInput(mainComposite);
        createStatusArea(mainComposite);
        createBindings(mainComposite);

        setInitialData();
        updateOKStatus();

        if (tagsTree != null && !tagsTree.isDisposed()) {
            tagsTree.setFocus();
        }
        SearchPageUtil.notifySearchPageListeners(this);
    }

    @Override
    public void setInputFromSearchQuery(final TaggedObjectSearchQuery query) {
        projectInput.setProjectName(query.getProjectProvider().getProjectName());
        matchAllTagsButton.setSelection(query.getSearchParams().isMatchesAllTags());
        previouslyCheckedTagIds = query.getSearchParams().getTagIds();
    }

    @Override
    public boolean performAction() {
        if (currentStatus != null && currentStatus.getSeverity() == IStatus.ERROR) {
            setStatus(currentStatus);
            updateOKStatus();
            return false;
        }
        if (checkedTags.isEmpty()) {
            updateOKStatus();
            return false;
        }
        prefStore.setValue(LAST_PROJECT_PREF, projectProvider.getProjectName());

        final ITaggedObjectSearchParams searchParams = IAbapTagsFactory.eINSTANCE.createTaggedObjectSearchParams();
        searchParams.setMaxResults(prefStore.getInt(ITaggedObjectSearchPrefs.MAX_RESULTS));
        searchParams.setWithTagInfo(true);
        searchParams.setTagInfoType(TagInfoType.CHILDREN);

        checkedTags.forEach(tag -> searchParams.addTag(tag));
        searchParams.setMatchesAllTags(matchAllTagsButton.getSelection());

        final TaggedObjectSearchQuery searchQuery = new TaggedObjectSearchQuery(searchParams);
        searchQuery.setProjectProvider(projectProvider);

        NewSearchUI.runQueryInBackground(searchQuery);
        return true;
    }

    @Override
    public void setContainer(final ISearchPageContainer container) {
        this.container = container;
    }

    private void setInitialData() {
        if (projectInput != null) {
            String projectName = null;

            final IProject currentAbapProject = ProjectUtil.getCurrentAbapProject();
            if (currentAbapProject != null) {
                projectName = currentAbapProject.getName();
            }
            if (projectName == null || projectName.isEmpty()) {
                projectName = prefStore.getString(LAST_PROJECT_PREF);
            }
            projectInput.setProjectName(projectName);
        }
    }

    private void createProjectInput(final Composite parent) {
        projectInput = new ProjectInput();
        projectProvider = projectInput.getProjectProvider();

        projectInput.createControl(parent);
        projectInput.addProjectValidator(project -> {
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

        tagsTree = new FilterableTree(tagsGroup, Messages.TaggedObjectSearchPage_TagsTreeFilterText_xmsg, false) {
            @Override
            protected void filterJobCompleted() {
                super.filterJobCompleted();
                setCheckedElements();
                if (tagsTree.getFilterString() == null || tagsTree.getFilterString().trim().isEmpty()) {
                    tagsTreeViewer.collapseAll();
                }
            }
        };
        tagsTree.setElementMatcher(element -> {
            if (element instanceof ITag) {
                final ITag tag = (ITag) element;
                return tagsTree.getWordMatcher().matchesWord(tag.getName()) || tagsTree.getWordMatcher()
                    .matchesWord(tag.getDescription());
            }
            return false;
        });
        tagsTreeViewer = new CheckboxTreeViewer(tagsTree, SWT.V_SCROLL | SWT.MULTI | SWT.BORDER);
        tagsTree.setViewer(tagsTreeViewer);
        tagsTree.setExpandAllOnFilterEmpty(false);

        tagsTreeViewer.addFilter(patternFilter);
        tagsTreeViewer.setContentProvider(new TagTreeContentProvider());
        tagsTreeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new TagLabelProvider(true, false)));
        tagsTreeViewer.setInput(tagList);
        tagsTree.setBackgroundMode(SWT.INHERIT_DEFAULT);
        GridDataFactory.fillDefaults().grab(true, true).hint(1, 150).applyTo(tagsTree);

        tagsTreeViewer.addCheckStateListener(e -> {
            if (e.getChecked()) {
                checkedTags.add((ITag) e.getElement());
            } else {
                checkedTags.remove(e.getElement());
            }
            updateOKStatus();
        });

        matchAllTagsButton = new Button(tagsGroup, SWT.CHECK);
        matchAllTagsButton.setText(Messages.TaggedObjectSearchPage_MatchAllTags_xckl);
        GridDataFactory.fillDefaults().applyTo(matchAllTagsButton);
    }

    private void determineCheckedTagsFromPreviousSearch() {
        if (previouslyCheckedTagIds == null || previouslyCheckedTagIds.isEmpty()) {
            return;
        }
        if (tagList != null && !tagList.getTags().isEmpty()) {
            tagList.getTags().stream().forEach(this::findAndSetTagAsChecked);
            if (!checkedTags.isEmpty()) {
                setCheckedElements();
                tagsTreeViewer.refresh();
                updateOKStatus();
            }
        }
        previouslyCheckedTagIds = null;
    }

    private void findAndSetTagAsChecked(final ITag tag) {
        if (previouslyCheckedTagIds.contains(tag.getId())) {
            checkedTags.add(tag);
        }
        for (final ITag childTag : tag.getChildTags()) {
            findAndSetTagAsChecked(childTag);
        }
    }

    private void setCheckedElements() {
        for (final Object checkedItem : checkedTags) {
            tagsTreeViewer.setChecked(checkedItem, true);
        }
    }

    private void createStatusArea(final Composite parent) {
        statusArea = new Composite(parent, SWT.NONE);

        GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(statusArea);
        GridLayoutFactory.fillDefaults().numColumns(2).applyTo(statusArea);

        searchStatusImageLabel = new Label(statusArea, SWT.NONE);
        GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.CENTER).applyTo(searchStatusImageLabel);

        searchStatusTextLabel = new Label(statusArea, SWT.NONE);
        GridDataFactory.fillDefaults().grab(true, true).applyTo(searchStatusTextLabel);
    }

    private void createBindings(final Composite parent) {
        final DataBindingContext projectContext = projectInput.createBindings();

        /*
         * create aggregation status to collect max severity status and do some further
         * validation for the page
         */
        projectAggrValStatus = new AggregateValidationStatus(projectContext, AggregateValidationStatus.MAX_SEVERITY);
        projectAggrValStatus.addValueChangeListener(e -> {
            if (projectAggrValStatus.getValue().isOK()) {
                final IProject newProject = projectInput.getProjectProvider().getProject();
                final IProject oldProject = currentProject;
                if (newProject != oldProject) {
                    tagList.getTags().clear();
                    tagsTreeViewer.refresh();
                    loadTags(newProject);
                }
                currentProject = newProject;
            } else {
                currentProject = null;
                tagList.getTags().clear();
                tagsTreeViewer.refresh();
            }
            setStatus(projectAggrValStatus.getValue());
            updateOKStatus();

        });
        parent.addDisposeListener(e -> {
            projectAggrValStatus.dispose();
        });

    }

    private void loadTags(final IProject project) {
        if (loadTagsJob != null && loadTagsJob.getResult() == null) {
            loadTagsJob.cancel();
        }
        loadTagsJob = Job.create(Messages.TaggedObjectSearchPage_LoadingTagsJob_xmsg, monitor -> {
            final ITagList tagList = AbapTagsServiceFactory.createTagsService()
                .readTags(DestinationUtil.getDestinationId(project), TagSearchScope.ALL, false);
            monitor.done();
            if (tagList != null) {
                this.tagList.getTags().clear();
                this.tagList.getTags().addAll(tagList.getTags());
                Display.getDefault().asyncExec(() -> {
                    tagsTreeViewer.refresh();
                    determineCheckedTagsFromPreviousSearch();
                });
                loadTagsJob = null;
            }
        });
        loadTagsJob.setSystem(true);
        loadTagsJob.schedule();
    }

    private void setStatus(final IStatus status) {
        currentStatus = status;
        Display.getDefault().asyncExec(() -> {
            if (mainComposite.isDisposed() || searchStatusImageLabel == null || searchStatusTextLabel == null) {
                return;
            }
            if (status.getSeverity() == IStatus.OK) {
                searchStatusImageLabel.setImage(null);
                searchStatusTextLabel.setText(""); //$NON-NLS-1$
            } else {
                searchStatusImageLabel.setImage(StatusUtil.getImageForStatus(status.getSeverity()));
                searchStatusTextLabel.setText(status.getMessage());
                searchStatusTextLabel.setToolTipText(status.getMessage());
                searchStatusTextLabel.pack(true);
                searchStatusTextLabel.getParent().layout(true);
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
            if (currentStatus != null) {
                isError = IStatus.ERROR == currentStatus.getSeverity();
            }
            container.setPerformActionEnabled(!checkedTags.isEmpty() && !isError);
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
