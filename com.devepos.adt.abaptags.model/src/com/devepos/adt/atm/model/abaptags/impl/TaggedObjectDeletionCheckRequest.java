/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckRequest;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Object Deletion Check Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectDeletionCheckRequest#getTaggedObjectIds
 * <em>Tagged Object Ids</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedObjectDeletionCheckRequest extends MinimalEObjectImpl.Container implements
    ITaggedObjectDeletionCheckRequest {
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected TaggedObjectDeletionCheckRequest() {
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
    return IAbapTagsPackage.Literals.TAGGED_OBJECT_DELETION_CHECK_REQUEST;
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
          IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_REQUEST__TAGGED_OBJECT_IDS);
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
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_REQUEST__TAGGED_OBJECT_IDS:
      return getTaggedObjectIds();
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_REQUEST__TAGGED_OBJECT_IDS:
      getTaggedObjectIds().clear();
      getTaggedObjectIds().addAll((Collection<? extends String>) newValue);
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_REQUEST__TAGGED_OBJECT_IDS:
      getTaggedObjectIds().clear();
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
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_REQUEST__TAGGED_OBJECT_IDS:
      return taggedObjectIds != null && !taggedObjectIds.isEmpty();
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
    result.append(" (taggedObjectIds: ");
    result.append(taggedObjectIds);
    result.append(')');
    return result.toString();
  }

} // TaggedObjectDeletionCheckRequest
