package com.devepos.adt.atm.ui.internal.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.part.ViewPart;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.tagging.IAdtObjTaggingService;
import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.tags.IAbapTagsService;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.ImageUtil;
import com.devepos.adt.atm.ui.internal.help.HelpContexts;
import com.devepos.adt.atm.ui.internal.help.HelpUtil;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.util.AdtObjectCapabilities;
import com.devepos.adt.atm.ui.internal.util.AdtObjectUtil;
import com.devepos.adt.atm.ui.internal.util.ITaggedObjectPropertyNameConstants;
import com.devepos.adt.atm.ui.internal.wizard.tagging.TagObjectsWizard;
import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.elementinfo.AdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.ElementInfoCollection;
import com.devepos.adt.base.elementinfo.IAdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoCollection;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.elementinfo.LazyLoadingRefreshMode;
import com.devepos.adt.base.elementinfo.SimpleElementInfo;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.IGeneralCommandConstants;
import com.devepos.adt.base.ui.IGeneralMenuConstants;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.ViewDescriptionLabel;
import com.devepos.adt.base.ui.ViewPartListener;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.base.ui.action.ChooseOtherAdtObjectAction;
import com.devepos.adt.base.ui.action.CommandFactory;
import com.devepos.adt.base.ui.action.CopyToClipboardAction;
import com.devepos.adt.base.ui.action.ExecuteAdtObjectAction;
import com.devepos.adt.base.ui.action.OpenAdtObjectAction;
import com.devepos.adt.base.ui.action.PreferenceToggleAction;
import com.devepos.adt.base.ui.adtobject.AdtObjectFactory;
import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.search.IAdtRisSearchResultProxy;
import com.devepos.adt.base.ui.tree.FolderTreeNode;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.base.ui.tree.ILazyLoadingNode;
import com.devepos.adt.base.ui.tree.IStyledTreeNode;
import com.devepos.adt.base.ui.tree.ITreeNode;
import com.devepos.adt.base.ui.tree.LazyLoadingFolderNode;
import com.devepos.adt.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.base.ui.tree.LoadingTreeItemsNode;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.devepos.adt.base.ui.util.AdtUIUtil;
import com.devepos.adt.base.ui.util.EditorUtil;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * View to manage the tags of a given ADT object
 *
 * @author stockbal
 */
public class AbapObjectTagsView extends ViewPart {

  public static final String VIEW_ID = "com.devepos.adt.atm.ui.views.AbapObjectTags"; //$NON-NLS-1$
  private static final String LINK_TO_EDITOR_PREF = "com.devepos.adt.atm.ui.views.AbapObjectTags.linkToEditor"; //$NON-NLS-1$
  private final IAbapTagsService abapTagsService;
  private IAdtObject currentAdtObject;

  private CopyToClipboardAction copyToClipBoardAction;
  private PreferenceToggleAction linkToEditorAction;
  private Action addTagsAction;
  private Action otherObjectAction;
  private Action refreshAction;
  private Action focusOnObject;
  private UnassignTagsAction unassignTagsAction;

  private Composite mainComposite;
  private Tree tree;
  private ViewDescriptionLabel viewLabel;
  private TreeInput treeResult;
  private TreeViewer treeViewer;
  private String destinationOwner;

  public AbapObjectTagsView() {
    abapTagsService = AbapTagsServiceFactory.createTagsService();
  }

  private class ContentProvider extends LazyLoadingTreeContentProvider {
    public ContentProvider() {
      super(LazyLoadingRefreshMode.ROOT_AND_NON_LAZY_CHILDREN, AbstractTreeViewer.ALL_LEVELS);
    }

    @Override
    public Object[] getElements(final Object inputElement) {

      if (inputElement instanceof ITreeNode) {
        if (inputElement instanceof ILazyLoadingNode) {
          final Object[] childNodes = getChildren(inputElement);
          return childNodes != null ? childNodes : new Object[0];
        }
        return new Object[] { inputElement };
      }
      return super.getElements(inputElement);
    }
  }

