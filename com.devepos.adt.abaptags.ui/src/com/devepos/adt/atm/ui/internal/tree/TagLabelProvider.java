package com.devepos.adt.atm.ui.internal.tree;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagBase;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.util.IImages;
import com.devepos.adt.tools.base.ui.StylerFactory;
import com.devepos.adt.tools.base.util.StringUtil;

/**
 * Label Provider for Viewer which holds instances of type {@link ITagBase}
 *
 * @author stockbal
 */
public class TagLabelProvider extends LabelProvider implements IStyledLabelProvider {

	private final boolean grayScaleImageForNewTags;
	private final boolean noCounterText;

	/**
	 * Creates new Label Provider for Viewer which holds instances of type
	 * {@link ITagBase}
	 */
	public TagLabelProvider() {
		this(true, false);
	}

	/**
	 * Creates new Label Provider for Viewer which holds instances of type
	 * {@link ITagBase}
	 *
	 * @param grayScaleImageForNewTags apply's gray scale filter to image if the tag
	 *                                 is new
	 * @param noCounterText            prevents displaying the counter of objects
	 *                                 that exist for a given tag
	 */
	public TagLabelProvider(final boolean grayScaleImageForNewTags, final boolean noCounterText) {
		this.grayScaleImageForNewTags = grayScaleImageForNewTags;
		this.noCounterText = noCounterText;
	}

	@Override
	public String getText(final Object element) {
		final ITagBase node = (ITagBase) element;
		return node.getName();
	}

	@Override
	public Image getImage(final Object element) {
		if (element instanceof ITagBase) {
			final ITagBase tag = (ITagBase) element;
			if (StringUtil.isEmpty(tag.getId()) && this.grayScaleImageForNewTags) {
				return AbapTagsUIPlugin.getDefault().getImage(IImages.TAG, true);
			} else if (!StringUtil.isEmpty(tag.getOwner())) {
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
		final ITagBase tagNode = (ITagBase) element;

		if (tagNode instanceof ITag && ((ITag) tagNode).isChanged()) {
			text.append(tagNode.getName(), StylerFactory.ITALIC_STYLER);
		} else {
			text.append(tagNode.getName());
		}

		if (!this.noCounterText && !StringUtil.isEmpty(tagNode.getId()) && tagNode instanceof ITag) {
			text.append(" (" + ((ITag) tagNode).getTaggedObjectCount() + ")", StyledString.COUNTER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
		}

		return text;
	}
}