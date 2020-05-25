package com.devepos.adt.abaptags.ui.internal.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;

import com.devepos.adt.abaptags.ITaggedObjectList;
import com.devepos.adt.abaptags.ui.AbapTagsUIPlugin;
import com.devepos.adt.abaptags.ui.internal.messages.Messages;
import com.devepos.adt.abaptags.ui.internal.util.IImages;
import com.devepos.adt.tools.base.AdtToolsBaseResources;
import com.devepos.adt.tools.base.IAdtToolsBaseStrings;
import com.devepos.adt.tools.base.ui.tree.IAdtObjectReferenceNode;

public class TaggedObjectSearchResult implements ISearchResult {
	private final TaggedObjectSearchQuery query;
	private final List<ISearchResultListener> resultListeners = new ArrayList<>();
	private ITaggedObjectList internalSearchResult;
	private IAdtObjectReferenceNode[] treeResult;
	private int resultCount;
	private boolean hasMoreResults;

	public TaggedObjectSearchResult(final TaggedObjectSearchQuery tagSearchQuery) {
		this.query = tagSearchQuery;
	}

	@Override
	public void addListener(final ISearchResultListener l) {
		this.resultListeners.add(l);
	}

	@Override
	public void removeListener(final ISearchResultListener l) {
		this.resultListeners.remove(l);
	}

	@Override
	public String getLabel() {
		String resultsLabel = null;
		if (this.resultCount == 1) {
			resultsLabel = AdtToolsBaseResources.getString(IAdtToolsBaseStrings.SearchUI_MoreThanOneResult_xmsg);
		} else if (this.resultCount > 1) {
			if (this.hasMoreResults) {
				resultsLabel = AdtToolsBaseResources.format(IAdtToolsBaseStrings.SearchUI_MoreThanOneResult_xmsg,
					this.query.getSearchParams().getMaxResults());
			} else {
				resultsLabel = AdtToolsBaseResources.format(IAdtToolsBaseStrings.SearchUI_SpecificResults_xmsg, this.resultCount);

			}
		} else {
			resultsLabel = AdtToolsBaseResources.getString(IAdtToolsBaseStrings.SearchUI_NoResults_xmsg);
		}
		final String label = NLS.bind(Messages.TaggedObjectSearchResult_SearchLabel_xmsg, this.query, resultsLabel);
		return label;
	}

	@Override
	public String getTooltip() {
		return getLabel();
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.TAG);
	}

	@Override
	public ISearchQuery getQuery() {
		return this.query;
	}

	public void cleanup() {
		this.hasMoreResults = false;
		this.internalSearchResult = null;
		this.treeResult = null;
		this.resultCount = 0;
		final TaggedObjectSearchResultEvent resultEvent = new TaggedObjectSearchResultEvent(this);
		resultEvent.setCleanup(true);
		informListener(resultEvent);
	}

	public void setHasMoreResults(final boolean hasMoreResults) {
		this.hasMoreResults = hasMoreResults;
	}

	public void addSearchResult(final ITaggedObjectList result) {
		this.internalSearchResult = result;
		this.treeResult = null;
		this.resultCount = 0;
		informListener(new TaggedObjectSearchResultEvent(this));
	}

	protected void informListener(final TaggedObjectSearchResultEvent resultEvent) {
		this.resultListeners.stream().forEach(l -> l.searchResultChanged(resultEvent));
	}

}
