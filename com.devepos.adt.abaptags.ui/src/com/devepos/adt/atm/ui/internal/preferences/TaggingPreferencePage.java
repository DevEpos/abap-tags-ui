package com.devepos.adt.atm.ui.internal.preferences;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

import com.devepos.adt.atm.ui.internal.messages.Messages;

public class TaggingPreferencePage extends BaseFieldEditorPrefPage {

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
    final var wizardGroup = new Group(parent, SWT.NONE);
    wizardGroup.setText(Messages.TaggingPreferencePage_TagWizardSettings_xgrp);

    GridDataFactory.fillDefaults().grab(true, false).applyTo(wizardGroup);

    addBooleanEditor(IObjectTaggingPrefs.AUTO_EXPAND_TAGS,
        Messages.TaggingPreferencePage_AutoExpandTagsOnTagSelectionPage_xchk, wizardGroup);

    adjustMargins(wizardGroup);

    final var tagManagerGroup = new Group(parent, SWT.NONE);
    tagManagerGroup.setText(Messages.TaggingPreferencePage_TagManagerSettings_xgrp);

    GridDataFactory.fillDefaults().grab(true, false).applyTo(tagManagerGroup);

    addBooleanEditor(ITagManagerPrefs.AUTO_EXPAND_TAGS,
        Messages.TaggingPreferencePage_AutoExpandTagsOnTagManagerReloade_xchk, tagManagerGroup);

    adjustMargins(tagManagerGroup);
  }
}