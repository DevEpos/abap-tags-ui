package com.devepos.adt.atm.ui.internal.forms;

import org.eclipse.core.databinding.observable.sideeffect.ISideEffect;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.tree.TagLabelProvider;
import com.devepos.adt.atm.ui.internal.tree.TagTreeContentProvider;
import com.devepos.adt.tools.base.AdtToolsBaseResources;
import com.devepos.adt.tools.base.IAdtToolsBaseImages;
import com.devepos.adt.tools.base.ui.tree.PrefixedAsteriskFilteredTree;
import com.devepos.adt.tools.base.util.IModificationListener;

/**
 * Master Details block for Tags
 *
 * @author stockbal
 */
public class AbapTagMasterDetailsBlock extends MasterDetailsBlock implements IMasterSection {

	private final AbapTagModel model;
	private Section masterSection;
	private FilteredTree tagsTree;
	private TreeViewer treeViewer;
	private IModificationListener<ITag> modListener;

	public AbapTagMasterDetailsBlock(final AbapTagModel model) {
		this.model = model;
	}

	@Override
	public void createContent(final IManagedForm managedForm) {
		super.createContent(managedForm);
		this.detailsPart.setPageProvider(new AbapTagDetailsPageProvider(this));

		// register menus
		final MenuManager popupMenuManager = new MenuManager();
		final IMenuListener listener = mng -> fillContextMenu(mng);
		popupMenuManager.addMenuListener(listener);
		popupMenuManager.setRemoveAllWhenShown(true);
		final Control tree = this.treeViewer.getControl();
		final Menu menu = popupMenuManager.createContextMenu(tree);
		tree.setMenu(menu);
	}

	private void fillContextMenu(final IMenuManager mng) {
		if (!this.model.isEditMode()) {
			return; // currently there are no actions for read only mode
		}
		final IStructuredSelection sel = (IStructuredSelection) this.treeViewer.getSelection();
		if (sel.isEmpty()) {
			return;
		}

		if (sel.size() == 1) {
			final ITag selectedTag = (ITag) sel.getFirstElement();
			mng.add(new AddChildTag(selectedTag));
		}
		mng.add(new RemoveTagAction());
	}

	@Override
	public void enableSelectionChange(final boolean enable) {
		if (this.tagsTree != null && !this.tagsTree.isDisposed()) {
			this.tagsTree.setEnabled(enable);
		}
	}

	@Override
	public int getTextClientHeightDifference() {
		if (this.masterSection != null && !this.masterSection.isDisposed()) {
			return this.masterSection.getTextClientHeightDifference();
		}
		return 0;
	}

	@Override
	public IModel getModel() {
		return this.model;
	}

	@Override
	protected void createMasterPart(final IManagedForm managedForm, final Composite parent) {
		final FormToolkit toolkit = managedForm.getToolkit();
		this.masterSection = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR);
		this.masterSection.setText(Messages.AbapTagMasterDetailsBlock_MasterSectionTitle_xtit);
		this.masterSection.setDescription(Messages.AbapTagMasterDetailsBlock_MasterSectionDescription_xmsg);
		createSectionToolbar(this.masterSection, toolkit);

