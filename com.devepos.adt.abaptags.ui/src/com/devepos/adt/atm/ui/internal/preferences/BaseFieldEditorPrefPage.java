package com.devepos.adt.atm.ui.internal.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.devepos.adt.atm.ui.AbapTagsUIPlugin;

public abstract class BaseFieldEditorPrefPage extends PreferencePage implements
    IWorkbenchPreferencePage, IPropertyChangeListener {

  protected final List<FieldEditor> fields = new ArrayList<>();

  @Override
  public void init(final IWorkbench workbench) {
    setPreferenceStore(AbapTagsUIPlugin.getDefault().getPreferenceStore());
  }

  @Override
  public boolean performOk() {
    for (final FieldEditor field : fields) {
      field.store();
    }
    return super.performOk();
  }

  @Override
  public void propertyChange(final PropertyChangeEvent event) {
    if (event.getProperty() == FieldEditor.IS_VALID) {
      final boolean isValid = (Boolean) event.getNewValue();
      if (isValid) {
        for (final FieldEditor field : fields) {
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
  protected void performDefaults() {
    for (final FieldEditor field : fields) {
      field.loadDefault();
    }
    super.performDefaults();
  }

  protected BooleanFieldEditor addBooleanEditor(final String preferenceId, final String labelText,
      final Composite parent, final int colSpan, final int rowSpan) {
    final BooleanFieldEditor booleanEditor = new BooleanFieldEditor(preferenceId, labelText,
        parent);
    fields.add(booleanEditor);

    // adjust control layouts
    GridDataFactory.fillDefaults()
        .span(colSpan, rowSpan)
        .applyTo(booleanEditor.getDescriptionControl(parent));

    return booleanEditor;
  }

  protected BooleanFieldEditor addBooleanEditor(final String preferenceId, final String labelText,
      final Composite parent) {
    return addBooleanEditor(preferenceId, labelText, parent, 1, 1);
  }

  protected void adjustMargins(final Composite composite) {
    final GridLayout layout = (GridLayout) composite.getLayout();
    layout.marginLeft = 5;
    layout.marginTop = 5;
    layout.marginRight = 5;
    layout.marginBottom = 5;

  }

  protected void initFields() {
    for (final FieldEditor field : fields) {
      field.setPage(this);
      field.setPreferenceStore(getPreferenceStore());
      field.load();
      field.setPropertyChangeListener(this);
    }
  }

  protected void addEditor(final FieldEditor editor) {
    fields.add(editor);
  }

}
