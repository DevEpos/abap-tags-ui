package com.devepos.adt.atm.ui.internal.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.devepos.adt.atm.ui.AbapTagsUIPlugin;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

  @Override
  public void initializeDefaultPreferences() {
    final IPreferenceStore prefStore = AbapTagsUIPlugin.getDefault().getPreferenceStore();
    prefStore.setDefault(ITaggedObjectSearchPrefs.MAX_RESULTS, 50);
    prefStore.setDefault(ITaggedObjectSearchPrefs.DISPLAY_OBJECT_TYPES, true);
    prefStore.setDefault(ITaggedObjectSearchPrefs.DISPLAY_PACKAGES, false);
    prefStore.setDefault(ITaggedObjectSearchPrefs.DISPLAY_DESCRIPTIONS, true);
    prefStore.setDefault(IObjectTaggingPrefs.AUTO_EXPAND_TAGS, true);
    prefStore.setDefault(ITagManagerPrefs.AUTO_EXPAND_TAGS, true);
  }

}
