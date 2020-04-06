package com.devepos.adt.abaptags.tags.service;

import com.devepos.adt.abaptags.ITags;

/**
 * Public interface for ABAP Tags service
 *
 * @author stockbal
 */
public interface IAbapTagsService {
	/**
	 * Creates new tags
	 *
	 * @param tags          tags to be saved
	 * @param destinationId destination of ABAP Project
	 * @param globalTags    if <code>true</code> global tags will be created
	 */
	void createTags(ITags tags, final String destinationId, final boolean globalTags);

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
	 * @param tags          the tags to be deleted
	 * @param destinationId destination of ABAP Project
	 * @param globalTags    if <code>true</code> global tags will be deleted
	 */
	void deleteTags(ITags tags, final String destinationId, final boolean globalTags);

	/**
	 * Locks the tags
	 *
	 * @param  destinationId          destination of ABAP Project
	 * @param  globalTags             if <code>true</code> global tags will be
	 *                                locked
	 * @throws TagsNotLockedException thrown if tags could not be locked
	 */
	void lockTags(final String destinationId, final boolean globalTags) throws TagsNotLockedException;

	/**
	 * Unlocks the tags
	 *
	 * @param destinationId destination of ABAP Project
	 * @param globalTags    if <code>true</code> global tags will be unlocked
	 */
	void unlockTags(final String destinationId, final boolean globalTags);
}
