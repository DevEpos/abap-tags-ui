package com.devepos.adt.atm.ui.internal;

import java.util.Map;
import java.util.TreeMap;

/**
 * Represents a List of {@link TagFolderType}s
 *
 * @author stockbal
 *
 */
public class TagFolders {

  private final Map<TagFolderType, TagFolder> folders;

  /**
   * Creates new {@link TagFolders} instance with as many folders as there are
   * {@link TagFolderType}s
   */
  public TagFolders() {
    folders = new TreeMap<>();
    for (TagFolderType folderType : TagFolderType.values()) {
      folders.put(folderType, new TagFolder(folderType));
    }
  }

  /**
   * Retrieves folder for the given type
   *
   * @param type the folder type
   * @return the found folder or {@code null}
   */
  public TagFolder getFolderByType(final TagFolderType type) {
    return folders.get(type);
  }

  /**
   * Clears tags from all folders
   */
  public void clearTags() {
    for (TagFolder tagFolder : folders.values()) {
      tagFolder.getTags().clear();
    }
  }

  /**
   * Retrieves array of tag folders
   *
   * @param includeSharedTags if {@code true} the {@link TagFolderType#SHARED}
   *                          entry is also includes
   * @return array of tag folders
   */
  public Object[] getFolders(final boolean includeSharedTags) {
    return includeSharedTags ? folders.values().toArray()
        : folders.keySet()
            .stream()
            .filter(t -> t != TagFolderType.SHARED)
            .map(type -> folders.get(type))
            .toArray();
  }

}
