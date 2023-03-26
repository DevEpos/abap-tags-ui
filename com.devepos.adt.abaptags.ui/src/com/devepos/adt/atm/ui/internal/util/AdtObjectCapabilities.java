package com.devepos.adt.atm.ui.internal.util;

import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ITadirTypeConstants;
import com.devepos.adt.base.ui.adtobject.IAdtObject;

/**
 * Simple utility class to check capabilities of an ADT object for ABAP Tags specific activities
 * 
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class AdtObjectCapabilities {

  private static AdtObjectCapabilities INSTANCE;

  private AdtObjectCapabilities() {

  }

  public static AdtObjectCapabilities getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new AdtObjectCapabilities();
    }
    return INSTANCE;
  }

  /**
   * Returns {@code true} if the given Adt Object is taggable
   *
   * @param adtObject adt object to test
   * @return
   */
  public boolean isTaggable(final IAdtObject adtObject) {
    if (adtObject == null) {
      return false;
    }
    return isTypeTaggable(adtObject.getReference().getType());
  }

  /**
   * Returns {@code true} if the given ADT Object type (e.g. CLAS/OC) is a taggable type
   *
   * @param adtType adt workbench type
   */
  public boolean isTypeTaggable(final String adtType) {
    if (adtType != null) {
      if (adtType.startsWith(ITadirTypeConstants.CLASS)) {
        return adtType.equals(IAdtObjectTypeConstants.CLASS) || adtType.equals(
            IAdtObjectTypeConstants.LOCAL_CLASS) || adtType.equals(
                IAdtObjectTypeConstants.LOCAL_INTERFACE);
      }
      if (adtType.startsWith(ITadirTypeConstants.PROGRAM)) {
        return adtType.equals(IAdtObjectTypeConstants.PROGRAM) || adtType.equals(
            IAdtObjectTypeConstants.PROGRAM_INCLUDE);
      }
      if (adtType.startsWith(ITadirTypeConstants.TABLE)) {
        return adtType.equals(IAdtObjectTypeConstants.TABLE_DEFINITION_TYPE);
      } else if (adtType.startsWith(ITadirTypeConstants.FUNCTION_GROUP)) {
        return adtType.equals(IAdtObjectTypeConstants.FUNCTION_GROUP) || adtType.equals(
            IAdtObjectTypeConstants.FUNCTION_INCLUDE) || adtType.equals(
                IAdtObjectTypeConstants.FUNCTION_MODULE);
      }
      return true;
    }
    return false;
  }

  /**
   * Returns {@code true} if the given ADT Object type (e.g. CLAS/OC) is valid so the corresponding
   * object can be shown in the 'Object Tags' view
   *
   * @param adtType ADT workbench type
   */
  public boolean isTypeValidForObjectTagsView(final String adtType) {
    if (adtType != null) {
      if (adtType.startsWith(ITadirTypeConstants.CLASS)) {
        return adtType.equals(IAdtObjectTypeConstants.CLASS);
      }
      if (adtType.startsWith(ITadirTypeConstants.PROGRAM)) {
        return adtType.equals(IAdtObjectTypeConstants.PROGRAM) || adtType.equals(
            IAdtObjectTypeConstants.PROGRAM_INCLUDE);
      }
      if (adtType.startsWith(ITadirTypeConstants.TABLE)) {
        return adtType.equals(IAdtObjectTypeConstants.TABLE_DEFINITION_TYPE);
      } else if (adtType.startsWith(ITadirTypeConstants.FUNCTION_GROUP)) {
        return adtType.equals(IAdtObjectTypeConstants.FUNCTION_GROUP) || adtType.equals(
            IAdtObjectTypeConstants.FUNCTION_INCLUDE) || adtType.equals(
                IAdtObjectTypeConstants.FUNCTION_MODULE);
      }
      return true;
    }
    return false;
  }

  public boolean isValidForObjectTagsView(final IAdtObject adtObject) {
    if (adtObject == null) {
      return false;
    }
    return isTypeValidForObjectTagsView(adtObject.getReference().getType());
  }
}
