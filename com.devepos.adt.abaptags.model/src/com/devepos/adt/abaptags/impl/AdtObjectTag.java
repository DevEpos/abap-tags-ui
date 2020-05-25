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
 *   <li>{@link com.devepos.adt.abaptags.impl.AdtObjectTag#getParentTagId <em>Parent Tag Id</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.AdtObjectTag#getParentTagName <em>Parent Tag Name</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.AdtObjectTag#isUserTag <em>User Tag</em>}</li>
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
	 * The default value of the '{@link #getParentTagId() <em>Parent Tag Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentTagId()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_TAG_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentTagId() <em>Parent Tag Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentTagId()
	 * @generated
	 * @ordered
	 */
	protected String parentTagId = PARENT_TAG_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getParentTagName() <em>Parent Tag Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentTagName()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_TAG_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentTagName() <em>Parent Tag Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentTagName()
	 * @generated
	 * @ordered
	 */
	protected String parentTagName = PARENT_TAG_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isUserTag() <em>User Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUserTag()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USER_TAG_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUserTag() <em>User Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUserTag()
	 * @generated
	 * @ordered
	 */
	protected boolean userTag = USER_TAG_EDEFAULT;

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
	public String getParentTagId() {
		return parentTagId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentTagId(String newParentTagId) {
		String oldParentTagId = parentTagId;
		parentTagId = newParentTagId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_ID, oldParentTagId, parentTagId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getParentTagName() {
		return parentTagName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentTagName(String newParentTagName) {
		String oldParentTagName = parentTagName;
		parentTagName = newParentTagName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_NAME, oldParentTagName, parentTagName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isUserTag() {
		return userTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserTag(boolean newUserTag) {
		boolean oldUserTag = userTag;
		userTag = newUserTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.ADT_OBJECT_TAG__USER_TAG, oldUserTag, userTag));
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
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_ID:
				return getParentTagId();
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_NAME:
				return getParentTagName();
			case IAbapTagsPackage.ADT_OBJECT_TAG__USER_TAG:
				return isUserTag();
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
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_ID:
				setParentTagId((String)newValue);
				return;
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_NAME:
				setParentTagName((String)newValue);
				return;
			case IAbapTagsPackage.ADT_OBJECT_TAG__USER_TAG:
				setUserTag((Boolean)newValue);
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
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_ID:
				setParentTagId(PARENT_TAG_ID_EDEFAULT);
				return;
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_NAME:
				setParentTagName(PARENT_TAG_NAME_EDEFAULT);
				return;
			case IAbapTagsPackage.ADT_OBJECT_TAG__USER_TAG:
				setUserTag(USER_TAG_EDEFAULT);
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
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_ID:
				return PARENT_TAG_ID_EDEFAULT == null ? parentTagId != null : !PARENT_TAG_ID_EDEFAULT.equals(parentTagId);
			case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_NAME:
				return PARENT_TAG_NAME_EDEFAULT == null ? parentTagName != null : !PARENT_TAG_NAME_EDEFAULT.equals(parentTagName);
			case IAbapTagsPackage.ADT_OBJECT_TAG__USER_TAG:
				return userTag != USER_TAG_EDEFAULT;
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
		result.append(", parentTagId: ");
		result.append(parentTagId);
		result.append(", parentTagName: ");
		result.append(parentTagName);
		result.append(", userTag: ");
		result.append(userTag);
		result.append(')');
		return result.toString();
	}

} //AdtObjectTag
