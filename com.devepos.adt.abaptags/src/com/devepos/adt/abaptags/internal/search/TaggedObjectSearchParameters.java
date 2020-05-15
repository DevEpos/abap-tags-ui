package com.devepos.adt.abaptags.internal.search;

import com.devepos.adt.abaptags.TagSearchScope;
import com.devepos.adt.abaptags.search.ITaggedObjectSearchParameters;

public class TaggedObjectSearchParameters implements ITaggedObjectSearchParameters {
	private String query;
	private TagSearchScope searchScope;
	private int maxResults = 50;
	private boolean withTagInfo;
	private boolean matchAllTags;
	private String tags;

	@Override
	public void setQuery(final String query) {
		this.query = query;
	}

	@Override
	public String getQuery() {
		return this.query;
	}

	@Override
	public void setSearchScope(final TagSearchScope scope) {
		this.searchScope = scope;
	}

	@Override
	public TagSearchScope getSearchScope() {
		return this.searchScope;
	}

	@Override
	public void setMaxResult(final int maxResults) {
		this.maxResults = maxResults;
	}

	@Override
	public int getMaxResults() {
		return this.maxResults;
	}

	@Override
	public void setWithTagInfo(final boolean withTagInfo) {
		this.withTagInfo = withTagInfo;
	}

	@Override
	public boolean isWithTagInfo() {
		return this.withTagInfo;
	}

	@Override
	public void setMatchAllTags(final boolean matchAllTags) {
		this.matchAllTags = matchAllTags;
	}

	@Override
	public boolean isMatchAllTags() {
		return this.matchAllTags;
	}

	@Override
	public void setTags(final String tags) {
		this.tags = tags;
	}

	@Override
	public String getTags() {
		return this.tags;
	}

}
