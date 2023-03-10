package com.devepos.adt.atm.ui.internal.tree;

import java.util.Comparator;

import org.eclipse.jface.viewers.ViewerComparator;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.util.StringUtil;

public class TaggedObjectTreeNodeSorter extends ViewerComparator {

  public TaggedObjectTreeNodeSorter() {
  }

  public TaggedObjectTreeNodeSorter(Comparator<? super String> comparator) {
    super(comparator);
  }

  @Override
  public int category(Object element) {
    if (element instanceof IAdtObjectReferenceNode) {
      return -5;
    } else if (element instanceof ICollectionTreeNode) {
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

}
