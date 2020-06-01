package com.devepos.adt.atm.ui.internal.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.PatternFilter;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagPreviewInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.validation.TagListValidator;
import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.tagging.IAdtObjTaggingService;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.tree.TagFilter;
import com.devepos.adt.atm.ui.internal.tree.TagLabelProvider;
import com.devepos.adt.atm.ui.internal.tree.TagTreeContentProvider;
import com.devepos.adt.tools.base.destinations.DestinationUtil;
import com.devepos.adt.tools.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.tools.base.project.ProjectUtil;
import com.devepos.adt.tools.base.ui.StylerFactory;
import com.devepos.adt.tools.base.util.StringUtil;
import com.devepos.adt.tools.base.wizard.AbstractBaseWizardPage;

public class TagSelectionWizardPage extends AbstractBaseWizardPage {
	public static final String PAGE_NAME = TaggableObjectSelectionWizardPage.class.getCanonicalName();
	private Tree tagsTree;
	private CheckboxTreeViewer checkBoxViewer;
	private Text filterText;
	private final PatternFilter patternFilter;
	private int objectCount;
	private TreeViewerLabelProvider treeLabelProvider;
	private TagTreeContentProvider treeContentProvider;
	private final Set<ITag> checkedTags = new HashSet<>();
	private final Set<ITag> preCheckedTags = new HashSet<>();
	private final Set<ITag> uncheckableTags = new HashSet<>();
	private final List<ITag> newTags = new ArrayList<>();
	private String alreadyCheckedTagName;
	private boolean needsParentObjectSelection;
	private String owner;
	private Button removeTagButton;

	public TagSelectionWizardPage() {
		super(PAGE_NAME);
		setTitle(Messages.TagSelectionWizardPage_Title_xtit);
		this.patternFilter = new TagFilter();
		this.patternFilter.setIncludeLeadingWildcard(true);
	}

	@Override
	public ITagObjectsWizard getWizard() {
		return (ITagObjectsWizard) super.getWizard();
	}

	@Override
	public boolean isPageComplete() {
		return !this.checkedTags.isEmpty();
	}

	@Override
	public boolean canFlipToNextPage() {
		return isPageComplete() && StringUtil.isEmpty(getErrorMessage()) && this.needsParentObjectSelection;
	}

	@Override
	public void setVisible(final boolean visible) {
		final boolean previousPageIsDirty = getWizard().isPreviousPageDirty(this);
		if (visible && (!isPageComplete() || previousPageIsDirty)) {
			if (previousPageIsDirty) {
				clearCheckedTags();
				this.owner = null;
				this.newTags.clear();
				this.needsParentObjectSelection = false;
				getWizard().setCanFinish(false);
			}
			getWizard().completePreviousPage(this);

			if (!getWizard().getCurrentTagPreviewInfo().getTags().isEmpty()) {
				fillTagsFromPreviewInfo();
			} else if (getWizard().getCurrentTagPreviewInfo().getTags().isEmpty()
				&& !getWizard().getSelectedObjects().getObjectReferences().isEmpty()) {
				loadTagPreviewInfo();
			}
		}
		super.setVisible(visible);
	}

	@Override
	public void completePage() {
		if (!isDirty()) {
			return;
		}
		getWizard().getSelectedTags().clear();
		getWizard().getSelectedTags().addAll(this.checkedTags);
		getWizard().getTaggedObjectList().getTaggedObjects().clear();

		final List<IAdtObjRef> objectsToBeTagged = getWizard().getCurrentTagPreviewInfo().getAdtObjectRefs();
		for (final IAdtObjRef adtObjRef : objectsToBeTagged) {
			final ITaggedObject taggedObject = IAbapTagsFactory.eINSTANCE.createTaggedObject();
			final IAdtObjRef objRefNew = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
			objRefNew.setUri(adtObjRef.getUri());
			objRefNew.setName(adtObjRef.getName());
			objRefNew.setType(adtObjRef.getType());
			taggedObject.setObjectRef(objRefNew);
			for (final ITag selectedTag : this.checkedTags) {
				final IAdtObjectTag objectTag = IAbapTagsFactory.eINSTANCE.createAdtObjectTag();
				objectTag.setId(selectedTag.getId());
				objectTag.setName(selectedTag.getName());
				objectTag.setOwner(selectedTag.getOwner());
				objectTag.setUserTag(selectedTag.getOwner() != null && !selectedTag.getOwner().isEmpty());
				final EObject parent = selectedTag.eContainer();
				if (parent != null && parent instanceof ITag) {
					objectTag.setParentTagId(((ITag) parent).getId());
					objectTag.setParentTagName(((ITag) parent).getName());
				}
				taggedObject.getTags().add(objectTag);
			}
			getWizard().getTaggedObjectList().getTaggedObjects().add(taggedObject);
		}
		setDirty(false);
	}

