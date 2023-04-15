/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Object Delete Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeleteRequest#getObjectId <em>Object
 * Id</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectDeleteRequest()
 * @model extendedMetaData="kind='elementOnly' name='taggedObjectDelRequest'"
 * @generated
 */
public interface ITaggedObjectDeleteRequest extends EObject {
  /**
   * Returns the value of the '<em><b>Object Id</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Object Id</em>' attribute list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectDeleteRequest_ObjectId()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="name='taggedObjectId' namespace='##targetNamespace' kind='element'"
   * @generated
   */
  EList<String> getObjectId();

} // ITaggedObjectDeleteRequest
