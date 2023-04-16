package com.devepos.adt.atm.ui.internal.dialogs;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
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
  protected void cancelPressed() {
    tag.setName(oldTagName);
    tag.setDescription(oldTagDescription);
    super.cancelPressed();
  }

  @Override
  protected void configureShell(final Shell shell) {
    super.configureShell(shell);
    shell.setText(getTitle());
  }

  @Override
  protected Control createButtonBar(final Composite parent) {
    final Control buttonBar = super.createButtonBar(parent);
    onModifyTagName(null);
    return buttonBar;
  }

  @Override
  protected Control createDialogArea(final Composite parent) {
    setTitle(getTitle());
    final var dialogArea = (Composite) super.createDialogArea(parent);
    mainComposite = new Composite(dialogArea, SWT.NONE);
    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(mainComposite);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(mainComposite);

    createHierarchyInput();
    createNameInput();
    createDescriptionInput();

    nameInput.setFocus();
    return dialogArea;
  }

  @Override
  protected IDialogSettings getDialogBoundsSettings() {
    return AbapTagsUIPlugin.getDefault().getDialogSettingsSection(DIALOG_SETTINGS_NAME);
  }

  @Override
  protected int getDialogBoundsStrategy() {
    return DIALOG_PERSISTSIZE;
  }

  @Override
  protected void okPressed() {
    final var status = new TagListValidator(tagListForValidation).validate(true, false);
    if (!status.isOK()) {
      setErrorMessage(status.getMessage());
      nameInput.setFocus();
      return;
    }
    super.okPressed();
  }

  private void createDescriptionInput() {
    final var descriptionLabel = new Label(mainComposite, SWT.NONE);
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
  }

  private void createNameInput() {
    final var nameLabel = new Label(mainComposite, SWT.NONE);
    nameLabel.setText(Messages.EditTagDataDialog_NameInput_xlbl);
    AdtSWTUtilFactory.getOrCreateSWTUtil().setMandatory(nameLabel, true);

    nameInput = new Text(mainComposite, SWT.BORDER);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(nameInput);
    nameInput.setTextLimit(60);
    if (tag.getName() != null) {
      nameInput.setText(tag.getName());
    }
    nameInput.addModifyListener(this::onModifyTagName);
  }

  private void createHierarchyInput() {
    if (!(tag.eContainer() instanceof ITag)) {
      return;
    }

    var label = new Label(mainComposite, SWT.NONE);
    label.setText(Messages.EditTagDataDialog_hierarchyInput_xlbl);

    var input = new Text(mainComposite, SWT.READ_ONLY | SWT.BORDER);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(input);
    String hierarchyText = getHierarchyAsText();
    input.setText(hierarchyText);
    input.setToolTipText(hierarchyText);
  }

  private void enableOkButton(final boolean enable) {
    final var okButton = getButton(IDialogConstants.OK_ID);
    if (okButton != null && !okButton.isDisposed()) {
      okButton.setEnabled(enable);
    }
  }

  private String getHierarchyAsText() {
    var parentTag = (ITag) tag.eContainer();
    var bottomUpParents = new LinkedList<String>();
    var hierarchyText = new StringBuffer();

    while (parentTag != null) {
      bottomUpParents.addFirst(parentTag.getName());

      if (parentTag.eContainer() instanceof ITag) {
        parentTag = (ITag) parentTag.eContainer();
      } else {
        parentTag = null;
      }
    }

    for (var parentTagEntry : bottomUpParents) {
      if (hierarchyText.length() != 0) {
        hierarchyText.append(" > "); //$NON-NLS-1$
      }
      hierarchyText.append(parentTagEntry);
    }
    return hierarchyText.toString();
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

  private boolean isDirty() {
    if (!nameInput.getText().equals(oldTagName) || !descriptionInput.getText()
        .equals(oldTagDescription)) {
      return true;
    }
    return false;
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
}
