/**
 */
package com.devepos.adt.atm.model.abaptags;

import com.devepos.adt.tools.base.model.adtbase.IAdtObjRef;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObject#getObjectRef <em>Object Ref</em>}</li>
 *   <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObject#getTags <em>Tags</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObject()
 * @model extendedMetaData="kind='elementOnly' name='taggedObject'"
 * @generated
 */
public interface ITaggedObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Object Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Ref</em>' containment reference.
	 * @see #setObjectRef(IAdtObjRef)
	 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObject_ObjectRef()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='adtObjRef' namespace='http://www.devepos.com/adt/base'"
	 * @generated
	 */
	IAdtObjRef getObjectRef();

	/**
	 * Sets the value of the '{@link com.devepos.adt.atm.model.abaptags.ITaggedObject#getObjectRef <em>Object Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Ref</em>' containment reference.
	 * @see #getObjectRef()
	 * @generated
	 */
	void setObjectRef(IAdtObjRef value);

	/**
	 * Returns the value of the '<em><b>Tags</b></em>' containment reference list.
	 * The list contents are of type {@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' containment reference list.
	 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObject_Tags()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='adtObjectTag' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<IAdtObjectTag> getTags();

} // ITaggedObject
