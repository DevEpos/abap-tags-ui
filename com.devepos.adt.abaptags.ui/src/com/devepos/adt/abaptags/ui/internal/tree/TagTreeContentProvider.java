package com.devepos.adt.abaptags.ui.internal.tree;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;

import com.devepos.adt.abaptags.ITag;
import com.devepos.adt.abaptags.ITagList;
import com.devepos.adt.abaptags.ui.internal.forms.AbapTagModel;

public class TagTreeContentProvider implements ITreeContentProvider {

	private boolean showUserTags = true;

	/**
	 * @return the showUserTags value
	 */
	public boolean isShowUserTags() {
		return this.showUserTags;
	}

	/**
	 * @param showUserTags the showUserTags to set
	 */
	public void setShowUserTags(final boolean showUserTags) {
		this.showUserTags = showUserTags;
	}

	@Override
	public Object[] getElements(final Object inputElement) {
		List<ITag> tagList = null;
		if (inputElement instanceof AbapTagModel) {
			tagList = ((AbapTagModel) inputElement).getTags().getTags();
		} else if (inputElement instanceof EList<?>) {
			tagList = (EList<ITag>) inputElement;
		}
		if (tagList != null) {
			if (!this.showUserTags) {
				final List<ITag> filteredList = tagList.stream()
					.filter(t -> t.getOwner() == null || t.getOwner() != null && t.getOwner().isBlank())
					.collect(Collectors.toList());
				if (filteredList != null && filteredList.size() > 0) {
					return filteredList.toArray();
				}
			} else {
				return tagList.toArray();
			}
		}

		return new Object[0];
	}

	@Override
	public Object[] getChildren(final Object parentElement) {
		if (parentElement instanceof ITag) {
			return ((ITag) parentElement).getChildTags().toArray();
		}
		return null;
	}

	@Override
	public Object getParent(final Object element) {
		if (!(element instanceof ITag)) {
			return null;
		}
		final ITag tag = (ITag) element;
		final EObject container = tag.eContainer();
		if (container == null || container instanceof ITagList) {
			return null;
		} else if (container instanceof ITag) {
			return container;
		} else {
			return null;
		}
	}

	@Override
	public boolean hasChildren(final Object element) {
		if (element instanceof ITag) {
			final ITag tag = (ITag) element;
			return tag.getChildTags().size() > 0;
		}
		return false;
	}

}