  private class UnassignTagsAction extends Action {
    public UnassignTagsAction() {
      super(Messages.AbapObjectTagsView_DeleteTagAction_xmit, PlatformUI.getWorkbench()
          .getSharedImages()
          .getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
    }

    @Override
    public void run() {
      final ITaggedObjectList tgobjList = collectJobPayload();
      if (tgobjList == null || tgobjList.getTaggedObjects().isEmpty()) {
        // TODO: warning or error??
        return;
      }

      final Job deleteTagsJob = createDeleteTagsJob(tgobjList);
      deleteTagsJob.schedule();
    }

    private ITaggedObjectList collectJobPayload() {
      final var tgobjList = IAbapTagsFactory.eINSTANCE.createTaggedObjectList();

      var selObjects = treeViewer.getStructuredSelection().toList();

      for (var selObj : selObjects) {
        if (selObj instanceof IAdtObjectReferenceNode) {
          var objRefNode = (IAdtObjectReferenceNode) selObj;
          var parentNode = objRefNode.getParent();
          // check if parent node itself is also selected, then we do skip it
          if (!(parentNode instanceof FolderTreeNode) || selObjects.contains(parentNode)) {
            continue;
          }
          var tagOfNode = parentNode.getAdapter(IAdtObjectTag.class);
          if (tagOfNode == null) {
            continue;
          }
          addTaggedObject(tgobjList, (IAdtObjectReferenceNode) parentNode.getParent(), objRefNode,
              tagOfNode);
        } else {
          var treeNode = (ITreeNode) selObj;
          var tagOfNode = treeNode.getAdapter(IAdtObjectTag.class);
          if (tagOfNode == null) {
            continue;
          }

          // check if parent is component
          var parentObjNode = treeNode.getParent();
          if (!(parentObjNode instanceof IAdtObjectReferenceNode)) {
            // TODO: we should actually raise an error here as this should not happen
            continue;
          }

          addTaggedObject(tgobjList, (IAdtObjectReferenceNode) parentObjNode, null, tagOfNode);
        }
      }

      return tgobjList;
    }

    private void addTaggedObject(final ITaggedObjectList tgobjList,
        final IAdtObjectReferenceNode tagOwningObjRefNode, final IAdtObjectReferenceNode parent,
        final IAdtObjectTag tag) {

      var adtObjRef = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
      // Parent name could be optional, but if null is returned it has no consequence
      adtObjRef.setParentName(tagOwningObjRefNode.getPropertyValue(
          ITaggedObjectPropertyNameConstants.ADT_OBJECT_PARENT_NAME));
      adtObjRef.setName(tagOwningObjRefNode.getName());
      adtObjRef.setType(tagOwningObjRefNode.getAdtObjectType());
      adtObjRef.setUri(tagOwningObjRefNode.getObjectReference().getUri());

      var taggedObject = IAbapTagsFactory.eINSTANCE.createTaggedObject();
      taggedObject.setObjectRef(adtObjRef);

      var objectTag = IAbapTagsFactory.eINSTANCE.createAdtObjectTag();
      objectTag.setId(tag.getId());
      objectTag.setParentTagId(tag.getParentTagId());
      if (parent != null) {
        objectTag.setParentObjectName(parent.getName());
        objectTag.setParentObjectType(parent.getAdtObjectType());
        objectTag.setParentObjectUri(parent.getObjectReference().getUri());
      }
      taggedObject.getTags().add(objectTag);
      tgobjList.getTaggedObjects().add(taggedObject);
    }

    private Job createDeleteTagsJob(final ITaggedObjectList tgobjList) {
      return Job.create(Messages.AbapObjectTagsView_DeleteTagsJob_xmsg, monitor -> {

        final var taggingService = AdtObjTaggingServiceFactory.createTaggingService();
        taggingService.deleteTags(DestinationUtil.getDestinationId(getProject()), tgobjList);

        Display.getDefault().asyncExec(() -> {
          refreshCurrentNode();
        });
      });
    }

  }

  private class TaggedObjectInfoProvider implements IElementInfoProvider {

    private final String objectUri;

    public TaggedObjectInfoProvider(final String objectUri) {
      this.objectUri = objectUri;
    }

