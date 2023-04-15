/**
 */
package com.devepos.adt.atm.model.abaptags.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagBase;
import com.devepos.adt.atm.model.abaptags.ITagDeletionCheckObject;
import com.devepos.adt.atm.model.abaptags.ITagDeletionCheckResult;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.ITagPreviewInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeleteRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckResult;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfoList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectListRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage
 * @generated
 */
public class AbapTagsSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected static IAbapTagsPackage modelPackage;

  /**
   * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   */
  public AbapTagsSwitch() {
    if (modelPackage == null) {
      modelPackage = IAbapTagsPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(final EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it
   * yields that result.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(final int classifierID, final EObject theEObject) {
    switch (classifierID) {
    case IAbapTagsPackage.TAG_BASE: {
      ITagBase tagBase = (ITagBase) theEObject;
      T result = caseTagBase(tagBase);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAG: {
      ITag tag = (ITag) theEObject;
      T result = caseTag(tag);
      if (result == null) {
        result = caseTagBase(tag);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAG_LIST: {
      ITagList tagList = (ITagList) theEObject;
      T result = caseTagList(tagList);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.ADT_OBJECT_TAG: {
      IAdtObjectTag adtObjectTag = (IAdtObjectTag) theEObject;
      T result = caseAdtObjectTag(adtObjectTag);
      if (result == null) {
        result = caseTagBase(adtObjectTag);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAG_PREVIEW_INFO: {
      ITagPreviewInfo tagPreviewInfo = (ITagPreviewInfo) theEObject;
      T result = caseTagPreviewInfo(tagPreviewInfo);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAGGED_OBJECT: {
      ITaggedObject taggedObject = (ITaggedObject) theEObject;
      T result = caseTaggedObject(taggedObject);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAGGED_OBJECT_LIST: {
      ITaggedObjectList taggedObjectList = (ITaggedObjectList) theEObject;
      T result = caseTaggedObjectList(taggedObjectList);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST: {
      ITaggedObjectTreeRequest taggedObjectTreeRequest = (ITaggedObjectTreeRequest) theEObject;
      T result = caseTaggedObjectTreeRequest(taggedObjectTreeRequest);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS: {
      ITaggedObjectSearchParams taggedObjectSearchParams = (ITaggedObjectSearchParams) theEObject;
      T result = caseTaggedObjectSearchParams(taggedObjectSearchParams);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAG_DELETION_CHECK_RESULT: {
      ITagDeletionCheckResult tagDeletionCheckResult = (ITagDeletionCheckResult) theEObject;
      T result = caseTagDeletionCheckResult(tagDeletionCheckResult);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT: {
      ITagDeletionCheckObject tagDeletionCheckObject = (ITagDeletionCheckObject) theEObject;
      T result = caseTagDeletionCheckObject(tagDeletionCheckObject);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT: {
      ITaggedObjectTreeObject taggedObjectTreeObject = (ITaggedObjectTreeObject) theEObject;
      T result = caseTaggedObjectTreeObject(taggedObjectTreeObject);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT: {
      ITaggedObjectTreeResult taggedObjectTreeResult = (ITaggedObjectTreeResult) theEObject;
      T result = caseTaggedObjectTreeResult(taggedObjectTreeResult);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST: {
      ITaggedObjectListRequest taggedObjectListRequest = (ITaggedObjectListRequest) theEObject;
      T result = caseTaggedObjectListRequest(taggedObjectListRequest);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAGGED_OBJECT_INFO: {
      ITaggedObjectInfo taggedObjectInfo = (ITaggedObjectInfo) theEObject;
      T result = caseTaggedObjectInfo(taggedObjectInfo);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAGGED_OBJECT_INFO_LIST: {
      ITaggedObjectInfoList taggedObjectInfoList = (ITaggedObjectInfoList) theEObject;
      T result = caseTaggedObjectInfoList(taggedObjectInfoList);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_REQUEST: {
      ITaggedObjectDeletionCheckRequest taggedObjectDeletionCheckRequest = (ITaggedObjectDeletionCheckRequest) theEObject;
      T result = caseTaggedObjectDeletionCheckRequest(taggedObjectDeletionCheckRequest);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_RESULT: {
      ITaggedObjectDeletionCheckResult taggedObjectDeletionCheckResult = (ITaggedObjectDeletionCheckResult) theEObject;
      T result = caseTaggedObjectDeletionCheckResult(taggedObjectDeletionCheckResult);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT: {
      ITaggedObjectDeletionCheckObject taggedObjectDeletionCheckObject = (ITaggedObjectDeletionCheckObject) theEObject;
      T result = caseTaggedObjectDeletionCheckObject(taggedObjectDeletionCheckObject);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case IAbapTagsPackage.TAGGED_OBJECT_DELETE_REQUEST: {
      ITaggedObjectDeleteRequest taggedObjectDeleteRequest = (ITaggedObjectDeleteRequest) theEObject;
      T result = caseTaggedObjectDeleteRequest(taggedObjectDeleteRequest);
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tag Base</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tag Base</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTagBase(final ITagBase object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tag</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tag</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTag(final ITag object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Adt Object Tag</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Adt Object Tag</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdtObjectTag(final IAdtObjectTag object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tag List</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tag List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTagList(final ITagList object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tag Preview Info</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tag Preview Info</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTagPreviewInfo(final ITagPreviewInfo object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Object</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedObject(final ITaggedObject object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Object List</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch. <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Object List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedObjectList(final ITaggedObjectList object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Object Tree
   * Request</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Object Tree
   *         Request</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedObjectTreeRequest(final ITaggedObjectTreeRequest object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Object Search
   * Params</em>'.
   * <!-- begin-user-doc --> This implementation
   * returns null; returning a non-null result will terminate the switch. <!--
   * end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Object Search
   *         Params</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedObjectSearchParams(final ITaggedObjectSearchParams object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tag Deletion Check
   * Result</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tag Deletion Check
   *         Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTagDeletionCheckResult(final ITagDeletionCheckResult object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tag Deletion Check
   * Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tag Deletion Check
   *         Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTagDeletionCheckObject(final ITagDeletionCheckObject object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Object Tree
   * Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Object Tree
   *         Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedObjectTreeObject(final ITaggedObjectTreeObject object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Object Tree
   * Result</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Object Tree
   *         Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedObjectTreeResult(final ITaggedObjectTreeResult object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Object List
   * Request</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Object List
   *         Request</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedObjectListRequest(final ITaggedObjectListRequest object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Object Info</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Object Info</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedObjectInfo(final ITaggedObjectInfo object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Object Info
   * List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Object Info
   *         List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedObjectInfoList(final ITaggedObjectInfoList object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Object Deletion
   * Check Request</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Object Deletion
   *         Check Request</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedObjectDeletionCheckRequest(final ITaggedObjectDeletionCheckRequest object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Object Deletion
   * Check Result</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Object Deletion
   *         Check Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedObjectDeletionCheckResult(final ITaggedObjectDeletionCheckResult object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Object Deletion
   * Check Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Object Deletion
   *         Check Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedObjectDeletionCheckObject(final ITaggedObjectDeletionCheckObject object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Object Delete
   * Request</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Object Delete
   *         Request</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedObjectDeleteRequest(final ITaggedObjectDeleteRequest object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc --> This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last
   * case anyway. <!-- end-user-doc -->
   *
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(final EObject object) {
    return null;
  }

} // AbapTagsSwitch
