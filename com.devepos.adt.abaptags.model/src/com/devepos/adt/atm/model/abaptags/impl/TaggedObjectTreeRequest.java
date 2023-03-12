/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Object Tree Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeRequest#getTagId <em>Tag
 * Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeRequest#getParentObjectName
 * <em>Parent Object Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeRequest#getParentObjectType
 * <em>Parent Object Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedObjectTreeRequest extends MinimalEObjectImpl.Container implements
    ITaggedObjectTreeRequest {
  /**
   * The default value of the '{@link #getTagId() <em>Tag Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTagId()
   * @generated
   * @ordered
   */
  protected static final String TAG_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTagId() <em>Tag Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTagId()
   * @generated
   * @ordered
   */
  protected String tagId = TAG_ID_EDEFAULT;

  /**
   * The default value of the '{@link #getParentObjectName() <em>Parent Object Name</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getParentObjectName()
   * @generated
   * @ordered
   */
  protected static final String PARENT_OBJECT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParentObjectName() <em>Parent Object Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getParentObjectName()
   * @generated
   * @ordered
   */
  protected String parentObjectName = PARENT_OBJECT_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getParentObjectType() <em>Parent Object Type</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getParentObjectType()
   * @generated
   * @ordered
   */
  protected static final String PARENT_OBJECT_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParentObjectType() <em>Parent Object Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getParentObjectType()
   * @generated
   * @ordered
   */
  protected String parentObjectType = PARENT_OBJECT_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected TaggedObjectTreeRequest() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return IAbapTagsPackage.Literals.TAGGED_OBJECT_TREE_REQUEST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getTagId() {
    return tagId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setTagId(final String newTagId) {
    String oldTagId = tagId;
    tagId = newTagId;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__TAG_ID, oldTagId, tagId));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getParentObjectName() {
    return parentObjectName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setParentObjectName(final String newParentObjectName) {
    String oldParentObjectName = parentObjectName;
    parentObjectName = newParentObjectName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_NAME, oldParentObjectName,
          parentObjectName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getParentObjectType() {
    return parentObjectType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setParentObjectType(final String newParentObjectType) {
    String oldParentObjectType = parentObjectType;
    parentObjectType = newParentObjectType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_TYPE, oldParentObjectType,
          parentObjectType));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__TAG_ID:
      return getTagId();
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_NAME:
      return getParentObjectName();
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_TYPE:
      return getParentObjectType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__TAG_ID:
      setTagId((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_NAME:
      setParentObjectName((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_TYPE:
      setParentObjectType((String) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eUnset(final int featureID) {
    switch (featureID) {
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__TAG_ID:
      setTagId(TAG_ID_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_NAME:
      setParentObjectName(PARENT_OBJECT_NAME_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_TYPE:
      setParentObjectType(PARENT_OBJECT_TYPE_EDEFAULT);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__TAG_ID:
      return TAG_ID_EDEFAULT == null ? tagId != null : !TAG_ID_EDEFAULT.equals(tagId);
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_NAME:
      return PARENT_OBJECT_NAME_EDEFAULT == null ? parentObjectName != null
          : !PARENT_OBJECT_NAME_EDEFAULT.equals(parentObjectName);
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_TYPE:
      return PARENT_OBJECT_TYPE_EDEFAULT == null ? parentObjectType != null
          : !PARENT_OBJECT_TYPE_EDEFAULT.equals(parentObjectType);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (tagId: ");
    result.append(tagId);
    result.append(", parentObjectName: ");
    result.append(parentObjectName);
    result.append(", parentObjectType: ");
    result.append(parentObjectType);
    result.append(')');
    return result.toString();
  }

} // TaggedObjectTreeRequest
