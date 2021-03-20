package com.devepos.adt.atm.ui.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.util.IImages;

/**
 * Represents a Folder with tags
 *
 * @author stockbal
 */
public enum TagFolder {
    USER(IImages.USER_TAGS_FOLDER, Messages.AbapTagsView_UserTagsFolder_xlbl),
//	SHARED(IImages.SHARED_TAGS_FOLDER, Messag es.AbapTagsView_SharedTagsFolder_xlbl),
    GLOBAL(IImages.GLOBAL_TAGS_FOLDER, Messages.AbapTagsView_GlobalTagsFolder_xlbl);

    private Image folderImage;
    private String folderName;
    private final List<ITag> tags;

    TagFolder(final String folderImageId, final String folderName) {
        tags = new ArrayList<>();
        folderImage = AbapTagsUIPlugin.getDefault().getImage(folderImageId);
        this.folderName = folderName;
    }

    public Image getImage() {
        return folderImage;
    }

    public String getName() {
        return folderName;
    }

    public List<ITag> getTags() {
        return tags;
    }

    public boolean hasTags() {
        return !tags.isEmpty();
    }

}