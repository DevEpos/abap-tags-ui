package com.devepos.adt.abaptags.internal.tagging;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.abaptags.AbapTagsPlugin;
import com.devepos.adt.abaptags.IAbapTagsFactory;
import com.devepos.adt.abaptags.ITagPreviewInfo;
import com.devepos.adt.abaptags.ITaggedObjectList;
import com.devepos.adt.abaptags.tagging.IAdtObjTaggingService;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRefList;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.IRestResource;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.AdtSystemSessionFactory;
import com.sap.adt.communication.session.ISystemSession;

/**
 * Implementation of Service for Tagging ADT Objects
 *
 * @author stockbal
 */
public class AdtObjTaggingService implements IAdtObjTaggingService {

	@Override
	public ITagPreviewInfo getInformationForTagging(final String destinationId, final IAdtObjRefList adtObjRefs)
		throws CoreException {
		if (adtObjRefs == null || adtObjRefs.getObjectReferences().isEmpty()) {
			return null;
		}

		try {

			final ITagPreviewInfo previewInfo = IAbapTagsFactory.eINSTANCE.createTagPreviewInfo();
			previewInfo.getAdtObjectRefs().addAll(adtObjRefs.getObjectReferences());
			final AdtObjTaggingUriDiscovery uriDiscovery = new AdtObjTaggingUriDiscovery(destinationId);
			final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
				.createStatelessSession(destinationId);

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTagPreviewUri(), session);
			restResource.addContentHandler(new TagPreviewInfoContentHandler());

			return restResource.post(null, ITagPreviewInfo.class, previewInfo);
		} catch (final ResourceException exc) {
			exc.printStackTrace();
			throw new CoreException(new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage()));
		}
	}

	@Override
	public void saveTaggedObjects(final String destinationId, final ITaggedObjectList taggedObjectList) throws CoreException {
		if (taggedObjectList == null || taggedObjectList.getTaggedObjects().isEmpty()) {
			return;
		}

		try {

			final AdtObjTaggingUriDiscovery uriDiscovery = new AdtObjTaggingUriDiscovery(destinationId);
			final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
				.createStatelessSession(destinationId);

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTaggingUri(), session);
			restResource.addContentHandler(new TaggedObjectListContentHandler());

			restResource.post(null, ITaggedObjectList.class, taggedObjectList);
		} catch (final ResourceException exc) {
			exc.printStackTrace();
			throw new CoreException(new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage()));
		}
	}

}
