package com.devepos.adt.atm.ui.internal.preferences;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

import com.devepos.adt.atm.ui.internal.messages.Messages;

public class SearchPreferencesPage extends BaseFieldEditorPrefPage {

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

    final FieldEditor maxSearchResultsEditor = new IntegerFieldEditor(
        ITaggedObjectSearchPrefs.MAX_RESULTS,
        Messages.SearchPreferencesPage_MaxNumberOfResults_xlbl, searchGroup, 4);
    fields.add(maxSearchResultsEditor);
    addEditor(maxSearchResultsEditor);

    addBooleanEditor(ITaggedObjectSearchPrefs.DISPLAY_OBJECT_TYPES,
        Messages.SearchPreferencesPage_DisplayObjectTypes_xckl, searchGroup, 2, 1);
    addBooleanEditor(ITaggedObjectSearchPrefs.DISPLAY_PACKAGES,
        Messages.SearchPreferencesPage_DisplayPackages_xckl, searchGroup, 2, 1);
    addBooleanEditor(ITaggedObjectSearchPrefs.DISPLAY_DESCRIPTIONS,
        Messages.SearchPreferencesPage_DisplayShortDescriptions_xckl, searchGroup, 2, 1);
    /*
     * Layout of group needs to be set at last as the field editors will change it
     * final during their creation
     */
    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(searchGroup);

    // reset group margins because of field editors
    adjustMargins(searchGroup);
  }
}
