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
import org.eclipse.ui.actions.ActionFactory;
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
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.util.IImages;
import com.devepos.adt.atm.ui.internal.wizard.TagObjectsWizard;
import com.devepos.adt.tools.base.AdtToolsBaseResources;
import com.devepos.adt.tools.base.IAdtToolsBaseImages;
import com.devepos.adt.tools.base.IAdtToolsBaseStrings;
import com.devepos.adt.tools.base.adtobject.AdtObjectFactory;
import com.devepos.adt.tools.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.tools.base.adtobject.IAdtObject;
import com.devepos.adt.tools.base.destinations.DestinationUtil;
import com.devepos.adt.tools.base.elementinfo.AdtObjectReferenceElementInfo;
import com.devepos.adt.tools.base.elementinfo.ErrorElementInfo;
import com.devepos.adt.tools.base.elementinfo.IElementInfo;
import com.devepos.adt.tools.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.tools.base.elementinfo.LazyLoadingRefreshMode;
import com.devepos.adt.tools.base.elementinfo.SimpleElementInfo;
import com.devepos.adt.tools.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.tools.base.project.ProjectUtil;
import com.devepos.adt.tools.base.ui.IGeneralContextMenuConstants;
import com.devepos.adt.tools.base.ui.StylerFactory;
import com.devepos.adt.tools.base.ui.ViewDescriptionLabel;
import com.devepos.adt.tools.base.ui.ViewPartListener;
import com.devepos.adt.tools.base.ui.action.ActionUtil;
import com.devepos.adt.tools.base.ui.action.ChooseOtherAdtObjectAction;
import com.devepos.adt.tools.base.ui.action.CopyToClipboardAction;
import com.devepos.adt.tools.base.ui.action.ExecuteAdtObjectAction;
import com.devepos.adt.tools.base.ui.action.OpenAdtObjectAction;
import com.devepos.adt.tools.base.ui.action.PreferenceToggleAction;
import com.devepos.adt.tools.base.ui.menu.MenuItemFactory;
import com.devepos.adt.tools.base.ui.search.IAdtRisSearchResultProxy;
import com.devepos.adt.tools.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.tools.base.ui.tree.ICollectionTreeNode;
import com.devepos.adt.tools.base.ui.tree.ILazyLoadingNode;
import com.devepos.adt.tools.base.ui.tree.IStyledTreeNode;
import com.devepos.adt.tools.base.ui.tree.ITreeNode;
import com.devepos.adt.tools.base.ui.tree.LazyLoadingFolderNode;
import com.devepos.adt.tools.base.ui.tree.LazyLoadingTreeContentProvider;
import com.devepos.adt.tools.base.ui.tree.LoadingTreeItemsNode;
import com.devepos.adt.tools.base.util.AdtTypeUtil;
import com.devepos.adt.tools.base.util.AdtUtil;
import com.devepos.adt.tools.base.util.EditorUtil;
import com.devepos.adt.tools.base.util.ObjectUtil;
import com.devepos.adt.tools.base.util.StringUtil;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * View to explore ABAP Tags of currently selected ADT object
 *
 * @author stockbal
 */
public class AbapTagExplorerView extends ViewPart {

	public static final String VIEW_ID = "com.devepos.adt.atm.ui.views.AbapTagsExplorer"; //$NON-NLS-1$
	private static final String LINK_TO_EDITOR_PREF = "com.devepos.adt.atm.ui.views.AbapTagsExplorer.linkToEditor"; //$NON-NLS-1$
	private Composite mainComposite;
	private PreferenceToggleAction linkToEditorAction;
	private Action refreshAction;
	private IAdtObject currentAdtObject;
	private TreeViewer treeViewer;
	private Tree tree;
	private TreeInput treeResult;
	private ViewDescriptionLabel viewLabel;
	private Action addTagsAction;
	private Action otherObjectAction;
	private final IAbapTagsService abapTagsService;
	private CopyToClipboardAction copyToClipBoardAction;

	public AbapTagExplorerView() {
		this.abapTagsService = AbapTagsServiceFactory.createTagsService();
	}

