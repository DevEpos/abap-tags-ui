/**
 */
package com.devepos.adt.abaptags;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abap Object With Tags</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.abaptags.IAbapObjectWithTags#getObjectName <em>Object Name</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.IAbapObjectWithTags#getObjectType <em>Object Type</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.IAbapObjectWithTags#getTag <em>Tag</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAbapObjectWithTags()
 * @model extendedMetaData="kind='elementOnly' name='abapObjectWithTags'"
 * @generated
 */
public interface IAbapObjectWithTags extends EObject {
	/**
	 * Returns the value of the '<em><b>Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Name</em>' attribute.
	 * @see #setObjectName(String)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAbapObjectWithTags_ObjectName()
	 * @model extendedMetaData="kind='attribute' name='objectName' namespace='##targetNamespace'"
	 * @generated
	 */
	String getObjectName();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.IAbapObjectWithTags#getObjectName <em>Object Name</em>}' attribute.
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
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAbapObjectWithTags_ObjectType()
	 * @model extendedMetaData="kind='attribute' name='objectType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getObjectType();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.IAbapObjectWithTags#getObjectType <em>Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Type</em>' attribute.
	 * @see #getObjectType()
	 * @generated
	 */
	void setObjectType(String value);

	/**
	 * Returns the value of the '<em><b>Tag</b></em>' containment reference list.
	 * The list contents are of type {@link com.devepos.adt.abaptags.ITag}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' containment reference list.
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAbapObjectWithTags_Tag()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='tag' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ITag> getTag();

} // IAbapObjectWithTags
