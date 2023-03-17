/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject;
import com.devepos.adt.base.model.adtbase.MessageType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tag Deletion Check Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TagDeletionCheckObject#getTagId <em>Tag
 * Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TagDeletionCheckObject#isDeletable
 * <em>Deletable</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TagDeletionCheckObject#getMessage
 * <em>Message</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TagDeletionCheckObject#getMessageType
 * <em>Message Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TagDeletionCheckObject extends MinimalEObjectImpl.Container implements
    ITagDeletionCheckObject {
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected TagDeletionCheckObject() {
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
    return IAbapTagsPackage.Literals.TAG_DELETION_CHECK_OBJECT;
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
          IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__TAG_ID, oldTagId, tagId));
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
          IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__DELETABLE, oldDeletable, deletable));
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
          IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__MESSAGE, oldMessage, message));
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
          IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__MESSAGE_TYPE, oldMessageType, messageType));
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
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__TAG_ID:
      return getTagId();
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__DELETABLE:
      return isDeletable();
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__MESSAGE:
      return getMessage();
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__MESSAGE_TYPE:
      return getMessageType();
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
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__TAG_ID:
      setTagId((String) newValue);
      return;
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__DELETABLE:
      setDeletable((Boolean) newValue);
      return;
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__MESSAGE:
      setMessage((String) newValue);
      return;
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__MESSAGE_TYPE:
      setMessageType((MessageType) newValue);
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
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__TAG_ID:
      setTagId(TAG_ID_EDEFAULT);
      return;
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__DELETABLE:
      setDeletable(DELETABLE_EDEFAULT);
      return;
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__MESSAGE:
      setMessage(MESSAGE_EDEFAULT);
      return;
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__MESSAGE_TYPE:
      setMessageType(MESSAGE_TYPE_EDEFAULT);
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
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__TAG_ID:
      return TAG_ID_EDEFAULT == null ? tagId != null : !TAG_ID_EDEFAULT.equals(tagId);
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__DELETABLE:
      return deletable != DELETABLE_EDEFAULT;
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__MESSAGE:
      return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT__MESSAGE_TYPE:
      return messageType != MESSAGE_TYPE_EDEFAULT;
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
    result.append(", deletable: ");
    result.append(deletable);
    result.append(", message: ");
    result.append(message);
    result.append(", messageType: ");
    result.append(messageType);
    result.append(')');
    return result.toString();
  }

} // TagDeletionCheckObject
