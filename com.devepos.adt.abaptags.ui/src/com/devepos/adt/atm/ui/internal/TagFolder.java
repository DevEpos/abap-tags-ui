package com.devepos.adt.atm.ui.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;

import com.devepos.adt.atm.model.abaptags.ITag;

/**
 * Folder with tags
 *
 * @author stockbal
 *
 */
public class TagFolder {

  private final TagFolderType folderType;
  private final List<ITag> tags;

  /**
   * Creates new tag folder
   *
   * @param folderType type of the folder
   */
  public TagFolder(final TagFolderType folderType) {
    tags = new ArrayList<>();
    this.folderType = folderType;
  }

  /**
   * @return the image of the tag folder
   */
  public Image getImage() {
    return folderType.getImage();
  }

  /**
   * @return the name of the tag folder
   */
  public String getName() {
    return folderType.getName();
  }

  /**
   * @return a list of tags
   */
  public List<ITag> getTags() {
    return tags;
  }

  /**
   * @return {@code true} if the folder has tags
   */
  public boolean hasTags() {
    return !tags.isEmpty();
  }

  /**
   * @return the type of the tags folder
   */
  public TagFolderType getType() {
    return folderType;
  }
}
