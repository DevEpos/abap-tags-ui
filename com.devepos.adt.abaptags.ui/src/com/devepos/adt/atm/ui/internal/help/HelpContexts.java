package com.devepos.adt.atm.ui.internal.help;

/**
 * Holds Help Contexts
 *
 * @author stockbal
 */
public enum HelpContexts {
  TAG_WIZARD_OBJECT_SELECTION("tag_wizard_object_selection"),
  TAG_WIZARD_TAG_SELECTION("tag_wizard_tag_selection"),
  TAG_WIZARD_PARENT_OBJECT_SELECTION("tag_wizard_parent_object_selection"),
  UNASSIGN_TAGS_WIZARD("unassign_tags_wizard"),
  UNASSIGN_TAGS_WIZARD_TAG_SELECTION("unassign_tags_wizard_tag_selection"),
  UNASSIGN_TAGS_WIZARD_OBJ_SELECtION("unassign_tags_wizard_object_selection"),
  TAG_MANAGER("tag_manager"),
  OBJECT_TAGS("object_tags"),
  TAGGED_OBJECT_SEARCH("tagged_object_search");

  private String helpContextId;

  HelpContexts(final String contextId) {
    helpContextId = contextId;
  }

  public String getHelpContextId() {
    return helpContextId;
  }
}
