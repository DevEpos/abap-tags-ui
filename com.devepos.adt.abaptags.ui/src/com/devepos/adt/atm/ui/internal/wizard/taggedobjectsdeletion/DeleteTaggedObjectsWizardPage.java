package com.devepos.adt.atm.ui.internal.wizard.taggedobjectsdeletion;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.search.ITaggedObjectSearchService;
import com.devepos.adt.atm.search.TaggedObjectSearchFactory;
import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.tagging.IAdtObjTaggingService;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.help.HelpContexts;
import com.devepos.adt.atm.ui.internal.help.HelpUtil;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.preferences.IObjectTaggingPrefs;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.table.FilterableTable;
import com.devepos.adt.base.ui.wizard.AbstractBaseWizardPage;
import com.devepos.adt.base.util.StringUtil;

public class DeleteTaggedObjectsWizardPage extends AbstractBaseWizardPage {

  public static final String PAGE_NAME = DeleteTaggedObjectsWizardPage.class.getCanonicalName();

  private CheckboxTableViewer taggedObjectsViewer;
  private Label selectionInfo;
  private ToolBar toolBar;
  private TaggedObjectsTable taggedObjectsTable;
  private CustomViewerComparator comparator;

  private final IAdtObjTaggingService taggingService;
  private final ITaggedObjectSearchService searchService;
  private final boolean loadTaggedChildObjectsIfAvailable;

  private final List<DeletableTaggedObject> taggedObjects = new ArrayList<>();
  private final Map<String, DeletableTaggedObject> taggedObjectsById = new HashMap<>();
  private final Set<DeletableTaggedObject> checkedTaggedObjects = new HashSet<>();
  private final Set<DeletableTaggedObject> undeletableTaggedObjects = new HashSet<>();

  protected DeleteTaggedObjectsWizardPage() {
    super(PAGE_NAME);
    setTitle(Messages.DeleteTaggedObjectsWizardPage_PageTitle_xtit);
    setDescription(Messages.DeleteTaggedObjectsWizardPage_PageDescription_xmsg);

    searchService = TaggedObjectSearchFactory.createTaggedObjectSearchService();
    taggingService = AdtObjTaggingServiceFactory.createTaggingService();
    loadTaggedChildObjectsIfAvailable = AbapTagsUIPlugin.getDefault()
        .getPreferenceStore()
        .getBoolean(IObjectTaggingPrefs.DELETION_AUTO_LOAD_ASSIGNED_CHILDREN);
  }

  private static class CustomViewerComparator extends ViewerComparator {
    private ColumnViewerSpec col;
    private boolean isDescendingSort = true;

    @Override
    public int compare(final Viewer viewer, final Object e1, final Object e2) {
      var obj1 = (DeletableTaggedObject) e1;
      var obj2 = (DeletableTaggedObject) e2;

      if (col != null) {
        switch (col) {
        case TAG:
          return compareStrings(concatStrings(obj1.getTagType().toString(), obj1.getTagName()),
              concatStrings(obj2.getTagType().toString(), obj2.getTagName()));
        case OBJECT:
          return compareStrings(concatStrings(obj1.getComponentType(), obj1.getComponentName(), obj1
              .getObjectType(), obj1.getObjectName()), concatStrings(obj2.getComponentType(), obj2
                  .getComponentName(), obj2.getObjectType(), obj2.getObjectName()));
        case PARENT_TAG:
          var parentTag1 = obj1.getParentTagName();
          var parentTag2 = obj2.getParentTagName();
          parentTag1 = parentTag1 != null ? concatStrings(obj1.getTagType().toString(), parentTag1)
              : null;
          parentTag2 = parentTag2 != null ? concatStrings(obj2.getTagType().toString(), parentTag2)
              : null;
          return compareStrings(parentTag1, parentTag2);
        case PARENT_OBJECT:
          return compareStrings(concatStrings(obj1.getParentObjectType(), obj1
              .getParentObjectName()), concatStrings(obj2.getParentObjectType(), obj2
                  .getParentObjectName()));
        case ISSUES:
          return compareStrings(obj1.getMessage(), obj2.getMessage());
        }
      }

      return 0;
    }

    public int getDirection() {
      return isDescendingSort ? SWT.DOWN : SWT.UP;
    }

