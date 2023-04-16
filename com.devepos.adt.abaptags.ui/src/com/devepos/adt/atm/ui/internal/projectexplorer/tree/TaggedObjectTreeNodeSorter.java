package com.devepos.adt.atm.ui.internal.projectexplorer.tree;

import java.util.Comparator;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.ui.internal.util.ITaggedObjectPropertyNameConstants;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.util.StringUtil;

public class TaggedObjectTreeNodeSorter extends ViewerComparator {

  public TaggedObjectTreeNodeSorter() {
  }

  public TaggedObjectTreeNodeSorter(final Comparator<? super String> comparator) {
    super(comparator);
  }

  @Override
  public int category(final Object element) {
    if (element instanceof IAdtObjectReferenceNode) {
      return -5;
    }
    if (element instanceof ICollectionTreeNode) {
      var tag = ((ICollectionTreeNode) element).getAdapter(ITag.class);
      if (tag != null) {
        if (StringUtil.isEmpty(tag.getOwner())) {
          return -2;
        } else if (tag.isSharedForMe()) {
          return -3;
        } else {
          return -4;
        }
      }
      return -1;
    }
    return super.category(element);
  }

  @Override
  public int compare(final Viewer viewer, final Object e1, final Object e2) {
    int cat1 = category(e1);
    int cat2 = category(e2);

    if (cat1 != cat2) {
      return cat1 - cat2;
    }

    String name1 = getLabel(e1);
    String name2 = getLabel(e2);

    // use the comparator to compare the strings
    return getComparator().compare(name1, name2);
  }

  private String getLabel(final Object o1) {
    if (o1 instanceof IAdtObjectReferenceNode) {
      var objRefNode = (IAdtObjectReferenceNode) o1;
      var parentObjName = objRefNode.getPropertyValue(
          ITaggedObjectPropertyNameConstants.ADT_OBJECT_PARENT_NAME);
      var label = objRefNode.getAdtObjectType() + objRefNode.getName();
      return parentObjName != null ? label + parentObjName : label;
    }
    if (o1 instanceof ITreeNode) {
      return ((ITreeNode) o1).getDisplayName();
    }
    return null;
  }

}