    @Override
    public List<IElementInfo> getElements() throws CoreException {
      final IAdtObjTaggingService taggingService = AdtObjTaggingServiceFactory
          .createTaggingService();

      final String destinationId = DestinationUtil.getDestinationId(getProject());
      final IStatus loggedOnStatus = ProjectUtil.ensureLoggedOnToProject(getProject());
      if (!loggedOnStatus.isOK()) {
        return Arrays.asList(new SimpleElementInfo(loggedOnStatus.getMessage()));
      }

      var taggedObjects = taggingService.getObjectInfo(destinationId, objectUri);
      if (taggedObjects != null) {
        return convertToElementInfo(destinationId, taggedObjects);
      }
      return null;
    }

    @Override
    public String getProviderDescription() {
      return Messages.AbapObjectTagsView_LoadingTaggedObjectInfoJob_xmsg;
    }

    private void addHierarchicalTags(final String destinationId,
        final AdtObjectReferenceElementInfo adtObjRefElemInfo,
        final Map<TagKey, List<IAdtObjectTag>> hierarchicalTags) {

      for (Entry<TagKey, List<IAdtObjectTag>> entry : hierarchicalTags.entrySet()) {
        // check if the list contains
        List<IAdtObjectTag> tags = entry.getValue();
        IAdtObjectTag tag = entry.getKey().tag;
        IElementInfo tagElementInfo = null;

        if (tags.size() == 1) {
          if (tags.get(0).getParentObjectName() == null) {
            tagElementInfo = new SimpleElementInfo(tag.getName(), ImageUtil.getObjectTagImage(tag,
                destinationOwner));
            tagElementInfo.setAdditionalInfo(tag);
          } else {
            ElementInfoCollection tagElementInfoColl = new ElementInfoCollection(tag.getName(),
                ImageUtil.getObjectTagImage(tag, destinationOwner));
            tagElementInfoColl.setAdditionalInfo(tag);

            collectParentObject(destinationId, tag, tagElementInfoColl);

            tagElementInfo = tagElementInfoColl;
          }
        } else {
          // if more than one tag with the same key exists we should have entries with
          // parent objects
          ElementInfoCollection tagElementInfoColl = new ElementInfoCollection(tag.getName(),
              ImageUtil.getObjectTagImage(tag, destinationOwner));
          tagElementInfoColl.setAdditionalInfo(tag);

          for (IAdtObjectTag parentObjTag : tags) {
            // it is still possible that a tag was assigned without supplying a parent object
            if (parentObjTag.getParentObjectName() != null) {
              collectParentObject(destinationId, parentObjTag, tagElementInfoColl);
            }
          }

          tagElementInfo = tagElementInfoColl;
        }
        adtObjRefElemInfo.getChildren().add(tagElementInfo);
      }

    }

    private void collectParentObject(final String destinationId, final IAdtObjectTag tag,
        final ElementInfoCollection tagElementInfoColl) {
      IAdtObjectReferenceElementInfo parentObjectRef = new AdtObjectReferenceElementInfo(tag
          .getParentObjectName());
      parentObjectRef.setAdtObjectReference(AdtObjectReferenceModelFactory.createReference(
          destinationId, tag.getParentObjectName(), tag.getParentObjectType(), tag
              .getParentObjectUri()));
      tagElementInfoColl.getChildren().add(parentObjectRef);
      // clear the parent object information from the tag
      tag.setParentObjectName(null);
      tag.setParentObjectType(null);
      tag.setParentObjectUri(null);
    }

    private void collectObjectTags(final String destinationId, final ITaggedObject taggedObject,
        final AdtObjectReferenceElementInfo adtObjRefElemInfo) {
      final Map<TagKey, List<IAdtObjectTag>> hierarchicalTags = new HashMap<>();

      for (final IAdtObjectTag tag : taggedObject.getTags()) {
        if (tag.getParentTagId() != null) {
          TagKey tagKey = new TagKey(tag);
          List<IAdtObjectTag> tagsForKey = hierarchicalTags.get(tagKey);
          if (tagsForKey == null) {
            tagsForKey = new ArrayList<>();
          }
          tagsForKey.add(tag);
          hierarchicalTags.put(tagKey, tagsForKey);
        } else {
          final IElementInfo tagElementInfo = new SimpleElementInfo(tag.getName(), ImageUtil
              .getObjectTagImage(tag, destinationOwner));
          tagElementInfo.setAdditionalInfo(tag);
          adtObjRefElemInfo.getChildren().add(tagElementInfo);
        }
      }

      if (!hierarchicalTags.isEmpty()) {
        addHierarchicalTags(destinationId, adtObjRefElemInfo, hierarchicalTags);
      }
    }

