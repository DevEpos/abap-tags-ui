package com.devepos.adt.atm.ui.internal.wizard;

import org.eclipse.core.resources.IProject;

public interface IBaseWizard {
  /**
   * Returns the current project
   *
   * @return the current project
   */
  IProject getProject();

  /**
   * Sets the current project of the wizard
   *
   * @param project the project to be set in the wizard
   */
  void setProject(IProject project);
}
