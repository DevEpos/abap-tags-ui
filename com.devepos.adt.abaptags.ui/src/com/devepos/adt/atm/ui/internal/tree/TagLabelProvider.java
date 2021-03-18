package com.devepos.adt.atm.ui.internal.tree;

import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagBase;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.util.IImages;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.util.StringUtil;

/**
 * Label Provider for Viewer which holds instances of type {@link ITagBase}
 *
 * @author stockbal
 */
public class TagLabelProvider extends LabelProvider implements IStyledLabelProvider {

	private final boolean grayScaleImageForNewTags;
	private final boolean noCounterText;
	private final boolean noDescription;

	/**
	 * Creates new Label Provider for Viewer which holds instances of type
	 * {@link ITagBase}
	 */
	public TagLabelProvider() {
		this(true, false, true);
	}

	/**
	 * Creates new Label Provider for Viewer which holds instances of type
	 * {@link ITagBase}
	 *
	 * @param grayScaleImageForNewTags apply's gray scale filter to image if the tag
	 *                                 is new
	 * @param noCounterText            prevents displaying the counter of objects
	 *                                 that exist for a given tag
	 * @param noDescription            prevents displaying the description of the
	 *                                 tag
	 */
	public TagLabelProvider(final boolean grayScaleImageForNewTags, final boolean noCounterText,
		final boolean noDescription) {
		this.grayScaleImageForNewTags = grayScaleImageForNewTags;
		this.noCounterText = noCounterText;
		this.noDescription = noDescription;
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
		final ITag tagNode = (ITag) element;

		appendTagName(tagNode, text);
		appendCounterText(tagNode, text);
		appendDescription(tagNode, text);

		return text;
	}

	protected void appendDescription(final ITag tagNode, final StyledString text) {
		if (this.noDescription) {
			return;
		}
		if (tagNode.getDescription() != null) {
			text.append("  " + tagNode.getDescription(),
				StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR, null));
		}
	}

	protected void appendTagName(final ITag tag, final StyledString text) {
		if (tag != null && tag.isChanged()) {
			text.append(tag.getName(), StylerFactory.ITALIC_STYLER);
		} else {
			text.append(tag.getName());
		}
	}

	protected void appendCounterText(final ITag tag, final StyledString text) {
		if (this.noCounterText) {
			return;
		}
		if (!StringUtil.isEmpty(tag.getId())) {
			text.append(" (" + tag.getTaggedObjectCount() + ")", StyledString.COUNTER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
		}

	}
}