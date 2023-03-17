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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Tagged
 * Object</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObject#getObjectRef <em>Object
 * Ref</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObject#getTags <em>Tags</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedObject extends MinimalEObjectImpl.Container implements ITaggedObject {
  /**
   * The cached value of the '{@link #getObjectRef() <em>Object Ref</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getObjectRef()
   * @generated
   * @ordered
   */
  protected IAdtObjRef objectRef;

  /**
   * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getTags()
   * @generated
   * @ordered
   */
  protected EList<IAdtObjectTag> tags;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected TaggedObject() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return IAbapTagsPackage.Literals.TAGGED_OBJECT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
          IAbapTagsPackage.TAGGED_OBJECT__OBJECT_REF, oldObjectRef, newObjectRef);
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
            - IAbapTagsPackage.TAGGED_OBJECT__OBJECT_REF, null, msgs);
      }
      if (newObjectRef != null) {
        msgs = ((InternalEObject) newObjectRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
            - IAbapTagsPackage.TAGGED_OBJECT__OBJECT_REF, null, msgs);
      }
      msgs = basicSetObjectRef(newObjectRef, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    } else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT__OBJECT_REF, newObjectRef, newObjectRef));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<IAdtObjectTag> getTags() {
    if (tags == null) {
      tags = new EObjectContainmentEList<>(IAdtObjectTag.class, this,
          IAbapTagsPackage.TAGGED_OBJECT__TAGS);
    }
    return tags;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
      final NotificationChain msgs) {
    switch (featureID) {
    case IAbapTagsPackage.TAGGED_OBJECT__OBJECT_REF:
      return basicSetObjectRef(null, msgs);
    case IAbapTagsPackage.TAGGED_OBJECT__TAGS:
      return ((InternalEList<?>) getTags()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    case IAbapTagsPackage.TAGGED_OBJECT__OBJECT_REF:
      return getObjectRef();
    case IAbapTagsPackage.TAGGED_OBJECT__TAGS:
      return getTags();
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
    case IAbapTagsPackage.TAGGED_OBJECT__OBJECT_REF:
      setObjectRef((IAdtObjRef) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT__TAGS:
      getTags().clear();
      getTags().addAll((Collection<? extends IAdtObjectTag>) newValue);
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
    case IAbapTagsPackage.TAGGED_OBJECT__OBJECT_REF:
      setObjectRef((IAdtObjRef) null);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT__TAGS:
      getTags().clear();
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
    case IAbapTagsPackage.TAGGED_OBJECT__OBJECT_REF:
      return objectRef != null;
    case IAbapTagsPackage.TAGGED_OBJECT__TAGS:
      return tags != null && !tags.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // TaggedObject
