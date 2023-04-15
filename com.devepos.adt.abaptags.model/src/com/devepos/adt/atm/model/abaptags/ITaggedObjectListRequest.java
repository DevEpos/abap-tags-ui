/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Object List Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectListRequest#getTagIds <em>Tag
 * Ids</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectListRequest#getTaggedObjectIds
 * <em>Tagged Object Ids</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectListRequest#getTaggedObjectInfos
 * <em>Tagged Object Infos</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectListRequest#isLoadChildObjects
 * <em>Load Child Objects</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectListRequest()
 * @model extendedMetaData="kind='elementOnly' name='taggedObjectListRequest'"
 * @generated
 */
public interface ITaggedObjectListRequest extends EObject {
  /**
   * Returns the value of the '<em><b>Tag Ids</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tag Ids</em>' attribute list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectListRequest_TagIds()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='element' name='tagId' namespace='##targetNamespace'"
   * @generated
   */
  EList<String> getTagIds();

  /**
   * Returns the value of the '<em><b>Tagged Object Ids</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tagged Object Ids</em>' attribute list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectListRequest_TaggedObjectIds()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='element' name='taggedObjectId' namespace='##targetNamespace'"
   * @generated
   */
  EList<String> getTaggedObjectIds();

  /**
   * Returns the value of the '<em><b>Tagged Object Infos</b></em>' containment reference list.
   * The list contents are of type {@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tagged Object Infos</em>' containment reference list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectListRequest_TaggedObjectInfos()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='taggedObjectInfo' namespace='##targetNamespace'"
   * @generated
   */
  EList<ITaggedObjectInfo> getTaggedObjectInfos();

  /**
   * Returns the value of the '<em><b>Load Child Objects</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Load Child Objects</em>' attribute.
   * @see #setLoadChildObjects(boolean)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectListRequest_LoadChildObjects()
   * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
   *        extendedMetaData="kind='attribute' namespace='##targetNamespace'
   *        name='loadChildObjects'"
   * @generated
   */
  boolean isLoadChildObjects();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectListRequest#isLoadChildObjects <em>Load
   * Child Objects</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Load Child Objects</em>' attribute.
   * @see #isLoadChildObjects()
   * @generated
   */
  void setLoadChildObjects(boolean value);

} // ITaggedObjectListRequest
