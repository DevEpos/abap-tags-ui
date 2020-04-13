package com.devepos.adt.abaptags.ui.internal.dialogs;

import org.eclipse.core.databinding.observable.sideeffect.ISideEffect;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.devepos.adt.abaptags.internal.tags.service.AbapTagsUriDiscovery;
import com.devepos.adt.abaptags.ui.AbapTagsUIPlugin;
import com.devepos.adt.abaptags.ui.internal.forms.AbapTagMasterDetailsBlock;
import com.devepos.adt.abaptags.ui.internal.forms.AbapTagModel;
import com.devepos.adt.abaptags.ui.internal.messages.Messages;
import com.devepos.adt.abaptags.ui.internal.util.IImages;
import com.devepos.adt.tools.base.project.AbapProjectProxy;
import com.devepos.adt.tools.base.project.IAbapProjectProvider;
import com.devepos.adt.tools.base.ui.MessageLine;
import com.devepos.adt.tools.base.util.AdtUtil;
import com.devepos.adt.tools.base.util.IStatusView;
import com.sap.adt.tools.core.ui.AbapProjectProposalProvider;
import com.sap.adt.tools.core.ui.dialogs.AbapProjectSelectionDialog;
import com.sap.adt.util.ui.SWTUtil;

/**
 * Dialog for managing ABAP Tags
 *
 * @author stockbal
 */
public class TagManagerDialog extends TrayDialog implements IStatusView {
	public static final String LAST_PROJECT_PREF = "com.devepos.adt.atm.tags.lastSelectedProject"; //$NON-NLS-1$

	private static final int STATUS_PROJECT = 100;

	private Text projectField;
	private AbapTagsUriDiscovery uriDiscovery;
	private final IAbapProjectProvider projectProvider;
	private IStatus currentStatus;
	private final boolean globalTags;
	private final AbapTagModel model;
	private final IPreferenceStore prefStore;
	private MessageLine statusLine;

	/**
	 * Creates instance of Dialog for managing ABAP Tags
	 *
	 * @param parent     the parent Shell of this dialog
	 * @param globalTags <code>true</code> if the global tags should be manage
	 * @param project    the current project
	 */
	public TagManagerDialog(final Shell parent, final boolean globalTags, final IProject project) {
		super(parent);
		this.globalTags = globalTags;
		this.projectProvider = new AbapProjectProxy(project);
		this.model = new AbapTagModel(this.projectProvider, this, this.globalTags);
		this.prefStore = AbapTagsUIPlugin.getDefault().getPreferenceStore();
		this.prefStore.setDefault(LAST_PROJECT_PREF, ""); //$NON-NLS-1$
	}

	@Override
	public void setViewStatus(final IStatus status) {
		Display.getDefault().asyncExec(() -> {
			validateAndSetStatus(status);
		});
	}

	@Override
	public boolean close() {
		this.model.unlock(false);
		return super.close();
	}

	@Override
	protected void configureShell(final Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.TagManagerDialog_DialogTitle_xtit);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected int getDialogBoundsStrategy() {
		return DIALOG_PERSISTSIZE;
	}

	@Override
	protected IDialogSettings getDialogBoundsSettings() {
		return AbapTagsUIPlugin.getDefault().getDialogSettingsSection("DialogBounds_TagManagerDialog"); //$NON-NLS-1$
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite dialogContents = (Composite) super.createDialogArea(parent);
		// remove margins so form is
		GridLayoutFactory.swtDefaults().extendedMargins(0, 0, 0, 0).margins(1, 1).applyTo(dialogContents);
		createForm(dialogContents);
		createStatusLine(dialogContents);

		setInitialProject();

		return dialogContents;
	}

