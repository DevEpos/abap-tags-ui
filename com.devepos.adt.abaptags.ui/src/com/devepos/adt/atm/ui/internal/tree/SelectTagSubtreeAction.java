package com.devepos.adt.atm.ui.internal.tree;

import java.util.stream.Stream;

import org.eclipse.jface.action.Action;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;

/**
 * Action which will select all the sub tree nodes of a tag object of the contained
 * {@link TagSelectionTree} instance.
 * 
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class SelectTagSubtreeAction extends Action {

  private final TagSelectionTree tagTree;
  private IPostRunHandler postRun;

  public SelectTagSubtreeAction(final TagSelectionTree tagSelectTree) {
    super(Messages.TagSelectionWizardPage_SelectSubTreeAction_xmit, AdtBaseUIResources
        .getImageDescriptor(IAdtBaseImages.CHECK));
    tagTree = tagSelectTree;
  }

  public interface IPostRunHandler {
    void run();
  }

  /**
   * Returns {@code true} if the viewer selection contains only tag objects that have child tags
   */
  public boolean hasTreeValidSelectionForAction() {
    var selection = tagTree.getViewerSelection();

    return Stream.of(selection.toArray()).allMatch(selObj -> {
      if (selObj instanceof ITag) {
        return !((ITag) selObj).getChildTags().isEmpty();
      }
      return false;
    });
  }

  @Override
  public void run() {
    var selectedTags = tagTree.getViewerSelection();
    for (var selObj : selectedTags.toArray()) {
      var selTag = (ITag) selObj;
      if (!selTag.getChildTags().isEmpty()) {
        tagTree.setTagChecked(selTag, true, true);
      }
    }

    if (postRun != null) {
      postRun.run();
    }
  }

  /**
   * Sets a runner which will be executed after a successful {@link Action#run()} call of the action
   * 
   * @param postRun the post runner to be used
   */
  public void setPostRunHandler(final IPostRunHandler postRun) {
    this.postRun = postRun;
  }
}