    private List<IElementInfo> convertToElementInfo(final String destinationId,
        final List<ITaggedObject> taggedObjects) {

      var mainObj = taggedObjects.get(0);
      final var adtObjRefElemInfo = new AdtObjectReferenceElementInfo(mainObj.getObjectRef()
          .getName());
      adtObjRefElemInfo.setAdtObjectReference(AdtObjectReferenceModelFactory.createReference(
          destinationId, mainObj.getObjectRef()));

      var childObjectCollection = createChildObjectCollection(destinationId, mainObj,
          taggedObjects);
      if (childObjectCollection != null) {
        adtObjRefElemInfo.getChildren().add(childObjectCollection);
      }
      if (mainObj.getTags().isEmpty() && !adtObjRefElemInfo.hasChildren()) {
        adtObjRefElemInfo.getChildren()
            .add(new SimpleElementInfo(Messages.AbapObjectTagsView_NoTagsAssigned_xmsg));
      } else {
        collectObjectTags(destinationId, mainObj, adtObjRefElemInfo);
      }
      return Arrays.asList(adtObjRefElemInfo);
    }

    private IElementInfoCollection createChildObjectCollection(final String destinationId,
        final ITaggedObject mainObj, final List<ITaggedObject> taggedObjects) {

      if (taggedObjects.size() <= 1) {
        return null;
      }

      var folder = new ElementInfoCollection(
          Messages.AbapObjectTagsView_TaggedComponentsFolder_xlbl, AbapTagsUIPlugin.getDefault()
              .getImage(IImages.LOCAL_OBJECTS_FOLDER));
      for (var childObj : taggedObjects.subList(1, taggedObjects.size())) {
        final var adtObjRefElemInfo = new AdtObjectReferenceElementInfo(childObj.getObjectRef()
            .getName());
        adtObjRefElemInfo.setAdtObjectReference(AdtObjectReferenceModelFactory.createReference(
            destinationId, childObj.getObjectRef()));
        adtObjRefElemInfo.getProperties()
            .put(ITaggedObjectPropertyNameConstants.ADT_OBJECT_PARENT_NAME, childObj.getObjectRef()
                .getParentName());
        folder.getChildren().add(adtObjRefElemInfo);

        collectObjectTags(destinationId, childObj, adtObjRefElemInfo);
      }
      return folder;
    }
  }

  private class TagKey {
    public IAdtObjectTag tag;
    private int hash;

    public TagKey(final IAdtObjectTag tag) {
      this.tag = tag;
    }

    @Override
    public boolean equals(final Object o) {
      if (o instanceof TagKey) {
        TagKey key2 = (TagKey) o;
        return hashCode() == key2.hashCode();
      }
      return super.equals(o);
    }

    @Override
    public int hashCode() {
      if (hash == 0) {
        hash = 17;
        hash = 31 * hash + tag.getId().hashCode();
        if (tag.getParentTagId() != null) {
          hash = 31 * hash + tag.getParentTagId().hashCode();
        }
      }
      return hash;
    }

  }

  private class TreeInput {
    private ITreeNode currentInput;
    private final TreeViewer viewer;

    public TreeInput(final TreeViewer viewer) {
      this.viewer = viewer;
    }

    public void clearInput() {
      currentInput = null;
      viewer.setInput(null);
    }

    public void refresh() {
      if (currentInput instanceof ILazyLoadingNode) {
        ((ILazyLoadingNode) currentInput).resetLoadedState();
        viewer.refresh();
      }
    }

    public void updateInput(final String objectUri) {
      Assert.isNotNull(objectUri);

      final ILazyLoadingNode lazyLoadingNode = new LazyLoadingFolderNode("", //$NON-NLS-1$
          new TaggedObjectInfoProvider(objectUri), null, null);

      lazyLoadingNode.setContentRefreshMode(LazyLoadingRefreshMode.ROOT_AND_NON_LAZY_CHILDREN);
      currentInput = lazyLoadingNode;
      viewer.setInput(currentInput);
    }

  }

