/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeleteRequest;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Object Delete Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectDeleteRequest#getObjectId
 * <em>Object Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedObjectDeleteRequest extends MinimalEObjectImpl.Container implements
    ITaggedObjectDeleteRequest {
  /**
   * The cached value of the '{@link #getObjectId() <em>Object Id</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getObjectId()
   * @generated
   * @ordered
   */
  protected EList<String> objectId;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected TaggedObjectDeleteRequest() {
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
    return IAbapTagsPackage.Literals.TAGGED_OBJECT_DELETE_REQUEST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<String> getObjectId() {
    if (objectId == null) {
      objectId = new EDataTypeUniqueEList<>(String.class, this,
          IAbapTagsPackage.TAGGED_OBJECT_DELETE_REQUEST__OBJECT_ID);
    }
    return objectId;
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETE_REQUEST__OBJECT_ID:
      return getObjectId();
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETE_REQUEST__OBJECT_ID:
      getObjectId().clear();
      getObjectId().addAll((Collection<? extends String>) newValue);
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETE_REQUEST__OBJECT_ID:
      getObjectId().clear();
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETE_REQUEST__OBJECT_ID:
      return objectId != null && !objectId.isEmpty();
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
    result.append(" (objectId: ");
    result.append(objectId);
    result.append(')');
    return result.toString();
  }

} // TaggedObjectDeleteRequest
