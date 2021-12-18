/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Tagged
 * Object List</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectList#getTaggedObjects
 * <em>Tagged Objects</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectList()
 * @model extendedMetaData="kind='elementOnly' name='taggedObjects'"
 * @generated
 */
public interface ITaggedObjectList extends EObject {
  /**
   * Returns the value of the '<em><b>Tagged Objects</b></em>' containment
   * reference list. The list contents are of type
   * {@link com.devepos.adt.atm.model.abaptags.ITaggedObject}. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tagged Objects</em>' containment reference
   *         list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectList_TaggedObjects()
   * @model containment="true" extendedMetaData="kind='element'
   *        name='taggedObject' namespace='##targetNamespace'"
   * @generated
   */
  EList<ITaggedObject> getTaggedObjects();

} // ITaggedObjectList
