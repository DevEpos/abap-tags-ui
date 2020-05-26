package com.devepos.adt.atm.ui.internal.wizard;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.IWizard;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagPreviewInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.tools.base.wizard.IBaseWizardPage;

/**
 * Model for the Tag Objects Wizard
 *
 * @author stockbal
 */
public interface ITagObjectsWizard extends IWizard {

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
	 * Sets new list of selected tags
	 *
	 * @param tagList new list of selected tags
	 */
	void setSelectedTags(List<ITag> tags);

	/**
	 * Returns list of selected tags
	 *
	 * @return list of selected tags
	 */
	List<ITag> getSelectedTags();

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
	 * Sets the {@code canFinish} flag in the wizard
	 *
	 * @param canFinish the {@code canFinish} flag in the wizard
	 */
	void setCanFinish(boolean canFinish);

	/**
	 * Returns list of the the currently selected objects
	 *
	 * @return list of the the currently selected objects
	 */
	IAdtObjRefList getSelectedObjects();

	/**
	 * Sets the selectionObjects property
	 *
	 * @param selectedObjects the selectionObjects property
	 */
	void setSelectedObjects(IAdtObjRefList selectedObjects);

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