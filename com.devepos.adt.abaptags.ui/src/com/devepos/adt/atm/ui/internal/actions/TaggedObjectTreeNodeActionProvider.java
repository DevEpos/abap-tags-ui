package com.devepos.adt.atm.ui.internal.actions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.actions.SelectionListenerAction;
import org.eclipse.ui.navigator.CommonActionProvider;

import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.tree.ILazyLoadingNode;

/**
 *
 * Action provider for Tree Nodes in the Tagged Object Tree
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class TaggedObjectTreeNodeActionProvider extends CommonActionProvider {

  public TaggedObjectTreeNodeActionProvider() {
    super();
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

    var relevantSelectedNodes = getRelevantNodesFromSelection();
    if (relevantSelectedNodes != null && !relevantSelectedNodes.isEmpty()) {
      menu.appendToGroup("group.build", new RefreshFolderAction(relevantSelectedNodes,
          getActionSite().getStructuredViewer()));
    }
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

  private class RefreshFolderAction extends SelectionListenerAction {

    private final List<ILazyLoadingNode> lazyLoadableNodes;
    private final StructuredViewer viewer;

    public RefreshFolderAction(final List<ILazyLoadingNode> lazyLoadableNodes,
        final StructuredViewer viewer) {
      super("Refresh");
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
}