	@Override
	public void createPartControl(final Composite parent) {
		this.mainComposite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(this.mainComposite);
		GridLayoutFactory.swtDefaults().margins(0, 0).applyTo(this.mainComposite);

		createViewer(this.mainComposite);
		this.viewLabel = new ViewDescriptionLabel(this.mainComposite);
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
		getSite().setSelectionProvider(this.treeViewer);
	}

	@Override
	public void setFocus() {
		if (this.tree != null && !this.tree.isDisposed()) {
			this.tree.setFocus();
		}
	}

	private void showTaggedObjectsForEditor(final IEditorPart editor) {
		if (editor == null) {
			return;
		}
		final IWorkbenchPage page = editor.getSite().getPage();
		if (this.linkToEditorAction.isChecked() && page.isPartVisible(this)) {
			final IAdtObject selObj = EditorUtil.getAdtObjectFromEditor(editor);
			updateInput(selObj, false);
		}
	}

	public void setInput(final IAdtObject newAdtObject) {
		updateInput(newAdtObject, true);
	}

	private void updateInputFromEditor() {
		final IAdtObject adtObject = EditorUtil.getAdtObjectFromActiveEditor();
		updateInput(adtObject, false);
	}

	private IProject getProject() {
		return this.currentAdtObject != null ? this.currentAdtObject.getProject() : null;
	}

