package com.devepos.adt.abaptags.internal.search;

import java.util.ArrayList;
import java.util.List;

import com.devepos.adt.abaptags.ITaggedObjectList;
import com.devepos.adt.abaptags.internal.tagging.TaggedObjectListContentHandler;
import com.devepos.adt.abaptags.search.ITaggedObjectSearchParameters;
import com.devepos.adt.abaptags.search.ITaggedObjectSearchService;
import com.devepos.adt.tools.base.project.AbapProjectProviderAccessor;
import com.devepos.adt.tools.base.project.IAbapProjectProvider;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.IQueryParameter;
import com.sap.adt.communication.resources.IRestResource;
import com.sap.adt.communication.resources.QueryParameter;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.ISystemSession;

public class TaggedObjectSearchService implements ITaggedObjectSearchService {
	public static final String TRUE = "X"; //$NON-NLS-1$

	@Override
	public ITaggedObjectList findObjects(final String destinationId, final ITaggedObjectSearchParameters parameters) {
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

			return restResource.get(null, ITaggedObjectList.class, getQueryParameters(parameters));

		} catch (final ResourceException exc) {
			exc.printStackTrace();
		}
		return null;
	}

	private IQueryParameter[] getQueryParameters(final ITaggedObjectSearchParameters parameters) {
		final List<IQueryParameter> params = new ArrayList<>();
		params.add(new QueryParameter("query", parameters.getQuery())); //$NON-NLS-1$
		params.add(new QueryParameter("tag", parameters.getTags())); //$NON-NLS-1$
		params.add(new QueryParameter("scope", parameters.getSearchScope().toString())); //$NON-NLS-1$
		params.add(new QueryParameter("maxResults", String.valueOf(parameters.getMaxResults()))); //$NON-NLS-1$
		if (parameters.isMatchAllTags()) {
			params.add(new QueryParameter("matchAllTags", TRUE)); //$NON-NLS-1$
		}
		if (parameters.isWithTagInfo()) {
			params.add(new QueryParameter("withTagInfo", TRUE)); //$NON-NLS-1$
		}
		return params.toArray(new IQueryParameter[params.size()]);
	}

}
