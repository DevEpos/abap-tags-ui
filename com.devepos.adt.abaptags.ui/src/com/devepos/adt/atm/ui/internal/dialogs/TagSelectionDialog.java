package com.devepos.adt.atm.ui.internal.dialogs;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.util.List;
import java.util.Set;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.tree.TagSelectionTree;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;

/**
 * Dialog for selecting tags.<br>
 * This class provides no capability to load the tags on its own, so they have to be passed in the
 * constructor
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class TagSelectionDialog extends TrayDialog {

  private final TagSelectionTree tagsTree;
  private final List<ITag> tags;
  private ToolBar treeToolBar;

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
    tagsTree.setCheckedTagIds(tagIds);
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
    tagsTree.addKeyListenerForFilterFocus();
    createTagsToolbar(tagsTree.getTreeFilterComposite());
    tagsTree.setTags(tags, false);
    return dialogArea;
  }

  private void createTagsToolbar(final Composite parent) {
    treeToolBar = new ToolBar(parent, SWT.FLAT | SWT.HORIZONTAL);
    GridDataFactory.fillDefaults().align(SWT.END, SWT.END).applyTo(treeToolBar);

    var expandAll = new ToolItem(treeToolBar, SWT.PUSH);
    expandAll.setToolTipText(Messages.TagSelectionWizardPage_ExpandAll_xbut);
    expandAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.EXPAND_ALL));
    expandAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagsTree.expandAll();

    }));

    final var collapseAll = new ToolItem(treeToolBar, SWT.PUSH);
    collapseAll.setToolTipText(Messages.TagSelectionWizardPage_CollapseAll_xbut);
    collapseAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.COLLAPSE_ALL));
    collapseAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagsTree.collapseAll();
    }));

    new ToolItem(treeToolBar, SWT.SEPARATOR);

    final var uncheckAll = new ToolItem(treeToolBar, SWT.PUSH);
    uncheckAll.setToolTipText(AdtBaseUIResources.getString(IAdtBaseStrings.UncheckAll_xlbl));

    uncheckAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.UNCHECK_ALL));
    uncheckAll.addSelectionListener(widgetSelectedAdapter(l -> {
      tagsTree.setCheckedTags(null);
    }));
  }

  /**
   * Retrieves a set of all selected (checked) tags
   *
   * @return a set of all selected (checked) tags
   */
  public Set<ITag> getSelectedTags() {
    return tagsTree.getCheckedTags();
  }

}
