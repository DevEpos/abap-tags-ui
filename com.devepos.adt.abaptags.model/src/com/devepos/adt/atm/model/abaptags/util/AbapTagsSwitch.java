/**
 */
package com.devepos.adt.atm.model.abaptags.util;

import com.devepos.adt.atm.model.abaptags.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage
 * @generated
 */
public class AbapTagsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static IAbapTagsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbapTagsSwitch() {
		if (modelPackage == null) {
			modelPackage = IAbapTagsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case IAbapTagsPackage.TAG_BASE: {
				ITagBase tagBase = (ITagBase)theEObject;
				T result = caseTagBase(tagBase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IAbapTagsPackage.TAG: {
				ITag tag = (ITag)theEObject;
				T result = caseTag(tag);
				if (result == null) result = caseTagBase(tag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IAbapTagsPackage.TAG_LIST: {
				ITagList tagList = (ITagList)theEObject;
				T result = caseTagList(tagList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IAbapTagsPackage.ADT_OBJECT_TAG: {
				IAdtObjectTag adtObjectTag = (IAdtObjectTag)theEObject;
				T result = caseAdtObjectTag(adtObjectTag);
				if (result == null) result = caseTagBase(adtObjectTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IAbapTagsPackage.TAG_PREVIEW_INFO: {
				ITagPreviewInfo tagPreviewInfo = (ITagPreviewInfo)theEObject;
				T result = caseTagPreviewInfo(tagPreviewInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IAbapTagsPackage.TAGGED_OBJECT: {
				ITaggedObject taggedObject = (ITaggedObject)theEObject;
				T result = caseTaggedObject(taggedObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IAbapTagsPackage.TAGGED_OBJECT_LIST: {
				ITaggedObjectList taggedObjectList = (ITaggedObjectList)theEObject;
				T result = caseTaggedObjectList(taggedObjectList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS: {
				ITaggedObjectSearchParams taggedObjectSearchParams = (ITaggedObjectSearchParams)theEObject;
				T result = caseTaggedObjectSearchParams(taggedObjectSearchParams);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTagBase(ITagBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTag(ITag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Adt Object Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Adt Object Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdtObjectTag(IAdtObjectTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTagList(ITagList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag Preview Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag Preview Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTagPreviewInfo(ITagPreviewInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tagged Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tagged Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaggedObject(ITaggedObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tagged Object List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tagged Object List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaggedObjectList(ITaggedObjectList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tagged Object Search Params</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tagged Object Search Params</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaggedObjectSearchParams(ITaggedObjectSearchParams object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //AbapTagsSwitch
