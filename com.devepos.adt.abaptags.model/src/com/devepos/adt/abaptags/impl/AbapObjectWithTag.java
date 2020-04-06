/**
 */
package com.devepos.adt.abaptags.impl;

import com.devepos.adt.abaptags.IAbapObjectWithTag;
import com.devepos.adt.abaptags.IAbapTagsPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abap Object With Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.abaptags.impl.AbapObjectWithTag#getObjectName <em>Object Name</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.AbapObjectWithTag#getObjectType <em>Object Type</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.AbapObjectWithTag#getParentObjectName <em>Parent Object Name</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.AbapObjectWithTag#getParentObjectType <em>Parent Object Type</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.AbapObjectWithTag#getTagId <em>Tag Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbapObjectWithTag extends MinimalEObjectImpl.Container implements IAbapObjectWithTag {
	/**
	 * The default value of the '{@link #getObjectName() <em>Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjectName() <em>Object Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectName()
	 * @generated
	 * @ordered
	 */
	protected String objectName = OBJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getObjectType() <em>Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectType()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJECT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjectType() <em>Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectType()
	 * @generated
	 * @ordered
	 */
	protected String objectType = OBJECT_TYPE_EDEFAULT;

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
	 * The default value of the '{@link #getTagId() <em>Tag Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagId()
	 * @generated
	 * @ordered
	 */
	protected static final String TAG_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTagId() <em>Tag Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagId()
	 * @generated
	 * @ordered
	 */
	protected String tagId = TAG_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbapObjectWithTag() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IAbapTagsPackage.Literals.ABAP_OBJECT_WITH_TAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getObjectName() {
		return objectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObjectName(String newObjectName) {
		String oldObjectName = objectName;
		objectName = newObjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__OBJECT_NAME, oldObjectName, objectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getObjectType() {
		return objectType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObjectType(String newObjectType) {
		String oldObjectType = objectType;
		objectType = newObjectType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__OBJECT_TYPE, oldObjectType, objectType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_NAME, oldParentObjectName, parentObjectName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_TYPE, oldParentObjectType, parentObjectType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTagId() {
		return tagId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTagId(String newTagId) {
		String oldTagId = tagId;
		tagId = newTagId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__TAG_ID, oldTagId, tagId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__OBJECT_NAME:
				return getObjectName();
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__OBJECT_TYPE:
				return getObjectType();
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_NAME:
				return getParentObjectName();
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_TYPE:
				return getParentObjectType();
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__TAG_ID:
				return getTagId();
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
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__OBJECT_NAME:
				setObjectName((String)newValue);
				return;
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__OBJECT_TYPE:
				setObjectType((String)newValue);
				return;
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_NAME:
				setParentObjectName((String)newValue);
				return;
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_TYPE:
				setParentObjectType((String)newValue);
				return;
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__TAG_ID:
				setTagId((String)newValue);
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
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__OBJECT_NAME:
				setObjectName(OBJECT_NAME_EDEFAULT);
				return;
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__OBJECT_TYPE:
				setObjectType(OBJECT_TYPE_EDEFAULT);
				return;
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_NAME:
				setParentObjectName(PARENT_OBJECT_NAME_EDEFAULT);
				return;
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_TYPE:
				setParentObjectType(PARENT_OBJECT_TYPE_EDEFAULT);
				return;
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__TAG_ID:
				setTagId(TAG_ID_EDEFAULT);
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
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__OBJECT_NAME:
				return OBJECT_NAME_EDEFAULT == null ? objectName != null : !OBJECT_NAME_EDEFAULT.equals(objectName);
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__OBJECT_TYPE:
				return OBJECT_TYPE_EDEFAULT == null ? objectType != null : !OBJECT_TYPE_EDEFAULT.equals(objectType);
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_NAME:
				return PARENT_OBJECT_NAME_EDEFAULT == null ? parentObjectName != null : !PARENT_OBJECT_NAME_EDEFAULT.equals(parentObjectName);
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_TYPE:
				return PARENT_OBJECT_TYPE_EDEFAULT == null ? parentObjectType != null : !PARENT_OBJECT_TYPE_EDEFAULT.equals(parentObjectType);
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG__TAG_ID:
				return TAG_ID_EDEFAULT == null ? tagId != null : !TAG_ID_EDEFAULT.equals(tagId);
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
		result.append(" (objectName: ");
		result.append(objectName);
		result.append(", objectType: ");
		result.append(objectType);
		result.append(", parentObjectName: ");
		result.append(parentObjectName);
		result.append(", parentObjectType: ");
		result.append(parentObjectType);
		result.append(", tagId: ");
		result.append(tagId);
		result.append(')');
		return result.toString();
	}

} //AbapObjectWithTag
