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
import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfoList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Object Info List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectInfoList#getTaggedObjectInfos
 * <em>Tagged Object Infos</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedObjectInfoList extends MinimalEObjectImpl.Container implements
    ITaggedObjectInfoList {
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected TaggedObjectInfoList() {
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
    return IAbapTagsPackage.Literals.TAGGED_OBJECT_INFO_LIST;
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
          this, IAbapTagsPackage.TAGGED_OBJECT_INFO_LIST__TAGGED_OBJECT_INFOS);
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
  public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
      final NotificationChain msgs) {
    switch (featureID) {
    case IAbapTagsPackage.TAGGED_OBJECT_INFO_LIST__TAGGED_OBJECT_INFOS:
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
    case IAbapTagsPackage.TAGGED_OBJECT_INFO_LIST__TAGGED_OBJECT_INFOS:
      return getTaggedObjectInfos();
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
    case IAbapTagsPackage.TAGGED_OBJECT_INFO_LIST__TAGGED_OBJECT_INFOS:
      getTaggedObjectInfos().clear();
      getTaggedObjectInfos().addAll((Collection<? extends ITaggedObjectInfo>) newValue);
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
    case IAbapTagsPackage.TAGGED_OBJECT_INFO_LIST__TAGGED_OBJECT_INFOS:
      getTaggedObjectInfos().clear();
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
    case IAbapTagsPackage.TAGGED_OBJECT_INFO_LIST__TAGGED_OBJECT_INFOS:
      return taggedObjectInfos != null && !taggedObjectInfos.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // TaggedObjectInfoList
