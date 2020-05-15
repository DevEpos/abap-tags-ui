package com.devepos.adt.abaptags.tagging;

import org.eclipse.core.runtime.CoreException;

import com.devepos.adt.abaptags.ITagPreviewInfo;
import com.devepos.adt.abaptags.ITaggedObject;
import com.devepos.adt.abaptags.ITaggedObjectList;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRefList;

/**
 * Service to handle all things concerning tagging ADT objects
 *
 * @author stockbal
 */
public interface IAdtObjTaggingService {

	/**
	 * Retrieves information for tagging ADT objects
	 *
	 * @param  destinationId destination Id of ABAP Project
	 * @param  adtObjRefs    list of ADT Object references
	 * @return
	 * @throws CoreException
	 */
	ITagPreviewInfo getInformationForTagging(String destinationId, IAdtObjRefList adtObjRefs) throws CoreException;

	/**
	 * Saves the given list of {@link ITaggedObject}s in the project with the given
	 * destination id
	 * 
	 * @param  destinationId    destination Id of ABAP Project
	 * @param  taggedObjectList list of {@link ITaggedObject}s
	 * @throws CoreException
	 */
	void saveTaggedObjects(String destinationId, ITaggedObjectList taggedObjectList) throws CoreException;
}