    public void setColumn(final ColumnViewerSpec col) {
      if (this.col == col) {
        isDescendingSort = !isDescendingSort;
      } else {
        isDescendingSort = true;
      }
      this.col = col;
    }

    private int compareStrings(final String s1, final String s2) {
      int rc = (s1 == null ? "" : s1).compareTo(s2 == null ? "" : s2); //$NON-NLS-1$ //$NON-NLS-2$
      return isDescendingSort ? -rc : rc;
    }

    private String concatStrings(final String... values) {
      StringBuffer buffer = new StringBuffer();
      for (var val : values) {
        if (val != null) {
          buffer.append(val);
        }
      }
      return buffer.toString();
    }
  }

  private class TaggedObjectsTable extends FilterableTable {
    public TaggedObjectsTable(final Composite parent) {
      super(parent, null, false, true); // $NON-NLS-1$
      setElementMatcher(l -> {
        var taggedObject = (DeletableTaggedObject) l;
        var wordMatcher = getWordMatcher();
        return wordMatcher.matchesWord(taggedObject.getObjectName()) || wordMatcher.matchesWord(
            taggedObject.getComponentName()) || wordMatcher.matchesWord(taggedObject.getTagName())
            || wordMatcher.matchesWord(taggedObject.getParentObjectName()) || wordMatcher
                .matchesWord(taggedObject.getParentTagName());
      });
    }

    @Override
    protected void filterJobCompleted() {
      super.filterJobCompleted();
      setCheckedElementsInTable();
    }

    private void setCheckedElementsInTable() {
      for (var checkedElement : checkedTaggedObjects) {
        taggedObjectsViewer.setChecked(checkedElement, true);
      }
    }
  }

  @Override
  public void completePage() {
    if (!isDirty()) {
      return;
    }

    getWizard().setTaggedObjectIdsForDeletion(checkedTaggedObjects.stream()
        .map(DeletableTaggedObject::getId)
        .collect(Collectors.toList()));

    setDirty(false);
  }

  @Override
  public void createControl(final Composite parent) {
    var mainComponent = new Composite(parent, SWT.NONE);
    HelpUtil.setHelp(mainComponent, HelpContexts.UNASSIGN_TAGS_WIZARD_OBJ_SELECtION);
    GridLayoutFactory.swtDefaults().applyTo(mainComponent);
    GridDataFactory.fillDefaults().applyTo(mainComponent);

    createViewer(mainComponent);
    createTreeToolbar(taggedObjectsTable.getFilterComposite());
    createSelectionInfo(mainComponent);

    setControl(mainComponent);
  }

  @Override
  public DeleteTaggedObjectsWizard getWizard() {
    return (DeleteTaggedObjectsWizard) super.getWizard();
  }

  @Override
  public void setVisible(final boolean visible) {
    var wizard = getWizard();
    final boolean previousPageIsDirty = wizard.isPreviousPageDirty(this);
    if (visible && (!isPageComplete() || previousPageIsDirty || taggedObjects == null
        || taggedObjects.isEmpty())) {
      if (previousPageIsDirty) {
        clearModelChanges();
        taggedObjectsViewer.refresh();
      }
      wizard.completePreviousPage(this);

      taggedObjectsViewer.getTable().setFocus();

      var objectListRequest = wizard.getTaggedObjectListRequest();
      if (taggedObjects != null && !taggedObjects.isEmpty()) {
        setTableInput();
      } else if (!objectListRequest.getTagIds().isEmpty() || !objectListRequest.getTaggedObjectIds()
          .isEmpty() || !objectListRequest.getTaggedObjectInfos().isEmpty()) {
        runDeletionCheck();
      }
    } else {
      if (!visible && taggedObjectsTable != null) {
        taggedObjectsTable.resetFilter();
      }
      validatePage();
    }
    super.setVisible(visible);
  }

  private void checkAllObjects() {
    taggedObjectsViewer.getTable().setRedraw(false);

    if (StringUtil.isEmpty(taggedObjectsTable.getFilterString())) {
      for (var taggedObject : taggedObjects) {
        setObjectChecked(taggedObject);
      }
    } else {
      // select only filtered objects
      for (var visibleRow : taggedObjectsViewer.getTable().getItems()) {
        var rowObject = visibleRow.getData();
        var taggedObject = (DeletableTaggedObject) rowObject;
        setObjectChecked(taggedObject);
      }
    }
    taggedObjectsViewer.getTable().setRedraw(true);
    taggedObjectsViewer.refresh();
    validatePage();
  }

