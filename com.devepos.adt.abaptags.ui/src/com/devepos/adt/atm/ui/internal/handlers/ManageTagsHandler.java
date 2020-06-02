package com.devepos.adt.atm.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.atm.ui.internal.dialogs.TagManagerDialog;

public class ManageTagsHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final boolean globalTags = Boolean.parseBoolean(event.getParameter("com.devepos.adt.atm.ui.commandParams.globalTags")); //$NON-NLS-1$
		// get current project via dialog
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		new TagManagerDialog(window.getShell(), globalTags, null).open();

		return null;
	}

}
