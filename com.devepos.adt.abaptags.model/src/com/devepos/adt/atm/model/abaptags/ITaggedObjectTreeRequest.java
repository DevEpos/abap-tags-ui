/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Object Tree Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest#getTagId <em>Tag
 * Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest#getParentObjectName
 * <em>Parent Object Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest#getParentObjectType
 * <em>Parent Object Type</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectTreeRequest()
 * @model extendedMetaData="kind='elementOnly' name='taggedObjectTreeRequest'"
 * @generated
 */
public interface ITaggedObjectTreeRequest extends EObject {
  /**
   * Returns the value of the '<em><b>Tag Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tag Id</em>' attribute.
   * @see #setTagId(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectTreeRequest_TagId()
   * @model extendedMetaData="name='tagId' namespace='##targetNamespace' kind='attribute'"
   * @generated
   */
  String getTagId();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest#getTagId <em>Tag Id</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Tag Id</em>' attribute.
   * @see #getTagId()
   * @generated
   */
  void setTagId(String value);

  /**
   * Returns the value of the '<em><b>Parent Object Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Parent Object Name</em>' attribute.
   * @see #setParentObjectName(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectTreeRequest_ParentObjectName()
   * @model extendedMetaData="kind='attribute' name='parentObjectName'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getParentObjectName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest#getParentObjectName
   * <em>Parent Object Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Parent Object Name</em>' attribute.
   * @see #getParentObjectName()
   * @generated
   */
  void setParentObjectName(String value);

  /**
   * Returns the value of the '<em><b>Parent Object Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Parent Object Type</em>' attribute.
   * @see #setParentObjectType(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectTreeRequest_ParentObjectType()
   * @model extendedMetaData="kind='attribute' name='parentObjectType'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getParentObjectType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest#getParentObjectType
   * <em>Parent Object Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Parent Object Type</em>' attribute.
   * @see #getParentObjectType()
   * @generated
   */
  void setParentObjectType(String value);

} // ITaggedObjectTreeRequest
