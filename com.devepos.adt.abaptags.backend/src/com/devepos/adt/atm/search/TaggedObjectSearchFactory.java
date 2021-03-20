package com.devepos.adt.atm.search;

import com.devepos.adt.atm.internal.search.TaggedObjectSearchService;

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
