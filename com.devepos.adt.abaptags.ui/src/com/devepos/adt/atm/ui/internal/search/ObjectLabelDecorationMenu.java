package com.devepos.adt.atm.ui.internal.search;

import org.eclipse.jface.action.MenuManager;

import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.preferences.ITaggedObjectSearchPrefs;
import com.devepos.adt.tools.base.ui.action.PreferenceToggleAction;

public class ObjectLabelDecorationMenu extends MenuManager {

	public ObjectLabelDecorationMenu() {
		super(Messages.ObjectLabelDecorationMenu_MenuLabel_xmit);

		add(new PreferenceToggleAction(Messages.SearchPreferencesPage_DisplayObjectTypes_xckl, null,
			ITaggedObjectSearchPrefs.DISPLAY_OBJECT_TYPES, true, AbapTagsUIPlugin.getDefault().getPreferenceStore()));
		add(new PreferenceToggleAction(Messages.SearchPreferencesPage_DisplayPackages_xckl, null,
			ITaggedObjectSearchPrefs.DISPLAY_PACKAGES, false, AbapTagsUIPlugin.getDefault().getPreferenceStore()));
		add(new PreferenceToggleAction(Messages.SearchPreferencesPage_DisplayShortDescriptions_xckl, null,
			ITaggedObjectSearchPrefs.DISPLAY_DESCRIPTIONS, true, AbapTagsUIPlugin.getDefault().getPreferenceStore()));
	}
}