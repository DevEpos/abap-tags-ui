/**
 */
package com.devepos.adt.abaptags.impl;

import com.devepos.adt.abaptags.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AbapTagsFactory extends EFactoryImpl implements IAbapTagsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IAbapTagsFactory init() {
		try {
			IAbapTagsFactory theAbapTagsFactory = (IAbapTagsFactory)EPackage.Registry.INSTANCE.getEFactory(IAbapTagsPackage.eNS_URI);
			if (theAbapTagsFactory != null) {
				return theAbapTagsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AbapTagsFactory();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbapTagsFactory() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case IAbapTagsPackage.TAGS: return createTags();
			case IAbapTagsPackage.TAG: return createTag();
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAG: return createAbapObjectWithTag();
			case IAbapTagsPackage.ABAP_OBJECT_WITH_TAGS: return createAbapObjectWithTags();
			case IAbapTagsPackage.ABAP_OBJECTS_WITH_TAGS: return createAbapObjectsWithTags();
			case IAbapTagsPackage.ABAP_OBJECTS_WITH_TAG: return createAbapObjectsWithTag();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ITags createTags() {
		Tags tags = new Tags();
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ITag createTag() {
		Tag tag = new Tag();
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IAbapObjectWithTag createAbapObjectWithTag() {
		AbapObjectWithTag abapObjectWithTag = new AbapObjectWithTag();
		return abapObjectWithTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IAbapObjectWithTags createAbapObjectWithTags() {
		AbapObjectWithTags abapObjectWithTags = new AbapObjectWithTags();
		return abapObjectWithTags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IAbapObjectsWithTags createAbapObjectsWithTags() {
		AbapObjectsWithTags abapObjectsWithTags = new AbapObjectsWithTags();
		return abapObjectsWithTags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IAbapObjectsWithTag createAbapObjectsWithTag() {
		AbapObjectsWithTag abapObjectsWithTag = new AbapObjectsWithTag();
		return abapObjectsWithTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IAbapTagsPackage getAbapTagsPackage() {
		return (IAbapTagsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IAbapTagsPackage getPackage() {
		return IAbapTagsPackage.eINSTANCE;
	}

} //AbapTagsFactory
