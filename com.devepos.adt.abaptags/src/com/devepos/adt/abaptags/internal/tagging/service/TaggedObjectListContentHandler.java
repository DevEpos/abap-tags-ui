package com.devepos.adt.abaptags.internal.tagging.service;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.abaptags.ITaggedObjectList;
import com.devepos.adt.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.tools.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

public class TaggedObjectListContentHandler extends AbstractEmfContentHandler<ITaggedObjectList> {

	public TaggedObjectListContentHandler() {
		super(AdtMediaType.APPLICATION_XML, ".abaptaggedobjects");
	}

	@Override
	public Class<ITaggedObjectList> getSupportedDataType() {
		return ITaggedObjectList.class;
	}

	@Override
	protected Resource createResource() {
		return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
	}

	@Override
	protected ITaggedObjectList getRootElement(final EObject rootElement) {
		return (ITaggedObjectList) rootElement;
	}

}
