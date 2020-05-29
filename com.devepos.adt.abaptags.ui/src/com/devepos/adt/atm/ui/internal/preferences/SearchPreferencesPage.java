package com.devepos.adt.atm.ui.internal.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.messages.Messages;

public class SearchPreferencesPage extends PreferencePage implements IWorkbenchPreferencePage, IPropertyChangeListener {
	private final List<FieldEditor> fields = new ArrayList<>();

	@Override
	public void init(final IWorkbench workbench) {

	}

	@Override
	public boolean performOk() {
		for (final FieldEditor field : this.fields) {
			field.store();
		}
		return super.performOk();
	}

	@Override
	public void propertyChange(final PropertyChangeEvent event) {
		if (event.getProperty() == FieldEditor.IS_VALID) {
			final boolean isValid = (Boolean) event.getNewValue();
			if (isValid) {
				for (final FieldEditor field : this.fields) {
					if (!field.isValid()) {
						setValid(false);
						return;
					}
				}
				setValid(true);
			} else {
				setValid(false);
			}
		}
	}

	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return AbapTagsUIPlugin.getDefault().getPreferenceStore();
	}

	@Override
	protected void performDefaults() {
		for (final FieldEditor field : this.fields) {
			field.loadDefault();
		}
		super.performDefaults();
	}

	@Override
	protected Control createContents(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(composite);
		GridLayoutFactory.fillDefaults().applyTo(composite);

		createSearchSettings(composite);

		initFields();

		applyDialogFont(composite);

		return composite;
	}

	/**
	 * Creates group with search settings
	 *
	 * @param composite
	 */
	private void createSearchSettings(final Composite composite) {
		final Group searchGroup = new Group(composite, SWT.NONE);
		searchGroup.setText(Messages.SearchPreferencesPage_ResultDisplayGroup_xtit);

		GridDataFactory.fillDefaults().grab(true, false).applyTo(searchGroup);

		final FieldEditor maxSearchResultsEditor = new IntegerFieldEditor(ITaggedObjectSearchPrefs.MAX_RESULTS,
			Messages.SearchPreferencesPage_MaxNumberOfResults_xlbl, searchGroup, 4);
		this.fields.add(maxSearchResultsEditor);

		addBooleanEditor(ITaggedObjectSearchPrefs.DISPLAY_OBJECT_TYPES, Messages.SearchPreferencesPage_DisplayObjectTypes_xckl, searchGroup);
		addBooleanEditor(ITaggedObjectSearchPrefs.DISPLAY_PACKAGES, Messages.SearchPreferencesPage_DisplayPackages_xckl, searchGroup);
		addBooleanEditor(ITaggedObjectSearchPrefs.DISPLAY_DESCRIPTIONS, Messages.SearchPreferencesPage_DisplayShortDescriptions_xckl, searchGroup);
		/*
		 * Layout of group needs to be set at last as the field editors will change it
		 * final during their creation
		 */
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(searchGroup);

		// reset group margins because of field editors
		adjustMargins(searchGroup);
	}

	private BooleanFieldEditor addBooleanEditor(final String preferenceId, final String labelText, final Composite parent) {
		final BooleanFieldEditor booleanEditor = new BooleanFieldEditor(preferenceId, labelText, parent);
		this.fields.add(booleanEditor);

		// adjust control layouts
		GridDataFactory.fillDefaults().span(2, 1).applyTo(booleanEditor.getDescriptionControl(parent));

		return booleanEditor;
	}

	private void adjustMargins(final Composite composite) {
		final GridLayout layout = (GridLayout) composite.getLayout();
		layout.marginLeft = 5;
		layout.marginTop = 5;
		layout.marginRight = 5;
		layout.marginBottom = 5;

	}

	private void initFields() {
		for (final FieldEditor field : this.fields) {
			field.setPage(this);
			field.setPreferenceStore(getPreferenceStore());
			field.load();
			field.setPropertyChangeListener(this);
		}
	}

}
