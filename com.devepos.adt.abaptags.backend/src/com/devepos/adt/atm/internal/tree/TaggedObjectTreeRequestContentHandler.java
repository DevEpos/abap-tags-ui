package com.devepos.adt.atm.internal.tree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

public class TaggedObjectTreeRequestContentHandler extends
    AbstractEmfContentHandler<ITaggedObjectTreeRequest> {

  public TaggedObjectTreeRequestContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".taggedobjecttreerequest");
  }

  @Override
  public Class<ITaggedObjectTreeRequest> getSupportedDataType() {
    return ITaggedObjectTreeRequest.class;
  }

  @Override
  protected Resource createResource() {
    return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ITaggedObjectTreeRequest getRootElement(final EObject rootElement) {
    return (ITaggedObjectTreeRequest) rootElement;
  }

}
