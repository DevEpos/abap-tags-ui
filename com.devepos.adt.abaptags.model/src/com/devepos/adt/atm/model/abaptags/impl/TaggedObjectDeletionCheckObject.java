/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject;
import com.devepos.adt.base.model.adtbase.MessageType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Object Deletion Check Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectDeletionCheckObject#getTaggedObjectId
 * <em>Tagged Object Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectDeletionCheckObject#isDeletable
 * <em>Deletable</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectDeletionCheckObject#getMessage
 * <em>Message</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectDeletionCheckObject#getMessageType
 * <em>Message Type</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectDeletionCheckObject#getDependentObjectIds
 * <em>Dependent Object Ids</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedObjectDeletionCheckObject extends MinimalEObjectImpl.Container implements
    ITaggedObjectDeletionCheckObject {
  /**
   * The default value of the '{@link #getTaggedObjectId() <em>Tagged Object Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTaggedObjectId()
   * @generated
   * @ordered
   */
  protected static final String TAGGED_OBJECT_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTaggedObjectId() <em>Tagged Object Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTaggedObjectId()
   * @generated
   * @ordered
   */
  protected String taggedObjectId = TAGGED_OBJECT_ID_EDEFAULT;

  /**
   * The default value of the '{@link #isDeletable() <em>Deletable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isDeletable()
   * @generated
   * @ordered
   */
  protected static final boolean DELETABLE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDeletable() <em>Deletable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isDeletable()
   * @generated
   * @ordered
   */
  protected boolean deletable = DELETABLE_EDEFAULT;

  /**
   * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected static final String MESSAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected String message = MESSAGE_EDEFAULT;

  /**
   * The default value of the '{@link #getMessageType() <em>Message Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getMessageType()
   * @generated
   * @ordered
   */
  protected static final MessageType MESSAGE_TYPE_EDEFAULT = MessageType.NONE;

  /**
   * The cached value of the '{@link #getMessageType() <em>Message Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getMessageType()
   * @generated
   * @ordered
   */
  protected MessageType messageType = MESSAGE_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getDependentObjectIds() <em>Dependent Object Ids</em>}'
   * attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getDependentObjectIds()
   * @generated
   * @ordered
   */
  protected EList<String> dependentObjectIds;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected TaggedObjectDeletionCheckObject() {
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
    return IAbapTagsPackage.Literals.TAGGED_OBJECT_DELETION_CHECK_OBJECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getTaggedObjectId() {
    return taggedObjectId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setTaggedObjectId(final String newTaggedObjectId) {
    String oldTaggedObjectId = taggedObjectId;
    taggedObjectId = newTaggedObjectId;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__TAGGED_OBJECT_ID, oldTaggedObjectId,
          taggedObjectId));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isDeletable() {
    return deletable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setDeletable(final boolean newDeletable) {
    boolean oldDeletable = deletable;
    deletable = newDeletable;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__DELETABLE, oldDeletable,
          deletable));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getMessage() {
    return message;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setMessage(final String newMessage) {
    String oldMessage = message;
    message = newMessage;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__MESSAGE, oldMessage, message));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public MessageType getMessageType() {
    return messageType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setMessageType(final MessageType newMessageType) {
    MessageType oldMessageType = messageType;
    messageType = newMessageType == null ? MESSAGE_TYPE_EDEFAULT : newMessageType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__MESSAGE_TYPE, oldMessageType,
          messageType));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<String> getDependentObjectIds() {
    if (dependentObjectIds == null) {
      dependentObjectIds = new EDataTypeUniqueEList<>(String.class, this,
          IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__DEPENDENT_OBJECT_IDS);
    }
    return dependentObjectIds;
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__TAGGED_OBJECT_ID:
      return getTaggedObjectId();
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__DELETABLE:
      return isDeletable();
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__MESSAGE:
      return getMessage();
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__MESSAGE_TYPE:
      return getMessageType();
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__DEPENDENT_OBJECT_IDS:
      return getDependentObjectIds();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__TAGGED_OBJECT_ID:
      setTaggedObjectId((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__DELETABLE:
      setDeletable((Boolean) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__MESSAGE:
      setMessage((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__MESSAGE_TYPE:
      setMessageType((MessageType) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__DEPENDENT_OBJECT_IDS:
      getDependentObjectIds().clear();
      getDependentObjectIds().addAll((Collection<? extends String>) newValue);
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__TAGGED_OBJECT_ID:
      setTaggedObjectId(TAGGED_OBJECT_ID_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__DELETABLE:
      setDeletable(DELETABLE_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__MESSAGE:
      setMessage(MESSAGE_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__MESSAGE_TYPE:
      setMessageType(MESSAGE_TYPE_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__DEPENDENT_OBJECT_IDS:
      getDependentObjectIds().clear();
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__TAGGED_OBJECT_ID:
      return TAGGED_OBJECT_ID_EDEFAULT == null ? taggedObjectId != null
          : !TAGGED_OBJECT_ID_EDEFAULT.equals(taggedObjectId);
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__DELETABLE:
      return deletable != DELETABLE_EDEFAULT;
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__MESSAGE:
      return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__MESSAGE_TYPE:
      return messageType != MESSAGE_TYPE_EDEFAULT;
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT__DEPENDENT_OBJECT_IDS:
      return dependentObjectIds != null && !dependentObjectIds.isEmpty();
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
    result.append(" (taggedObjectId: ");
    result.append(taggedObjectId);
    result.append(", deletable: ");
    result.append(deletable);
    result.append(", message: ");
    result.append(message);
    result.append(", messageType: ");
    result.append(messageType);
    result.append(", dependentObjectIds: ");
    result.append(dependentObjectIds);
    result.append(')');
    return result.toString();
  }

} // TaggedObjectDeletionCheckObject
