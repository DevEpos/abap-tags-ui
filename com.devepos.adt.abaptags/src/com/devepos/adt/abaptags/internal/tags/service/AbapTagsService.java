package com.devepos.adt.abaptags.internal.tags.service;

import java.util.ArrayList;
import java.util.List;

import com.devepos.adt.abaptags.ITags;
import com.devepos.adt.abaptags.tags.service.IAbapTagsService;
import com.devepos.adt.abaptags.tags.service.TagsNotLockedException;
import com.devepos.adt.tools.base.project.AbapProjectProviderAccessor;
import com.devepos.adt.tools.base.project.IAbapProjectProvider;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.IQueryParameter;
import com.sap.adt.communication.resources.IRestResource;
import com.sap.adt.communication.resources.QueryParameter;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.session.ISystemSession;

/**
 * Implementation of the ABAP Tags Service for managing ABAP Tags
 *
 * @author stockbal
 */
public class AbapTagsService implements IAbapTagsService {

	private static final String CUSTOM_ACTION_UNLOCK = "unlock"; //$NON-NLS-1$
	private static final String CUSTOM_ACTION_LOCK = "lock"; //$NON-NLS-1$
	private static final String CUSTOM_ACTION_BATCH_DELETE = "batchDelete"; //$NON-NLS-1$

	@Override
	public void createTags(final ITags tags, final String destinationId, final boolean globalTags) {
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(destinationId);
		if (projectProvider == null) {
			return;
		}

		try {

			final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
			final ISystemSession session = projectProvider.createStatelessSession();

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTagsUri(), session);
			restResource.addContentHandler(new AbapTagsContentHandler());

			restResource.post(null, ITags.class, tags, getParameters(globalTags, null));

		} catch (final ResourceException exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public ITags readTags(final String destinationId, final boolean globalTags) {
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(destinationId);
		if (projectProvider == null) {
			return null;
		}

		try {

			final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
			final ISystemSession session = projectProvider.createStatelessSession();

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTagsUri(), session);
			restResource.addContentHandler(new AbapTagsContentHandler());

			return restResource.get(null, ITags.class, getParameters(globalTags, null));

		} catch (final ResourceException exc) {
			exc.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteTags(final ITags tags, final String destinationId, final boolean globalTags) {
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(destinationId);
		if (projectProvider == null) {
			return;
		}

		try {

			final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
			final ISystemSession session = projectProvider.createStatelessSession();

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTagsUri(), session);
			restResource.addContentHandler(new AbapTagsContentHandler());

			restResource.get(null, ITags.class, getParameters(globalTags, CUSTOM_ACTION_BATCH_DELETE));

		} catch (final ResourceException exc) {
			exc.printStackTrace();
		}

	}

	@Override
	public void lockTags(final String destinationId, final boolean globalTags) throws TagsNotLockedException {
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(destinationId);
		if (projectProvider == null) {
			return;
		}

		try {

			final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
			final ISystemSession session = projectProvider.createStatelessSession();

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTagsUri(), session);
			restResource.addContentHandler(new AbapTagsContentHandler());

			restResource.post(null, ITags.class, getParameters(globalTags, CUSTOM_ACTION_LOCK));

		} catch (final ResourceException exc) {
			throw new TagsNotLockedException();
		}
	}

	@Override
	public void unlockTags(final String destinationId, final boolean globalTags) {
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(destinationId);
		if (projectProvider == null) {
			return;
		}

		try {

			final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
			final ISystemSession session = projectProvider.createStatelessSession();

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTagsUri(), session);
			restResource.addContentHandler(new AbapTagsContentHandler());

			restResource.post(null, ITags.class, getParameters(globalTags, CUSTOM_ACTION_UNLOCK));

		} catch (final ResourceException exc) {
			exc.printStackTrace();
		}
	}

	private IQueryParameter[] getParameters(final boolean globalTags, final String customAction) {
		final List<IQueryParameter> params = new ArrayList<>();
		if (globalTags) {
			params.add(new QueryParameter("globalTags", "X")); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (customAction != null && !customAction.isEmpty()) {
			params.add(new QueryParameter("action", customAction)); //$NON-NLS-1$
		}

		return params.toArray(new IQueryParameter[params.size()]);
	}
}
