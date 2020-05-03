package com.devepos.adt.abaptags.internal.tags.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.abaptags.AbapTagsPlugin;
import com.devepos.adt.abaptags.ITagList;
import com.devepos.adt.abaptags.tags.service.IAbapTagsService;
import com.devepos.adt.tools.base.project.AbapProjectProviderAccessor;
import com.devepos.adt.tools.base.project.IAbapProjectProvider;
import com.devepos.adt.tools.base.util.AdtUtil;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.IQueryParameter;
import com.sap.adt.communication.resources.IRestResource;
import com.sap.adt.communication.resources.QueryParameter;
import com.sap.adt.communication.resources.ResourceException;
import com.sap.adt.communication.resources.ResourceForbiddenException;
import com.sap.adt.communication.session.AdtSystemSessionFactory;
import com.sap.adt.communication.session.IEnqueueSystemSession;
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
	public IStatus testTagsFeatureAvailability(final IProject project) {
		final String destinationId = AdtUtil.getDestinationId(project);
		if (new AbapTagsUriDiscovery(destinationId).isResourceDiscoverySuccessful()) {
			return Status.OK_STATUS;
		} else {
			return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID,
				NLS.bind("ABAP Tags are not available in Project {0}", project.getName()));
		}
	}

	@Override
	public IStatus updateTags(final ITagList tags, final String destinationId, final boolean globalTags) {
		if (tags == null || tags.getTags().isEmpty()) {
			return Status.OK_STATUS;
		}
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(destinationId);
		if (projectProvider == null) {
			return Status.CANCEL_STATUS;
		}

		try {

			final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
			final ISystemSession session = projectProvider.createStatelessSession();

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTagsUri(), session);
			restResource.addContentHandler(new AbapTagsContentHandler());

			restResource.post(null, ITagList.class, tags, getParameters(globalTags, null));
			return Status.OK_STATUS;
		} catch (final ResourceException exc) {
			exc.printStackTrace();
			return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage());
		}
	}

	@Override
	public ITagList readTags(final String destinationId, final boolean globalTags) {
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

			return restResource.get(null, ITagList.class, getParameters(globalTags, null));

		} catch (final ResourceException exc) {
			exc.printStackTrace();
		}
		return null;
	}

	@Override
	public IStatus deleteTags(final ITagList tags, final String destinationId, final boolean globalTags) {
		if (tags == null || tags.getTags().isEmpty()) {
			return Status.OK_STATUS;
		}
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(destinationId);
		if (projectProvider == null) {
			return Status.CANCEL_STATUS;
		}

		try {

			final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
			final ISystemSession session = projectProvider.createStatelessSession();

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTagsUri(), session);
			restResource.addContentHandler(new AbapTagsContentHandler());

			restResource.post(null, ITagList.class, tags, getParameters(globalTags, CUSTOM_ACTION_BATCH_DELETE));
			return Status.OK_STATUS;
		} catch (final ResourceException exc) {
			exc.printStackTrace();
			return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage());
		}

	}

	@Override
	public IStatus lockTags(final String destinationId, final boolean globalTags) {
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(destinationId);
		if (projectProvider == null) {
			return Status.CANCEL_STATUS;
		}

		try {

			final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
			final IEnqueueSystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
				.getEnqueueSession(destinationId);

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTagsUri(), session);
			restResource.addContentHandler(new AbapTagsContentHandler());

			restResource.post(null, ITagList.class, getParameters(globalTags, CUSTOM_ACTION_LOCK));
			return Status.OK_STATUS;
		} catch (final ResourceForbiddenException exc) {
			return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage(), exc);
		} catch (final ResourceException exc) {
			return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage(), exc);
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
			final IEnqueueSystemSession session = AdtSystemSessionFactory.createSystemSessionFactory()
				.getEnqueueSession(destinationId);

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTagsUri(), session);
			restResource.addContentHandler(new AbapTagsContentHandler());

			restResource.post(null, ITagList.class, getParameters(globalTags, CUSTOM_ACTION_UNLOCK));

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
