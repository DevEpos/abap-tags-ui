package com.devepos.adt.atm.internal.tagging;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.atm.AbapTagsPlugin;
import com.devepos.adt.atm.internal.messages.Messages;
import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.ITagPreviewInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeleteRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckResult;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.tagging.IAdtObjTaggingService;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtObjRefList;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.QueryParameter;
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
  public IStatus deleteTaggedObjects(final String destinationId,
      final ITaggedObjectDeleteRequest deleteRequest) {
    final var uriDiscovery = new AdtObjTaggingUriDiscovery(destinationId);
    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);

    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(uriDiscovery.getTaggedObjectDeletionUri(), session);
    restResource.addContentHandler(new TaggedObjectDeleteRequestContentHandler());

    try {
      restResource.post(null, null, deleteRequest);
    } catch (ResourceException exc) {
      return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage());
    }
    return Status.OK_STATUS;
  }

  @Override
  public ITagPreviewInfo getInformationForTagging(final String destinationId,
      final IAdtObjRefList adtObjRefs) throws CoreException {
    if (adtObjRefs == null || adtObjRefs.getObjectReferences().isEmpty()) {
      return null;
    }

    try {

      final var previewInfo = IAbapTagsFactory.eINSTANCE.createTagPreviewInfo();
      previewInfo.getAdtObjectRefs().addAll(adtObjRefs.getObjectReferences());
      final var uriDiscovery = new AdtObjTaggingUriDiscovery(destinationId);
      final ISystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destinationId);

      final var restResource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(uriDiscovery.getTagPreviewUri(), session);
      restResource.addContentHandler(new TagPreviewInfoContentHandler());

      return restResource.post(null, ITagPreviewInfo.class, previewInfo);
    } catch (final ResourceException exc) {
      exc.printStackTrace();
      throw new CoreException(new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc
          .getMessage()));
    }
  }

  @Override
  public List<ITaggedObject> getObjectInfo(final String destinationId, final String objectUri)
      throws CoreException {
    try {

      final var uriDiscovery = new AdtObjTaggingUriDiscovery(destinationId);
      final var session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destinationId);

      final var restResource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(uriDiscovery.getTaggingUri(), session);
      restResource.addContentHandler(new TaggedObjectListContentHandler());

      final var objectList = restResource.get(null, ITaggedObjectList.class, new QueryParameter(
          "objectUri", objectUri)); //$NON-NLS-1$
      return objectList != null && !objectList.getTaggedObjects().isEmpty() ? objectList
          .getTaggedObjects() : null;
    } catch (final ResourceException exc) {
      exc.printStackTrace();
      throw new CoreException(new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc
          .getMessage()));
    }
  }

  @Override
  public ITaggedObjectDeletionCheckResult runTaggedObjectDeletionCheck(final String destinationId,
      final ITaggedObjectDeletionCheckRequest checkRequest) {

    final var uriDiscovery = new AdtObjTaggingUriDiscovery(destinationId);
    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);

    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(uriDiscovery.getTaggedObjectDelCheckUri(), session);
    restResource.addContentHandler(new TaggedObjectDelCheckRequestContentHandler());
    restResource.addContentHandler(new TaggedObjectDelCheckResultContentHandler());

    return restResource.post(null, ITaggedObjectDeletionCheckResult.class, checkRequest);
  }

  @Override
  public void saveTaggedObjects(final String destinationId,
      final ITaggedObjectList taggedObjectList) throws CoreException {
    if (taggedObjectList == null || taggedObjectList.getTaggedObjects().isEmpty()) {
      return;
    }

    try {

      final var uriDiscovery = new AdtObjTaggingUriDiscovery(destinationId);
      final var session = AdtSystemSessionFactory.createSystemSessionFactory()
          .createStatelessSession(destinationId);

      final var restResource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(uriDiscovery.getTaggingUri(), session);
      restResource.addContentHandler(new TaggedObjectListContentHandler());

      restResource.post(null, ITaggedObjectList.class, taggedObjectList);
    } catch (final ResourceException exc) {
      exc.printStackTrace();
      throw new CoreException(new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc
          .getMessage()));
    }
  }

  @Override
  public IStatus testTaggedObjectDeletionFeatureAvailability(final IProject project) {
    final var destinationId = DestinationUtil.getDestinationId(project);
    final var uriDiscovery = new AdtObjTaggingUriDiscovery(destinationId);
    if (uriDiscovery.isResourceDiscoverySuccessful() && uriDiscovery
        .getTaggedObjectDeletionUri() != null) {
      return Status.OK_STATUS;
    }
    return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, NLS.bind(
        Messages.AdtObjTaggingService_taggedObjectDeletionNotAvailable_xmsg,
        project.getName()));
  }

}
