package com.devepos.adt.atm.ui.internal.search;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.part.Page;

import com.devepos.adt.tools.base.project.IAbapProjectProvider;
import com.devepos.adt.tools.base.ui.UIState;

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
		GridDataFactory.fillDefaults().applyTo(this.mainComposite);
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
//			// clean up old search
			this.result.removeListener(this);
//			this.resultTreeViewer.setInput(null);
		}
		this.result = (TaggedObjectSearchResult) search;
		if (this.result != null) {
			this.result.addListener(this);
//			this.resultTreeViewer.setInput(this.result);
//			this.state = uiState instanceof UIState ? (UIState) uiState : null;
			this.searchQuery = (TaggedObjectSearchQuery) this.result.getQuery();
//			this.projectProvider = this.searchQuery.getProjectProvider();
////			checkFeatureAvailibility();
//			if (!NewSearchUI.isQueryRunning(this.searchQuery)) {
////				updateUiState();
//			}
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
		// TODO Auto-generated method stub

	}

	@Override
	public void saveState(final IMemento memento) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

}
