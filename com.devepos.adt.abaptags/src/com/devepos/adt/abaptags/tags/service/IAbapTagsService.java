package com.devepos.adt.abaptags.tags.service;

import org.eclipse.core.runtime.IStatus;

import com.devepos.adt.abaptags.ITags;

/**
 * Public interface for ABAP Tags service
 *
 * @author stockbal
 */
public interface IAbapTagsService {
	/**
	 * Returns {@code true} if the ABAP Tags feature is available at the given
	 * destination
	 * 
	 * @param  destinationId the destination of an ABAP Project
	 * @return               {@code true} if the ABAP Tags feature is available at
	 *                       the given destination
	 */
	boolean isTagsFeatureAvailable(String destinationId);

	/**
	 * Creates/updates tags
	 *
	 * @param  tags          tags to be saved
	 * @param  destinationId destination of ABAP Project
	 * @param  globalTags    if <code>true</code> global tags will be created
	 * @return               the status of the update operation
	 */
	IStatus updateTags(ITags tags, final String destinationId, final boolean globalTags);

	/**
	 * Reads ABAP Tags for the given destination ID
	 *
	 * @param destinationId destination of ABAP Project
	 * @param globalTags    if <code>true</code> global tags will be read
	 */
	ITags readTags(final String destinationId, final boolean globalTags);

	/**
	 * Deletes the given Tags
	 *
	 * @param  tags          the tags to be deleted
	 * @param  destinationId destination of ABAP Project
	 * @param  globalTags    if <code>true</code> global tags will be deleted
	 * @return               the status of the delete operation
	 */
	IStatus deleteTags(ITags tags, final String destinationId, final boolean globalTags);

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
