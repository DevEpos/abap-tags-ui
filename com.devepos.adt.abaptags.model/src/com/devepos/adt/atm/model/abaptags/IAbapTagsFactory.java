/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage
 * @generated
 */
public interface IAbapTagsFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  IAbapTagsFactory eINSTANCE = com.devepos.adt.atm.model.abaptags.impl.AbapTagsFactory.init();

  /**
   * Returns a new object of class '<em>Tag</em>'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @return a new object of class '<em>Tag</em>'.
   * @generated
   */
  ITag createTag();

  /**
   * Returns a new object of class '<em>Adt Object Tag</em>'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Adt Object Tag</em>'.
   * @generated
   */
  IAdtObjectTag createAdtObjectTag();

  /**
   * Returns a new object of class '<em>Tag List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tag List</em>'.
   * @generated
   */
  ITagList createTagList();

  /**
   * Returns a new object of class '<em>Tag Preview Info</em>'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tag Preview Info</em>'.
   * @generated
   */
  ITagPreviewInfo createTagPreviewInfo();

  /**
   * Returns a new object of class '<em>Tagged Object</em>'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tagged Object</em>'.
   * @generated
   */
  ITaggedObject createTaggedObject();

  /**
   * Returns a new object of class '<em>Tagged Object List</em>'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tagged Object List</em>'.
   * @generated
   */
  ITaggedObjectList createTaggedObjectList();

  /**
   * Returns a new object of class '<em>Tagged Object Tree Request</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tagged Object Tree Request</em>'.
   * @generated
   */
  ITaggedObjectTreeRequest createTaggedObjectTreeRequest();

  /**
   * Returns a new object of class '<em>Tagged Object Search Params</em>'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tagged Object Search Params</em>'.
   * @generated
   */
  ITaggedObjectSearchParams createTaggedObjectSearchParams();

  /**
   * Returns a new object of class '<em>Tag Deletion Check Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tag Deletion Check Result</em>'.
   * @generated
   */
  ITagDeletionCheckResult createTagDeletionCheckResult();

  /**
   * Returns a new object of class '<em>Tag Deletion Check Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tag Deletion Check Object</em>'.
   * @generated
   */
  ITagDeletionCheckObject createTagDeletionCheckObject();

  /**
   * Returns a new object of class '<em>Tagged Object Tree Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tagged Object Tree Object</em>'.
   * @generated
   */
  ITaggedObjectTreeObject createTaggedObjectTreeObject();

  /**
   * Returns a new object of class '<em>Tagged Object Tree Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tagged Object Tree Result</em>'.
   * @generated
   */
  ITaggedObjectTreeResult createTaggedObjectTreeResult();

  /**
   * Returns a new object of class '<em>Tagged Object List Request</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tagged Object List Request</em>'.
   * @generated
   */
  ITaggedObjectListRequest createTaggedObjectListRequest();

  /**
   * Returns a new object of class '<em>Tagged Object Info</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tagged Object Info</em>'.
   * @generated
   */
  ITaggedObjectInfo createTaggedObjectInfo();

  /**
   * Returns a new object of class '<em>Tagged Object Info List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tagged Object Info List</em>'.
   * @generated
   */
  ITaggedObjectInfoList createTaggedObjectInfoList();

  /**
   * Returns a new object of class '<em>Tagged Object Deletion Check Request</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tagged Object Deletion Check Request</em>'.
   * @generated
   */
  ITaggedObjectDeletionCheckRequest createTaggedObjectDeletionCheckRequest();

  /**
   * Returns a new object of class '<em>Tagged Object Deletion Check Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tagged Object Deletion Check Result</em>'.
   * @generated
   */
  ITaggedObjectDeletionCheckResult createTaggedObjectDeletionCheckResult();

  /**
   * Returns a new object of class '<em>Tagged Object Deletion Check Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tagged Object Deletion Check Object</em>'.
   * @generated
   */
  ITaggedObjectDeletionCheckObject createTaggedObjectDeletionCheckObject();

  /**
   * Returns a new object of class '<em>Tagged Object Delete Request</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Tagged Object Delete Request</em>'.
   * @generated
   */
  ITaggedObjectDeleteRequest createTaggedObjectDeleteRequest();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @return the package supported by this factory.
   * @generated
   */
  IAbapTagsPackage getAbapTagsPackage();

} // IAbapTagsFactory
