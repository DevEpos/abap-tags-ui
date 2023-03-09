/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Object Tree Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult#getObjects
 * <em>Objects</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult#getTags <em>Tags</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectTreeResult()
 * @model extendedMetaData="kind='elementOnly' name='tagTreeResult'"
 * @generated
 */
public interface ITaggedObjectTreeResult extends EObject {
  /**
   * Returns the value of the '<em><b>Objects</b></em>' containment reference list.
   * The list contents are of type
   * {@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Objects</em>' containment reference list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectTreeResult_Objects()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='object' namespace='##targetNamespace'"
   * @generated
   */
  EList<ITaggedObjectTreeObject> getObjects();

  /**
   * Returns the value of the '<em><b>Tags</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.atm.model.abaptags.ITag}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tags</em>' containment reference list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectTreeResult_Tags()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='tag' namespace='##targetNamespace'"
   * @generated
   */
  EList<ITag> getTags();

} // ITaggedObjectTreeResult
