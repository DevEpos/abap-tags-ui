package com.devepos.adt.atm.ui.internal.tree;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.PatternFilter;

import com.devepos.adt.atm.model.abaptags.ITag;

/**
 * {@link PatternFilter} for a {@link Tree} that holds {@link ITag} objects
 * 
 * @author stockbal
 */
public class TagFilter extends PatternFilter {
	@Override
	protected boolean isLeafMatch(final Viewer viewer, final Object element) {
		if (element instanceof ITag) {
			final ITag tag = (ITag) element;
			return wordMatches(tag.getName());
		}
		return false;
	}
}
