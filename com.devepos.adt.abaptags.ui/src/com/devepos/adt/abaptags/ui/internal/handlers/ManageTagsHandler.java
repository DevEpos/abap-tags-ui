package com.devepos.adt.abaptags.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.abaptags.ui.internal.dialogs.TagManagerDialog;

public class ManageTagsHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final boolean globalTags = Boolean
			.parseBoolean(event.getParameter("com.devepos.adt.abaptags.ui.commandParams.globalTags"));
		// get current project via dialog
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		new TagManagerDialog(window.getShell(), globalTags, null).open();

//		final IAbapTagsService tagsService = AbapTagsServiceFactory.createTagsService();
//		final IProject project = AbapProjectSelectionDialog.open(window.getShell(), null);
//		if (project != null) {
//			final String destinationId = AdtUtil.getDestinationId(project);
//			AbapProjectProviderAccessor.getProviderForDestination(destinationId);
//
//			// dummy logic to pass some tags to backend
//			final IAbapTagsFactory factory = IAbapTagsFactory.eINSTANCE;
//			final ITags tags = factory.createTags();
//			final ITag costing = factory.createTag();
//			costing.setName("Costing");
//			costing.setIsRoot(true);
//			tags.getTags().add(costing);
//
//			final ITag productCosting = factory.createTag();
//			productCosting.setName("Product Costing");
//			costing.getChildTag().add(productCosting);
//			tagsService.createTags(tags, destinationId, globalTags);
//		}
		return null;
	}

}
