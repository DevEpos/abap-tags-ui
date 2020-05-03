package com.devepos.adt.abaptags.ui.internal.wizard;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.devepos.adt.abaptags.ui.internal.messages.Messages;
import com.devepos.adt.tools.base.wizard.AbstractBaseWizardPage;
import com.sap.adt.tools.core.ui.AbapCoreUi;
import com.sap.adt.tools.core.ui.IAdtObjectTypeRegistryUi;

@SuppressWarnings("restriction")
public class TagParentObjectSelectionWizardPage extends AbstractBaseWizardPage {
	public static final String PAGE_NAME = TagParentObjectSelectionWizardPage.class.getCanonicalName();
	private final ITagObjectsWizardModel model;
	protected IAdtObjectTypeRegistryUi typeRegistryUi;

	protected TagParentObjectSelectionWizardPage(final ITagObjectsWizardModel model) {
		super(PAGE_NAME);
		setTitle(Messages.TagParentObjectSelectionWizardPage_Title_xtit);
		setDescription(Messages.TagParentObjectSelectionWizardPage_Description_xmsg);
		this.model = model;
		this.typeRegistryUi = AbapCoreUi.getObjectTypeRegistry();
	}

	@Override
	public void setVisible(final boolean visible) {
		if (visible && (!isPageComplete() || this.model.isPreviousPageDirty(this))) {
			this.model.completePreviousPage(this);

			// initialize controls
		}
		super.setVisible(visible);
	}

	@Override
	public void createControl(final Composite parent) {
		final Composite root = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().applyTo(root);

		createSelectionModeComposite(root);
		createTagsTable(root);
		setControl(root);

		setPageComplete(false);
	}

	private void createSelectionModeComposite(final Composite root) {
		final Composite modeComposite = new Composite(root, SWT.NONE);
		GridLayoutFactory.swtDefaults().applyTo(modeComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(modeComposite);

		final Button groupSelectionButton = new Button(modeComposite, SWT.RADIO);
		groupSelectionButton.setText(Messages.TagParentObjectSelectionWizardPage_MultipleSelectionMode_xrbl);
		groupSelectionButton.setSelection(true);
		groupSelectionButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				updateTableMode(!groupSelectionButton.getSelection());
			}
		});

		final Button singleSelectionButton = new Button(modeComposite, SWT.RADIO);
		singleSelectionButton.setText(Messages.TagParentObjectSelectionWizardPage_SingleSelectionMode_xrbl);
	}

	private void createTagsTable(final Composite root) {
		// TODO Auto-generated method stub

	}

	private void updateTableMode(final boolean singleSelection) {
	}

}
