package com.devepos.adt.atm.ui.internal.search;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.dialogs.PreferencesUtil;

import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.preferences.IPreferences;

/**
 * Action to open tagged object search preferences in the eclipse preferences
 * dialog
 *
 * @author stockbal
 */
public class OpenTaggedObjectSearchPreferences extends Action {
	public OpenTaggedObjectSearchPreferences() {
		super(Messages.OpenTaggedObjectSearchPreferences_ActionLabel_xmit);
	}

	@Override
	public void run() {
		PreferencesUtil
			.createPreferenceDialogOn(null, IPreferences.SEARCH_PREF_PAGE_ID, new String[] { IPreferences.SEARCH_PREF_PAGE_ID },
				(Object) null)
			.open();
	}
}
