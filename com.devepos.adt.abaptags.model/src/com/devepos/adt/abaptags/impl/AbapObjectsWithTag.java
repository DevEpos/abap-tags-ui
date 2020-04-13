/**
 */
package com.devepos.adt.abaptags.impl;

import com.devepos.adt.abaptags.IAbapObjectWithTag;
import com.devepos.adt.abaptags.IAbapObjectsWithTag;
import com.devepos.adt.abaptags.IAbapTagsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abap Objects With Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.abaptags.impl.AbapObjectsWithTag#getAbapObjectsWithTag <em>Abap Objects With Tag</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbapObjectsWithTag extends MinimalEObjectImpl.Container implements IAbapObjectsWithTag {
	/**
	 * The cached value of the '{@link #getAbapObjectsWithTag() <em>Abap Objects With Tag</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbapObjectsWithTag()
	 * @generated
	 * @ordered
	 */
	protected EList<IAbapObjectWithTag> abapObjectsWithTag;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbapObjectsWithTag() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IAbapTagsPackage.Literals.ABAP_OBJECTS_WITH_TAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IAbapObjectWithTag> getAbapObjectsWithTag() {
		if (abapObjectsWithTag == null) {
			abapObjectsWithTag = new EObjectContainmentEList<IAbapObjectWithTag>(IAbapObjectWithTag.class, this, IAbapTagsPackage.ABAP_OBJECTS_WITH_TAG__ABAP_OBJECTS_WITH_TAG);
		}
		return abapObjectsWithTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IAbapTagsPackage.ABAP_OBJECTS_WITH_TAG__ABAP_OBJECTS_WITH_TAG:
				return ((InternalEList<?>)getAbapObjectsWithTag()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IAbapTagsPackage.ABAP_OBJECTS_WITH_TAG__ABAP_OBJECTS_WITH_TAG:
				return getAbapObjectsWithTag();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IAbapTagsPackage.ABAP_OBJECTS_WITH_TAG__ABAP_OBJECTS_WITH_TAG:
				getAbapObjectsWithTag().clear();
				getAbapObjectsWithTag().addAll((Collection<? extends IAbapObjectWithTag>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case IAbapTagsPackage.ABAP_OBJECTS_WITH_TAG__ABAP_OBJECTS_WITH_TAG:
				getAbapObjectsWithTag().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IAbapTagsPackage.ABAP_OBJECTS_WITH_TAG__ABAP_OBJECTS_WITH_TAG:
				return abapObjectsWithTag != null && !abapObjectsWithTag.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbapObjectsWithTag
