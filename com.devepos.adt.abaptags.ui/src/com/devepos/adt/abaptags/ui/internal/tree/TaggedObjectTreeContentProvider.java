package com.devepos.adt.abaptags.ui.internal.tree;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.jface.viewers.ITreeContentProvider;

import com.devepos.adt.abaptags.ITaggedObject;
import com.devepos.adt.abaptags.ITaggedObjectList;

/**
 * Content Provider for Tagged objects
 *
 * @author stockbal
 */
public class TaggedObjectTreeContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getElements(final Object inputElement) {
		if (inputElement instanceof ITaggedObjectList) {
			return ((ITaggedObjectList) inputElement).getTaggedObjects().toArray();
		} else if (inputElement instanceof List<?>) {
			return ((List<?>) inputElement).toArray();
		}
		return new Object[0];
	}

	@Override
	public Object[] getChildren(final Object parentElement) {
		if (parentElement instanceof ITaggedObject) {
			return ((ITaggedObject) parentElement).getTags()
				.stream()
				.filter(t -> t.getParentTagName() != null && !t.getParentTagName().isEmpty())
				.collect(Collectors.toList())
				.toArray();
		}
		return null;
	}

	@Override
	public Object getParent(final Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(final Object element) {
		if (element instanceof ITaggedObject) {
			return !((ITaggedObject) element).getTags().isEmpty();
		}
		return false;
	}

}
