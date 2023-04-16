package com.devepos.adt.atm.ui.internal.projectexplorer.actions;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.SelectionListenerAction;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.util.AdtUIUtil;
import com.sap.adt.project.IProjectProvider;

public class AdtObjectRefOpenActionProvider extends CommonActionProvider {

  private SelectionListenerAction openAction;

  @Override
  public void fillActionBars(final IActionBars actionBars) {
    super.fillActionBars(actionBars);
    IStructuredSelection selection = getSelection();
    if (selection != null) {
      initOpenAction();
      openAction.selectionChanged(selection);
      actionBars.setGlobalActionHandler("org.eclipse.ui.navigator.Open", openAction);
    }

  }

  protected IStructuredSelection getSelection() {
    return (IStructuredSelection) getContext().getSelection();
  }

  @Override
  public void fillContextMenu(final IMenuManager menu) {
    super.fillContextMenu(menu);

    IStructuredSelection selection = getSelection();
    if (selection != null) {
      initOpenAction();
      openAction.selectionChanged(selection);
      menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, openAction);
    }
  }

  private void initOpenAction() {

    if (openAction == null) {
      openAction = new SelectionListenerAction(
          Messages.AdtObjectRefOpenActionProvider_OpenAction_xmit) {

        @Override
        public void run() {
          var selectedObjects = getStructuredSelection().toArray();

          for (var selObj : selectedObjects) {
            if (selObj instanceof IAdtObjectReferenceNode) {
              var adtObjRefNode = (IAdtObjectReferenceNode) selObj;
              var projectProvider = adtObjRefNode.getAdapter(IProjectProvider.class);
              AdtUIUtil.navigateWithObjectReference(adtObjRefNode.getObjectReference(),
                  projectProvider.getProject());
            }
          }
        }
      };
    }
  }
}
