/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Object Deletion Check Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckRequest#getTaggedObjectIds
 * <em>Tagged Object Ids</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectDeletionCheckRequest()
 * @model extendedMetaData="kind='elementOnly' name='taggedObjectDelCheckRequest'"
 * @generated
 */
public interface ITaggedObjectDeletionCheckRequest extends EObject {
  /**
   * Returns the value of the '<em><b>Tagged Object Ids</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tagged Object Ids</em>' attribute list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectDeletionCheckRequest_TaggedObjectIds()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='element' namespace='##targetNamespace' name='taggedObjectId'"
   * @generated
   */
  EList<String> getTaggedObjectIds();

} // ITaggedObjectDeletionCheckRequest
