package com.devepos.adt.abaptags.search;

import com.devepos.adt.abaptags.TagSearchScope;

/**
 * Search parameters for Tagged Object Search
 *
 * @author stockbal
 */
public interface ITaggedObjectSearchParameters {

	void setQuery(String query);

	String getQuery();

	void setTags(String tags);

	String getTags();

	void setSearchScope(TagSearchScope scope);

	TagSearchScope getSearchScope();

	void setMaxResult(int maxResults);

	int getMaxResults();

	void setWithTagInfo(boolean withTagInfo);

	boolean isWithTagInfo();

	void setMatchAllTags(boolean matchAllTags);

	boolean isMatchAllTags();

}
