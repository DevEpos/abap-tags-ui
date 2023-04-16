package com.devepos.adt.atm.ui.internal.projectexplorer.actions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.actions.SelectionListenerAction;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.util.ITaggedObjectPropertyNameConstants;
import com.devepos.adt.atm.ui.internal.wizard.taggedobjectsdeletion.DeleteTaggedObjectsWizard;
import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ILazyLoadingNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.sap.adt.project.IProjectProvider;

/**
 * Action to remove a certain tag from a list of selected Tagged Objects in the Tagged Object Tree
 * in the Project Explorer View
 * 
 * @author Ludwig Stockbauer-Muhr
 *
 */
class RemoveAssignedTagsAction extends SelectionListenerAction {
  private final StructuredViewer viewer;
  private ICommonActionExtensionSite actionSite;

  public RemoveAssignedTagsAction(ICommonActionExtensionSite actionSite) {
    super(Messages.TaggedObjectTreeNodeActionProvider_RefreshAction_xmit);
    this.actionSite = actionSite;
    viewer = actionSite.getStructuredViewer();
    setText(Messages.RemoveAssignedTagsAction_ActionName_xlbl);
    setImageDescriptor(AbapTagsUIPlugin.getDefault()
        .getImageDescriptor(IImages.REMOVE_ASSIGNED_TAGS));
  }

  @Override
  public void run() {
    var wizard = new DeleteTaggedObjectsWizard();
    var nodesToUpdate = new HashSet<ILazyLoadingNode>();
    var listRequest = wizard.getTaggedObjectListRequest();
    boolean isFirstIteration = true;
    for (var selObj : viewer.getStructuredSelection()) {
      if (selObj instanceof IAdtObjectReferenceNode) {
        var objRefNode = (IAdtObjectReferenceNode) selObj;
        if (isFirstIteration) {
          isFirstIteration = false;
          wizard.setProject(objRefNode.getAdapter(IProjectProvider.class).getProject());
        }
        addTaggedObjectInfo(objRefNode, listRequest.getTaggedObjectInfos(), nodesToUpdate);
      }
    }

    var wizardDialog = new WizardDialog(actionSite.getViewSite().getShell(), wizard);
    wizardDialog.open();
    if (wizard.hasDeletionOccurred()) {
      for (var nodeToUpdate : nodesToUpdate) {
        nodeToUpdate.resetLoadedState();
        viewer.refresh(nodeToUpdate);
      }
    }
  }

  private void addTaggedObjectInfo(final IAdtObjectReferenceNode objRefNode,
      final List<ITaggedObjectInfo> objectInfos, final Set<ILazyLoadingNode> nodesToUpdate) {
    var taggedObjectInfo = IAbapTagsFactory.eINSTANCE.createTaggedObjectInfo();

    var parentName = objRefNode.getPropertyValue(
        ITaggedObjectPropertyNameConstants.ADT_OBJECT_PARENT_NAME);
    if (parentName != null) {
      taggedObjectInfo.setComponentName(objRefNode.getName());
      taggedObjectInfo.setComponentType(objRefNode.getAdtObjectType());
      taggedObjectInfo.setObjectType(IAdtObjectTypeConstants.CLASS);
      taggedObjectInfo.setObjectName(parentName);
    } else {
      taggedObjectInfo.setObjectName(objRefNode.getName());
      taggedObjectInfo.setObjectType(objRefNode.getAdtObjectType());
    }

    boolean containingNodeAdded = false;

    var parentNode = objRefNode.getParent();
    if (parentNode != null) {
      var tag = parentNode.getAdapter(ITag.class);
      if (tag != null) {
        taggedObjectInfo.setTagId(tag.getId());
      }

      containingNodeAdded = markNodeForUpdate(nodesToUpdate, containingNodeAdded, parentNode);

      var tagParent = parentNode.getParent();
      if (tagParent != null) {
        if (tagParent instanceof IAdtObjectReferenceNode) {
          var parentAdtObjRefNode = (IAdtObjectReferenceNode) tagParent;
          taggedObjectInfo.setParentObjectType(parentAdtObjRefNode.getAdtObjectType());
          taggedObjectInfo.setParentObjectName(parentAdtObjRefNode.getName());

          var parentObjectTag = tagParent.getParent();
          if (parentObjectTag != null) {
            var parentTag = parentObjectTag.getAdapter(ITag.class);
            if (parentTag != null) {
              taggedObjectInfo.setParentTagId(parentTag.getId());
            }
            markNodeForUpdate(nodesToUpdate, containingNodeAdded, parentObjectTag);
          }
        }
        markNodeForUpdate(nodesToUpdate, containingNodeAdded, tagParent);
      }
    }
    objectInfos.add(taggedObjectInfo);
  }

  private boolean markNodeForUpdate(final Set<ILazyLoadingNode> nodesToUpdate,
      final boolean containingNodeAdded, final ITreeNode node) {
    if (!containingNodeAdded && node instanceof ILazyLoadingNode) {
      var parent = node.getParent();
      if (parent == null || !nodesToUpdate.contains(parent)) {
        nodesToUpdate.add((ILazyLoadingNode) node);
        return true;
      }
    }
    return false;
  }
}