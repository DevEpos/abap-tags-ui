package com.devepos.adt.atm.internal.tagging;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckResult;
import com.devepos.adt.atm.model.abaptags.util.AbapTagsResourceFactory;
import com.devepos.adt.base.content.AbstractEmfContentHandler;
import com.sap.adt.communication.content.AdtMediaType;

/**
 * Content Handler for {@link ITaggedObjectDeletionCheckResult}
 *
 * @author Ludwig Stockbauer-Muhr
 */
public class TaggedObjectDelCheckResultContentHandler extends
    AbstractEmfContentHandler<ITaggedObjectDeletionCheckResult> {

  public TaggedObjectDelCheckResultContentHandler() {
    super(AdtMediaType.APPLICATION_XML, ".tgobjDelCheckResult");
  }

  @Override
  public Class<ITaggedObjectDeletionCheckResult> getSupportedDataType() {
    return ITaggedObjectDeletionCheckResult.class;
  }

  @Override
  protected Resource createResource() {
    return new AbapTagsResourceFactory().createResource(getVirtualResourceUri());
  }

  @Override
  protected ITaggedObjectDeletionCheckResult getRootElement(final EObject rootElement) {
    return (ITaggedObjectDeletionCheckResult) rootElement;
  }

}
