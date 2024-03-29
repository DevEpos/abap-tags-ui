/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Object Tree Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeObject#getObjectRef <em>Object
 * Ref</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeObject#getTaggedObjectCount
 * <em>Tagged Object Count</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeObject#getParentTagId
 * <em>Parent Tag Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeObject#isExpandable
 * <em>Expandable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedObjectTreeObject extends MinimalEObjectImpl.Container implements
    ITaggedObjectTreeObject {
  /**
   * The cached value of the '{@link #getObjectRef() <em>Object Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getObjectRef()
   * @generated
   * @ordered
   */
  protected IAdtObjRef objectRef;

  /**
   * The default value of the '{@link #getTaggedObjectCount() <em>Tagged Object Count</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTaggedObjectCount()
   * @generated
   * @ordered
   */
  protected static final int TAGGED_OBJECT_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTaggedObjectCount() <em>Tagged Object Count</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTaggedObjectCount()
   * @generated
   * @ordered
   */
  protected int taggedObjectCount = TAGGED_OBJECT_COUNT_EDEFAULT;

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
   * The default value of the '{@link #isExpandable() <em>Expandable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isExpandable()
   * @generated
   * @ordered
   */
  protected static final boolean EXPANDABLE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isExpandable() <em>Expandable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isExpandable()
   * @generated
   * @ordered
   */
  protected boolean expandable = EXPANDABLE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected TaggedObjectTreeObject() {
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
    return IAbapTagsPackage.Literals.TAGGED_OBJECT_TREE_OBJECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IAdtObjRef getObjectRef() {
    return objectRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public NotificationChain basicSetObjectRef(final IAdtObjRef newObjectRef,
      NotificationChain msgs) {
    IAdtObjRef oldObjectRef = objectRef;
    objectRef = newObjectRef;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__OBJECT_REF, oldObjectRef, newObjectRef);
      if (msgs == null) {
        msgs = notification;
      } else {
        msgs.add(notification);
      }
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setObjectRef(final IAdtObjRef newObjectRef) {
    if (newObjectRef != objectRef) {
      NotificationChain msgs = null;
      if (objectRef != null) {
        msgs = ((InternalEObject) objectRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
            - IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__OBJECT_REF, null, msgs);
      }
      if (newObjectRef != null) {
        msgs = ((InternalEObject) newObjectRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
            - IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__OBJECT_REF, null, msgs);
      }
      msgs = basicSetObjectRef(newObjectRef, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    } else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__OBJECT_REF, newObjectRef, newObjectRef));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getTaggedObjectCount() {
    return taggedObjectCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setTaggedObjectCount(final int newTaggedObjectCount) {
    int oldTaggedObjectCount = taggedObjectCount;
    taggedObjectCount = newTaggedObjectCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__TAGGED_OBJECT_COUNT, oldTaggedObjectCount,
          taggedObjectCount));
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
          IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__PARENT_TAG_ID, oldParentTagId, parentTagId));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isExpandable() {
    return expandable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setExpandable(final boolean newExpandable) {
    boolean oldExpandable = expandable;
    expandable = newExpandable;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__EXPANDABLE, oldExpandable, expandable));
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
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__OBJECT_REF:
      return basicSetObjectRef(null, msgs);
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
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__OBJECT_REF:
      return getObjectRef();
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__TAGGED_OBJECT_COUNT:
      return getTaggedObjectCount();
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__PARENT_TAG_ID:
      return getParentTagId();
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__EXPANDABLE:
      return isExpandable();
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
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__OBJECT_REF:
      setObjectRef((IAdtObjRef) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__TAGGED_OBJECT_COUNT:
      setTaggedObjectCount((Integer) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__PARENT_TAG_ID:
      setParentTagId((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__EXPANDABLE:
      setExpandable((Boolean) newValue);
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
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__OBJECT_REF:
      setObjectRef((IAdtObjRef) null);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__TAGGED_OBJECT_COUNT:
      setTaggedObjectCount(TAGGED_OBJECT_COUNT_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__PARENT_TAG_ID:
      setParentTagId(PARENT_TAG_ID_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__EXPANDABLE:
      setExpandable(EXPANDABLE_EDEFAULT);
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
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__OBJECT_REF:
      return objectRef != null;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__TAGGED_OBJECT_COUNT:
      return taggedObjectCount != TAGGED_OBJECT_COUNT_EDEFAULT;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__PARENT_TAG_ID:
      return PARENT_TAG_ID_EDEFAULT == null ? parentTagId != null
          : !PARENT_TAG_ID_EDEFAULT.equals(parentTagId);
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT__EXPANDABLE:
      return expandable != EXPANDABLE_EDEFAULT;
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
    result.append(" (taggedObjectCount: ");
    result.append(taggedObjectCount);
    result.append(", parentTagId: ");
    result.append(parentTagId);
    result.append(", expandable: ");
    result.append(expandable);
    result.append(')');
    return result.toString();
  }

} // TaggedObjectTreeObject
