package com.devepos.adt.abaptags.ui.internal.wizard;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.Viewer;
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

import com.devepos.adt.abaptags.ITag;
import com.devepos.adt.abaptags.ITagPreviewInfo;
import com.devepos.adt.abaptags.ui.internal.messages.Messages;
import com.devepos.adt.abaptags.ui.internal.tree.TagLabelProvider;
import com.devepos.adt.abaptags.ui.internal.tree.TagTreeContentProvider;
import com.devepos.adt.tools.base.ui.StylerFactory;
import com.devepos.adt.tools.base.util.AdtUtil;
import com.devepos.adt.tools.base.wizard.AbstractBaseWizardPage;

public class TagSelectionWizardPage extends AbstractBaseWizardPage {
	public static final String PAGE_NAME = TaggableObjectSelectionWizardPage.class.getCanonicalName();
	private final ITagObjectsWizardModel model;
	private Tree tagsTree;
	private CheckboxTreeViewer checkBoxViewer;
	private Text filterText;
	private final TreePatternFilter patternFilter;
	private int objectCount;
	private TreeViewerLabelProvider treeLabelProvider;
	private TagTreeContentProvider treeContentProvider;
	private final Set<ITag> checkedTags = new HashSet<>();
	private final Set<ITag> preCheckedTags = new HashSet<>();
	private final Set<ITag> uncheckableTags = new HashSet<>();
	private String alreadyCheckedTagName;
	private boolean needsParentObjectSelection;

	public TagSelectionWizardPage(final ITagObjectsWizardModel model) {
		super(PAGE_NAME);
		setTitle(Messages.TagSelectionWizardPage_Title_xtit);
		this.model = model;
		this.patternFilter = new TreePatternFilter();
		this.patternFilter.setIncludeLeadingWildcard(true);
	}

	@Override
	public boolean isPageComplete() {
		return !this.checkedTags.isEmpty();
	}

	@Override
	public boolean canFlipToNextPage() {
		return this.needsParentObjectSelection;
	}

	@Override
	public void setVisible(final boolean visible) {
		final boolean previousPageIsDirty = this.model.isPreviousPageDirty(this);
		if (visible && (!isPageComplete() || previousPageIsDirty)) {
			if (previousPageIsDirty) {
				clearCheckedTags();
				this.needsParentObjectSelection = false;
				this.model.setCanFinish(false);
			}
			this.model.completePreviousPage(this);

			if (!this.model.getCurrentTagPreviewInfo().getTags().isEmpty()) {
				fillTagsFromPreviewInfo();
			} else if (this.model.getCurrentTagPreviewInfo().getTags().isEmpty()
				&& !this.model.getSelectedObjects().getObjectReferences().isEmpty()) {
				loadTagPreviewInfo();
			}
		}
		super.setVisible(visible);
	}

	@Override
	public void createControl(final Composite parent) {
		final Composite root = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().applyTo(root);

		createShowUserTagsCheckbox(root);
		createFilterText(root);
		createTagsCheckBoxTree(root);
		setControl(root);
		setPageComplete(false);
	}

	private void fillTagsFromPreviewInfo() {
//		clearCheckedTags();
		final ITagPreviewInfo previewInfo = this.model.getCurrentTagPreviewInfo();
		if (previewInfo != null) {
			this.objectCount = previewInfo.getAdtObjectRefs().size();
			determinePreCheckedTags(previewInfo.getTags());
			this.checkBoxViewer.setInput(previewInfo.getTags());
			this.checkBoxViewer.expandAll();
			setCheckedElements();
		}
	}

	private void determinePreCheckedTags(final EList<ITag> tags) {
		for (final ITag tag : tags) {
			final EObject parent = tag.eContainer();
			final boolean isHierarchicalTag = parent != null && parent instanceof ITag || tag.isIsRoot();
			if (isHierarchicalTag && tag.getTaggedObjectCount() > 0) {
				this.preCheckedTags.add(tag);
				if (tag.getTaggedObjectCount() == this.objectCount) {
					this.uncheckableTags.add(tag);
				}
			} else {
				determinePreCheckedTags(tag.getChildTags());
			}
		}
	}

