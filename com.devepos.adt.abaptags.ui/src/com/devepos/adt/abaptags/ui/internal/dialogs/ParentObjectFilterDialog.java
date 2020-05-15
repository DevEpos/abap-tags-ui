package com.devepos.adt.abaptags.ui.internal.dialogs;

import java.util.Comparator;
import java.util.Locale;

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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.ui.dialogs.SearchPattern;

import com.devepos.adt.abaptags.ITaggedObjectList;
import com.devepos.adt.abaptags.TagSearchScope;
import com.devepos.adt.abaptags.search.ITaggedObjectSearchParameters;
import com.devepos.adt.abaptags.search.ITaggedObjectSearchService;
import com.devepos.adt.abaptags.search.TaggedObjectSearchFactory;
import com.devepos.adt.abaptags.ui.AbapTagsUIPlugin;
import com.devepos.adt.abaptags.ui.internal.messages.Messages;
import com.devepos.adt.tools.base.AdtToolsBasePlugin;
import com.devepos.adt.tools.base.IGeneralWorkbenchImages;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRef;
import com.sap.adt.tools.core.ui.AbapCoreUi;
import com.sap.adt.tools.core.ui.IAdtObjectTypeInfoUi;
import com.sap.adt.tools.core.ui.IAdtObjectTypeRegistryUi;

public class ParentObjectFilterDialog extends FilteredItemsSelectionDialog {
	public static final String DIALOG_SETTINGS_NAME = ParentObjectFilterDialog.class.getCanonicalName();
	private final String tagName;
	private final TagSearchScope searchScope;
	private final String destinationId;
	private boolean firstFilter = true;
	private final IAdtObjectTypeRegistryUi typeRegistryUi;
	private final Comparator<IAdtObjRef> itemsComparator;

	public ParentObjectFilterDialog(final Shell shell, final String destinationId, final String tagName,
		final TagSearchScope searchScope) {
		super(shell, false);
		setTitle(Messages.ParentObjectFilterDialog_Title_xtit);
		setMessage(Messages.ParentObjectFilterDialog_FilterText_xmsg);
		this.tagName = tagName;
		this.destinationId = destinationId;
		this.searchScope = searchScope;
		this.typeRegistryUi = AbapCoreUi.getObjectTypeRegistry();
		this.itemsComparator = (o1, o2) -> {
			if (o1 == null) {
				return -1;
			}
			if (o2 == null) {
				return 1;
			}
			return o1.getName().compareTo(o2.getName());
		};
		setListLabelProvider(new ItemsLabelProvider());
		setDetailsLabelProvider(new ItemsLabelProvider());
	}

	@Override
	protected Control createExtendedContentArea(final Composite parent) {
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

	@Override
	protected ItemsFilter createFilter() {
		final Control patternControl = getPatternControl();
		if (patternControl == null || patternControl.isDisposed()) {
			return null;
		}
		final ParentObjectItemsFilter filter = new ParentObjectItemsFilter(new SearchPattern());
		if (this.firstFilter) {
			filter.setPattern("*"); //$NON-NLS-1$
			this.firstFilter = false;
		}
		return filter;
	}

	@Override
	protected Comparator<IAdtObjRef> getItemsComparator() {
		return this.itemsComparator;
	}

	@Override
	protected void fillContentProvider(final AbstractContentProvider contentProvider, final ItemsFilter itemsFilter,
		final IProgressMonitor progressMonitor) throws CoreException {

		final ITaggedObjectSearchParameters parameters = TaggedObjectSearchFactory.createParameters();
		final ITaggedObjectSearchService service = TaggedObjectSearchFactory.createTaggedObjectSearchService();

		parameters.setTags(this.tagName);
		parameters.setSearchScope(this.searchScope);
		parameters.setMaxResult(50);
		parameters.setQuery(itemsFilter.getPattern());

		final ITaggedObjectList taggedObjects = service.findObjects(this.destinationId, parameters);
		if (taggedObjects != null && !taggedObjects.getTaggedObjects().isEmpty()) {
			taggedObjects.getTaggedObjects().forEach(obj -> contentProvider.add(obj.getObjectRef(), itemsFilter));
		}
	}

	@Override
	public String getElementName(final Object item) {
		if (item instanceof IAdtObjRef) {
			return ((IAdtObjRef) item).getName();
		}
		return null;
	}

	private final class ParentObjectItemsFilter extends ItemsFilter {

		public ParentObjectItemsFilter(final SearchPattern searchPattern) {
			super(searchPattern);
		}

		public void setPattern(final String pattern) {
			this.patternMatcher.setPattern(pattern);
		}

		@Override
		public boolean matchItem(final Object item) {
			if (item instanceof IAdtObjRef) {
				final SearchPattern searchPattern = new SearchPattern();
				searchPattern.setPattern(getPattern().toLowerCase(Locale.ENGLISH));
				return searchPattern.matches(((IAdtObjRef) item).getName().toLowerCase(Locale.ENGLISH));
			}
			return false;
		}

		@Override
		public boolean isConsistentItem(final Object item) {
			return true;
		}
	}

	private class ItemsLabelProvider extends LabelProvider implements DelegatingStyledCellLabelProvider.IStyledLabelProvider {

		@Override
		public StyledString getStyledText(final Object element) {
			final StyledString text = new StyledString();
			if (element != null && element instanceof IAdtObjRef) {
				final IAdtObjRef objRef = (IAdtObjRef) element;
				text.append(objRef.getName());

				final String description = objRef.getDescription();
				if (description != null && !description.isEmpty()) {
					text.append(" " + objRef.getDescription(), StyledString.DECORATIONS_STYLER); //$NON-NLS-1$
				}
			}
			return text;
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
					return AdtToolsBasePlugin.getDefault().getImage(IGeneralWorkbenchImages.SAP_GUI_OBJECT);
				}
			}
			return null;
		}

	}
}
