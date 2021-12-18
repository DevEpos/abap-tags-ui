/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Tag
 * Base</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITagBase#getId
 * <em>Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITagBase#getName
 * <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITagBase#getOwner
 * <em>Owner</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagBase()
 * @model abstract="true" extendedMetaData="kind='elementOnly' name='tagBase'"
 * @generated
 */
public interface ITagBase extends EObject {
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagBase_Id()
   * @model extendedMetaData="kind='attribute' name='id'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getId();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITagBase#getId <em>Id</em>}'
   * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute. The default value
   * is <code>""</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagBase_Name()
   * @model default="" extendedMetaData="kind='attribute' name='name'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITagBase#getName <em>Name</em>}'
   * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Owner</b></em>' attribute. The default value
   * is <code>""</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Owner</em>' attribute.
   * @see #setOwner(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagBase_Owner()
   * @model default="" extendedMetaData="kind='attribute' name='owner'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getOwner();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITagBase#getOwner <em>Owner</em>}'
   * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Owner</em>' attribute.
   * @see #getOwner()
   * @generated
   */
  void setOwner(String value);

} // ITagBase
