package com.devepos.adt.atm.internal.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "com.devepos.adt.atm.internal.messages"; //$NON-NLS-1$
    public static String AbapTagsService_ShareTagsNotSupported;
    public static String AbapTagsService_TagsNotSupported;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}