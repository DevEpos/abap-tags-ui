package com.devepos.adt.abaptags.ui.internal.forms;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;

import com.devepos.adt.abaptags.IAbapTagsFactory;
import com.devepos.adt.abaptags.IAbapTagsPackage;
import com.devepos.adt.abaptags.ITag;
import com.devepos.adt.abaptags.ITags;
import com.devepos.adt.tools.base.project.IAbapProjectProvider;
import com.devepos.adt.tools.base.util.IModificationListener;
import com.devepos.adt.tools.base.util.IModificationListener.ModificationKind;
import com.devepos.adt.tools.base.util.IModificationProvider;
import com.devepos.adt.tools.base.util.IStatusView;

/**
 * Model for ABAP Tags. To be used in the dialog for managing Tags
 *
 * @author stockbal
 */
public class AbapTagModel implements IModel, IModificationProvider<ITag> {

	private final IAbapProjectProvider projectProvider;
	private ITags tags;
	private final IStatusView statusView;
	private boolean modelChanged;
	private final List<IModificationListener<ITag>> modificationListener = new ArrayList<>();
	private final WritableValue<Boolean> valid = new WritableValue<>(true, Boolean.class);
	private final WritableValue<Boolean> editMode = new WritableValue<>(false, Boolean.class);
	private final WritableValue<Boolean> validProject = new WritableValue<>(false, Boolean.class);

	public AbapTagModel(final IAbapProjectProvider projectProvider, final IStatusView statusView) {
		this.projectProvider = projectProvider;
		this.statusView = statusView;

		getTags();
		ITag tag = IAbapTagsFactory.eINSTANCE.createTag();
		tag.setId("asdf");
		tag.setName("Costing");
		tag.setCreatedDateTime("2019-11-06T06:30:30");
		tag.setCreatedBy("STOCKBAL");
		this.tags.getTags().add(tag);
		tag = IAbapTagsFactory.eINSTANCE.createTag();
		tag.setId("asdfd");
		tag.setName("Product Costing");
		tag.setCreatedDateTime("2019-12-06T06:30:30");
		tag.setCreatedBy("STOCKBAL");
		this.tags.getTags().add(tag);

		tag = IAbapTagsFactory.eINSTANCE.createTag();
		tag.setId("da49dls");
		tag.setName("BO");
		tag.setTaggedObjectCount(10);
		final ITag tag2 = IAbapTagsFactory.eINSTANCE.createTag();
		tag2.setId("a9434d");
		tag2.setName("Validation");
		tag2.setTaggedObjectCount(30);
		tag.getChildTag().add(tag2);

		this.tags.getTags().add(tag);

		fillParent(this.tags.getTags(), null);
	}

	public void setModelChanged(final boolean modelChanged) {
		this.modelChanged = modelChanged;
	}

	/**
	 * @return {@code true} if the model has changed data
	 */
	public boolean hasModelChanged() {
		return this.modelChanged;
	}

	/**
	 * @return {@code true} if the model is valid
	 */
	@Override
	public boolean isValid() {
		return this.valid.getValue();
	}

	/**
	 * @param valid the new valid state of the model
	 */
	public void setValid(final boolean valid) {
		this.valid.setValue(valid);
	}

	/**
	 * @return {@code true} if model is in edit mode
	 */
	@Override
	public boolean isEditMode() {
		return this.editMode.getValue();
	}

	/**
	 * @param editMode the new editMode to be set
	 */
	public void setEditMode(final boolean editMode) {
		this.editMode.setValue(editMode);
	}

	/**
	 * @return {@code true} if the model has a valid project
	 */
	public boolean hasValidProject() {
		return this.validProject.getValue();
	}

	/**
	 * @param validProject the new value for the {@code validProject} flag
	 */
	public void setValidProject(final boolean validProject) {
		this.validProject.setValue(validProject);
	}

	public void loadTagsFromProject() {
		// TODO: implement tag loading

		// post process tags. i.e. fill the parent at each tag
		fillParent(this.tags.getTags(), null);
	}

	public void lockTags() {

	}

	public void unlockTags() {

	}

	public void saveTags() {

	}

	public ITags getTags() {
		if (this.tags == null) {
			this.tags = IAbapTagsFactory.eINSTANCE.createTags();
			this.tags.eAdapters().add(new TagNotificationAdapter());
		}
		return this.tags;
	}

	/**
	 * Retrieves the current contents
	 *
	 * @return
	 */
	public Object[] getContents() {
		return getTags().getTags().toArray();
	}

	public ITag addNewTag() {
		final ITag newTag = IAbapTagsFactory.eINSTANCE.createTag();
		getTags().getTags().add(newTag);
		fireModified(ModificationKind.ADDED, newTag);
		return newTag;
	}

	public void removeTag(final ITag tag) {

	}

	@Override
	public void addModificationListener(final IModificationListener<ITag> listener) {
		this.modificationListener.add(listener);
	}

	@Override
	public void removeModificationListener(final IModificationListener<ITag> listener) {
		this.modificationListener.remove(listener);
	}

	private void fireModified(final ModificationKind kind, final ITag modifiedTag) {
		for (final IModificationListener<ITag> l : this.modificationListener) {
			if (modifiedTag == null) {
				l.modified(kind);
			} else {
				l.modified(modifiedTag, kind);
			}
		}
	}

	private void fillParent(final List<ITag> tags, final ITag parent) {
		for (final ITag tag : tags) {
			tag.setParentTag(parent);

			// process children
			if (tag.getChildTag() != null) {
				fillParent(tag.getChildTag(), tag);
			}
		}
	}

	private class TagNotificationAdapter extends EContentAdapter {
		@Override
		public void notifyChanged(final Notification notification) {
			super.notifyChanged(notification);
			final Object notifier = notification.getNotifier();
			final int eventType = notification.getEventType();

			if (notifier instanceof ITag) {
				final ITag changedTag = (ITag) notifier;
				final IStatus tagStatus = changedTag.validate();
				setValid(tagStatus.getSeverity() == IStatus.OK);
				AbapTagModel.this.statusView.setViewStatus(tagStatus);

				if (eventType == Notification.SET || eventType == Notification.ADD || eventType == Notification.REMOVE) {
					notifyOfTagChange(changedTag, notification.getFeature());
				}
			}
		}

		private void notifyOfTagChange(final ITag tag, final Object genericFeature) {
			if (tag == null) {
				return;
			}
			final EStructuralFeature structFeature = (EStructuralFeature) genericFeature;
			if (!(structFeature.getFeatureID() == IAbapTagsPackage.TAG__PARENT_TAG
				|| structFeature.getFeatureID() == IAbapTagsPackage.TAG__CHANGED)) {
				tag.setChanged(true);
				setModelChanged(true);
				fireModified(ModificationKind.UPDATED, tag);
			}

		}
	}

}
