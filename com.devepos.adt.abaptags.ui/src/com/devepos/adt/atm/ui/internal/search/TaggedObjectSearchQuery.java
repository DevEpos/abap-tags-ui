package com.devepos.adt.atm.ui.internal.search;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.search.ui.ISearchQuery;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.search.TaggedObjectSearchFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.tools.base.project.IAbapProjectProvider;
import com.devepos.adt.tools.base.util.AdtUtil;
import com.sap.adt.destinations.model.IDestinationData;

/**
 * Search Query which implements the search for ABAP Tagged Objects
 *
 * @author stockbal
 */
public class TaggedObjectSearchQuery implements ISearchQuery {
	private final TaggedObjectSearchResult searchResult;
	private String destinationId;
	private IAbapProjectProvider projectProvider;
	private final ITaggedObjectSearchParams searchParams;

	public TaggedObjectSearchQuery(final ITaggedObjectSearchParams searchParams) {
		this.searchParams = searchParams;
		this.searchResult = new TaggedObjectSearchResult(this);
	}

	@Override
	public IStatus run(final IProgressMonitor monitor) throws OperationCanceledException {
		this.searchResult.cleanup();

		// perform object search
		if (this.projectProvider == null) {
			return new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID,
				NLS.bind("Destination Id ''{0}'' is not valid", this.destinationId));
		}
		final IStatus loggedOnStatus = AdtUtil.ensureLoggedOnToProject(this.projectProvider.getProject());
		if (!loggedOnStatus.isOK()) {
			return loggedOnStatus;
		}

		monitor.beginTask("Searching...", 1); // Messages.ObjectSearch_SearchJobProgressText_xmsg, 1);

		final ITaggedObjectList result = TaggedObjectSearchFactory.createTaggedObjectSearchService()
			.findObjects(this.projectProvider.getDestinationId(), this.searchParams);

		if (result != null && result.getTaggedObjects().size() > this.searchParams.getMaxResults()) {
			this.searchResult.setHasMoreResults(true);
		}
		this.searchResult.addSearchResult(result);
		monitor.worked(1);
		monitor.done();
		return Status.OK_STATUS;
	}

	@Override
	public String getLabel() {
		return this.searchParams != null ? "ABAP Tags Search" : "";
	}

	@Override
	public String toString() {
		final String destinationInfo = getDestinationInfo();
		if (destinationInfo.isEmpty()) {
			return String.format("'%s'", getQuery());
		} else {
			return String.format("'%s' [%s]", getQuery(), destinationInfo);
		}
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
		return this.searchResult;
	}

	public String getDestinationId() {
		return this.projectProvider != null ? this.projectProvider.getDestinationId()
			: this.destinationId != null ? this.destinationId : "";
	}

	public void setDestinationId(final String destinationId) {
		this.destinationId = destinationId;
	}

	public ITaggedObjectSearchParams getSearchParams() {
		return this.searchParams;
	}

	public void setProjectProvider(final IAbapProjectProvider projectProvider) {
		this.projectProvider = projectProvider;
	}

	public IAbapProjectProvider getProjectProvider() {
		return this.projectProvider;
	}

	private String getDestinationInfo() {
		if (this.projectProvider == null || !this.projectProvider.hasProject()) {
			return "";
		} else {
			final IDestinationData destData = this.projectProvider.getDestinationData();
			return String.format("%s-%s", destData.getSystemConfiguration().getSystemId(), destData.getClient());
		}
	}

	private String getQuery() {
		if (this.searchParams != null) {
			return this.searchParams.getTags();
		}
		return ""; //$NON-NLS-1$
	}
}
