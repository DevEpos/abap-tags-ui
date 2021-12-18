package com.devepos.adt.atm.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.atm.ui.internal.wizard.TagObjectsWizard;
import com.devepos.adt.base.ui.project.ProjectUtil;

public class AddTagsToObjectsHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final TagObjectsWizard wizard = new TagObjectsWizard();
    final IProject project = ProjectUtil.getCurrentAbapProject();
    wizard.setProject(project);
    final WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShell(event), wizard);
    dialog.open();
    return null;
  }

}
