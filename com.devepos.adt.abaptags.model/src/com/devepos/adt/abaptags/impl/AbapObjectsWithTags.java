/**
 */
package com.devepos.adt.abaptags.impl;

import com.devepos.adt.abaptags.IAbapObjectWithTags;
import com.devepos.adt.abaptags.IAbapObjectsWithTags;
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
 * An implementation of the model object '<em><b>Abap Objects With Tags</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.abaptags.impl.AbapObjectsWithTags#getAbapObjectsWithTags <em>Abap Objects With Tags</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbapObjectsWithTags extends MinimalEObjectImpl.Container implements IAbapObjectsWithTags {
	/**
	 * The cached value of the '{@link #getAbapObjectsWithTags() <em>Abap Objects With Tags</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbapObjectsWithTags()
	 * @generated
	 * @ordered
	 */
	protected EList<IAbapObjectWithTags> abapObjectsWithTags;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbapObjectsWithTags() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IAbapTagsPackage.Literals.ABAP_OBJECTS_WITH_TAGS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IAbapObjectWithTags> getAbapObjectsWithTags() {
		if (abapObjectsWithTags == null) {
			abapObjectsWithTags = new EObjectContainmentEList<IAbapObjectWithTags>(IAbapObjectWithTags.class, this, IAbapTagsPackage.ABAP_OBJECTS_WITH_TAGS__ABAP_OBJECTS_WITH_TAGS);
		}
		return abapObjectsWithTags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IAbapTagsPackage.ABAP_OBJECTS_WITH_TAGS__ABAP_OBJECTS_WITH_TAGS:
				return ((InternalEList<?>)getAbapObjectsWithTags()).basicRemove(otherEnd, msgs);
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
			case IAbapTagsPackage.ABAP_OBJECTS_WITH_TAGS__ABAP_OBJECTS_WITH_TAGS:
				return getAbapObjectsWithTags();
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
			case IAbapTagsPackage.ABAP_OBJECTS_WITH_TAGS__ABAP_OBJECTS_WITH_TAGS:
				getAbapObjectsWithTags().clear();
				getAbapObjectsWithTags().addAll((Collection<? extends IAbapObjectWithTags>)newValue);
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
			case IAbapTagsPackage.ABAP_OBJECTS_WITH_TAGS__ABAP_OBJECTS_WITH_TAGS:
				getAbapObjectsWithTags().clear();
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
			case IAbapTagsPackage.ABAP_OBJECTS_WITH_TAGS__ABAP_OBJECTS_WITH_TAGS:
				return abapObjectsWithTags != null && !abapObjectsWithTags.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbapObjectsWithTags
