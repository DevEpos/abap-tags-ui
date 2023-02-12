/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITagBase;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Tag
 * Base</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TagBase#getId <em>Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TagBase#getName <em>Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TagBase#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TagBase extends MinimalEObjectImpl.Container implements ITagBase {
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = "";

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getOwner()
   * @generated
   * @ordered
   */
  protected static final String OWNER_EDEFAULT = "";

  /**
   * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getOwner()
   * @generated
   * @ordered
   */
  protected String owner = OWNER_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected TagBase() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return IAbapTagsPackage.Literals.TAG_BASE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getId() {
    return id;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setId(final String newId) {
    String oldId = id;
    id = newId;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAG_BASE__ID, oldId,
          id));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setName(final String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAG_BASE__NAME,
          oldName, name));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getOwner() {
    return owner;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setOwner(final String newOwner) {
    String oldOwner = owner;
    owner = newOwner;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAG_BASE__OWNER,
          oldOwner, owner));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    case IAbapTagsPackage.TAG_BASE__ID:
      return getId();
    case IAbapTagsPackage.TAG_BASE__NAME:
      return getName();
    case IAbapTagsPackage.TAG_BASE__OWNER:
      return getOwner();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case IAbapTagsPackage.TAG_BASE__ID:
      setId((String) newValue);
      return;
    case IAbapTagsPackage.TAG_BASE__NAME:
      setName((String) newValue);
      return;
    case IAbapTagsPackage.TAG_BASE__OWNER:
      setOwner((String) newValue);
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
    case IAbapTagsPackage.TAG_BASE__ID:
      setId(ID_EDEFAULT);
      return;
    case IAbapTagsPackage.TAG_BASE__NAME:
      setName(NAME_EDEFAULT);
      return;
    case IAbapTagsPackage.TAG_BASE__OWNER:
      setOwner(OWNER_EDEFAULT);
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
    case IAbapTagsPackage.TAG_BASE__ID:
      return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
    case IAbapTagsPackage.TAG_BASE__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case IAbapTagsPackage.TAG_BASE__OWNER:
      return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
    result.append(", name: ");
    result.append(name);
    result.append(", owner: ");
    result.append(owner);
    result.append(')');
    return result.toString();
  }

} // TagBase