  private void clearModelChanges() {
    var wizard = getWizard();
    uncheckAllObjects(true);
    taggedObjects.clear();
    taggedObjectsById.clear();
    undeletableTaggedObjects.clear();
    wizard.setCanFinish(false);
  }

  private void collectAdditionalObjectInformation() {
    for (var obj : taggedObjects) {
      if (!obj.isDeletable()) {
        undeletableTaggedObjects.add(obj);
      }
      if (!obj.getDependentObjectIds().isEmpty()) {
        for (var childId : obj.getDependentObjectIds()) {
          var childObject = taggedObjectsById.get(childId);
          obj.addChildObject(childObject);
          childObject.addParentObject(obj);
        }
      }
    }
  }

  private void createColumns() {
    boolean hideParentObjectCol = true;
    boolean hideParentTagCol = true;

    for (var obj : taggedObjects) {
      if (!hideParentObjectCol && !hideParentTagCol) {
        break;
      }
      if (obj.getParentObjectName() != null) {
        hideParentObjectCol = false;
      }
      if (obj.getParentTagName() != null) {
        hideParentTagCol = false;
      }
    }

    for (var colSpec : ColumnViewerSpec.values()) {
      if ((colSpec == ColumnViewerSpec.PARENT_OBJECT && hideParentObjectCol)
          || (colSpec == ColumnViewerSpec.PARENT_TAG && hideParentTagCol)) {
        continue;
      }
      var tableColumn = new TableViewerColumn(taggedObjectsViewer, SWT.NONE);
      var column = tableColumn.getColumn();
      column.setText(colSpec.headerText);
      column.setWidth(colSpec.defaultWidth);
      column.setMoveable(false);
      column.setData(colSpec);
      tableColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(
          new TaggedObjectColumnLabelProvider(colSpec)));
      column.addSelectionListener(widgetSelectedAdapter(l -> {
        comparator.setColumn(colSpec);
        taggedObjectsViewer.getTable().setSortDirection(comparator.getDirection());
        taggedObjectsViewer.getTable().setSortColumn(tableColumn.getColumn());
        taggedObjectsViewer.refresh();
      }));
    }
  }

  private void createSelectionInfo(final Composite parent) {
    selectionInfo = new Label(parent, SWT.NONE);
    GridDataFactory.fillDefaults().applyTo(selectionInfo);
  }

  private void createTreeToolbar(final Composite parent) {
    toolBar = new ToolBar(parent, SWT.FLAT | SWT.HORIZONTAL);
    toolBar.setEnabled(false);
    GridDataFactory.fillDefaults().align(SWT.END, SWT.FILL).applyTo(toolBar);

    final var checkAll = new ToolItem(toolBar, SWT.PUSH);
    checkAll.setToolTipText(AdtBaseUIResources.getString(IAdtBaseStrings.SelectAll_xlbl));

    checkAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.CHECK_ALL));
    checkAll.addSelectionListener(widgetSelectedAdapter(l -> {
      checkAllObjects();
    }));

    final var uncheckAll = new ToolItem(toolBar, SWT.PUSH);
    uncheckAll.setToolTipText(AdtBaseUIResources.getString(IAdtBaseStrings.DeselectAll_xlbl));

    uncheckAll.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.UNCHECK_ALL));
    uncheckAll.addSelectionListener(widgetSelectedAdapter(l -> {
      uncheckAllObjects(false);
    }));
  }

  private void createViewer(final Composite parent) {
    taggedObjectsTable = new TaggedObjectsTable(parent);
    var table = new Table(taggedObjectsTable, SWT.V_SCROLL | SWT.SINGLE | SWT.BORDER
        | SWT.FULL_SELECTION | SWT.CHECK);
    table.setHeaderVisible(true);

    taggedObjectsViewer = new CheckboxTableViewer(table);

    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.FILL)
        .grab(true, true)
        .hint(SWT.DEFAULT, table.getItemHeight() * 20) // 18 Entries + Filter + Column Headers
        .applyTo(taggedObjectsTable);

    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(table);

    taggedObjectsViewer.setContentProvider(new ArrayContentProvider());
    taggedObjectsViewer.getTable().setLinesVisible(true);
    taggedObjectsTable.setViewer(taggedObjectsViewer);

    taggedObjectsViewer.addCheckStateListener(e -> {
      var taggedObject = (DeletableTaggedObject) e.getElement();
      var checkable = e.getCheckable();
      if (e.getChecked()) {
        if (!taggedObject.isDeletable(true)) {
          checkable.setChecked(taggedObject, false);
        } else {
          checkedTaggedObjects.add(taggedObject);
          taggedObject.updateParents();
        }
      } else {
        checkedTaggedObjects.remove(taggedObject);
        taggedObject.uncheckParents();
        taggedObject.updateParents();
        taggedObjectsViewer.refresh(taggedObject);
      }
      setDirty(true);
      validatePage();
    });

    taggedObjectsTable.addKeyListenerForFilterFocus();
    comparator = new CustomViewerComparator();
    taggedObjectsViewer.setComparator(comparator);
  }

  private void disposeTableColumns() {
    for (var column : taggedObjectsViewer.getTable().getColumns()) {
      column.dispose();
    }
  }

  private void runDeletionCheck() {
    final var wizard = getWizard();
    final var project = wizard.getProject();
    if (project == null) {
      return;
    }
    final String destinationId = DestinationUtil.getDestinationId(project);

    var previousPage = wizard.getPreviousPage(this);
    var listRequest = wizard.getTaggedObjectListRequest();
    if (previousPage == null && (!listRequest.getTaggedObjectIds().isEmpty() || !listRequest
        .getTaggedObjectInfos()
        .isEmpty())) {
      listRequest.setLoadChildObjects(loadTaggedChildObjectsIfAvailable);
    }

    try {
      getContainer().run(true, false, monitor -> {
        monitor.beginTask("", 2); //$NON-NLS-1$
        monitor.subTask(Messages.DeleteTaggedObjectsWizardPage_RetrieveObjectInfosJobTitle_xmsg);
        final var taggedObjectInfos = searchService.findObjectInfos(destinationId, wizard
            .getTaggedObjectListRequest());
        monitor.worked(1);

        if (taggedObjectInfos == null || taggedObjectInfos.isEmpty()) {
          monitor.done();
          Display.getDefault().asyncExec(() -> {
            setMessage(Messages.DeleteTaggedObjectsWizardPage_NoTaggedObjectsFoundInfo_xmsg,
                INFORMATION);
            setPageComplete(false);
          });
          return;
        }
        var delCheckRequest = IAbapTagsFactory.eINSTANCE.createTaggedObjectDeletionCheckRequest();

        taggedObjectInfos.forEach(info -> {
          var taggedObjInfo = new DeletableTaggedObject(taggedObjectsViewer, checkedTaggedObjects);
          taggedObjInfo.setObjectInfo(info);
          taggedObjectsById.put(info.getId(), taggedObjInfo);
          taggedObjects.add(taggedObjInfo);
          delCheckRequest.getTaggedObjectIds().add(info.getId());
        });

        monitor.subTask(Messages.DeleteTaggedObjectsWizardPage_DeletionCheckJobTitle_xmsg);
        final var checkResults = taggingService.runTaggedObjectDeletionCheck(destinationId,
            delCheckRequest);
        monitor.worked(1);

        Display.getDefault().asyncExec(() -> {
          if (checkResults == null || checkResults.getCheckedObjects().isEmpty()) {
            taggedObjects.clear();
            taggedObjectsById.clear();
            setMessage(Messages.DeleteTaggedObjectsWizardPage_NoTaggedObjectsFoundInfo_xmsg,
                INFORMATION);
            setPageComplete(false);
          } else {
            checkResults.getCheckedObjects().forEach(checkResultObj -> {
              var taggedObjectInfo = taggedObjectsById.get(checkResultObj.getTaggedObjectId());
              taggedObjectInfo.setDeletionCheckInfo(checkResultObj);
            });
          }
          collectAdditionalObjectInformation();
          setTableInput();
        });
        monitor.done();
      });
    } catch (final InvocationTargetException e) {
      if (e.getTargetException() instanceof RuntimeException) {
        throw (RuntimeException) e.getTargetException();
      }
    } catch (final InterruptedException e) {
    }
  }

  private void setObjectChecked(final DeletableTaggedObject taggedObject) {
    if (taggedObject.isDeletable()) {
      checkedTaggedObjects.add(taggedObject);
      taggedObjectsViewer.setChecked(taggedObject, true);
      taggedObject.updateParents();
    }
    taggedObject.clearTransientMessage();
  }

  /*
   * Prepares received data from backend for display in the table viewer
   */
  private void setTableInput() {
    disposeTableColumns();
    createColumns();

    taggedObjectsViewer.setInput(taggedObjects);
    checkAllObjects();
    validatePage();

    // delay necessary otherwise the toolbar state is not yet active
    Display.getDefault().timerExec(200, () -> {
      toolBar.setEnabled(taggedObjects != null && !taggedObjects.isEmpty() && taggedObjects
          .size() != undeletableTaggedObjects.size());
    });

    // make column adjustments
    for (var column : taggedObjectsViewer.getTable().getColumns()) {
      var colSpec = (ColumnViewerSpec) column.getData();
      if (colSpec == ColumnViewerSpec.ISSUES) {
        continue;
      }
      column.pack();
      column.setWidth(column.getWidth() + 7);
    }

    updateShellSize();

    if (!taggedObjects.isEmpty()) {
      taggedObjectsViewer.getTable().setSelection(0);
      taggedObjectsViewer.getTable().setFocus();
    }

    setDirty(true);
  }

  private void uncheckAllObjects(final boolean skipValidation) {
    checkedTaggedObjects.clear();
    for (var object : taggedObjects) {
      object.uncheckChildren();
    }
    taggedObjectsViewer.setAllChecked(false);
    taggedObjectsViewer.refresh();
    if (!skipValidation) {
      validatePage();
    }
  }

  private void updateCheckedLabel() {
    var checkedCount = checkedTaggedObjects.size();

    if (checkedCount == 0) {
      setErrorMessage(Messages.DeleteTagsWizardPage_NoTagsSelectedError_xmsg);
    }

    selectionInfo.setText(String.format(
        Messages.DeleteTaggedObjectsWizardPage_TaggedObjectSelectionFormat_xmsg, checkedCount == 0
            ? Messages.General_No_xlbl
            : String.valueOf(checkedCount), checkedCount == 1 ? "" : "s", //$NON-NLS-1$ //$NON-NLS-2$
        Messages.DeleteTagsWizardPage_Selected_xlbl));
  }

  private void updatePageStatus(final IStatus pageStatus) {
    boolean pageComplete = true;
    if (pageStatus == null || pageStatus.isOK()) {
      setErrorMessage(null);
      setMessage(null);
    } else if (pageStatus.getSeverity() == IStatus.ERROR) {
      pageComplete = false;
      if (pageStatus.getCode() == IStatus.INFO) {
        setErrorMessage(null);
        setMessage(pageStatus.getMessage(), INFORMATION);
      } else {
        setErrorMessage(pageStatus.getMessage());
      }
    }
    getWizard().setCanFinish(pageComplete);
    setPageComplete(pageComplete);
  }

  private void updateShellSize() {
    var wizardDialog = (WizardDialog) getWizard().getContainer();
    wizardDialog.updateSize();
  }

  private void validatePage() {
    IStatus pageStatus = null;
    if (checkedTaggedObjects.isEmpty()) {
      if (!taggedObjects.isEmpty() && undeletableTaggedObjects.size() == taggedObjects.size()) {
        pageStatus = new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID, IStatus.ERROR,
            Messages.DeleteTaggedObjectsWizardPage_CompletionNotPossible_xmsg, null);
      } else {
        pageStatus = new Status(IStatus.ERROR, AbapTagsUIPlugin.PLUGIN_ID, IStatus.INFO,
            Messages.DeleteTaggedObjectsWizardPage_NoTaggedObjectSelectedInfo_xmsg, null);
      }
    } else {
      pageStatus = Status.OK_STATUS;
    }
    updateCheckedLabel();
    updatePageStatus(pageStatus);
  }
}