	private void loadTagPreviewInfo() {
//		clearCheckedTags();
		final IProject project = this.model.getProject();
		if (project == null) {
			return;
		}
		final String destinationId = AdtUtil.getDestinationId(project);
		final TagPreviewLoadingJob previewLoadingJob = new TagPreviewLoadingJob(destinationId, this.model.getSelectedObjects());
		previewLoadingJob.addJobDoneListener(e -> {
			if (e.getResult().isOK()) {
				final ITagPreviewInfo previewInfo = previewLoadingJob.getPreviewInfo();
				if (previewInfo == null || previewInfo.getTags().size() == 0) {
					setErrorMessage(Messages.TaggingObjectWizard_NoTagsAvailableMessage_xmsg);
					setPageComplete(false);
					return;
				}
				this.model.setCurrentTagPreviewInfo(previewLoadingJob.getPreviewInfo());
				fillTagsFromPreviewInfo();
			} else {
				setErrorMessage(e.getResult().getMessage());
			}
		}, true);
		previewLoadingJob.schedule();

	}

	private void createShowUserTagsCheckbox(final Composite root) {
		final Button showUserTagsFilter = new Button(root, SWT.CHECK);
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

	private void createFilterText(final Composite root) {
		this.filterText = new Text(root, SWT.SINGLE | SWT.BORDER | SWT.SEARCH | SWT.ICON_CANCEL);
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

	private void createTagsCheckBoxTree(final Composite root) {
		this.checkBoxViewer = new CheckboxTreeViewer(root, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		this.checkBoxViewer.addFilter(this.patternFilter);
		this.treeLabelProvider = new TreeViewerLabelProvider();
		this.treeContentProvider = new TagTreeContentProvider();
		this.checkBoxViewer.setContentProvider(this.treeContentProvider);
		this.checkBoxViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(this.treeLabelProvider));
		this.checkBoxViewer.addCheckStateListener(event -> {
			setMessage(""); //$NON-NLS-1$
			final ITag tag = (ITag) event.getElement();
			if (!event.getChecked() && this.uncheckableTags.contains(tag)) {
				event.getCheckable().setChecked(tag, true);
				setMessage(
					NLS.bind(Messages.TagSelectionWizardPage_TagSelectionNotReversable_xmsg,
						tag.getName()),
					INFORMATION);
				return;
			}
			this.alreadyCheckedTagName = ""; //$NON-NLS-1$
			if (event.getChecked() && shouldRevertCheckedState(tag)) {
				setMessage(NLS.bind(Messages.TagSelectionWizardPage_TagHierarchySelectionError_xmsg,
					this.alreadyCheckedTagName), INFORMATION);
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
		this.tagsTree = this.checkBoxViewer.getTree();
		GridDataFactory.fillDefaults().grab(true, true).minSize(250, 300).applyTo(this.tagsTree);
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
		final boolean isComplete = this.checkedTags.size() > 0;
		this.needsParentObjectSelection = false;
		if (!isComplete) {
			this.model.setCanFinish(false);
		} else {
			for (final ITag tag : this.checkedTags) {
				final EObject parent = tag.eContainer();
				if (parent instanceof ITag) {
					this.needsParentObjectSelection = true;
					break;
				}
			}
			this.model.setCanFinish(!this.needsParentObjectSelection);
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

	private class TreePatternFilter extends PatternFilter {
		@Override
		protected boolean isLeafMatch(final Viewer viewer, final Object element) {
			if (element instanceof ITag) {
				final ITag tag = (ITag) element;
				return wordMatches(tag.getName());
			}
			return false;
		}
	}

	private class TreeViewerLabelProvider extends TagLabelProvider {

		@Override
		public StyledString getStyledText(final Object element) {
			final StyledString text = new StyledString();
			final ITag tagNode = (ITag) element;

			if (tagNode.getTaggedObjectCount() == TagSelectionWizardPage.this.objectCount) {
				text.append(tagNode.getName(), StylerFactory.BOLD_STYLER);
			} else {
				text.append(tagNode.getName());
			}
			text.append(" (" + tagNode.getTaggedObjectCount() + " of " + TagSelectionWizardPage.this.objectCount + ")", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				StyledString.COUNTER_STYLER);

			return text;
		}
	}

	private void clearCheckedTags() {
		this.checkedTags.clear();
		this.preCheckedTags.clear();
	}
}
