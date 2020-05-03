package com.devepos.adt.abaptags.tagging.service;

import com.devepos.adt.abaptags.internal.tagging.service.AdtObjTaggingService;

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
