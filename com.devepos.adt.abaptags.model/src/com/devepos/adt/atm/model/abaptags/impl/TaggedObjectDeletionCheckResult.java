/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Object Deletion Check Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectDeletionCheckResult#getCheckedObjects
 * <em>Checked Objects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedObjectDeletionCheckResult extends MinimalEObjectImpl.Container implements
    ITaggedObjectDeletionCheckResult {
  /**
   * The cached value of the '{@link #getCheckedObjects() <em>Checked Objects</em>}' containment
   * reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCheckedObjects()
   * @generated
   * @ordered
   */
  protected EList<ITaggedObjectDeletionCheckObject> checkedObjects;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected TaggedObjectDeletionCheckResult() {
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
    return IAbapTagsPackage.Literals.TAGGED_OBJECT_DELETION_CHECK_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<ITaggedObjectDeletionCheckObject> getCheckedObjects() {
    if (checkedObjects == null) {
      checkedObjects = new EObjectContainmentEList<>(
          ITaggedObjectDeletionCheckObject.class, this,
          IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_RESULT__CHECKED_OBJECTS);
    }
    return checkedObjects;
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_RESULT__CHECKED_OBJECTS:
      return ((InternalEList<?>) getCheckedObjects()).basicRemove(otherEnd, msgs);
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_RESULT__CHECKED_OBJECTS:
      return getCheckedObjects();
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_RESULT__CHECKED_OBJECTS:
      getCheckedObjects().clear();
      getCheckedObjects().addAll((Collection<? extends ITaggedObjectDeletionCheckObject>) newValue);
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_RESULT__CHECKED_OBJECTS:
      getCheckedObjects().clear();
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_RESULT__CHECKED_OBJECTS:
      return checkedObjects != null && !checkedObjects.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // TaggedObjectDeletionCheckResult
