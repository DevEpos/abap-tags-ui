package com.devepos.adt.atm.tree;

import com.devepos.adt.atm.internal.tree.TaggedObjectTreeService;

public class TaggedObjectTreeServicesFactory {

  /**
   * Creates new search service instance for getting nodes for a Tagged Object Tree
   *
   * @return new search service instance for finding tagged objects
   */
  public static ITaggedObjectTreeService createTaggedObjectTreeService() {
    return new TaggedObjectTreeService();
  }
}
