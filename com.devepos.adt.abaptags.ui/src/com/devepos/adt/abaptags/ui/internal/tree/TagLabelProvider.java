package com.devepos.adt.abaptags.ui.internal.tree;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.abaptags.ITag;
import com.devepos.adt.abaptags.ui.AbapTagsUIPlugin;
import com.devepos.adt.abaptags.ui.internal.util.IImages;
import com.devepos.adt.tools.base.ui.StylerFactory;

public class TagLabelProvider extends LabelProvider implements ILabelProvider, IStyledLabelProvider {

	@Override
	public String getText(final Object element) {
		final ITag node = (ITag) element;
		return node.getName();
	}

	@Override
	public Image getImage(final Object element) {
		if (element instanceof ITag) {
			final ITag tag = (ITag) element;
			if (tag.getId() == null || tag.getId().isBlank()) {
				return AbapTagsUIPlugin.getDefault().getImage(IImages.TAG, true);
			} else if (tag.getOwner() != null && !tag.getOwner().isBlank()) {
				return AbapTagsUIPlugin.getDefault().getImage(IImages.USER_TAG);
			} else {
				return AbapTagsUIPlugin.getDefault().getImage(IImages.TAG);
			}
		}
		return null;
	}

	@Override
	public StyledString getStyledText(final Object element) {
		final StyledString text = new StyledString();
		final ITag tagNode = (ITag) element;

		if (tagNode.isChanged()) {
			text.append(tagNode.getName(), StylerFactory.ITALIC_STYLER);
		} else {
			text.append(tagNode.getName());
		}
		text.append(" (" + tagNode.getTaggedObjectCount() + ")", StyledString.COUNTER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$

		return text;
	}
}