  /**
   * Custom view label provider for the Result Tree
   *
   * @author stockbal
   */
  private static class ViewLabelProvider extends LabelProvider implements ILabelProvider,
      IStyledLabelProvider {

    @Override
    public Image getImage(final Object element) {
      Image image;
      final ITreeNode searchResult = (ITreeNode) element;
      image = searchResult.getImage();
      if (image == null && element instanceof IAdtObjectReferenceNode) {
        final IAdtObjectReferenceNode adtObjRefNode = (IAdtObjectReferenceNode) element;
        final IAdtObjectReference objRef = adtObjRefNode.getObjectReference();
        var type = objRef.getType();
        if (type.equals(IAdtObjectTypeConstants.LOCAL_CLASS)) {
          image = ImageUtil.getLocalClassImage();
        } else if (type.equals(IAdtObjectTypeConstants.LOCAL_INTERFACE)) {
          image = ImageUtil.getLocalInterfaceImage();
        } else {
          image = AdtTypeUtil.getInstance().getTypeImage(type);
        }
      }
      return image;
    }

    @Override
    public StyledString getStyledText(final Object element) {
      boolean isAdtObjectRefNode = false;
      StyledString text = new StyledString();
      final ITreeNode treeNode = (ITreeNode) element;

      if (element instanceof IStyledTreeNode) {
        text = ((IStyledTreeNode) element).getStyledText();
        if (text == null) {
          text = new StyledString();
        }
      } else {
        if (element instanceof LoadingTreeItemsNode) {
          text.append(treeNode.getDisplayName(), StylerFactory.ITALIC_STYLER);
          return text;
        }
        text.append(treeNode.getDisplayName());

        if (element instanceof IAdtObjectReferenceNode) {
          isAdtObjectRefNode = true;
          AdtObjectUtil.appendAdtTypeDescription((IAdtObjectReferenceNode) element, text);
        }

        if (element instanceof ICollectionTreeNode && !isAdtObjectRefNode) {
          final ICollectionTreeNode collectionNode = (ICollectionTreeNode) element;
          if (collectionNode.hasChildren()) {
            final String size = ((ICollectionTreeNode) element).getSizeAsString();
            if (size != null) {
              text.append(" (" + size + ")", StyledString.COUNTER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
            }
          }
        }

        String description = treeNode.getDescription();
        if (description == null && isAdtObjectRefNode) {
          description = ((IAdtObjectReferenceNode) element).getObjectReference().getDescription();
        }
        if (!StringUtil.isEmpty(description)) {
          text.append("  " + description + "  ", //$NON-NLS-1$ //$NON-NLS-2$
              StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR,
                  null));
        }
      }

      return text;
    }

    @Override
    public String getText(final Object element) {
      final ITreeNode searchResult = (ITreeNode) element;

      return searchResult.getName();
    }
  }

  @Override
  public void createPartControl(final Composite parent) {
    mainComposite = new Composite(parent, SWT.NONE);
    HelpUtil.setHelp(mainComposite, HelpContexts.OBJECT_TAGS);
    GridDataFactory.fillDefaults().grab(true, true).applyTo(mainComposite);
    GridLayoutFactory.swtDefaults().margins(0, 0).applyTo(mainComposite);

    createViewer(mainComposite);
    viewLabel = new ViewDescriptionLabel(mainComposite);

    initializeActions();
    clearInput();

    initToolbar(getViewSite().getActionBars());
    hookContextMenu();

    final ViewPartListener partListener = new ViewPartListener();
    partListener.setPartActivatedConsumer(partRef -> {
      final IWorkbenchPart part = partRef.getPart(true);
      if (part instanceof IEditorPart) {
        showTaggedObjectsForEditor((IEditorPart) part);
      } else if (part instanceof AbapObjectTagsView) {
        showTaggedObjectsForEditor(partRef.getPage().getActiveEditor());
      }
    });
    partListener.setPartVisibleConsumer(partRef -> {
      if (VIEW_ID.equals(partRef.getId()) && partRef.getPart(false) instanceof AbapObjectTagsView) {
        showTaggedObjectsForEditor(partRef.getPage().getActiveEditor());
      }
    });
    getSite().getPage().addPartListener(partListener);
    getSite().setSelectionProvider(treeViewer);
  }

