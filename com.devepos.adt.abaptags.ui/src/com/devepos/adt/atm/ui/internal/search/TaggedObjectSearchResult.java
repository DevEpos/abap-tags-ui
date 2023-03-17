package com.devepos.adt.atm.ui.internal.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;

import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.tree.AdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;

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
    query = tagSearchQuery;
  }

  @Override
  public void addListener(final ISearchResultListener l) {
    resultListeners.add(l);
  }

  @Override
  public void removeListener(final ISearchResultListener l) {
    resultListeners.remove(l);
  }

  @Override
  public String getLabel() {
    String resultsLabel = null;
    if (resultCount == 1) {
      resultsLabel = AdtBaseUIResources.getString(IAdtBaseStrings.SearchUI_OneResult_xmsg);
    } else if (resultCount > 1) {
      if (hasMoreResults) {
        resultsLabel = AdtBaseUIResources.format(IAdtBaseStrings.SearchUI_ResultsExceedMaximum_xmsg,
            query.getSearchParams().getMaxResults());
      } else {
        resultsLabel = AdtBaseUIResources.format(IAdtBaseStrings.SearchUI_SpecificResults_xmsg,
            resultCount);

      }
    } else {
      resultsLabel = AdtBaseUIResources.getString(IAdtBaseStrings.SearchUI_NoResults_xmsg);
    }
    final String label = NLS.bind(Messages.TaggedObjectSearchResult_SearchLabel_xmsg, query,
        resultsLabel);
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
    return query;
  }

  public void cleanup() {
    hasMoreResults = false;
    internalSearchResult = null;
    treeResult = null;
    resultCount = 0;
    final TaggedObjectSearchResultEvent resultEvent = new TaggedObjectSearchResultEvent(this);
    resultEvent.setCleanup(true);
    informListener(resultEvent);
  }

  public void setHasMoreResults(final boolean hasMoreResults) {
    this.hasMoreResults = hasMoreResults;
  }

  public void addSearchResult(final ITaggedObjectList result) {
    if (result != null && result.getTaggedObjects().size() > 0) {
      internalSearchResult = result;
      resultCount = result.getTaggedObjects().size();
    } else {
      internalSearchResult = null;
      treeResult = null;
      resultCount = 0;
    }
    informListener(new TaggedObjectSearchResultEvent(this));
  }

  protected void informListener(final TaggedObjectSearchResultEvent resultEvent) {
    resultListeners.stream().forEach(l -> l.searchResultChanged(resultEvent));
  }

  /**
   * Returns an Array of Tree Nodes
   *
   * @param groupByPackage if <code>true</code> the search result should be
   *                       grouped by their packages
   * @return an Array of Tree Nodes, where the root nodes are either CDS Views,
   *         Database Tables or Views
   */
  public IAdtObjectReferenceNode[] getResultForTree(final boolean groupByPackage) {
    if (resultCount == 0) {
      return EMPTY_RESULT;
    }
    if (treeResult == null || treeResult == EMPTY_RESULT || groupByPackage != isGroupedResult) {
      isGroupedResult = groupByPackage;
      if (groupByPackage) {
        createGroupedResult();
      } else {
        createResult();
      }
    }
    return treeResult;
  }

  private void createResult() {
    final List<IAdtObjectReferenceNode> nodes = new ArrayList<>();

    for (final ITaggedObject taggedObject : internalSearchResult.getTaggedObjects()) {
      final IAdtObjRef objectRef = taggedObject.getObjectRef();
      final AdtObjectReferenceNode objRefNode = new AdtObjectReferenceNode(objectRef.getName(),
          objectRef.getName(), objectRef.getDescription(), AdtObjectReferenceModelFactory
              .createReference(query.getDestinationId(), objectRef));
      nodes.add(objRefNode);
    }
    treeResult = nodes.toArray(new IAdtObjectReferenceNode[nodes.size()]);
  }

  private void createGroupedResult() {
    // TODO Auto-generated method stub

  }

}
