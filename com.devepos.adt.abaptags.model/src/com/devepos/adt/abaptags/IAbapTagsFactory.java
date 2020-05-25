/**
 */
package com.devepos.adt.abaptags;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.devepos.adt.abaptags.IAbapTagsPackage
 * @generated
 */
public interface IAbapTagsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IAbapTagsFactory eINSTANCE = com.devepos.adt.abaptags.impl.AbapTagsFactory.init();

	/**
	 * Returns a new object of class '<em>Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag</em>'.
	 * @generated
	 */
	ITag createTag();

	/**
	 * Returns a new object of class '<em>Adt Object Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adt Object Tag</em>'.
	 * @generated
	 */
	IAdtObjectTag createAdtObjectTag();

	/**
	 * Returns a new object of class '<em>Tag List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag List</em>'.
	 * @generated
	 */
	ITagList createTagList();

	/**
	 * Returns a new object of class '<em>Tag Preview Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag Preview Info</em>'.
	 * @generated
	 */
	ITagPreviewInfo createTagPreviewInfo();

	/**
	 * Returns a new object of class '<em>Tagged Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tagged Object</em>'.
	 * @generated
	 */
	ITaggedObject createTaggedObject();

	/**
	 * Returns a new object of class '<em>Tagged Object List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tagged Object List</em>'.
	 * @generated
	 */
	ITaggedObjectList createTaggedObjectList();

	/**
	 * Returns a new object of class '<em>Tagged Object Search Params</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tagged Object Search Params</em>'.
	 * @generated
	 */
	ITaggedObjectSearchParams createTaggedObjectSearchParams();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IAbapTagsPackage getAbapTagsPackage();

} //IAbapTagsFactory
