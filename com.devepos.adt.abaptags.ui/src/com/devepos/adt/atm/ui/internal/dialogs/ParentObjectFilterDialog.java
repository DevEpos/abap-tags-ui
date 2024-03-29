package com.devepos.adt.atm.ui.internal.dialogs;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.model.abaptags.ResultGroupLevel;
import com.devepos.adt.atm.model.abaptags.TagInfoType;
import com.devepos.adt.atm.search.ITaggedObjectSearchService;
import com.devepos.adt.atm.search.TaggedObjectSearchFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.ImageUtil;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.dialogs.SearchSelectionDialog;
import com.devepos.adt.base.util.StringUtil;

public class ParentObjectFilterDialog extends SearchSelectionDialog<ITaggedObject, String> {
  private static final String DIALOG_SETTINGS_NAME = ParentObjectFilterDialog.class
      .getCanonicalName();
  private final String destinationId;
  private final ITaggedObjectSearchParams parameters;
  private final ITaggedObjectSearchService service;
  private final String destinationOwner;
  private CustomViewerComparator comparator;

  public ParentObjectFilterDialog(final Shell shell, final String destinationId,
      final List<String> possibleParentTags) {
    super(shell, false);
    this.destinationId = destinationId;

    destinationOwner = DestinationUtil.getDestinationData(destinationId).getUser();

    setTitle(Messages.ParentObjectFilterDialog_Title_xtit);
    setFilterLabel(Messages.ParentObjectFilterDialog_FilterText_xmsg);
    setDetailsLabelProvider(new ItemsLabelProvider());
    setInitialJobDelay(0L);

    parameters = IAbapTagsFactory.eINSTANCE.createTaggedObjectSearchParams();

    parameters.getTagIds().addAll(possibleParentTags);
    parameters.setWithTagInfo(true);
    parameters.setResultGroupLevel(ResultGroupLevel.BY_TAG_AND_OBJECT);
    parameters.setTagInfoType(TagInfoType.SEARCH_FOCUS);
    parameters.setMaxResults(50);
    parameters.setExcludeComponents(true);
    service = TaggedObjectSearchFactory.createTaggedObjectSearchService();
  }

  private enum Column {
    TAG(150, Messages.ParentObjectFilterDialog_tagColumnName_xtit),
    OBJECT_NAME(280, Messages.ParentObjectFilterDialog_objectNameColumnName_xtit);

    public final int defaultWidth;
    public final String tooltip;
    public final String headerText;

    Column(final int width, final String headerText) {
      this(width, headerText, headerText);
    }

    Column(final int width, final String headerText, final String tooltip) {
      defaultWidth = width;
      this.headerText = headerText;
      this.tooltip = tooltip;
    }
  }

  /*
   * Label provider for a single column in this Table Viewer
   */
  private class ColumnLabelProvider extends CellLabelProvider implements
      DelegatingStyledCellLabelProvider.IStyledLabelProvider, ILabelProvider {

    private final Column column;

    public ColumnLabelProvider(final Column column) {
      this.column = column;
    }

    @Override
    public Image getImage(final Object element) {
      Image image = null;
      if (column == Column.OBJECT_NAME) {
        image = getObjectNameColImage(element);
      } else if (column == Column.TAG) {
        IAdtObjectTag tag = ((ITaggedObject) element).getTags().get(0);
        return ImageUtil.getObjectTagImage(tag, destinationOwner);
      }
      return image;
    }

    @Override
    public StyledString getStyledText(final Object element) {
      final StyledString text = new StyledString();

      switch (column) {
      case OBJECT_NAME:
        setObjectNameText(element, text);
        break;
      case TAG:
        text.append(((ITaggedObject) element).getTags().get(0).getName());
        break;
      }
      return text;
    }

    @Override
    public String getText(final Object element) {
      return null;
    }

    @Override
    public void update(final ViewerCell cell) {
    }

    private Image getObjectNameColImage(final Object element) {
      if (element instanceof ITaggedObject) {
        final ITaggedObject taggedObject = (ITaggedObject) element;
        return ImageUtil.getAdtObjRefImage(taggedObject.getObjectRef());
      }
      return null;
    }

    private void setObjectNameText(final Object element, final StyledString text) {
      if (element instanceof ITaggedObject) {
        final ITaggedObject taggedObject = (ITaggedObject) element;
        var objectRefName = taggedObject.getObjectRef().getDisplayName();
        if (!StringUtil.isEmpty(objectRefName)) {
          text.append(objectRefName);
        }
      }
    }
  }

  private static class CustomViewerComparator extends ViewerComparator {
    private Column col;
    private boolean isDescendingSort = true;

