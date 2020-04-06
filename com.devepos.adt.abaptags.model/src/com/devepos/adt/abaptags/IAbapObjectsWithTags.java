/**
 */
package com.devepos.adt.abaptags;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abap Objects With Tags</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.abaptags.IAbapObjectsWithTags#getAbapObjectWithTags <em>Abap Object With Tags</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAbapObjectsWithTags()
 * @model extendedMetaData="kind='elementOnly' name='abapObjectsWithTags'"
 * @generated
 */
public interface IAbapObjectsWithTags extends EObject {
	/**
	 * Returns the value of the '<em><b>Abap Object With Tags</b></em>' containment reference list.
	 * The list contents are of type {@link com.devepos.adt.abaptags.IAbapObjectWithTags}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abap Object With Tags</em>' containment reference list.
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAbapObjectsWithTags_AbapObjectWithTags()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='abapObjectWithTags' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<IAbapObjectWithTags> getAbapObjectWithTags();

} // IAbapObjectsWithTags
