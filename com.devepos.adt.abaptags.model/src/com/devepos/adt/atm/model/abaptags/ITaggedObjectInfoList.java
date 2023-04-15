/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Object Info List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfoList#getTaggedObjectInfos
 * <em>Tagged Object Infos</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfoList()
 * @model extendedMetaData="kind='elementOnly' name='taggedObjectInfos'"
 * @generated
 */
public interface ITaggedObjectInfoList extends EObject {
  /**
   * Returns the value of the '<em><b>Tagged Object Infos</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tagged Object Infos</em>' containment reference list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfoList_TaggedObjectInfos()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='taggedObjectInfo' namespace='##targetNamespace'"
   * @generated
   */
  EList<ITaggedObjectInfo> getTaggedObjectInfos();

} // ITaggedObjectInfoList
