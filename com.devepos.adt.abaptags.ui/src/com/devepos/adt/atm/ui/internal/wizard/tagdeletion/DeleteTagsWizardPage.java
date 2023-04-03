package com.devepos.adt.atm.ui.internal.wizard.tagdeletion;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject;
import com.devepos.adt.atm.model.abaptags.ITagDeletionCheckResult;
import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.ui.internal.ImageUtil;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.wizard.AbstractBaseWizardPage;

public class DeleteTagsWizardPage extends AbstractBaseWizardPage {

  private CheckboxTableViewer tagsTableViewer;
  private Label selectionInfo;
  private final Set<String> undeletableTags = new HashSet<>();
  private final Map<String, ITagDeletionCheckObject> tagDeletionIssues = new HashMap<>();

  public DeleteTagsWizardPage() {
    super(DeleteTagsWizardPage.class.getName());
    setTitle(Messages.DeleteTagsWizardPage_PageTitle_xtit);
    setDescription(Messages.DeleteTagsWizardPage_PageDescription_xtit);
  }

  private class ColumnLabelProvider extends CellLabelProvider implements
      DelegatingStyledCellLabelProvider.IStyledLabelProvider {

    private final ColumnSpec colSpec;

    public ColumnLabelProvider(final ColumnSpec colSpec) {
      this.colSpec = colSpec;
    }

    @Override
    public Image getImage(final Object element) {
      Image image = null;
      if (colSpec == ColumnSpec.TAG) {
        image = getTagImage(element);
      } else {
        image = getIssueImage(element);
      }
      return image;
    }

    @Override
    public StyledString getStyledText(final Object element) {
      var nodeText = new StyledString();
      if (element instanceof ITag) {
        var tag = (ITag) element;
        if (colSpec == ColumnSpec.TAG) {
          nodeText.append(tag.getName());
        } else {
          var issue = tagDeletionIssues.get(tag.getId());
          if (issue != null) {
            nodeText.append(issue.getMessage());
          }
        }
      }
      return nodeText;
    }

    @Override
    public void update(final ViewerCell cell) {
    }

    private Image getIssueImage(final Object element) {
      if (!(element instanceof ITag)) {
        return null;
      }
      var issue = tagDeletionIssues.get(((ITag) element).getId());
      if (issue != null) {
        switch (issue.getMessageType()) {
        case ERROR:
          return PlatformUI.getWorkbench()
              .getSharedImages()
              .getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
        case WARNING:
          return PlatformUI.getWorkbench()
              .getSharedImages()
              .getImage(ISharedImages.IMG_OBJS_WARN_TSK);
        default:
          break;
        }
      }
      return null;
    }

    private Image getTagImage(final Object element) {
      if (!(element instanceof ITag)) {
        return null;
      }
      return ImageUtil.getImageForTag((ITag) element, false);
    }

  }

  private enum ColumnSpec {
    TAG(280, Messages.DeleteTagsWizardPage_TagColumn_xtit),
    ISSUES(300, Messages.DeleteTagsWizardPage_IssuesColumn_xtit);

    public final int defaultWidth;
    public final String tooltip;
    public final String headerText;

    ColumnSpec(final int width, final String headerText) {
      this(width, headerText, headerText);
    }

    ColumnSpec(final int width, final String headerText, final String tooltip) {
      defaultWidth = width;
      this.headerText = headerText;
      this.tooltip = tooltip;
    }
  }

  @Override
  public void createControl(final Composite parent) {
    var mainComponent = new Composite(parent, SWT.NONE);
    GridLayoutFactory.swtDefaults().applyTo(mainComponent);
    GridDataFactory.fillDefaults().applyTo(mainComponent);

    createViewer(mainComponent);

    tagsTableViewer.setInput(getWizard().getTagsForDeletion().getTags());

    setControl(mainComponent);
  }

  @Override
  public DeleteTagsWizard getWizard() {
    return (DeleteTagsWizard) super.getWizard();
  }

  @Override
  public void setVisible(final boolean visible) {
    var tagsForDeletion = getWizard().getTagsForDeletion();
    if (tagsForDeletion != null && !tagsForDeletion.getTags().isEmpty()) {
      runDeletionCheckForTags();
    } else {
      setErrorMessage(Messages.DeleteTagsWizardPage_NoTagsAvailableError_xmsg);
      setPageComplete(false);
    }
    super.setVisible(visible);
  }

