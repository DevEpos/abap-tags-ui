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
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Object Tree Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeResult#getTaggedObjectCount
 * <em>Tagged Object Count</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeResult#getObjects
 * <em>Objects</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeResult#getTags
 * <em>Tags</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedObjectTreeResult extends MinimalEObjectImpl.Container implements
    ITaggedObjectTreeResult {
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
   * The cached value of the '{@link #getObjects() <em>Objects</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getObjects()
   * @generated
   * @ordered
   */
  protected EList<ITaggedObjectTreeObject> objects;

  /**
   * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getTags()
   * @generated
   * @ordered
   */
  protected EList<ITag> tags;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected TaggedObjectTreeResult() {
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
    return IAbapTagsPackage.Literals.TAGGED_OBJECT_TREE_RESULT;
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
  public void setTaggedObjectCount(final int newTaggedObjectCount) {
    int oldTaggedObjectCount = taggedObjectCount;
    taggedObjectCount = newTaggedObjectCount;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__TAGGED_OBJECT_COUNT, oldTaggedObjectCount,
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
  public EList<ITaggedObjectTreeObject> getObjects() {
    if (objects == null) {
      objects = new EObjectContainmentEList<>(ITaggedObjectTreeObject.class,
          this, IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__OBJECTS);
    }
    return objects;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<ITag> getTags() {
    if (tags == null) {
      tags = new EObjectContainmentEList<>(ITag.class, this,
          IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__TAGS);
    }
    return tags;
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
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__OBJECTS:
      return ((InternalEList<?>) getObjects()).basicRemove(otherEnd, msgs);
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__TAGS:
      return ((InternalEList<?>) getTags()).basicRemove(otherEnd, msgs);
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
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__TAGGED_OBJECT_COUNT:
      return getTaggedObjectCount();
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__OBJECTS:
      return getObjects();
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__TAGS:
      return getTags();
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
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__TAGGED_OBJECT_COUNT:
      setTaggedObjectCount((Integer) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__OBJECTS:
      getObjects().clear();
      getObjects().addAll((Collection<? extends ITaggedObjectTreeObject>) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__TAGS:
      getTags().clear();
      getTags().addAll((Collection<? extends ITag>) newValue);
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
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__TAGGED_OBJECT_COUNT:
      setTaggedObjectCount(TAGGED_OBJECT_COUNT_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__OBJECTS:
      getObjects().clear();
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__TAGS:
      getTags().clear();
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
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__TAGGED_OBJECT_COUNT:
      return taggedObjectCount != TAGGED_OBJECT_COUNT_EDEFAULT;
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__OBJECTS:
      return objects != null && !objects.isEmpty();
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT__TAGS:
      return tags != null && !tags.isEmpty();
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
    result.append(')');
    return result.toString();
  }

} // TaggedObjectTreeResult
