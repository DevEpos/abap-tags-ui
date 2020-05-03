/**
 */
package com.devepos.adt.abaptags.impl;

import com.devepos.adt.abaptags.IAbapTagsPackage;
import com.devepos.adt.abaptags.ITaggedObject;
import com.devepos.adt.abaptags.ITaggedObjectList;

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
 * An implementation of the model object '<em><b>Tagged Object List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.abaptags.impl.TaggedObjectList#getTaggedObjects <em>Tagged Objects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedObjectList extends MinimalEObjectImpl.Container implements ITaggedObjectList {
	/**
	 * The cached value of the '{@link #getTaggedObjects() <em>Tagged Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaggedObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<ITaggedObject> taggedObjects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaggedObjectList() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IAbapTagsPackage.Literals.TAGGED_OBJECT_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ITaggedObject> getTaggedObjects() {
		if (taggedObjects == null) {
			taggedObjects = new EObjectContainmentEList<ITaggedObject>(ITaggedObject.class, this, IAbapTagsPackage.TAGGED_OBJECT_LIST__TAGGED_OBJECTS);
		}
		return taggedObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IAbapTagsPackage.TAGGED_OBJECT_LIST__TAGGED_OBJECTS:
				return ((InternalEList<?>)getTaggedObjects()).basicRemove(otherEnd, msgs);
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
			case IAbapTagsPackage.TAGGED_OBJECT_LIST__TAGGED_OBJECTS:
				return getTaggedObjects();
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
			case IAbapTagsPackage.TAGGED_OBJECT_LIST__TAGGED_OBJECTS:
				getTaggedObjects().clear();
				getTaggedObjects().addAll((Collection<? extends ITaggedObject>)newValue);
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
			case IAbapTagsPackage.TAGGED_OBJECT_LIST__TAGGED_OBJECTS:
				getTaggedObjects().clear();
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
			case IAbapTagsPackage.TAGGED_OBJECT_LIST__TAGGED_OBJECTS:
				return taggedObjects != null && !taggedObjects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TaggedObjectList
