package com.devepos.adt.atm.internal.tags;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.atm.model.abaptags.ITagDeletionCheckResult;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

public class TagDeletionCheckResultContentHandler extends
    AbstractEmfContentHandler<ITagDeletionCheckResult> {

  public TagDeletionCheckResultContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".tagdeletioncheckresult");
  }

  @Override
  public Class<ITagDeletionCheckResult> getSupportedDataType() {
    return ITagDeletionCheckResult.class;
  }

  @Override
  protected Resource createResource() {
    return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ITagDeletionCheckResult getRootElement(final EObject rootElement) {
    return (ITagDeletionCheckResult) rootElement;
  }

}
