package com.devepos.adt.atm.ui.internal.search;

import java.util.Iterator;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.search.internal.ui.SearchPlugin;
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
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.Page;

import com.devepos.adt.tools.base.adtobject.AdtTypeUtil;
import com.devepos.adt.tools.base.project.IAbapProjectProvider;
import com.devepos.adt.tools.base.ui.StylerFactory;
import com.devepos.adt.tools.base.ui.UIState;
import com.devepos.adt.tools.base.ui.tree.ActionTreeNode;
import com.devepos.adt.tools.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.tools.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.tools.base.ui.tree.IStyledTreeNode;
import com.devepos.adt.tools.base.ui.tree.ITreeNode;
import com.devepos.adt.tools.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.tools.base.ui.tree.LoadingTreeItemsNode;
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

	@Override
	public void createControl(final Composite parent) {
		this.mainComposite = new Composite(parent, SWT.NONE);
		this.mainComposite.setLayout(new FillLayout());
		this.mainComposite.setSize(100, 100);
		GridDataFactory.fillDefaults().applyTo(this.mainComposite);

		createResultTree(this.mainComposite);

		getSite().setSelectionProvider(this.resultTreeViewer);
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public Control getControl() {
		return this.mainComposite;
	}

	@Override
	public void setActionBars(final IActionBars actionBars) {
		// TODO Auto-generated method stub

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
//			checkFeatureAvailibility();
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
			if (activeSearchPage != null && this.searchViewPart != null && activeSearchPage.isPartVisible(this.searchViewPart)) {
				activeSearchPage.bringToTop(this.searchViewPart);
			}
			this.searchViewPart.updateLabel();
			final IAbapProjectProvider projectProvider = this.searchQuery.getProjectProvider();
			if (projectProvider != this.projectProvider) {
				this.projectProvider = projectProvider;
//				checkFeatureAvailibility();
			}
			this.resultTreeViewer.setInput(e.getSearchResult());
//			if (this.groupByPackageAction.isChecked()) {
//				expandAllPackages();
//			}
			updateUiState();
		});

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
	class ViewLabelProvider extends LabelProvider implements ILabelProvider, IStyledLabelProvider {

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

				if (element instanceof ICollectionTreeNode) {
					final ICollectionTreeNode collectionNode = (ICollectionTreeNode) element;
					if (collectionNode.hasChildren()) {
						final String size = ((ICollectionTreeNode) element).getSizeAsString();
						if (size != null) {
							text.append(" (" + size + ")", StyledString.COUNTER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				}

				final String description = searchResult.getDescription();
				if (description != null && !description.isEmpty()) {
					text.append("  " + description + "  ", //$NON-NLS-1$ //$NON-NLS-2$
						StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR, null));
				}
			}

			return text;
		}
	}
}
