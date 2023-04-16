package com.devepos.adt.atm.ui.internal.search;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

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
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
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
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;
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
  private Composite mainComposite;
  private ProjectInput projectInput;
  private IAbapProjectProvider projectProvider;
  private Composite statusArea;
  private Label searchStatusImageLabel;
  private Label searchStatusTextLabel;
  private IStatus currentStatus;
  private Button matchAllTagsButton;
  private TagSelectionTree tagsTree;
  private ToolBar treeToolBar;

  private final IPreferenceStore prefStore;
  private Job loadTagsJob;
  private IProject currentProject;

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
    createTreeToolbar();

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

    if (!tagsTree.hasCheckedTags()) {
      updateOKStatus();
      return false;
    }
    prefStore.setValue(LAST_PROJECT_PREF, projectProvider.getProjectName());

    final ITaggedObjectSearchParams searchParams = IAbapTagsFactory.eINSTANCE
        .createTaggedObjectSearchParams();
    searchParams.setMaxResults(prefStore.getInt(ITaggedObjectSearchPrefs.MAX_RESULTS));
    searchParams.setWithTagInfo(false);

    tagsTree.getCheckedTags().forEach(tag -> searchParams.addTag(tag));
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
    tagsTree.setCheckedTagIds(query.getSearchParams().getTagIds());
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
    tagsTree.addKeyListenerForFilterFocus();
    tagsTree.addCheckStateListener(l -> {
      updateOKStatus();
    });

    matchAllTagsButton = new Button(tagsGroup, SWT.CHECK);
    matchAllTagsButton.setText(Messages.TaggedObjectSearchPage_MatchAllTags_xckl);
    GridDataFactory.fillDefaults().applyTo(matchAllTagsButton);
  }

  private void createTreeToolbar() {
    var filterComposite = tagsTree.getTreeFilterComposite();
    treeToolBar = new ToolBar(filterComposite, SWT.FLAT | SWT.HORIZONTAL);
    GridDataFactory.fillDefaults().grab(false, false).align(SWT.END, SWT.END).applyTo(treeToolBar);

    var expandAll = new ToolItem(treeToolBar, SWT.PUSH);
    expandAll.setToolTipText(Messages.TagSelectionWizardPage_ExpandAll_xbut);
    expandAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.EXPAND_ALL));
    expandAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagsTree.expandAll();

    }));

    final var collapseAll = new ToolItem(treeToolBar, SWT.PUSH);
    collapseAll.setToolTipText(Messages.TagSelectionWizardPage_CollapseAll_xbut);
    collapseAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.COLLAPSE_ALL));
    collapseAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagsTree.collapseAll();
    }));

    new ToolItem(treeToolBar, SWT.SEPARATOR);

    final var uncheckAll = new ToolItem(treeToolBar, SWT.PUSH);
    uncheckAll.setToolTipText(AdtBaseUIResources.getString(IAdtBaseStrings.UncheckAll_xlbl));

    uncheckAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.UNCHECK_ALL));
    uncheckAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagsTree.setCheckedTags(null);
      updateOKStatus();
    }));
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
      container.setPerformActionEnabled(tagsTree.hasCheckedTags() && !isError);
    });
  }
}
