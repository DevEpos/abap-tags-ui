/**
 */
package com.devepos.adt.abaptags;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adt Object Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.abaptags.IAdtObjectTag#getParentObjectName <em>Parent Object Name</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.IAdtObjectTag#getParentObjectType <em>Parent Object Type</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.IAdtObjectTag#getParentObjectUri <em>Parent Object Uri</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAdtObjectTag()
 * @model extendedMetaData="kind='elementOnly' name='adtObjectTag'"
 * @generated
 */
public interface IAdtObjectTag extends ITagBase {
	/**
	 * Returns the value of the '<em><b>Parent Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Object Name</em>' attribute.
	 * @see #setParentObjectName(String)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAdtObjectTag_ParentObjectName()
	 * @model extendedMetaData="kind='attribute' name='parentObjectName' namespace='##targetNamespace'"
	 * @generated
	 */
	String getParentObjectName();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.IAdtObjectTag#getParentObjectName <em>Parent Object Name</em>}' attribute.
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
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAdtObjectTag_ParentObjectType()
	 * @model extendedMetaData="kind='attribute' name='parentObjectType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getParentObjectType();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.IAdtObjectTag#getParentObjectType <em>Parent Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Object Type</em>' attribute.
	 * @see #getParentObjectType()
	 * @generated
	 */
	void setParentObjectType(String value);

	/**
	 * Returns the value of the '<em><b>Parent Object Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Object Uri</em>' attribute.
	 * @see #setParentObjectUri(String)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAdtObjectTag_ParentObjectUri()
	 * @model extendedMetaData="kind='attribute' name='parentObjectUri' namespace='##targetNamespace'"
	 * @generated
	 */
	String getParentObjectUri();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.IAdtObjectTag#getParentObjectUri <em>Parent Object Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Object Uri</em>' attribute.
	 * @see #getParentObjectUri()
	 * @generated
	 */
	void setParentObjectUri(String value);

} // IAdtObjectTag
