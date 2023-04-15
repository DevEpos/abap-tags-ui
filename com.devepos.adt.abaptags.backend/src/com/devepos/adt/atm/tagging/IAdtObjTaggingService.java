package com.devepos.adt.atm.tagging;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.atm.model.abaptags.ITagPreviewInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeleteRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckResult;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.base.model.adtbase.IAdtObjRefList;

/**
 * Service to handle all things concerning tagging ADT objects
 *
 * @author stockbal
 */
public interface IAdtObjTaggingService {
  /**
   * Deletes a list of tagged objects
   *
   * @param destinationId destination Id of ABAP project
   * @param deleteRequest request with Ids of tagged objects
   */
  IStatus deleteTaggedObjects(String destinationId, ITaggedObjectDeleteRequest deleteRequest);

  /**
   * Retrieves information for tagging ADT objects
   *
   * @param destinationId destination Id of ABAP Project
   * @param adtObjRefs    list of ADT Object references
   * @return
   * @throws CoreException
   */
  ITagPreviewInfo getInformationForTagging(String destinationId, IAdtObjRefList adtObjRefs)
      throws CoreException;

  /**
   * Retrieves tagged object information about object with {@code objectUri}.
   *
   * @param destinationId destination Id of ABAP Project
   * @param objectUri     uri of an ADT object
   * @return the found object information
   * @throws CoreException
   */
  List<ITaggedObject> getObjectInfo(String destinationId, String objectUri) throws CoreException;

  /**
   * Checks a given list of Tagged Object Ids if they can be deleted
   *
   * @param destinationId destination Id of ABAP project
   * @param checkRequest  request information for deletion check
   * @return deletion check result
   */
  ITaggedObjectDeletionCheckResult runTaggedObjectDeletionCheck(String destinationId,
      ITaggedObjectDeletionCheckRequest checkRequest);

  /**
   * Saves the given list of {@link ITaggedObject}s in the project with the given
   * destination id
   *
   * @param destinationId    destination Id of ABAP Project
   * @param taggedObjectList list of {@link ITaggedObject}s
   * @throws CoreException
   */
  void saveTaggedObjects(String destinationId, ITaggedObjectList taggedObjectList)
      throws CoreException;

  /**
   * Returns {@link Status#OK_STATUS} if it is possible to delete tagged objects
   * in the given ABAP project
   *
   * @param project ABAP project
   * @return Status with severity {@link IStatus#OK} if the feature is available
   */
  IStatus testTaggedObjectDeletionFeatureAvailability(IProject project);
}
