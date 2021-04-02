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
    TAG_EXPLORER("tag_explorer"),
    TAGS("tag_management"),
    TAG_SEARCH("tag_search");

    private String helpContextId;

    HelpContexts(final String contextId) {
        helpContextId = contextId;
    }

    public String getHelpContextId() {
        return helpContextId;
    }
}
