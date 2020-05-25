package com.devepos.adt.abaptags.internal.tagging;

import java.net.URI;

import org.eclipse.core.runtime.Assert;

import com.devepos.adt.abaptags.internal.util.AbapTagsUriDiscoveryBase;
import com.devepos.adt.tools.base.util.StringUtil;
import com.sap.adt.compatibility.uritemplate.IAdtUriTemplate;

/**
 * URI Discovery for ADT Object Tagging
 *
 * @author stockbal
 */
public class AdtObjTaggingUriDiscovery extends AbapTagsUriDiscoveryBase {
	private static final String DISCOVERY_SCHEME = "http://www.devepos.com/adt/atm";
	private static final String DISCOVERY_RELATION_TAGS = "http://www.devepos.com/adt/relations/atm/taggedobjects";
	private static final String DISCOVERY_TEMPLATE_TAG_PREVIEW = "/previewInfo"; //$NON-NLS-1$
	private static final String DISCOVERY_TERM_TAGS = "objecttagging";

	public AdtObjTaggingUriDiscovery(final String destination) {
		super(destination, DISCOVERY_SCHEME);
	}

	/**
	 * Retrieves Resource URI for tagging ADT objects
	 *
	 * @return Resource URI for tagging ADT objects
	 */
	public URI getTaggingUri() {
		return getUriFromCollectionMember(DISCOVERY_TERM_TAGS);
	}

	/**
	 * Retrieves resource URI for reading tags of a tagged object
	 *
	 * @param  objectUri uri of ADT object whose tags should be read
	 * @return           resource URI for reading tags of a tagged object
	 */
	public URI getUriForInfoOfTaggedObject(final String objectUri) {
		Assert.isTrue(!StringUtil.isEmpty(objectUri), "Parmeter 'objectUri' must be filled");
		final URI taggedObjectsUri = getTaggingUri();
		if (taggedObjectsUri == null) {
			return null;
		}
		return taggedObjectsUri.resolve("/" + objectUri + "/tags");
	}

	/**
	 * Returns Resource URI for retrieving preview before tagging of ADT objects can
	 * take place
	 *
	 * @return
	 */
	public URI getTagPreviewUri() {
		final IAdtUriTemplate template = getTemplate(DISCOVERY_TERM_TAGS,
			DISCOVERY_RELATION_TAGS + DISCOVERY_TEMPLATE_TAG_PREVIEW);
		if (template != null) {
			return URI.create(template.getTemplate());
		}
		return null;
	}

}
