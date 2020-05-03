package com.devepos.adt.abaptags.ui.internal.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.devepos.adt.abaptags.ITagPreviewInfo;
import com.devepos.adt.abaptags.ui.internal.messages.Messages;
import com.devepos.adt.abaptags.ui.internal.wizard.TagObjectsWizard;
import com.devepos.adt.abaptags.ui.internal.wizard.TagPreviewLoadingJob;
import com.devepos.adt.tools.base.adtobject.IAdtObject;
import com.devepos.adt.tools.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.tools.base.util.AdtUtil;

public class AddTagsToSelectedObjectsHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<IAdtObject> selectedObjects = AdtUtil.getAdtObjectsFromSelection(false);
		if (selectedObjects == null || selectedObjects.isEmpty()) {
			return null;
		}

		schedulePreviewRetrievalJob(selectedObjects, HandlerUtil.getActiveShell(event));
		return null;
	}

	private void schedulePreviewRetrievalJob(final List<IAdtObject> selectedObjects, final Shell shell) {
		final IProject project = selectedObjects.get(0).getProject();
		final String destinationId = AdtUtil.getDestinationId(project);
		final IAdtObjRefList adtObjRefList = IAdtBaseFactory.eINSTANCE.createAdtObjRefList();
		for (final IAdtObject adtObj : selectedObjects) {
			final IAdtObjRef adtObjRef = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
			adtObjRef.setUri(adtObj.getReference().getUri());
			adtObjRefList.getObjectReferences().add(adtObjRef);
		}

		final TagPreviewLoadingJob job = new TagPreviewLoadingJob(destinationId, adtObjRefList);
		job.addJobDoneListener(e -> {
			if (e.getResult().isOK()) {
				final ITagPreviewInfo previewInfo = job.getPreviewInfo();
				if (previewInfo.getTags().size() == 0) {
					showMessage(shell, Messages.General_TagsTitle_TagsTitle,
						Messages.TaggingObjectWizard_NoTagsAvailableMessage_xmsg);
					return;
				}
				final TagObjectsWizard wizard = new TagObjectsWizard(true);
				wizard.setProject(project);
				wizard.setCurrentTagPreviewInfo(previewInfo);
				final WizardDialog dialog = new WizardDialog(shell, wizard);
				dialog.open();
			} else {
				showMessage(shell, Messages.TaggingObjectWizard_TagsServiceError_xtit, e.getResult().getMessage());
			}
		}, true);
		job.schedule();
	}

	private void showMessage(final Shell shell, final String title, final String message) {
		final MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR);
		mb.setMessage(message);
		mb.setText(title);
		mb.open();
	}
}
