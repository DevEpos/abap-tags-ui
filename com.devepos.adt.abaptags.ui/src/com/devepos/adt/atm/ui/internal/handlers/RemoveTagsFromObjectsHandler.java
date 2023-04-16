package com.devepos.adt.atm.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.atm.ui.internal.wizard.taggedobjectsdeletion.DeleteTaggedObjectsWizard;
import com.devepos.adt.base.ui.project.ProjectUtil;

/**
 * Command handler to open the Wizard which allows the guided removal of Tags from repository
 * objects
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class RemoveTagsFromObjectsHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final var wizard = new DeleteTaggedObjectsWizard();
    final var project = ProjectUtil.getCurrentAbapProject();
    wizard.setProject(project);
    final var dialog = new WizardDialog(HandlerUtil.getActiveShell(event), wizard);
    dialog.open();
    return null;
  }

}
