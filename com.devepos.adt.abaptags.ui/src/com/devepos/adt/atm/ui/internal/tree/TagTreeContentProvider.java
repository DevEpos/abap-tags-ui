package com.devepos.adt.atm.ui.internal.tree;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.base.util.StringUtil;

public class TagTreeContentProvider implements ITreeContentProvider {

  private TagSearchScope visibleTagScope = TagSearchScope.ALL;

  public void setVisbleTagScope(final TagSearchScope scope) {
    visibleTagScope = scope;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Object[] getElements(final Object inputElement) {
    List<ITag> tagList = null;
    if (inputElement instanceof EList<?>) {
      tagList = (EList<ITag>) inputElement;
    } else if (inputElement instanceof ITagList) {
      tagList = ((ITagList) inputElement).getTags();
    }
    if (tagList != null) {
      if (visibleTagScope == TagSearchScope.ALL || visibleTagScope == null) {
        return tagList.toArray();
      }
      final List<ITag> filteredList = tagList.stream().filter(t -> {
        switch (visibleTagScope) {
        case GLOBAL:
          return StringUtil.isEmpty(t.getOwner());
        case USER:
          return !t.isSharedForMe() && !StringUtil.isEmpty(t.getOwner());
        case SHARED:
          return t.isSharedForMe();
        default:
          return false;
        }
      }).collect(Collectors.toList());
      if (filteredList != null && filteredList.size() > 0) {
        return filteredList.toArray();
      }
    }

    return new Object[0];
  }

  @Override
  public Object[] getChildren(final Object parentElement) {
    if (parentElement instanceof ITag) {
      return ((ITag) parentElement).getChildTags().toArray();
    }
    return null;
  }

  @Override
  public Object getParent(final Object element) {
    if (!(element instanceof ITag)) {
      return null;
    }
    final ITag tag = (ITag) element;
    final EObject container = tag.eContainer();
    if (container == null || container instanceof ITagList) {
      return null;
    }
    if (container instanceof ITag) {
      return container;
    }
    return null;
  }

  @Override
  public boolean hasChildren(final Object element) {
    if (element instanceof ITag) {
      final ITag tag = (ITag) element;
      return tag.getChildTags().size() > 0;
    }
    return false;
  }

}