package com.devepos.adt.atm.internal.search;

import java.net.URI;

import com.devepos.adt.atm.internal.util.AbapTagsUriDiscoveryBase;

/**
 * URI Discovery for ABAP Tag management
 *
 * @author stockbal
 */
public class TaggedObjectSearchUriDiscovery extends AbapTagsUriDiscoveryBase {
	private static final String DISCOVERY_SCHEME = "http://www.devepos.com/adt/atm";
	private static final String DISCOVERY_RELATION_TAGS = "http://www.devepos.com/adt/relations/atm/taggedobjects/search";
	private static final String DISCOVERY_TERM_TAGS = "taggedobjectsearch";

	public TaggedObjectSearchUriDiscovery(final String destination) {
		super(destination, DISCOVERY_SCHEME);
	}

	/**
	 * Retrieves Resource URI for searching for tagged objects
	 *
	 * @return
	 */
	public URI getTaggedObjectSearchUri() {
		return getUriFromCollectionMember(DISCOVERY_TERM_TAGS);
	}

}
