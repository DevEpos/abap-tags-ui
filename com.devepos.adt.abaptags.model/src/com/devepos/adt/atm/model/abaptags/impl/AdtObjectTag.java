/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Adt
 * Object Tag</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag#getParentObjectName <em>Parent
 * Object Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag#getParentObjectType <em>Parent
 * Object Type</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag#getParentObjectUri <em>Parent
 * Object Uri</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag#getParentTagId <em>Parent Tag
 * Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag#getParentTagName <em>Parent Tag
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag#getImage <em>Image</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag#getPossibleParentTags
 * <em>Possible Parent Tags</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdtObjectTag extends TagBase implements IAdtObjectTag {
  /**
   * The default value of the '{@link #getParentObjectName() <em>Parent Object Name</em>}'
   * attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getParentObjectName()
   * @generated
   * @ordered
   */
  protected static final String PARENT_OBJECT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParentObjectName() <em>Parent Object Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getParentObjectName()
   * @generated
   * @ordered
   */
  protected String parentObjectName = PARENT_OBJECT_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getParentObjectType() <em>Parent Object Type</em>}'
   * attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getParentObjectType()
   * @generated
   * @ordered
   */
  protected static final String PARENT_OBJECT_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParentObjectType() <em>Parent Object Type</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getParentObjectType()
   * @generated
   * @ordered
   */
  protected String parentObjectType = PARENT_OBJECT_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getParentObjectUri() <em>Parent Object Uri</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getParentObjectUri()
   * @generated
   * @ordered
   */
  protected static final String PARENT_OBJECT_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParentObjectUri() <em>Parent Object Uri</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getParentObjectUri()
   * @generated
   * @ordered
   */
  protected String parentObjectUri = PARENT_OBJECT_URI_EDEFAULT;

  /**
   * The default value of the '{@link #getParentTagId() <em>Parent Tag Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getParentTagId()
   * @generated
   * @ordered
   */
  protected static final String PARENT_TAG_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParentTagId() <em>Parent Tag Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getParentTagId()
   * @generated
   * @ordered
   */
  protected String parentTagId = PARENT_TAG_ID_EDEFAULT;

  /**
   * The default value of the '{@link #getParentTagName() <em>Parent Tag Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getParentTagName()
   * @generated
   * @ordered
   */
  protected static final String PARENT_TAG_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParentTagName() <em>Parent Tag Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getParentTagName()
   * @generated
   * @ordered
   */
  protected String parentTagName = PARENT_TAG_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getImage() <em>Image</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getImage()
   * @generated
   * @ordered
   */
  protected static final Image IMAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImage() <em>Image</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getImage()
   * @generated
   * @ordered
   */
  protected Image image = IMAGE_EDEFAULT;

  /**
   * The cached value of the '{@link #getPossibleParentTags() <em>Possible Parent Tags</em>}'
   * attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getPossibleParentTags()
   * @generated
   * @ordered
   */
  protected EList<String> possibleParentTags;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected AdtObjectTag() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return IAbapTagsPackage.Literals.ADT_OBJECT_TAG;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getParentObjectName() {
    return parentObjectName;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setParentObjectName(final String newParentObjectName) {
    String oldParentObjectName = parentObjectName;
    parentObjectName = newParentObjectName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_NAME, oldParentObjectName,
          parentObjectName));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getParentObjectType() {
    return parentObjectType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setParentObjectType(final String newParentObjectType) {
    String oldParentObjectType = parentObjectType;
    parentObjectType = newParentObjectType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_TYPE, oldParentObjectType,
          parentObjectType));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getParentObjectUri() {
    return parentObjectUri;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setParentObjectUri(final String newParentObjectUri) {
    String oldParentObjectUri = parentObjectUri;
    parentObjectUri = newParentObjectUri;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_URI, oldParentObjectUri, parentObjectUri));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getParentTagId() {
    return parentTagId;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setParentTagId(final String newParentTagId) {
    String oldParentTagId = parentTagId;
    parentTagId = newParentTagId;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_ID, oldParentTagId, parentTagId));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getParentTagName() {
    return parentTagName;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setParentTagName(final String newParentTagName) {
    String oldParentTagName = parentTagName;
    parentTagName = newParentTagName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_NAME, oldParentTagName, parentTagName));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Image getImage() {
    return image;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setImage(final Image newImage) {
    Image oldImage = image;
    image = newImage;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.ADT_OBJECT_TAG__IMAGE,
          oldImage, image));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<String> getPossibleParentTags() {
    if (possibleParentTags == null) {
      possibleParentTags = new EDataTypeUniqueEList<>(String.class, this,
          IAbapTagsPackage.ADT_OBJECT_TAG__POSSIBLE_PARENT_TAGS);
    }
    return possibleParentTags;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
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
    case IAbapTagsPackage.ADT_OBJECT_TAG__IMAGE:
      return getImage();
    case IAbapTagsPackage.ADT_OBJECT_TAG__POSSIBLE_PARENT_TAGS:
      return getPossibleParentTags();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_NAME:
      setParentObjectName((String) newValue);
      return;
    case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_TYPE:
      setParentObjectType((String) newValue);
      return;
    case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_URI:
      setParentObjectUri((String) newValue);
      return;
    case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_ID:
      setParentTagId((String) newValue);
      return;
    case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_NAME:
      setParentTagName((String) newValue);
      return;
    case IAbapTagsPackage.ADT_OBJECT_TAG__IMAGE:
      setImage((Image) newValue);
      return;
    case IAbapTagsPackage.ADT_OBJECT_TAG__POSSIBLE_PARENT_TAGS:
      getPossibleParentTags().clear();
      getPossibleParentTags().addAll((Collection<? extends String>) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eUnset(final int featureID) {
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
    case IAbapTagsPackage.ADT_OBJECT_TAG__IMAGE:
      setImage(IMAGE_EDEFAULT);
      return;
    case IAbapTagsPackage.ADT_OBJECT_TAG__POSSIBLE_PARENT_TAGS:
      getPossibleParentTags().clear();
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_NAME:
      return PARENT_OBJECT_NAME_EDEFAULT == null ? parentObjectName != null
          : !PARENT_OBJECT_NAME_EDEFAULT.equals(parentObjectName);
    case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_TYPE:
      return PARENT_OBJECT_TYPE_EDEFAULT == null ? parentObjectType != null
          : !PARENT_OBJECT_TYPE_EDEFAULT.equals(parentObjectType);
    case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_OBJECT_URI:
      return PARENT_OBJECT_URI_EDEFAULT == null ? parentObjectUri != null
          : !PARENT_OBJECT_URI_EDEFAULT.equals(parentObjectUri);
    case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_ID:
      return PARENT_TAG_ID_EDEFAULT == null ? parentTagId != null
          : !PARENT_TAG_ID_EDEFAULT.equals(parentTagId);
    case IAbapTagsPackage.ADT_OBJECT_TAG__PARENT_TAG_NAME:
      return PARENT_TAG_NAME_EDEFAULT == null ? parentTagName != null
          : !PARENT_TAG_NAME_EDEFAULT.equals(parentTagName);
    case IAbapTagsPackage.ADT_OBJECT_TAG__IMAGE:
      return IMAGE_EDEFAULT == null ? image != null : !IMAGE_EDEFAULT.equals(image);
    case IAbapTagsPackage.ADT_OBJECT_TAG__POSSIBLE_PARENT_TAGS:
      return possibleParentTags != null && !possibleParentTags.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) {
      return super.toString();
    }

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
    result.append(", image: ");
    result.append(image);
    result.append(", possibleParentTags: ");
    result.append(possibleParentTags);
    result.append(')');
    return result.toString();
  }

} // AdtObjectTag
