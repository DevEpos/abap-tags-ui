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
import org.eclipse.search.internal.ui.SearchPlugin;
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
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.Page;

import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.help.HelpContexts;
import com.devepos.adt.atm.ui.internal.help.HelpUtil;
import com.devepos.adt.atm.ui.internal.preferences.ITaggedObjectSearchPrefs;
import com.devepos.adt.tools.base.ui.AdtToolsBaseUIResources;
import com.devepos.adt.tools.base.ui.IAdtToolsBaseImages;
import com.devepos.adt.tools.base.ui.IAdtToolsBaseStrings;
import com.devepos.adt.tools.base.ui.StylerFactory;
import com.devepos.adt.tools.base.ui.UIState;
import com.devepos.adt.tools.base.ui.action.CollapseAllTreeNodesAction;
import com.devepos.adt.tools.base.ui.action.CollapseTreeNodesAction;
import com.devepos.adt.tools.base.ui.action.CopyToClipboardAction;
import com.devepos.adt.tools.base.ui.action.ExecuteAdtObjectAction;
import com.devepos.adt.tools.base.ui.action.OpenAdtObjectAction;
import com.devepos.adt.tools.base.ui.menu.MenuItemFactory;
import com.devepos.adt.tools.base.ui.project.IAbapProjectProvider;
import com.devepos.adt.tools.base.ui.tree.ActionTreeNode;
import com.devepos.adt.tools.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.tools.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.tools.base.ui.tree.IStyledTreeNode;
import com.devepos.adt.tools.base.ui.tree.ITreeNode;
import com.devepos.adt.tools.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.tools.base.ui.tree.LoadingTreeItemsNode;
import com.devepos.adt.tools.base.ui.util.AdtTypeUtil;
import com.devepos.adt.tools.base.util.StringUtil;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

public class TaggedObjectSearchResultPage extends Page implements ISearchResultPage, ISearchResultListener {
	private String id;
	private ISearchResultViewPart searchViewPart;
	private Tree resultTree;
	private TreeViewer resultTreeViewer;
	private TaggedObjectSearchResult result;
	private UIState state;
	private Composite mainComposite;
	private TaggedObjectSearchQuery searchQuery;
	private IAbapProjectProvider projectProvider;
	private CollapseAllTreeNodesAction collapseAllNodesAction;
	private CollapseTreeNodesAction collapseNodesAction;
	private CopyToClipboardAction copyToClipBoardAction;
	private OpenTaggedObjectSearchPreferences openPreferencesAction;
	private OpenInSearchDialogAction openInSearchDialog;
	private IPropertyChangeListener prefStoreListener;
	private IPreferenceStore prefStore;
	private final List<String> executableObjectTypes;

	public TaggedObjectSearchResultPage() {
		this.executableObjectTypes = Stream
			.of("CLAS/OC", "PROG/P", "TRAN/T", "FUGR/FF", "WAPA/WO", "WDYA/YY", "WDCA/YA")
			.collect(Collectors.toList());
	}

	@Override
	public void createControl(final Composite parent) {
		this.mainComposite = new Composite(parent, SWT.NONE);
		HelpUtil.setHelp(this.mainComposite, HelpContexts.TAG_SEARCH);
		this.mainComposite.setLayout(new FillLayout());
		this.mainComposite.setSize(100, 100);
		GridDataFactory.fillDefaults().applyTo(this.mainComposite);

		createResultTree(this.mainComposite);

		initializeActions();
		hookContextMenu();

		this.prefStoreListener = e -> {
			if (this.resultTree == null || this.resultTree.isDisposed()) {
				return;
			}
			if (e.getProperty().equals(ITaggedObjectSearchPrefs.DISPLAY_DESCRIPTIONS)
				|| e.getProperty().equals(ITaggedObjectSearchPrefs.DISPLAY_PACKAGES)
				|| e.getProperty().equals(ITaggedObjectSearchPrefs.DISPLAY_OBJECT_TYPES)) {

				this.resultTreeViewer.refresh();
			}
		};
		this.prefStore = AbapTagsUIPlugin.getDefault().getPreferenceStore();
		this.prefStore.addPropertyChangeListener(this.prefStoreListener);

		getSite().setSelectionProvider(this.resultTreeViewer);
	}

	@Override
	public void dispose() {
		if (this.prefStoreListener != null) {
			this.prefStore.removePropertyChangeListener(this.prefStoreListener);
		}
		super.dispose();
	}

