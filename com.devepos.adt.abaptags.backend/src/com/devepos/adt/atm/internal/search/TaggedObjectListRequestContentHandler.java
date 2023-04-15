package com.devepos.adt.atm.internal.search;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectListRequest;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

public class TaggedObjectListRequestContentHandler extends
    AbstractEmfContentHandler<ITaggedObjectListRequest> {

  public TaggedObjectListRequestContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".taggedObjectInfoGetRequest");
  }

  @Override
  public Class<ITaggedObjectListRequest> getSupportedDataType() {
    return ITaggedObjectListRequest.class;
  }

  @Override
  protected Resource createResource() {
    return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ITaggedObjectListRequest getRootElement(final EObject rootElement) {
    return (ITaggedObjectListRequest) rootElement;
  }

}
