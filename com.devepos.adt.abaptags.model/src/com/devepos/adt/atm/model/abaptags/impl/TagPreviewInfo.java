/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagPreviewInfo;

import com.devepos.adt.tools.base.model.adtbase.IAdtObjRef;

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
 * An implementation of the model object '<em><b>Tag Preview Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.atm.model.abaptags.impl.TagPreviewInfo#getTags <em>Tags</em>}</li>
 *   <li>{@link com.devepos.adt.atm.model.abaptags.impl.TagPreviewInfo#getAdtObjectRefs <em>Adt Object Refs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TagPreviewInfo extends MinimalEObjectImpl.Container implements ITagPreviewInfo {
	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<ITag> tags;

	/**
	 * The cached value of the '{@link #getAdtObjectRefs() <em>Adt Object Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdtObjectRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<IAdtObjRef> adtObjectRefs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TagPreviewInfo() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IAbapTagsPackage.Literals.TAG_PREVIEW_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ITag> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentEList<ITag>(ITag.class, this, IAbapTagsPackage.TAG_PREVIEW_INFO__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IAdtObjRef> getAdtObjectRefs() {
		if (adtObjectRefs == null) {
			adtObjectRefs = new EObjectContainmentEList<IAdtObjRef>(IAdtObjRef.class, this, IAbapTagsPackage.TAG_PREVIEW_INFO__ADT_OBJECT_REFS);
		}
		return adtObjectRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IAbapTagsPackage.TAG_PREVIEW_INFO__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
			case IAbapTagsPackage.TAG_PREVIEW_INFO__ADT_OBJECT_REFS:
				return ((InternalEList<?>)getAdtObjectRefs()).basicRemove(otherEnd, msgs);
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
			case IAbapTagsPackage.TAG_PREVIEW_INFO__TAGS:
				return getTags();
			case IAbapTagsPackage.TAG_PREVIEW_INFO__ADT_OBJECT_REFS:
				return getAdtObjectRefs();
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
			case IAbapTagsPackage.TAG_PREVIEW_INFO__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends ITag>)newValue);
				return;
			case IAbapTagsPackage.TAG_PREVIEW_INFO__ADT_OBJECT_REFS:
				getAdtObjectRefs().clear();
				getAdtObjectRefs().addAll((Collection<? extends IAdtObjRef>)newValue);
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
			case IAbapTagsPackage.TAG_PREVIEW_INFO__TAGS:
				getTags().clear();
				return;
			case IAbapTagsPackage.TAG_PREVIEW_INFO__ADT_OBJECT_REFS:
				getAdtObjectRefs().clear();
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
			case IAbapTagsPackage.TAG_PREVIEW_INFO__TAGS:
				return tags != null && !tags.isEmpty();
			case IAbapTagsPackage.TAG_PREVIEW_INFO__ADT_OBJECT_REFS:
				return adtObjectRefs != null && !adtObjectRefs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TagPreviewInfo