  @Override
  public void setFocus() {
    if (tree != null && !tree.isDisposed()) {
      tree.setFocus();
    }
  }

  public void setInput(final IAdtObject newAdtObject) {
    updateInput(newAdtObject, true);
  }

  private void clearInput() {
    currentAdtObject = null;
    if (addTagsAction != null) {
      addTagsAction.setEnabled(false);
      refreshAction.setEnabled(false);
    }
    treeResult.clearInput();
    viewLabel.updateLabel(Messages.AbapObjectTagsView_NoInputAvailable_xmsg);
  }

  private void createViewer(final Composite parent) {
    treeViewer = new TreeViewer(parent, SWT.V_SCROLL | SWT.MULTI);
    tree = treeViewer.getTree();
    GridDataFactory.fillDefaults().grab(true, true).applyTo(tree);
    treeViewer.setContentProvider(new ContentProvider());
    treeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new ViewLabelProvider()));
    treeViewer.setUseHashlookup(true);
    treeViewer.addOpenListener(event -> {
      final ITreeSelection sel = (ITreeSelection) event.getSelection();
      final Iterator<?> selIter = sel.iterator();
      while (selIter.hasNext()) {
        final Object node = selIter.next();
        if (node == null) {
          return;
        }
        if (node instanceof IAdtObjectReferenceNode) {
          final IAdtObjectReferenceNode adtObjRefNode = (IAdtObjectReferenceNode) node;

          if (adtObjRefNode != null) {
            AdtUIUtil.navigateWithObjectReference(adtObjRefNode.getObjectReference(), getProject());
          }
        }
      }
    });
    treeViewer.addDoubleClickListener(l -> {
      var selection = treeViewer.getStructuredSelection();
      if (selection == null || selection.isEmpty()) {
        return;
      }

      var selObj = selection.getFirstElement();
      if (!(selObj instanceof IAdtObjectReferenceNode) && selObj instanceof ICollectionTreeNode) {
        if (treeViewer.getExpandedState(selObj)) {
          treeViewer.collapseToLevel(selObj, 1);
        } else {
          treeViewer.expandToLevel(selObj, 1);
        }
        // treeViewer.refresh();
      }
    });

