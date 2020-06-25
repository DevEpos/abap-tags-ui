package com.devepos.adt.atm.internal.tags;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.atm.AbapTagsPlugin;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.tags.IAbapTagsService;
import com.devepos.adt.tools.base.destinations.DestinationUtil;
import com.devepos.adt.tools.base.project.AbapProjectProviderAccessor;
import com.devepos.adt.tools.base.project.IAbapProjectProvider;
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

	private static final String QUERY_PARAM_SCOPE = "scope"; //$NON-NLS-1$
	private static final String QUERY_PARAM_ACTION = "action"; //$NON-NLS-1$
	private static final String QUERY_PARAM_QUERY = "query"; //$NON-NLS-1$
	private static final String QUERY_PARAM_WITH_OBJECT_COUNT = "withObjectCount"; //$NON-NLS-1$
	private static final String CUSTOM_ACTION_UNLOCK = "unlock"; //$NON-NLS-1$
	private static final String CUSTOM_ACTION_LOCK = "lock"; //$NON-NLS-1$
	private static final String CUSTOM_ACTION_BATCH_DELETE = "batchDelete"; //$NON-NLS-1$

	@Override
	public IStatus testTagsFeatureAvailability(final IProject project) {
		final String destinationId = DestinationUtil.getDestinationId(project);
		if (new AbapTagsUriDiscovery(destinationId).isResourceDiscoverySuccessful()) {
			return Status.OK_STATUS;
		} else {
			return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID,
				NLS.bind("ABAP Tags are not available in Project {0}", project.getName()));
		}
	}

	@Override
	public IStatus updateTags(final ITagList tags, final String destinationId, final TagSearchScope scope) {
		if (tags == null || tags.getTags().isEmpty()) {
			return Status.OK_STATUS;
		}
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor
			.getProviderForDestination(destinationId);
		if (projectProvider == null) {
			return Status.CANCEL_STATUS;
		}

		try {

			final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
			final ISystemSession session = projectProvider.createStatelessSession();

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTagsUri(), session);
			restResource.addContentHandler(new AbapTagsContentHandler());

			restResource.post(null, ITagList.class, tags, new QueryParameter(QUERY_PARAM_SCOPE, scope.toString()));
			return Status.OK_STATUS;
		} catch (final ResourceException exc) {
			exc.printStackTrace();
			return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage());
		}
	}

	@Override
	public ITagList findTags(final String destinationId, final TagSearchScope scope, final String query) {
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor
			.getProviderForDestination(destinationId);
		if (projectProvider == null) {
			return null;
		}

		try {

			final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
			final ISystemSession session = projectProvider.createStatelessSession();

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTagsUri(), session);
			restResource.addContentHandler(new AbapTagsContentHandler());

			return restResource.get(null, ITagList.class, new QueryParameter(QUERY_PARAM_SCOPE, scope.toString()),
				new QueryParameter(QUERY_PARAM_QUERY, query));

		} catch (final ResourceException exc) {
			exc.printStackTrace();
		}
		return null;
	}

	@Override
	public ITagList readTags(final String destinationId, final TagSearchScope scope, final boolean withObjectCount) {
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor
			.getProviderForDestination(destinationId);
		if (projectProvider == null) {
			return null;
		}

		try {

			final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
			final ISystemSession session = projectProvider.createStatelessSession();

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTagsUri(), session);
			restResource.addContentHandler(new AbapTagsContentHandler());

			final List<IQueryParameter> params = new ArrayList<>();
			params.add(new QueryParameter(QUERY_PARAM_SCOPE, scope.toString()));
			if (withObjectCount) {
				params.add(new QueryParameter(QUERY_PARAM_WITH_OBJECT_COUNT, "X")); //$NON-NLS-1$
			}

			return restResource.get(null, ITagList.class, params.toArray(new QueryParameter[params.size()]));

		} catch (final ResourceException exc) {
			exc.printStackTrace();
		}
		return null;
	}

	@Override
	public IStatus deleteTags(final ITagList tags, final String destinationId, final TagSearchScope scope) {
		if (tags == null || tags.getTags().isEmpty()) {
			return Status.OK_STATUS;
		}
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor
			.getProviderForDestination(destinationId);
		if (projectProvider == null) {
			return Status.CANCEL_STATUS;
		}

		try {

			final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
			final ISystemSession session = projectProvider.createStatelessSession();

			final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
				.createRestResource(uriDiscovery.getTagsUri(), session);
			restResource.addContentHandler(new AbapTagsContentHandler());

			restResource.post(null, ITagList.class, tags, new QueryParameter(QUERY_PARAM_SCOPE, scope.toString()),
				new QueryParameter(QUERY_PARAM_ACTION, CUSTOM_ACTION_BATCH_DELETE));
			return Status.OK_STATUS;
		} catch (final ResourceException exc) {
			exc.printStackTrace();
			return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage());
		}

	}

	@Override
	public IStatus lockTags(final String destinationId, final TagSearchScope scope) {
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor
			.getProviderForDestination(destinationId);
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

			restResource.post(null, ITagList.class, new QueryParameter(QUERY_PARAM_SCOPE, scope.toString()),
				new QueryParameter(QUERY_PARAM_ACTION, CUSTOM_ACTION_LOCK));
			return Status.OK_STATUS;
		} catch (final ResourceForbiddenException exc) {
			return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage(), exc);
		} catch (final ResourceException exc) {
			return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage(), exc);
		}
	}

	@Override
	public void unlockTags(final String destinationId, final TagSearchScope scope) {
		final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor
			.getProviderForDestination(destinationId);
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

			restResource.post(null, ITagList.class, new QueryParameter(QUERY_PARAM_SCOPE, scope.toString()),
				new QueryParameter(QUERY_PARAM_ACTION, CUSTOM_ACTION_UNLOCK));

		} catch (final ResourceException exc) {
			exc.printStackTrace();
		}
	}

}
