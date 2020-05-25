package com.devepos.adt.abaptags.ui.internal.search;

import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;

public class TaggedObjectSearchResultPage extends Page implements ISearchResultPage {
	private String id;
	private ISearchResultViewPart searchViewPart;
	private Tree resultTree;

	@Override
	public IPageSite getSite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createControl(final Composite parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public Control getControl() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInput(final ISearchResult search, final Object uiState) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return null;
	}

}
