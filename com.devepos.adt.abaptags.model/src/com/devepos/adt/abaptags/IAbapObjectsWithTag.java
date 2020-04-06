/**
 */
package com.devepos.adt.abaptags;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abap Objects With Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.abaptags.IAbapObjectsWithTag#getAbapObjectWithTag <em>Abap Object With Tag</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAbapObjectsWithTag()
 * @model extendedMetaData="kind='elementOnly' name='abapObjectsWithTag'"
 * @generated
 */
public interface IAbapObjectsWithTag extends EObject {
	/**
	 * Returns the value of the '<em><b>Abap Object With Tag</b></em>' containment reference list.
	 * The list contents are of type {@link com.devepos.adt.abaptags.IAbapObjectWithTag}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abap Object With Tag</em>' containment reference list.
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getAbapObjectsWithTag_AbapObjectWithTag()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='abapObjectWithTag' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<IAbapObjectWithTag> getAbapObjectWithTag();

} // IAbapObjectsWithTag
