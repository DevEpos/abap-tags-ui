package com.devepos.adt.atm.ui.internal.propertytester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;

import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.base.ui.adtobject.IAdtObject;

public class FeatureTester extends PropertyTester {

  private static final String TAGS_FEATURE = "abaptagsAvailable"; //$NON-NLS-1$

  public FeatureTester() {
  }

  @Override
  public boolean test(final Object receiver, final String property, final Object[] args,
      final Object expectedValue) {
    if (!(receiver instanceof IAdtObject)) {
      return false;
    }
    final IAdtObject rec = (IAdtObject) receiver;
    if (property.equals(TAGS_FEATURE)) {
      final IProject proj = rec.getProject();
      if (proj == null) {
        return false;
      }
      return AbapTagsServiceFactory.createTagsService().testTagsFeatureAvailability(proj).isOK();
    }
    return false;
  }

}
