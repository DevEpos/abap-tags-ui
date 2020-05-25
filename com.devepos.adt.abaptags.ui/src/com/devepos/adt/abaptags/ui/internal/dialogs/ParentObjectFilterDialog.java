package com.devepos.adt.abaptags.ui.internal.dialogs;

import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.devepos.adt.abaptags.IAbapTagsFactory;
import com.devepos.adt.abaptags.ITaggedObjectList;
import com.devepos.adt.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.abaptags.TagSearchScope;
import com.devepos.adt.abaptags.search.ITaggedObjectSearchService;
import com.devepos.adt.abaptags.search.TaggedObjectSearchFactory;
import com.devepos.adt.abaptags.ui.AbapTagsUIPlugin;
import com.devepos.adt.abaptags.ui.internal.messages.Messages;
import com.devepos.adt.tools.base.AdtToolsBaseResources;
import com.devepos.adt.tools.base.IAdtToolsBaseImages;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.tools.base.ui.StylerFactory;
import com.sap.adt.tools.core.ui.AbapCoreUi;
import com.sap.adt.tools.core.ui.IAdtObjectTypeInfoUi;
import com.sap.adt.tools.core.ui.IAdtObjectTypeRegistryUi;
import com.sap.ide.platform.common.ui.dialogs.ScopedFilteredItemsSelectionDialog;

@SuppressWarnings("restriction")
public class ParentObjectFilterDialog extends ScopedFilteredItemsSelectionDialog<String, IAdtObjRef> {
	public static final String DIALOG_SETTINGS_NAME = ParentObjectFilterDialog.class.getCanonicalName();
	private final String tagId;
	private final TagSearchScope searchScope;
	private final String destinationId;
	private final IAdtObjectTypeRegistryUi typeRegistryUi;
	private final ITaggedObjectSearchParams parameters;

	public ParentObjectFilterDialog(final Shell shell, final String destinationId, final String tagId,
		final TagSearchScope searchScope) {
		super(shell, false, false);
		setTitle(Messages.ParentObjectFilterDialog_Title_xtit);
		setMessage(Messages.ParentObjectFilterDialog_FilterText_xmsg);
		this.tagId = tagId;
		this.destinationId = destinationId;
		this.searchScope = searchScope;
		this.typeRegistryUi = AbapCoreUi.getObjectTypeRegistry();
		setListLabelProvider(new ItemsLabelProvider());
		setDetailsLabelProvider(new ItemsLabelProvider());
		setInitialPattern("*");
		setInitialSearchScope(destinationId);

		this.parameters = IAbapTagsFactory.eINSTANCE.createTaggedObjectSearchParams();

		this.parameters.getTagIds().add(this.tagId);
		this.parameters.setSearchScope(this.searchScope);
		this.parameters.setMaxResults(50);
	}

	@Override
	public IAdtObjRef getFirstResult() {
		final IAdtObjRef[] results = getTypedResult();
		if (results != null && results.length > 0) {
			return results[0];
		}
		return null;
	}

	@Override
	protected Composite createSearchScopeSection(final Composite var1) {
		return null;
	}

	@Override
	protected String readSearchScope(final String var1) {
		return null;
	}

	@Override
	protected String writeSearchScope(final String var1) {
		return null;
	}

	@Override
	protected IAdtObjRef readResultEntry(final String var1) {
		return null;
	}

	@Override
	protected String writeResultEntry(final IAdtObjRef var1) {
		return null;
	}

	@Override
	protected IStatus isValidScope(final String var1) {
		return INVISIBLE_OK_STATUS;
	}

	@Override
	protected ScopedFilteredItemsSelectionDialog<String, IAdtObjRef>.SearchResultObject<IAdtObjRef> performSearch(
		final String scope, final String searchPattern, final IProgressMonitor monitor) throws CoreException {
		final ITaggedObjectSearchService service = TaggedObjectSearchFactory.createTaggedObjectSearchService();

		this.parameters.setQuery(searchPattern);

		final ITaggedObjectList taggedObjects = service.findObjects(this.destinationId, this.parameters);
		if (taggedObjects != null && !taggedObjects.getTaggedObjects().isEmpty()) {
			return new SearchResultObject<>(
				taggedObjects.getTaggedObjects().stream().map(tgobj -> tgobj.getObjectRef()).collect(Collectors.toList()), true);
		}
		return null;
	}

	@Override
	protected String getHelpContext() {
		return null;
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		return AbapTagsUIPlugin.getDefault().getDialogSettingsSection(DIALOG_SETTINGS_NAME);
	}

	@Override
	protected IStatus validateItem(final Object item) {
		return Status.OK_STATUS;
	}

	private class ItemsLabelProvider extends LabelProvider implements DelegatingStyledCellLabelProvider.IStyledLabelProvider {

		@Override
		public StyledString getStyledText(final Object element) {
			StyledString text = null;
			if (element != null && element instanceof IAdtObjRef) {
				final IAdtObjRef objRef = (IAdtObjRef) element;
				text = getStyledStringHighlighter().highlight(objRef.getName(), getSearchPattern(), StylerFactory.BOLD_STYLER);

				final String description = objRef.getDescription();
				if (description != null && !description.isEmpty()) {
					text.append(" " + objRef.getDescription(), StyledString.DECORATIONS_STYLER); //$NON-NLS-1$
				}
			}
			return text != null ? text : new StyledString();
		}

		@Override
		public String getText(final Object element) {
			if (element != null && element instanceof IAdtObjRef) {
				final IAdtObjRef objRef = (IAdtObjRef) element;
				return objRef.getName();
			}
			return super.getText(element);
		}

		@Override
		public Image getImage(final Object element) {
			if (element != null && element instanceof IAdtObjRef) {
				final IAdtObjRef ref = (IAdtObjRef) element;
				final IAdtObjectTypeInfoUi type = ParentObjectFilterDialog.this.typeRegistryUi
					.getObjectTypeByGlobalWorkbenchType(ref.getType());
				if (type != null) {
					return type.getImage();
				} else {
					return AdtToolsBaseResources.getImage(IAdtToolsBaseImages.SAP_GUI_OBJECT);
				}
			}
			return null;
		}

	}
}