  private void createViewer(final Composite parent) {
    var table = new Table(parent, SWT.V_SCROLL | SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION
        | SWT.CHECK);
    table.setHeaderVisible(true);

    tagsTableViewer = new CheckboxTableViewer(table);

    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.FILL)
        .grab(true, true)
        .minSize(580, 20)
        .hint(SWT.DEFAULT, table.getItemHeight() * 5)
        .applyTo(table);

    for (var colSpec : ColumnSpec.values()) {
      var tableColumn = new TableViewerColumn(tagsTableViewer, SWT.NONE);
      var column = tableColumn.getColumn();
      column.setText(colSpec.headerText);
      column.setToolTipText(colSpec.tooltip);
      column.setWidth(colSpec.defaultWidth);
      column.setMoveable(false);
      tableColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new ColumnLabelProvider(
          colSpec)));
    }

    tagsTableViewer.addCheckStateListener(event -> {
      setMessage(null);
      final ITag tag = (ITag) event.getElement();
      if (event.getChecked() && undeletableTags.contains(tag.getId())) {
        event.getCheckable().setChecked(tag, false);
      } else {
        setErrorMessage(null);
      }
      getWizard().setTagCheckedForDeletion(tag.getId(), event.getChecked());
      updateSelectionInfoLabel();
    });
    tagsTableViewer.setContentProvider(new ArrayContentProvider());

    selectionInfo = new Label(parent, SWT.NONE);
    GridDataFactory.fillDefaults().applyTo(selectionInfo);
  }

  @SuppressWarnings("unchecked")
  private void fillCheckResult(final ITagDeletionCheckResult checkResult) {
    tagDeletionIssues.clear();
    for (var checkedTag : checkResult.getCheckedTags()) {
      tagDeletionIssues.put(checkedTag.getTagId(), checkedTag);
    }

    var wizard = getWizard();
    for (var tag : (List<ITag>) tagsTableViewer.getInput()) {
      var issue = tagDeletionIssues.get(tag.getId());
      if (issue != null) {
        tagsTableViewer.setChecked(tag, issue.isDeletable());
        wizard.setTagCheckedForDeletion(tag.getId(), issue.isDeletable());
        if (!issue.isDeletable()) {
          undeletableTags.add(tag.getId());
        }
      } else {
        tagsTableViewer.setChecked(tag, true);
        wizard.setTagCheckedForDeletion(tag.getId(), true);
      }
    }
    updateSelectionInfoLabel();

    if (undeletableTags.size() == getWizard().getTagsForDeletion().getTags().size()) {
      setErrorMessage(Messages.DeleteTagsWizardPage_DeletionNotPossibleError_xmsg);
      setPageComplete(false);
    }
    tagsTableViewer.refresh();
  }

  private void runDeletionCheckForTags() {
    final var wizard = getWizard();
    final var project = wizard.getProject();
    if (project == null) {
      return;
    }
    final var destinationId = DestinationUtil.getDestinationId(project);
    try {
      getContainer().run(true, false, monitor -> {
        monitor.beginTask(Messages.DeleteTagsWizardPage_DeletionCheckJob_xmsg, 1);
        var tagsService = AbapTagsServiceFactory.createTagsService();

        final var checkResult = tagsService.runTagDeletionCheck(destinationId, getWizard()
            .getTagsForDeletion());

        Display.getDefault().asyncExec(() -> {
          fillCheckResult(checkResult);
        });
      });
    } catch (final InvocationTargetException e) {
      if (e.getTargetException() instanceof RuntimeException) {
        throw (RuntimeException) e.getTargetException();
      }
    } catch (final InterruptedException e) {

    }

  }

  private void updateSelectionInfoLabel() {
    var checkedCount = tagsTableViewer.getCheckedElements().length;

    if (checkedCount == 0 && undeletableTags.size() < getWizard().getTagsForDeletion()
        .getTags()
        .size()) {
      setErrorMessage(Messages.DeleteTagsWizardPage_NoTagsSelectedError_xmsg);
    }

    selectionInfo.setText(String.format("%d Tag%s %s", checkedCount, checkedCount == 1 ? "" : "s",
        Messages.DeleteTagsWizardPage_Selected_xlbl));

    setPageComplete(checkedCount > 0);
  }
}
