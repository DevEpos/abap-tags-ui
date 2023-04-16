package com.devepos.adt.atm.tags;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.atm.model.abaptags.ITagDeletionCheckResult;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.base.model.adtbase.IUser;

/**
 * Public interface for ABAP Tags service
 *
 * @author stockbal
 */
public interface IAbapTagsService {
  /**
   * Returns {@link Status#OK_STATUS} if the ABAP Tags feature is available at the
   * given project
   *
   * @param project ABAP project
   * @return Status with severity {@link IStatus#OK} if the ABAP Tags feature is
   *         available at the given destination
   */
  IStatus testTagsFeatureAvailability(IProject project);

  /**
   * Returns {@link Status#OK_STATUS} if the Share feature in the ABAP Tags Plugin
   * is available in the given ABAP project
   *
   * @param project ABAP project
   * @return Status with severity {@link IStatus#OK} if the Share feature in the
   *         ABAP Tags Plugin is available in the given ABAP project
   */
  IStatus testShareTagsFeatureAvailability(IProject project);

  /**
   * Returns {@link Status#OK_STATUS} if it is possible to run a tags deletion check
   * in the given ABAP project
   *
   * @param project ABAP project
   * @return Status with severity {@link IStatus#OK} if the feature is available
   */
  IStatus testTagDeletionCheckFeatureAvailability(IProject project);

  /**
   * Creates/updates tags
   *
   * @param tags          tags to be saved
   * @param destinationId destination of ABAP Project
   * @param scope         the scope of the tags
   * @return the status of the update operation
   */
  IStatus updateTags(ITagList tags, final String destinationId, TagSearchScope scope);

  /**
   * Reads ABAP Tags for the given destination ID
   *
   * @param destinationId   destination of ABAP Project
   * @param scope           the search scope for the tags
   * @param withObjectCount if {@code true} the tagged object count for each tag
   *                        should be determined
   */
  ITagList readTags(final String destinationId, TagSearchScope scope, boolean withObjectCount);

  /**
   * Deletes the given Tags
   *
   * @param tags          the tags to be deleted
   * @param destinationId destination of ABAP Project
   * @param scope         the scope of the tags
   * @return the status of the delete operation
   */
  IStatus deleteTags(ITagList tags, final String destinationId, TagSearchScope scope);

  /**
   * Searches for tags with the given query string
   *
   * @param destinationId destination id of ABAP project
   * @param scope         search scope
   * @param query         query String
   * @return list of found tags that match the given parameters
   */
  ITagList findTags(String destinationId, TagSearchScope scope, String query);

  /**
   * Locks the tags
   *
   * @param destinationId destination of ABAP Project
   * @param scope         the scope of the tags
   * @return the status of the lock operation
   */
  IStatus lockTags(final String destinationId, TagSearchScope scope);

  /**
   * Unlocks the tags
   *
   * @param destinationId destination of ABAP Project
   * @param scope         the scope of the tags
   */
  void unlockTags(final String destinationId, TagSearchScope scope);

  /**
   * Converts the list of user tags into global tags
   *
   * @param destinationId destination of ABAP project
   * @param tagList       list of Tags
   * @return the result status of the operation
   */
  IStatus makeTagsGlobal(String destinationId, ITagList tagList);

  /**
   * Shares the tags with other users
   *
   * @param destinationId destination of ABAP Project
   * @param tagList       list of Tags
   * @return the result status of the operation
   */
  IStatus shareTags(String destinationId, ITagList tagList);

  /**
   * Unshares the list of tags
   *
   * @param destinationId destination of ABAP Project
   * @param tagList       list of Tags
   * @return the result of the status of the operation
   */
  IStatus unshareTags(String destinationId, ITagList tagList);

  /**
   * Retrieves list of shared users for the given tag id
   *
   * @param destinationId destination of ABAP Project
   * @param tagId         id of Tag
   * @return List of shared users
   */
  List<IUser> getSharedUsers(String destinationId, String tagId);

  /**
   * Runs a check if the passed list of tags can be safely deleted
   *
   * @param destinationId destination of ABAP Project
   * @param tagList       list of tags to be deleted
   * @return deletion check result
   */
  ITagDeletionCheckResult runTagDeletionCheck(String destinationId, ITagList tagList);
}
