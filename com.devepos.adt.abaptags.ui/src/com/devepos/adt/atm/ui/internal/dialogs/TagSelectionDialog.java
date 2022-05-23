package com.devepos.adt.atm.ui.internal.dialogs;

import java.util.List;
import java.util.Set;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.tree.TagSelectionTree;

/**
 * Dialog for selecting tags.<br>
 * This class provides no capability to load the tags on its own, so they have to be passed in the
 * constructor
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class TagSelectionDialog extends TrayDialog {

  private TagSelectionTree tagsTree;
  private List<ITag> tags;

  /**
   * Creates new instance of a tag selection dialog
   *
   * @param shell  the parent shell
   * @param tagIds list of tag ids to configure which of the <code>tags</code> shall be initially
   *               checked
   * @param tags   list of tags that shall be displayed in a tree control
   */
  public TagSelectionDialog(final Shell shell, final List<String> tagIds, final List<ITag> tags) {
    super(shell);
    tagsTree = new TagSelectionTree();
    tagsTree.setSelectedTags(tagIds);
    this.tags = tags;
  }

  @Override
  protected void configureShell(final Shell shell) {
    super.configureShell(shell);
    shell.setText(Messages.TagSearchParameterSection_selectTags_xbtn);
  }

  @Override
  protected boolean isResizable() {
    return true;
  }

  @Override
  protected Control createDialogArea(final Composite parent) {
    final Composite dialogArea = (Composite) super.createDialogArea(parent);
    tagsTree.createControl(dialogArea);
    tagsTree.setTags(tags, false);
    return dialogArea;
  }

  /**
   * Retrieves a set of all selected (checked) tags
   *
   * @return a set of all selected (checked) tags
   */
  public Set<ITag> getSelectedTags() {
    return tagsTree.getSelectedTags();
  }

}
