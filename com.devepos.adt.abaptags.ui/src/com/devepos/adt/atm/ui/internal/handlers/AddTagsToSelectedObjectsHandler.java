package com.devepos.adt.atm.ui.internal.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.atm.ui.internal.wizard.TagObjectsWizard;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.base.ui.util.AdtUIUtil;

public class AddTagsToSelectedObjectsHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final List<IAdtObject> selectedObjects = AdtUIUtil.getAdtObjectsFromSelection(false);
    if (selectedObjects == null || selectedObjects.isEmpty()) {
      return null;
    }

    final IProject project = selectedObjects.get(0).getProject();
    final IAdtObjRefList adtObjRefList = IAdtBaseFactory.eINSTANCE.createAdtObjRefList();

    for (final IAdtObject adtObj : selectedObjects) {
      final IAdtObjRef adtObjRef = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
      adtObjRef.setUri(adtObj.getReference().getUri());
      adtObjRef.setName(adtObj.getName());
      adtObjRef.setType(adtObj.getReference().getType());
      adtObjRefList.getObjectReferences().add(adtObjRef);
    }

    final TagObjectsWizard wizard = new TagObjectsWizard(true);
    wizard.setProject(project);
    wizard.setSelectedObjects(adtObjRefList);
    final WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShell(event), wizard);
    dialog.open();
    return null;
  }
}
