package com.devepos.adt.atm.ui.internal.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult;
import com.devepos.adt.atm.model.abaptags.TagQueryFocus;
import com.devepos.adt.atm.model.abaptags.TagQueryType;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.tree.ITaggedObjectTreeService;
import com.devepos.adt.atm.tree.TaggedObjectTreeServicesFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.ImageUtil;
import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.elementinfo.AdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.ElementInfoCollection;
import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoCollection;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.elementinfo.LazyLoadingElementInfo;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.ui.tree.ILazyLoadingNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.LazyLoadingFolderNode;
import com.devepos.adt.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

public class TaggedObjectTreeContentAndLabelProvider extends LazyLoadingTreeContentProvider
    implements ILabelProvider, IStyledLabelProvider {

  private final ITaggedObjectTreeService treeService = TaggedObjectTreeServicesFactory
      .createTaggedObjectTreeService();

  private final Map<IProject, ILazyLoadingNode> projectRootNodeMap = new HashMap<>();

  public TaggedObjectTreeContentAndLabelProvider() {
  }

  private class TagLoader implements IElementInfoProvider {

    private final String tagId;
    private final IAdtObjectReference objectRef;
    private final String destinationId;

    public TagLoader(final String destinationId) {
      this(destinationId, null, null);
    }

    public TagLoader(final String destinationId, final String tagId,
        final IAdtObjectReference objectRef) {
      this.destinationId = destinationId;
      this.tagId = tagId;
      this.objectRef = objectRef;
    }

    @Override
    public List<IElementInfo> getElements() {
      var searchParams = IAbapTagsFactory.eINSTANCE.createTaggedObjectSearchParams();
      searchParams.setSearchScope(TagSearchScope.ALL);
      if (tagId != null) {
        searchParams.getTagIds().add(tagId);
      }
      if (objectRef != null) {
        searchParams.setQuery(String.format("%s:%s", objectRef.getName(), objectRef.getType()
            .substring(0, 4)));
        searchParams.setQueryType(TagQueryType.OBJECT_NAME_TYPE_COMBO);
        searchParams.setQueryFocus(TagQueryFocus.PARENT_OBJECT);
      }

      try {
        var treeResult = treeService.findNodes(destinationId, searchParams);
        var foundElements = new ArrayList<IElementInfo>();

        fillObjectResults(treeResult, foundElements);
        fillTagResults(treeResult, foundElements);
        return foundElements;
      } catch (Exception exc) {
        exc.printStackTrace();
        return null;
      }
    }

    @Override
    public String getProviderDescription() {
      return "Loading Tree Nodes...";
    }

    private void fillObjectResults(final ITaggedObjectTreeResult treeResult,
        final List<IElementInfo> resultElements) {
      treeResult.getObjects()
          .stream()
          .filter(o -> StringUtil.isEmpty(o.getParentTagId()))
          .forEach(o -> {
            resultElements.add(createAdtObjectRef(o));
          });
    }

    private AdtObjectReferenceElementInfo createAdtObjectRef(final ITaggedObjectTreeObject o) {
      var objectRef = o.getObjectRef();
      var adtObjectRefEmf = AdtObjectReferenceModelFactory.createReference(destinationId, objectRef
          .getName(), objectRef.getType(), objectRef.getUri());
      var objectElementInfo = new AdtObjectReferenceElementInfo(objectRef.getName(), objectRef
          .getName(), objectRef.getDescription());
      objectElementInfo.setAdtObjectReference(adtObjectRefEmf);
      if (o.isExpandable()) {
        objectElementInfo.setLazyLoadingSupport(true);
        objectElementInfo.setElementInfoProvider(new TagLoader(destinationId, o
            .getParentTagId() != null ? o.getParentTagId() : tagId, adtObjectRefEmf));
      }
      return objectElementInfo;
    }

    private void fillTagResults(final ITaggedObjectTreeResult treeResult,
        final List<IElementInfo> resultElements) {

      // group the objects by parent tag
      var objectsByTagMap = treeResult.getObjects()
          .stream()
          .filter(o -> !StringUtil.isEmpty(o.getParentTagId()))
          .collect(Collectors.groupingBy(ITaggedObjectTreeObject::getParentTagId));

      for (var t : treeResult.getTags()) {
        // find objects with that tag id
        var objectsForTag = objectsByTagMap.get(t.getId());
        boolean hasObjectsForTag = objectsForTag != null && !objectsForTag.isEmpty();

        if (hasObjectsForTag || !t.getChildTags().isEmpty()) {
          // lazy loading of tag is not required
          var tagNode = new ElementInfoCollection(t.getName(), t.getName(), null, t
              .getDescription());
          tagNode.setAdditionalInfo(t);
          if (!t.getChildTags().isEmpty()) {
            processChildNodes(tagNode, t.getChildTags());
          }
          if (hasObjectsForTag) {
            objectsForTag.forEach(o -> tagNode.getChildren().add(createAdtObjectRef(o)));
          }
          resultElements.add(tagNode);
        } else {
          var tagNode = new LazyLoadingElementInfo(t.getName(), ImageUtil.getImageForTag(t, false),
              new TagLoader(destinationId, t.getId(), null));
          tagNode.setAdditionalInfo(t);
          resultElements.add(tagNode);
        }
      }
    }

    private void processChildNodes(final IElementInfoCollection collection,
        final List<ITag> childTags) {
      for (var childTag : childTags) {
        if (childTag.getChildTags().isEmpty()) {
          var lazyTagNode = new LazyLoadingElementInfo(childTag.getName(), null, new TagLoader(
              destinationId, childTag.getId(), null));
          lazyTagNode.setAdditionalInfo(childTag);
          collection.getChildren().add(lazyTagNode);
        } else {
          var childFolderNode = new ElementInfoCollection(childTag.getName(), childTag.getName(),
              null, childTag.getDescription());
          childFolderNode.setAdditionalInfo(childTag);
          collection.getChildren().add(childFolderNode);
          processChildNodes(childFolderNode, childTag.getChildTags());
        }
      }
    }

  }

  @Override
  public void addListener(final ILabelProviderListener listener) {
    // TODO Auto-generated method stub
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public Object[] getChildren(final Object parentElement) {
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
  public Object[] getElements(final Object inputElement) {
    return null;
  }

  @Override
  public Image getImage(final Object element) {
    if (element instanceof IAdtObjectReferenceNode) {
      var adtObjRef = ((IAdtObjectReferenceNode) element).getObjectReference();
      return adtObjRef != null ? AdtTypeUtil.getInstance().getTypeImage(adtObjRef.getType()) : null;
    }
    if (element instanceof ITreeNode) {
      var nodeTag = ((ITreeNode) element).getAdapter(ITag.class);
      // CHECK: move "shared" information to next request so the tag already returns with the
      // information
      if (nodeTag != null) {
        ITreeNode lastParentBeforeRoot = (ITreeNode) element;
        while (lastParentBeforeRoot != null) {
          if (lastParentBeforeRoot.getParent() != null && lastParentBeforeRoot.getParent()
              .getParent() == null) {
            break;
          }
          lastParentBeforeRoot = lastParentBeforeRoot.getParent();
        }

        var parentNodeTag = lastParentBeforeRoot.getAdapter(ITag.class);
        if (parentNodeTag != null) {
          return ImageUtil.getImageForTag(parentNodeTag, false);
        }
      }
      return ((ITreeNode) element).getImage();
    }
    return null;
  }

  @Override
  public StyledString getStyledText(final Object element) {
    final var text = new StyledString();
    final var node = (ITreeNode) element;

    if (node instanceof IAdtObjectReferenceNode) {
      var objRefNode = (IAdtObjectReferenceNode) node;
      text.append(objRefNode.getName());
      if (!StringUtil.isEmpty(objRefNode.getDescription())) {
        text.append("  " + objRefNode.getDescription(), StylerFactory.createCustomStyler(SWT.ITALIC,
            JFacePreferences.DECORATIONS_COLOR, null));
      }
    } else {
      var tag = node.getAdapter(ITag.class);
      if (tag != null) {
        appendTagName(tag, text);
        // appendCounterText(tag, text);

        text.append(" (" + ((ICollectionTreeNode) node).getSizeAsString() + ")",
            StyledString.COUNTER_STYLER);
        appendDescription(tag, text);
      } else {
        text.append(node.getName());
      }
    }

    return text;
  }

  @Override
  public String getText(final Object element) {
    if (element instanceof ITreeNode) {
      return ((ITreeNode) element).getName();
    }
    return null;
  }

  @Override
  public boolean isLabelProperty(final Object element, final String property) {
    return false;
  }

  @Override
  public void removeListener(final ILabelProviderListener listener) {
  }

  protected void appendCounterText(final ITag tag, final StyledString text) {
    // if (noCounterText) {
    // return;
    // }
    if (!StringUtil.isEmpty(tag.getId())) {
      text.append(" (" + tag.getTaggedObjectCount() + ")", StyledString.COUNTER_STYLER);
    }

  }

  protected void appendDescription(final ITag tagNode, final StyledString text) {
    // if (noDescription) {
    // return;
    // }
    if (tagNode.getDescription() != null) {
      text.append("  " + tagNode.getDescription(), StylerFactory.createCustomStyler(SWT.ITALIC,
          JFacePreferences.DECORATIONS_COLOR, null));
    }
  }

  protected void appendTagName(final ITag tag, final StyledString text) {
    if (tag != null && tag.isChanged()) {
      text.append(tag.getName(), StylerFactory.ITALIC_STYLER);
    } else {
      text.append(tag.getName());
    }
  }
}
