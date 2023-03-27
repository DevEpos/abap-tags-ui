package com.devepos.adt.atm.ui.internal.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.Page;

import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.ImageUtil;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.preferences.ITaggedObjectSearchPrefs;
import com.devepos.adt.atm.ui.internal.util.IColorConstants;
import com.devepos.adt.atm.ui.internal.util.ITaggedObjectPropertyNameConstants;
import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ITadirTypeConstants;
import com.devepos.adt.base.project.IAbapProjectProvider;
import com.devepos.adt.base.ui.ContextHelper;
import com.devepos.adt.base.ui.IGeneralCommandConstants;
import com.devepos.adt.base.ui.IGeneralContextConstants;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.ViewerState;
import com.devepos.adt.base.ui.action.CollapseAllTreeNodesAction;
import com.devepos.adt.base.ui.action.CollapseTreeNodesAction;
import com.devepos.adt.base.ui.action.CommandFactory;
import com.devepos.adt.base.ui.action.CopyToClipboardAction;
import com.devepos.adt.base.ui.action.OpenAdtObjectAction;
import com.devepos.adt.base.ui.action.OpenColorPreferencePageAction;
import com.devepos.adt.base.ui.search.ISearchResultPageExtension;
import com.devepos.adt.base.ui.tree.ActionTreeNode;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.ui.tree.IStyledTreeNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.base.ui.tree.LoadingTreeItemsNode;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.ui.util.WorkbenchUtil;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.project.IProjectProvider;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

