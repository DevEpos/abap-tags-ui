package com.devepos.adt.atm.ui.internal.handlers;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.tags.IAbapTagsService;
import com.devepos.adt.atm.ui.internal.views.AbapTagExplorerView;
import com.devepos.adt.tools.base.adtobject.IAdtObject;
import com.devepos.adt.tools.base.util.EditorUtil;
import com.devepos.adt.tools.base.util.Logging;

public class ShowInTagExplorerHandler extends AbstractHandler {

	private IAdtObject currentSelectedObject;
	private final IAbapTagsService abapTagsService;

	public ShowInTagExplorerHandler() {
		this.abapTagsService = AbapTagsServiceFactory.createTagsService();
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		AbapTagExplorerView view = null;
		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		try {
			final IViewPart viewPart = page.showView(AbapTagExplorerView.VIEW_ID);
			if (viewPart instanceof AbapTagExplorerView) {
				view = (AbapTagExplorerView) viewPart;
			}
		} catch (final PartInitException e) {
			Logging.getLogger(ShowInTagExplorerHandler.class).error(e);
		}

		if (view != null) {
			view.setInput(this.currentSelectedObject);
		}
		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		this.currentSelectedObject = null;
		final Object selectedObject = getSelectedObject(evaluationContext);
		if (selectedObject != null) {
			if (selectedObject instanceof ITextSelection) {
				this.currentSelectedObject = EditorUtil.getAdtObjectFromActiveEditor();
			} else {
				this.currentSelectedObject = Adapters.adapt(selectedObject, IAdtObject.class);
			}
		}
		if (this.currentSelectedObject != null) {
			final IProject project = this.currentSelectedObject.getProject();
			if (!this.abapTagsService.testTagsFeatureAvailability(project).isOK()) {
				this.currentSelectedObject = null;
			}
		}
		setBaseEnabled(this.currentSelectedObject != null);
	}

	protected Object getSelectedObject(final Object contextOrEvent) {
		if (contextOrEvent instanceof IEvaluationContext) {
			Collection<?> collection;
			final Object defaultVariable = ((IEvaluationContext) contextOrEvent).getDefaultVariable();
			if (defaultVariable instanceof Collection && (collection = (Collection<?>) defaultVariable).size() == 1) {
				final Object[] array = collection.toArray();
				return array[0];
			}
		} else if (contextOrEvent instanceof ExecutionEvent) {
			final IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection((ExecutionEvent) contextOrEvent);
			return selection.getFirstElement();
		}
		return null;
	}

}
