package com.devepos.adt.atm.ui.internal.dialogs;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.search.ITaggedObjectSearchService;
import com.devepos.adt.atm.search.TaggedObjectSearchFactory;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.tools.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.tools.base.ui.StylerFactory;
import com.devepos.adt.tools.base.ui.dialogs.AdtFilteredItemsSelectionDialog;
import com.devepos.adt.tools.base.util.AdtTypeUtil;
import com.devepos.adt.tools.base.util.StringUtil;

public class ParentObjectFilterDialog extends AdtFilteredItemsSelectionDialog<IAdtObjRef> {
	private final String tagId;
	private final TagSearchScope searchScope;
	private final String destinationId;
	private final ITaggedObjectSearchParams parameters;
	private final ITaggedObjectSearchService service;

	public ParentObjectFilterDialog(final Shell shell, final String destinationId, final String tagId,
		final TagSearchScope searchScope) {
		super(shell, false);
		this.tagId = tagId;
		this.destinationId = destinationId;
		this.searchScope = searchScope;

		setTitle(Messages.ParentObjectFilterDialog_Title_xtit);
		setMessage(Messages.ParentObjectFilterDialog_FilterText_xmsg);
		setListLabelProvider(new ItemsLabelProvider());
		setDetailsLabelProvider(new ItemsLabelProvider());
		setInitialPattern("*");
		setInitialJobDelay(0L);

		this.parameters = IAbapTagsFactory.eINSTANCE.createTaggedObjectSearchParams();

		this.parameters.getTagIds().add(this.tagId);
		this.parameters.setSearchScope(this.searchScope);
		this.parameters.setMaxResults(50);
		this.service = TaggedObjectSearchFactory.createTaggedObjectSearchService();
	}

	@Override
	protected AdtFilteredItemsSelectionDialog<IAdtObjRef>.SearchResultObject<IAdtObjRef> performSearch(
		final String pattern, final IProgressMonitor monitor) throws CoreException {
		this.parameters.setQuery(pattern);
		final ITaggedObjectList taggedObjects = this.service.findObjects(ParentObjectFilterDialog.this.destinationId,
			ParentObjectFilterDialog.this.parameters);
		if (taggedObjects != null && !taggedObjects.getTaggedObjects().isEmpty()) {
			return new SearchResultObject<>(
				taggedObjects.getTaggedObjects()
					.stream()
					.limit(this.parameters.getMaxResults())
					.map(ITaggedObject::getObjectRef)
					.collect(Collectors.toList()),
				taggedObjects.getTaggedObjects().size() <= this.parameters.getMaxResults());
		}
		return new SearchResultObject<>(new ArrayList<>(), true);
	}

	private class ItemsLabelProvider extends LabelProvider
		implements DelegatingStyledCellLabelProvider.IStyledLabelProvider {

		@Override
		public StyledString getStyledText(final Object element) {
			final StyledString text = new StyledString();
			if (element != null && element instanceof IAdtObjRef) {
				final IAdtObjRef objRef = (IAdtObjRef) element;
				text.append(objRef.getName());

				final String description = objRef.getDescription();
				if (!StringUtil.isEmpty(description)) {
					text.append("  " + objRef.getDescription(), //$NON-NLS-1$
						StylerFactory.createCustomStyler(SWT.ITALIC, JFacePreferences.DECORATIONS_COLOR, null));
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
				return AdtTypeUtil.getInstance().getTypeImage(ref.getType());
			}
			return null;
		}

	}

}
