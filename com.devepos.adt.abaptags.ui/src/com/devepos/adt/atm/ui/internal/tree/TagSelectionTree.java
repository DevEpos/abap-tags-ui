package com.devepos.adt.atm.ui.internal.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.tree.FilterableTree;

/**
 * Tree control for loading, displaying and selecting ABAP Tags that exist in a certain ABAP project
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class TagSelectionTree {
  private CheckboxTreeViewer tagsTreeViewer;
  private List<ITag> tagList = new ArrayList<>();
  private FilterableTree tagsTree;
  private final Set<ITag> checkedTags;
  private final TagFilter patternFilter;
  private List<String> previouslyCheckedTagIds;
  private Set<ISelectionChangedListener> selectionChangeListeners = new HashSet<>();

  public TagSelectionTree() {
    checkedTags = new HashSet<>();
    patternFilter = new TagFilter();
  }

  public void addSelectionChangeListener(final ISelectionChangedListener l) {
    selectionChangeListeners.add(l);
  }

  public void createControl(final Composite parent) {
    tagsTree = new FilterableTree(parent, Messages.TaggedObjectSearchPage_TagsTreeFilterText_xmsg,
        false) {
      @Override
      protected void filterJobCompleted() {
        super.filterJobCompleted();
        setCheckedElements();
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
    tagsTree.setExpandAllOnFilterEmpty(false);

    tagsTreeViewer.addFilter(patternFilter);
    tagsTreeViewer.setContentProvider(new TagTreeContentProvider());
    tagsTreeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new TagLabelProvider(true,
        false)));
    tagsTreeViewer.setInput(tagList);
    tagsTree.setBackgroundMode(SWT.INHERIT_DEFAULT);
    GridDataFactory.fillDefaults().grab(true, true).hint(300, 350).applyTo(tagsTree);

    tagsTreeViewer.addCheckStateListener(e -> {
      if (e.getChecked()) {
        checkedTags.add((ITag) e.getElement());
      } else {
        checkedTags.remove(e.getElement());
      }
      fireSelectionChanged();
    });
  }

  public Set<ITag> getSelectedTags() {
    return checkedTags;
  }

  public boolean hasSelection() {
    return !checkedTags.isEmpty();
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
    if (tagsTree != null && !tagsTree.isDisposed()) {
      tagList.clear();
      tagList.addAll(tags);
      if (asyncUpdate) {
        Display.getDefault().asyncExec(() -> {
          tagsTreeViewer.refresh();
          determineCheckedTagsFromPreviousSearch();
        });
      } else {
        tagsTreeViewer.refresh();
        determineCheckedTagsFromPreviousSearch();
      }
    }
  }

  public void removeSelectionChangeListener(final ISelectionChangedListener l) {
    selectionChangeListeners.remove(l);
  }

  public void reset() {
    tagList.clear();
    tagsTreeViewer.refresh();
  }

  public void setFocus() {
    if (tagsTree != null && !tagsTree.isDisposed()) {
      tagsTree.setFocus();
    }
  }

  public void setSelectedTags(final List<String> tagIds) {
    previouslyCheckedTagIds = tagIds;
  }

  private void determineCheckedTagsFromPreviousSearch() {
    if (previouslyCheckedTagIds == null || previouslyCheckedTagIds.isEmpty()) {
      return;
    }
    if (tagList != null && !tagList.isEmpty()) {
      tagList.stream().forEach(this::findAndSetTagAsChecked);
      if (!checkedTags.isEmpty()) {
        setCheckedElements();
        tagsTreeViewer.refresh();
        fireSelectionChanged();
      }
    }
    previouslyCheckedTagIds = null;
  }

  private void findAndSetTagAsChecked(final ITag tag) {
    if (previouslyCheckedTagIds.contains(tag.getId())) {
      checkedTags.add(tag);
    }
    for (final ITag childTag : tag.getChildTags()) {
      findAndSetTagAsChecked(childTag);
    }
  }

  private void fireSelectionChanged() {
    for (ISelectionChangedListener l : selectionChangeListeners) {
      l.selectionChanged(null);
    }
  }

  private void setCheckedElements() {
    for (final Object checkedItem : checkedTags) {
      tagsTreeViewer.setChecked(checkedItem, true);
    }
  }
}
