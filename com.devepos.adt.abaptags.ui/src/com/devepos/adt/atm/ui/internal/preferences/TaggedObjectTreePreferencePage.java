package com.devepos.adt.atm.ui.internal.preferences;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

import com.devepos.adt.atm.ui.internal.messages.Messages;

public class TaggedObjectTreePreferencePage extends BaseFieldEditorPrefPage {

  @Override
  protected Control createContents(final Composite parent) {
    final Composite main = new Composite(parent, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(main);
    GridLayoutFactory.fillDefaults().applyTo(main);

    createSettings(main);
    initFields();
    applyDialogFont(main);

    return main;
  }

  /**
   * Creates group with settings for object tagging
   *
   * @param parent the parent composite
   */
  private void createSettings(final Composite parent) {
    final var treeGroup = new Group(parent, SWT.NONE);
    treeGroup.setText(Messages.TaggedObjectTreePreferencePage_TreeSettingsGroup_xlbl);

    GridDataFactory.fillDefaults().grab(true, false).applyTo(treeGroup);

    addBooleanEditor(ITaggedObjectTreePrefs.DISPLAY_OBJECT_TYPES,
        Messages.SearchPreferencesPage_DisplayObjectTypes_xckl, treeGroup);
    addBooleanEditor(ITaggedObjectTreePrefs.DISPLAY_DESCRIPTIONS,
        Messages.SearchPreferencesPage_DisplayShortDescriptions_xckl, treeGroup);

    adjustMargins(treeGroup);
  }
}