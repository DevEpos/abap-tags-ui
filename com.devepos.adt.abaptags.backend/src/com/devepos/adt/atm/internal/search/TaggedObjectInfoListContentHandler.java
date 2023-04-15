package com.devepos.adt.atm.internal.search;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfoList;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

public class TaggedObjectInfoListContentHandler extends
    AbstractEmfContentHandler<ITaggedObjectInfoList> {

  public TaggedObjectInfoListContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".taggedObjectInfoList");
  }

  @Override
  public Class<ITaggedObjectInfoList> getSupportedDataType() {
    return ITaggedObjectInfoList.class;
  }

  @Override
  protected Resource createResource() {
    return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ITaggedObjectInfoList getRootElement(final EObject rootElement) {
    return (ITaggedObjectInfoList) rootElement;
  }

}
