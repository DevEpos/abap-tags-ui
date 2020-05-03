package com.devepos.adt.abaptags.ui.internal.wizard;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import com.devepos.adt.abaptags.IAbapTagsFactory;
import com.devepos.adt.abaptags.ITagPreviewInfo;
import com.devepos.adt.abaptags.ITaggedObjectList;
import com.devepos.adt.abaptags.tagging.service.AdtObjTaggingServiceFactory;
import com.devepos.adt.abaptags.ui.AbapTagsUIPlugin;
import com.devepos.adt.abaptags.ui.internal.messages.Messages;
import com.devepos.adt.abaptags.ui.internal.util.IImages;
import com.devepos.adt.tools.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.tools.base.util.AdtUtil;
import com.devepos.adt.tools.base.wizard.IBaseWizardPage;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Wizard for managing the tags of one or several ADT Objects
 *
 * @author stockbal
 */
public class TagObjectsWizard extends Wizard implements ITagObjectsWizardModel {

	private final ITaggedObjectList taggedObjectList = IAbapTagsFactory.eINSTANCE.createTaggedObjectList();
	private IAdtObjRefList selectedAdtObjRefList = IAdtBaseFactory.eINSTANCE.createAdtObjRefList();
	private ITagPreviewInfo tagPreviewInfo = IAbapTagsFactory.eINSTANCE.createTagPreviewInfo();
	private IProject project;
	private TagWizardStatus status = TagWizardStatus.NONE;
	private boolean canFinish;
	private final boolean skipObjectSelection;

	public TagObjectsWizard() {
		this(false);
	}

	public TagObjectsWizard(final boolean skipObjectSelection) {
		setDefaultPageImageDescriptor(AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.TAGS_WIZBAN_DEFAULT));
		setWindowTitle(Messages.TagObjectsWizard_WizardTitle_xtit);
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
	public boolean performFinish() {
		if (this.project == null) {
			return false;
		}
		try {
			AdtObjTaggingServiceFactory.createTaggingService()
				.saveTaggedObjects(AdtUtil.getDestinationId(this.project), this.taggedObjectList);
		} catch (final CoreException e) {
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
	public void setObjectsFromAdtObjRefs(final List<IAdtObjectReference> adtObjectReferences) {
		this.selectedAdtObjRefList.getObjectReferences().clear();
		for (final IAdtObjectReference objectReference : adtObjectReferences) {
			final IAdtObjRef objRef = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
			objRef.setName(objectReference.getName());
			objRef.setUri(objectReference.getUri());
			objRef.setType(objectReference.getType());
			this.selectedAdtObjRefList.getObjectReferences().add(objRef);
		}
	}

	@Override
	public void setObjectsFromAdtObjRefs(final IAdtObjRefList adtObjRefList) {
		if (adtObjRefList != null) {
			this.selectedAdtObjRefList = adtObjRefList;
		} else {
			this.selectedAdtObjRefList.getObjectReferences().clear();
		}
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
	public void setStatus(final TagWizardStatus status) {
		this.status = status;
	}

	@Override
	public TagWizardStatus getStatus() {
		return this.status;
	}

	@Override
	public IProject getProject() {
		return this.project;
	}

	@Override
	public void setProject(final IProject project) {
		this.project = project;
	}

	private void addTagSelectionPage() {
		final IWizardPage page = new TagSelectionWizardPage(this);
		addPage(page);
	}

	private void addObjectSelectionPage() {
		final IWizardPage page = new TaggableObjectSelectionWizardPage(this);
		addPage(page);
	}

	private void addParentObjectSelectionPage() {
		final IWizardPage page = new TagParentObjectSelectionWizardPage(this);
		addPage(page);
	}
}
