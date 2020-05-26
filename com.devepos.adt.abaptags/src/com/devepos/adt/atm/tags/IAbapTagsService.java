package com.devepos.adt.atm.tags;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;

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
	 * @param  project ABAP project
	 * @return         Status with severity {@link IStatus#OK} if the ABAP Tags
	 *                 feature is available at the given destination
	 */
	IStatus testTagsFeatureAvailability(IProject project);

	/**
	 * Creates/updates tags
	 *
	 * @param  tags          tags to be saved
	 * @param  destinationId destination of ABAP Project
	 * @param  scope         the scope of the tags
	 * @return               the status of the update operation
	 */
	IStatus updateTags(ITagList tags, final String destinationId, TagSearchScope scope);

	/**
	 * Reads ABAP Tags for the given destination ID
	 *
	 * @param destinationId destination of ABAP Project
	 * @param globalTags    if <code>true</code> global tags will be read
	 */
	ITagList readTags(final String destinationId, TagSearchScope scope);

	/**
	 * Deletes the given Tags
	 *
	 * @param  tags          the tags to be deleted
	 * @param  destinationId destination of ABAP Project
	 * @param  scope         the scope of the tags
	 * @return               the status of the delete operation
	 */
	IStatus deleteTags(ITagList tags, final String destinationId, TagSearchScope scope);

	/**
	 * Searches for tags with the given query string
	 *
	 * @param  destinationId destination id of ABAP project
	 * @param  scope         search scope
	 * @param  query         query String
	 * @return               list of found tags that match the given parameters
	 */
	ITagList findTags(String destinationId, TagSearchScope scope, String query);

	/**
	 * Locks the tags
	 *
	 * @param  destinationId destination of ABAP Project
	 * @param  scope         the scope of the tags
	 * @return               the status of the lock operation
	 */
	IStatus lockTags(final String destinationId, TagSearchScope scope);

	/**
	 * Unlocks the tags
	 *
	 * @param destinationId destination of ABAP Project
	 * @param scope         the scope of the tags
	 */
	void unlockTags(final String destinationId, TagSearchScope scope);
}
