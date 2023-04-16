package com.devepos.adt.atm.ui.internal.wizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import com.devepos.adt.base.ui.wizard.IBaseWizardPage;

/**
 * Base class for wizards
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public abstract class AbstractWizardBase extends Wizard {

  private IProject project;
  private boolean canFinish;

  @Override
  public boolean canFinish() {
    return canFinish;
  }

  public void completePreviousPage(final IBaseWizardPage page) {
    final IWizardPage prev = page.getPreviousPage();
    if (prev == null || !(prev instanceof IBaseWizardPage)) {
      return;
    }
    final IBaseWizardPage previousPage = (IBaseWizardPage) prev;

    if (previousPage.isDirty()) {
      previousPage.completePage();
    }
  }

  public IProject getProject() {
    return project;
  }

  public boolean isPreviousPageDirty(final IBaseWizardPage page) {
    final IWizardPage prev = page.getPreviousPage();
    if (prev == null || !(prev instanceof IBaseWizardPage)) {
      return false;
    }
    return ((IBaseWizardPage) prev).isDirty();
  }

  public void setCanFinish(final boolean canFinish) {
    this.canFinish = canFinish;
  }

  public void setProject(final IProject project) {
    this.project = project;
  }
}
