package com.devepos.adt.atm.internal.tree;

import com.devepos.adt.atm.internal.search.TagSearchParamsContentHandler;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult;
import com.devepos.adt.atm.tree.ITaggedObjectTreeService;
import com.devepos.adt.base.ui.project.AbapProjectProviderAccessor;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.ResourceException;

public class TaggedObjectTreeService implements ITaggedObjectTreeService {

  @Override
  public ITaggedObjectTreeResult findNodes(String destinationId,
      ITaggedObjectSearchParams parameters) {

    final var projectProvider = AbapProjectProviderAccessor.getProviderForDestination(
        destinationId);
    if (projectProvider == null) {
      return null;
    }

    try {

      final var uriDiscovery = new TaggedObjectTreeUriDiscovery(destinationId);
      final var session = projectProvider.createStatelessSession();

      final var restResource = AdtRestResourceFactory.createRestResourceFactory()
          .createRestResource(uriDiscovery.getTaggedObjectTreeUri(), session);
      restResource.addContentHandler(new TagSearchParamsContentHandler());
      restResource.addContentHandler(new TaggedObjectTreeResultContentHandler());

      return restResource.post(null, ITaggedObjectTreeResult.class, parameters);

    } catch (final ResourceException exc) {
      exc.printStackTrace();
    }
    return null;
  }

}