	protected void updateButtonsEnableState(final IStatus status) {
		final boolean enabled = !status.matches(IStatus.ERROR);
		final Button okButton = getButton(IDialogConstants.OK_ID);
		if (okButton != null) {
			okButton.setEnabled(enabled);
		}
	}

	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, false);
	}

	private void setInitialProject() {
		String projectName = null;

		final IProject currentAbapProject = AdtUtil.getCurrentAbapProject();
		if (currentAbapProject != null) {
			projectName = currentAbapProject.getName();
		}
		if (projectName == null || projectName.isEmpty()) {
			projectName = this.prefStore.getString(LAST_PROJECT_PREF);
		}

		this.projectField.setText(projectName == null ? "" : projectName); //$NON-NLS-1$
		if (projectName == null || projectName.isEmpty()) {
			this.prefStore.setToDefault(LAST_PROJECT_PREF);
		}
	}

	private void createForm(final Composite dialogContents) {
		final ManagedForm tagMasterDetailForm = new ManagedForm(dialogContents);
		tagMasterDetailForm.getForm()
			.setText(this.globalTags ? Messages.TagManagerDialog_GlobalTagsModeFormTitle_xtit
				: Messages.TagManagerDialog_UserTagsModeFormTitle_xtit);
		tagMasterDetailForm.getForm()
			.setImage(AbapTagsUIPlugin.getDefault().getImage(this.globalTags ? IImages.GLOBE : IImages.USER));
		GridDataFactory.fillDefaults().grab(true, true).applyTo(tagMasterDetailForm.getForm());

		createProjectInput(tagMasterDetailForm, tagMasterDetailForm.getToolkit(), tagMasterDetailForm.getForm().getBody());

		final AbapTagMasterDetailsBlock masterDetailBlock = new AbapTagMasterDetailsBlock(this.model);
		masterDetailBlock.createContent(tagMasterDetailForm);

		GridLayoutFactory.swtDefaults().applyTo(tagMasterDetailForm.getForm().getBody());
		tagMasterDetailForm.getToolkit().decorateFormHeading(tagMasterDetailForm.getForm().getForm());
	}

	private void createProjectInput(final IManagedForm form, final FormToolkit formToolkit, final Composite parent) {
		final Section projectSection = formToolkit.createSection(parent, Section.TITLE_BAR);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.FILL).applyTo(projectSection);
		projectSection.setText(Messages.TagManagerDialog_ProjectSelectionSectionTitle_xtit);

		final Composite client = formToolkit.createComposite(projectSection, SWT.WRAP);
		GridLayoutFactory.swtDefaults().numColumns(3).margins(0, 0).extendedMargins(2, 2, 2, 10).applyTo(client);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(client);
		formToolkit.paintBordersFor(client);

		final Label projectInputLabel = new Label(client, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(projectInputLabel);
		projectInputLabel.setText(Messages.TagManagerDialog_ProjectInput_xlbl);
		SWTUtil.setMandatory(projectInputLabel, true);

		this.projectField = new Text(client, SWT.BORDER);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(this.projectField);
		// register project proposal provider
		new AbapProjectProposalProvider(this.projectField);
		SWTUtil.addTextEditMenu(this.projectField);

		final Button projectBrowseButton = new Button(client, SWT.PUSH);
		projectBrowseButton.setText(Messages.TagManagerDialog_Browse_xbut);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(projectBrowseButton);
		SWTUtil.setButtonWidthHint(projectBrowseButton);
		projectBrowseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final IProject project = TagManagerDialog.this.projectProvider.getProject();
				final IProject resultProject = AbapProjectSelectionDialog.open(client.getShell(), project);
				if (resultProject != null) {
					TagManagerDialog.this.projectField.setText(resultProject.getName());
				}
			}
		});
		this.projectField.addModifyListener(e -> {
			final String projectName = this.projectField.getText();
			setProject(projectName);
			this.model.setValidProject(validateAndSetStatus(validateProject(projectName)));
		});

		formToolkit.paintBordersFor(client);
		projectSection.setClient(client);

		// register Observables
		ISideEffect.create(() -> !this.model.isEditMode(), this.projectField::setEditable);
		ISideEffect.create(() -> !this.model.isEditMode(), projectBrowseButton::setEnabled);

	}

	private void createStatusLine(final Composite parent) {
		final Composite statusComposite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(statusComposite);
		GridLayoutFactory.swtDefaults().applyTo(statusComposite);
		this.statusLine = new MessageLine(statusComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(this.statusLine);
		this.statusLine.setAlignment(SWT.LEFT);
		this.statusLine.setStatus(null);
	}

	/*
	 * Validates the current project
	 */
	private IStatus validateProject(final String projectName) {
		if (projectName != null && !projectName.isEmpty()) {
			if (this.projectProvider.hasProject()) {
				// check if user is logged on to project
				if (!this.projectProvider.ensureLoggedOn()) {
					return new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID, STATUS_PROJECT,
						NLS.bind(Messages.TagManagerDialog_LogonFailedMessage_xmsg, this.projectProvider.getProjectName()), null);
				}
				// check if the project supports the ABAP Tags
				this.uriDiscovery = new AbapTagsUriDiscovery(this.projectProvider.getDestinationId());
				if (this.uriDiscovery.getTagsUri() == null) {
					this.uriDiscovery = null;
					return new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID, STATUS_PROJECT,
						NLS.bind(Messages.TagManagerDialog_TagsNotSupported_xmsg, this.projectProvider.getProjectName()), null);
				}
				return new Status(IStatus.OK, AbapTagsUIPlugin.PLUGIN_ID, STATUS_PROJECT, null, null);
			} else {
				// project does not exist
				return new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID, STATUS_PROJECT,
					Messages.TagManagerDialog_ProjectNotExists_xmsg, null);
			}
		}
		// no project name entered
		return new Status(IStatus.WARNING, AbapTagsUIPlugin.PLUGIN_ID, STATUS_PROJECT,
			Messages.TagManagerDialog_ProjectNameMissing_xmsg, null);
	}

	/*
	 * Updates the project provider with the given project name. If no project for
	 * the given name can be found the project of the provider will be set to null
	 */
	private void setProject(final String projectName) {
		if (projectName == null || "".equals(projectName)) { //$NON-NLS-1$
			this.projectProvider.setProject(null);
		} else {
			// check if there is an ABAP project which matches the entered name
			final IProject[] abapProjects = AdtUtil.getAbapProjects();
			String availableProjectName = null;
			for (final IProject project : abapProjects) {
				if (project.getName().equalsIgnoreCase(projectName)) {
					availableProjectName = project.getName();
					break;
				}
			}
			if (availableProjectName != null) {
				this.projectProvider.setProject(ResourcesPlugin.getWorkspace().getRoot().getProject(availableProjectName));
			} else {
				this.projectProvider.setProject(null);
			}
		}

	}

	private boolean validateAndSetStatus(final IStatus status) {
		final IStatus validatedStatus = validateStatus(status);
		updateStatus(validatedStatus);
		return validatedStatus == null || validatedStatus.isOK();
	}

	private void updateStatus(final IStatus status) {
		if (this.statusLine != null && !this.statusLine.isDisposed()) {
			updateButtonsEnableState(status);
			this.statusLine.setStatus(status);
		}
	}

	private IStatus validateStatus(IStatus status) {
		if (status == null) {
			status = Status.OK_STATUS;
		}
		if (this.currentStatus == null) {
			return status;
		}
		if (status.getCode() == this.currentStatus.getCode()) {
			return status;
		}
		return status;
	}

}
