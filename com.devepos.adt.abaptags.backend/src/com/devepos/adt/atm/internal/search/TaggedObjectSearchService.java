package com.devepos.adt.atm.internal.search;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.atm.AbapTagsPlugin;
import com.devepos.adt.atm.internal.messages.Messages;
import com.devepos.adt.atm.internal.tagging.TaggedObjectListContentHandler;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfoList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectListRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.search.ITaggedObjectSearchService;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.session.AdtSystemSessionFactory;

public class TaggedObjectSearchService implements ITaggedObjectSearchService {
  public static final String TRUE = "X"; //$NON-NLS-1$

  @Override
  public ITaggedObjectList findObjects(final String destinationId,
      final ITaggedObjectSearchParams parameters) {
    final var uriDiscovery = new TaggedObjectSearchUriDiscovery(destinationId);
    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);

    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(uriDiscovery.getTaggedObjectSearchUri(), session);
    restResource.addContentHandler(new TaggedObjectListContentHandler());
    restResource.addContentHandler(new TagSearchParamsContentHandler());

    return restResource.post(null, ITaggedObjectList.class, parameters);
  }

  @Override
  public List<ITaggedObjectInfo> findObjectInfos(final String destinationId,
      final ITaggedObjectListRequest request) {
    final var uriDiscovery = new TaggedObjectSearchUriDiscovery(destinationId);
    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);

    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(uriDiscovery.getTaggedObjectInfosGetListUri(), session);
    restResource.addContentHandler(new TaggedObjectListRequestContentHandler());
    restResource.addContentHandler(new TaggedObjectInfoListContentHandler());

    var response = restResource.post(null, ITaggedObjectInfoList.class, request);
    return response != null ? response.getTaggedObjectInfos() : null;
  }

  @Override
  public IStatus testGetObjectInfosFeatureAvailability(final IProject project) {
    var destinationId = DestinationUtil.getDestinationId(project);
    var uriDiscovery = new TaggedObjectSearchUriDiscovery(destinationId);
    return uriDiscovery.isResourceDiscoverySuccessful() && uriDiscovery
        .getTaggedObjectInfosGetListUri() != null ? Status.OK_STATUS
            : new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, String.format(
                Messages.TaggedObjectSearchService_taggedObjectInfoReseourceNotAvailable_xmsg, project.toString()));
  }

}