public class TaggedObjectSearchResultPage extends Page implements ISearchResultPage,
    ISearchResultListener, ISearchResultPageExtension<TaggedObjectSearchQuery> {

  private String pageId;
  private ISearchResultViewPart searchViewPart;
  private Tree resultTree;
  private TreeViewer resultTreeViewer;
  private TaggedObjectSearchResult result;
  private ViewerState state;
  private Composite mainComposite;
  private TaggedObjectSearchQuery searchQuery;
  private IAbapProjectProvider projectProvider;
  private CollapseAllTreeNodesAction collapseAllNodesAction;
  private CollapseTreeNodesAction collapseNodesAction;
  private CopyToClipboardAction copyToClipBoardAction;
  private OpenTaggedObjectSearchPreferences openPreferencesAction;
  private OpenColorPreferencePageAction openColorPrefPageAction;
  private IPropertyChangeListener prefStoreListener;
  private IPreferenceStore prefStore;
  private final List<String> executableObjectTypes;
  private ContextHelper contextHelper;
  private final IPropertyChangeListener colorPropertyChangeListener;

  public TaggedObjectSearchResultPage() {
    executableObjectTypes = Stream.of("CLAS/OC", "PROG/P", "TRAN/T", "FUGR/FF", "WAPA/WO",
        "WDYA/YY", "WDCA/YA").collect(Collectors.toList());
    colorPropertyChangeListener = event -> {
      if (IColorConstants.COMP_PARENT_COLOR.equals(event.getProperty()) && (resultTreeViewer != null
          && !resultTreeViewer.getControl().isDisposed())) {
        resultTreeViewer.refresh();
      }
    };
    JFaceResources.getColorRegistry().addListener(colorPropertyChangeListener);
  }

  @Override
  public void createControl(final Composite parent) {
    mainComposite = new Composite(parent, SWT.NONE);
    mainComposite.setLayout(new FillLayout());
    mainComposite.setSize(100, 100);
    GridDataFactory.fillDefaults().applyTo(mainComposite);

    createResultTree(mainComposite);

    initializeActions();
    hookContextMenu();

    prefStoreListener = e -> {
      if (resultTree == null || resultTree.isDisposed()) {
        return;
      }
      if (e.getProperty().equals(ITaggedObjectSearchPrefs.DISPLAY_DESCRIPTIONS) || e.getProperty()
          .equals(ITaggedObjectSearchPrefs.DISPLAY_PACKAGES) || e.getProperty()
              .equals(ITaggedObjectSearchPrefs.DISPLAY_OBJECT_TYPES)) {

        resultTreeViewer.refresh();
      }
    };
    prefStore = AbapTagsUIPlugin.getDefault().getPreferenceStore();
    prefStore.addPropertyChangeListener(prefStoreListener);

    getSite().setSelectionProvider(resultTreeViewer);
    contextHelper = ContextHelper.createForServiceLocator(getSite());
    contextHelper.activateAbapContext();
    contextHelper.activateContext(IGeneralContextConstants.SEARCH_PAGE_VIEWS);
  }

  @Override
  public void dispose() {
    if (prefStoreListener != null) {
      prefStore.removePropertyChangeListener(prefStoreListener);
    }
    if (contextHelper != null) {
      contextHelper.deactivateAllContexts();
    }
    if (colorPropertyChangeListener != null) {
      JFaceResources.getColorRegistry().removeListener(colorPropertyChangeListener);
    }
    super.dispose();
  }

  @Override
  public Control getControl() {
    return mainComposite;
  }

  @Override
  public void setActionBars(final IActionBars actionBars) {
    final IToolBarManager tbm = actionBars.getToolBarManager();
    tbm.appendToGroup(IContextMenuConstants.GROUP_NEW, CommandFactory.createContribItemById(
        IGeneralCommandConstants.OPEN_QUERY_IN_SEARCH_DIALOG, false, null));
    tbm.appendToGroup(IContextMenuConstants.GROUP_EDIT, collapseAllNodesAction);
    copyToClipBoardAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_COPY);
    actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), copyToClipBoardAction);
    actionBars.updateActionBars();

    var menu = actionBars.getMenuManager();

    menu.add(new ObjectLabelDecorationMenu());
    menu.add(new Separator());
    menu.add(openColorPrefPageAction);
    menu.add(new Separator());
    menu.add(openPreferencesAction);

  }

  @Override
  public void setFocus() {
    if (resultTree != null && !resultTree.isDisposed()) {
      resultTree.setFocus();
    }

  }

  @Override
  public Object getUIState() {
    if (resultTree != null && !resultTree.isDisposed()) {
      final ViewerState uiState = new ViewerState();
      uiState.setExpandedPaths(resultTreeViewer.getExpandedTreePaths());
      uiState.setSelection(resultTreeViewer.getSelection());
      return uiState;
    }
    return null;
  }

  @Override
  public void setInput(final ISearchResult search, final Object uiState) {
    if (result != null) {
      // clean up old search
      result.removeListener(this);
      resultTreeViewer.setInput(null);
    }
    result = (TaggedObjectSearchResult) search;
    if (result != null) {
      result.addListener(this);
      resultTreeViewer.setInput(result);
      state = uiState instanceof ViewerState ? (ViewerState) uiState : null;
      searchQuery = (TaggedObjectSearchQuery) result.getQuery();
      projectProvider = searchQuery.getProjectProvider();
      if (!NewSearchUI.isQueryRunning(searchQuery)) {
        updateUiState();
      }
    } else {
      searchViewPart.updateLabel();
    }

  }

  @Override
  public void setViewPart(final ISearchResultViewPart part) {
    searchViewPart = part;
  }

  @Override
  public void restoreState(final IMemento memento) {
  }

  @Override
  public void saveState(final IMemento memento) {
  }

  @Override
  public void setID(final String id) {
    pageId = id;
  }

  @Override
  public String getID() {
    return pageId;
  }

  @Override
  public String getLabel() {
    return result != null ? result.getLabel() : "";
  }

  @Override
  public void searchResultChanged(final SearchResultEvent e) {
    if (e instanceof TaggedObjectSearchResultEvent && ((TaggedObjectSearchResultEvent) e)
        .isCleanup()) {
      return;
    }
    state = null;
    Display.getDefault().asyncExec(() -> {
      WorkbenchUtil.bringPartToFront(searchViewPart);
      searchViewPart.updateLabel();
      final IAbapProjectProvider projectProvider = searchQuery.getProjectProvider();
      if (projectProvider != this.projectProvider) {
        this.projectProvider = projectProvider;
      }
      resultTreeViewer.setInput(e.getSearchResult());
      updateUiState();
    });

  }

  @Override
  public TaggedObjectSearchQuery getSearchQuery() {
    return result != null ? (TaggedObjectSearchQuery) result.getQuery() : null;
  }

  @Override
  public String getSearchPageId() {
    return TaggedObjectSearchPage.PAGE_ID;
  }

  private void initializeActions() {
    collapseAllNodesAction = new CollapseAllTreeNodesAction(resultTreeViewer);
    collapseNodesAction = new CollapseTreeNodesAction(resultTreeViewer);
    copyToClipBoardAction = new CopyToClipboardAction();
    copyToClipBoardAction.registerViewer(resultTreeViewer);
    openPreferencesAction = new OpenTaggedObjectSearchPreferences();
    openColorPrefPageAction = new OpenColorPreferencePageAction();
    openColorPrefPageAction.setColorId(IColorConstants.COMP_PARENT_COLOR);
    openColorPrefPageAction.setCategories(IColorConstants.COLOR_NAMESPACE);
  }

  private void hookContextMenu() {
    final MenuManager menuMgr = new MenuManager();
    menuMgr.setRemoveAllWhenShown(true);

    menuMgr.addMenuListener(menu -> {
      fillContextMenu(menu);
    });
    final Control viewerControl = resultTree;
    final Menu menu = menuMgr.createContextMenu(viewerControl);
    viewerControl.setMenu(menu);
    getSite().registerContextMenu(searchViewPart.getViewSite().getId(), menuMgr, resultTreeViewer);
  }

  private void fillContextMenu(final IMenuManager menu) {
    final IStructuredSelection selection = resultTreeViewer.getStructuredSelection();
    if (selection == null || selection.isEmpty()) {
      return;
    }
    menu.add(new Separator(IContextMenuConstants.GROUP_NEW));
    menu.add(new Separator(IContextMenuConstants.GROUP_OPEN));
    menu.add(new Separator(IContextMenuConstants.GROUP_EDIT));
    menu.add(new Separator(IContextMenuConstants.GROUP_SEARCH));

    boolean selectionHasExpandedNodes = false;
    final List<IAdtObjectReference> adtObjRefs = new ArrayList<>();
    final List<IAdtObjectReference> previewAdtObjRefs = new ArrayList<>();
    final List<IAdtObjectReference> executableAdtObjRefs = new ArrayList<>();

    for (final Object selectedObject : selection.toList()) {
      if (selectedObject instanceof IAdtObjectReferenceNode) {
        final IAdtObjectReferenceNode objRefNode = (IAdtObjectReferenceNode) selectedObject;
        final IAdtObjectReference adtObjectRef = objRefNode.getObjectReference();
        if (objRefNode.supportsDataPreview()) {
          previewAdtObjRefs.add(adtObjectRef);
        }
        if (executableObjectTypes.contains(objRefNode.getAdtObjectType())) {
          executableAdtObjRefs.add(adtObjectRef);
        }
        adtObjRefs.add(adtObjectRef);
      }

      if (!selectionHasExpandedNodes && selectedObject instanceof ICollectionTreeNode
          && resultTreeViewer.getExpandedState(selectedObject)) {
        selectionHasExpandedNodes = true;
      }
    }

    if (!adtObjRefs.isEmpty()) {
      menu.appendToGroup(IContextMenuConstants.GROUP_OPEN, new OpenAdtObjectAction(projectProvider
          .getProject(), adtObjRefs));
    }

    if (!adtObjRefs.isEmpty()) {
      menu.appendToGroup(IContextMenuConstants.GROUP_SEARCH, CommandFactory.createContribItemById(
          IGeneralCommandConstants.WHERE_USED_IN, true, null));

    }

    if (selectionHasExpandedNodes) {
      menu.add(collapseNodesAction);
    }

    menu.appendToGroup(IContextMenuConstants.GROUP_EDIT, copyToClipBoardAction);
  }

  /*
   * Creates the result tree of the object search
   */
  private void createResultTree(final Composite parent) {

    resultTreeViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    resultTree = resultTreeViewer.getTree();
    resultTreeViewer.setContentProvider(new TreeContentProvider());
    resultTreeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(
        new ViewLabelProvider()));
    resultTreeViewer.addOpenListener(event -> {
      final ITreeSelection sel = (ITreeSelection) event.getSelection();
      final Iterator<?> selIter = sel.iterator();
      while (selIter.hasNext()) {
        handleOpenOnTreeNode(selIter.next());
      }
    });
  }

  private void handleOpenOnTreeNode(final Object node) {
    if (node == null) {
      return;
    }
    if (node instanceof IAdtObjectReferenceNode) {
      final IAdtObjectReferenceNode selectedAdtObject = (IAdtObjectReferenceNode) node;

      if (selectedAdtObject != null) {
        searchQuery.getProjectProvider()
            .openObjectReference(selectedAdtObject.getObjectReference());
      }
    } else if (node instanceof ICollectionTreeNode) {
      final boolean isExpanded = resultTreeViewer.getExpandedState(node);
      if (isExpanded) {
        resultTreeViewer.collapseToLevel(node, 1);
      } else {
        resultTreeViewer.expandToLevel(node, 1);
      }
    } else if (node instanceof ActionTreeNode) {
      ((ActionTreeNode) node).getAction().execute();
    }
  }

  private void updateUiState() {
    Display.getDefault().asyncExec(() -> {
      if (resultTreeViewer == null || resultTreeViewer.getControl().isDisposed()) {
        return;
      }
      if (state != null) {
        resultTreeViewer.getControl().setRedraw(false);
        try {
          resultTreeViewer.setExpandedTreePaths(state.getExpandedPaths());
        } finally {
          resultTreeViewer.getControl().setRedraw(true);
        }
      }
      resultTreeViewer.getControl().setFocus();
      final IAdtObjectReferenceNode[] result = this.result.getResultForTree(false);
      if (result != null && result.length > 0) {
        if (state != null && state.hasSelection()) {
          resultTreeViewer.setSelection(state.getSelection());
        } else {
          resultTreeViewer.setSelection(new StructuredSelection(result[0]));
        }
      }
      resultTreeViewer.refresh();
    });
  }

  private class TreeContentProvider extends LazyLoadingTreeContentProvider {
    @Override
    public Object[] getElements(final Object inputElement) {
      if (result != null) {
        return result.getResultForTree(false);
      }
      return new Object[0];
    }
  }

  /**
   * Custom view label provider for the Result Tree
   *
   * @author stockbal
   */
  private class ViewLabelProvider extends LabelProvider implements ILabelProvider,
      IStyledLabelProvider {

    @Override
    public String getText(final Object element) {
      final ITreeNode resultNode = (ITreeNode) element;
      return resultNode.getName();
    }

    @Override
    public Image getImage(final Object element) {
      Image image;
      final ITreeNode resultNode = (ITreeNode) element;
      image = resultNode.getImage();
      if (image == null && element instanceof IAdtObjectReferenceNode) {
        var adtObjRef = ((IAdtObjectReferenceNode) element).getObjectReference();
        var type = adtObjRef.getType();

        if (IAdtObjectTypeConstants.LOCAL_CLASS.equals(type)) {
          image = ImageUtil.getLocalClassImage();
        } else if (IAdtObjectTypeConstants.LOCAL_INTERFACE.equals(type)) {
          image = ImageUtil.getLocalInterfaceImage();
        } else {
          image = adtObjRef != null ? AdtTypeUtil.getInstance().getTypeImage(adtObjRef.getType())
              : null;
        }
      }
      return image;
    }

    @Override
    public StyledString getStyledText(final Object element) {
      StyledString text = new StyledString();
      final ITreeNode resultNode = (ITreeNode) element;

      if (element instanceof IStyledTreeNode) {
        text = ((IStyledTreeNode) element).getStyledText();
        if (text == null) {
          text = new StyledString();
        }
      } else {
        if (element instanceof LoadingTreeItemsNode) {
          text.append(resultNode.getDisplayName(), StylerFactory.ITALIC_STYLER);
        } else if (element instanceof IAdtObjectReferenceNode) {
          setObjectRefNodeText((IAdtObjectReferenceNode) element, text);
        }
      }

      return text;
    }

    private void setObjectRefNodeText(final IAdtObjectReferenceNode adtObjRefNode,
        final StyledString text) {
      text.append(adtObjRefNode.getDisplayName());
      if (prefStore.getBoolean(ITaggedObjectSearchPrefs.DISPLAY_OBJECT_TYPES)) {
        var type = adtObjRefNode.getAdtObjectType();
        if (type != null) {
          String typeLabel = null;
          if (type.equals(IAdtObjectTypeConstants.LOCAL_CLASS)) {
            typeLabel = Messages.TypeLabels_LocalClass_xlbl;
          } else if (type.equals(IAdtObjectTypeConstants.LOCAL_INTERFACE)) {
            typeLabel = Messages.TypeLabels_LocalInterface_xlbl;
          } else {
            typeLabel = AdtTypeUtil.getInstance().getTypeDescription(type);
            if (typeLabel == null) {
              var projectProvider = adtObjRefNode.getAdapter(IProjectProvider.class);
              if (projectProvider != null) {
                typeLabel = AdtTypeUtil.getInstance()
                    .getTypeDescriptionByProject(adtObjRefNode.getAdtObjectType(), projectProvider
                        .getProject());
              }
            }
          }
          if (typeLabel != null) {
            text.append(String.format(" (%s)", typeLabel), StyledString.QUALIFIER_STYLER);
          }
        }
      }

      var parentName = adtObjRefNode.getPropertyValue(
          ITaggedObjectPropertyNameConstants.ADT_OBJECT_PARENT_NAME);
      if (parentName != null) {
        text.append(" [" + parentName + "]", StylerFactory.createCustomStyler(SWT.NORMAL,
            IColorConstants.COMP_PARENT_COLOR, null));
      }
      if (prefStore.getBoolean(ITaggedObjectSearchPrefs.DISPLAY_PACKAGES) && !adtObjRefNode
          .getAdtObjectType()
          .startsWith(ITadirTypeConstants.PACKAGE) && !StringUtil.isEmpty(adtObjRefNode
              .getObjectReference()
              .getPackageName())) {
        text.append(" - ");
        text.append(adtObjRefNode.getObjectReference().getPackageName(),
            StyledString.QUALIFIER_STYLER);
      }

      if (prefStore.getBoolean(ITaggedObjectSearchPrefs.DISPLAY_DESCRIPTIONS)) {
        final String description = adtObjRefNode.getDescription();
        if (!StringUtil.isEmpty(description)) {
          text.append("  " + description, //$NON-NLS-1$
              StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR,
                  null));
        }
      }

    }
  }
}
