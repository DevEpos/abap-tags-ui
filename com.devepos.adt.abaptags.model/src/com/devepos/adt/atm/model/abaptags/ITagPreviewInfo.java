/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.devepos.adt.base.model.adtbase.IAdtObjRef;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Tag
 * Preview Info</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITagPreviewInfo#getTags <em>Tags</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITagPreviewInfo#getAdtObjectRefs <em>Adt Object
 * Refs</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagPreviewInfo()
 * @model extendedMetaData="kind='elementOnly' name='tagPreviewInfo'"
 * @generated
 */
public interface ITagPreviewInfo extends EObject {
  /**
   * Returns the value of the '<em><b>Tags</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.atm.model.abaptags.ITag}.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @return the value of the '<em>Tags</em>' containment reference list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagPreviewInfo_Tags()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='tag' namespace='##targetNamespace'"
   * @generated
   */
  EList<ITag> getTags();

  /**
   * Returns the value of the '<em><b>Adt Object Refs</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.base.model.adtbase.IAdtObjRef}.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Adt Object Refs</em>' containment reference list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagPreviewInfo_AdtObjectRefs()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='adtObjRef'
   *        namespace='http://www.devepos.com/adt/base'"
   * @generated
   */
  EList<IAdtObjRef> getAdtObjectRefs();

} // ITagPreviewInfo
