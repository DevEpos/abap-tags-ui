/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Object Deletion Check Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckResult#getCheckedObjects
 * <em>Checked Objects</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectDeletionCheckResult()
 * @model extendedMetaData="kind='elementOnly' name='taggedObjectDelCheckResult'"
 * @generated
 */
public interface ITaggedObjectDeletionCheckResult extends EObject {
  /**
   * Returns the value of the '<em><b>Checked Objects</b></em>' containment reference list.
   * The list contents are of type
   * {@link com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Checked Objects</em>' containment reference list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectDeletionCheckResult_CheckedObjects()
   * @model containment="true"
   *        extendedMetaData="kind='element' namespace='##targetNamespace' name='checkedObject'"
   * @generated
   */
  EList<ITaggedObjectDeletionCheckObject> getCheckedObjects();

} // ITaggedObjectDeletionCheckResult
