/**
 */
package com.devepos.adt.abaptags.util;

import com.devepos.adt.abaptags.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.devepos.adt.abaptags.IAbapTagsPackage
 * @generated
 */
public class AbapTagsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static IAbapTagsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbapTagsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = IAbapTagsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbapTagsSwitch<Adapter> modelSwitch =
		new AbapTagsSwitch<Adapter>() {
			@Override
			public Adapter caseTagBase(ITagBase object) {
				return createTagBaseAdapter();
			}
			@Override
			public Adapter caseTag(ITag object) {
				return createTagAdapter();
			}
			@Override
			public Adapter caseAdtObjectTag(IAdtObjectTag object) {
				return createAdtObjectTagAdapter();
			}
			@Override
			public Adapter caseTagList(ITagList object) {
				return createTagListAdapter();
			}
			@Override
			public Adapter caseTagPreviewInfo(ITagPreviewInfo object) {
				return createTagPreviewInfoAdapter();
			}
			@Override
			public Adapter caseTaggedObject(ITaggedObject object) {
				return createTaggedObjectAdapter();
			}
			@Override
			public Adapter caseTaggedObjectList(ITaggedObjectList object) {
				return createTaggedObjectListAdapter();
			}
			@Override
			public Adapter caseTaggedObjectSearchParams(ITaggedObjectSearchParams object) {
				return createTaggedObjectSearchParamsAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.devepos.adt.abaptags.ITagBase <em>Tag Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.devepos.adt.abaptags.ITagBase
	 * @generated
	 */
	public Adapter createTagBaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.devepos.adt.abaptags.ITag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.devepos.adt.abaptags.ITag
	 * @generated
	 */
	public Adapter createTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.devepos.adt.abaptags.IAdtObjectTag <em>Adt Object Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.devepos.adt.abaptags.IAdtObjectTag
	 * @generated
	 */
	public Adapter createAdtObjectTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.devepos.adt.abaptags.ITagList <em>Tag List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.devepos.adt.abaptags.ITagList
	 * @generated
	 */
	public Adapter createTagListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.devepos.adt.abaptags.ITagPreviewInfo <em>Tag Preview Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.devepos.adt.abaptags.ITagPreviewInfo
	 * @generated
	 */
	public Adapter createTagPreviewInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.devepos.adt.abaptags.ITaggedObject <em>Tagged Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.devepos.adt.abaptags.ITaggedObject
	 * @generated
	 */
	public Adapter createTaggedObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.devepos.adt.abaptags.ITaggedObjectList <em>Tagged Object List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.devepos.adt.abaptags.ITaggedObjectList
	 * @generated
	 */
	public Adapter createTaggedObjectListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams <em>Tagged Object Search Params</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.devepos.adt.abaptags.ITaggedObjectSearchParams
	 * @generated
	 */
	public Adapter createTaggedObjectSearchParamsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AbapTagsAdapterFactory
