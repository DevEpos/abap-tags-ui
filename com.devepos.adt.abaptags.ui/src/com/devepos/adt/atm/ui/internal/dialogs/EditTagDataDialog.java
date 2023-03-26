package com.devepos.adt.atm.ui.internal.dialogs;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.validation.TagListValidator;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.util.ui.swt.AdtSWTUtilFactory;

public class EditTagDataDialog extends TitleAreaDialog {
  private static final String DIALOG_SETTINGS_NAME = EditTagDataDialog.class.getCanonicalName();
  private Composite mainComposite;
  private final ITag tag;
  private final boolean isUserTag;
  private Text nameInput;
  private Text descriptionInput;
  private final List<ITag> tagListForValidation;
  private final String oldTagName;
  private final String oldTagDescription;

  public EditTagDataDialog(final Shell shell, final ITag tag, final List<ITag> tagListForValidation,
      final boolean isUserTag) {
    super(shell);
    this.tag = tag;
    oldTagName = tag.getName();
    oldTagDescription = tag.getDescription();
    this.tagListForValidation = tagListForValidation;
    this.isUserTag = isUserTag;
    setShellStyle(getShellStyle() | SWT.RESIZE);
    setHelpAvailable(false);
  }

  @Override
  protected void configureShell(final Shell shell) {
    super.configureShell(shell);
    shell.setText(getTitle());
  }

  @Override
  protected int getDialogBoundsStrategy() {
    return DIALOG_PERSISTSIZE;
  }

  @Override
  protected IDialogSettings getDialogBoundsSettings() {
    return AbapTagsUIPlugin.getDefault().getDialogSettingsSection(DIALOG_SETTINGS_NAME);
  }

  @Override
  protected Control createDialogArea(final Composite parent) {
    setTitle(getTitle());
    final Composite dialogArea = (Composite) super.createDialogArea(parent);
    mainComposite = new Composite(dialogArea, SWT.NONE);
    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(mainComposite);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(mainComposite);

    final Label nameLabel = new Label(mainComposite, SWT.NONE);
    nameLabel.setText(Messages.EditTagDataDialog_NameInput_xlbl);
    AdtSWTUtilFactory.getOrCreateSWTUtil().setMandatory(nameLabel, true);

    nameInput = new Text(mainComposite, SWT.BORDER);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(nameInput);
    nameInput.setTextLimit(60);
    if (tag.getName() != null) {
      nameInput.setText(tag.getName());
    }
    nameInput.addModifyListener(this::onModifyTagName);

    final Label descriptionLabel = new Label(mainComposite, SWT.NONE);
    descriptionLabel.setText(Messages.EditTagDataDialog_DescriptionInput_xlbl);

    descriptionInput = new Text(mainComposite, SWT.BORDER);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(descriptionInput);
    descriptionInput.setTextLimit(100);
    if (tag.getDescription() != null) {
      descriptionInput.setText(tag.getDescription());
    }
    descriptionInput.addModifyListener(e -> {
      tag.setDescription(descriptionInput.getText());
      if (!StringUtil.isEmpty(tag.getCreatedBy())) {
        enableOkButton(isDirty());
      }
    });

    return dialogArea;
  }

  @Override
  protected Control createButtonBar(final Composite parent) {
    final Control buttonBar = super.createButtonBar(parent);
    onModifyTagName(null);
    return buttonBar;
  }

  @Override
  protected void okPressed() {
    final IStatus status = new TagListValidator(tagListForValidation).validate(true, false);
    if (!status.isOK()) {
      setErrorMessage(status.getMessage());
      nameInput.setFocus();
      return;
    }
    super.okPressed();
  }

  @Override
  protected void cancelPressed() {
    tag.setName(oldTagName);
    tag.setDescription(oldTagDescription);
    super.cancelPressed();
  }

  private void onModifyTagName(final ModifyEvent e) {
    tag.setName(nameInput.getText());
    if (StringUtil.isBlank(nameInput.getText())) {
      setMessage(Messages.EditTagDataDialog_MandotoryFieldsNotFilled_xmsg,
          IMessageProvider.INFORMATION);
      enableOkButton(false);
    } else {
      setErrorMessage(null);
      setMessage(Messages.EditTagDataDialog_DialogInfoText_xtit);
      if (!StringUtil.isEmpty(tag.getCreatedBy())) {
        enableOkButton(isDirty());
      } else {
        enableOkButton(true);
      }
    }
  }

  private boolean isDirty() {
    if (!nameInput.getText().equals(oldTagName) || !descriptionInput.getText()
        .equals(oldTagDescription)) {
      return true;
    }
    return false;
  }

  private void enableOkButton(final boolean enable) {
    final Button okButton = getButton(IDialogConstants.OK_ID);
    if (okButton != null && !okButton.isDisposed()) {
      okButton.setEnabled(enable);
    }
  }

  private String getTitle() {
    if (!StringUtil.isEmpty(tag.getId())) {
      if (isUserTag) {
        return Messages.EditTagDataDialog_EditUserTagDialogTitle_xtit;
      }
      return Messages.EditTagDataDialog_EditGlobalTagTitle_xtit;
    }
    if (isUserTag) {
      return Messages.EditTagDataDialog_CreateUserTagTitle_xtit;
    }
    return Messages.EditTagDataDialog_CreateGlobalTagTitle_xtit;
  }
}
