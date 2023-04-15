/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
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
import com.devepos.adt.atm.model.abaptags.ResultGroupLevel;
import com.devepos.adt.atm.model.abaptags.TagInfoType;
import com.devepos.adt.atm.model.abaptags.TagQueryFocus;
import com.devepos.adt.atm.model.abaptags.TagQueryType;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.model.abaptags.TagType;
import com.devepos.adt.base.model.adtbase.IAdtBasePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class AbapTagsPackage extends EPackageImpl implements IAbapTagsPackage {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass tagBaseEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass tagEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass adtObjectTagEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass tagListEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass tagPreviewInfoEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass taggedObjectEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass taggedObjectListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass taggedObjectTreeRequestEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass taggedObjectSearchParamsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass tagDeletionCheckResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass tagDeletionCheckObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass taggedObjectTreeObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass taggedObjectTreeResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass taggedObjectListRequestEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass taggedObjectInfoEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass taggedObjectInfoListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass taggedObjectDeletionCheckRequestEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass taggedObjectDeletionCheckResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass taggedObjectDeletionCheckObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass taggedObjectDeleteRequestEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum tagSearchScopeEEnum = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum tagQueryTypeEEnum = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum tagInfoTypeEEnum = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum tagQueryFocusEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum resultGroupLevelEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum tagTypeEEnum = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EDataType imageEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>
   * Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private AbapTagsPackage() {
    super(eNS_URI, IAbapTagsFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon
   * which it depends.
   *
   * <p>
   * This method is used to initialize {@link IAbapTagsPackage#eINSTANCE} when that field is
   * accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain
   * the package.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static IAbapTagsPackage init() {
    if (isInited) {
      return (IAbapTagsPackage) EPackage.Registry.INSTANCE.getEPackage(IAbapTagsPackage.eNS_URI);
    }

    // Obtain or create and register package
    Object registeredAbapTagsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    AbapTagsPackage theAbapTagsPackage = registeredAbapTagsPackage instanceof AbapTagsPackage
        ? (AbapTagsPackage) registeredAbapTagsPackage
        : new AbapTagsPackage();

    isInited = true;

    // Initialize simple dependencies
    IAdtBasePackage.eINSTANCE.eClass();
    XMLTypePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theAbapTagsPackage.createPackageContents();

    // Initialize created meta-data
    theAbapTagsPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theAbapTagsPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(IAbapTagsPackage.eNS_URI, theAbapTagsPackage);
    return theAbapTagsPackage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTagBase() {
    return tagBaseEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTagBase_Id() {
    return (EAttribute) tagBaseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTagBase_Name() {
    return (EAttribute) tagBaseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTagBase_Owner() {
    return (EAttribute) tagBaseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTag() {
    return tagEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTag_Description() {
    return (EAttribute) tagEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTag_ChildTags() {
    return (EReference) tagEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTag_CreatedBy() {
    return (EAttribute) tagEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTag_CreatedDateTime() {
    return (EAttribute) tagEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTag_ChangedBy() {
    return (EAttribute) tagEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTag_ChangedDateTime() {
    return (EAttribute) tagEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTag_TaggedObjectCount() {
    return (EAttribute) tagEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTag_Shared() {
    return (EAttribute) tagEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTag_SharedForMe() {
    return (EAttribute) tagEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTag_Changed() {
    return (EAttribute) tagEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTag_ParentTagId() {
    return (EAttribute) tagEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTag_SharedUsers() {
    return (EReference) tagEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getAdtObjectTag() {
    return adtObjectTagEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjectTag_ParentObjectName() {
    return (EAttribute) adtObjectTagEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjectTag_ParentObjectType() {
    return (EAttribute) adtObjectTagEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjectTag_ParentObjectUri() {
    return (EAttribute) adtObjectTagEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjectTag_ParentTagId() {
    return (EAttribute) adtObjectTagEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjectTag_ParentTagName() {
    return (EAttribute) adtObjectTagEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjectTag_Image() {
    return (EAttribute) adtObjectTagEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getAdtObjectTag_PossibleParentTags() {
    return (EAttribute) adtObjectTagEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getAdtObjectTag_CorrectParentTag() {
    return (EReference) adtObjectTagEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTagList() {
    return tagListEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTagList_Tags() {
    return (EReference) tagListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTagPreviewInfo() {
    return tagPreviewInfoEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTagPreviewInfo_Tags() {
    return (EReference) tagPreviewInfoEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTagPreviewInfo_AdtObjectRefs() {
    return (EReference) tagPreviewInfoEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTaggedObject() {
    return taggedObjectEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTaggedObject_ObjectRef() {
    return (EReference) taggedObjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTaggedObject_Tags() {
    return (EReference) taggedObjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTaggedObjectList() {
    return taggedObjectListEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTaggedObjectList_TaggedObjects() {
    return (EReference) taggedObjectListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTaggedObjectTreeRequest() {
    return taggedObjectTreeRequestEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectTreeRequest_TagId() {
    return (EAttribute) taggedObjectTreeRequestEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectTreeRequest_ParentObjectName() {
    return (EAttribute) taggedObjectTreeRequestEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectTreeRequest_ParentObjectType() {
    return (EAttribute) taggedObjectTreeRequestEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTaggedObjectSearchParams() {
    return taggedObjectSearchParamsEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectSearchParams_TagIds() {
    return (EAttribute) taggedObjectSearchParamsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectSearchParams_SearchScope() {
    return (EAttribute) taggedObjectSearchParamsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectSearchParams_Query() {
    return (EAttribute) taggedObjectSearchParamsEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectSearchParams_QueryType() {
    return (EAttribute) taggedObjectSearchParamsEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectSearchParams_ResultGroupLevel() {
    return (EAttribute) taggedObjectSearchParamsEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectSearchParams_QueryFocus() {
    return (EAttribute) taggedObjectSearchParamsEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectSearchParams_MaxResults() {
    return (EAttribute) taggedObjectSearchParamsEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectSearchParams_MatchesAllTags() {
    return (EAttribute) taggedObjectSearchParamsEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectSearchParams_WithTagInfo() {
    return (EAttribute) taggedObjectSearchParamsEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectSearchParams_TagInfoType() {
    return (EAttribute) taggedObjectSearchParamsEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectSearchParams_ExcludeComponents() {
    return (EAttribute) taggedObjectSearchParamsEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTagDeletionCheckResult() {
    return tagDeletionCheckResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTagDeletionCheckResult_CheckedTags() {
    return (EReference) tagDeletionCheckResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTagDeletionCheckObject() {
    return tagDeletionCheckObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTagDeletionCheckObject_TagId() {
    return (EAttribute) tagDeletionCheckObjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTagDeletionCheckObject_Deletable() {
    return (EAttribute) tagDeletionCheckObjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTagDeletionCheckObject_Message() {
    return (EAttribute) tagDeletionCheckObjectEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTagDeletionCheckObject_MessageType() {
    return (EAttribute) tagDeletionCheckObjectEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTaggedObjectTreeObject() {
    return taggedObjectTreeObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTaggedObjectTreeObject_ObjectRef() {
    return (EReference) taggedObjectTreeObjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectTreeObject_TaggedObjectCount() {
    return (EAttribute) taggedObjectTreeObjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectTreeObject_ParentTagId() {
    return (EAttribute) taggedObjectTreeObjectEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectTreeObject_Expandable() {
    return (EAttribute) taggedObjectTreeObjectEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTaggedObjectTreeResult() {
    return taggedObjectTreeResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectTreeResult_TaggedObjectCount() {
    return (EAttribute) taggedObjectTreeResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTaggedObjectTreeResult_Objects() {
    return (EReference) taggedObjectTreeResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTaggedObjectTreeResult_Tags() {
    return (EReference) taggedObjectTreeResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTaggedObjectListRequest() {
    return taggedObjectListRequestEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectListRequest_TagIds() {
    return (EAttribute) taggedObjectListRequestEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectListRequest_TaggedObjectIds() {
    return (EAttribute) taggedObjectListRequestEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTaggedObjectListRequest_TaggedObjectInfos() {
    return (EReference) taggedObjectListRequestEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectListRequest_LoadChildObjects() {
    return (EAttribute) taggedObjectListRequestEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTaggedObjectInfo() {
    return taggedObjectInfoEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectInfo_Id() {
    return (EAttribute) taggedObjectInfoEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectInfo_TagId() {
    return (EAttribute) taggedObjectInfoEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectInfo_TagName() {
    return (EAttribute) taggedObjectInfoEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectInfo_TagType() {
    return (EAttribute) taggedObjectInfoEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectInfo_ObjectName() {
    return (EAttribute) taggedObjectInfoEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectInfo_ObjectType() {
    return (EAttribute) taggedObjectInfoEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectInfo_ComponentName() {
    return (EAttribute) taggedObjectInfoEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectInfo_ComponentType() {
    return (EAttribute) taggedObjectInfoEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectInfo_ParentTagId() {
    return (EAttribute) taggedObjectInfoEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectInfo_ParentTagName() {
    return (EAttribute) taggedObjectInfoEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectInfo_ParentObjectName() {
    return (EAttribute) taggedObjectInfoEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectInfo_ParentObjectType() {
    return (EAttribute) taggedObjectInfoEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTaggedObjectInfoList() {
    return taggedObjectInfoListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTaggedObjectInfoList_TaggedObjectInfos() {
    return (EReference) taggedObjectInfoListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTaggedObjectDeletionCheckRequest() {
    return taggedObjectDeletionCheckRequestEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectDeletionCheckRequest_TaggedObjectIds() {
    return (EAttribute) taggedObjectDeletionCheckRequestEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTaggedObjectDeletionCheckResult() {
    return taggedObjectDeletionCheckResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getTaggedObjectDeletionCheckResult_CheckedObjects() {
    return (EReference) taggedObjectDeletionCheckResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTaggedObjectDeletionCheckObject() {
    return taggedObjectDeletionCheckObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectDeletionCheckObject_TaggedObjectId() {
    return (EAttribute) taggedObjectDeletionCheckObjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectDeletionCheckObject_Deletable() {
    return (EAttribute) taggedObjectDeletionCheckObjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectDeletionCheckObject_Message() {
    return (EAttribute) taggedObjectDeletionCheckObjectEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectDeletionCheckObject_MessageType() {
    return (EAttribute) taggedObjectDeletionCheckObjectEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectDeletionCheckObject_DependentObjectIds() {
    return (EAttribute) taggedObjectDeletionCheckObjectEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTaggedObjectDeleteRequest() {
    return taggedObjectDeleteRequestEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTaggedObjectDeleteRequest_ObjectId() {
    return (EAttribute) taggedObjectDeleteRequestEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getTagSearchScope() {
    return tagSearchScopeEEnum;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getTagQueryType() {
    return tagQueryTypeEEnum;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getTagInfoType() {
    return tagInfoTypeEEnum;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getTagQueryFocus() {
    return tagQueryFocusEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getResultGroupLevel() {
    return resultGroupLevelEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getTagType() {
    return tagTypeEEnum;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EDataType getImage() {
    return imageEDataType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IAbapTagsFactory getAbapTagsFactory() {
    return (IAbapTagsFactory) getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package. This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) {
      return;
    }
    isCreated = true;

    // Create classes and their features
    tagBaseEClass = createEClass(TAG_BASE);
    createEAttribute(tagBaseEClass, TAG_BASE__ID);
    createEAttribute(tagBaseEClass, TAG_BASE__NAME);
    createEAttribute(tagBaseEClass, TAG_BASE__OWNER);

    tagEClass = createEClass(TAG);
    createEAttribute(tagEClass, TAG__DESCRIPTION);
    createEReference(tagEClass, TAG__CHILD_TAGS);
    createEAttribute(tagEClass, TAG__CREATED_BY);
    createEAttribute(tagEClass, TAG__CREATED_DATE_TIME);
    createEAttribute(tagEClass, TAG__CHANGED_BY);
    createEAttribute(tagEClass, TAG__CHANGED_DATE_TIME);
    createEAttribute(tagEClass, TAG__TAGGED_OBJECT_COUNT);
    createEAttribute(tagEClass, TAG__SHARED);
    createEAttribute(tagEClass, TAG__SHARED_FOR_ME);
    createEAttribute(tagEClass, TAG__CHANGED);
    createEAttribute(tagEClass, TAG__PARENT_TAG_ID);
    createEReference(tagEClass, TAG__SHARED_USERS);

    tagListEClass = createEClass(TAG_LIST);
    createEReference(tagListEClass, TAG_LIST__TAGS);

    adtObjectTagEClass = createEClass(ADT_OBJECT_TAG);
    createEAttribute(adtObjectTagEClass, ADT_OBJECT_TAG__PARENT_OBJECT_NAME);
    createEAttribute(adtObjectTagEClass, ADT_OBJECT_TAG__PARENT_OBJECT_TYPE);
    createEAttribute(adtObjectTagEClass, ADT_OBJECT_TAG__PARENT_OBJECT_URI);
    createEAttribute(adtObjectTagEClass, ADT_OBJECT_TAG__PARENT_TAG_ID);
    createEAttribute(adtObjectTagEClass, ADT_OBJECT_TAG__PARENT_TAG_NAME);
    createEAttribute(adtObjectTagEClass, ADT_OBJECT_TAG__IMAGE);
    createEAttribute(adtObjectTagEClass, ADT_OBJECT_TAG__POSSIBLE_PARENT_TAGS);
    createEReference(adtObjectTagEClass, ADT_OBJECT_TAG__CORRECT_PARENT_TAG);

    tagPreviewInfoEClass = createEClass(TAG_PREVIEW_INFO);
    createEReference(tagPreviewInfoEClass, TAG_PREVIEW_INFO__TAGS);
    createEReference(tagPreviewInfoEClass, TAG_PREVIEW_INFO__ADT_OBJECT_REFS);

    taggedObjectEClass = createEClass(TAGGED_OBJECT);
    createEReference(taggedObjectEClass, TAGGED_OBJECT__OBJECT_REF);
    createEReference(taggedObjectEClass, TAGGED_OBJECT__TAGS);

    taggedObjectListEClass = createEClass(TAGGED_OBJECT_LIST);
    createEReference(taggedObjectListEClass, TAGGED_OBJECT_LIST__TAGGED_OBJECTS);

    taggedObjectTreeRequestEClass = createEClass(TAGGED_OBJECT_TREE_REQUEST);
    createEAttribute(taggedObjectTreeRequestEClass, TAGGED_OBJECT_TREE_REQUEST__TAG_ID);
    createEAttribute(taggedObjectTreeRequestEClass, TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_NAME);
    createEAttribute(taggedObjectTreeRequestEClass, TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_TYPE);

    taggedObjectSearchParamsEClass = createEClass(TAGGED_OBJECT_SEARCH_PARAMS);
    createEAttribute(taggedObjectSearchParamsEClass, TAGGED_OBJECT_SEARCH_PARAMS__TAG_IDS);
    createEAttribute(taggedObjectSearchParamsEClass, TAGGED_OBJECT_SEARCH_PARAMS__SEARCH_SCOPE);
    createEAttribute(taggedObjectSearchParamsEClass, TAGGED_OBJECT_SEARCH_PARAMS__QUERY);
    createEAttribute(taggedObjectSearchParamsEClass, TAGGED_OBJECT_SEARCH_PARAMS__QUERY_TYPE);
    createEAttribute(taggedObjectSearchParamsEClass,
        TAGGED_OBJECT_SEARCH_PARAMS__RESULT_GROUP_LEVEL);
    createEAttribute(taggedObjectSearchParamsEClass, TAGGED_OBJECT_SEARCH_PARAMS__QUERY_FOCUS);
    createEAttribute(taggedObjectSearchParamsEClass, TAGGED_OBJECT_SEARCH_PARAMS__MAX_RESULTS);
    createEAttribute(taggedObjectSearchParamsEClass, TAGGED_OBJECT_SEARCH_PARAMS__MATCHES_ALL_TAGS);
    createEAttribute(taggedObjectSearchParamsEClass, TAGGED_OBJECT_SEARCH_PARAMS__WITH_TAG_INFO);
    createEAttribute(taggedObjectSearchParamsEClass, TAGGED_OBJECT_SEARCH_PARAMS__TAG_INFO_TYPE);
    createEAttribute(taggedObjectSearchParamsEClass,
        TAGGED_OBJECT_SEARCH_PARAMS__EXCLUDE_COMPONENTS);

    tagDeletionCheckResultEClass = createEClass(TAG_DELETION_CHECK_RESULT);
    createEReference(tagDeletionCheckResultEClass, TAG_DELETION_CHECK_RESULT__CHECKED_TAGS);

    tagDeletionCheckObjectEClass = createEClass(TAG_DELETION_CHECK_OBJECT);
    createEAttribute(tagDeletionCheckObjectEClass, TAG_DELETION_CHECK_OBJECT__TAG_ID);
    createEAttribute(tagDeletionCheckObjectEClass, TAG_DELETION_CHECK_OBJECT__DELETABLE);
    createEAttribute(tagDeletionCheckObjectEClass, TAG_DELETION_CHECK_OBJECT__MESSAGE);
    createEAttribute(tagDeletionCheckObjectEClass, TAG_DELETION_CHECK_OBJECT__MESSAGE_TYPE);

    taggedObjectTreeObjectEClass = createEClass(TAGGED_OBJECT_TREE_OBJECT);
    createEReference(taggedObjectTreeObjectEClass, TAGGED_OBJECT_TREE_OBJECT__OBJECT_REF);
    createEAttribute(taggedObjectTreeObjectEClass, TAGGED_OBJECT_TREE_OBJECT__TAGGED_OBJECT_COUNT);
    createEAttribute(taggedObjectTreeObjectEClass, TAGGED_OBJECT_TREE_OBJECT__PARENT_TAG_ID);
    createEAttribute(taggedObjectTreeObjectEClass, TAGGED_OBJECT_TREE_OBJECT__EXPANDABLE);

    taggedObjectTreeResultEClass = createEClass(TAGGED_OBJECT_TREE_RESULT);
    createEAttribute(taggedObjectTreeResultEClass, TAGGED_OBJECT_TREE_RESULT__TAGGED_OBJECT_COUNT);
    createEReference(taggedObjectTreeResultEClass, TAGGED_OBJECT_TREE_RESULT__OBJECTS);
    createEReference(taggedObjectTreeResultEClass, TAGGED_OBJECT_TREE_RESULT__TAGS);

    taggedObjectListRequestEClass = createEClass(TAGGED_OBJECT_LIST_REQUEST);
    createEAttribute(taggedObjectListRequestEClass, TAGGED_OBJECT_LIST_REQUEST__TAG_IDS);
    createEAttribute(taggedObjectListRequestEClass, TAGGED_OBJECT_LIST_REQUEST__TAGGED_OBJECT_IDS);
    createEReference(taggedObjectListRequestEClass,
        TAGGED_OBJECT_LIST_REQUEST__TAGGED_OBJECT_INFOS);
    createEAttribute(taggedObjectListRequestEClass, TAGGED_OBJECT_LIST_REQUEST__LOAD_CHILD_OBJECTS);

    taggedObjectInfoEClass = createEClass(TAGGED_OBJECT_INFO);
    createEAttribute(taggedObjectInfoEClass, TAGGED_OBJECT_INFO__ID);
    createEAttribute(taggedObjectInfoEClass, TAGGED_OBJECT_INFO__TAG_ID);
    createEAttribute(taggedObjectInfoEClass, TAGGED_OBJECT_INFO__TAG_NAME);
    createEAttribute(taggedObjectInfoEClass, TAGGED_OBJECT_INFO__TAG_TYPE);
    createEAttribute(taggedObjectInfoEClass, TAGGED_OBJECT_INFO__OBJECT_NAME);
    createEAttribute(taggedObjectInfoEClass, TAGGED_OBJECT_INFO__OBJECT_TYPE);
    createEAttribute(taggedObjectInfoEClass, TAGGED_OBJECT_INFO__COMPONENT_NAME);
    createEAttribute(taggedObjectInfoEClass, TAGGED_OBJECT_INFO__COMPONENT_TYPE);
    createEAttribute(taggedObjectInfoEClass, TAGGED_OBJECT_INFO__PARENT_TAG_ID);
    createEAttribute(taggedObjectInfoEClass, TAGGED_OBJECT_INFO__PARENT_TAG_NAME);
    createEAttribute(taggedObjectInfoEClass, TAGGED_OBJECT_INFO__PARENT_OBJECT_NAME);
    createEAttribute(taggedObjectInfoEClass, TAGGED_OBJECT_INFO__PARENT_OBJECT_TYPE);

    taggedObjectInfoListEClass = createEClass(TAGGED_OBJECT_INFO_LIST);
    createEReference(taggedObjectInfoListEClass, TAGGED_OBJECT_INFO_LIST__TAGGED_OBJECT_INFOS);

    taggedObjectDeletionCheckRequestEClass = createEClass(TAGGED_OBJECT_DELETION_CHECK_REQUEST);
    createEAttribute(taggedObjectDeletionCheckRequestEClass,
        TAGGED_OBJECT_DELETION_CHECK_REQUEST__TAGGED_OBJECT_IDS);

    taggedObjectDeletionCheckResultEClass = createEClass(TAGGED_OBJECT_DELETION_CHECK_RESULT);
    createEReference(taggedObjectDeletionCheckResultEClass,
        TAGGED_OBJECT_DELETION_CHECK_RESULT__CHECKED_OBJECTS);

    taggedObjectDeletionCheckObjectEClass = createEClass(TAGGED_OBJECT_DELETION_CHECK_OBJECT);
    createEAttribute(taggedObjectDeletionCheckObjectEClass,
        TAGGED_OBJECT_DELETION_CHECK_OBJECT__TAGGED_OBJECT_ID);
    createEAttribute(taggedObjectDeletionCheckObjectEClass,
        TAGGED_OBJECT_DELETION_CHECK_OBJECT__DELETABLE);
    createEAttribute(taggedObjectDeletionCheckObjectEClass,
        TAGGED_OBJECT_DELETION_CHECK_OBJECT__MESSAGE);
    createEAttribute(taggedObjectDeletionCheckObjectEClass,
        TAGGED_OBJECT_DELETION_CHECK_OBJECT__MESSAGE_TYPE);
    createEAttribute(taggedObjectDeletionCheckObjectEClass,
        TAGGED_OBJECT_DELETION_CHECK_OBJECT__DEPENDENT_OBJECT_IDS);

    taggedObjectDeleteRequestEClass = createEClass(TAGGED_OBJECT_DELETE_REQUEST);
    createEAttribute(taggedObjectDeleteRequestEClass, TAGGED_OBJECT_DELETE_REQUEST__OBJECT_ID);

    // Create enums
    tagSearchScopeEEnum = createEEnum(TAG_SEARCH_SCOPE);
    tagQueryTypeEEnum = createEEnum(TAG_QUERY_TYPE);
    tagInfoTypeEEnum = createEEnum(TAG_INFO_TYPE);
    tagQueryFocusEEnum = createEEnum(TAG_QUERY_FOCUS);
    resultGroupLevelEEnum = createEEnum(RESULT_GROUP_LEVEL);
    tagTypeEEnum = createEEnum(TAG_TYPE);

    // Create data types
    imageEDataType = createEDataType(IMAGE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model. This method is
   * guarded to have no affect on any invocation but its first. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) {
      return;
    }
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    IAdtBasePackage theAdtBasePackage = (IAdtBasePackage) EPackage.Registry.INSTANCE.getEPackage(
        IAdtBasePackage.eNS_URI);
    XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE.getEPackage(
        XMLTypePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    tagEClass.getESuperTypes().add(getTagBase());
    adtObjectTagEClass.getESuperTypes().add(getTagBase());

    // Initialize classes, features, and operations; add parameters
    initEClass(tagBaseEClass, ITagBase.class, "TagBase", IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTagBase_Id(), ecorePackage.getEString(), "id", null, 0, 1, ITagBase.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getTagBase_Name(), ecorePackage.getEString(), "name", "", 0, 1, ITagBase.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getTagBase_Owner(), ecorePackage.getEString(), "owner", "", 0, 1, ITagBase.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(tagEClass, ITag.class, "Tag", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTag_Description(), ecorePackage.getEString(), "description", "", 0, 1,
        ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
        !IS_DERIVED, IS_ORDERED);
    initEReference(getTag_ChildTags(), getTag(), null, "childTags", null, 0, -1, ITag.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
        !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTag_CreatedBy(), ecorePackage.getEString(), "createdBy", "", 0, 1, ITag.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getTag_CreatedDateTime(), ecorePackage.getEString(), "createdDateTime", "", 0, 1,
        ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
        !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTag_ChangedBy(), ecorePackage.getEString(), "changedBy", "", 0, 1, ITag.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getTag_ChangedDateTime(), ecorePackage.getEString(), "changedDateTime", "", 0, 1,
        ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
        !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTag_TaggedObjectCount(), ecorePackage.getEInt(), "taggedObjectCount", null, 0,
        1, ITag.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
        !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTag_Shared(), ecorePackage.getEBoolean(), "shared", null, 0, 1, ITag.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getTag_SharedForMe(), ecorePackage.getEBoolean(), "sharedForMe", null, 0, 1,
        ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
        !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTag_Changed(), ecorePackage.getEBoolean(), "changed", null, 0, 1, ITag.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getTag_ParentTagId(), ecorePackage.getEString(), "parentTagId", null, 0, 1,
        ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
        !IS_DERIVED, IS_ORDERED);
    initEReference(getTag_SharedUsers(), theAdtBasePackage.getUser(), null, "sharedUsers", null, 0,
        -1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tagListEClass, ITagList.class, "TagList", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTagList_Tags(), getTag(), null, "tags", null, 0, -1, ITagList.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
        !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(adtObjectTagEClass, IAdtObjectTag.class, "AdtObjectTag", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAdtObjectTag_ParentObjectName(), ecorePackage.getEString(),
        "parentObjectName", null, 0, 1, IAdtObjectTag.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtObjectTag_ParentObjectType(), ecorePackage.getEString(),
        "parentObjectType", null, 0, 1, IAdtObjectTag.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtObjectTag_ParentObjectUri(), ecorePackage.getEString(), "parentObjectUri",
        null, 0, 1, IAdtObjectTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtObjectTag_ParentTagId(), ecorePackage.getEString(), "parentTagId", null, 0,
        1, IAdtObjectTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtObjectTag_ParentTagName(), ecorePackage.getEString(), "parentTagName",
        null, 0, 1, IAdtObjectTag.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdtObjectTag_Image(), getImage(), "image", null, 0, 1, IAdtObjectTag.class,
        IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getAdtObjectTag_PossibleParentTags(), theXMLTypePackage.getString(),
        "possibleParentTags", null, 0, -1, IAdtObjectTag.class, IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAdtObjectTag_CorrectParentTag(), getTag(), null, "correctParentTag", null, 0,
        1, IAdtObjectTag.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
        IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tagPreviewInfoEClass, ITagPreviewInfo.class, "TagPreviewInfo", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTagPreviewInfo_Tags(), getTag(), null, "tags", null, 0, -1,
        ITagPreviewInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTagPreviewInfo_AdtObjectRefs(), theAdtBasePackage.getAdtObjRef(), null,
        "adtObjectRefs", null, 0, -1, ITagPreviewInfo.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(taggedObjectEClass, ITaggedObject.class, "TaggedObject", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTaggedObject_ObjectRef(), theAdtBasePackage.getAdtObjRef(), null, "objectRef",
        null, 0, 1, ITaggedObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTaggedObject_Tags(), getAdtObjectTag(), null, "tags", null, 0, -1,
        ITaggedObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(taggedObjectListEClass, ITaggedObjectList.class, "TaggedObjectList", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTaggedObjectList_TaggedObjects(), getTaggedObject(), null, "taggedObjects",
        null, 0, -1, ITaggedObjectList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(taggedObjectTreeRequestEClass, ITaggedObjectTreeRequest.class,
        "TaggedObjectTreeRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTaggedObjectTreeRequest_TagId(), ecorePackage.getEString(), "tagId", null, 0,
        1, ITaggedObjectTreeRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectTreeRequest_ParentObjectName(), ecorePackage.getEString(),
        "parentObjectName", null, 0, 1, ITaggedObjectTreeRequest.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectTreeRequest_ParentObjectType(), ecorePackage.getEString(),
        "parentObjectType", null, 0, 1, ITaggedObjectTreeRequest.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(taggedObjectSearchParamsEClass, ITaggedObjectSearchParams.class,
        "TaggedObjectSearchParams", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTaggedObjectSearchParams_TagIds(), ecorePackage.getEString(), "tagIds", null,
        0, -1, ITaggedObjectSearchParams.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectSearchParams_SearchScope(), getTagSearchScope(), "searchScope",
        null, 0, 1, ITaggedObjectSearchParams.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectSearchParams_Query(), ecorePackage.getEString(), "query", null, 0,
        1, ITaggedObjectSearchParams.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectSearchParams_QueryType(), getTagQueryType(), "queryType", null, 0,
        1, ITaggedObjectSearchParams.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectSearchParams_ResultGroupLevel(), getResultGroupLevel(),
        "resultGroupLevel", null, 0, 1, ITaggedObjectSearchParams.class, !IS_TRANSIENT,
        !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectSearchParams_QueryFocus(), getTagQueryFocus(), "queryFocus", null,
        0, 1, ITaggedObjectSearchParams.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectSearchParams_MaxResults(), ecorePackage.getEInt(), "maxResults",
        null, 0, 1, ITaggedObjectSearchParams.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectSearchParams_MatchesAllTags(), ecorePackage.getEBoolean(),
        "matchesAllTags", null, 0, 1, ITaggedObjectSearchParams.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectSearchParams_WithTagInfo(), ecorePackage.getEBoolean(),
        "withTagInfo", null, 0, 1, ITaggedObjectSearchParams.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectSearchParams_TagInfoType(), getTagInfoType(), "tagInfoType", null,
        0, 1, ITaggedObjectSearchParams.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectSearchParams_ExcludeComponents(), ecorePackage.getEBoolean(),
        "excludeComponents", null, 0, 1, ITaggedObjectSearchParams.class, !IS_TRANSIENT,
        !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tagDeletionCheckResultEClass, ITagDeletionCheckResult.class,
        "TagDeletionCheckResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTagDeletionCheckResult_CheckedTags(), getTagDeletionCheckObject(), null,
        "checkedTags", null, 0, -1, ITagDeletionCheckResult.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(tagDeletionCheckObjectEClass, ITagDeletionCheckObject.class,
        "TagDeletionCheckObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTagDeletionCheckObject_TagId(), ecorePackage.getEString(), "tagId", null, 0,
        1, ITagDeletionCheckObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTagDeletionCheckObject_Deletable(), theXMLTypePackage.getBoolean(),
        "deletable", null, 0, 1, ITagDeletionCheckObject.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTagDeletionCheckObject_Message(), ecorePackage.getEString(), "message", null,
        0, 1, ITagDeletionCheckObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTagDeletionCheckObject_MessageType(), theAdtBasePackage.getMessageType(),
        "messageType", null, 0, 1, ITagDeletionCheckObject.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(taggedObjectTreeObjectEClass, ITaggedObjectTreeObject.class,
        "TaggedObjectTreeObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTaggedObjectTreeObject_ObjectRef(), theAdtBasePackage.getAdtObjRef(), null,
        "objectRef", null, 0, 1, ITaggedObjectTreeObject.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getTaggedObjectTreeObject_TaggedObjectCount(), ecorePackage.getEInt(),
        "taggedObjectCount", null, 0, 1, ITaggedObjectTreeObject.class, IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectTreeObject_ParentTagId(), theXMLTypePackage.getString(),
        "parentTagId", null, 0, 1, ITaggedObjectTreeObject.class, IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectTreeObject_Expandable(), theXMLTypePackage.getBoolean(),
        "expandable", null, 0, 1, ITaggedObjectTreeObject.class, IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(taggedObjectTreeResultEClass, ITaggedObjectTreeResult.class,
        "TaggedObjectTreeResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTaggedObjectTreeResult_TaggedObjectCount(), ecorePackage.getEInt(),
        "taggedObjectCount", null, 0, 1, ITaggedObjectTreeResult.class, IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTaggedObjectTreeResult_Objects(), getTaggedObjectTreeObject(), null,
        "objects", null, 0, -1, ITaggedObjectTreeResult.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEReference(getTaggedObjectTreeResult_Tags(), getTag(), null, "tags", null, 0, -1,
        ITaggedObjectTreeResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(taggedObjectListRequestEClass, ITaggedObjectListRequest.class,
        "TaggedObjectListRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTaggedObjectListRequest_TagIds(), theXMLTypePackage.getString(), "tagIds",
        null, 0, -1, ITaggedObjectListRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectListRequest_TaggedObjectIds(), theXMLTypePackage.getString(),
        "taggedObjectIds", null, 0, -1, ITaggedObjectListRequest.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTaggedObjectListRequest_TaggedObjectInfos(), getTaggedObjectInfo(), null,
        "taggedObjectInfos", null, 0, -1, ITaggedObjectListRequest.class, !IS_TRANSIENT,
        !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
        !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectListRequest_LoadChildObjects(), theXMLTypePackage.getBoolean(),
        "loadChildObjects", null, 0, 1, ITaggedObjectListRequest.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(taggedObjectInfoEClass, ITaggedObjectInfo.class, "TaggedObjectInfo", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTaggedObjectInfo_Id(), ecorePackage.getEString(), "id", null, 0, 1,
        ITaggedObjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectInfo_TagId(), ecorePackage.getEString(), "tagId", null, 0, 1,
        ITaggedObjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectInfo_TagName(), theXMLTypePackage.getString(), "tagName", null, 0,
        1, ITaggedObjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectInfo_TagType(), getTagType(), "tagType", null, 0, 1,
        ITaggedObjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectInfo_ObjectName(), ecorePackage.getEString(), "objectName", null,
        0, 1, ITaggedObjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectInfo_ObjectType(), ecorePackage.getEString(), "objectType", null,
        0, 1, ITaggedObjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
        !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectInfo_ComponentName(), ecorePackage.getEString(), "componentName",
        null, 0, 1, ITaggedObjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectInfo_ComponentType(), ecorePackage.getEString(), "componentType",
        null, 0, 1, ITaggedObjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectInfo_ParentTagId(), ecorePackage.getEString(), "parentTagId",
        null, 0, 1, ITaggedObjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectInfo_ParentTagName(), ecorePackage.getEString(), "parentTagName",
        null, 0, 1, ITaggedObjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectInfo_ParentObjectName(), ecorePackage.getEString(),
        "parentObjectName", null, 0, 1, ITaggedObjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectInfo_ParentObjectType(), ecorePackage.getEString(),
        "parentObjectType", null, 0, 1, ITaggedObjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(taggedObjectInfoListEClass, ITaggedObjectInfoList.class, "TaggedObjectInfoList",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTaggedObjectInfoList_TaggedObjectInfos(), getTaggedObjectInfo(), null,
        "taggedObjectInfos", null, 0, -1, ITaggedObjectInfoList.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(taggedObjectDeletionCheckRequestEClass, ITaggedObjectDeletionCheckRequest.class,
        "TaggedObjectDeletionCheckRequest", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTaggedObjectDeletionCheckRequest_TaggedObjectIds(), theXMLTypePackage
        .getString(), "taggedObjectIds", null, 0, -1, ITaggedObjectDeletionCheckRequest.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(taggedObjectDeletionCheckResultEClass, ITaggedObjectDeletionCheckResult.class,
        "TaggedObjectDeletionCheckResult", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTaggedObjectDeletionCheckResult_CheckedObjects(),
        getTaggedObjectDeletionCheckObject(), null, "checkedObjects", null, 0, -1,
        ITaggedObjectDeletionCheckResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
        IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(taggedObjectDeletionCheckObjectEClass, ITaggedObjectDeletionCheckObject.class,
        "TaggedObjectDeletionCheckObject", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTaggedObjectDeletionCheckObject_TaggedObjectId(), ecorePackage.getEString(),
        "taggedObjectId", null, 0, 1, ITaggedObjectDeletionCheckObject.class, !IS_TRANSIENT,
        !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectDeletionCheckObject_Deletable(), theXMLTypePackage.getBoolean(),
        "deletable", null, 0, 1, ITaggedObjectDeletionCheckObject.class, !IS_TRANSIENT,
        !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectDeletionCheckObject_Message(), ecorePackage.getEString(),
        "message", null, 0, 1, ITaggedObjectDeletionCheckObject.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTaggedObjectDeletionCheckObject_MessageType(), theAdtBasePackage
        .getMessageType(), "messageType", null, 0, 1, ITaggedObjectDeletionCheckObject.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getTaggedObjectDeletionCheckObject_DependentObjectIds(), theXMLTypePackage
        .getString(), "dependentObjectIds", null, 0, -1, ITaggedObjectDeletionCheckObject.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(taggedObjectDeleteRequestEClass, ITaggedObjectDeleteRequest.class,
        "TaggedObjectDeleteRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTaggedObjectDeleteRequest_ObjectId(), theXMLTypePackage.getString(),
        "objectId", null, 0, -1, ITaggedObjectDeleteRequest.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(tagSearchScopeEEnum, TagSearchScope.class, "TagSearchScope");
    addEEnumLiteral(tagSearchScopeEEnum, TagSearchScope.ALL);
    addEEnumLiteral(tagSearchScopeEEnum, TagSearchScope.GLOBAL);
    addEEnumLiteral(tagSearchScopeEEnum, TagSearchScope.USER);
    addEEnumLiteral(tagSearchScopeEEnum, TagSearchScope.SHARED);

    initEEnum(tagQueryTypeEEnum, TagQueryType.class, "TagQueryType");
    addEEnumLiteral(tagQueryTypeEEnum, TagQueryType.OBJECT_NAME);
    addEEnumLiteral(tagQueryTypeEEnum, TagQueryType.OBJECT_URI);
    addEEnumLiteral(tagQueryTypeEEnum, TagQueryType.OBJECT_NAME_TYPE_COMBO);

    initEEnum(tagInfoTypeEEnum, TagInfoType.class, "TagInfoType");
    addEEnumLiteral(tagInfoTypeEEnum, TagInfoType.ALL);
    addEEnumLiteral(tagInfoTypeEEnum, TagInfoType.CHILDREN);
    addEEnumLiteral(tagInfoTypeEEnum, TagInfoType.SEARCH_FOCUS);

    initEEnum(tagQueryFocusEEnum, TagQueryFocus.class, "TagQueryFocus");
    addEEnumLiteral(tagQueryFocusEEnum, TagQueryFocus.OBJECT);
    addEEnumLiteral(tagQueryFocusEEnum, TagQueryFocus.PARENT_OBJECT);

    initEEnum(resultGroupLevelEEnum, ResultGroupLevel.class, "ResultGroupLevel");
    addEEnumLiteral(resultGroupLevelEEnum, ResultGroupLevel.BY_OBJECT);
    addEEnumLiteral(resultGroupLevelEEnum, ResultGroupLevel.BY_TAG_AND_OBJECT);

    initEEnum(tagTypeEEnum, TagType.class, "TagType");
    addEEnumLiteral(tagTypeEEnum, TagType.GLOBAL);
    addEEnumLiteral(tagTypeEEnum, TagType.USER);
    addEEnumLiteral(tagTypeEEnum, TagType.SHARED);

    // Initialize data types
    initEDataType(imageEDataType, Image.class, "Image", IS_SERIALIZABLE,
        !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

  /**
   * Initializes the annotations for
   * <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected void createExtendedMetaDataAnnotations() {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
    addAnnotation(tagBaseEClass, source, new String[] { "kind", "elementOnly", "name", "tagBase" });
    addAnnotation(getTagBase_Id(), source, new String[] { "kind", "attribute", "name", "id",
        "namespace", "##targetNamespace" });
    addAnnotation(getTagBase_Name(), source, new String[] { "kind", "attribute", "name", "name",
        "namespace", "##targetNamespace" });
    addAnnotation(getTagBase_Owner(), source, new String[] { "kind", "attribute", "name", "owner",
        "namespace", "##targetNamespace" });
    addAnnotation(tagEClass, source, new String[] { "kind", "elementOnly", "name", "tag" });
    addAnnotation(getTag_Description(), source, new String[] { "kind", "attribute", "name",
        "description", "namespace", "##targetNamespace" });
    addAnnotation(getTag_ChildTags(), source, new String[] { "kind", "element", "name", "tag",
        "namespace", "##targetNamespace" });
    addAnnotation(getTag_CreatedBy(), source, new String[] { "kind", "attribute", "name",
        "createdBy", "namespace", "##targetNamespace" });
    addAnnotation(getTag_CreatedDateTime(), source, new String[] { "kind", "attribute", "name",
        "createdDateTime", "namespace", "##targetNamespace" });
    addAnnotation(getTag_ChangedBy(), source, new String[] { "kind", "attribute", "name",
        "changedBy", "namespace", "##targetNamespace" });
    addAnnotation(getTag_ChangedDateTime(), source, new String[] { "kind", "attribute", "name",
        "changedDateTime", "namespace", "##targetNamespace" });
    addAnnotation(getTag_TaggedObjectCount(), source, new String[] { "kind", "attribute", "name",
        "taggedObjectCount", "namespace", "##targetNamespace" });
    addAnnotation(getTag_Shared(), source, new String[] { "kind", "attribute", "name", "shared",
        "namespace", "##targetNamespace" });
    addAnnotation(getTag_SharedForMe(), source, new String[] { "kind", "attribute", "name",
        "sharedForMe", "namespace", "##targetNamespace" });
    addAnnotation(getTag_Changed(), source, new String[] { "kind", "attribute", "name", "changed",
        "namespace", "##targetNamespace" });
    addAnnotation(getTag_ParentTagId(), source, new String[] { "kind", "attribute", "name",
        "parentTagId", "namespace", "##targetNamespace" });
    addAnnotation(getTag_SharedUsers(), source, new String[] { "kind", "element", "name", "user",
        "namespace", "http://www.devepos.com/adt/base" });
    addAnnotation(tagListEClass, source, new String[] { "kind", "elementOnly", "name", "tags" });
    addAnnotation(getTagList_Tags(), source, new String[] { "kind", "element", "name", "tag",
        "namespace", "##targetNamespace" });
    addAnnotation(adtObjectTagEClass, source, new String[] { "kind", "elementOnly", "name",
        "adtObjectTag" });
    addAnnotation(getAdtObjectTag_ParentObjectName(), source, new String[] { "kind", "attribute",
        "name", "parentObjectName", "namespace", "##targetNamespace" });
    addAnnotation(getAdtObjectTag_ParentObjectType(), source, new String[] { "kind", "attribute",
        "name", "parentObjectType", "namespace", "##targetNamespace" });
    addAnnotation(getAdtObjectTag_ParentObjectUri(), source, new String[] { "kind", "attribute",
        "name", "parentObjectUri", "namespace", "##targetNamespace" });
    addAnnotation(getAdtObjectTag_ParentTagId(), source, new String[] { "kind", "attribute", "name",
        "parentTagId", "namespace", "##targetNamespace" });
    addAnnotation(tagPreviewInfoEClass, source, new String[] { "kind", "elementOnly", "name",
        "tagPreviewInfo" });
    addAnnotation(getTagPreviewInfo_Tags(), source, new String[] { "kind", "element", "name", "tag",
        "namespace", "##targetNamespace" });
    addAnnotation(getTagPreviewInfo_AdtObjectRefs(), source, new String[] { "kind", "element",
        "name", "adtObjRef", "namespace", "http://www.devepos.com/adt/base" });
    addAnnotation(taggedObjectEClass, source, new String[] { "kind", "elementOnly", "name",
        "taggedObject" });
    addAnnotation(getTaggedObject_ObjectRef(), source, new String[] { "kind", "element", "name",
        "adtObjRef", "namespace", "http://www.devepos.com/adt/base" });
    addAnnotation(getTaggedObject_Tags(), source, new String[] { "kind", "element", "name",
        "adtObjectTag", "namespace", "##targetNamespace" });
    addAnnotation(taggedObjectListEClass, source, new String[] { "kind", "elementOnly", "name",
        "taggedObjects" });
    addAnnotation(getTaggedObjectList_TaggedObjects(), source, new String[] { "kind", "element",
        "name", "taggedObject", "namespace", "##targetNamespace" });
    addAnnotation(taggedObjectTreeRequestEClass, source, new String[] { "kind", "elementOnly",
        "name", "taggedObjectTreeRequest" });
    addAnnotation(getTaggedObjectTreeRequest_TagId(), source, new String[] { "name", "tagId",
        "namespace", "##targetNamespace", "kind", "attribute" });
    addAnnotation(getTaggedObjectTreeRequest_ParentObjectName(), source, new String[] { "kind",
        "attribute", "name", "parentObjectName", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectTreeRequest_ParentObjectType(), source, new String[] { "kind",
        "attribute", "name", "parentObjectType", "namespace", "##targetNamespace" });
    addAnnotation(taggedObjectSearchParamsEClass, source, new String[] { "kind", "elementOnly",
        "name", "taggedObjectSearchParams" });
    addAnnotation(getTaggedObjectSearchParams_TagIds(), source, new String[] { "kind", "element",
        "name", "tagId", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectSearchParams_SearchScope(), source, new String[] { "kind",
        "attribute", "name", "searchScope", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectSearchParams_Query(), source, new String[] { "kind", "attribute",
        "name", "query", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectSearchParams_QueryType(), source, new String[] { "kind",
        "attribute", "name", "queryType", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectSearchParams_ResultGroupLevel(), source, new String[] { "kind",
        "attribute", "name", "resultGroupLevel", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectSearchParams_QueryFocus(), source, new String[] { "kind",
        "attribute", "name", "queryFocus", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectSearchParams_MaxResults(), source, new String[] { "kind",
        "attribute", "name", "maxResults", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectSearchParams_MatchesAllTags(), source, new String[] { "kind",
        "attribute", "name", "matchesAllTags", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectSearchParams_WithTagInfo(), source, new String[] { "kind",
        "attribute", "name", "withTagInfo", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectSearchParams_TagInfoType(), source, new String[] { "kind",
        "attribute", "name", "tagInfoType", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectSearchParams_ExcludeComponents(), source, new String[] { "kind",
        "attribute", "name", "excludeComponents", "namespace", "##targetNamespace" });
    addAnnotation(tagDeletionCheckResultEClass, source, new String[] { "kind", "elementOnly",
        "name", "deletionCheckResult" });
    addAnnotation(getTagDeletionCheckResult_CheckedTags(), source, new String[] { "kind", "element",
        "name", "checkedTag", "namespace", "##targetNamespace" });
    addAnnotation(tagDeletionCheckObjectEClass, source, new String[] { "kind", "elementOnly",
        "name", "checkedTag" });
    addAnnotation(getTagDeletionCheckObject_TagId(), source, new String[] { "name", "tagId",
        "namespace", "##targetNamespace", "kind", "attribute" });
    addAnnotation(getTagDeletionCheckObject_Deletable(), source, new String[] { "kind", "attribute",
        "name", "isDeletable", "namespace", "##targetNamespace" });
    addAnnotation(getTagDeletionCheckObject_Message(), source, new String[] { "kind", "attribute",
        "name", "message", "namespace", "##targetNamespace" });
    addAnnotation(getTagDeletionCheckObject_MessageType(), source, new String[] { "kind",
        "attribute", "name", "messageType", "namespace", "##targetNamespace" });
    addAnnotation(taggedObjectTreeObjectEClass, source, new String[] { "kind", "elementOnly",
        "name", "object" });
    addAnnotation(getTaggedObjectTreeObject_ObjectRef(), source, new String[] { "kind", "element",
        "name", "adtObjRef", "namespace", "http://www.devepos.com/adt/base" });
    addAnnotation(getTaggedObjectTreeObject_TaggedObjectCount(), source, new String[] { "kind",
        "attribute", "name", "taggedObjectCount", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectTreeObject_ParentTagId(), source, new String[] { "kind",
        "attribute", "name", "parentTagId", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectTreeObject_Expandable(), source, new String[] { "kind",
        "attribute", "name", "expandable", "namespace", "##targetNamespace" });
    addAnnotation(taggedObjectTreeResultEClass, source, new String[] { "kind", "elementOnly",
        "name", "tagTreeResult" });
    addAnnotation(getTaggedObjectTreeResult_TaggedObjectCount(), source, new String[] { "kind",
        "attribute", "name", "taggedObjectCount", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectTreeResult_Objects(), source, new String[] { "kind", "element",
        "name", "object", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectTreeResult_Tags(), source, new String[] { "kind", "element",
        "name", "tag", "namespace", "##targetNamespace" });
    addAnnotation(taggedObjectListRequestEClass, source, new String[] { "kind", "elementOnly",
        "name", "taggedObjectListRequest" });
    addAnnotation(getTaggedObjectListRequest_TagIds(), source, new String[] { "kind", "element",
        "name", "tagId", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectListRequest_TaggedObjectIds(), source, new String[] { "kind",
        "element", "name", "taggedObjectId", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectListRequest_TaggedObjectInfos(), source, new String[] { "kind",
        "element", "name", "taggedObjectInfo", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectListRequest_LoadChildObjects(), source, new String[] { "kind",
        "attribute", "namespace", "##targetNamespace", "name", "loadChildObjects" });
    addAnnotation(taggedObjectInfoEClass, source, new String[] { "kind", "elementOnly", "name",
        "taggedObjectInfo" });
    addAnnotation(getTaggedObjectInfo_Id(), source, new String[] { "kind", "attribute", "name",
        "id", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectInfo_TagId(), source, new String[] { "kind", "attribute", "name",
        "tagId", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectInfo_TagName(), source, new String[] { "kind", "attribute", "name",
        "tagName", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectInfo_TagType(), source, new String[] { "kind", "attribute",
        "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectInfo_ObjectName(), source, new String[] { "kind", "attribute",
        "name", "objectName", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectInfo_ObjectType(), source, new String[] { "kind", "attribute",
        "name", "objectType", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectInfo_ComponentName(), source, new String[] { "kind", "attribute",
        "name", "componentName", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectInfo_ComponentType(), source, new String[] { "kind", "attribute",
        "name", "componentType", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectInfo_ParentTagId(), source, new String[] { "kind", "attribute",
        "name", "parentTagId", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectInfo_ParentTagName(), source, new String[] { "kind", "attribute",
        "name", "parentTagName", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectInfo_ParentObjectName(), source, new String[] { "kind",
        "attribute", "name", "parentObjectName", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectInfo_ParentObjectType(), source, new String[] { "kind",
        "attribute", "name", "parentObjectType", "namespace", "##targetNamespace" });
    addAnnotation(taggedObjectInfoListEClass, source, new String[] { "kind", "elementOnly", "name",
        "taggedObjectInfos" });
    addAnnotation(getTaggedObjectInfoList_TaggedObjectInfos(), source, new String[] { "kind",
        "element", "name", "taggedObjectInfo", "namespace", "##targetNamespace" });
    addAnnotation(taggedObjectDeletionCheckRequestEClass, source, new String[] { "kind",
        "elementOnly", "name", "taggedObjectDelCheckRequest" });
    addAnnotation(getTaggedObjectDeletionCheckRequest_TaggedObjectIds(), source, new String[] {
        "kind", "element", "namespace", "##targetNamespace", "name", "taggedObjectId" });
    addAnnotation(taggedObjectDeletionCheckResultEClass, source, new String[] { "kind",
        "elementOnly", "name", "taggedObjectDelCheckResult" });
    addAnnotation(getTaggedObjectDeletionCheckResult_CheckedObjects(), source, new String[] {
        "kind", "element", "namespace", "##targetNamespace", "name", "checkedObject" });
    addAnnotation(taggedObjectDeletionCheckObjectEClass, source, new String[] { "kind",
        "elementOnly", "name", "taggedObjectDeletionCheckObject" });
    addAnnotation(getTaggedObjectDeletionCheckObject_TaggedObjectId(), source, new String[] {
        "name", "taggedObjectId", "namespace", "##targetNamespace", "kind", "attribute" });
    addAnnotation(getTaggedObjectDeletionCheckObject_Deletable(), source, new String[] { "kind",
        "attribute", "name", "deletable", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectDeletionCheckObject_Message(), source, new String[] { "kind",
        "attribute", "name", "message", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectDeletionCheckObject_MessageType(), source, new String[] { "kind",
        "attribute", "name", "messageType", "namespace", "##targetNamespace" });
    addAnnotation(getTaggedObjectDeletionCheckObject_DependentObjectIds(), source, new String[] {
        "kind", "element", "name", "dependentObjectId", "namespace", "##targetNamespace" });
    addAnnotation(taggedObjectDeleteRequestEClass, source, new String[] { "kind", "elementOnly",
        "name", "taggedObjectDelRequest" });
    addAnnotation(getTaggedObjectDeleteRequest_ObjectId(), source, new String[] { "name",
        "taggedObjectId", "namespace", "##targetNamespace", "kind", "element" });
  }

} // AbapTagsPackage
