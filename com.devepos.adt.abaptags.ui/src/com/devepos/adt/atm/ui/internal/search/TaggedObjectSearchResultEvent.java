package com.devepos.adt.atm.ui.internal.search;

import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.SearchResultEvent;

public class TaggedObjectSearchResultEvent extends SearchResultEvent {

	private static final long serialVersionUID = -9013652938907883770L;

	private boolean cleanup;

	protected TaggedObjectSearchResultEvent(final ISearchResult searchResult) {
		super(searchResult);
	}

	public void setCleanup(final boolean cleanup) {
		this.cleanup = cleanup;
	}

	public boolean isCleanup() {
		return this.cleanup;
	}

}
