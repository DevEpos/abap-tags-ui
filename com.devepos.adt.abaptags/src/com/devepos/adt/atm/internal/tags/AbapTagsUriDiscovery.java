package com.devepos.adt.atm.internal.tags;

import java.net.URI;

import com.devepos.adt.atm.internal.util.AbapTagsUriDiscoveryBase;

/**
 * URI Discovery for ABAP Tag management
 *
 * @author stockbal
 */
public class AbapTagsUriDiscovery extends AbapTagsUriDiscoveryBase {
	private static final String DISCOVERY_SCHEME = "http://www.devepos.com/adt/atm";
	private static final String DISCOVERY_RELATION_TAGS = "http://www.devepos.com/adt/relations/atm/tags";
	private static final String DISCOVERY_TERM_TAGS = "tags";

	public AbapTagsUriDiscovery(final String destination) {
		super(destination, DISCOVERY_SCHEME);
	}

	/**
	 * Retrieves Resource URI for the ABAP Tags API
	 *
	 * @return
	 */
	public URI getTagsUri() {
		return getUriFromCollectionMember(DISCOVERY_TERM_TAGS);
	}

}
