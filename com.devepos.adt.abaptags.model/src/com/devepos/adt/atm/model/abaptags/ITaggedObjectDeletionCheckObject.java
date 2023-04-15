/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.base.model.adtbase.MessageType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Object Deletion Check Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject#getTaggedObjectId
 * <em>Tagged Object Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject#isDeletable
 * <em>Deletable</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject#getMessage
 * <em>Message</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject#getMessageType
 * <em>Message Type</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject#getDependentObjectIds
 * <em>Dependent Object Ids</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectDeletionCheckObject()
 * @model extendedMetaData="kind='elementOnly' name='taggedObjectDeletionCheckObject'"
 * @generated
 */
public interface ITaggedObjectDeletionCheckObject extends EObject {
  /**
   * Returns the value of the '<em><b>Tagged Object Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tagged Object Id</em>' attribute.
   * @see #setTaggedObjectId(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectDeletionCheckObject_TaggedObjectId()
   * @model extendedMetaData="name='taggedObjectId' namespace='##targetNamespace' kind='attribute'"
   * @generated
   */
  String getTaggedObjectId();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject#getTaggedObjectId
   * <em>Tagged Object Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Tagged Object Id</em>' attribute.
   * @see #getTaggedObjectId()
   * @generated
   */
  void setTaggedObjectId(String value);

  /**
   * Returns the value of the '<em><b>Deletable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Deletable</em>' attribute.
   * @see #setDeletable(boolean)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectDeletionCheckObject_Deletable()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
   *        extendedMetaData="kind='attribute' name='deletable' namespace='##targetNamespace'"
   * @generated
   */
  boolean isDeletable();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject#isDeletable
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
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectDeletionCheckObject_Message()
   * @model extendedMetaData="kind='attribute' name='message' namespace='##targetNamespace'"
   * @generated
   */
  String getMessage();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject#getMessage
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
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectDeletionCheckObject_MessageType()
   * @model extendedMetaData="kind='attribute' name='messageType' namespace='##targetNamespace'"
   * @generated
   */
  MessageType getMessageType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject#getMessageType
   * <em>Message Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Message Type</em>' attribute.
   * @see com.devepos.adt.base.model.adtbase.MessageType
   * @see #getMessageType()
   * @generated
   */
  void setMessageType(MessageType value);

  /**
   * Returns the value of the '<em><b>Dependent Object Ids</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Dependent Object Ids</em>' attribute list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectDeletionCheckObject_DependentObjectIds()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='element' name='dependentObjectId' namespace='##targetNamespace'"
   * @generated
   */
  EList<String> getDependentObjectIds();

} // ITaggedObjectDeletionCheckObject
