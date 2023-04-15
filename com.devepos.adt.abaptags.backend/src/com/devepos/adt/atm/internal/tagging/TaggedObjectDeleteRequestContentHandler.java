package com.devepos.adt.atm.internal.tagging;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeleteRequest;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

public class TaggedObjectDeleteRequestContentHandler extends
    AbstractEmfContentHandler<ITaggedObjectDeleteRequest> {

  public TaggedObjectDeleteRequestContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".taggedObjectDelRequest");
  }

  @Override
  public Class<ITaggedObjectDeleteRequest> getSupportedDataType() {
    return ITaggedObjectDeleteRequest.class;
  }

  @Override
  protected Resource createResource() {
    return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ITaggedObjectDeleteRequest getRootElement(final EObject rootElement) {
    return (ITaggedObjectDeleteRequest) rootElement;
  }

}
