package com.devepos.adt.abaptags.ui.internal.forms;

import org.eclipse.core.databinding.observable.sideeffect.ISideEffect;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.devepos.adt.abaptags.ITag;
import com.devepos.adt.abaptags.ui.AbapTagsUIPlugin;
import com.devepos.adt.abaptags.ui.internal.util.IImages;
import com.devepos.adt.tools.base.AdtToolsBasePlugin;
import com.devepos.adt.tools.base.IGeneralWorkbenchImages;
import com.devepos.adt.tools.base.ui.StylerFactory;
import com.devepos.adt.tools.base.ui.tree.ITreeNode;
import com.devepos.adt.tools.base.util.IModificationListener;

/**
 * Master Details block for Tags
 *
 * @author stockbal
 */
public class AbapTagMasterDetailsBlock extends MasterDetailsBlock implements IMasterSection {

	private final AbapTagModel model;
	private Section masterSection;
	private Tree tagsTree;
	private TreeViewer treeViewer;

	public AbapTagMasterDetailsBlock(final AbapTagModel model) {
		this.model = model;
	}

	@Override
	public void createContent(final IManagedForm managedForm) {
		super.createContent(managedForm);
		this.detailsPart.setPageProvider(new AbapTagDetailsPageProvider(this));
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
		this.masterSection.setText("Tags");
		this.masterSection.setDescription("Overview of all tags in the current project");
		createSectionToolbar(this.masterSection, toolkit);

		final Composite client = toolkit.createComposite(this.masterSection, SWT.WRAP);
		GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).extendedMargins(2, 2, 2, 10).applyTo(client);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(client);
		toolkit.paintBordersFor(client);

		this.tagsTree = toolkit.createTree(client, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(this.tagsTree);
		// register observables
		ISideEffect.create(() -> this.model.isValid(), this.tagsTree::setEnabled);

		final Composite buttonComposite = toolkit.createComposite(client);
		GridLayoutFactory.swtDefaults().margins(2, 2).applyTo(buttonComposite);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(buttonComposite);

		final Button addButton = toolkit.createButton(buttonComposite, "&Add", SWT.PUSH); //$NON-NLS-1$
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(addButton);
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final ITag newTag = AbapTagMasterDetailsBlock.this.model.addNewTag();
				AbapTagMasterDetailsBlock.this.treeViewer.setSelection(new StructuredSelection(newTag), true);
			}
		});
		// register observables
		ISideEffect.create(() -> this.model.isValid() && this.model.isEditMode(), addButton::setEnabled);

		final Button removeButton = toolkit.createButton(buttonComposite, "&Remove", SWT.PUSH); //$NON-NLS-1$
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(removeButton);
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
			}
		});
		// register observables
		ISideEffect.create(() -> this.model.isEditMode(), removeButton::setEnabled);

		this.masterSection.setClient(client);

		final SectionPart spart = new SectionPart(this.masterSection);
		managedForm.addPart(spart);

		this.treeViewer = new TreeViewer(this.tagsTree);
		this.treeViewer.setContentProvider(new TreeContentProvicder());
		this.treeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new TreeViewerLabelProvider()));
		this.treeViewer.addSelectionChangedListener(event -> {
			managedForm.fireSelectionChanged(spart, event.getSelection());
		});
		this.treeViewer.setInput(this.model);

		this.model.addModificationListener(new IModificationListener<ITag>() {

			@Override
			public void modified(final ITag entry, final ModificationKind modificationKind) {
				AbapTagMasterDetailsBlock.this.treeViewer.refresh();
			}

			@Override
			public void modified(final ModificationKind kind) {
				AbapTagMasterDetailsBlock.this.treeViewer.refresh();
			}
		});

	}

	@Override
	protected void registerPages(final DetailsPart detailsPart) {
	}

	@Override
	protected void createToolBarActions(final IManagedForm managedForm) {
		final Action refreshAction = new Action("Refresh",
			AdtToolsBasePlugin.getDefault().getImageDescriptor(IGeneralWorkbenchImages.REFRESH)) {
			@Override
			public void run() {
			}
		};
		final Action editAction = new Action("Edit",
			AdtToolsBasePlugin.getDefault().getImageDescriptor(IGeneralWorkbenchImages.EDIT_ACTION)) {
			@Override
			public void run() {
				AbapTagMasterDetailsBlock.this.model.setEditMode(true);
			}
		};
		final Action saveAction = new Action("Save",
			AdtToolsBasePlugin.getDefault().getImageDescriptor(IGeneralWorkbenchImages.SAVE_ACTION)) {
			@Override
			public void run() {
				AbapTagMasterDetailsBlock.this.model.setEditMode(false);
			}
		};
		final Action unlockAction = new Action("Unlock Data",
			AdtToolsBasePlugin.getDefault().getImageDescriptor(IGeneralWorkbenchImages.UNLOCK_ACTION)) {
			@Override
			public void run() {
				if (AbapTagMasterDetailsBlock.this.model.hasModelChanged()) {
					if (!MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Unlock?",
						"There are changed data in the model\nAre you sure want to discard the changes?")) {
						return;
					}
				}
				AbapTagMasterDetailsBlock.this.model.setEditMode(false);
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

		final IAction collapseAllAction = new Action("Collapse all",
			AdtToolsBasePlugin.getDefault().getImageDescriptor(IGeneralWorkbenchImages.COLLAPSE_ALL)) {
			@Override
			public void run() {
			}
		};
		toolBarManager.add(collapseAllAction);

		toolBarManager.update(true);

		section.setTextClient(toolbar);
	}

	private class TreeContentProvicder implements ITreeContentProvider {

		@Override
		public Object[] getElements(final Object inputElement) {
			if (inputElement instanceof IModel) {
				return ((AbapTagModel) inputElement).getContents();
			}
			return new Object[0];
		}

		@Override
		public Object[] getChildren(final Object parentElement) {
			if (parentElement instanceof ITag) {
				return ((ITag) parentElement).getChildTag().toArray();
			}
			return null;
		}

		@Override
		public Object getParent(final Object element) {
			return element instanceof ITreeNode ? ((ITreeNode) element).getParent() : null;
		}

		@Override
		public boolean hasChildren(final Object element) {
			if (element instanceof ITag) {
				final ITag tag = (ITag) element;
				return tag.getChildTag().size() > 0;
			}
			return false;
		}

	}

	private class TreeViewerLabelProvider extends LabelProvider implements ILabelProvider, IStyledLabelProvider {

		@Override
		public String getText(final Object element) {
			final ITag node = (ITag) element;
			return node.getName();
		}

		@Override
		public Image getImage(final Object element) {
			if (element instanceof ITag) {
				final ITag tag = (ITag) element;
				if (tag.getId() == null || tag.getId().isBlank()) {
					return AbapTagsUIPlugin.getDefault().getImage(IImages.TAGS, true);
				} else {
					return AbapTagsUIPlugin.getDefault().getImage(IImages.TAGS);
				}
			}
			return null;
		}

		@Override
		public StyledString getStyledText(final Object element) {
			final StyledString text = new StyledString();
			final ITag tagNode = (ITag) element;

			if (tagNode.isChanged()) {
				text.append(tagNode.getName(), StylerFactory.ITALIC_STYLER);
			} else {
				text.append(tagNode.getName());
			}
			text.append(" (" + tagNode.getTaggedObjectCount() + ")", StyledString.COUNTER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$

			return text;
		}
	}

}
