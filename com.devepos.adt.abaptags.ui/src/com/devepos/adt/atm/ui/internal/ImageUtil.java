package com.devepos.adt.atm.ui.internal;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.base.util.StringUtil;

/**
 * Utility for retrieving images
 *
 * @author stockbal
 *
 */
public class ImageUtil {

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
}
