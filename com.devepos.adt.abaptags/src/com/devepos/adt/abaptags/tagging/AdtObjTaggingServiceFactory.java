package com.devepos.adt.abaptags.tagging;

import com.devepos.adt.abaptags.internal.tagging.AdtObjTaggingService;

/**
 * Factory for Tagging Services
 * 
 * @author stockbal
 */
public class AdtObjTaggingServiceFactory {

	/**
	 * Creates new service instance for taggging ADT Objects
	 *
	 * @return
	 */
	public static IAdtObjTaggingService createTaggingService() {
		return new AdtObjTaggingService();
	}
}
