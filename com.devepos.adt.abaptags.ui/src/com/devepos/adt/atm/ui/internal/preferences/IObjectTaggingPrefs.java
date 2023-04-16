package com.devepos.adt.atm.ui.internal.preferences;

public interface IObjectTaggingPrefs {
  /**
   * Preference which control whether or not tags will be loaded in
   */
  String AUTO_EXPAND_TAGS = "com.devepos.adt.atm.ui.objectTagging.autoExpandTags";
  /**
   * Preference to control wheter the assigned child objects via tags should be loaded automatically
   * if an object with tag in the upper tag hierarchy is selected for deletion.
   */
  String DELETION_AUTO_LOAD_ASSIGNED_CHILDREN = "com.devepos.adt.atm.ui.objectTagging.removeTags.loadChildren";
}
