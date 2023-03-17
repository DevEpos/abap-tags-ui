/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject;
import com.devepos.adt.atm.model.abaptags.ITagDeletionCheckResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tag Deletion Check Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TagDeletionCheckResult#getCheckedTags
 * <em>Checked Tags</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TagDeletionCheckResult extends MinimalEObjectImpl.Container implements
    ITagDeletionCheckResult {
  /**
   * The cached value of the '{@link #getCheckedTags() <em>Checked Tags</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getCheckedTags()
   * @generated
   * @ordered
   */
  protected EList<ITagDeletionCheckObject> checkedTags;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected TagDeletionCheckResult() {
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
    return IAbapTagsPackage.Literals.TAG_DELETION_CHECK_RESULT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<ITagDeletionCheckObject> getCheckedTags() {
    if (checkedTags == null) {
      checkedTags = new EObjectResolvingEList<>(
          ITagDeletionCheckObject.class, this,
          IAbapTagsPackage.TAG_DELETION_CHECK_RESULT__CHECKED_TAGS);
    }
    return checkedTags;
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
    case IAbapTagsPackage.TAG_DELETION_CHECK_RESULT__CHECKED_TAGS:
      return getCheckedTags();
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
    case IAbapTagsPackage.TAG_DELETION_CHECK_RESULT__CHECKED_TAGS:
      getCheckedTags().clear();
      getCheckedTags().addAll((Collection<? extends ITagDeletionCheckObject>) newValue);
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
    case IAbapTagsPackage.TAG_DELETION_CHECK_RESULT__CHECKED_TAGS:
      getCheckedTags().clear();
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
    case IAbapTagsPackage.TAG_DELETION_CHECK_RESULT__CHECKED_TAGS:
      return checkedTags != null && !checkedTags.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // TagDeletionCheckResult