		final Composite client = toolkit.createComposite(this.masterSection, SWT.WRAP);
		GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).extendedMargins(2, 2, 2, 10).applyTo(client);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(client);
		toolkit.paintBordersFor(client);

		this.tagsTree = createFilteredTree(client);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(this.tagsTree);
		// register observables
		ISideEffect.create(() -> this.model.isValid(), this.tagsTree::setEnabled);

		final Composite buttonComposite = toolkit.createComposite(client);
		GridLayoutFactory.swtDefaults().margins(2, 28).applyTo(buttonComposite);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(buttonComposite);

		final Button addButton = toolkit.createButton(buttonComposite, Messages.AbapTagMasterDetailsBlock_AddAction_xbut,
			SWT.PUSH);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(addButton);
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final ITag newTag = AbapTagMasterDetailsBlock.this.model.addNewTag(null);
				newTag.setName("New Tag"); //$NON-NLS-1$
				AbapTagMasterDetailsBlock.this.treeViewer.setSelection(new StructuredSelection(newTag), true);
			}
		});
		// register observables
		ISideEffect.create(() -> this.model.isValid() && this.model.isEditMode(), addButton::setEnabled);

		final Button removeButton = toolkit.createButton(buttonComposite, Messages.AbapTagMasterDetailsBlock_RemoveAction_xbut,
			SWT.PUSH);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(removeButton);
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				removeTags();
			}
		});
		// register observables
		ISideEffect.create(() -> this.model.isEditMode(), removeButton::setEnabled);

		this.masterSection.setClient(client);

		final SectionPart sectionPart = new SectionPart(this.masterSection);
		managedForm.addPart(sectionPart);

		this.treeViewer = this.tagsTree.getViewer();
		this.treeViewer.setContentProvider(new TagTreeContentProvider());
		this.treeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new TagLabelProvider()));
		this.treeViewer.addSelectionChangedListener(event -> {
			managedForm.fireSelectionChanged(sectionPart, event.getSelection());
		});
		this.treeViewer.setInput(this.model);

		this.modListener = new IModificationListener<ITag>() {

			@Override
			public void modified(final ITag entry, final ModificationKind modificationKind) {
				AbapTagMasterDetailsBlock.this.treeViewer.refresh();
			}

			@Override
			public void modified(final ModificationKind kind) {
				AbapTagMasterDetailsBlock.this.treeViewer.refresh();
				AbapTagMasterDetailsBlock.this.treeViewer.expandAll();
			}
		};
		this.model.addModificationListener(this.modListener);
		// Dispose of listener when form is disposed
		managedForm.getForm().addDisposeListener(e -> {
			if (this.modListener != null && this.model != null) {
				this.model.removeModificationListener(this.modListener);
			}
			this.modListener = null;
		});

	}

	@Override
	protected void registerPages(final DetailsPart detailsPart) {
	}

	@Override
	protected void createToolBarActions(final IManagedForm managedForm) {
		final Action refreshAction = new Action(Messages.AbapTagMasterDetailsBlock_RefreshAction_xtol,
			AdtToolsBaseResources.getImageDescriptor(IAdtToolsBaseImages.REFRESH)) {
			@Override
			public void run() {
				AbapTagMasterDetailsBlock.this.model.refreshTags();
			}
		};
		final Action editAction = new Action(Messages.AbapTagMasterDetailsBlock_EditAction_xtol,
			AdtToolsBaseResources.getImageDescriptor(IAdtToolsBaseImages.EDIT_ACTION)) {
			@Override
			public void run() {
				AbapTagMasterDetailsBlock.this.model.editTags();
			}
		};
		final Action saveAction = new Action(Messages.AbapTagMasterDetailsBlock_SaveAction_xtol,
			PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT)) {
			@Override
			public void run() {
				AbapTagMasterDetailsBlock.this.model.saveTags();
			}
		};
		final Action unlockAction = new Action(Messages.AbapTagMasterDetailsBlock_CancelAction_xtol,
			PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_UNDO)) {
			@Override
			public void run() {
				AbapTagMasterDetailsBlock.this.model.unlock(true);
			}
		};
		ISideEffect.create(() -> this.model.isValid() && this.model.isEditMode(), saveAction::setEnabled);
		ISideEffect.create(() -> !this.model.isEditMode() && this.model.hasValidProject(), refreshAction::setEnabled);
		ISideEffect.create(this.model::isEditMode, unlockAction::setEnabled);
		ISideEffect.create(() -> !this.model.isEditMode() && this.model.hasValidProject(), editAction::setEnabled);

		managedForm.getForm().getToolBarManager().add(editAction);
		managedForm.getForm().getToolBarManager().add(saveAction);
		managedForm.getForm().getToolBarManager().add(unlockAction);
		managedForm.getForm().getToolBarManager().add(new Separator());
		managedForm.getForm().getToolBarManager().add(refreshAction);
	}

	/*
	 * Creates toolbar in section
	 */
	private void createSectionToolbar(final Section section, final FormToolkit toolkit) {
		final ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		final ToolBar toolbar = toolBarManager.createControl(section);
		// sets the cursor to the hand cursor
		final Cursor handCursor = Display.getCurrent().getSystemCursor(SWT.CURSOR_HAND);
		toolbar.setCursor(handCursor);

		final IAction collapseAllAction = new Action(Messages.AbapTagMasterDetailsBlock_CollapseAll_xtol,
			AdtToolsBaseResources.getImageDescriptor(IAdtToolsBaseImages.COLLAPSE_ALL)) {
			@Override
			public void run() {
				AbapTagMasterDetailsBlock.this.treeViewer.collapseAll();
			}
		};
		toolBarManager.add(collapseAllAction);

		toolBarManager.update(true);

		section.setTextClient(toolbar);
	}

	/*
	 * Creates the filtered tree for the display of the fields of a database entity
	 */
	private FilteredTree createFilteredTree(final Composite parent) {
		final FilteredTree tree = new PrefixedAsteriskFilteredTree(parent,
			SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER, createPatternFilter()) {
			@Override
			protected void textChanged() {
				super.textChanged();
				Display.getDefault().timerExec(500, (Runnable) () -> {
					if (this.filterText != null && this.filterText.getText().length() == 0) {
						getViewer().expandAll();
					}
				});
			}
		};
		return tree;
	}

	/*
	 * Creates the pattern filter which will be used for filtering the field tree
	 */
	private PatternFilter createPatternFilter() {
		return new PatternFilter() {
			@Override
			protected boolean isLeafMatch(final Viewer viewer, final Object element) {
				if (element instanceof ITag) {
					final ITag tag = (ITag) element;
					return wordMatches(tag.getName());
				}
				final DelegatingStyledCellLabelProvider labelProvider = (DelegatingStyledCellLabelProvider) AbapTagMasterDetailsBlock.this.treeViewer
					.getLabelProvider();
				final String labelText = labelProvider.getStyledStringProvider().getStyledText(element).getString();
				return wordMatches(labelText);
			}
		};
	}

	private void removeTags() {
		final IStructuredSelection sel = this.treeViewer.getStructuredSelection();
		if (sel.isEmpty()) {
			return;
		}
		for (final Object selected : sel.toList()) {
			this.model.removeTag((ITag) selected);
		}

		this.treeViewer.refresh();
	}

	private class AddChildTag extends Action {
		private final ITag tag;

		public AddChildTag(final ITag tag) {
			super(Messages.AbapTagMasterDetailsBlock_NewChildTagAction_xlbl,
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
			this.tag = tag;
		}

		@Override
		public void run() {
			final ITag newTag = AbapTagMasterDetailsBlock.this.model.addNewTag(this.tag);
			newTag.setName("New Tag"); //$NON-NLS-1$
			AbapTagMasterDetailsBlock.this.treeViewer.expandToLevel(this.tag, 1);
			AbapTagMasterDetailsBlock.this.treeViewer.setSelection(new StructuredSelection(newTag), true);
		}
	}

	private class RemoveTagAction extends Action {
		public RemoveTagAction() {
			super(Messages.AbapTagMasterDetailsBlock_RemoveAction_xlbl,
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
		}

		@Override
		public void run() {
			removeTags();
		}
	}

}
