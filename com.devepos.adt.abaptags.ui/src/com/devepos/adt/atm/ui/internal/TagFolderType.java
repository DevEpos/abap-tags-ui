package com.devepos.adt.atm.ui.internal;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.messages.Messages;

/**
 * Represents a Folder with tags
 *
 * @author stockbal
 */
public enum TagFolderType {
    USER(IImages.USER_TAGS_FOLDER, Messages.AbapTagsView_UserTagsFolder_xlbl),
    SHARED(IImages.SHARED_TAGS_FOLDER, Messages.AbapTagsView_SharedTagsFolder_xlbl),
    GLOBAL(IImages.GLOBAL_TAGS_FOLDER, Messages.AbapTagsView_GlobalTagsFolder_xlbl);

    private Image folderImage;
    private String folderName;

    TagFolderType(final String folderImageId, final String folderName) {
        folderImage = AbapTagsUIPlugin.getDefault().getImage(folderImageId);
        this.folderName = folderName;
    }

    public Image getImage() {
        return folderImage;
    }

    public String getName() {
        return folderName;
    }

}