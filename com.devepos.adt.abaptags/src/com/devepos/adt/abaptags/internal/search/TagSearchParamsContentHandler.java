package com.devepos.adt.abaptags.internal.search;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.tools.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

public class TagSearchParamsContentHandler extends AbstractEmfContentHandler<ITaggedObjectSearchParams> {

	public TagSearchParamsContentHandler() {
		super(AdtMediaType.APPLICATION_XML, ".tagsearchparams");
	}

	@Override
	public Class<ITaggedObjectSearchParams> getSupportedDataType() {
		return ITaggedObjectSearchParams.class;
	}

	@Override
	protected Resource createResource() {
		return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
	}

	@Override
	protected ITaggedObjectSearchParams getRootElement(final EObject rootElement) {
		return (ITaggedObjectSearchParams) rootElement;
	}

}
