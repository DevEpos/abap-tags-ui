package com.devepos.adt.abaptags.ui.internal.wizard;

import java.util.function.Consumer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.swt.widgets.Display;

import com.devepos.adt.abaptags.ITagPreviewInfo;
import com.devepos.adt.abaptags.tagging.service.AdtObjTaggingServiceFactory;
import com.devepos.adt.abaptags.tagging.service.IAdtObjTaggingService;
import com.devepos.adt.abaptags.ui.internal.messages.Messages;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRefList;

public class TagPreviewLoadingJob extends Job {
	private ITagPreviewInfo previewInfo;
	private final String destinationId;
	private final IAdtObjRefList adtObjRefList;

	public TagPreviewLoadingJob(final String destinationId, final IAdtObjRefList adtObjRefList) {
		super(Messages.TagPreviewLoadingJob_JobTitle_xmsg);
		setSystem(true);
		this.destinationId = destinationId;
		this.adtObjRefList = adtObjRefList;
	}

	public ITagPreviewInfo getPreviewInfo() {
		return this.previewInfo;
	}

	public void addJobDoneListener(final Consumer<IJobChangeEvent> doneListener, final boolean runInUI) {
		addJobChangeListener(new JobChangeAdapter() {
			@Override
			public void done(final IJobChangeEvent event) {
				if (runInUI) {
					Display.getDefault().asyncExec(() -> {
						doneListener.accept(event);
					});
				} else {
					doneListener.accept(event);
				}
			}
		});
	}

	@Override
	protected IStatus run(final IProgressMonitor monitor) {

		final IAdtObjTaggingService taggingService = AdtObjTaggingServiceFactory.createTaggingService();

		// read current tags from project
		try {
			this.previewInfo = taggingService.getInformationForTagging(this.destinationId, this.adtObjRefList);
			return Status.OK_STATUS;
		} catch (final CoreException e) {
			return e.getStatus();
		}
	}

}
