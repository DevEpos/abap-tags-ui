package com.devepos.adt.atm.internal.search;

import com.devepos.adt.atm.internal.tagging.TaggedObjectListContentHandler;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.search.ITaggedObjectSearchService;
import com.devepos.adt.tools.base.project.AbapProjectProviderAccessor;
import com.devepos.adt.tools.base.project.IAbapProjectProvider;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.IRestResource;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.ISystemSession;

public class TaggedObjectSearchService implements ITaggedObjectSearchService {
	public static final String TRUE = "X"; //$NON-NLS-1$

	@Override
	public ITaggedObjectList findObjects(final String destinationId, final ITaggedObjectSearchParams parameters) {
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(destinationId);
		if (projectProvider == null) {
			return null;
		}

		try {

			final TaggedObjectSearchUriDiscovery uriDiscovery = new TaggedObjectSearchUriDiscovery(destinationId);
			final ISystemSession session = projectProvider.createStatelessSession();

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTaggedObjectSearchUri(), session);
			restResource.addContentHandler(new TaggedObjectListContentHandler());
			restResource.addContentHandler(new TagSearchParamsContentHandler());

			return restResource.post(null, ITaggedObjectList.class, parameters);

		} catch (final ResourceException exc) {
			exc.printStackTrace();
		}
		return null;
	}

}
