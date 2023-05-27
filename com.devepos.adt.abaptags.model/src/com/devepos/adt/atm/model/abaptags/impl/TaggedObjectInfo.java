/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo;
import com.devepos.adt.atm.model.abaptags.TagType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Object Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfo#getId <em>Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfo#getTagId <em>Tag
 * Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfo#getTagName <em>Tag
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfo#getTagType <em>Tag
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfo#getObjectName <em>Object
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfo#getObjectAltName <em>Object
 * Alt Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfo#getObjectType <em>Object
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfo#getComponentName
 * <em>Component Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfo#getComponentType
 * <em>Component Type</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfo#getParentTagId <em>Parent Tag
 * Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfo#getParentTagName <em>Parent
 * Tag Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfo#getParentObjectName
 * <em>Parent Object Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfo#getParentObjectAltName
 * <em>Parent Object Alt Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfo#getParentObjectType
 * <em>Parent Object Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedObjectInfo extends MinimalEObjectImpl.Container implements ITaggedObjectInfo {
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

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
   * The default value of the '{@link #getTagName() <em>Tag Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTagName()
   * @generated
   * @ordered
   */
  protected static final String TAG_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTagName() <em>Tag Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTagName()
   * @generated
   * @ordered
   */
  protected String tagName = TAG_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getTagType() <em>Tag Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTagType()
   * @generated
   * @ordered
   */
  protected static final TagType TAG_TYPE_EDEFAULT = TagType.GLOBAL;

  /**
   * The cached value of the '{@link #getTagType() <em>Tag Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTagType()
   * @generated
   * @ordered
   */
  protected TagType tagType = TAG_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getObjectName() <em>Object Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getObjectName()
   * @generated
   * @ordered
   */
  protected static final String OBJECT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getObjectName() <em>Object Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getObjectName()
   * @generated
   * @ordered
   */
  protected String objectName = OBJECT_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getObjectAltName() <em>Object Alt Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getObjectAltName()
   * @generated
   * @ordered
   */
  protected static final String OBJECT_ALT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getObjectAltName() <em>Object Alt Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getObjectAltName()
   * @generated
   * @ordered
   */
  protected String objectAltName = OBJECT_ALT_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getObjectType() <em>Object Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getObjectType()
   * @generated
   * @ordered
   */
  protected static final String OBJECT_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getObjectType() <em>Object Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getObjectType()
   * @generated
   * @ordered
   */
  protected String objectType = OBJECT_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getComponentName() <em>Component Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getComponentName()
   * @generated
   * @ordered
   */
  protected static final String COMPONENT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getComponentName() <em>Component Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getComponentName()
   * @generated
   * @ordered
   */
  protected String componentName = COMPONENT_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getComponentType() <em>Component Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getComponentType()
   * @generated
   * @ordered
   */
  protected static final String COMPONENT_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getComponentType() <em>Component Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getComponentType()
   * @generated
   * @ordered
   */
  protected String componentType = COMPONENT_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getParentTagId() <em>Parent Tag Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getParentTagId()
   * @generated
   * @ordered
   */
  protected static final String PARENT_TAG_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParentTagId() <em>Parent Tag Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getParentTagId()
   * @generated
   * @ordered
   */
  protected String parentTagId = PARENT_TAG_ID_EDEFAULT;

  /**
   * The default value of the '{@link #getParentTagName() <em>Parent Tag Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getParentTagName()
   * @generated
   * @ordered
   */
  protected static final String PARENT_TAG_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParentTagName() <em>Parent Tag Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getParentTagName()
   * @generated
   * @ordered
   */
  protected String parentTagName = PARENT_TAG_NAME_EDEFAULT;

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
   * The default value of the '{@link #getParentObjectAltName() <em>Parent Object Alt Name</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getParentObjectAltName()
   * @generated
   * @ordered
   */
  protected static final String PARENT_OBJECT_ALT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParentObjectAltName() <em>Parent Object Alt Name</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getParentObjectAltName()
   * @generated
   * @ordered
   */
  protected String parentObjectAltName = PARENT_OBJECT_ALT_NAME_EDEFAULT;

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
  protected TaggedObjectInfo() {
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
    return IAbapTagsPackage.Literals.TAGGED_OBJECT_INFO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getId() {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setId(final String newId) {
    String oldId = id;
    id = newId;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAGGED_OBJECT_INFO__ID,
          oldId, id));
    }
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
          IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_ID, oldTagId, tagId));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getTagName() {
    return tagName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setTagName(final String newTagName) {
    String oldTagName = tagName;
    tagName = newTagName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_NAME, oldTagName, tagName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public TagType getTagType() {
    return tagType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setTagType(final TagType newTagType) {
    TagType oldTagType = tagType;
    tagType = newTagType == null ? TAG_TYPE_EDEFAULT : newTagType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_TYPE, oldTagType, tagType));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getObjectName() {
    return objectName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setObjectName(final String newObjectName) {
    String oldObjectName = objectName;
    objectName = newObjectName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_NAME, oldObjectName, objectName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getObjectAltName() {
    return objectAltName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setObjectAltName(final String newObjectAltName) {
    String oldObjectAltName = objectAltName;
    objectAltName = newObjectAltName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_ALT_NAME, oldObjectAltName, objectAltName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getObjectType() {
    return objectType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setObjectType(final String newObjectType) {
    String oldObjectType = objectType;
    objectType = newObjectType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_TYPE, oldObjectType, objectType));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getComponentName() {
    return componentName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setComponentName(final String newComponentName) {
    String oldComponentName = componentName;
    componentName = newComponentName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_INFO__COMPONENT_NAME, oldComponentName, componentName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getComponentType() {
    return componentType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setComponentType(final String newComponentType) {
    String oldComponentType = componentType;
    componentType = newComponentType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_INFO__COMPONENT_TYPE, oldComponentType, componentType));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getParentTagId() {
    return parentTagId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setParentTagId(final String newParentTagId) {
    String oldParentTagId = parentTagId;
    parentTagId = newParentTagId;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_TAG_ID, oldParentTagId, parentTagId));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getParentTagName() {
    return parentTagName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setParentTagName(final String newParentTagName) {
    String oldParentTagName = parentTagName;
    parentTagName = newParentTagName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_TAG_NAME, oldParentTagName, parentTagName));
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
          IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_NAME, oldParentObjectName,
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
  public String getParentObjectAltName() {
    return parentObjectAltName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setParentObjectAltName(final String newParentObjectAltName) {
    String oldParentObjectAltName = parentObjectAltName;
    parentObjectAltName = newParentObjectAltName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_ALT_NAME, oldParentObjectAltName,
          parentObjectAltName));
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
          IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_TYPE, oldParentObjectType,
          parentObjectType));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   */
  @Override
  public String getObjectDisplayName() {
    var displayName = getObjectAltName();
    return displayName == null ? getObjectName() : displayName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   */
  @Override
  public String getParentObjectDisplayName() {
    var displayName = getParentObjectAltName();
    return displayName == null ? getParentObjectName() : displayName;
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
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__ID:
      return getId();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_ID:
      return getTagId();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_NAME:
      return getTagName();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_TYPE:
      return getTagType();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_NAME:
      return getObjectName();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_ALT_NAME:
      return getObjectAltName();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_TYPE:
      return getObjectType();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__COMPONENT_NAME:
      return getComponentName();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__COMPONENT_TYPE:
      return getComponentType();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_TAG_ID:
      return getParentTagId();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_TAG_NAME:
      return getParentTagName();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_NAME:
      return getParentObjectName();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_ALT_NAME:
      return getParentObjectAltName();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_TYPE:
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
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__ID:
      setId((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_ID:
      setTagId((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_NAME:
      setTagName((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_TYPE:
      setTagType((TagType) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_NAME:
      setObjectName((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_ALT_NAME:
      setObjectAltName((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_TYPE:
      setObjectType((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__COMPONENT_NAME:
      setComponentName((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__COMPONENT_TYPE:
      setComponentType((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_TAG_ID:
      setParentTagId((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_TAG_NAME:
      setParentTagName((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_NAME:
      setParentObjectName((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_ALT_NAME:
      setParentObjectAltName((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_TYPE:
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
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__ID:
      setId(ID_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_ID:
      setTagId(TAG_ID_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_NAME:
      setTagName(TAG_NAME_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_TYPE:
      setTagType(TAG_TYPE_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_NAME:
      setObjectName(OBJECT_NAME_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_ALT_NAME:
      setObjectAltName(OBJECT_ALT_NAME_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_TYPE:
      setObjectType(OBJECT_TYPE_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__COMPONENT_NAME:
      setComponentName(COMPONENT_NAME_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__COMPONENT_TYPE:
      setComponentType(COMPONENT_TYPE_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_TAG_ID:
      setParentTagId(PARENT_TAG_ID_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_TAG_NAME:
      setParentTagName(PARENT_TAG_NAME_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_NAME:
      setParentObjectName(PARENT_OBJECT_NAME_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_ALT_NAME:
      setParentObjectAltName(PARENT_OBJECT_ALT_NAME_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_TYPE:
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
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__ID:
      return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_ID:
      return TAG_ID_EDEFAULT == null ? tagId != null : !TAG_ID_EDEFAULT.equals(tagId);
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_NAME:
      return TAG_NAME_EDEFAULT == null ? tagName != null : !TAG_NAME_EDEFAULT.equals(tagName);
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__TAG_TYPE:
      return tagType != TAG_TYPE_EDEFAULT;
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_NAME:
      return OBJECT_NAME_EDEFAULT == null ? objectName != null
          : !OBJECT_NAME_EDEFAULT.equals(objectName);
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_ALT_NAME:
      return OBJECT_ALT_NAME_EDEFAULT == null ? objectAltName != null
          : !OBJECT_ALT_NAME_EDEFAULT.equals(objectAltName);
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__OBJECT_TYPE:
      return OBJECT_TYPE_EDEFAULT == null ? objectType != null
          : !OBJECT_TYPE_EDEFAULT.equals(objectType);
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__COMPONENT_NAME:
      return COMPONENT_NAME_EDEFAULT == null ? componentName != null
          : !COMPONENT_NAME_EDEFAULT.equals(componentName);
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__COMPONENT_TYPE:
      return COMPONENT_TYPE_EDEFAULT == null ? componentType != null
          : !COMPONENT_TYPE_EDEFAULT.equals(componentType);
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_TAG_ID:
      return PARENT_TAG_ID_EDEFAULT == null ? parentTagId != null
          : !PARENT_TAG_ID_EDEFAULT.equals(parentTagId);
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_TAG_NAME:
      return PARENT_TAG_NAME_EDEFAULT == null ? parentTagName != null
          : !PARENT_TAG_NAME_EDEFAULT.equals(parentTagName);
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_NAME:
      return PARENT_OBJECT_NAME_EDEFAULT == null ? parentObjectName != null
          : !PARENT_OBJECT_NAME_EDEFAULT.equals(parentObjectName);
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_ALT_NAME:
      return PARENT_OBJECT_ALT_NAME_EDEFAULT == null ? parentObjectAltName != null
          : !PARENT_OBJECT_ALT_NAME_EDEFAULT.equals(parentObjectAltName);
    case IAbapTagsPackage.TAGGED_OBJECT_INFO__PARENT_OBJECT_TYPE:
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
  public Object eInvoke(final int operationID, final EList<?> arguments)
      throws InvocationTargetException {
    switch (operationID) {
    case IAbapTagsPackage.TAGGED_OBJECT_INFO___GET_OBJECT_DISPLAY_NAME:
      return getObjectDisplayName();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO___GET_PARENT_OBJECT_DISPLAY_NAME:
      return getParentObjectDisplayName();
    }
    return super.eInvoke(operationID, arguments);
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
    result.append(" (id: ");
    result.append(id);
    result.append(", tagId: ");
    result.append(tagId);
    result.append(", tagName: ");
    result.append(tagName);
    result.append(", tagType: ");
    result.append(tagType);
    result.append(", objectName: ");
    result.append(objectName);
    result.append(", objectAltName: ");
    result.append(objectAltName);
    result.append(", objectType: ");
    result.append(objectType);
    result.append(", componentName: ");
    result.append(componentName);
    result.append(", componentType: ");
    result.append(componentType);
    result.append(", parentTagId: ");
    result.append(parentTagId);
    result.append(", parentTagName: ");
    result.append(parentTagName);
    result.append(", parentObjectName: ");
    result.append(parentObjectName);
    result.append(", parentObjectAltName: ");
    result.append(parentObjectAltName);
    result.append(", parentObjectType: ");
    result.append(parentObjectType);
    result.append(')');
    return result.toString();
  }

} // TaggedObjectInfo
