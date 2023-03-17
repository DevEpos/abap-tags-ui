package com.devepos.adt.atm.internal.tree;

import java.net.URI;

import com.devepos.adt.atm.internal.util.AbapTagsUriDiscoveryBase;

/**
 * URI Discovery for ABAP Tagged Object Tree Services
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class TaggedObjectTreeUriDiscovery extends AbapTagsUriDiscoveryBase {
  private static final String DISCOVERY_SCHEME = "http://www.devepos.com/adt/atm";
  private static final String DISCOVERY_TERM_TAGS = "taggedobjecttree";

  public TaggedObjectTreeUriDiscovery(final String destination) {
    super(destination, DISCOVERY_SCHEME);
  }

  /**
   * Retrieves Resource URI for tagged object tree services
   */
  public URI getTaggedObjectTreeUri() {
    return getUriFromCollectionMember(DISCOVERY_TERM_TAGS);
  }

}
