package com.devepos.adt.atm.internal.search;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

public class TagSearchParamsContentHandler extends
    AbstractEmfContentHandler<ITaggedObjectSearchParams> {

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
