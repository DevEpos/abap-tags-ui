package com.devepos.adt.atm.internal.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
  private static final String BUNDLE_NAME = "com.devepos.adt.atm.internal.messages.messages"; //$NON-NLS-1$
  public static String AbapTagsService_DeletionCheckNotPossible_xmsg;
  public static String AbapTagsService_ShareTagsNotSupported_xmsg;
  public static String AbapTagsService_TagsNotSupported_xmsg;
  public static String AdtObjTaggingService_taggedObjectDeletionNotAvailable_xmsg;
  public static String TaggedObjectSearchService_taggedObjectInfoReseourceNotAvailable_xmsg;
  public static String TaggedObjectTreeService_TaggedObjectTreesNotAvailable_xmsg;
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
  }
}
