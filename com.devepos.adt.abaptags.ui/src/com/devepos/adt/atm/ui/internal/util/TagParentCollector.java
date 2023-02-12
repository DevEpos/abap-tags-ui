package com.devepos.adt.atm.ui.internal.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.atm.model.abaptags.ITag;

/**
 * Class for collecting parents of Tags
 * 
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class TagParentCollector {

  public static List<String> collectParentTagIds(final ITag startingTag) {
    ITag parent = startingTag;
    List<String> parentTagIds = new ArrayList<>();

    while (parent != null) {
      parentTagIds.add(parent.getId());

      EObject container = parent.eContainer();
      if ((container == null) || !(container instanceof ITag)) {
        break;
      }
      parent = (ITag) container;
    }
    return parentTagIds;
  }
}