    @Override
    public int compare(final Viewer viewer, final Object e1, final Object e2) {
      var obj1 = (ITaggedObject) e1;
      var obj2 = (ITaggedObject) e2;
      int rc = 0;

      if (col != null) {
        switch (col) {
        case OBJECT_NAME:
          rc = obj1.getObjectRef().getName().compareTo(obj2.getObjectRef().getName());
          break;
        case TAG:
          rc = obj1.getTags().get(0).getName().compareTo(obj2.getTags().get(0).getName());
          break;
        }
      }
      return isDescendingSort ? -rc : rc;
    }

    public int getDirection() {
      return isDescendingSort ? SWT.DOWN : SWT.UP;
    }

    public void setColumn(final Column col) {
      if (this.col == col) {
        isDescendingSort = !isDescendingSort;
      } else {
        isDescendingSort = true;
      }
      this.col = col;
    }
  }

  /*
   * Label provider for the selected result part
   */
  private static class ItemsLabelProvider extends LabelProvider implements
      DelegatingStyledCellLabelProvider.IStyledLabelProvider {

    @Override
    public Image getImage(final Object element) {
      final IAdtObjRef ref = getObjectRef(element);
      return ImageUtil.getAdtObjRefImage(ref);
    }

    @Override
    public StyledString getStyledText(final Object element) {
      final StyledString text = new StyledString();
      final IAdtObjRef objectRef = getObjectRef(element);
      if (objectRef != null) {
        text.append(objectRef.getDisplayName());
        final String description = objectRef.getDescription();
        if (!StringUtil.isEmpty(description)) {
          text.append(" " + objectRef.getDescription(), //$NON-NLS-1$
              StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR,
                  null));
        }
      }
      return text != null ? text : new StyledString();
    }

    @Override
    public String getText(final Object element) {
      final IAdtObjRef objectRef = getObjectRef(element);
      return objectRef != null ? objectRef.getDisplayName() : null;
    }

    private IAdtObjRef getObjectRef(final Object element) {
      if (!(element instanceof ITaggedObject)) {
        return null;
      }
      return ((ITaggedObject) element).getObjectRef();
    }
  }

  @Override
  protected void configureDefaultResultViewer(final TableViewer tableViewer) {
    tableViewer.getTable().setHeaderVisible(true);
    comparator = new CustomViewerComparator();
    tableViewer.setComparator(comparator);
    for (Column c : Column.values()) {
      createColumn(tableViewer, c, new ColumnLabelProvider(c));
    }
  }

  @Override
  protected IDialogSettings getDialogSettings() {
    return AbapTagsUIPlugin.getDefault().getDialogSettingsSection(DIALOG_SETTINGS_NAME);
  }

  @Override
  protected boolean matchesFilter(final ITaggedObject result, final String filter) {
    return true;
  }

  @Override
  protected SearchSelectionDialog<ITaggedObject, String>.SearchResultObject performSearch(
      final String filter, final IProgressMonitor monitor) throws CoreException {
    parameters.setQuery(StringUtil.isEmpty(filter) ? "*" : filter); //$NON-NLS-1$
    final ITaggedObjectList taggedObjList = service.findObjects(
        ParentObjectFilterDialog.this.destinationId, ParentObjectFilterDialog.this.parameters);

    if (taggedObjList != null && !taggedObjList.getTaggedObjects().isEmpty()) {
      return new SearchResultObject(taggedObjList.getTaggedObjects()
          .stream()
          .limit(parameters.getMaxResults())
          .collect(Collectors.toList()), taggedObjList.getTaggedObjects().size() <= parameters
              .getMaxResults());
    }
    return new SearchResultObject(new ArrayList<>(), true);
  }

  private TableViewerColumn createColumn(final TableViewer treeViewer, final Column column,
      final ColumnLabelProvider cellLabelProvider) {
    final TableViewerColumn viewerColumn = new TableViewerColumn(treeViewer, SWT.NONE);
    viewerColumn.getColumn().setText(column.headerText);
    viewerColumn.getColumn().setToolTipText(column.tooltip);
    viewerColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(cellLabelProvider));
    viewerColumn.getColumn().setWidth(column.defaultWidth);
    viewerColumn.getColumn().setMoveable(false);
    viewerColumn.getColumn().addSelectionListener(widgetSelectedAdapter(l -> {
      comparator.setColumn(column);
      treeViewer.getTable().setSortDirection(comparator.getDirection());
      treeViewer.getTable().setSortColumn(viewerColumn.getColumn());
      treeViewer.refresh();
    }));
    return viewerColumn;
  }
}
