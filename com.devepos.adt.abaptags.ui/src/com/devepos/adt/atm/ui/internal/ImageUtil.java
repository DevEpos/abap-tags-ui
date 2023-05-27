package com.devepos.adt.atm.ui.internal;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.tools.core.ui.AbapCoreUi;

/**
 * Utility for retrieving images
 *
 * @author stockbal
 *
 */
@SuppressWarnings("restriction")
public class ImageUtil {

  /**
   * Retrieves correct image for ADT Object
   * 
   * @param objRef adt object reference
   * @return
   */
  public static Image getAdtObjRefImage(IAdtObjRef objRef) {
    return objRef == null ? null : getAdtTypeImage(objRef.getType());
  }

  /**
   * Retrieves correct image for ADT type
   * 
   * @param adtType adt type
   * @return
   */
  public static Image getAdtTypeImage(String type) {
    if (type == null) {
      return null;
    }
    if (IAdtObjectTypeConstants.LOCAL_CLASS.equals(type)) {
      return ImageUtil.getLocalClassImage();
    }
    if (IAdtObjectTypeConstants.LOCAL_INTERFACE.equals(type)) {
      return ImageUtil.getLocalInterfaceImage();
    }
    if (IAdtObjectTypeConstants.DATA_DEFINITION.equals(type)) {
      type = IAdtObjectTypeConstants.CDS_VIEW;
    }

    return AdtTypeUtil.getInstance().getTypeImage(type);
  }

  /**
   * Retrieves correct image for the given tag
   *
   * @param tag               tag reference
   * @param markOwnSharedTags if {@code true} the shared tags where the owner
   *                          matches the project destination owner they will get
   *                          a custom image
   * @return image for the tag
   */
  public static Image getImageForTag(final ITag tag, final boolean markOwnSharedTags) {
    if (StringUtil.isEmpty(tag.getOwner())) {
      return AbapTagsUIPlugin.getDefault().getImage(IImages.TAG);
    }
    if (!tag.isShared()) {
      return AbapTagsUIPlugin.getDefault().getImage(IImages.USER_TAG);
    }
    if (tag.isSharedForMe()) {
      return AbapTagsUIPlugin.getDefault().getImage(IImages.SHARED_TAG);
    }
    if (markOwnSharedTags) {
      return AbapTagsUIPlugin.getDefault().getImage(IImages.USER_TAG_W_SHARED_OVERLAY);
    }
    return AbapTagsUIPlugin.getDefault().getImage(IImages.USER_TAG);
  }

  /**
   * Returns image for a local class
   */
  public static Image getLocalClassImage() {
    return AbapCoreUi.getSharedImages().getClassImage(false, false, false, false, false, true);
  }

  /**
   * Returns image for a local interface
   */
  public static Image getLocalInterfaceImage() {
    return AbapCoreUi.getSharedImages().getInterfaceImage(false, false, true);
  }

  /**
   * Retrieves the image for the given object tag
   *
   * @param tag an object tag
   * @return the image for the object tag
   */
  public static Image getObjectTagImage(final IAdtObjectTag tag, final String destinationOwner) {
    if (StringUtil.isEmpty(tag.getOwner())) {
      return AbapTagsUIPlugin.getDefault().getImage(IImages.TAG);
    }
    if (!tag.getOwner().equals(destinationOwner) && !StringUtil.isEmpty(destinationOwner)) {
      return AbapTagsUIPlugin.getDefault().getImage(IImages.SHARED_TAG);
    }
    return AbapTagsUIPlugin.getDefault().getImage(IImages.USER_TAG);
  }
}
