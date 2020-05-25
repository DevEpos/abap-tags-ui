package com.devepos.adt.abaptags.search;

import com.devepos.adt.abaptags.internal.search.TaggedObjectSearchService;

public class TaggedObjectSearchFactory {

	/**
	 * Creates new search service instance for finding tagged objects
	 *
	 * @return new search service instance for finding tagged objects
	 */
	public static ITaggedObjectSearchService createTaggedObjectSearchService() {
		return new TaggedObjectSearchService();
	}
}
