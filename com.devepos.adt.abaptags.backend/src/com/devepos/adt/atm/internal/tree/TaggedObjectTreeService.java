package com.devepos.adt.atm.internal.tree;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult;
import com.devepos.adt.atm.tree.ITaggedObjectTreeService;
import com.devepos.adt.base.ui.project.AbapProjectProviderAccessor;
import com.sap.adt.communication.resources.AdtRestResourceFactory;

public class TaggedObjectTreeService implements ITaggedObjectTreeService {

  @Override
  public ITaggedObjectTreeResult findNodes(final String destinationId,
      final ITaggedObjectTreeRequest request) {

    final var projectProvider = AbapProjectProviderAccessor.getProviderForDestination(
        destinationId);
    if (projectProvider == null) {
      return null;
    }

    final var uriDiscovery = new TaggedObjectTreeUriDiscovery(destinationId);
    final var session = projectProvider.createStatelessSession();

    final var restResource = AdtRestResourceFactory.createRestResourceFactory()
        .createRestResource(uriDiscovery.getTaggedObjectTreeUri(), session);
    restResource.addContentHandler(new TaggedObjectTreeRequestContentHandler());
    restResource.addContentHandler(new TaggedObjectTreeResultContentHandler());

    return restResource.post(null, ITaggedObjectTreeResult.class, request);
  }

}
