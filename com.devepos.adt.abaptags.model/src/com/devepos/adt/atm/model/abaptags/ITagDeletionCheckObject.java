/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.base.model.adtbase.MessageType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag Deletion Check Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject#getTagId <em>Tag
 * Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject#isDeletable
 * <em>Deletable</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject#getMessage
 * <em>Message</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject#getMessageType <em>Message
 * Type</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagDeletionCheckObject()
 * @model extendedMetaData="kind='elementOnly' name='checkedTag'"
 * @generated
 */
public interface ITagDeletionCheckObject extends EObject {
  /**
   * Returns the value of the '<em><b>Tag Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tag Id</em>' attribute.
   * @see #setTagId(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagDeletionCheckObject_TagId()
   * @model extendedMetaData="name='tagId' namespace='##targetNamespace' kind='attribute'"
   * @generated
   */
  String getTagId();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject#getTagId <em>Tag Id</em>}'
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
   * Returns the value of the '<em><b>Deletable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Deletable</em>' attribute.
   * @see #setDeletable(boolean)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagDeletionCheckObject_Deletable()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
   *        extendedMetaData="kind='attribute' name='isDeletable' namespace='##targetNamespace'"
   * @generated
   */
  boolean isDeletable();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject#isDeletable
   * <em>Deletable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Deletable</em>' attribute.
   * @see #isDeletable()
   * @generated
   */
  void setDeletable(boolean value);

  /**
   * Returns the value of the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Message</em>' attribute.
   * @see #setMessage(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagDeletionCheckObject_Message()
   * @model extendedMetaData="kind='attribute' name='message' namespace='##targetNamespace'"
   * @generated
   */
  String getMessage();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject#getMessage
   * <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Message</em>' attribute.
   * @see #getMessage()
   * @generated
   */
  void setMessage(String value);

  /**
   * Returns the value of the '<em><b>Message Type</b></em>' attribute.
   * The literals are from the enumeration {@link com.devepos.adt.base.model.adtbase.MessageType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Message Type</em>' attribute.
   * @see com.devepos.adt.base.model.adtbase.MessageType
   * @see #setMessageType(MessageType)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagDeletionCheckObject_MessageType()
   * @model extendedMetaData="kind='attribute' name='messageType' namespace='##targetNamespace'"
   * @generated
   */
  MessageType getMessageType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject#getMessageType <em>Message
   * Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Message Type</em>' attribute.
   * @see com.devepos.adt.base.model.adtbase.MessageType
   * @see #getMessageType()
   * @generated
   */
  void setMessageType(MessageType value);

} // ITagDeletionCheckObject
