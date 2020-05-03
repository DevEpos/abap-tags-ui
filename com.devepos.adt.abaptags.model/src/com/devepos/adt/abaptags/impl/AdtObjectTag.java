/**
 */
package com.devepos.adt.abaptags.impl;

import com.devepos.adt.abaptags.IAbapTagsPackage;
import com.devepos.adt.abaptags.IAdtObjectTag;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adt Object Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.abaptags.impl.AdtObjectTag#getParentObjectName <em>Parent Object Name</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.AdtObjectTag#getParentObjectType <em>Parent Object Type</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.AdtObjectTag#getParentObjectUri <em>Parent Object Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdtObjectTag extends TagBase implements IAdtObjectTag {
	/**
	 * The default value of the '{@link #getParentObjectName() <em>Parent Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentObjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_OBJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentObjectName() <em>Parent Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentObjectName()
	 * @generated
	 * @ordered
	 */
	protected String parentObjectName = PARENT_OBJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getParentObjectType() <em>Parent Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentObjectType()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_OBJECT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentObjectType() <em>Parent Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentObjectType()
	 * @generated
	 * @ordered
	 */
	protected String parentObjectType = PARENT_OBJECT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getParentObjectUri() <em>Parent Object Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentObjectUri()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_OBJECT_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentObjectUri() <em>Parent Object Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentObjectUri()
	 * @generated
	 * @ordered
	 */
	protected String parentObjectUri = PARENT_OBJECT_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdtObjectTag() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IAbapTagsPackage.Literals.ADT_OBJECT_TAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getParentObjectName() {
		return parentObjectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentObjectName(String newParentObjectName) {
		String oldParentObjectName = parentObjectName;
		parentObjectName = newParentObjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_NAME, oldParentObjectName, parentObjectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getParentObjectType() {
		return parentObjectType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentObjectType(String newParentObjectType) {
		String oldParentObjectType = parentObjectType;
		parentObjectType = newParentObjectType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_TYPE, oldParentObjectType, parentObjectType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getParentObjectUri() {
		return parentObjectUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentObjectUri(String newParentObjectUri) {
		String oldParentObjectUri = parentObjectUri;
		parentObjectUri = newParentObjectUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_URI, oldParentObjectUri, parentObjectUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_NAME:
				return getParentObjectName();
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_TYPE:
				return getParentObjectType();
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_URI:
				return getParentObjectUri();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_NAME:
				setParentObjectName((String)newValue);
				return;
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_TYPE:
				setParentObjectType((String)newValue);
				return;
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_URI:
				setParentObjectUri((String)newValue);
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
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_NAME:
				setParentObjectName(PARENT_OBJECT_NAME_EDEFAULT);
				return;
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_TYPE:
				setParentObjectType(PARENT_OBJECT_TYPE_EDEFAULT);
				return;
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_URI:
				setParentObjectUri(PARENT_OBJECT_URI_EDEFAULT);
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
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_NAME:
				return PARENT_OBJECT_NAME_EDEFAULT == null ? parentObjectName != null : !PARENT_OBJECT_NAME_EDEFAULT.equals(parentObjectName);
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_TYPE:
				return PARENT_OBJECT_TYPE_EDEFAULT == null ? parentObjectType != null : !PARENT_OBJECT_TYPE_EDEFAULT.equals(parentObjectType);
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_URI:
				return PARENT_OBJECT_URI_EDEFAULT == null ? parentObjectUri != null : !PARENT_OBJECT_URI_EDEFAULT.equals(parentObjectUri);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (parentObjectName: ");
		result.append(parentObjectName);
		result.append(", parentObjectType: ");
		result.append(parentObjectType);
		result.append(", parentObjectUri: ");
		result.append(parentObjectUri);
		result.append(')');
		return result.toString();
	}

} //AdtObjectTag
