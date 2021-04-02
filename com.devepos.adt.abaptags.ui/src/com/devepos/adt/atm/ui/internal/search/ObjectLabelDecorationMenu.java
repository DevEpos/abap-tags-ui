package com.devepos.adt.atm.ui.internal.search;

import org.eclipse.jface.action.MenuManager;

import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.preferences.ITaggedObjectSearchPrefs;
import com.devepos.adt.base.ui.action.PreferenceToggleAction;

public class ObjectLabelDecorationMenu extends MenuManager {

    public ObjectLabelDecorationMenu() {
        super(Messages.ObjectLabelDecorationMenu_MenuLabel_xmit);

        add(new PreferenceToggleAction(Messages.ObjectLabelDecorationMenu_DisplayType_xckl, null,
            ITaggedObjectSearchPrefs.DISPLAY_OBJECT_TYPES, true, AbapTagsUIPlugin.getDefault().getPreferenceStore()));
        add(new PreferenceToggleAction(Messages.ObjectLabelDecorationMenu_DisplayPackage_xckl, null,
            ITaggedObjectSearchPrefs.DISPLAY_PACKAGES, false, AbapTagsUIPlugin.getDefault().getPreferenceStore()));
        add(new PreferenceToggleAction(Messages.ObjectLabelDecorationMenu_DisplayDescription_xckl, null,
            ITaggedObjectSearchPrefs.DISPLAY_DESCRIPTIONS, true, AbapTagsUIPlugin.getDefault().getPreferenceStore()));
    }
}