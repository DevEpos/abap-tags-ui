package com.devepos.adt.atm.search;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectListRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;

/**
 * Service for searching for Objects with certain tags
 *
 * @author stockbal
 */
public interface ITaggedObjectSearchService {

  /**
   * Finds tagged objects
   *
   * @param destinationId destination Id for ABAP project
   * @param parameters    instance of search parameters
   * @return list of found objects
   */
  ITaggedObjectList findObjects(String destinationId, ITaggedObjectSearchParams parameters);

  /**
   * Retrieves a list of tagged object information objects
   *
   * @param destinationId destination Id for ABAP project
   * @param request       request with information what objects should be read
   * @return list of found object infos
   */
  List<ITaggedObjectInfo> findObjectInfos(String destinationId, ITaggedObjectListRequest request);

  /**
   * Tests if the feature to retrieve tagged object info objects is available in the given ABAP
   * project.
   *
   * @param project ABAP project
   * @return {@link Status#OK_STATUS} if the feature is available
   */
  IStatus testGetObjectInfosFeatureAvailability(IProject project);
}
