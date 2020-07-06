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
import com.devepos.adt.tools.base.util.StringUtil;
import com.sap.adt.util.ui.SWTUtil;

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
		this.oldTagName = tag.getName();
		this.oldTagDescription = tag.getDescription();
		this.tagListForValidation = tagListForValidation;
		this.isUserTag = isUserTag;
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE);
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
		this.mainComposite = new Composite(dialogArea, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(this.mainComposite);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(this.mainComposite);

		final Label nameLabel = new Label(this.mainComposite, SWT.NONE);
		nameLabel.setText(Messages.EditTagDataDialog_NameInput_xlbl);
		SWTUtil.setMandatory(nameLabel, true);

		this.nameInput = new Text(this.mainComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(this.nameInput);
		this.nameInput.setTextLimit(60);
		if (this.tag.getName() != null) {
			this.nameInput.setText(this.tag.getName());
		}
		this.nameInput.addModifyListener(this::onModifyTagName);

		final Label descriptionLabel = new Label(this.mainComposite, SWT.NONE);
		descriptionLabel.setText(Messages.EditTagDataDialog_DescriptionInput_xlbl);

		this.descriptionInput = new Text(this.mainComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(this.descriptionInput);
		this.descriptionInput.setTextLimit(100);
		if (this.tag.getDescription() != null) {
			this.descriptionInput.setText(this.tag.getDescription());
		}
		this.descriptionInput.addModifyListener(e -> {
			this.tag.setDescription(this.descriptionInput.getText());
			if (!StringUtil.isEmpty(this.tag.getCreatedBy())) {
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
		final IStatus status = new TagListValidator(this.tagListForValidation).validate(true, false);
		if (!status.isOK()) {
			setErrorMessage(status.getMessage());
			this.nameInput.setFocus();
			return;
		}
		super.okPressed();
	}

	@Override
	protected void cancelPressed() {
		this.tag.setName(this.oldTagName);
		this.tag.setDescription(this.oldTagDescription);
		super.cancelPressed();
	}

	private void onModifyTagName(final ModifyEvent e) {
		this.tag.setName(this.nameInput.getText());
		if (this.nameInput.getText().isEmpty()) {
			setMessage(Messages.EditTagDataDialog_MandotoryFieldsNotFilled_xmsg, IMessageProvider.INFORMATION);
			enableOkButton(false);
		} else {
			setErrorMessage(null);
			setMessage(Messages.EditTagDataDialog_DialogInfoText);
			if (!StringUtil.isEmpty(this.tag.getCreatedBy())) {
				enableOkButton(isDirty());
			} else {
				enableOkButton(true);
			}
		}
	}

	private boolean isDirty() {
		if (!this.nameInput.getText().equals(this.oldTagName)) {
			return true;
		}
		if (!this.descriptionInput.getText().equals(this.oldTagDescription)) {
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
		if (!StringUtil.isEmpty(this.tag.getId())) {
			if (this.isUserTag) {
				return Messages.EditTagDataDialog_EditUserTagDialogTitle_xtit;
			} else {
				return Messages.EditTagDataDialog_EditGlobalTagTitle_xtit;
			}
		} else {
			if (this.isUserTag) {
				return Messages.EditTagDataDialog_CreateUserTagTitle_xtit;
			} else {
				return Messages.EditTagDataDialog_CreateGlobalTagTitle_xtit;
			}
		}
	}
}
