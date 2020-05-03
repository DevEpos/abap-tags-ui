package com.devepos.adt.abaptags.tags.service;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.abaptags.ITagList;

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
	 * @param  globalTags    if <code>true</code> global tags will be created
	 * @return               the status of the update operation
	 */
	IStatus updateTags(ITagList tags, final String destinationId, final boolean globalTags);

	/**
	 * Reads ABAP Tags for the given destination ID
	 *
	 * @param destinationId destination of ABAP Project
	 * @param globalTags    if <code>true</code> global tags will be read
	 */
	ITagList readTags(final String destinationId, final boolean globalTags);

	/**
	 * Deletes the given Tags
	 *
	 * @param  tags          the tags to be deleted
	 * @param  destinationId destination of ABAP Project
	 * @param  globalTags    if <code>true</code> global tags will be deleted
	 * @return               the status of the delete operation
	 */
	IStatus deleteTags(ITagList tags, final String destinationId, final boolean globalTags);

	/**
	 * Locks the tags
	 *
	 * @param  destinationId destination of ABAP Project
	 * @param  globalTags    if <code>true</code> global tags will be locked
	 * @return               the status of the lock operation
	 */
	IStatus lockTags(final String destinationId, final boolean globalTags);

	/**
	 * Unlocks the tags
	 *
	 * @param destinationId destination of ABAP Project
	 * @param globalTags    if <code>true</code> global tags will be unlocked
	 */
	void unlockTags(final String destinationId, final boolean globalTags);
}
