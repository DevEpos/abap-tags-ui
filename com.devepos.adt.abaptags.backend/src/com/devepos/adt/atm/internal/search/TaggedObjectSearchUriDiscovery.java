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
  private static final String DISCOVERY_TERM_TAGGED_OBJ_SEARCH = "taggedobjectsearch";
  private static final String DISCOVERY_TERM_TAGGED_OBJECT_INFOS = "taggedObjectInfos";

  public TaggedObjectSearchUriDiscovery(final String destination) {
    super(destination, DISCOVERY_SCHEME);
  }

  /**
   * Retrieves Resource URI for searching for tagged objects
   */
  public URI getTaggedObjectSearchUri() {
    return getUriFromCollectionMember(DISCOVERY_TERM_TAGGED_OBJ_SEARCH);
  }

  /**
   * Retrieves Resource UIR for getting a list of taggeg object info objects
   */
  public URI getTaggedObjectInfosGetListUri() {
    return getUriFromCollectionMember(DISCOVERY_TERM_TAGGED_OBJECT_INFOS);
  }
}
