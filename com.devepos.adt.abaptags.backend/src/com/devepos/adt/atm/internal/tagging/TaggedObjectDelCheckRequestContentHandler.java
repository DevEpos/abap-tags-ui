package com.devepos.adt.atm.internal.tagging;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckRequest;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

/**
 * Content Handler for {@link ITaggedObjectDeletionCheckRequest}
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class TaggedObjectDelCheckRequestContentHandler extends
    AbstractEmfContentHandler<ITaggedObjectDeletionCheckRequest> {

  public TaggedObjectDelCheckRequestContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".tgobjDelChkRequest");
  }

  @Override
  public Class<ITaggedObjectDeletionCheckRequest> getSupportedDataType() {
    return ITaggedObjectDeletionCheckRequest.class;
  }

  @Override
  protected Resource createResource() {
    return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ITaggedObjectDeletionCheckRequest getRootElement(final EObject rootElement) {
    return (ITaggedObjectDeletionCheckRequest) rootElement;
  }

}