	private void createViewer(final Composite parent) {
		this.treeViewer = new TreeViewer(parent, SWT.V_SCROLL | SWT.MULTI);
		this.tree = this.treeViewer.getTree();
		GridDataFactory.fillDefaults().grab(true, true).applyTo(this.tree);
		this.treeViewer.setContentProvider(new ContentProvider());
		this.treeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new ViewLabelProvider()));
		this.treeViewer.setUseHashlookup(true);
		this.treeViewer.addOpenListener(event -> {
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
						AdtUtil.navigateWithObjectReference(adtObjRefNode.getObjectReference(), getProject());
					}
				}
			}
		});

		this.treeResult = new TreeInput(this.treeViewer);
	}

	private void updateInput(final IAdtObject newAdtObject, final boolean forceUpdate) {
		if (!this.linkToEditorAction.isChecked() && !forceUpdate) {
			return;
		}
		if (ObjectUtil.equals(this.currentAdtObject, newAdtObject)) {
			return;
		}
		this.currentAdtObject = newAdtObject;
		if (this.currentAdtObject == null) {
			clearInput();
		} else {
			if (!ProjectUtil.isLoggedOnToProject(getProject())) {
				clearInput();
				return;
			}
			final IStatus abapTagsFeatureStatus = this.abapTagsService
				.testTagsFeatureAvailability(this.currentAdtObject.getProject());
			if (!abapTagsFeatureStatus.isOK()) {
				clearInput();
				this.viewLabel.updateLabel(abapTagsFeatureStatus.getMessage());
				return;
			}
			this.treeResult.updateInput(this.currentAdtObject.getReference().getUri());
			this.viewLabel.updateLabel(
				" [" + this.currentAdtObject.getProject().getName() + "] " + this.currentAdtObject.getName(), //$NON-NLS-1$ //$NON-NLS-2$
				this.currentAdtObject.getImage());
		}
	}

	private void initializeActions() {
		this.copyToClipBoardAction = new CopyToClipboardAction();
		this.copyToClipBoardAction.registerViewer(this.treeViewer);
		this.linkToEditorAction = new PreferenceToggleAction(Messages.AbapTagExplorerView_LinkToEditorAction_xtol,
			PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED),
			LINK_TO_EDITOR_PREF, true, AbapTagsUIPlugin.getDefault().getPreferenceStore());
		this.linkToEditorAction.addPropertyChangeListener(e -> {
			if (e.getProperty().equals(Action.CHECKED) && (Boolean) e.getNewValue()) {
				updateInputFromEditor();
			}
		});
		this.addTagsAction = ActionUtil.createAction(Messages.AbapTagExplorerView_AddTagsAction_xtol,
			AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.ASSIGN_TAG), () -> {
				final TagObjectsWizard wizard = new TagObjectsWizard(this.currentAdtObject != null);
				if (this.currentAdtObject != null) {
					wizard.setProject(this.currentAdtObject.getProject());
					final IAdtObjRefList adtObjRefList = IAdtBaseFactory.eINSTANCE.createAdtObjRefList();
					final IAdtObjRef adtObjRef = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
					adtObjRef.setUri(this.currentAdtObject.getReference().getUri());
					adtObjRef.setName(this.currentAdtObject.getReference().getName());
					adtObjRef.setType(this.currentAdtObject.getReference().getType());
					adtObjRefList.getObjectReferences().add(adtObjRef);
					wizard.setSelectedObjects(adtObjRefList);
				} else {
					wizard.setProject(ProjectUtil.getCurrentAbapProject());
				}
				final WizardDialog dialog = new WizardDialog(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
				dialog.open();
				if (this.currentAdtObject != null && wizard.wasSuccessful()) {
					refreshCurrentNode();
				}
			});
		this.refreshAction = ActionUtil.createAction(AdtToolsBaseResources.getString(IAdtToolsBaseStrings.Refresh),
			AdtToolsBaseResources.getImageDescriptor(IAdtToolsBaseImages.REFRESH), this::refreshCurrentNode);
		this.otherObjectAction = new ChooseOtherAdtObjectAction(false, this::onOtherObjectAction);
	}

	private void hookContextMenu() {
		final MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);

		menuMgr.addMenuListener(menu -> {
			fillContextMenu(menu);
		});
		final Control viewerControl = this.tree;
		final Menu menu = menuMgr.createContextMenu(viewerControl);
		viewerControl.setMenu(menu);
		getSite().registerContextMenu(getViewSite().getId(), menuMgr, this.treeViewer);
	}

	private void fillContextMenu(final IMenuManager menu) {
		final IStructuredSelection selection = this.treeViewer.getStructuredSelection();
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
				AdtToolsBaseResources.getImageDescriptor(IAdtToolsBaseImages.WHERE_USED_LIST),
				AdtToolsBaseResources.getString(IAdtToolsBaseStrings.General_WhereUsedList_xmit), null);
		}

		menu.add(new Separator(IGeneralContextMenuConstants.GROUP_EDIT));
		if (deleteTagsAction != null) {
			menu.appendToGroup(IGeneralContextMenuConstants.GROUP_EDIT, deleteTagsAction);
		}
		menu.appendToGroup(IGeneralContextMenuConstants.GROUP_EDIT, this.copyToClipBoardAction);
	}

	private void initToolbar(final IActionBars actionBars) {
		actionBars.setGlobalActionHandler(ActionFactory.REFRESH.getId(), this.refreshAction);
		final IToolBarManager tbm = actionBars.getToolBarManager();
		tbm.add(this.linkToEditorAction);
		tbm.add(new Separator());
		tbm.add(this.addTagsAction);
		tbm.add(new Separator());
		tbm.add(this.otherObjectAction);
		tbm.add(new Separator());
		tbm.add(this.refreshAction);
	}

	private void clearInput() {
		this.currentAdtObject = null;
		this.treeResult.clearInput();
		this.viewLabel.updateLabel(Messages.AbapTagExplorerView_NoInputAvailable_xmsg);
	}

	private void refreshCurrentNode() {
		this.treeResult.refresh();
	}

	private void onOtherObjectAction(final IAdtRisSearchResultProxy result) {
		if (result != null) {
			final IProject project = result.getSelectedProject();
			if (project != null) {
				final IStatus abapTagsFeatureStatus = this.abapTagsService.testTagsFeatureAvailability(project);
				if (!abapTagsFeatureStatus.isOK()) {
					clearInput();
					this.viewLabel.updateLabel(abapTagsFeatureStatus.getMessage());
					return;
				}
			} else {
				return;
			}

			final IAdtObjectReference objectRef = result.getFirstResult();
			if (objectRef != null) {
				updateInput(AdtObjectFactory.create(objectRef, project), true);
			}
		}
	}

	private class ContentProvider extends LazyLoadingTreeContentProvider {
		@Override
		public Object[] getElements(final Object inputElement) {

			if (inputElement instanceof ITreeNode) {
				if (inputElement instanceof ILazyLoadingNode) {
					final Object[] childNodes = getChildren(inputElement);
					return childNodes != null ? childNodes : new Object[0];
				} else {
					return new Object[] { inputElement };
				}
			}
			return super.getElements(inputElement);
		}
	}

	private class TreeInput {
		private final TreeViewer viewer;
		private ITreeNode currentInput;

		public TreeInput(final TreeViewer viewer) {
			this.viewer = viewer;
		}

		public void clearInput() {
			this.currentInput = null;
			this.viewer.setInput(null);
		}

		public void refresh() {
			if (this.currentInput != null && this.currentInput instanceof ILazyLoadingNode) {
				((ILazyLoadingNode) this.currentInput).resetLoadedState();
				this.viewer.refresh();
			}
		}

		public void updateInput(final String objectUri) {
			Assert.isNotNull(objectUri);

			final ILazyLoadingNode lazyLoadingNode = new LazyLoadingFolderNode("", new IElementInfoProvider() { //$NON-NLS-1$

				@Override
				public String getProviderDescription() {
					return Messages.AbapTagExplorerView_LoadingTaggedObjectInfoJob_xmsg;
				}

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
							adtObjRefElemInfo.setAdtObjectReference(AdtObjectReferenceModelFactory
								.createReference(destinationId, taggedObject.getObjectRef()));

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
			}, null, null);
			lazyLoadingNode.setContentRefreshMode(LazyLoadingRefreshMode.ROOT_AND_NON_LAZY_CHILDREN);
			this.currentInput = lazyLoadingNode;
			this.viewer.setInput(this.currentInput);
		}

	}

	/**
	 * Custom view label provider for the Result Tree
	 *
	 * @author stockbal
	 */
	private class ViewLabelProvider extends LabelProvider implements ILabelProvider, IStyledLabelProvider {

		@Override
		public String getText(final Object element) {
			final ITreeNode searchResult = (ITreeNode) element;

			return searchResult.getName();
		}

		@Override
		public Image getImage(final Object element) {
			Image image = null;
			final ITreeNode searchResult = (ITreeNode) element;
			image = searchResult.getImage();
			if (image == null) {

				if (element instanceof IAdtObjectReferenceNode) {
					final IAdtObjectReferenceNode adtObjRefNode = (IAdtObjectReferenceNode) element;
					final IAdtObjectReference objRef = adtObjRefNode.getObjectReference();
					image = AdtTypeUtil.getInstance().getTypeImage(objRef.getType());
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
				} else {
					text.append(treeNode.getDisplayName());
				}

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
	}

	private class DeleteTagsAction extends Action {
		private ITaggedObjectList tgobjList;
		private final Map<String, List<IAdtObjectTag>> tagMap = new HashMap<>();

		public DeleteTagsAction() {
			super(Messages.AbapTagExplorerView_DeleteTagAction_xmit,
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
		}

		public void addTag(final IAdtObjectTag tag, final ITreeNode tagNode) {
			if (this.tgobjList == null) {
				this.tgobjList = IAbapTagsFactory.eINSTANCE.createTaggedObjectList();
			}
			final ITreeNode parent = tagNode.getParent();
			String objectUri = null;
			if (parent != null && parent instanceof IAdtObjectReferenceNode) {
				objectUri = ((IAdtObjectReferenceNode) parent).getObjectReference().getUri();
			}

			List<IAdtObjectTag> tagList = null;
			if (objectUri != null) {
				tagList = this.tagMap.get(objectUri);
				if (tagList == null) {
					tagList = new ArrayList<>();
					this.tagMap.put(objectUri, tagList);
				}
			} else {
				return;
			}
			tagList.add(tag);
		}

		@Override
		public void run() {
			final ITaggedObjectList tgobjList = IAbapTagsFactory.eINSTANCE.createTaggedObjectList();

			for (final String objectUri : this.tagMap.keySet()) {
				final ITaggedObject taggedObject = IAbapTagsFactory.eINSTANCE.createTaggedObject();
				final IAdtObjRef objectRef = IAdtBaseFactory.eINSTANCE.createAdtObjRef();
				objectRef.setUri(objectUri);
				taggedObject.setObjectRef(objectRef);
				taggedObject.getTags().addAll(this.tagMap.get(objectUri));
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

}