	@Override
	public void createControl(final Composite parent) {
		final Composite root = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().margins(0, 0).numColumns(2).applyTo(root);

		final Composite leftComposite = new Composite(root, SWT.NONE);
		GridLayoutFactory.swtDefaults().applyTo(leftComposite);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(leftComposite);

		final Composite rightComposite = new Composite(root, SWT.NONE);
		GridLayoutFactory.swtDefaults().margins(0, 0).extendedMargins(0, 5, 0, 0).applyTo(rightComposite);
		GridDataFactory.fillDefaults().applyTo(rightComposite);

		createShowUserTagsCheckbox(leftComposite);
		createFilterText(leftComposite);
		createTagsCheckBoxTree(leftComposite);
		createTreeButtons(rightComposite);
		setControl(root);
		setPageComplete(false);
	}

	private void createTreeButtons(final Composite parent) {
		final Composite buttonComposite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().margins(0, 0).extendedMargins(0, 0, 62, 0).applyTo(buttonComposite);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.BEGINNING, SWT.BEGINNING).applyTo(buttonComposite);

		final Button addTag = new Button(buttonComposite, SWT.PUSH);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(addTag);
		addTag.setText(Messages.TagSelectionWizardPage_AddGlobalTag_xbut);
		addTag.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				addTag(false);
			}
		});

		final Button addUserTag = new Button(buttonComposite, SWT.PUSH);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(addUserTag);
		addUserTag.setText(Messages.TagSelectionWizardPage_AddUserTag_xbut);
		addUserTag.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				addTag(true);
			}
		});

		this.removeTagButton = new Button(buttonComposite, SWT.PUSH);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(this.removeTagButton);
		this.removeTagButton.setText(Messages.TagSelectionWizardPage_RemoveTag_xbut);
		this.removeTagButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				removeTag();
			}
		});
		this.removeTagButton.setEnabled(false);

		this.checkBoxViewer.addSelectionChangedListener(e -> {
			updateRemoveTagEnabled();
		});
	}

	private void updateRemoveTagEnabled() {
		boolean removeEnabled = false;
		final IStructuredSelection sel = (IStructuredSelection) TagSelectionWizardPage.this.checkBoxViewer.getSelection();
		if (sel != null && !sel.isEmpty()) {
			final ITag selectedTag = (ITag) sel.getFirstElement();
			removeEnabled = StringUtil.isEmpty(selectedTag.getId());
		}
		TagSelectionWizardPage.this.removeTagButton.setEnabled(removeEnabled);
	}

	private void removeTag() {
		final IStructuredSelection sel = (IStructuredSelection) this.checkBoxViewer.getSelection();
		final ITag selectedTag = (ITag) sel.getFirstElement();
		getWizard().getCurrentTagPreviewInfo().getTags().remove(selectedTag);
		this.newTags.remove(selectedTag);
		this.checkedTags.remove(selectedTag);
		this.checkBoxViewer.refresh();
		updatePageStatus();
	}

	private void addTag(final boolean userTag) {
		final ITag newTag = IAbapTagsFactory.eINSTANCE.createTag();
		newTag.setName(Messages.TagSelectionWizardPage_NewTagDefaultName_xmsg);
		if (userTag) {
			newTag.setOwner(getDestinationOwner());
		}
		getWizard().getCurrentTagPreviewInfo().getTags().add(newTag);
		this.newTags.add(newTag);
		this.checkBoxViewer.refresh();
		this.checkBoxViewer.setChecked(newTag, true);
		this.checkedTags.add(newTag);
		this.checkBoxViewer.setSelection(new StructuredSelection(newTag));
		this.checkBoxViewer.editElement(newTag, 0);
		setMessage(null);
	}

	private void fillTagsFromPreviewInfo() {
		final ITagPreviewInfo previewInfo = getWizard().getCurrentTagPreviewInfo();
		if (previewInfo != null) {
			this.objectCount = previewInfo.getAdtObjectRefs().size();
			if (this.objectCount > 1) {
				((Wizard) getWizard())
					.setWindowTitle(NLS.bind(Messages.TagObjectsWizard_MultipleObjectsWizardTitle_xtit, this.objectCount));
			} else {
				((Wizard) getWizard()).setWindowTitle(
					Messages.TagObjectsWizard_SingleObjectWizardTitle_xtit + previewInfo.getAdtObjectRefs().get(0).getName());
			}
			determinePreCheckedTags(previewInfo.getTags());
			this.checkBoxViewer.setInput(previewInfo.getTags());
			this.checkBoxViewer.expandAll();
			setCheckedElements();
		}
	}

	private void determinePreCheckedTags(final EList<ITag> tags) {
		for (final ITag tag : tags) {
			if (tag.getTaggedObjectCount() > 0) {
				this.preCheckedTags.add(tag);
				if (tag.getTaggedObjectCount() == this.objectCount) {
					this.uncheckableTags.add(tag);
				}
			}
			determinePreCheckedTags(tag.getChildTags());
		}
	}

	private void loadTagPreviewInfo() {
		final IProject project = getWizard().getProject();
		if (project == null) {
			return;
		}
		final String destinationId = ProjectUtil.getDestinationId(project);
		try {
			getContainer().run(true, false, monitor -> {
				monitor.beginTask(Messages.TagPreviewLoadingJob_JobTitle_xmsg, -1);
				final IAdtObjTaggingService taggingService = AdtObjTaggingServiceFactory.createTaggingService();

				// read current tags from project
				try {
					final ITagPreviewInfo previewInfo = taggingService.getInformationForTagging(destinationId,
						getWizard().getSelectedObjects());
					Display.getDefault().asyncExec(() -> {
						if (previewInfo == null || previewInfo.getTags().size() == 0) {
							setMessage(Messages.TaggingObjectWizard_NoTagsAvailableMessage_xmsg, INFORMATION);
							setPageComplete(false);
						}
						getWizard().setCurrentTagPreviewInfo(previewInfo);
						fillTagsFromPreviewInfo();
					});
				} catch (final CoreException e) {
					Display.getDefault().asyncExec(() -> {
						setErrorMessage(e.getMessage());
					});
				}
			});
		} catch (final InvocationTargetException e) {
			if (e.getTargetException() instanceof RuntimeException) {
				throw (RuntimeException) e.getTargetException();
			}
		} catch (final InterruptedException e) {

		}

	}

	private void createShowUserTagsCheckbox(final Composite parent) {
		final Button showUserTagsFilter = new Button(parent, SWT.CHECK);
		showUserTagsFilter.setText(Messages.TagSelectionWizardPage_ShowUserTags_xchk);
		showUserTagsFilter.setSelection(true);
		showUserTagsFilter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				TagSelectionWizardPage.this.treeContentProvider.setShowUserTags(showUserTagsFilter.getSelection());
				TagSelectionWizardPage.this.checkBoxViewer.refresh();
				setCheckedElements();
			}
		});
	}

	private void createFilterText(final Composite parent) {
		this.filterText = new Text(parent, SWT.SINGLE | SWT.BORDER | SWT.SEARCH | SWT.ICON_CANCEL);
		GridDataFactory.fillDefaults().grab(true, false).indent(SWT.DEFAULT, 10).applyTo(this.filterText);
		this.filterText.setMessage(Messages.TagSelectionWizardPage_TagFilterPrompt_xmsg);

		this.filterText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				// on a CR we want to transfer focus to the list
				final boolean hasItems = TagSelectionWizardPage.this.tagsTree.getItemCount() > 0;
				if (hasItems && e.keyCode == SWT.ARROW_DOWN) {
					TagSelectionWizardPage.this.tagsTree.setFocus();
				} else if (e.character == SWT.CR) {
					return;
				}
			}
		});
		this.filterText.addModifyListener(e -> {
			this.patternFilter.setPattern(this.filterText.getText());
			Display.getDefault().timerExec(500, (Runnable) () -> {
				if (this.filterText != null && this.filterText.getText().length() == 0) {
					this.checkBoxViewer.expandAll();
				}
			});
			this.checkBoxViewer.refresh();
			setCheckedElements();
		});

	}

	private void createTagsCheckBoxTree(final Composite parent) {
		this.checkBoxViewer = new CheckboxTreeViewer(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		this.tagsTree = this.checkBoxViewer.getTree();
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).minSize(250, 300).applyTo(this.tagsTree);
		this.checkBoxViewer.addFilter(this.patternFilter);
		this.treeLabelProvider = new TreeViewerLabelProvider();
		this.treeContentProvider = new TagTreeContentProvider();
		this.checkBoxViewer.setContentProvider(this.treeContentProvider);
		final TreeViewerColumn nameColumn = new TreeViewerColumn(this.checkBoxViewer, SWT.FULL_SELECTION, SWT.NONE);
		nameColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(this.treeLabelProvider));
		nameColumn.setEditingSupport(new TextEditingSupport(this.checkBoxViewer));
		nameColumn.getColumn().setWidth(400);
		this.checkBoxViewer.addCheckStateListener(event -> {
			setMessage(null);
			final ITag tag = (ITag) event.getElement();
			if (!event.getChecked() && this.uncheckableTags.contains(tag)) {
				event.getCheckable().setChecked(tag, true);
				setMessage(NLS.bind(Messages.TagSelectionWizardPage_TagSelectionNotReversable_xmsg, tag.getName()), INFORMATION);
				return;
			}
			this.alreadyCheckedTagName = ""; //$NON-NLS-1$
			if (event.getChecked() && shouldRevertCheckedState(tag)) {
				setMessage(NLS.bind(Messages.TagSelectionWizardPage_TagHierarchySelectionError_xmsg, this.alreadyCheckedTagName),
					INFORMATION);
				event.getCheckable().setChecked(tag, !event.getChecked());
			} else {
				if (event.getChecked()) {
					this.checkedTags.add((ITag) event.getElement());
				} else {
					this.checkedTags.remove(event.getElement());
				}
				setDirty(true);
			}
			updatePageStatus();
		});
		this.tagsTree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.keyCode != SWT.CR) {
					return;
				}
				final IStructuredSelection sel = TagSelectionWizardPage.this.checkBoxViewer.getStructuredSelection();
				if (sel.isEmpty()) {
					return;
				}
				final ITag selectedTag = (ITag) sel.getFirstElement();
				if (StringUtil.isEmpty(selectedTag.getId())) {
					TagSelectionWizardPage.this.checkBoxViewer.editElement(selectedTag, 0);
				}
			}
		});
	}

	private boolean shouldRevertCheckedState(final ITag tag) {
		/*
		 * if a tag is in the list of pre checked tags and all selected objects have
		 * this tag a selection makes no sense and should therefore be prevented
		 */
		return isParentChecked(tag) || hasCheckedChildren(tag);
	}

	private boolean isParentChecked(final ITag tag) {
		final EObject container = tag.eContainer();
		if (container instanceof ITag) {
			if (this.checkedTags.contains(container) || this.preCheckedTags.contains(container)) {
				this.alreadyCheckedTagName = ((ITag) container).getName();
				return true;
			}
			return hasCheckedSiblings((ITag) container, tag) || isParentChecked((ITag) container);
		}
		return false;
	}

	private boolean hasCheckedSiblings(final ITag parent, final ITag excludedTag) {
		if (parent.getChildTags().size() == 0) {
			return false;
		}
		for (final ITag childTag : parent.getChildTags()) {
			if (childTag == excludedTag) {
				continue;
			}
			if (this.checkedTags.contains(childTag) || this.preCheckedTags.contains(childTag)) {
				this.alreadyCheckedTagName = childTag.getName();
				return true;
			}
			if (hasCheckedChildren(childTag)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasCheckedChildren(final ITag tag) {
		if (tag.getChildTags().size() == 0) {
			return false;
		}
		for (final ITag childTag : tag.getChildTags()) {
			if (this.checkedTags.contains(childTag) || this.preCheckedTags.contains(childTag)) {
				this.alreadyCheckedTagName = childTag.getName();
				return true;
			}
			if (hasCheckedChildren(childTag)) {
				return true;
			}
		}
		return false;
	}

	private void updatePageStatus() {
		IStatus tagStatus = null;
		if (!this.newTags.isEmpty()) {
			tagStatus = new TagListValidator((List<ITag>) this.checkBoxViewer.getInput()).validate(true, false);
		}
		boolean isComplete = false;
		this.needsParentObjectSelection = false;
		if (tagStatus == null || tagStatus.isOK()) {
			setErrorMessage(null);
			isComplete = this.checkedTags.size() > 0;
			if (!isComplete) {
				getWizard().setCanFinish(false);
			} else {
				for (final ITag tag : this.checkedTags) {
					final EObject parent = tag.eContainer();
					if (parent instanceof ITag) {
						this.needsParentObjectSelection = true;
						break;
					}
				}
				getWizard().setCanFinish(!this.needsParentObjectSelection);
			}
		} else {
			setErrorMessage(tagStatus.getMessage());
			getWizard().setCanFinish(false);
		}
		setPageComplete(isComplete);
	}

	private void setCheckedElements() {
		for (final Object checkedItem : this.checkedTags) {
			this.checkBoxViewer.setChecked(checkedItem, true);
		}
		for (final Object checkedItem : this.uncheckableTags) {
			this.checkBoxViewer.setChecked(checkedItem, true);
		}
	}

	private class TreeViewerLabelProvider extends TagLabelProvider {
		public TreeViewerLabelProvider() {
			super(false, false);
		}

		@Override
		public StyledString getStyledText(final Object element) {
			final StyledString text = new StyledString();
			final ITag tagNode = (ITag) element;

			if (!StringUtil.isEmpty(tagNode.getId())) {
				if (tagNode.getTaggedObjectCount() == TagSelectionWizardPage.this.objectCount) {
					text.append(tagNode.getName(), StylerFactory.BOLD_STYLER);
				} else {
					text.append(tagNode.getName());
				}
				text.append(" (" + tagNode.getTaggedObjectCount() + " of " + TagSelectionWizardPage.this.objectCount + ")", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					StyledString.COUNTER_STYLER);
			} else {
				text.append(tagNode.getName(), StylerFactory.ITALIC_STYLER);
				text.append(" **", StylerFactory.BOLD_STYLER); //$NON-NLS-1$
			}

			return text;
		}

	}

	private void clearCheckedTags() {
		this.checkedTags.clear();
		this.preCheckedTags.clear();
	}

	private String getDestinationOwner() {
		if (this.owner == null) {
			final String destinationId = ProjectUtil.getDestinationId(getWizard().getProject());
			this.owner = DestinationUtil.getDestinationData(destinationId).getUser();
		}
		return this.owner;
	}

	private class TextEditingSupport extends EditingSupport {

		public TextEditingSupport(final ColumnViewer viewer) {
			super(viewer);
		}

		@Override
		public CheckboxTreeViewer getViewer() {
			return (CheckboxTreeViewer) super.getViewer();
		}

		@Override
		protected CellEditor getCellEditor(final Object element) {
			return new TextCellEditor(getViewer().getTree());
		}

		@Override
		protected boolean canEdit(final Object element) {
			return StringUtil.isEmpty(((ITag) element).getId());
		}

		@Override
		protected Object getValue(final Object element) {
			return ((ITag) element).getName();
		}

		@Override
		protected void setValue(final Object element, final Object value) {
			((ITag) element).setName((String) value);
			getViewer().update(element, null);
			updatePageStatus();
		}

	}
}
