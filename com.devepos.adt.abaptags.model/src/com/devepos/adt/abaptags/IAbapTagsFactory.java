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
	 * Returns a new object of class '<em>Tags</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tags</em>'.
	 * @generated
	 */
	ITags createTags();

	/**
	 * Returns a new object of class '<em>Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag</em>'.
	 * @generated
	 */
	ITag createTag();

	/**
	 * Returns a new object of class '<em>Abap Object With Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abap Object With Tag</em>'.
	 * @generated
	 */
	IAbapObjectWithTag createAbapObjectWithTag();

	/**
	 * Returns a new object of class '<em>Abap Object With Tags</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abap Object With Tags</em>'.
	 * @generated
	 */
	IAbapObjectWithTags createAbapObjectWithTags();

	/**
	 * Returns a new object of class '<em>Abap Objects With Tags</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abap Objects With Tags</em>'.
	 * @generated
	 */
	IAbapObjectsWithTags createAbapObjectsWithTags();

	/**
	 * Returns a new object of class '<em>Abap Objects With Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abap Objects With Tag</em>'.
	 * @generated
	 */
	IAbapObjectsWithTag createAbapObjectsWithTag();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IAbapTagsPackage getAbapTagsPackage();

} //IAbapTagsFactory
