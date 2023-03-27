package com.devepos.adt.atm.ui.internal.preferences;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

import com.devepos.adt.atm.ui.internal.messages.Messages;

public class TagManagerPreferencePage extends BaseFieldEditorPrefPage {

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
    final var tagManagerGroup = new Group(parent, SWT.NONE);
    tagManagerGroup.setText(Messages.TagManagerPreferencePage_TreeSettingsGroup_xlbl);

    GridDataFactory.fillDefaults().grab(true, false).applyTo(tagManagerGroup);

    addBooleanEditor(ITagManagerPrefs.AUTO_EXPAND_TAGS,
        Messages.TaggingPreferencePage_AutoExpandTagsOnTagManagerReloade_xchk, tagManagerGroup);

    adjustMargins(tagManagerGroup);
  }
}