package com.devepos.adt.atm.internal.tags;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.tools.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

/**
 * Content Handler for ABAP Tags
 *
 * @author stockbal
 */
public class AbapTagsContentHandler extends AbstractEmfContentHandler<ITagList> {

	public AbapTagsContentHandler() {
		super(AdtMediaType.APPLICATION_XML, ".abaptags");
	}

	@Override
	public Class<ITagList> getSupportedDataType() {
		return ITagList.class;
	}

	@Override
	protected Resource createResource() {
		return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
	}

	@Override
	protected ITagList getRootElement(final EObject rootElement) {
		return (ITagList) rootElement;
	}

}
