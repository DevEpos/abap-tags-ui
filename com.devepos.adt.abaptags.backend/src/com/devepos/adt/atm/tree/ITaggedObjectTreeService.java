package com.devepos.adt.atm.tree;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

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

  /**
   * Returns {@link Status#OK_STATUS} if the Tagged Object Tree Feature is available in the
   * given project
   *
   * @param project ABAP project
   * @return status of the feature test
   */
  IStatus testTreeFeatureAvailability(IProject project);
}
