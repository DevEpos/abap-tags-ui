/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsFactory
 * @model kind="package"
 * @generated
 */
public interface IAbapTagsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "abaptags";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.devepos.com/adt/atm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "atm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IAbapTagsPackage eINSTANCE = com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage.init();

	/**
	 * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.TagBase <em>Tag Base</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.atm.model.abaptags.impl.TagBase
	 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagBase()
	 * @generated
	 */
	int TAG_BASE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_BASE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_BASE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_BASE__OWNER = 2;

	/**
	 * The number of structural features of the '<em>Tag Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_BASE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Tag Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_BASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.Tag <em>Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.atm.model.abaptags.impl.Tag
	 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTag()
	 * @generated
	 */
	int TAG = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__ID = TAG_BASE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__NAME = TAG_BASE__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__OWNER = TAG_BASE__OWNER;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__DESCRIPTION = TAG_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Child Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__CHILD_TAGS = TAG_BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__IS_ROOT = TAG_BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Created By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__CREATED_BY = TAG_BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Created Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__CREATED_DATE_TIME = TAG_BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Changed By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__CHANGED_BY = TAG_BASE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Changed Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__CHANGED_DATE_TIME = TAG_BASE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Tagged Object Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__TAGGED_OBJECT_COUNT = TAG_BASE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Changed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__CHANGED = TAG_BASE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Parent Tag Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__PARENT_TAG_ID = TAG_BASE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FEATURE_COUNT = TAG_BASE_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_OPERATION_COUNT = TAG_BASE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag <em>Adt Object Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag
	 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getAdtObjectTag()
	 * @generated
	 */
	int ADT_OBJECT_TAG = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADT_OBJECT_TAG__ID = TAG_BASE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADT_OBJECT_TAG__NAME = TAG_BASE__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADT_OBJECT_TAG__OWNER = TAG_BASE__OWNER;

	/**
	 * The feature id for the '<em><b>Parent Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADT_OBJECT_TAG__PARENT_OBJECT_NAME = TAG_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Object Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADT_OBJECT_TAG__PARENT_OBJECT_TYPE = TAG_BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent Object Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADT_OBJECT_TAG__PARENT_OBJECT_URI = TAG_BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent Tag Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADT_OBJECT_TAG__PARENT_TAG_ID = TAG_BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parent Tag Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADT_OBJECT_TAG__PARENT_TAG_NAME = TAG_BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>User Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADT_OBJECT_TAG__USER_TAG = TAG_BASE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Adt Object Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADT_OBJECT_TAG_FEATURE_COUNT = TAG_BASE_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Adt Object Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADT_OBJECT_TAG_OPERATION_COUNT = TAG_BASE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.TagList <em>Tag List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.atm.model.abaptags.impl.TagList
	 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagList()
	 * @generated
	 */
	int TAG_LIST = 3;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_LIST__TAGS = 0;

	/**
	 * The number of structural features of the '<em>Tag List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_LIST_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Tag List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_LIST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.TagPreviewInfo <em>Tag Preview Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.atm.model.abaptags.impl.TagPreviewInfo
	 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagPreviewInfo()
	 * @generated
	 */
	int TAG_PREVIEW_INFO = 4;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_PREVIEW_INFO__TAGS = 0;

	/**
	 * The feature id for the '<em><b>Adt Object Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_PREVIEW_INFO__ADT_OBJECT_REFS = 1;

	/**
	 * The number of structural features of the '<em>Tag Preview Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_PREVIEW_INFO_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Tag Preview Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_PREVIEW_INFO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObject <em>Tagged Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObject
	 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObject()
	 * @generated
	 */
	int TAGGED_OBJECT = 5;

	/**
	 * The feature id for the '<em><b>Object Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT__OBJECT_REF = 0;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT__TAGS = 1;

	/**
	 * The number of structural features of the '<em>Tagged Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Tagged Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectList <em>Tagged Object List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObjectList
	 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObjectList()
	 * @generated
	 */
	int TAGGED_OBJECT_LIST = 6;

	/**
	 * The feature id for the '<em><b>Tagged Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_LIST__TAGGED_OBJECTS = 0;

	/**
	 * The number of structural features of the '<em>Tagged Object List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_LIST_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Tagged Object List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_LIST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams <em>Tagged Object Search Params</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams
	 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObjectSearchParams()
	 * @generated
	 */
	int TAGGED_OBJECT_SEARCH_PARAMS = 7;

	/**
	 * The feature id for the '<em><b>Tag Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_SEARCH_PARAMS__TAG_IDS = 0;

	/**
	 * The feature id for the '<em><b>Search Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_SEARCH_PARAMS__SEARCH_SCOPE = 1;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_SEARCH_PARAMS__QUERY = 2;

	/**
	 * The feature id for the '<em><b>Max Results</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_SEARCH_PARAMS__MAX_RESULTS = 3;

	/**
	 * The feature id for the '<em><b>Matches All Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_SEARCH_PARAMS__MATCHES_ALL_TAGS = 4;

	/**
	 * The feature id for the '<em><b>With Tag Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_SEARCH_PARAMS__WITH_TAG_INFO = 5;

	/**
	 * The feature id for the '<em><b>With Full Tag Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_SEARCH_PARAMS__WITH_FULL_TAG_INFO = 6;

	/**
	 * The feature id for the '<em><b>Query Is Object Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_SEARCH_PARAMS__QUERY_IS_OBJECT_URI = 7;

	/**
	 * The number of structural features of the '<em>Tagged Object Search Params</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_SEARCH_PARAMS_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Tagged Object Search Params</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_OBJECT_SEARCH_PARAMS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.TagSearchScope <em>Tag Search Scope</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.atm.model.abaptags.TagSearchScope
	 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagSearchScope()
	 * @generated
	 */
	int TAG_SEARCH_SCOPE = 8;


	/**
	 * Returns the meta object for class '{@link com.devepos.adt.atm.model.abaptags.ITagBase <em>Tag Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag Base</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITagBase
	 * @generated
	 */
	EClass getTagBase();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITagBase#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITagBase#getId()
	 * @see #getTagBase()
	 * @generated
	 */
	EAttribute getTagBase_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITagBase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITagBase#getName()
	 * @see #getTagBase()
	 * @generated
	 */
	EAttribute getTagBase_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITagBase#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITagBase#getOwner()
	 * @see #getTagBase()
	 * @generated
	 */
	EAttribute getTagBase_Owner();

	/**
	 * Returns the meta object for class '{@link com.devepos.adt.atm.model.abaptags.ITag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITag
	 * @generated
	 */
	EClass getTag();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITag#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITag#getDescription()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link com.devepos.adt.atm.model.abaptags.ITag#getChildTags <em>Child Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child Tags</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITag#getChildTags()
	 * @see #getTag()
	 * @generated
	 */
	EReference getTag_ChildTags();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITag#isIsRoot <em>Is Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Root</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITag#isIsRoot()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_IsRoot();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITag#getCreatedBy <em>Created By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created By</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITag#getCreatedBy()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_CreatedBy();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITag#getCreatedDateTime <em>Created Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created Date Time</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITag#getCreatedDateTime()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_CreatedDateTime();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITag#getChangedBy <em>Changed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Changed By</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITag#getChangedBy()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_ChangedBy();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITag#getChangedDateTime <em>Changed Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Changed Date Time</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITag#getChangedDateTime()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_ChangedDateTime();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITag#getTaggedObjectCount <em>Tagged Object Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tagged Object Count</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITag#getTaggedObjectCount()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_TaggedObjectCount();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITag#isChanged <em>Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Changed</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITag#isChanged()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Changed();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITag#getParentTagId <em>Parent Tag Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Tag Id</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITag#getParentTagId()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_ParentTagId();

	/**
	 * Returns the meta object for class '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag <em>Adt Object Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adt Object Tag</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag
	 * @generated
	 */
	EClass getAdtObjectTag();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectName <em>Parent Object Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Object Name</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectName()
	 * @see #getAdtObjectTag()
	 * @generated
	 */
	EAttribute getAdtObjectTag_ParentObjectName();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectType <em>Parent Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Object Type</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectType()
	 * @see #getAdtObjectTag()
	 * @generated
	 */
	EAttribute getAdtObjectTag_ParentObjectType();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectUri <em>Parent Object Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Object Uri</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectUri()
	 * @see #getAdtObjectTag()
	 * @generated
	 */
	EAttribute getAdtObjectTag_ParentObjectUri();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagId <em>Parent Tag Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Tag Id</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagId()
	 * @see #getAdtObjectTag()
	 * @generated
	 */
	EAttribute getAdtObjectTag_ParentTagId();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagName <em>Parent Tag Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Tag Name</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagName()
	 * @see #getAdtObjectTag()
	 * @generated
	 */
	EAttribute getAdtObjectTag_ParentTagName();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#isUserTag <em>User Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Tag</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag#isUserTag()
	 * @see #getAdtObjectTag()
	 * @generated
	 */
	EAttribute getAdtObjectTag_UserTag();

	/**
	 * Returns the meta object for class '{@link com.devepos.adt.atm.model.abaptags.ITagList <em>Tag List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag List</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITagList
	 * @generated
	 */
	EClass getTagList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.devepos.adt.atm.model.abaptags.ITagList#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITagList#getTags()
	 * @see #getTagList()
	 * @generated
	 */
	EReference getTagList_Tags();

	/**
	 * Returns the meta object for class '{@link com.devepos.adt.atm.model.abaptags.ITagPreviewInfo <em>Tag Preview Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag Preview Info</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITagPreviewInfo
	 * @generated
	 */
	EClass getTagPreviewInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link com.devepos.adt.atm.model.abaptags.ITagPreviewInfo#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITagPreviewInfo#getTags()
	 * @see #getTagPreviewInfo()
	 * @generated
	 */
	EReference getTagPreviewInfo_Tags();

	/**
	 * Returns the meta object for the containment reference list '{@link com.devepos.adt.atm.model.abaptags.ITagPreviewInfo#getAdtObjectRefs <em>Adt Object Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Adt Object Refs</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITagPreviewInfo#getAdtObjectRefs()
	 * @see #getTagPreviewInfo()
	 * @generated
	 */
	EReference getTagPreviewInfo_AdtObjectRefs();

	/**
	 * Returns the meta object for class '{@link com.devepos.adt.atm.model.abaptags.ITaggedObject <em>Tagged Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tagged Object</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITaggedObject
	 * @generated
	 */
	EClass getTaggedObject();

	/**
	 * Returns the meta object for the containment reference '{@link com.devepos.adt.atm.model.abaptags.ITaggedObject#getObjectRef <em>Object Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object Ref</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITaggedObject#getObjectRef()
	 * @see #getTaggedObject()
	 * @generated
	 */
	EReference getTaggedObject_ObjectRef();

	/**
	 * Returns the meta object for the containment reference list '{@link com.devepos.adt.atm.model.abaptags.ITaggedObject#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITaggedObject#getTags()
	 * @see #getTaggedObject()
	 * @generated
	 */
	EReference getTaggedObject_Tags();

	/**
	 * Returns the meta object for class '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectList <em>Tagged Object List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tagged Object List</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectList
	 * @generated
	 */
	EClass getTaggedObjectList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectList#getTaggedObjects <em>Tagged Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tagged Objects</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectList#getTaggedObjects()
	 * @see #getTaggedObjectList()
	 * @generated
	 */
	EReference getTaggedObjectList_TaggedObjects();

	/**
	 * Returns the meta object for class '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams <em>Tagged Object Search Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tagged Object Search Params</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams
	 * @generated
	 */
	EClass getTaggedObjectSearchParams();

	/**
	 * Returns the meta object for the attribute list '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getTagIds <em>Tag Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tag Ids</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getTagIds()
	 * @see #getTaggedObjectSearchParams()
	 * @generated
	 */
	EAttribute getTaggedObjectSearchParams_TagIds();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getSearchScope <em>Search Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Search Scope</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getSearchScope()
	 * @see #getTaggedObjectSearchParams()
	 * @generated
	 */
	EAttribute getTaggedObjectSearchParams_SearchScope();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getQuery()
	 * @see #getTaggedObjectSearchParams()
	 * @generated
	 */
	EAttribute getTaggedObjectSearchParams_Query();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getMaxResults <em>Max Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Results</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getMaxResults()
	 * @see #getTaggedObjectSearchParams()
	 * @generated
	 */
	EAttribute getTaggedObjectSearchParams_MaxResults();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isMatchesAllTags <em>Matches All Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Matches All Tags</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isMatchesAllTags()
	 * @see #getTaggedObjectSearchParams()
	 * @generated
	 */
	EAttribute getTaggedObjectSearchParams_MatchesAllTags();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isWithTagInfo <em>With Tag Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With Tag Info</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isWithTagInfo()
	 * @see #getTaggedObjectSearchParams()
	 * @generated
	 */
	EAttribute getTaggedObjectSearchParams_WithTagInfo();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isWithFullTagInfo <em>With Full Tag Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With Full Tag Info</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isWithFullTagInfo()
	 * @see #getTaggedObjectSearchParams()
	 * @generated
	 */
	EAttribute getTaggedObjectSearchParams_WithFullTagInfo();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isQueryIsObjectUri <em>Query Is Object Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query Is Object Uri</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isQueryIsObjectUri()
	 * @see #getTaggedObjectSearchParams()
	 * @generated
	 */
	EAttribute getTaggedObjectSearchParams_QueryIsObjectUri();

	/**
	 * Returns the meta object for enum '{@link com.devepos.adt.atm.model.abaptags.TagSearchScope <em>Tag Search Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Tag Search Scope</em>'.
	 * @see com.devepos.adt.atm.model.abaptags.TagSearchScope
	 * @generated
	 */
	EEnum getTagSearchScope();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IAbapTagsFactory getAbapTagsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.impl.TagBase <em>Tag Base</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.atm.model.abaptags.impl.TagBase
		 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagBase()
		 * @generated
		 */
		EClass TAG_BASE = eINSTANCE.getTagBase();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG_BASE__ID = eINSTANCE.getTagBase_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG_BASE__NAME = eINSTANCE.getTagBase_Name();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG_BASE__OWNER = eINSTANCE.getTagBase_Owner();

		/**
		 * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.impl.Tag <em>Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.atm.model.abaptags.impl.Tag
		 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTag()
		 * @generated
		 */
		EClass TAG = eINSTANCE.getTag();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__DESCRIPTION = eINSTANCE.getTag_Description();

		/**
		 * The meta object literal for the '<em><b>Child Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG__CHILD_TAGS = eINSTANCE.getTag_ChildTags();

		/**
		 * The meta object literal for the '<em><b>Is Root</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__IS_ROOT = eINSTANCE.getTag_IsRoot();

		/**
		 * The meta object literal for the '<em><b>Created By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__CREATED_BY = eINSTANCE.getTag_CreatedBy();

		/**
		 * The meta object literal for the '<em><b>Created Date Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__CREATED_DATE_TIME = eINSTANCE.getTag_CreatedDateTime();

		/**
		 * The meta object literal for the '<em><b>Changed By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__CHANGED_BY = eINSTANCE.getTag_ChangedBy();

		/**
		 * The meta object literal for the '<em><b>Changed Date Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__CHANGED_DATE_TIME = eINSTANCE.getTag_ChangedDateTime();

		/**
		 * The meta object literal for the '<em><b>Tagged Object Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__TAGGED_OBJECT_COUNT = eINSTANCE.getTag_TaggedObjectCount();

		/**
		 * The meta object literal for the '<em><b>Changed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__CHANGED = eINSTANCE.getTag_Changed();

		/**
		 * The meta object literal for the '<em><b>Parent Tag Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__PARENT_TAG_ID = eINSTANCE.getTag_ParentTagId();

		/**
		 * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag <em>Adt Object Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag
		 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getAdtObjectTag()
		 * @generated
		 */
		EClass ADT_OBJECT_TAG = eINSTANCE.getAdtObjectTag();

		/**
		 * The meta object literal for the '<em><b>Parent Object Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADT_OBJECT_TAG__PARENT_OBJECT_NAME = eINSTANCE.getAdtObjectTag_ParentObjectName();

		/**
		 * The meta object literal for the '<em><b>Parent Object Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADT_OBJECT_TAG__PARENT_OBJECT_TYPE = eINSTANCE.getAdtObjectTag_ParentObjectType();

		/**
		 * The meta object literal for the '<em><b>Parent Object Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADT_OBJECT_TAG__PARENT_OBJECT_URI = eINSTANCE.getAdtObjectTag_ParentObjectUri();

		/**
		 * The meta object literal for the '<em><b>Parent Tag Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADT_OBJECT_TAG__PARENT_TAG_ID = eINSTANCE.getAdtObjectTag_ParentTagId();

		/**
		 * The meta object literal for the '<em><b>Parent Tag Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADT_OBJECT_TAG__PARENT_TAG_NAME = eINSTANCE.getAdtObjectTag_ParentTagName();

		/**
		 * The meta object literal for the '<em><b>User Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADT_OBJECT_TAG__USER_TAG = eINSTANCE.getAdtObjectTag_UserTag();

		/**
		 * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.impl.TagList <em>Tag List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.atm.model.abaptags.impl.TagList
		 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagList()
		 * @generated
		 */
		EClass TAG_LIST = eINSTANCE.getTagList();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG_LIST__TAGS = eINSTANCE.getTagList_Tags();

		/**
		 * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.impl.TagPreviewInfo <em>Tag Preview Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.atm.model.abaptags.impl.TagPreviewInfo
		 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagPreviewInfo()
		 * @generated
		 */
		EClass TAG_PREVIEW_INFO = eINSTANCE.getTagPreviewInfo();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG_PREVIEW_INFO__TAGS = eINSTANCE.getTagPreviewInfo_Tags();

		/**
		 * The meta object literal for the '<em><b>Adt Object Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG_PREVIEW_INFO__ADT_OBJECT_REFS = eINSTANCE.getTagPreviewInfo_AdtObjectRefs();

		/**
		 * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObject <em>Tagged Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObject
		 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObject()
		 * @generated
		 */
		EClass TAGGED_OBJECT = eINSTANCE.getTaggedObject();

		/**
		 * The meta object literal for the '<em><b>Object Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAGGED_OBJECT__OBJECT_REF = eINSTANCE.getTaggedObject_ObjectRef();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAGGED_OBJECT__TAGS = eINSTANCE.getTaggedObject_Tags();

		/**
		 * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectList <em>Tagged Object List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObjectList
		 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObjectList()
		 * @generated
		 */
		EClass TAGGED_OBJECT_LIST = eINSTANCE.getTaggedObjectList();

		/**
		 * The meta object literal for the '<em><b>Tagged Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAGGED_OBJECT_LIST__TAGGED_OBJECTS = eINSTANCE.getTaggedObjectList_TaggedObjects();

		/**
		 * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams <em>Tagged Object Search Params</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams
		 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObjectSearchParams()
		 * @generated
		 */
		EClass TAGGED_OBJECT_SEARCH_PARAMS = eINSTANCE.getTaggedObjectSearchParams();

		/**
		 * The meta object literal for the '<em><b>Tag Ids</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAGGED_OBJECT_SEARCH_PARAMS__TAG_IDS = eINSTANCE.getTaggedObjectSearchParams_TagIds();

		/**
		 * The meta object literal for the '<em><b>Search Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAGGED_OBJECT_SEARCH_PARAMS__SEARCH_SCOPE = eINSTANCE.getTaggedObjectSearchParams_SearchScope();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAGGED_OBJECT_SEARCH_PARAMS__QUERY = eINSTANCE.getTaggedObjectSearchParams_Query();

		/**
		 * The meta object literal for the '<em><b>Max Results</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAGGED_OBJECT_SEARCH_PARAMS__MAX_RESULTS = eINSTANCE.getTaggedObjectSearchParams_MaxResults();

		/**
		 * The meta object literal for the '<em><b>Matches All Tags</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAGGED_OBJECT_SEARCH_PARAMS__MATCHES_ALL_TAGS = eINSTANCE.getTaggedObjectSearchParams_MatchesAllTags();

		/**
		 * The meta object literal for the '<em><b>With Tag Info</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAGGED_OBJECT_SEARCH_PARAMS__WITH_TAG_INFO = eINSTANCE.getTaggedObjectSearchParams_WithTagInfo();

		/**
		 * The meta object literal for the '<em><b>With Full Tag Info</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAGGED_OBJECT_SEARCH_PARAMS__WITH_FULL_TAG_INFO = eINSTANCE.getTaggedObjectSearchParams_WithFullTagInfo();

		/**
		 * The meta object literal for the '<em><b>Query Is Object Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAGGED_OBJECT_SEARCH_PARAMS__QUERY_IS_OBJECT_URI = eINSTANCE.getTaggedObjectSearchParams_QueryIsObjectUri();

		/**
		 * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.TagSearchScope <em>Tag Search Scope</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.atm.model.abaptags.TagSearchScope
		 * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagSearchScope()
		 * @generated
		 */
		EEnum TAG_SEARCH_SCOPE = eINSTANCE.getTagSearchScope();

	}

} //IAbapTagsPackage
