package com.devepos.adt.atm.ui.internal.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardDialog;
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
import com.devepos.adt.atm.ui.internal.help.HelpContexts;
import com.devepos.adt.atm.ui.internal.help.HelpUtil;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.wizard.TagObjectsWizard;
import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.elementinfo.AdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.ErrorElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.elementinfo.LazyLoadingRefreshMode;
import com.devepos.adt.base.elementinfo.SimpleElementInfo;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.IAdtBaseStrings;
import com.devepos.adt.base.ui.IGeneralContextMenuConstants;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.ViewDescriptionLabel;
import com.devepos.adt.base.ui.ViewPartListener;
import com.devepos.adt.base.ui.action.ActionFactory;
import com.devepos.adt.base.ui.action.ChooseOtherAdtObjectAction;
import com.devepos.adt.base.ui.action.CopyToClipboardAction;
import com.devepos.adt.base.ui.action.ExecuteAdtObjectAction;
import com.devepos.adt.base.ui.action.OpenAdtObjectAction;
import com.devepos.adt.base.ui.action.PreferenceToggleAction;
import com.devepos.adt.base.ui.adtobject.AdtObjectFactory;
import com.devepos.adt.base.ui.adtobject.IAdtObject;
import com.devepos.adt.base.ui.menu.MenuItemFactory;
import com.devepos.adt.base.ui.project.ProjectUtil;
import com.devepos.adt.base.ui.search.IAdtRisSearchResultProxy;
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
import com.devepos.adt.base.util.ObjectUtil;
import com.devepos.adt.base.util.StringUtil;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * View to explore ABAP Tags of currently selected ADT object
 *
 * @author stockbal
 */
public class AbapTagExplorerView extends ViewPart {

    public static final String VIEW_ID = "com.devepos.adt.atm.ui.views.AbapTagsExplorer"; //$NON-NLS-1$
    private static final String LINK_TO_EDITOR_PREF = "com.devepos.adt.atm.ui.views.AbapTagsExplorer.linkToEditor"; //$NON-NLS-1$
    private final IAbapTagsService abapTagsService;
    private Action addTagsAction;
    private CopyToClipboardAction copyToClipBoardAction;
    private IAdtObject currentAdtObject;
    private PreferenceToggleAction linkToEditorAction;
    private Composite mainComposite;
    private Action otherObjectAction;
    private Action refreshAction;
    private Tree tree;
    private TreeInput treeResult;
    private TreeViewer treeViewer;
    private ViewDescriptionLabel viewLabel;

    public AbapTagExplorerView() {
        abapTagsService = AbapTagsServiceFactory.createTagsService();
    }