	@Override
	public Control getControl() {
		return this.mainComposite;
	}

	@Override
	public void setActionBars(final IActionBars actionBars) {
		final IToolBarManager tbm = actionBars.getToolBarManager();
		tbm.appendToGroup(IContextMenuConstants.GROUP_NEW, this.openInSearchDialog);
		tbm.appendToGroup(IContextMenuConstants.GROUP_EDIT, this.collapseAllNodesAction);
		this.copyToClipBoardAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_COPY);
		actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), this.copyToClipBoardAction);
		actionBars.updateActionBars();

		actionBars.getMenuManager().add(new ObjectLabelDecorationMenu());
		actionBars.getMenuManager().add(new Separator());
		actionBars.getMenuManager().add(this.openPreferencesAction);

	}

	@Override
	public void setFocus() {
		if (this.resultTree != null && !this.resultTree.isDisposed()) {
			this.resultTree.setFocus();
		}

	}

	@Override
	public Object getUIState() {
		if (this.resultTree != null && !this.resultTree.isDisposed()) {
			final UIState uiState = new UIState();
			uiState.setExpandedPaths(this.resultTreeViewer.getExpandedTreePaths());
			uiState.setSelection(this.resultTreeViewer.getSelection());
			return uiState;
		}
		return null;
	}

	@Override
	public void setInput(final ISearchResult search, final Object uiState) {
		if (this.result != null) {
			// clean up old search
			this.result.removeListener(this);
			this.resultTreeViewer.setInput(null);
		}
		this.result = (TaggedObjectSearchResult) search;
		if (this.result != null) {
			this.result.addListener(this);
			this.resultTreeViewer.setInput(this.result);
			this.state = uiState instanceof UIState ? (UIState) uiState : null;
			this.searchQuery = (TaggedObjectSearchQuery) this.result.getQuery();
			this.projectProvider = this.searchQuery.getProjectProvider();
			if (!NewSearchUI.isQueryRunning(this.searchQuery)) {
				updateUiState();
			}
		} else {
			this.searchViewPart.updateLabel();
		}

	}

	@Override
	public void setViewPart(final ISearchResultViewPart part) {
		this.searchViewPart = part;
	}

	@Override
	public void restoreState(final IMemento memento) {
	}

	@Override
	public void saveState(final IMemento memento) {
	}

	@Override
	public void setID(final String id) {
		this.id = id;
	}

	@Override
	public String getID() {
		return this.id;
	}

	@Override
	public String getLabel() {
		return this.result != null ? this.result.getLabel() : "";
	}

	@Override
	public void searchResultChanged(final SearchResultEvent e) {
		if (e instanceof TaggedObjectSearchResultEvent && ((TaggedObjectSearchResultEvent) e).isCleanup()) {
			return;
		}
		this.state = null;
		Display.getDefault().asyncExec(() -> {
			/*
			 * If there is no active page in the workbench window the search view will not
			 * be brought to the front so it has to be done manually
			 */
			final IWorkbenchPage activeSearchPage = SearchPlugin.getActivePage();
			if (activeSearchPage != null && this.searchViewPart != null
				&& activeSearchPage.isPartVisible(this.searchViewPart)) {
				activeSearchPage.bringToTop(this.searchViewPart);
			}
			this.searchViewPart.updateLabel();
			final IAbapProjectProvider projectProvider = this.searchQuery.getProjectProvider();
			if (projectProvider != this.projectProvider) {
				this.projectProvider = projectProvider;
			}
			this.resultTreeViewer.setInput(e.getSearchResult());
			updateUiState();
		});

	}

	public TaggedObjectSearchQuery getQuery() {
		return this.result != null ? (TaggedObjectSearchQuery) this.result.getQuery() : null;
	}

	private void initializeActions() {
		this.collapseAllNodesAction = new CollapseAllTreeNodesAction(this.resultTreeViewer);
		this.collapseNodesAction = new CollapseTreeNodesAction(this.resultTreeViewer);
		this.copyToClipBoardAction = new CopyToClipboardAction();
		this.copyToClipBoardAction.registerViewer(this.resultTreeViewer);
		this.openPreferencesAction = new OpenTaggedObjectSearchPreferences();
		this.openInSearchDialog = new OpenInSearchDialogAction();
	}

	private void hookContextMenu() {
		final MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);

		menuMgr.addMenuListener(menu -> {
			fillContextMenu(menu);
		});
		final Control viewerControl = this.resultTree;
		final Menu menu = menuMgr.createContextMenu(viewerControl);
		viewerControl.setMenu(menu);
		getSite().registerContextMenu(this.searchViewPart.getViewSite().getId(), menuMgr, this.resultTreeViewer);
	}

	private void fillContextMenu(final IMenuManager menu) {
		final IStructuredSelection selection = this.resultTreeViewer.getStructuredSelection();
		if (selection == null || selection.isEmpty()) {
			return;
		}
		menu.add(new Separator(IContextMenuConstants.GROUP_NEW));
		menu.add(new Separator(IContextMenuConstants.GROUP_OPEN));

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
				if (this.executableObjectTypes.contains(objRefNode.getAdtObjectType())) {
					executableAdtObjRefs.add(adtObjectRef);
				}
				adtObjRefs.add(adtObjectRef);
			}

			if (!selectionHasExpandedNodes && selectedObject instanceof ICollectionTreeNode
				&& this.resultTreeViewer.getExpandedState(selectedObject)) {
				selectionHasExpandedNodes = true;
			}
		}

		if (!adtObjRefs.isEmpty()) {
			menu.appendToGroup(IContextMenuConstants.GROUP_OPEN,
				new OpenAdtObjectAction(this.projectProvider.getProject(), adtObjRefs));
		}
		if (!previewAdtObjRefs.isEmpty()) {
			menu.appendToGroup(IContextMenuConstants.GROUP_OPEN,
				new ExecuteAdtObjectAction(this.projectProvider.getProject(), previewAdtObjRefs, true));
		}
		if (!executableAdtObjRefs.isEmpty()) {
			menu.appendToGroup(IContextMenuConstants.GROUP_OPEN,
				new ExecuteAdtObjectAction(this.projectProvider.getProject(), executableAdtObjRefs, false));
		}

		if (!adtObjRefs.isEmpty()) {
			menu.add(new Separator(IContextMenuConstants.GROUP_ADDITIONS));
			MenuItemFactory.addCommandItem(menu, IContextMenuConstants.GROUP_ADDITIONS,
				"com.sap.adt.ris.whereused.ui.callWhereUsed", //$NON-NLS-1$
				AdtToolsBaseUIResources.getImageDescriptor(IAdtToolsBaseImages.WHERE_USED_LIST),
				AdtToolsBaseUIResources.getString(IAdtToolsBaseStrings.General_WhereUsedList_xmit), null);
		}

		if (selectionHasExpandedNodes) {
			if (selectionHasExpandedNodes) {
				menu.add(this.collapseNodesAction);
			}
		}

		menu.add(new Separator(IContextMenuConstants.GROUP_EDIT));
		menu.appendToGroup(IContextMenuConstants.GROUP_EDIT, this.copyToClipBoardAction);
	}

	/*
	 * Creates the result tree of the object search
	 */
	private void createResultTree(final Composite parent) {

		this.resultTreeViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		this.resultTree = this.resultTreeViewer.getTree();
		this.resultTreeViewer.setContentProvider(new TreeContentProvider());
		this.resultTreeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new ViewLabelProvider()));
		this.resultTreeViewer.addOpenListener(event -> {
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
				this.searchQuery.getProjectProvider().openObjectReference(selectedAdtObject.getObjectReference());
			}
		} else if (node instanceof ICollectionTreeNode) {
			final boolean isExpanded = this.resultTreeViewer.getExpandedState(node);
			if (isExpanded) {
				this.resultTreeViewer.collapseToLevel(node, 1);
			} else {
				this.resultTreeViewer.expandToLevel(node, 1);
			}
		} else if (node instanceof ActionTreeNode) {
			((ActionTreeNode) node).getAction().execute();
		}
	}

	private void updateUiState() {
		Display.getDefault().asyncExec(() -> {
			if (this.resultTreeViewer == null || this.resultTreeViewer.getControl().isDisposed()) {
				return;
			}
			if (this.state != null) {
				this.resultTreeViewer.getControl().setRedraw(false);
				try {
					this.resultTreeViewer.setExpandedTreePaths(this.state.getExpandedPaths());
				} finally {
					this.resultTreeViewer.getControl().setRedraw(true);
				}
			}
			this.resultTreeViewer.getControl().setFocus();
			final IAdtObjectReferenceNode[] result = this.result.getResultForTree(false);
			if (result != null && result.length > 0) {
				if (this.state != null && this.state.hasSelection()) {
					this.resultTreeViewer.setSelection(this.state.getSelection());
				} else {
					this.resultTreeViewer.setSelection(new StructuredSelection(result[0]));
				}
			}
			this.resultTreeViewer.refresh();
		});
	}

	private class TreeContentProvider extends LazyLoadingTreeContentProvider {
		@Override
		public Object[] getElements(final Object inputElement) {
			if (TaggedObjectSearchResultPage.this.result != null) {
				return TaggedObjectSearchResultPage.this.result.getResultForTree(false);
			}
			return new Object[0];
		}
	}

	/**
	 * Custom view label provider for the Result Tree
	 *
	 * @author stockbal
	 */
	private class ViewLabelProvider extends LabelProvider implements ILabelProvider, IStyledLabelProvider {

		@Override
		public String getText(final Object element) {
			final ITreeNode searchResult = (ITreeNode) element;

			return searchResult.getName();
		}

		@Override
		public Image getImage(final Object element) {
			Image image = null;
			final ITreeNode searchResult = (ITreeNode) element;
			image = searchResult.getImage();
			if (image == null) {

				if (element instanceof IAdtObjectReferenceNode) {
					final IAdtObjectReferenceNode adtObjRefNode = (IAdtObjectReferenceNode) element;
					final IAdtObjectReference objRef = adtObjRefNode.getObjectReference();
					image = AdtTypeUtil.getInstance().getTypeImage(objRef.getType());
				}
			}
			return image;
		}

		@Override
		public StyledString getStyledText(final Object element) {
			boolean isAdtObjectRefNode = false;
			StyledString text = new StyledString();
			final ITreeNode searchResult = (ITreeNode) element;

			if (element instanceof IStyledTreeNode) {
				text = ((IStyledTreeNode) element).getStyledText();
				if (text == null) {
					text = new StyledString();
				}
			} else {
				if (element instanceof LoadingTreeItemsNode) {
					text.append(searchResult.getDisplayName(), StylerFactory.ITALIC_STYLER);
					return text;
				} else {
					text.append(searchResult.getDisplayName());
				}

				if (element instanceof IAdtObjectReferenceNode) {
					isAdtObjectRefNode = true;
					final IAdtObjectReferenceNode adtObjRefNode = (IAdtObjectReferenceNode) element;

					if (TaggedObjectSearchResultPage.this.prefStore
						.getBoolean(ITaggedObjectSearchPrefs.DISPLAY_OBJECT_TYPES)) {
						String typeLabel = AdtTypeUtil.getInstance()
							.getTypeDescription(adtObjRefNode.getAdtObjectType());
						if (typeLabel == null) {
							typeLabel = AdtTypeUtil.getInstance()
								.getTypeDescriptionByProject(adtObjRefNode.getAdtObjectType(),
									TaggedObjectSearchResultPage.this.projectProvider.getProject());
						}
						if (typeLabel != null) {
							text.append(" (" + typeLabel + ")", StyledString.QUALIFIER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
					if (TaggedObjectSearchResultPage.this.prefStore
						.getBoolean(ITaggedObjectSearchPrefs.DISPLAY_PACKAGES)
						&& !adtObjRefNode.getAdtObjectType().startsWith("DEVC")) { //$NON-NLS-1$
						if (!StringUtil.isEmpty(adtObjRefNode.getObjectReference().getPackageName())) {
							text.append(" - ");
							text.append(adtObjRefNode.getObjectReference().getPackageName(),
								StyledString.QUALIFIER_STYLER);
						}
					}
				}

				if (element instanceof ICollectionTreeNode && !isAdtObjectRefNode) {
					final ICollectionTreeNode collectionNode = (ICollectionTreeNode) element;
					if (collectionNode.hasChildren()) {
						final String size = ((ICollectionTreeNode) element).getSizeAsString();
						if (size != null) {
							text.append(" (" + size + ")", StyledString.COUNTER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				}

				if (TaggedObjectSearchResultPage.this.prefStore
					.getBoolean(ITaggedObjectSearchPrefs.DISPLAY_DESCRIPTIONS)) {
					final String description = searchResult.getDescription();
					if (!StringUtil.isEmpty(description)) {
						text.append("  " + description, //$NON-NLS-1$
							StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR, null));
					}
				}
			}

			return text;
		}
	}
}
