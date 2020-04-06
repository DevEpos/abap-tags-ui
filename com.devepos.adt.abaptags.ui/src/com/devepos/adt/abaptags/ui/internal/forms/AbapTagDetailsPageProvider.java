package com.devepos.adt.abaptags.ui.internal.forms;

import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;

import com.devepos.adt.abaptags.ITag;

public class AbapTagDetailsPageProvider implements IDetailsPageProvider {
	private final IMasterSection masterSection;

	public AbapTagDetailsPageProvider(final IMasterSection masterSection) {
		this.masterSection = masterSection;
	}

	@Override
	public Object getPageKey(final Object object) {
		if (object instanceof ITag) {
			return ITag.class;
		}
		return null;
	}

	@Override
	public IDetailsPage getPage(final Object key) {
		if (key == ITag.class) {
			return new AbapTagDetailsPage(this.masterSection);
		}
		return null;
	}

}
