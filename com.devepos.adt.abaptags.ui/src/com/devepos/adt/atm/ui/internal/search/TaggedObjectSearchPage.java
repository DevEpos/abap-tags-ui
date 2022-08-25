package com.devepos.adt.atm.ui.internal.search;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.IPreferenceStore;
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
import com.devepos.adt.atm.ui.internal.tree.TagSelectionTree;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.project.ProjectInput;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.search.IChangeableSearchPage;
import com.devepos.adt.base.ui.search.SearchPageUtil;
import com.devepos.adt.base.ui.util.StatusUtil;

public class TaggedObjectSearchPage extends DialogPage implements ISearchPage,
    IChangeableSearchPage<TaggedObjectSearchQuery> {

  public static final String PAGE_ID = "com.devepos.adt.atm.ui.searchpage.tags"; //$NON-NLS-1$
  private static final String LAST_PROJECT_PREF = "com.devepos.adt.abaptags.ui.taggedObjectSearch.lastProject"; //$NON-NLS-1$
  private ISearchPageContainer container;
  // private CheckboxTreeViewer tagsTreeViewer;
  // private final ITagList tagList = IAbapTagsFactory.eINSTANCE.createTagList();
  private Composite mainComposite;
  private ProjectInput projectInput;
  private IAbapProjectProvider projectProvider;
  private Composite statusArea;
  private Label searchStatusImageLabel;
  private Label searchStatusTextLabel;
  private IStatus currentStatus;
  private IProject currentProject;
  private Button matchAllTagsButton;
  private final IPreferenceStore prefStore;
  private TagSelectionTree tagsTree;
  private Job loadTagsJob;

  public TaggedObjectSearchPage() {
    prefStore = AbapTagsUIPlugin.getDefault().getPreferenceStore();
    prefStore.setDefault(LAST_PROJECT_PREF, ""); //$NON-NLS-1$
    prefStore.setDefault(ITaggedObjectSearchPrefs.MAX_RESULTS, 50);
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

    setInitialData();

    updateOKStatus();

    tagsTree.setFocus();
    SearchPageUtil.notifySearchPageListeners(this);
  }

  @Override
  public boolean performAction() {
    if (currentStatus != null && currentStatus.getSeverity() == IStatus.ERROR) {
      setStatus(currentStatus);
      updateOKStatus();
      return false;
    }

    if (!tagsTree.hasSelection()) {
      updateOKStatus();
      return false;
    }
    prefStore.setValue(LAST_PROJECT_PREF, projectProvider.getProjectName());

    final ITaggedObjectSearchParams searchParams = IAbapTagsFactory.eINSTANCE
        .createTaggedObjectSearchParams();
    searchParams.setMaxResults(prefStore.getInt(ITaggedObjectSearchPrefs.MAX_RESULTS));
    searchParams.setWithTagInfo(true);
    searchParams.setTagInfoType(TagInfoType.CHILDREN);

    tagsTree.getSelectedTags().forEach(tag -> searchParams.addTag(tag));
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

  @Override
  public void setInputFromSearchQuery(final TaggedObjectSearchQuery query) {
    projectInput.setProjectName(query.getProjectProvider().getProjectName());
    matchAllTagsButton.setSelection(query.getSearchParams().isMatchesAllTags());
    tagsTree.setSelectedTags(query.getSearchParams().getTagIds());
  }

  @Override
  public void setVisible(final boolean visible) {
    super.setVisible(visible);
    updateOKStatus();
  }

  private void createProjectInput(final Composite parent) {
    projectInput = new ProjectInput(true);
    projectProvider = projectInput.getProjectProvider();

    projectInput.createControl(parent);
    projectInput.addProjectValidator(project -> AbapTagsServiceFactory.createTagsService()
        .testTagsFeatureAvailability(project));
    projectInput.addStatusChangeListener(status -> {
      if (status.isOK()) {
        final IProject newProject = projectInput.getProjectProvider().getProject();
        final IProject oldProject = currentProject;
        if (newProject != oldProject) {
          tagsTree.reset();
          loadTags(newProject);
        }
        currentProject = newProject;
      } else {
        currentProject = null;
        tagsTree.reset();
      }
      setStatus(status);
      updateOKStatus();
    });
  }

  private void loadTags(final IProject project) {
    if (loadTagsJob != null && loadTagsJob.getResult() == null) {
      loadTagsJob.cancel();
    }
    loadTagsJob = Job.createSystem(Messages.TaggedObjectSearchPage_LoadingTagsJob_xmsg, monitor -> {
      final ITagList tagList = AbapTagsServiceFactory.createTagsService()
          .readTags(DestinationUtil.getDestinationId(project), TagSearchScope.ALL, false);
      monitor.done();
      if (tagList != null) {
        if (tagsTree != null) {
          tagsTree.setTags(tagList.getTags(), true);
        }
        loadTagsJob = null;
      }
    });
    loadTagsJob.schedule();
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

  private void createTagsTree(final Composite parent) {
    final Group tagsGroup = new Group(parent, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(tagsGroup);
    GridLayoutFactory.swtDefaults().applyTo(tagsGroup);
    tagsGroup.setText(Messages.TaggedObjectSearchPage_TagsGroup_xtit);

    tagsTree = new TagSelectionTree();
    tagsTree.createControl(tagsGroup);
    tagsTree.addSelectionChangeListener(l -> {
      updateOKStatus();
    });

    matchAllTagsButton = new Button(tagsGroup, SWT.CHECK);
    matchAllTagsButton.setText(Messages.TaggedObjectSearchPage_MatchAllTags_xckl);
    GridDataFactory.fillDefaults().applyTo(matchAllTagsButton);
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

  private void setStatus(final IStatus status) {
    currentStatus = status;
    Display.getDefault().asyncExec(() -> {
      if (mainComposite.isDisposed() || searchStatusImageLabel == null
          || searchStatusTextLabel == null) {
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
      container.setPerformActionEnabled(tagsTree.hasSelection() && !isError);
    });
  }
}
