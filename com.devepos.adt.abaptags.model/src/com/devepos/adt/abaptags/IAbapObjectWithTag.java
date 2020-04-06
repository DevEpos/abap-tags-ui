/**
 */
package com.devepos.adt.abaptags;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abap Object With Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getObjectName <em>Object Name</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getObjectType <em>Object Type</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getParentObjectName <em>Parent Object Name</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getParentObjectType <em>Parent Object Type</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getTagId <em>Tag Id</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAbapObjectWithTag()
 * @model extendedMetaData="kind='elementOnly' name='abapObjectWithTag'"
 * @generated
 */
public interface IAbapObjectWithTag extends EObject {
	/**
	 * Returns the value of the '<em><b>Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Name</em>' attribute.
	 * @see #setObjectName(String)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAbapObjectWithTag_ObjectName()
	 * @model extendedMetaData="kind='attribute' name='objectName' namespace='##targetNamespace'"
	 * @generated
	 */
	String getObjectName();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getObjectName <em>Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Name</em>' attribute.
	 * @see #getObjectName()
	 * @generated
	 */
	void setObjectName(String value);

	/**
	 * Returns the value of the '<em><b>Object Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Type</em>' attribute.
	 * @see #setObjectType(String)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAbapObjectWithTag_ObjectType()
	 * @model extendedMetaData="kind='attribute' name='objectType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getObjectType();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getObjectType <em>Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Type</em>' attribute.
	 * @see #getObjectType()
	 * @generated
	 */
	void setObjectType(String value);

	/**
	 * Returns the value of the '<em><b>Parent Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Object Name</em>' attribute.
	 * @see #setParentObjectName(String)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAbapObjectWithTag_ParentObjectName()
	 * @model extendedMetaData="kind='attribute' name='parentObjectName' namespace='##targetNamespace'"
	 * @generated
	 */
	String getParentObjectName();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getParentObjectName <em>Parent Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Object Name</em>' attribute.
	 * @see #getParentObjectName()
	 * @generated
	 */
	void setParentObjectName(String value);

	/**
	 * Returns the value of the '<em><b>Parent Object Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Object Type</em>' attribute.
	 * @see #setParentObjectType(String)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAbapObjectWithTag_ParentObjectType()
	 * @model extendedMetaData="kind='attribute' name='parentObjectType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getParentObjectType();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getParentObjectType <em>Parent Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Object Type</em>' attribute.
	 * @see #getParentObjectType()
	 * @generated
	 */
	void setParentObjectType(String value);

	/**
	 * Returns the value of the '<em><b>Tag Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag Id</em>' attribute.
	 * @see #setTagId(String)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAbapObjectWithTag_TagId()
	 * @model extendedMetaData="kind='attribute' name='tagId' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTagId();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getTagId <em>Tag Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag Id</em>' attribute.
	 * @see #getTagId()
	 * @generated
	 */
	void setTagId(String value);

} // IAbapObjectWithTag
