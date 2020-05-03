package com.devepos.adt.abaptags.ui.internal.wizard;

import java.util.List;

import org.eclipse.core.resources.IProject;

import com.devepos.adt.abaptags.ITagPreviewInfo;
import com.devepos.adt.abaptags.ITaggedObject;
import com.devepos.adt.abaptags.ITaggedObjectList;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.tools.base.wizard.IBaseWizardPage;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Model for the Tag Objects Wizard
 *
 * @author stockbal
 */
public interface ITagObjectsWizardModel {

	public enum TagWizardStatus {
		NONE,
		PENDING,
		RAW_OBJECTS_SELECTED,
		OBJECTS_SELECTED,
		TAG_PREVIEW_LOADED,
		TAG_SELECTION_PENDING,
		TAGS_SELECTED,
		PARENT_OBJECT_SELECTION_PENDING,
		CAN_FINISH;
	}

	/**
	 * Returns the current project
	 *
	 * @return the current project
	 */
	IProject getProject();

	/**
	 * Sets the current project of the wizard
	 *
	 * @param project the project to be set in the wizard
	 */
	void setProject(IProject project);

	/**
	 * Transforms the given list into {@link ITaggedObject tagged objects} and sets
	 * them in the model
	 *
	 * @param adtObjectReferences list of ADT object references
	 */
	void setObjectsFromAdtObjRefs(List<IAdtObjectReference> adtObjectReferences);

	/**
	 * @param adtObjRefList
	 */
	void setObjectsFromAdtObjRefs(IAdtObjRefList adtObjRefList);

	/**
	 * Clears all objects from the tagged objects list
	 */
	void clearTaggedObjects();

	/**
	 * Returns the list with objects that should or already have been tagged
	 *
	 * @return
	 */
	ITaggedObjectList getTaggedObjectList();

	/**
	 * Returns the current tag preview info
	 *
	 * @return
	 */
	ITagPreviewInfo getCurrentTagPreviewInfo();

	/**
	 * Sets the current tag preview information
	 *
	 * @param tagPreviewInfo the current tag preview information
	 */
	void setCurrentTagPreviewInfo(ITagPreviewInfo tagPreviewInfo);

	/**
	 * Sets the status of the wizard
	 *
	 * @param status the new wizard status
	 */
	void setStatus(TagWizardStatus status);

	/**
	 * Sets the {@code canFinish} flag in the wizard
	 *
	 * @param canFinish the {@code canFinish} flag in the wizard
	 */
	void setCanFinish(boolean canFinish);

	/**
	 * Retrieves the current wizard status
	 *
	 * @return the current wizard status
	 */
	TagWizardStatus getStatus();

	/**
	 * Returns list of the the currently selected objects
	 *
	 * @return list of the the currently selected objects
	 */
	IAdtObjRefList getSelectedObjects();

	/**
	 * Call to bring the previous page of the given page to completion, so that the
	 * given page can work properly
	 *
	 * @param page current page in the wizard
	 */
	void completePreviousPage(IBaseWizardPage page);

	/**
	 * Returns flag indicating if the previous page of the passed page is in the
	 * "dirty" state
	 *
	 * @param  page a wizard page
	 * @return      flag indicating if the previous page of the passed page is in
	 *              the "dirty" state
	 */
	boolean isPreviousPageDirty(IBaseWizardPage page);

}