package com.devepos.adt.atm.internal.tags;

import java.net.URI;

import com.devepos.adt.atm.internal.util.AbapTagsUriDiscoveryBase;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * URI Discovery for ABAP Tag management
 *
 * @author stockbal
 */
public class AbapTagsUriDiscovery extends AbapTagsUriDiscoveryBase {
    private static final String TAG_ID = "tagId";
    private static final String DISCOVERY_SCHEME = "http://www.devepos.com/adt/atm"; //$NON-NLS-1$
    private static final String DISCOVERY_RELATION_ROOT = "http://www.devepos.com/adt/relations/atm"; //$NON-NLS-1$
    private static final String DISCOVERY_RELATION_SHARED_TAG_INFO = DISCOVERY_RELATION_ROOT + "/tags/share/info"; //$NON-NLS-1$

    private static final String DISCOVERY_TERM_TAGS = "tags"; //$NON-NLS-1$
    private static final String DISCOVERY_TERM_SHARE_TAGS = "shareTags"; //$NON-NLS-1$

    public AbapTagsUriDiscovery(final String destination) {
        super(destination, DISCOVERY_SCHEME);
    }

    /**
     * Retrieves Resource URI for the ABAP Tags API
     *
     * @return Resource URI for the ABAP Tags API
     */
    public URI getTagsUri() {
        return getUriFromCollectionMember(DISCOVERY_TERM_TAGS);
    }

    /**
     * Retrieves Resource URI for sharing/unsharing Tags
     * 
     * @return Resource URI for sharing/unsharing Tags
     */
    public URI getShareTagsUri() {
        return getUriFromCollectionMember(DISCOVERY_TERM_SHARE_TAGS);
    }

    /**
     * Returns URI for retrieving information about shared tag
     * 
     * @param tagId identifier of user tag
     * @return URI for retrieving information about shared tag
     */
    public URI getSharedTagInfoUri(final String tagId) {
        final IAdtUriTemplate template = getTemplate(DISCOVERY_TERM_SHARE_TAGS, DISCOVERY_RELATION_SHARED_TAG_INFO);
        if (template == null) {
            return null;
        }
        if (!template.containsVariable(TAG_ID)) {
            return null;
        }
        template.set(TAG_ID, tagId);
        return URI.create(template.expand());
    }

}
