package com.devepos.adt.atm.internal.tree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

public class TaggedObjectTreeResultContentHandler extends
    AbstractEmfContentHandler<ITaggedObjectTreeResult> {

  public TaggedObjectTreeResultContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".taggedobjecttreeresult");
  }

  @Override
  public Class<ITaggedObjectTreeResult> getSupportedDataType() {
    return ITaggedObjectTreeResult.class;
  }

  @Override
  protected Resource createResource() {
    return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ITaggedObjectTreeResult getRootElement(final EObject rootElement) {
    return (ITaggedObjectTreeResult) rootElement;
  }

}
