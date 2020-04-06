package com.devepos.adt.abaptags.ui.internal.forms;

import java.util.List;

import com.devepos.adt.abaptags.ui.internal.util.IImages;
import com.devepos.adt.tools.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.tools.base.ui.tree.ITreeNode;
import com.devepos.adt.tools.base.ui.tree.TreeNodeBase;

public class AbapTagTreeNode extends TreeNodeBase implements ICollectionTreeNode {

	public AbapTagTreeNode(final String name, final String displayName, final String description, final ITreeNode parent) {
		super(name, displayName, description, parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getImageId() {
		return IImages.TAGS;
	}

	@Override
	public List<ITreeNode> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setChildren(final List<ITreeNode> children) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addChild(final ITreeNode child) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getSizeAsString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
