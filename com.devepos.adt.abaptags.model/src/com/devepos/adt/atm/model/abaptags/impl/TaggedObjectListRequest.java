/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectListRequest;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Object List Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectListRequest#getTagIds <em>Tag
 * Ids</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectListRequest#getTaggedObjectIds
 * <em>Tagged Object Ids</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectListRequest#getTaggedObjectInfos
 * <em>Tagged Object Infos</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectListRequest#isLoadChildObjects
 * <em>Load Child Objects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedObjectListRequest extends MinimalEObjectImpl.Container implements
    ITaggedObjectListRequest {
  /**
   * The cached value of the '{@link #getTagIds() <em>Tag Ids</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTagIds()
   * @generated
   * @ordered
   */
  protected EList<String> tagIds;

  /**
   * The cached value of the '{@link #getTaggedObjectIds() <em>Tagged Object Ids</em>}' attribute
   * list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTaggedObjectIds()
   * @generated
   * @ordered
   */
  protected EList<String> taggedObjectIds;

  /**
   * The cached value of the '{@link #getTaggedObjectInfos() <em>Tagged Object Infos</em>}'
   * containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTaggedObjectInfos()
   * @generated
   * @ordered
   */
  protected EList<ITaggedObjectInfo> taggedObjectInfos;

  /**
   * The default value of the '{@link #isLoadChildObjects() <em>Load Child Objects</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isLoadChildObjects()
   * @generated
   * @ordered
   */
  protected static final boolean LOAD_CHILD_OBJECTS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isLoadChildObjects() <em>Load Child Objects</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isLoadChildObjects()
   * @generated
   * @ordered
   */
  protected boolean loadChildObjects = LOAD_CHILD_OBJECTS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected TaggedObjectListRequest() {
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
    return IAbapTagsPackage.Literals.TAGGED_OBJECT_LIST_REQUEST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<String> getTagIds() {
    if (tagIds == null) {
      tagIds = new EDataTypeUniqueEList<>(String.class, this,
          IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAG_IDS);
    }
    return tagIds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<String> getTaggedObjectIds() {
    if (taggedObjectIds == null) {
      taggedObjectIds = new EDataTypeUniqueEList<>(String.class, this,
          IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAGGED_OBJECT_IDS);
    }
    return taggedObjectIds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<ITaggedObjectInfo> getTaggedObjectInfos() {
    if (taggedObjectInfos == null) {
      taggedObjectInfos = new EObjectContainmentEList<>(ITaggedObjectInfo.class,
          this, IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAGGED_OBJECT_INFOS);
    }
    return taggedObjectInfos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isLoadChildObjects() {
    return loadChildObjects;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setLoadChildObjects(final boolean newLoadChildObjects) {
    boolean oldLoadChildObjects = loadChildObjects;
    loadChildObjects = newLoadChildObjects;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__LOAD_CHILD_OBJECTS, oldLoadChildObjects,
          loadChildObjects));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
      final NotificationChain msgs) {
    switch (featureID) {
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAGGED_OBJECT_INFOS:
      return ((InternalEList<?>) getTaggedObjectInfos()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAG_IDS:
      return getTagIds();
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAGGED_OBJECT_IDS:
      return getTaggedObjectIds();
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAGGED_OBJECT_INFOS:
      return getTaggedObjectInfos();
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__LOAD_CHILD_OBJECTS:
      return isLoadChildObjects();
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
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAG_IDS:
      getTagIds().clear();
      getTagIds().addAll((Collection<? extends String>) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAGGED_OBJECT_IDS:
      getTaggedObjectIds().clear();
      getTaggedObjectIds().addAll((Collection<? extends String>) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAGGED_OBJECT_INFOS:
      getTaggedObjectInfos().clear();
      getTaggedObjectInfos().addAll((Collection<? extends ITaggedObjectInfo>) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__LOAD_CHILD_OBJECTS:
      setLoadChildObjects((Boolean) newValue);
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
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAG_IDS:
      getTagIds().clear();
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAGGED_OBJECT_IDS:
      getTaggedObjectIds().clear();
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAGGED_OBJECT_INFOS:
      getTaggedObjectInfos().clear();
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__LOAD_CHILD_OBJECTS:
      setLoadChildObjects(LOAD_CHILD_OBJECTS_EDEFAULT);
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
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAG_IDS:
      return tagIds != null && !tagIds.isEmpty();
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAGGED_OBJECT_IDS:
      return taggedObjectIds != null && !taggedObjectIds.isEmpty();
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__TAGGED_OBJECT_INFOS:
      return taggedObjectInfos != null && !taggedObjectInfos.isEmpty();
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST__LOAD_CHILD_OBJECTS:
      return loadChildObjects != LOAD_CHILD_OBJECTS_EDEFAULT;
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
    result.append(" (tagIds: ");
    result.append(tagIds);
    result.append(", taggedObjectIds: ");
    result.append(taggedObjectIds);
    result.append(", loadChildObjects: ");
    result.append(loadChildObjects);
    result.append(')');
    return result.toString();
  }

} // TaggedObjectListRequest
