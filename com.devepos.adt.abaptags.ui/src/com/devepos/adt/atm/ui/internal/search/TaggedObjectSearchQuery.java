package com.devepos.adt.atm.ui.internal.search;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.search.ui.ISearchQuery;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.search.TaggedObjectSearchFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.preferences.ITaggedObjectSearchPrefs;
import com.devepos.adt.base.ui.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.sap.adt.destinations.model.IDestinationData;

/**
 * Search Query which implements the search for ABAP Tagged Objects
 *
 * @author stockbal
 */
public class TaggedObjectSearchQuery implements ISearchQuery {
  private final TaggedObjectSearchResult searchResult;
  private IAbapProjectProvider projectProvider;
  private final ITaggedObjectSearchParams searchParams;

  public TaggedObjectSearchQuery(final ITaggedObjectSearchParams searchParams) {
    this.searchParams = searchParams;
    searchResult = new TaggedObjectSearchResult(this);
  }

  @Override
  public IStatus run(final IProgressMonitor monitor) throws OperationCanceledException {
    searchResult.cleanup();
    // update the max results parameter as it could have changed in the mean time
    searchParams.setMaxResults(AbapTagsUIPlugin.getDefault()
        .getPreferenceStore()
        .getInt(ITaggedObjectSearchPrefs.MAX_RESULTS));

    // perform object search
    if (projectProvider == null || !projectProvider.hasProject()) {
      return new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID,
          Messages.TaggedObjectSearchQuery_NoProjectError_xmsg);
    }
    final IStatus loggedOnStatus = ProjectUtil.ensureLoggedOnToProject(projectProvider
        .getProject());
    if (!loggedOnStatus.isOK()) {
      return loggedOnStatus;
    }

    monitor.beginTask(Messages.TaggedObjectSearchQuery_SearchTaskName_xmsg, 1); // Messages.ObjectSearch_SearchJobProgressText_xmsg,
                                                                                // 1);

    final ITaggedObjectList result = TaggedObjectSearchFactory.createTaggedObjectSearchService()
        .findObjects(projectProvider.getDestinationId(), searchParams);

    if (result != null && result.getTaggedObjects().size() > searchParams.getMaxResults()) {
      searchResult.setHasMoreResults(true);
    }
    searchResult.addSearchResult(result);
    monitor.worked(1);
    monitor.done();
    return Status.OK_STATUS;
  }

  @Override
  public String getLabel() {
    return searchParams != null ? Messages.TaggedObjectSearchQuery_TaggedObjectSearchLabel_xmsg
        : "";
  }

  @Override
  public String toString() {
    final String destinationInfo = getDestinationInfo();
    if (destinationInfo.isEmpty()) {
      return String.format("'%s'", getQuery()); //$NON-NLS-1$
    }
    return String.format("'%s' [%s]", getQuery(), destinationInfo); //$NON-NLS-1$
  }

  @Override
  public boolean canRerun() {
    return true;
  }

  @Override
  public boolean canRunInBackground() {
    return true;
  }

  @Override
  public TaggedObjectSearchResult getSearchResult() {
    return searchResult;
  }

  public String getDestinationId() {
    return projectProvider != null ? projectProvider.getDestinationId() : ""; //$NON-NLS-1$
  }

  public ITaggedObjectSearchParams getSearchParams() {
    return searchParams;
  }

  public void setProjectProvider(final IAbapProjectProvider projectProvider) {
    this.projectProvider = projectProvider;
  }

  public IAbapProjectProvider getProjectProvider() {
    return projectProvider;
  }

  private String getDestinationInfo() {
    if (projectProvider == null || !projectProvider.hasProject()) {
      return ""; //$NON-NLS-1$
    }
    final IDestinationData destData = projectProvider.getDestinationData();
    return String.format("%s-%s", destData.getSystemConfiguration().getSystemId(), destData //$NON-NLS-1$
        .getClient());
  }

  private String getQuery() {
    if (searchParams != null) {
      return searchParams.getTags();
    }
    return ""; //$NON-NLS-1$
  }
}
