package com.devepos.adt.atm.tagging;

import org.eclipse.core.runtime.CoreException;

import com.devepos.adt.atm.model.abaptags.ITagPreviewInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.base.model.adtbase.IAdtObjRefList;

/**
 * Service to handle all things concerning tagging ADT objects
 *
 * @author stockbal
 */
public interface IAdtObjTaggingService {

    /**
     * Retrieves information for tagging ADT objects
     *
     * @param destinationId destination Id of ABAP Project
     * @param adtObjRefs    list of ADT Object references
     * @return
     * @throws CoreException
     */
    ITagPreviewInfo getInformationForTagging(String destinationId, IAdtObjRefList adtObjRefs) throws CoreException;

    /**
     * Saves the given list of {@link ITaggedObject}s in the project with the given
     * destination id
     *
     * @param destinationId    destination Id of ABAP Project
     * @param taggedObjectList list of {@link ITaggedObject}s
     * @throws CoreException
     */
    void saveTaggedObjects(String destinationId, ITaggedObjectList taggedObjectList) throws CoreException;

    /**
     * Retrieves tagged object information about object with {@code objectUri}.
     *
     * @param destinationId destination Id of ABAP Project
     * @param objectUri     uri of an ADT object
     * @return the found object information
     * @throws CoreException
     */
    ITaggedObject getObject(String destinationId, String objectUri) throws CoreException;

    /**
     * Deletes the tags from the ADT objects
     *
     * @param destinationId destination Id of ABAP project
     * @param tgobjList     list of tagged objects with tags that should be deleted
     * @throws CoreException
     */
    void deleteTags(String destinationId, ITaggedObjectList tgobjList) throws CoreException;
}
