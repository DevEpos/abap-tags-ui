package com.devepos.adt.atm.ui.internal.projectexplorer.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.actions.SelectionListenerAction;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.action.CollapseTreeNodesAction;
import com.devepos.adt.base.ui.tree.ILazyLoadingNode;

/**
 *
 * Action provider for Tree Nodes in the Tagged Object Tree
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class TaggedObjectTreeNodeActionProvider extends CommonActionProvider {

  private List<String> unusedMenuGroups;

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
      super.run();

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
    var relevantSelectedNodes = getRelevantNodesFromSelection();

    if (relevantSelectedNodes != null && !relevantSelectedNodes.isEmpty()) {
      actionBars.setGlobalActionHandler(IWorkbenchCommandConstants.FILE_REFRESH,
          new RefreshFolderAction(relevantSelectedNodes, getActionSite().getStructuredViewer()));
    }
  }

  @Override
  public void fillContextMenu(final IMenuManager menu) {
    super.fillContextMenu(menu);

    // check if selected nodes support collapsing
    addCollapseAction(menu);

    var relevantSelectedNodes = getRelevantNodesFromSelection();
    if (relevantSelectedNodes == null || relevantSelectedNodes.isEmpty()) {
      return;
    }

    menu.appendToGroup(ICommonMenuConstants.GROUP_BUILD, new RefreshFolderAction(
        relevantSelectedNodes, getActionSite().getStructuredViewer()));

    deleteUnusedMenuGroups(menu);
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

    var groupsToDelete = fetchMenuGroupsForDeletion();
    if (groupsToDelete == null || groupsToDelete.isEmpty()) {
      return;
    }

    for (IContributionItem item : items) {
      String id = item.getId();
      if (id == null) {
        continue;
      }
      if (groupsToDelete.contains(id)) {
        menu.remove(item);
      }
    }
  }

  private List<String> fetchMenuGroupsForDeletion() {
    if (unusedMenuGroups == null) {
      unusedMenuGroups = new ArrayList<>(Arrays.asList(IContextMenuConstants.GROUP_GENERATE,
          IContextMenuConstants.GROUP_SEARCH, IContextMenuConstants.GROUP_BUILD,
          IContextMenuConstants.GROUP_GOTO, IWorkbenchActionConstants.MB_ADDITIONS,
          IContextMenuConstants.GROUP_VIEWER_SETUP, IContextMenuConstants.GROUP_PROPERTIES));
    }
    return unusedMenuGroups;
  }

  private List<ILazyLoadingNode> getRelevantNodesFromSelection() {
    var selection = (IStructuredSelection) getContext().getSelection();
    if (selection == null || selection.isEmpty()) {
      return null;
    }

    return Stream.of(selection.toArray())
        .filter(ILazyLoadingNode.class::isInstance)
        .map(ILazyLoadingNode.class::cast)
        .collect(Collectors.toList());
  }
}
