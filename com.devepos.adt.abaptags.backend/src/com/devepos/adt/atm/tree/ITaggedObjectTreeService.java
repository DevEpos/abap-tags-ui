package com.devepos.adt.atm.tree;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult;

/**
 * Service for retrieving results for the Tagged Object Tree
 * 
 * @author Ludwig Stockbauer-Muhr
 *
 */
public interface ITaggedObjectTreeService {
  /**
   * Finds nodes in the the Tagged Object Tree
   *
   * @param destinationId destination Id for ABAP project
   * @param request       request for tree
   * @return result for tree
   */
  ITaggedObjectTreeResult findNodes(String destinationId, ITaggedObjectTreeRequest request);
}
