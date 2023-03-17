package com.devepos.adt.atm.internal.tree;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.devepos.adt.atm.AbapTagsPlugin;
import com.devepos.adt.atm.internal.messages.Messages;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult;
import com.devepos.adt.atm.tree.ITaggedObjectTreeService;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.session.AdtSystemSessionFactory;

public class TaggedObjectTreeService implements ITaggedObjectTreeService {

  @Override
  public ITaggedObjectTreeResult findNodes(final String destinationId,
      final ITaggedObjectTreeRequest request) {

    final var uriDiscovery = new TaggedObjectTreeUriDiscovery(destinationId);
    final var session = AdtSystemSessionFactory.createSystemSessionFactory()
        .createStatelessSession(destinationId);

    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(uriDiscovery.getTaggedObjectTreeUri(), session);
    restResource.addContentHandler(new TaggedObjectTreeRequestContentHandler());
    restResource.addContentHandler(new TaggedObjectTreeResultContentHandler());

    return restResource.post(null, ITaggedObjectTreeResult.class, request);
  }

  @Override
  public IStatus testTreeFeatureAvailability(final IProject project) {
    final var destinationId = DestinationUtil.getDestinationId(project);
    var uriDiscovery = new TaggedObjectTreeUriDiscovery(destinationId);
    return uriDiscovery.isResourceDiscoverySuccessful() && uriDiscovery
        .getTaggedObjectTreeUri() != null ? Status.OK_STATUS
            : new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, String.format(
                Messages.TaggedObjectTreeService_TaggedObjectTreesNotAvailable_xmsg, project
                    .toString()));
  }

}
