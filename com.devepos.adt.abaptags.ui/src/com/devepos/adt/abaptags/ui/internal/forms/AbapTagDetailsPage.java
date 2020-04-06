package com.devepos.adt.abaptags.ui.internal.forms;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import org.eclipse.core.databinding.observable.sideeffect.ISideEffect;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.devepos.adt.abaptags.ITag;
import com.sap.adt.util.ui.SWTUtil;

public class AbapTagDetailsPage implements IDetailsPage {
	private IManagedForm managedForm;
	private ITag currentTag;
	private final IMasterSection masterSection;
	private Text nameText;
	private Text descriptionText;
	private Composite detailsComposite;
	private Label createdDateTimeLabel;
	private Label createdByLabel;
	private Label changedByLabel;
	private Label changedDateTimeLabel;
	private boolean notifyOfModifications;

	public AbapTagDetailsPage(final IMasterSection masterSection) {
		this.masterSection = masterSection;
	}

	@Override
	public void initialize(final IManagedForm form) {
		this.managedForm = form;
	}

	@Override
	public void dispose() {

	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public void commit(final boolean onSave) {

	}

	@Override
	public boolean setFormInput(final Object input) {
		return false;
	}

	@Override
	public void setFocus() {
		if (this.nameText != null && !this.nameText.isDisposed()) {
			this.nameText.setFocus();
			final String name = this.nameText.getText();
			if (name != null && !name.isBlank() && this.masterSection.getModel().isEditMode()) {
				this.nameText.setSelection(0, name.length());
			}
		}
	}

	@Override
	public boolean isStale() {
		return false;
	}

	@Override
	public void refresh() {
		if (this.currentTag == null) {
			return;
		}
		this.notifyOfModifications = this.currentTag.validate().getSeverity() != IStatus.OK;
		final String name = this.currentTag.getName();

		this.nameText.setText(name != null ? name : "");

		final String description = this.currentTag.getDescription();
		this.descriptionText.setText(description != null ? description : "");

		final String createdDateTime = this.currentTag.getCreatedDateTime();
		try {
			this.createdDateTimeLabel.setText(createdDateTime != null && !createdDateTime.isBlank()
				? LocalDateTime.parse(createdDateTime, DateTimeFormatter.ISO_DATE_TIME)
					.format(DateTimeFormatter.ofPattern("EEEE, MMMM d, uuuu, hh:mm:ss", Locale.ENGLISH))
				: "");
		} catch (final DateTimeParseException exc) {
			this.createdDateTimeLabel.setText("");
		}

		final String createdBy = this.currentTag.getCreatedBy();
		this.createdByLabel.setText(createdBy != null ? createdBy : "");

		final String changedDateTime = this.currentTag.getChangedDateTime();
		try {
			this.changedDateTimeLabel.setText(changedDateTime != null && !changedDateTime.isBlank()
				? LocalDateTime.parse(changedDateTime, DateTimeFormatter.ISO_DATE_TIME)
					.format(DateTimeFormatter.ofPattern("EEEE, MMMM d, uuuu, hh:mm:ss", Locale.ENGLISH))
				: "");
		} catch (final DateTimeParseException exc) {
			this.changedDateTimeLabel.setText("");
		}

		final String changedBy = this.currentTag.getChangedBy();
		this.changedByLabel.setText(changedBy != null ? changedBy : "");

		this.notifyOfModifications = true;
	}

	@Override
	public void selectionChanged(final IFormPart part, final ISelection selection) {
		final IStructuredSelection treeSelection = (IStructuredSelection) selection;
		if (treeSelection.size() == 1) {
			this.detailsComposite.setVisible(true);
			this.currentTag = (ITag) treeSelection.getFirstElement();
		} else {
			this.currentTag = null;
			this.detailsComposite.setVisible(false);
		}
		refresh();
		setFocus();
	}

	@Override
	public void createContents(final Composite parent) {
		this.detailsComposite = parent;
		GridLayoutFactory.swtDefaults().numColumns(1).extendedMargins(2, 2, 0, 10).margins(0, 0).applyTo(parent);
		final FormToolkit toolkit = this.managedForm.getToolkit();

		final Section section = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(section);

		section.marginWidth = 10;
		section.clientVerticalSpacing = 6;
		section.setText("Tag Details");
		section.setDescription("Sets the properties of the selected Tag");

		final Composite client = toolkit.createComposite(section);
		GridLayoutFactory.swtDefaults().margins(0, 0).numColumns(2).applyTo(client);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(client);

		final Label nameLabel = new Label(client, SWT.NONE);
		nameLabel.setText("Name:");
		SWTUtil.setMandatory(nameLabel, true);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER).applyTo(nameLabel);

		this.nameText = new Text(client, SWT.BORDER);
		this.nameText.addModifyListener(e -> {
			final String name = this.nameText.getText();
			if (this.notifyOfModifications && this.currentTag != null) {
				this.currentTag.setName(name);
			}
		});
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(this.nameText);

		final Label descriptionLabel = new Label(client, SWT.NONE);
		descriptionLabel.setText("Description:");

		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(descriptionLabel);

		this.descriptionText = new Text(client, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.WRAP);
		this.descriptionText.addModifyListener(e -> {
			if (this.notifyOfModifications && this.currentTag != null) {
				this.currentTag.setDescription(this.descriptionText.getText());
			}
		});
		GridDataFactory.fillDefaults()
			.align(SWT.FILL, SWT.FILL)
			.minSize(SWT.DEFAULT, 100)
			.grab(true, true)
			.applyTo(this.descriptionText);

		createAdminDataFields(client);

		toolkit.paintBordersFor(section);
		section.setClient(client);

		section.descriptionVerticalSpacing += this.masterSection.getTextClientHeightDifference();

		// register observables
		ISideEffect.create(this.masterSection.getModel()::isEditMode, this.nameText::setEditable);
		ISideEffect.create(this.masterSection.getModel()::isEditMode, this.descriptionText::setEditable);
	}

	/**
	 * @param client the parent composite
	 */
	private void createAdminDataFields(final Composite client) {
		final Label createdDateTimeLabel = new Label(client, SWT.NONE);
		createdDateTimeLabel.setText("Created On:");
		this.createdDateTimeLabel = new Label(client, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(this.createdDateTimeLabel);

		final Label createdByLabel = new Label(client, SWT.NONE);
		createdByLabel.setText("Created By:");
		this.createdByLabel = new Label(client, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(this.createdByLabel);

		final Label changedDateTimeLabel = new Label(client, SWT.NONE);
		changedDateTimeLabel.setText("Last Changed on:");
		this.changedDateTimeLabel = new Label(client, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(this.changedDateTimeLabel);

		final Label changedByLabel = new Label(client, SWT.NONE);
		changedByLabel.setText("Last Changed By:");
		this.changedByLabel = new Label(client, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(this.changedByLabel);
	}

}
