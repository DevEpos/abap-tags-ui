package com.devepos.adt.atm.ui.internal.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.base.ui.controls.FilterableComposite;
import com.devepos.adt.base.ui.tree.FilterableTree;

/**
 * Tree control for loading, displaying and selecting ABAP Tags that exist in a certain ABAP project
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class TagSelectionTree {
  private CheckboxTreeViewer tagsTreeViewer;
  private IContentProvider contentProvider;
  private IStyledLabelProvider labelProvider;

  private FilterableTree tagsTree;

  private final List<ITag> tagList = new ArrayList<>();

  private final Set<ITag> checkedTags;
  private List<String> checkedTagIds;
  private final Set<ICheckStateListener> checkedStateListener = new HashSet<>();

  public TagSelectionTree() {
    checkedTags = new HashSet<>();
  }

  public void addCheckStateListener(final ICheckStateListener l) {
    checkedStateListener.add(l);
  }

  /**
   * @see {@link FilterableComposite#addKeyListenerForFilterFocus()
   */
  public void addKeyListenerForFilterFocus() {
    tagsTree.addKeyListenerForFilterFocus();
  }

  public void collapseAll() {
    if (isTreeOnline()) {
      tagsTreeViewer.collapseAll();
    }
  }

  public void createControl(final Composite parent) {
    tagsTree = new FilterableTree(parent, null, false, true) {
      @Override
      protected void filterJobCompleted() {
        super.filterJobCompleted();
        setCheckedElementsInTree();
        if (tagsTree.getFilterString() == null || tagsTree.getFilterString().trim().isEmpty()) {
          tagsTreeViewer.collapseAll();
        }
      }
    };
    tagsTree.setElementMatcher(element -> {
      if (element instanceof ITag) {
        final ITag tag = (ITag) element;
        return tagsTree.getWordMatcher().matchesWord(tag.getName()) || tagsTree.getWordMatcher()
            .matchesWord(tag.getDescription());
      }
      return false;
    });
    tagsTreeViewer = new CheckboxTreeViewer(tagsTree, SWT.V_SCROLL | SWT.MULTI | SWT.BORDER);
    tagsTree.setViewer(tagsTreeViewer);
    applyTreeLayoutData(tagsTreeViewer.getTree());
    tagsTree.setExpandAllOnFilterEmpty(false);

    tagsTreeViewer.setContentProvider(contentProvider != null ? contentProvider
        : new TagTreeContentProvider());
    tagsTreeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(labelProvider != null
        ? labelProvider
        : new TagLabelProvider(true, false)));
    tagsTreeViewer.setInput(tagList);
    tagsTree.setBackgroundMode(SWT.INHERIT_DEFAULT);

    tagsTreeViewer.addCheckStateListener(e -> {
      if (e.getChecked()) {
        checkedTags.add((ITag) e.getElement());
      } else {
        checkedTags.remove(e.getElement());
      }
      fireCheckedStateChanged();
    });
  }

  public void expandAll() {
    if (isTreeOnline()) {
      tagsTreeViewer.expandAll();
    }
  }

  public Set<ITag> getCheckedTags() {
    return checkedTags;
  }

  public Composite getTreeFilterComposite() {
    if (!isTreeOnline()) {
      throw new IllegalStateException("Tree is not online yet!");
    }
    return tagsTree.getFilterComposite();
  }

  public IStructuredSelection getViewerSelection() {
    if (isTreeOnline()) {
      return tagsTreeViewer.getStructuredSelection();
    }
    return StructuredSelection.EMPTY;
  }

  public boolean hasCheckedTags() {
    return !checkedTags.isEmpty();
  }

  public boolean hasViewerInput() {
    return isTreeOnline() && !tagList.isEmpty() && tagsTreeViewer.getInput() != null;
  }

  public void hookContextMenu(final MenuManager menuMgr) {
    if (!isTreeOnline()) {
      return;
    }
    var tree = tagsTreeViewer.getTree();
    var menu = menuMgr.createContextMenu(tree);
    tree.setMenu(menu);
  }

  public void refresh() {
    if (tagsTree != null && !tagsTree.isDisposed()) {
      tagsTreeViewer.refresh();
    }

  }

  public void removeCheckedStateListener(final ICheckStateListener l) {
    checkedStateListener.remove(l);
  }

  public void reset() {
    tagList.clear();
    tagsTreeViewer.refresh();
  }

  public void selectFirstItem() {
    if (!isTreeOnline() || tagsTreeViewer.getInput() == null) {
      return;
    }
    var tree = tagsTreeViewer.getTree();
    tree.select(tree.getItem(0));
  }

  public void setCheckedElementsInTree() {
    for (var checkedItem : checkedTags) {
      tagsTreeViewer.setChecked(checkedItem, true);
    }
  }

  public void setCheckedTagIds(final List<String> tagIds) {
    checkedTagIds = tagIds;
  }

  public void setCheckedTags(final List<ITag> tags) {
    checkedTags.clear();
    if (tags != null) {
      checkedTags.addAll(tags);
    }
    if (isTreeOnline()) {
      uncheckAllTags();
      setCheckedElementsInTree();
    }
  }

  /**
   * Sets a custom content provider for the tree viewer
   *
   * @param contentProvider content provider for the tree viewer
   */
  public void setContentProvider(final IContentProvider contentProvider) {
    this.contentProvider = contentProvider;
  }

  public void setFocus() {
    if (tagsTree != null && !tagsTree.isDisposed()) {
      var innerTreeControl = tagsTree.getViewer().getControl();
      if (innerTreeControl != null && !innerTreeControl.isDisposed()) {
        innerTreeControl.setFocus();
      }
    }
  }

  /**
   * Sets a custom label provider for the tree viewer
   *
   * @param labelProvider label provider for the tree viewer
   */
  public void setLabelProvider(final IStyledLabelProvider labelProvider) {
    this.labelProvider = labelProvider;
  }

  public void setTagChecked(final ITag tag, final boolean checked, final boolean includeChildren) {
    if (tag == null) {
      return;
    }

    if (checked) {
      checkedTags.add(tag);
    } else {
      checkedTags.remove(tag);
    }
    if (includeChildren) {
      setTagCheckedRecursive(tag, checked);
    }

    // update Tree
    setCheckedElementsInTree();
    refresh();
  }

  /**
   * Updates the input of tree. <br>
   * Has only effect if the tree control has already been created
   *
   * @param tags        a list of tags
   * @param asyncUpdate if {@code true} the update of the tree update will be performed
   *                    asynchronously
   */
  public void setTags(final List<ITag> tags, final boolean asyncUpdate) {
    if (isTreeOnline()) {
      tagList.clear();
      checkedTags.clear();
      if (tags != null) {
        tagList.addAll(tags);
      }
      if (asyncUpdate) {
        Display.getDefault().asyncExec(() -> {
          tagsTreeViewer.refresh();
          updateCheckedTagsFromTagIdList();
        });
      } else {
        tagsTreeViewer.refresh();
        updateCheckedTagsFromTagIdList();
      }
    }
  }

  protected void applyTreeLayoutData(final Tree tree) {
    GridDataFactory.fillDefaults().grab(true, true).hint(300, 350).applyTo(tree);
  }

  private void findAndSetTagAsChecked(final ITag tag) {
    if (checkedTagIds.contains(tag.getId())) {
      checkedTags.add(tag);
    }
    for (final ITag childTag : tag.getChildTags()) {
      findAndSetTagAsChecked(childTag);
    }
  }

  private void fireCheckedStateChanged() {
    for (var l : checkedStateListener) {
      l.checkStateChanged(null);
    }
  }

  private boolean isTreeOnline() {
    return tagsTreeViewer != null && tagsTreeViewer.getTree() != null && !tagsTreeViewer.getTree()
        .isDisposed();
  }

  private void setTagCheckedRecursive(final ITag tag, final boolean checked) {
    for (var childTag : tag.getChildTags()) {
      if (checked) {
        checkedTags.add(childTag);
      } else {
        checkedTags.remove(childTag);
      }
      setTagCheckedRecursive(childTag, checked);
    }
  }

  private void uncheckAllTags() {
    for (var currentlyChecked : tagsTreeViewer.getCheckedElements()) {
      tagsTreeViewer.setChecked(currentlyChecked, false);
    }
  }

  private void updateCheckedTagsFromTagIdList() {
    if (checkedTagIds == null || checkedTagIds.isEmpty()) {
      return;
    }
    if (tagList != null && !tagList.isEmpty()) {
      tagList.stream().forEach(this::findAndSetTagAsChecked);
      if (!checkedTags.isEmpty()) {
        setCheckedElementsInTree();
        tagsTreeViewer.refresh();
        fireCheckedStateChanged();
      }
    }
    checkedTagIds = null;
  }
}
