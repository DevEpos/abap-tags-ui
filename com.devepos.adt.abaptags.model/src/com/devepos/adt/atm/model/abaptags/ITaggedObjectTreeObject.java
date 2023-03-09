/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.base.model.adtbase.IAdtObjRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Object Tree Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#getObjectRef <em>Object
 * Ref</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#getTaggedObjectCount
 * <em>Tagged Object Count</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#getParentTagId <em>Parent
 * Tag Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#isExpandable
 * <em>Expandable</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectTreeObject()
 * @model extendedMetaData="kind='elementOnly' name='object'"
 * @generated
 */
public interface ITaggedObjectTreeObject extends EObject {
  /**
   * Returns the value of the '<em><b>Object Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Object Ref</em>' containment reference.
   * @see #setObjectRef(IAdtObjRef)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectTreeObject_ObjectRef()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='adtObjRef'
   *        namespace='http://www.devepos.com/adt/base'"
   * @generated
   */
  IAdtObjRef getObjectRef();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#getObjectRef <em>Object
   * Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Object Ref</em>' containment reference.
   * @see #getObjectRef()
   * @generated
   */
  void setObjectRef(IAdtObjRef value);

  /**
   * Returns the value of the '<em><b>Tagged Object Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tagged Object Count</em>' attribute.
   * @see #setTaggedObjectCount(int)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectTreeObject_TaggedObjectCount()
   * @model transient="true"
   *        extendedMetaData="kind='attribute' name='taggedObjectCount'
   *        namespace='##targetNamespace'"
   * @generated
   */
  int getTaggedObjectCount();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#getTaggedObjectCount
   * <em>Tagged Object Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Tagged Object Count</em>' attribute.
   * @see #getTaggedObjectCount()
   * @generated
   */
  void setTaggedObjectCount(int value);

  /**
   * Returns the value of the '<em><b>Parent Tag Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Parent Tag Id</em>' attribute.
   * @see #setParentTagId(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectTreeObject_ParentTagId()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" transient="true"
   *        extendedMetaData="kind='attribute' name='parentTagId' namespace='##targetNamespace'"
   * @generated
   */
  String getParentTagId();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#getParentTagId <em>Parent
   * Tag Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Parent Tag Id</em>' attribute.
   * @see #getParentTagId()
   * @generated
   */
  void setParentTagId(String value);

  /**
   * Returns the value of the '<em><b>Expandable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Expandable</em>' attribute.
   * @see #setExpandable(boolean)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectTreeObject_Expandable()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean" transient="true"
   *        extendedMetaData="kind='attribute' name='expandable' namespace='##targetNamespace'"
   * @generated
   */
  boolean isExpandable();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#isExpandable
   * <em>Expandable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Expandable</em>' attribute.
   * @see #isExpandable()
   * @generated
   */
  void setExpandable(boolean value);

} // ITaggedObjectTreeObject