    @Override
    public void createPartControl(final Composite parent) {
        mainComposite = new Composite(parent, SWT.NONE);
        HelpUtil.setHelp(mainComposite, HelpContexts.TAG_EXPLORER);
        GridDataFactory.fillDefaults().grab(true, true).applyTo(mainComposite);
        GridLayoutFactory.swtDefaults().margins(0, 0).applyTo(mainComposite);

        createViewer(mainComposite);
        viewLabel = new ViewDescriptionLabel(mainComposite);
        clearInput();

        initializeActions();

        initToolbar(getViewSite().getActionBars());
        hookContextMenu();

        final ViewPartListener partListener = new ViewPartListener();
        partListener.setPartActivatedConsumer(partRef -> {
            final IWorkbenchPart part = partRef.getPart(true);
            if (part instanceof IEditorPart) {
                showTaggedObjectsForEditor((IEditorPart) part);
            } else if (part instanceof AbapTagExplorerView) {
                showTaggedObjectsForEditor(partRef.getPage().getActiveEditor());
            }
        });
        partListener.setPartVisibleConsumer(partRef -> {
            if (VIEW_ID.equals(partRef.getId()) && partRef.getPart(false) instanceof AbapTagExplorerView) {
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
        treeResult.clearInput();
        viewLabel.updateLabel(Messages.AbapTagExplorerView_NoInputAvailable_xmsg);
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

        treeResult = new TreeInput(treeViewer);
    }

    private void fillContextMenu(final IMenuManager menu) {
        final IStructuredSelection selection = treeViewer.getStructuredSelection();
        if (selection == null || selection.isEmpty()) {
            return;
        }
        final List<IAdtObjectReference> adtObjRefs = new ArrayList<>();
        DeleteTagsAction deleteTagsAction = null;
        final List<IAdtObjectReference> previewAdtObjRefs = new ArrayList<>();

        for (final Object selectedObject : selection.toList()) {
            if (selectedObject instanceof IAdtObjectReferenceNode) {
                final IAdtObjectReferenceNode objRefNode = (IAdtObjectReferenceNode) selectedObject;
                final IAdtObjectReference adtObjectRef = objRefNode.getObjectReference();
                if (objRefNode.supportsDataPreview()) {
                    previewAdtObjRefs.add(adtObjectRef);
                }
                adtObjRefs.add(adtObjectRef);
            } else if (selectedObject instanceof ITreeNode) {
                final ITreeNode tagNode = (ITreeNode) selectedObject;
                final IAdtObjectTag tag = tagNode.getAdapter(IAdtObjectTag.class);
                if (tag != null) {
                    if (deleteTagsAction == null) {
                        deleteTagsAction = new DeleteTagsAction();
                    }
                    deleteTagsAction.addTag(tag, tagNode);
                }
            }
        }

        if (!adtObjRefs.isEmpty()) {
            menu.add(new OpenAdtObjectAction(getProject(), adtObjRefs));
        }
        if (!previewAdtObjRefs.isEmpty()) {
            menu.add(new ExecuteAdtObjectAction(getProject(), previewAdtObjRefs, true));
        }

        if (!adtObjRefs.isEmpty()) {
            menu.add(new Separator(IGeneralContextMenuConstants.GROUP_ADDITIONS));
            MenuItemFactory.addCommandItem(menu, IGeneralContextMenuConstants.GROUP_ADDITIONS,
                "com.sap.adt.ris.whereused.ui.callWhereUsed", //$NON-NLS-1$
                AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.WHERE_USED_LIST), AdtBaseUIResources.getString(
                    IAdtBaseStrings.General_WhereUsedList_xmit), null);
        }

        menu.add(new Separator(IGeneralContextMenuConstants.GROUP_EDIT));
        if (deleteTagsAction != null) {
            menu.appendToGroup(IGeneralContextMenuConstants.GROUP_EDIT, deleteTagsAction);
        }
        menu.appendToGroup(IGeneralContextMenuConstants.GROUP_EDIT, copyToClipBoardAction);
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
        copyToClipBoardAction = new CopyToClipboardAction();
        copyToClipBoardAction.registerViewer(treeViewer);
        linkToEditorAction = new PreferenceToggleAction(Messages.AbapTagExplorerView_LinkToEditorAction_xtol, PlatformUI
            .getWorkbench()
            .getSharedImages()
            .getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED), LINK_TO_EDITOR_PREF, true, AbapTagsUIPlugin.getDefault()
                .getPreferenceStore());
        linkToEditorAction.addPropertyChangeListener(e -> {
            if (e.getProperty().equals(IAction.CHECKED) && (Boolean) e.getNewValue()) {
                updateInputFromEditor();
            }
        });
        addTagsAction = ActionFactory.createAction(Messages.AbapTagExplorerView_AddTagsAction_xtol, AbapTagsUIPlugin
            .getDefault()
            .getImageDescriptor(IImages.ASSIGN_TAG), () -> {
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
        refreshAction = ActionFactory.createAction(AdtBaseUIResources.getString(IAdtBaseStrings.Refresh),
            AdtBaseUIResources.getImageDescriptor(IAdtBaseImages.REFRESH), this::refreshCurrentNode);
        otherObjectAction = new ChooseOtherAdtObjectAction(false, this::onOtherObjectAction);
    }

    private void initToolbar(final IActionBars actionBars) {
        actionBars.setGlobalActionHandler(org.eclipse.ui.actions.ActionFactory.REFRESH.getId(), refreshAction);
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
        if (ObjectUtil.equals(currentAdtObject, newAdtObject)) {
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
            final IStatus abapTagsFeatureStatus = abapTagsService.testTagsFeatureAvailability(currentAdtObject
                .getProject());
            if (!abapTagsFeatureStatus.isOK()) {
                clearInput();
                viewLabel.updateLabel(abapTagsFeatureStatus.getMessage());
                return;
            }
            treeResult.updateInput(currentAdtObject.getReference().getUri());
            viewLabel.updateLabel(" [" + currentAdtObject.getProject().getName() + "] " + currentAdtObject.getName(), //$NON-NLS-1$ //$NON-NLS-2$
                currentAdtObject.getImage());
        }
    }

    private void updateInputFromEditor() {
        final IAdtObject adtObject = EditorUtil.getAdtObjectFromActiveEditor();
        updateInput(adtObject, false);
    }

    private class ContentProvider extends LazyLoadingTreeContentProvider {
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

    private class DeleteTagsAction extends Action {
        private final Map<String, List<IAdtObjectTag>> tagMap = new HashMap<>();
        private ITaggedObjectList tgobjList;

        public DeleteTagsAction() {
            super(Messages.AbapTagExplorerView_DeleteTagAction_xmit, PlatformUI.getWorkbench()
                .getSharedImages()
                .getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
        }

        public void addTag(final IAdtObjectTag tag, final ITreeNode tagNode) {
            if (tgobjList == null) {
                tgobjList = IAbapTagsFactory.eINSTANCE.createTaggedObjectList();
            }
            final ITreeNode parent = tagNode.getParent();
            String objectUri = null;
            if (parent instanceof IAdtObjectReferenceNode) {
                objectUri = ((IAdtObjectReferenceNode) parent).getObjectReference().getUri();
            }

            List<IAdtObjectTag> tagList;
            if (objectUri == null) {
                return;
            }
            tagList = tagMap.get(objectUri);
            if (tagList == null) {
                tagList = new ArrayList<>();
                tagMap.put(objectUri, tagList);
            }
            tagList.add(tag);
        }

        @Override
        public void run() {
            final ITaggedObjectList tgobjList = IAbapTagsFactory.eINSTANCE.createTaggedObjectList();

            for (final String objectUri : tagMap.keySet()) {
                final ITaggedObject taggedObject = IAbapTagsFactory.eINSTANCE.createTaggedObject();
                final IAdtObjRef objectRef = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
                objectRef.setUri(objectUri);
                taggedObject.setObjectRef(objectRef);
                taggedObject.getTags().addAll(tagMap.get(objectUri));
                tgobjList.getTaggedObjects().add(taggedObject);
            }

            final Job deleteTagsJob = createDeleteTagsJob(tgobjList);
            deleteTagsJob.schedule();
        }

        private Job createDeleteTagsJob(final ITaggedObjectList tgobjList) {
            return Job.create(Messages.AbapTagExplorerView_DeleteTagsJob_xmsg, monitor -> {

                final IAdtObjTaggingService taggingService = AdtObjTaggingServiceFactory.createTaggingService();
                taggingService.deleteTags(DestinationUtil.getDestinationId(getProject()), tgobjList);

                Display.getDefault().asyncExec(() -> {
                    refreshCurrentNode();
                });
            });
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

            final ILazyLoadingNode lazyLoadingNode = new LazyLoadingFolderNode("", new IElementInfoProvider() { //$NON-NLS-1$

                @Override
                public List<IElementInfo> getElements() {
                    final IAdtObjTaggingService taggingService = AdtObjTaggingServiceFactory.createTaggingService();

                    try {
                        final String destinationId = DestinationUtil.getDestinationId(getProject());
                        final IStatus loggedOnStatus = ProjectUtil.ensureLoggedOnToProject(getProject());
                        if (!loggedOnStatus.isOK()) {
                            return Arrays.asList(new SimpleElementInfo(loggedOnStatus.getMessage()));
                        }

                        final ITaggedObject taggedObject = taggingService.getObject(destinationId, objectUri);
                        if (taggedObject != null) {
                            final AdtObjectReferenceElementInfo adtObjRefElemInfo = new AdtObjectReferenceElementInfo(
                                taggedObject.getObjectRef().getName());
                            adtObjRefElemInfo.setAdtObjectReference(AdtObjectReferenceModelFactory.createReference(
                                destinationId, taggedObject.getObjectRef()));

                            for (final IAdtObjectTag tag : taggedObject.getTags()) {
                                final IElementInfo tagElementInfo = new SimpleElementInfo(tag.getName(),
                                    AbapTagsUIPlugin.getDefault()
                                        .getImage(StringUtil.isEmpty(tag.getOwner()) ? IImages.TAG : IImages.USER_TAG));
                                tagElementInfo.setAdditionalInfo(tag);
                                adtObjRefElemInfo.getChildren().add(tagElementInfo);
                            }
                            if (taggedObject.getTags().isEmpty()) {
                                adtObjRefElemInfo.getChildren()
                                    .add(new SimpleElementInfo(Messages.AbapTagExplorerView_NoTagsAssigned_xmsg));
                            }
                            return Arrays.asList(adtObjRefElemInfo);
                        }
                    } catch (final CoreException e) {
                        return Arrays.asList(new ErrorElementInfo(e.getMessage(), e));
                    }
                    return null;
                }

                @Override
                public String getProviderDescription() {
                    return Messages.AbapTagExplorerView_LoadingTaggedObjectInfoJob_xmsg;
                }
            }, null, null);
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
    private class ViewLabelProvider extends LabelProvider implements ILabelProvider, IStyledLabelProvider {

        @Override
        public Image getImage(final Object element) {
            Image image;
            final ITreeNode searchResult = (ITreeNode) element;
            image = searchResult.getImage();
            if (image == null && element instanceof IAdtObjectReferenceNode) {
                final IAdtObjectReferenceNode adtObjRefNode = (IAdtObjectReferenceNode) element;
                final IAdtObjectReference objRef = adtObjRefNode.getObjectReference();
                image = AdtTypeUtil.getInstance().getTypeImage(objRef.getType());
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
                    final IAdtObjectReferenceNode adtObjRefNode = (IAdtObjectReferenceNode) element;

                    String typeLabel = AdtTypeUtil.getInstance().getTypeDescription(adtObjRefNode.getAdtObjectType());
                    if (typeLabel == null) {
                        typeLabel = AdtTypeUtil.getInstance()
                            .getTypeDescriptionByProject(adtObjRefNode.getAdtObjectType(), getProject());
                    }
                    if (typeLabel != null) {
                        text.append(" (" + typeLabel + ")", StyledString.QUALIFIER_STYLER); //$NON-NLS-1$ //$NON-NLS-2$
                    }
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
                        StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR, null));
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

}
