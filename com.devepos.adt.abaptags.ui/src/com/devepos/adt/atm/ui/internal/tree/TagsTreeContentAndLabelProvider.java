package com.devepos.adt.atm.ui.internal.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.TagQueryType;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.tree.ITaggedObjectTreeService;
import com.devepos.adt.atm.tree.TaggedObjectTreeServicesFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ILazyLoadingNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.LazyLoadingFolderNode;
import com.devepos.adt.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

public class TagsTreeContentAndLabelProvider extends LazyLoadingTreeContentProvider implements
    ILabelProvider {

  private ITaggedObjectTreeService treeService = TaggedObjectTreeServicesFactory
      .createTaggedObjectTreeService();

  private Map<IProject, ILazyLoadingNode> projectRootNodeMap = new HashMap<>();

  private class TagLoader implements IElementInfoProvider {

    private String tagId;
    private IAdtObjectReference objectRef;
    private String destinationId;

    public TagLoader(String destinationId, String tagId, IAdtObjectReference objectRef) {
      this.destinationId = destinationId;
      this.tagId = tagId;
      this.objectRef = objectRef;
    }

    public TagLoader(String destinationId) {
      this(destinationId, null, null);
    }

    @Override
    public List<IElementInfo> getElements() {
      var searchParams = IAbapTagsFactory.eINSTANCE.createTaggedObjectSearchParams();
      searchParams.setSearchScope(TagSearchScope.USER);
      searchParams.setQueryType(TagQueryType.OBJECT_NAME);
      searchParams.setMatchesAllTags(true);

      var treeResult = treeService.findNodes(destinationId, searchParams);
      System.out.printf("Tags at level: %d\n", treeResult.getTags().size());
      System.out.printf("Objects at level: %d\n", treeResult.getObjects().size());
      return null;
    }

    @Override
    public String getProviderDescription() {
      return "Loading Tree Nodes...";
    }

  }

  public TagsTreeContentAndLabelProvider() {
  }

  @Override
  public void addListener(ILabelProviderListener listener) {
    // TODO Auto-generated method stub
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public Object[] getChildren(Object parentElement) {
    if (parentElement instanceof IProject) {
      var lazyNode = projectRootNodeMap.get(parentElement);
      // was node already fetched once?
      if (lazyNode == null) {
        lazyNode = new LazyLoadingFolderNode("Tagged Objects", new TagLoader(DestinationUtil
            .getDestinationId((IProject) parentElement)), null, AbapTagsUIPlugin.getDefault()
                .getImage(IImages.GLOBAL_TAGS_FOLDER));
        projectRootNodeMap.put((IProject) parentElement, lazyNode);
      }
      return new Object[] { lazyNode };
    }
    return super.getChildren(parentElement);
  }

  @Override
  public Object[] getElements(Object inputElement) {
    return null;
  }

  @Override
  public Image getImage(Object element) {
    if (element instanceof IAdtObjectReferenceNode) {
      var adtObjRef = ((IAdtObjectReferenceNode) element).getObjectReference();
      return adtObjRef != null ? AdtTypeUtil.getInstance().getTypeImage(adtObjRef.getType()) : null;
    } else if (element instanceof ITreeNode) {
      return ((ITreeNode) element).getImage();
    }
    return null;
  }

  @Override
  public String getText(Object element) {
    if (element instanceof ITreeNode) {
      return ((ITreeNode) element).getName();
    }
    return null;
  }

  @Override
  public boolean isLabelProperty(Object element, String property) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void removeListener(ILabelProviderListener listener) {
    // TODO Auto-generated method stub

  }

}
