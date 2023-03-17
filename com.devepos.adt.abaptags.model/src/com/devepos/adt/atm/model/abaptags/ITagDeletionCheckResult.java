/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag Deletion Check Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITagDeletionCheckResult#getCheckedTags <em>Checked
 * Tags</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagDeletionCheckResult()
 * @model extendedMetaData="kind='elementOnly' name='deletionCheckResult'"
 * @generated
 */
public interface ITagDeletionCheckResult extends EObject {

  /**
   * Returns the value of the '<em><b>Checked Tags</b></em>' reference list.
   * The list contents are of type
   * {@link com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Checked Tags</em>' reference list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagDeletionCheckResult_CheckedTags()
   * @model extendedMetaData="kind='element' name='checkedTag' namespace='##targetNamespace'"
   * @generated
   */
  EList<ITagDeletionCheckObject> getCheckedTags();
} // ITagDeletionCheckResult
