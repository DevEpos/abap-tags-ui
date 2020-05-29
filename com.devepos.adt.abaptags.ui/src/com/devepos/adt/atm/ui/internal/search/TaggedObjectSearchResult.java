package com.devepos.adt.atm.ui.internal.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;

import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.util.IImages;
import com.devepos.adt.tools.base.AdtToolsBaseResources;
import com.devepos.adt.tools.base.IAdtToolsBaseStrings;
import com.devepos.adt.tools.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.tools.base.ui.tree.AdtObjectReferenceNode;
import com.devepos.adt.tools.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.tools.base.ui.tree.ILazyLoadingNode;
import com.devepos.adt.tools.base.ui.tree.LazyLoadingFolderNode;
import com.devepos.adt.tools.base.util.StringUtil;

public class TaggedObjectSearchResult implements ISearchResult {
	private final TaggedObjectSearchQuery query;
	private final List<ISearchResultListener> resultListeners = new ArrayList<>();
	private ITaggedObjectList internalSearchResult;
	private IAdtObjectReferenceNode[] treeResult;
	private static final IAdtObjectReferenceNode[] EMPTY_RESULT = new IAdtObjectReferenceNode[0];
	private int resultCount;
	private boolean hasMoreResults;
	private boolean isGroupedResult;

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
			resultsLabel = AdtToolsBaseResources.getString(IAdtToolsBaseStrings.SearchUI_OneResult_xmsg);
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
		if (result != null && result.getTaggedObjects().size() > 0) {
			this.internalSearchResult = result;
			this.resultCount = result.getTaggedObjects().size();
		} else {
			this.internalSearchResult = null;
			this.treeResult = null;
			this.resultCount = 0;
		}
		informListener(new TaggedObjectSearchResultEvent(this));
	}

	protected void informListener(final TaggedObjectSearchResultEvent resultEvent) {
		this.resultListeners.stream().forEach(l -> l.searchResultChanged(resultEvent));
	}

	/**
	 * Returns an Array of Tree Nodes
	 *
	 * @param  groupByPackage if <code>true</code> the search result should be
	 *                        grouped by their packages
	 * @return                an Array of Tree Nodes, where the root nodes are
	 *                        either CDS Views, Database Tables or Views
	 */
	public IAdtObjectReferenceNode[] getResultForTree(final boolean groupByPackage) {
		if (this.resultCount == 0) {
			return EMPTY_RESULT;
		}
		if (this.treeResult == null || this.treeResult == EMPTY_RESULT || groupByPackage != this.isGroupedResult) {
			this.isGroupedResult = groupByPackage;
			if (groupByPackage) {
				createGroupedResult();
			} else {
				createResult();
			}
		}
		return this.treeResult;
	}

	private void createResult() {
		final List<IAdtObjectReferenceNode> nodes = new ArrayList<>();

		for (final ITaggedObject taggedObject : this.internalSearchResult.getTaggedObjects()) {
			final IAdtObjRef objectRef = taggedObject.getObjectRef();
			/*
			 * if tags are present it means the ADT object has tags with child tags so an
			 * expansion is possible
			 */
			final AdtObjectReferenceNode objRefNode = new AdtObjectReferenceNode(objectRef.getName(), objectRef.getName(),
				objectRef.getDescription(),
				AdtObjectReferenceModelFactory.createReference(this.query.getDestinationId(), objectRef));
			nodes.add(objRefNode);

			for (final IAdtObjectTag tag : taggedObject.getTags()) {
				final ILazyLoadingNode lazyTagNode = new LazyLoadingFolderNode(tag.getName(),
					new TaggedObjectSearchInfoProvider(this.query.getDestinationId(), objectRef, tag, 50), objRefNode,
					AbapTagsUIPlugin.getDefault().getImage(StringUtil.isEmpty(tag.getOwner()) ? IImages.TAG : IImages.USER_TAG));
				objRefNode.getChildren().add(lazyTagNode);
			}
		}
		this.treeResult = nodes.toArray(new IAdtObjectReferenceNode[nodes.size()]);
	}

	private void createGroupedResult() {
		// TODO Auto-generated method stub

	}

}