    treeResult = new TreeInput(treeViewer);
  }

  private boolean isSelectionValidForDeletion(final IStructuredSelection sel) {
    for (var selObj : sel.toList()) {
      if (selObj instanceof IAdtObjectReferenceNode) {
        var objRefNode = (IAdtObjectReferenceNode) selObj;
        var parentNode = objRefNode.getParent();
        if (!(parentNode instanceof FolderTreeNode)) {
          continue;
        }
        IAdtObjectTag tag = parentNode.getAdapter(IAdtObjectTag.class);
        if (tag != null) {
          return true;
        }
      } else {
        var tag = ((ITreeNode) selObj).getAdapter(IAdtObjectTag.class);
        if (tag != null) {
          return true;
        }
      }
    }
    return false;
  }

  private void fillContextMenu(final IMenuManager menu) {
    final IStructuredSelection selection = treeViewer.getStructuredSelection();
    if (selection == null || selection.isEmpty()) {
      return;
    }
    final List<IAdtObjectReference> adtObjRefs = new ArrayList<>();
    final List<IAdtObjectReference> previewAdtObjRefs = new ArrayList<>();

    menu.add(new Separator(ICommonMenuConstants.GROUP_OPEN));
    menu.add(new Separator(IGeneralMenuConstants.GROUP_ADDITIONS));
    menu.add(new Separator(IGeneralMenuConstants.GROUP_EDIT));
    menu.add(new Separator(ICommonMenuConstants.GROUP_PROPERTIES));

    for (final Object selectedObject : selection.toList()) {
      if (selectedObject instanceof IAdtObjectReferenceNode) {
        final IAdtObjectReferenceNode objRefNode = (IAdtObjectReferenceNode) selectedObject;
        final IAdtObjectReference adtObjectRef = objRefNode.getObjectReference();
        if (objRefNode.supportsDataPreview()) {
          previewAdtObjRefs.add(adtObjectRef);
        }
        adtObjRefs.add(adtObjectRef);
      }
    }

    if (!adtObjRefs.isEmpty()) {
      menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, new OpenAdtObjectAction(getProject(),
          adtObjRefs));
    }
    if (!previewAdtObjRefs.isEmpty()) {
      menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, new ExecuteAdtObjectAction(getProject(),
          previewAdtObjRefs, true));
    }

    if (!adtObjRefs.isEmpty() && adtObjRefs.size() == 1 && selection.size() == 1) {

      menu.appendToGroup(IContextMenuConstants.GROUP_ADDITIONS, CommandFactory
          .createContribItemById(IGeneralCommandConstants.WHERE_USED_IN, true, null));
      var singleAdtObjRef = adtObjRefs.get(0);

      if (AdtObjectCapabilities.getInstance()
          .isTypeValidForObjectTagsView(singleAdtObjRef.getType())) {
        focusOnObject.setText(String.format(Messages.AbapObjectTagsView_focusOnObjectAction_xmit,
            singleAdtObjRef.getName()));
        menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, focusOnObject);
      }
    }

    if (isSelectionValidForDeletion(selection)) {
      menu.appendToGroup(IGeneralMenuConstants.GROUP_EDIT, unassignTagsAction);
    }
    menu.appendToGroup(IGeneralMenuConstants.GROUP_EDIT, copyToClipBoardAction);
  }

  private IProject getProject() {
    return currentAdtObject != null ? currentAdtObject.getProject() : null;
  }

  private void hookContextMenu() {
    final MenuManager menuMgr = new MenuManager();
    menuMgr.setRemoveAllWhenShown(true);

    menuMgr.addMenuListener(menu -> {
      fillContextMenu(menu);
    });
    final Control viewerControl = tree;
    final Menu menu = menuMgr.createContextMenu(viewerControl);
    viewerControl.setMenu(menu);
    getSite().registerContextMenu(getViewSite().getId(), menuMgr, treeViewer);
  }

  private void initializeActions() {
    unassignTagsAction = new UnassignTagsAction();
    copyToClipBoardAction = new CopyToClipboardAction();
    copyToClipBoardAction.registerViewer(treeViewer);
    linkToEditorAction = new PreferenceToggleAction(
        Messages.AbapObjectTagsView_LinkToEditorAction_xtol, PlatformUI.getWorkbench()
            .getSharedImages()
            .getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED), LINK_TO_EDITOR_PREF, true,
        AbapTagsUIPlugin.getDefault().getPreferenceStore());
    linkToEditorAction.addPropertyChangeListener(e -> {
      if (e.getProperty().equals(IAction.CHECKED) && (Boolean) e.getNewValue()) {
        updateInputFromEditor();
      }
    });
    focusOnObject = ActionFactory.createAction(/* will be filled later */"", null, () -> {
      IStructuredSelection sel = treeViewer.getStructuredSelection();
      if (sel == null || sel.isEmpty() || sel.size() > 1) {
        return;
      }

      Object selObject = sel.getFirstElement();
      if (!(selObject instanceof IAdtObjectReferenceNode)) {
        return;
      }

      IAdtObjectReferenceNode adtObjRefNode = (IAdtObjectReferenceNode) selObject;
      updateInput(AdtObjectFactory.create(adtObjRefNode.getObjectReference(), currentAdtObject
          .getProject()), true);
    });
    addTagsAction = ActionFactory.createAction(Messages.AbapObjectTagsView_AddTagsAction_xtol,
        AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.ASSIGN_TAG), () -> {
          final TagObjectsWizard wizard = new TagObjectsWizard(currentAdtObject != null);
          if (currentAdtObject != null) {
            wizard.setProject(currentAdtObject.getProject());
            final IAdtObjRefList adtObjRefList = IAdtBaseFactory.eINSTANCE.createAdtObjRefList();
            final IAdtObjRef adtObjRef = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
            adtObjRef.setUri(currentAdtObject.getReference().getUri());
            adtObjRef.setName(currentAdtObject.getReference().getName());
            adtObjRef.setType(currentAdtObject.getReference().getType());
            adtObjRefList.getObjectReferences().add(adtObjRef);
            wizard.setSelectedObjects(adtObjRefList);
          } else {
            wizard.setProject(ProjectUtil.getCurrentAbapProject());
          }
          final WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench()
              .getActiveWorkbenchWindow()
              .getShell(), wizard);
          dialog.open();
          if (currentAdtObject != null && wizard.wasSuccessful()) {
            refreshCurrentNode();
          }
        });
    refreshAction = ActionFactory.createAction(AdtBaseUIResources.getString(
        IAdtBaseStrings.Refresh), AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.REFRESH),
        this::refreshCurrentNode);
    otherObjectAction = new ChooseOtherAdtObjectAction(false, this::onOtherObjectAction);
  }

  private void initToolbar(final IActionBars actionBars) {
    actionBars.setGlobalActionHandler(org.eclipse.ui.actions.ActionFactory.REFRESH.getId(),
        refreshAction);
    final IToolBarManager tbm = actionBars.getToolBarManager();
    tbm.add(linkToEditorAction);
    tbm.add(new Separator());
    tbm.add(addTagsAction);
    tbm.add(new Separator());
    tbm.add(otherObjectAction);
    tbm.add(new Separator());
    tbm.add(refreshAction);
  }

  private void onOtherObjectAction(final IAdtRisSearchResultProxy result) {
    if (result != null) {
      final IProject project = result.getSelectedProject();
      if (project == null) {
        return;
      }
      final IStatus abapTagsFeatureStatus = abapTagsService.testTagsFeatureAvailability(project);
      if (!abapTagsFeatureStatus.isOK()) {
        clearInput();
        viewLabel.updateLabel(abapTagsFeatureStatus.getMessage());
        return;
      }

      final IAdtObjectReference objectRef = result.getFirstResult();
      if (objectRef != null) {
        updateInput(AdtObjectFactory.create(objectRef, project), true);
      }
    }
  }

  private void refreshCurrentNode() {
    treeResult.refresh();
  }

  private void showTaggedObjectsForEditor(final IEditorPart editor) {
    if (editor == null) {
      if (linkToEditorAction.isChecked() && PlatformUI.getWorkbench()
          .getActiveWorkbenchWindow()
          .getActivePage()
          .isPartVisible(this)) {
        clearInput();
      }
      return;
    }

    final IWorkbenchPage page = editor.getSite().getPage();
    if (linkToEditorAction.isChecked() && page.isPartVisible(this)) {
      final IAdtObject selObj = EditorUtil.getAdtObjectFromEditor(editor);
      updateInput(selObj, false);
    }
  }

  private void updateInput(final IAdtObject newAdtObject, final boolean forceUpdate) {
    if (!linkToEditorAction.isChecked() && !forceUpdate) {
      return;
    }
    if (Objects.equals(currentAdtObject, newAdtObject) && (newAdtObject == null || Objects.equals(
        currentAdtObject.getProject(), newAdtObject.getProject()))) {
      return;
    }
    currentAdtObject = newAdtObject;
    if (currentAdtObject == null) {
      clearInput();
    } else {
      if (!ProjectUtil.isLoggedOnToProject(getProject())) {
        clearInput();
        return;
      }
      final IStatus abapTagsFeatureStatus = abapTagsService.testTagsFeatureAvailability(
          currentAdtObject.getProject());
      if (!abapTagsFeatureStatus.isOK()) {
        clearInput();
        viewLabel.updateLabel(abapTagsFeatureStatus.getMessage());
        return;
      }
      treeResult.updateInput(currentAdtObject.getReference().getUri());
      viewLabel.updateLabel(" [" + currentAdtObject.getProject().getName() + "] " + currentAdtObject //$NON-NLS-1$ //$NON-NLS-2$
          .getName(), currentAdtObject.getImage());
      destinationOwner = DestinationUtil.getDestinationOwner(currentAdtObject.getProject());
      addTagsAction.setEnabled(true);
      refreshAction.setEnabled(true);
    }
  }

  private void updateInputFromEditor() {
    final IAdtObject adtObject = EditorUtil.getAdtObjectFromActiveEditor();
    updateInput(adtObject, false);
  }
}
