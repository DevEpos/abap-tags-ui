package com.devepos.adt.atm.ui.internal.propertytester;

import org.eclipse.core.expressions.PropertyTester;

import com.devepos.adt.atm.ui.internal.util.AdtObjectCapabilities;
import com.devepos.adt.base.ui.adtobject.IAdtObject;

public class AdtObjectPropertyTester extends PropertyTester {

  private static final String IS_TAGGABLE = "isTaggable";

  public AdtObjectPropertyTester() {
  }

  @Override
  public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
    if (!(receiver instanceof IAdtObject)) {
      return false;
    }
    var adtObj = (IAdtObject) receiver;
    if (property.equals(IS_TAGGABLE)) {
      return AdtObjectCapabilities.getInstance().isTaggable(adtObj);
    }
    return false;
  }

}
