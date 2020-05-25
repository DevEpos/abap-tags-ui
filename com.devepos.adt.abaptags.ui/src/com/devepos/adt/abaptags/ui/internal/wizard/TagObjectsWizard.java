package com.devepos.adt.abaptags.ui.internal.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;

import com.devepos.adt.abaptags.IAbapTagsFactory;
import com.devepos.adt.abaptags.ITag;
import com.devepos.adt.abaptags.ITagPreviewInfo;
import com.devepos.adt.abaptags.ITaggedObjectList;
import com.devepos.adt.abaptags.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.abaptags.ui.AbapTagsUIPlugin;
import com.devepos.adt.abaptags.ui.internal.messages.Messages;
import com.devepos.adt.abaptags.ui.internal.util.IImages;
import com.devepos.adt.tools.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.tools.base.util.AdtUtil;
import com.devepos.adt.tools.base.wizard.IBaseWizardPage;

/**
 * Wizard for managing the tags of one or several ADT Objects
 *
 * @author stockbal
 */
public class TagObjectsWizard extends Wizard implements ITagObjectsWizard {

	private final ITaggedObjectList taggedObjectList = IAbapTagsFactory.eINSTANCE.createTaggedObjectList();
	private IAdtObjRefList selectedAdtObjRefList = IAdtBaseFactory.eINSTANCE.createAdtObjRefList();
	private ITagPreviewInfo tagPreviewInfo = IAbapTagsFactory.eINSTANCE.createTagPreviewInfo();
	private IProject project;
	private boolean canFinish;
	private final boolean skipObjectSelection;
	private List<ITag> selectedTags;

	public TagObjectsWizard() {
		this(false);
	}

	public TagObjectsWizard(final boolean skipObjectSelection) {
		setDefaultPageImageDescriptor(AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.TAGS_WIZBAN_DEFAULT));
		setWindowTitle(Messages.TagObjectsWizard_WizardTitle_xtit);
		setNeedsProgressMonitor(true);
		this.skipObjectSelection = skipObjectSelection;
	}

	@Override
	public void addPages() {
		if (!this.skipObjectSelection) {
			addObjectSelectionPage();
		}
		addTagSelectionPage();
		addParentObjectSelectionPage();
	}

	@Override
	public void createPageControls(final Composite pageContainer) {
		/*
		 * page controls will be initialized on demand. This ensures that the wizard
		 * dialog will not be unnecessarily big at initial open due to some pages
		 * needing more space
		 */
	}

	@Override
	public boolean performFinish() {
		if (this.project == null) {
			return false;
		}
		// complete current page
		final IWizardPage currentPage = getContainer().getCurrentPage();
		if (currentPage != null && currentPage instanceof IBaseWizardPage) {
			((IBaseWizardPage) currentPage).completePage();
		}
		try {
			getContainer().run(true, false, monitor -> {
				monitor.beginTask(Messages.TagObjectsWizard_AddTagsToObjectsJob_xmsg, -1);
				try {
					AdtObjTaggingServiceFactory.createTaggingService()
						.saveTaggedObjects(AdtUtil.getDestinationId(this.project), this.taggedObjectList);
				} catch (final CoreException e) {
					e.printStackTrace();
				}
			});
		} catch (final InvocationTargetException e) {
			if (e.getTargetException() instanceof RuntimeException) {
				throw (RuntimeException) e.getTargetException();
			}
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean canFinish() {
		return this.canFinish;
	}

	@Override
	public void setCanFinish(final boolean canFinish) {
		this.canFinish = canFinish;
	}

	@Override
	public void completePreviousPage(final IBaseWizardPage page) {
		final IWizardPage prev = page.getPreviousPage();
		if (prev == null || !(prev instanceof IBaseWizardPage)) {
			return;
		}
		final IBaseWizardPage previousPage = (IBaseWizardPage) prev;

		if (previousPage.isDirty()) {
			previousPage.completePage();
		}
	}

	@Override
	public boolean isPreviousPageDirty(final IBaseWizardPage page) {
		final IWizardPage prev = page.getPreviousPage();
		if (prev == null || !(prev instanceof IBaseWizardPage)) {
			return false;
		}
		return ((IBaseWizardPage) prev).isDirty();
	}

	@Override
	public void clearTaggedObjects() {
		this.taggedObjectList.getTaggedObjects().clear();
	}

	@Override
	public IAdtObjRefList getSelectedObjects() {
		return this.selectedAdtObjRefList;
	}

	@Override
	public void setSelectedObjects(final IAdtObjRefList selectedObjects) {
		if (selectedObjects == null) {
			this.selectedAdtObjRefList.getObjectReferences().clear();
		} else {
			this.selectedAdtObjRefList = selectedObjects;
		}

	}

	@Override
	public ITaggedObjectList getTaggedObjectList() {
		return this.taggedObjectList;
	}

	@Override
	public ITagPreviewInfo getCurrentTagPreviewInfo() {
		return this.tagPreviewInfo;
	}

	@Override
	public void setCurrentTagPreviewInfo(final ITagPreviewInfo tagPreviewInfo) {
		if (tagPreviewInfo != null) {
			this.tagPreviewInfo = tagPreviewInfo;
		} else {
			this.tagPreviewInfo.getTags().clear();
			this.tagPreviewInfo.getAdtObjectRefs().clear();
		}
	}

	@Override
	public IProject getProject() {
		return this.project;
	}

	@Override
	public void setProject(final IProject project) {
		this.project = project;
	}

	@Override
	public void setSelectedTags(final List<ITag> tags) {
		this.selectedTags = tags;

	}

	@Override
	public List<ITag> getSelectedTags() {
		if (this.selectedTags == null) {
			this.selectedTags = new ArrayList<>();
		}
		return this.selectedTags;
	}

	private void addTagSelectionPage() {
		final IWizardPage page = new TagSelectionWizardPage();
		addPage(page);
	}

	private void addObjectSelectionPage() {
		final IWizardPage page = new TaggableObjectSelectionWizardPage();
		addPage(page);
	}

	private void addParentObjectSelectionPage() {
		final IWizardPage page = new TagParentObjectSelectionWizardPage();
		addPage(page);
	}
}