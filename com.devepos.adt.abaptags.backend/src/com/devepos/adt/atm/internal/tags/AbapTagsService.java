package com.devepos.adt.atm.internal.tags;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.atm.AbapTagsPlugin;
import com.devepos.adt.atm.internal.messages.Messages;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.tags.IAbapTagsService;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IUser;
import com.devepos.adt.base.ui.project.AbapProjectProviderAccessor;
import com.devepos.adt.base.ui.project.IAbapProjectProvider;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.communication.resources.AdtRestResourceFactory;
import com.sap.adt.communication.resources.IQueryParameter;
import com.sap.adt.communication.resources.IRestResource;
import com.sap.adt.communication.resources.QueryParameter;
import com.sap.adt.communication.resources.ResourceException;
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
    private static final String QUERY_PARAM_UNSHARE = "unshare"; //$NON-NLS-1$

    private static final String CUSTOM_ACTION_UNLOCK = "unlock"; //$NON-NLS-1$
    private static final String CUSTOM_ACTION_LOCK = "lock"; //$NON-NLS-1$
    private static final String CUSTOM_ACTION_MAKE_GLOBAL = "makeGlobal"; //$NON-NLS-1$
    private static final String CUSTOM_ACTION_BATCH_DELETE = "batchDelete"; //$NON-NLS-1$

    @Override
    public IStatus testTagsFeatureAvailability(final IProject project) {
        final String destinationId = DestinationUtil.getDestinationId(project);
        if (new AbapTagsUriDiscovery(destinationId).isResourceDiscoverySuccessful()) {
            return Status.OK_STATUS;
        }
        return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, NLS.bind(
            Messages.AbapTagsService_TagsNotSupported_xmsg, project.getName()));
    }

    @Override
    public IStatus testShareTagsFeatureAvailability(final IProject project) {
        final String destinationId = DestinationUtil.getDestinationId(project);
        final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
        if (uriDiscovery.isResourceDiscoverySuccessful() && uriDiscovery.getShareTagsUri() != null) {
            return Status.OK_STATUS;
        }
        return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, NLS.bind(
            Messages.AbapTagsService_ShareTagsNotSupported_xmsg, project.getName()));
    }

    @Override
    public IStatus updateTags(final ITagList tags, final String destinationId, final TagSearchScope scope) {
        if (tags == null || tags.getTags().isEmpty()) {
            return Status.OK_STATUS;
        }
        final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(
            destinationId);
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
    public IStatus makeTagsGlobal(final String destinationId, final ITagList tagList) {
        if (tagList == null || tagList.getTags().isEmpty()) {
            return Status.OK_STATUS;
        }
        final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(
            destinationId);
        if (projectProvider == null) {
            return Status.CANCEL_STATUS;
        }

        try {

            final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
            final ISystemSession session = projectProvider.createStatelessSession();

            final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
                .createRestResource(uriDiscovery.getTagsUri(), session);
            restResource.addContentHandler(new AbapTagsContentHandler());

            restResource.post(null, ITagList.class, tagList, new QueryParameter(QUERY_PARAM_ACTION,
                CUSTOM_ACTION_MAKE_GLOBAL));
            return Status.OK_STATUS;
        } catch (final ResourceException exc) {
            exc.printStackTrace();
            return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage());
        }
    }

    @Override
    public IStatus shareTags(final String destinationId, final ITagList tagList) {
        if (tagList == null || tagList.getTags().isEmpty()) {
            return Status.OK_STATUS;
        }
        final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(
            destinationId);
        if (projectProvider == null) {
            return Status.CANCEL_STATUS;
        }

        try {

            final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
            final ISystemSession session = projectProvider.createStatelessSession();

            final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
                .createRestResource(uriDiscovery.getShareTagsUri(), session);
            restResource.addContentHandler(new AbapTagsContentHandler());

            restResource.post(null, ITagList.class, tagList);
            return Status.OK_STATUS;
        } catch (final ResourceException exc) {
            exc.printStackTrace();
            return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage());
        }
    }

    @Override
    public IStatus unshareTags(final String destinationId, final ITagList tagList) {
        if (tagList == null || tagList.getTags().isEmpty()) {
            return Status.OK_STATUS;
        }
        final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(
            destinationId);
        if (projectProvider == null) {
            return Status.CANCEL_STATUS;
        }

        try {

            final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
            final ISystemSession session = projectProvider.createStatelessSession();

            final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
                .createRestResource(uriDiscovery.getShareTagsUri(), session);
            restResource.addContentHandler(new AbapTagsContentHandler());

            restResource.post(null, ITagList.class, tagList, new QueryParameter(QUERY_PARAM_UNSHARE, "X")); //$NON-NLS-1$
            return Status.OK_STATUS;
        } catch (final ResourceException exc) {
            exc.printStackTrace();
            return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage());
        }
    }

    @Override
    public List<IUser> getSharedUsers(final String destinationId, final String tagId) {
        if (StringUtil.isEmpty(tagId)) {
            return null;
        }
        final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(
            destinationId);
        if (projectProvider == null) {
            return null;
        }

        try {

            final AbapTagsUriDiscovery uriDiscovery = new AbapTagsUriDiscovery(destinationId);
            final ISystemSession session = projectProvider.createStatelessSession();

            final IRestResource restResource = AdtRestResourceFactory.createRestResourceFactory()
                .createRestResource(uriDiscovery.getSharedTagInfoUri(tagId), session);
            restResource.addContentHandler(new AbapTagsContentHandler());

            final ITagList tagList = restResource.get(null, ITagList.class);
            if (tagList != null && !tagList.getTags().isEmpty()) {
                return tagList.getTags().get(0).getSharedUsers();
            }
        } catch (final ResourceException exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @Override
    public ITagList findTags(final String destinationId, final TagSearchScope scope, final String query) {
        final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(
            destinationId);
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
        final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(
            destinationId);
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
        final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(
            destinationId);
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
        final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(
            destinationId);
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
        } catch (final ResourceException exc) {
            return new Status(IStatus.ERROR, AbapTagsPlugin.PLUGIN_ID, exc.getMessage(), exc);
        }
    }

    @Override
    public void unlockTags(final String destinationId, final TagSearchScope scope) {
        final IAbapProjectProvider projectProvider = AbapProjectProviderAccessor.getProviderForDestination(
            destinationId);
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
