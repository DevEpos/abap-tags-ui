package com.devepos.adt.atm.internal.util;

import com.devepos.adt.base.util.UriDiscoveryBase;

/**
 * URI discovery base for ABAP Tags/Tagging API
 *
 * @author stockbal
 */
public class AbapTagsUriDiscoveryBase extends UriDiscoveryBase {

    private static final String DISCOVERY_PATH = "/devepos/adt/atm/discovery";

    protected AbapTagsUriDiscoveryBase(final String destination, final String discoveryScheme) {
        super(destination, DISCOVERY_PATH, discoveryScheme);
    }

}
