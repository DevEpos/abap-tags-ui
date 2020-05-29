package com.devepos.adt.atm.ui.internal.search;

import org.eclipse.jface.action.Action;
import org.eclipse.search.internal.ui.SearchDialog;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search2.internal.ui.SearchView;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.tools.base.AdtToolsBaseResources;
import com.devepos.adt.tools.base.IAdtToolsBaseImages;

public class OpenInSearchDialogAction extends Action {
	public OpenInSearchDialogAction() {
		super(Messages.OpenInSearchDialogAction_Label_xmit, AdtToolsBaseResources.getImageDescriptor(IAdtToolsBaseImages.SEARCH));
	}

	@Override
	public void run() {
		final SearchView activeSearchView = getSearchView();
		if (activeSearchView == null) {
			return;
		}
		final ISearchResultPage resultPage = activeSearchView.getActivePage();
		if (resultPage != null && resultPage instanceof TaggedObjectSearchResultPage) {
			final TaggedObjectSearchResultPage objectSearchResultPage = (TaggedObjectSearchResultPage) resultPage;
			final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			final SearchDialog dialog = new SearchDialog(window, TaggedObjectSearchPage.PAGE_ID);
			dialog.setBlockOnOpen(false);
			dialog.open();
			dialog.setBlockOnOpen(true);
		}
	}

	protected SearchView getSearchView() {

		final IWorkbenchPart activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		if (activePart instanceof SearchView) {
			return (SearchView) activePart;
		}
		return null;
	}

}
