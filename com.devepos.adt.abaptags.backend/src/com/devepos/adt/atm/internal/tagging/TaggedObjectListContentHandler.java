package com.devepos.adt.atm.internal.tagging;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
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
