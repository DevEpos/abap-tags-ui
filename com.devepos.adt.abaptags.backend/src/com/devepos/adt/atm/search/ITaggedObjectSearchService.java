package com.devepos.adt.atm.search;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
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
	 * @param  destinationId destination Id for ABAP project
	 * @param  parameters    instance of search parameters
	 * @return               list of found objects
	 */
	ITaggedObjectList findObjects(String destinationId, ITaggedObjectSearchParams parameters);
}
