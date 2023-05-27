package com.devepos.adt.atm.ui.internal.projectexplorer.tree;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.util.IPropertyChangeListener;
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
import com.devepos.adt.atm.tree.ITaggedObjectTreeService;
import com.devepos.adt.atm.tree.TaggedObjectTreeServicesFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.ImageUtil;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.preferences.ITaggedObjectTreePrefs;
import com.devepos.adt.atm.ui.internal.util.AdtObjectUtil;
import com.devepos.adt.atm.ui.internal.util.IColorConstants;
import com.devepos.adt.atm.ui.internal.util.ITaggedObjectPropertyNameConstants;
import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ITadirTypeConstants;
import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.elementinfo.AdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.ElementInfoCollection;
import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoCollection;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.elementinfo.LazyLoadingElementInfo;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.LazyLoadingFolderNode;
import com.devepos.adt.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.base.ui.tree.launchable.ILaunchableNode;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

public class TaggedObjectTreeContentAndLabelProvider extends LazyLoadingTreeContentProvider
    implements ILabelProvider, IStyledLabelProvider {

  // For now only a single tree node is stored per project, later this could be several
  private static final QualifiedName SESSION_PROP_TAGGED_OBJECT_TREE = new QualifiedName(
      "com.devepos.adt.atm.ui", "taggedObjectTrees"); //$NON-NLS-1$ //$NON-NLS-2$

  private final ITaggedObjectTreeService treeService = TaggedObjectTreeServicesFactory
      .createTaggedObjectTreeService();

  private final IPreferenceStore prefStore;
  private final IPropertyChangeListener colorPropertyChangeListener;
  private boolean showDescriptions;
  private boolean showObjectTypes;

  public TaggedObjectTreeContentAndLabelProvider() {
    super();
    prefStore = AbapTagsUIPlugin.getDefault().getPreferenceStore();
    showDescriptions = prefStore.getBoolean(ITaggedObjectTreePrefs.DISPLAY_DESCRIPTIONS);
    showObjectTypes = prefStore.getBoolean(ITaggedObjectTreePrefs.DISPLAY_OBJECT_TYPES);

    prefStore.addPropertyChangeListener(l -> {
      var prop = l.getProperty();
      if (prop.startsWith("com.devepos.adt.atm.ui.taggedObjectTree.")) {
        if (prop.equals(ITaggedObjectTreePrefs.DISPLAY_DESCRIPTIONS)) {
          showDescriptions = (boolean) l.getNewValue();
        } else if (prop.equals(ITaggedObjectTreePrefs.DISPLAY_OBJECT_TYPES)) {
          showObjectTypes = (boolean) l.getNewValue();
        }
        refreshViewer();
      }
    });

    colorPropertyChangeListener = event -> {
      if (IColorConstants.COMP_PARENT_COLOR.equals(event.getProperty())) {
        refreshViewer();
      }
    };
    JFaceResources.getColorRegistry().addListener(colorPropertyChangeListener);
  }

  private class RootNode extends LazyLoadingFolderNode {

    private final TaggedObjectTreeLoader treeLoader;

    public RootNode(final TaggedObjectTreeLoader tagLoader) {
      super(Messages.TaggedObjectTreeContentAndLabelProvider_TaggedObjectsNodeName_xtit, tagLoader,
          null, AbapTagsUIPlugin.getDefault().getImage(IImages.GLOBAL_TAGS_FOLDER));
      treeLoader = tagLoader;
    }

    @Override
    public String getSizeAsString() {
      if (isLoading() || !isLoaded()) {
        return "?"; //$NON-NLS-1$
      }
      return treeLoader != null ? new DecimalFormat("###,###").format(treeLoader.getFolderSize()) //$NON-NLS-1$
          : "0"; //$NON-NLS-1$
    }
  }

  private class TaggedObjectTreeLoader implements IElementInfoProvider {

    private final String tagId;
    private final IAdtObjectReference objectRef;
    private final String destinationId;
    private int folderSize;

    public TaggedObjectTreeLoader(final String destinationId) {
      this(destinationId, null, null);
    }

    public TaggedObjectTreeLoader(final String destinationId, final String tagId,
        final IAdtObjectReference objectRef) {
      this.destinationId = destinationId;
      this.tagId = tagId;
      this.objectRef = objectRef;
    }

    @Override
    public List<IElementInfo> getElements() {
      var treeRequest = IAbapTagsFactory.eINSTANCE.createTaggedObjectTreeRequest();
      if (tagId != null) {
        treeRequest.setTagId(tagId);
      }
      if (objectRef != null) {
        var type = objectRef.getType();
        if (type.equals(IAdtObjectTypeConstants.FUNCTION_MODULE)) {
          treeRequest.setParentObjectType("FUNC"); //$NON-NLS-1$
        } else if (type.equals(IAdtObjectTypeConstants.FUNCTION_INCLUDE)) {
          treeRequest.setParentObjectType(ITadirTypeConstants.PROGRAM);
        } else {
          treeRequest.setParentObjectType(objectRef.getType().substring(0, 4));
        }
        treeRequest.setParentObjectName(objectRef.getName());
      }

      var treeResult = treeService.findNodes(destinationId, treeRequest);
      var foundElements = new ArrayList<IElementInfo>();

      folderSize = treeResult.getTaggedObjectCount();

      fillObjectResults(treeResult, foundElements);
      fillTagResults(treeResult, foundElements);
      return foundElements;
    }

    public int getFolderSize() {
      return folderSize;
    }

    @Override
    public String getProviderDescription() {
      return Messages.TaggedObjectTreeContentAndLabelProvider_LoadingTaggedObjectTreeJob_xtit;
    }

    private AdtObjectReferenceElementInfo createAdtObjectRef(final ITaggedObjectTreeObject o) {
      var objectRef = o.getObjectRef();
      var adtObjectRefEmf = AdtObjectReferenceModelFactory.createReference(destinationId, objectRef
          .getName(), objectRef.getType(), objectRef.getUri());
      var objectElementInfo = new AdtObjectReferenceElementInfo(objectRef.getName(), objectRef
          .getDisplayName(), objectRef.getDescription());
      if (!StringUtil.isEmpty(objectRef.getParentName())) {
        objectElementInfo.getProperties()
            .put(ITaggedObjectPropertyNameConstants.ADT_OBJECT_PARENT_NAME, objectRef
                .getParentName());
      }
      objectElementInfo.setAdtObjectReference(adtObjectRefEmf);
      // mark this adt object element info as launchable, so the project explorer will create the
      // necessary items in the context menu
      objectElementInfo.getProperties()
          .put(ILaunchableNode.class.getName(), Boolean.TRUE.toString()); // $NON-NLS-1$
      if (o.isExpandable()) {
        objectElementInfo.setLazyLoadingSupport(true);
        objectElementInfo.setElementInfoProvider(new TaggedObjectTreeLoader(destinationId, o
            .getParentTagId() != null ? o.getParentTagId() : tagId, adtObjectRefEmf));
      }
      return objectElementInfo;
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
              new TaggedObjectTreeLoader(destinationId, t.getId(), null));
          tagNode.setAdditionalInfo(t);
          resultElements.add(tagNode);
        }
      }
    }

    private void processChildNodes(final IElementInfoCollection collection,
        final List<ITag> childTags) {
      for (var childTag : childTags) {
        if (childTag.getChildTags().isEmpty()) {
          var lazyTagNode = new LazyLoadingElementInfo(childTag.getName(), null,
              new TaggedObjectTreeLoader(destinationId, childTag.getId(), null));
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
  }

  @Override
  public void dispose() {
    if (colorPropertyChangeListener != null) {
      JFaceResources.getColorRegistry().removeListener(colorPropertyChangeListener);
    }
  }

  @Override
  public Object[] getChildren(final Object parentElement) {
    if (parentElement instanceof IProject) {
      var project = (IProject) parentElement;
      if (isTaggedObjectTreesAvailable(project)) {
        var childNodes = getTaggedObjectTrees(project);
        if (childNodes != null) {
          return childNodes;
        }
      }
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
      return ImageUtil.getAdtTypeImage(adtObjRef.getType());
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

    if (node instanceof RootNode) {
      text.append(node.getName());
      text.append(" (" + ((RootNode) node).getSizeAsString() + ")", StyledString.COUNTER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
    } else if (node instanceof IAdtObjectReferenceNode) {
      setObjRefNodeText(text, (IAdtObjectReferenceNode) node);
    } else {
      var tag = node.getAdapter(ITag.class);
      if (tag != null) {
        appendTagName(tag, text);

        // Ignore count from tag node and take the child nodes as count instead
        text.append(" (" + ((ICollectionTreeNode) node).getSizeAsString() + ")", //$NON-NLS-1$ //$NON-NLS-2$
            StyledString.COUNTER_STYLER);
        appendDescription(tag, text);
      } else {
        text.append(node.getDisplayName());
      }
    }

    return text;
  }

  @Override
  public String getText(final Object element) {
    if (element instanceof ITreeNode) {
      return ((ITreeNode) element).getDisplayName();
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
    if (!StringUtil.isEmpty(tag.getId())) {
      text.append(" (" + tag.getTaggedObjectCount() + ")", StyledString.COUNTER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
    }

  }

  protected void appendDescription(final ITag tagNode, final StyledString text) {
    if (tagNode.getDescription() != null) {
      text.append("  " + tagNode.getDescription(), StylerFactory.createCustomStyler(SWT.ITALIC, //$NON-NLS-1$
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

  private Object[] getTaggedObjectTrees(final IProject project) {
    try {
      var sessionProp = project.getSessionProperty(SESSION_PROP_TAGGED_OBJECT_TREE);
      if (sessionProp instanceof Object[]) {
        return (Object[]) sessionProp;
      }
      var lazyNode = new RootNode(new TaggedObjectTreeLoader(DestinationUtil.getDestinationId(
          project)));
      sessionProp = new Object[] { lazyNode };
      project.setSessionProperty(SESSION_PROP_TAGGED_OBJECT_TREE, sessionProp);
      return (Object[]) sessionProp;
    } catch (CoreException e) {
      e.printStackTrace();
    }
    return null;
  }

  private boolean isTaggedObjectTreesAvailable(final IProject project) {
    if (!ProjectUtil.isLoggedOnToProject(project)) {
      return false;
    }

    return treeService.testTreeFeatureAvailability(project).isOK();
  }

  private void setObjRefNodeText(final StyledString text,
      final IAdtObjectReferenceNode objRefNode) {
    text.append(objRefNode.getDisplayName());
    if (showObjectTypes) {
      AdtObjectUtil.appendAdtTypeDescription(objRefNode, text);
    }
    var parentName = objRefNode.getPropertyValue(
        ITaggedObjectPropertyNameConstants.ADT_OBJECT_PARENT_NAME);
    if (parentName != null) {
      text.append(" [" + parentName + "]", StylerFactory.createCustomStyler(SWT.NORMAL,
          IColorConstants.COMP_PARENT_COLOR, null));
    }

    if (showDescriptions && !StringUtil.isEmpty(objRefNode.getDescription())) {
      text.append("  " + objRefNode.getDescription(), StylerFactory.createCustomStyler(SWT.ITALIC, //$NON-NLS-1$
          JFacePreferences.DECORATIONS_COLOR, null));
    }
  }
}
