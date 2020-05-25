package com.devepos.adt.abaptags.ui.internal.tree;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.IDescriptionProvider;

import com.devepos.adt.abaptags.ui.AbapTagsUIPlugin;
import com.devepos.adt.abaptags.ui.internal.util.IImages;
import com.devepos.adt.tools.base.ui.tree.FolderTreeNode;
import com.devepos.adt.tools.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.tools.base.ui.tree.ITreeNode;
import com.devepos.adt.tools.base.ui.tree.SimpleInfoTreeNode;

public class TagsTreeContentAndLabelProvider extends LabelProvider
	implements DelegatingStyledCellLabelProvider.IStyledLabelProvider, ITreeContentProvider, IDescriptionProvider {

	private CommonViewer viewer;

	public TagsTreeContentAndLabelProvider() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		this.viewer = (CommonViewer) viewer;
	}

	@Override
	public Object[] getElements(final Object inputElement) {
		return null;
	}

	@Override
	public Object[] getChildren(final Object parentElement) {
		if (parentElement instanceof ICollectionTreeNode) {
			return ((ICollectionTreeNode) parentElement).getChildren().toArray();
		}
		if (parentElement instanceof IProject) {
			final IProject project = (IProject) parentElement;

			final FolderTreeNode root = new FolderTreeNode("ABAP Tags", null,
				AbapTagsUIPlugin.getDefault().getImage(IImages.GLOBAL_TAGS_FOLDER), null);
			root.addChild(new SimpleInfoTreeNode("Custom Tag", AbapTagsUIPlugin.getDefault().getImage(IImages.TAG), root));
			final FolderTreeNode root2 = new FolderTreeNode("ABAP User Tags", null,
				AbapTagsUIPlugin.getDefault().getImage(IImages.USER_TAGS_FOLDER), null);
			return new Object[] { root, root2 };
		}
		return null;
	}

	@Override
	public Object getParent(final Object element) {
		if (element instanceof ITreeNode) {
			return ((ITreeNode) element).getParent();
		}
		return null;
	}

	@Override
	public boolean hasChildren(final Object element) {
		if (element instanceof ICollectionTreeNode) {
			return true;
		}
		return false;
	}

	@Override
	public StyledString getStyledText(final Object element) {
		final StyledString text = new StyledString();
		if (element instanceof ITreeNode) {
			text.append(((ITreeNode) element).getDisplayName());
		}
		return text;
	}

	@Override
	public String getDescription(final Object anElement) {
		return "";
	}

	@Override
	public boolean isLabelProperty(final Object element, final String property) {
		return false;
	}

	@Override
	public Image getImage(final Object element) {
		if (element instanceof ITreeNode) {
			return ((ITreeNode) element).getImage();
		}
		return null;
	}

}