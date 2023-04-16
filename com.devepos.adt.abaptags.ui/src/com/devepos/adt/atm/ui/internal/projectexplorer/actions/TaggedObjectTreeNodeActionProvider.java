package com.devepos.adt.atm.ui.internal.projectexplorer.actions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.actions.SelectionListenerAction;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.action.CollapseTreeNodesAction;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ILazyLoadingNode;
import com.devepos.adt.base.ui.tree.ITreeNode;

/**
 *
 * Action provider for Tree Nodes in the Tagged Object Tree
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class TaggedObjectTreeNodeActionProvider extends CommonActionProvider {
  private final static Object[] EMPTY_ARRAY = new Object[0];

  public TaggedObjectTreeNodeActionProvider() {
    super();
  }

  private class RefreshFolderAction extends SelectionListenerAction {

    private final List<ILazyLoadingNode> lazyLoadableNodes;
    private final StructuredViewer viewer;

    public RefreshFolderAction(final List<ILazyLoadingNode> lazyLoadableNodes,
        final StructuredViewer viewer) {
      super(Messages.TaggedObjectTreeNodeActionProvider_RefreshAction_xmit);
      this.lazyLoadableNodes = lazyLoadableNodes;
      this.viewer = viewer;
      setActionDefinitionId(IWorkbenchCommandConstants.FILE_REFRESH);
      setImageDescriptor(AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.REFRESH));
    }

    @Override
    public void run() {
      if (lazyLoadableNodes == null || lazyLoadableNodes.isEmpty()) {
        return;
      }

      for (var node : lazyLoadableNodes) {
        // CHECK: skip child node if parent is also refreshed?
        node.resetLoadedState();
        viewer.refresh(node);
      }
    }

  }

  @Override
  public void fillActionBars(final IActionBars actionBars) {
    super.fillActionBars(actionBars);
    var selection = getSelection();
    var relevantSelectedNodes = getRelevantNodesFromSelection(selection);

    if (relevantSelectedNodes != null && !relevantSelectedNodes.isEmpty()) {
      actionBars.setGlobalActionHandler(IWorkbenchCommandConstants.FILE_REFRESH,
          new RefreshFolderAction(relevantSelectedNodes, getActionSite().getStructuredViewer()));
    }
  }

  @Override
  public void fillContextMenu(final IMenuManager menu) {
    super.fillContextMenu(menu);
    var selection = getSelection();

    // check if selected nodes support collapsing
    addCollapseAction(menu);

    boolean tagSelected = isTagNodeSelected(selection);

    // delete menu groups if at least one tag node is selected
    if (tagSelected) {
      deleteUnusedMenuGroups(menu);
    } else if (Stream.of(selection).anyMatch(o -> o instanceof IAdtObjectReferenceNode)) {
      menu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, new RemoveAssignedTagsAction(this
          .getActionSite()));
      menu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, new Separator());
    }

    var relevantSelectedNodes = getRelevantNodesFromSelection(selection);
    if (relevantSelectedNodes != null && !relevantSelectedNodes.isEmpty()) {
      if (tagSelected) {
        menu.add(new Separator());
        menu.add(new RefreshFolderAction(relevantSelectedNodes, getActionSite()
            .getStructuredViewer()));
      } else {
        menu.appendToGroup(ICommonMenuConstants.GROUP_BUILD, new RefreshFolderAction(
            relevantSelectedNodes, getActionSite().getStructuredViewer()));
      }
    }

  }

  private void addCollapseAction(final IMenuManager menu) {
    var treeViewer = (TreeViewer) getActionSite().getStructuredViewer();

    for (var selObj : treeViewer.getStructuredSelection()) {
      if (treeViewer.getExpandedState(selObj)) {
        menu.appendToGroup(ICommonMenuConstants.GROUP_REORGANIZE, new CollapseTreeNodesAction(
            treeViewer));
        break;
      }
    }
  }

  private void deleteUnusedMenuGroups(final IMenuManager menu) {
    IContributionItem[] items = menu.getItems();
    if (items == null || items.length == 0) {
      return;
    }

    for (var item : items) {
      if (item instanceof Separator) {
        menu.remove(item);
      }
    }
  }

  private List<ILazyLoadingNode> getRelevantNodesFromSelection(final Object[] selection) {
    return Stream.of(selection)
        .filter(ILazyLoadingNode.class::isInstance)
        .map(ILazyLoadingNode.class::cast)
        .collect(Collectors.toList());
  }

  private Object[] getSelection() {
    var selection = (IStructuredSelection) getContext().getSelection();
    if (selection == null || selection.isEmpty()) {
      return EMPTY_ARRAY;
    }

    return selection.toArray();
  }

  private boolean isTagNodeSelected(final Object[] selection) {
    return Stream.of(selection).anyMatch(node -> {
      if (node instanceof ITreeNode && ((ITreeNode) node).getParent() == null) {
        return true;
      }
      if (node instanceof IAdaptable) {
        var tag = ((IAdaptable) node).getAdapter(ITag.class);
        return tag != null;
      }
      return false;
    });
  }
}
