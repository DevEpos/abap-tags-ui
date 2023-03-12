/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsFactory
 * @model kind="package"
 * @generated
 */
public interface IAbapTagsPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  String eNAME = "abaptags";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  String eNS_URI = "http://www.devepos.com/adt/atm";

  /**
   * The package namespace name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  String eNS_PREFIX = "atm";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  IAbapTagsPackage eINSTANCE = com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage.init();

  /**
   * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.TagBase <em>Tag
   * Base</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.impl.TagBase
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagBase()
   * @generated
   */
  int TAG_BASE = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG_BASE__ID = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG_BASE__NAME = 1;

  /**
   * The feature id for the '<em><b>Owner</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG_BASE__OWNER = 2;

  /**
   * The number of structural features of the '<em>Tag Base</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG_BASE_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Tag Base</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG_BASE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.Tag <em>Tag</em>}'
   * class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.impl.Tag
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTag()
   * @generated
   */
  int TAG = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__ID = TAG_BASE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__NAME = TAG_BASE__NAME;

  /**
   * The feature id for the '<em><b>Owner</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__OWNER = TAG_BASE__OWNER;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__DESCRIPTION = TAG_BASE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Child Tags</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__CHILD_TAGS = TAG_BASE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Created By</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__CREATED_BY = TAG_BASE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Created Date Time</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__CREATED_DATE_TIME = TAG_BASE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Changed By</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__CHANGED_BY = TAG_BASE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Changed Date Time</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__CHANGED_DATE_TIME = TAG_BASE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Tagged Object Count</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__TAGGED_OBJECT_COUNT = TAG_BASE_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Shared</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__SHARED = TAG_BASE_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Shared For Me</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__SHARED_FOR_ME = TAG_BASE_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Changed</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__CHANGED = TAG_BASE_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Parent Tag Id</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__PARENT_TAG_ID = TAG_BASE_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Shared Users</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG__SHARED_USERS = TAG_BASE_FEATURE_COUNT + 11;

  /**
   * The number of structural features of the '<em>Tag</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG_FEATURE_COUNT = TAG_BASE_FEATURE_COUNT + 12;

  /**
   * The number of operations of the '<em>Tag</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG_OPERATION_COUNT = TAG_BASE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag <em>Adt
   * Object Tag</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getAdtObjectTag()
   * @generated
   */
  int ADT_OBJECT_TAG = 3;

  /**
   * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.TagList <em>Tag
   * List</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.impl.TagList
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagList()
   * @generated
   */
  int TAG_LIST = 2;

  /**
   * The feature id for the '<em><b>Tags</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG_LIST__TAGS = 0;

  /**
   * The number of structural features of the '<em>Tag List</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG_LIST_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Tag List</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG_LIST_OPERATION_COUNT = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJECT_TAG__ID = TAG_BASE__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJECT_TAG__NAME = TAG_BASE__NAME;

  /**
   * The feature id for the '<em><b>Owner</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJECT_TAG__OWNER = TAG_BASE__OWNER;

  /**
   * The feature id for the '<em><b>Parent Object Name</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJECT_TAG__PARENT_OBJECT_NAME = TAG_BASE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parent Object Type</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJECT_TAG__PARENT_OBJECT_TYPE = TAG_BASE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Parent Object Uri</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJECT_TAG__PARENT_OBJECT_URI = TAG_BASE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Parent Tag Id</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJECT_TAG__PARENT_TAG_ID = TAG_BASE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Parent Tag Name</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJECT_TAG__PARENT_TAG_NAME = TAG_BASE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Image</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJECT_TAG__IMAGE = TAG_BASE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Possible Parent Tags</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJECT_TAG__POSSIBLE_PARENT_TAGS = TAG_BASE_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Correct Parent Tag</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJECT_TAG__CORRECT_PARENT_TAG = TAG_BASE_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Adt Object Tag</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJECT_TAG_FEATURE_COUNT = TAG_BASE_FEATURE_COUNT + 8;

  /**
   * The number of operations of the '<em>Adt Object Tag</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int ADT_OBJECT_TAG_OPERATION_COUNT = TAG_BASE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.TagPreviewInfo
   * <em>Tag Preview Info</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.impl.TagPreviewInfo
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagPreviewInfo()
   * @generated
   */
  int TAG_PREVIEW_INFO = 4;

  /**
   * The feature id for the '<em><b>Tags</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG_PREVIEW_INFO__TAGS = 0;

  /**
   * The feature id for the '<em><b>Adt Object Refs</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG_PREVIEW_INFO__ADT_OBJECT_REFS = 1;

  /**
   * The number of structural features of the '<em>Tag Preview Info</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG_PREVIEW_INFO_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Tag Preview Info</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAG_PREVIEW_INFO_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObject
   * <em>Tagged Object</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObject
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObject()
   * @generated
   */
  int TAGGED_OBJECT = 5;

  /**
   * The feature id for the '<em><b>Object Ref</b></em>' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT__OBJECT_REF = 0;

  /**
   * The feature id for the '<em><b>Tags</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT__TAGS = 1;

  /**
   * The number of structural features of the '<em>Tagged Object</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Tagged Object</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectList
   * <em>Tagged Object List</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObjectList
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObjectList()
   * @generated
   */
  int TAGGED_OBJECT_LIST = 6;

  /**
   * The feature id for the '<em><b>Tagged Objects</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_LIST__TAGGED_OBJECTS = 0;

  /**
   * The number of structural features of the '<em>Tagged Object List</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_LIST_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Tagged Object List</em>' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_LIST_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeRequest <em>Tagged Object Tree
   * Request</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeRequest
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObjectTreeRequest()
   * @generated
   */
  int TAGGED_OBJECT_TREE_REQUEST = 7;

  /**
   * The feature id for the '<em><b>Tag Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_REQUEST__TAG_ID = 0;

  /**
   * The feature id for the '<em><b>Parent Object Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_NAME = 1;

  /**
   * The feature id for the '<em><b>Parent Object Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_TYPE = 2;

  /**
   * The number of structural features of the '<em>Tagged Object Tree Request</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_REQUEST_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Tagged Object Tree Request</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_REQUEST_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams <em>Tagged Object
   * Search Params</em>}' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObjectSearchParams()
   * @generated
   */
  int TAGGED_OBJECT_SEARCH_PARAMS = 8;

  /**
   * The feature id for the '<em><b>Tag Ids</b></em>' attribute list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_SEARCH_PARAMS__TAG_IDS = 0;

  /**
   * The feature id for the '<em><b>Search Scope</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_SEARCH_PARAMS__SEARCH_SCOPE = 1;

  /**
   * The feature id for the '<em><b>Query</b></em>' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_SEARCH_PARAMS__QUERY = 2;

  /**
   * The feature id for the '<em><b>Query Type</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_SEARCH_PARAMS__QUERY_TYPE = 3;

  /**
   * The feature id for the '<em><b>Result Group Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_SEARCH_PARAMS__RESULT_GROUP_LEVEL = 4;

  /**
   * The feature id for the '<em><b>Query Focus</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_SEARCH_PARAMS__QUERY_FOCUS = 5;

  /**
   * The feature id for the '<em><b>Max Results</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_SEARCH_PARAMS__MAX_RESULTS = 6;

  /**
   * The feature id for the '<em><b>Matches All Tags</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_SEARCH_PARAMS__MATCHES_ALL_TAGS = 7;

  /**
   * The feature id for the '<em><b>With Tag Info</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_SEARCH_PARAMS__WITH_TAG_INFO = 8;

  /**
   * The feature id for the '<em><b>Tag Info Type</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_SEARCH_PARAMS__TAG_INFO_TYPE = 9;

  /**
   * The number of structural features of the '<em>Tagged Object Search Params</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_SEARCH_PARAMS_FEATURE_COUNT = 10;

  /**
   * The number of operations of the '<em>Tagged Object Search Params</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_SEARCH_PARAMS_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeObject <em>Tagged Object Tree
   * Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeObject
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObjectTreeObject()
   * @generated
   */
  int TAGGED_OBJECT_TREE_OBJECT = 9;

  /**
   * The feature id for the '<em><b>Object Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_OBJECT__OBJECT_REF = 0;

  /**
   * The feature id for the '<em><b>Tagged Object Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_OBJECT__TAGGED_OBJECT_COUNT = 1;

  /**
   * The feature id for the '<em><b>Parent Tag Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_OBJECT__PARENT_TAG_ID = 2;

  /**
   * The feature id for the '<em><b>Expandable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_OBJECT__EXPANDABLE = 3;

  /**
   * The number of structural features of the '<em>Tagged Object Tree Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_OBJECT_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Tagged Object Tree Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_OBJECT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the
   * '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeResult <em>Tagged Object Tree
   * Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeResult
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObjectTreeResult()
   * @generated
   */
  int TAGGED_OBJECT_TREE_RESULT = 10;

  /**
   * The feature id for the '<em><b>Objects</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_RESULT__OBJECTS = 0;

  /**
   * The feature id for the '<em><b>Tags</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_RESULT__TAGS = 1;

  /**
   * The number of structural features of the '<em>Tagged Object Tree Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_RESULT_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Tagged Object Tree Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TAGGED_OBJECT_TREE_RESULT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.TagSearchScope <em>Tag
   * Search Scope</em>}' enum.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.TagSearchScope
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagSearchScope()
   * @generated
   */
  int TAG_SEARCH_SCOPE = 11;

  /**
   * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.TagQueryType <em>Tag
   * Query Type</em>}' enum.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.TagQueryType
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagQueryType()
   * @generated
   */
  int TAG_QUERY_TYPE = 12;

  /**
   * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.TagInfoType <em>Tag Info
   * Type</em>}' enum.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.TagInfoType
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagInfoType()
   * @generated
   */
  int TAG_INFO_TYPE = 13;

  /**
   * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.TagQueryFocus <em>Tag
   * Query Focus</em>}' enum.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.TagQueryFocus
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagQueryFocus()
   * @generated
   */
  int TAG_QUERY_FOCUS = 14;

  /**
   * The meta object id for the '{@link com.devepos.adt.atm.model.abaptags.ResultGroupLevel
   * <em>Result Group Level</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.devepos.adt.atm.model.abaptags.ResultGroupLevel
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getResultGroupLevel()
   * @generated
   */
  int RESULT_GROUP_LEVEL = 15;

  /**
   * The meta object id for the '<em>Image</em>' data type.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @see org.eclipse.swt.graphics.Image
   * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getImage()
   * @generated
   */
  int IMAGE = 16;

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.atm.model.abaptags.ITagBase <em>Tag Base</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Tag Base</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITagBase
   * @generated
   */
  EClass getTagBase();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITagBase#getId <em>Id</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITagBase#getId()
   * @see #getTagBase()
   * @generated
   */
  EAttribute getTagBase_Id();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITagBase#getName <em>Name</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITagBase#getName()
   * @see #getTagBase()
   * @generated
   */
  EAttribute getTagBase_Name();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITagBase#getOwner <em>Owner</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Owner</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITagBase#getOwner()
   * @see #getTagBase()
   * @generated
   */
  EAttribute getTagBase_Owner();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.atm.model.abaptags.ITag <em>Tag</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Tag</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITag
   * @generated
   */
  EClass getTag();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITag#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITag#getDescription()
   * @see #getTag()
   * @generated
   */
  EAttribute getTag_Description();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.atm.model.abaptags.ITag#getChildTags <em>Child Tags</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Child Tags</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITag#getChildTags()
   * @see #getTag()
   * @generated
   */
  EReference getTag_ChildTags();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITag#getCreatedBy <em>Created By</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Created By</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITag#getCreatedBy()
   * @see #getTag()
   * @generated
   */
  EAttribute getTag_CreatedBy();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITag#getCreatedDateTime <em>Created Date
   * Time</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Created Date Time</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITag#getCreatedDateTime()
   * @see #getTag()
   * @generated
   */
  EAttribute getTag_CreatedDateTime();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITag#getChangedBy <em>Changed By</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Changed By</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITag#getChangedBy()
   * @see #getTag()
   * @generated
   */
  EAttribute getTag_ChangedBy();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITag#getChangedDateTime <em>Changed Date
   * Time</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Changed Date Time</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITag#getChangedDateTime()
   * @see #getTag()
   * @generated
   */
  EAttribute getTag_ChangedDateTime();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITag#getTaggedObjectCount <em>Tagged Object
   * Count</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Tagged Object Count</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITag#getTaggedObjectCount()
   * @see #getTag()
   * @generated
   */
  EAttribute getTag_TaggedObjectCount();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITag#isShared <em>Shared</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Shared</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITag#isShared()
   * @see #getTag()
   * @generated
   */
  EAttribute getTag_Shared();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITag#isSharedForMe <em>Shared For Me</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Shared For Me</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITag#isSharedForMe()
   * @see #getTag()
   * @generated
   */
  EAttribute getTag_SharedForMe();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITag#isChanged <em>Changed</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Changed</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITag#isChanged()
   * @see #getTag()
   * @generated
   */
  EAttribute getTag_Changed();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITag#getParentTagId <em>Parent Tag Id</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Parent Tag Id</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITag#getParentTagId()
   * @see #getTag()
   * @generated
   */
  EAttribute getTag_ParentTagId();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.atm.model.abaptags.ITag#getSharedUsers <em>Shared Users</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Shared Users</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITag#getSharedUsers()
   * @see #getTag()
   * @generated
   */
  EReference getTag_SharedUsers();

  /**
   * Returns the meta object for class '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag
   * <em>Adt Object Tag</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Adt Object Tag</em>'.
   * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag
   * @generated
   */
  EClass getAdtObjectTag();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectName <em>Parent Object
   * Name</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Parent Object Name</em>'.
   * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectName()
   * @see #getAdtObjectTag()
   * @generated
   */
  EAttribute getAdtObjectTag_ParentObjectName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectType <em>Parent Object
   * Type</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Parent Object Type</em>'.
   * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectType()
   * @see #getAdtObjectTag()
   * @generated
   */
  EAttribute getAdtObjectTag_ParentObjectType();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectUri <em>Parent Object
   * Uri</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Parent Object Uri</em>'.
   * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectUri()
   * @see #getAdtObjectTag()
   * @generated
   */
  EAttribute getAdtObjectTag_ParentObjectUri();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagId <em>Parent Tag
   * Id</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Parent Tag Id</em>'.
   * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagId()
   * @see #getAdtObjectTag()
   * @generated
   */
  EAttribute getAdtObjectTag_ParentTagId();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagName <em>Parent Tag
   * Name</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Parent Tag Name</em>'.
   * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagName()
   * @see #getAdtObjectTag()
   * @generated
   */
  EAttribute getAdtObjectTag_ParentTagName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getImage <em>Image</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Image</em>'.
   * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getImage()
   * @see #getAdtObjectTag()
   * @generated
   */
  EAttribute getAdtObjectTag_Image();

  /**
   * Returns the meta object for the attribute list
   * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getPossibleParentTags <em>Possible
   * Parent Tags</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute list '<em>Possible Parent Tags</em>'.
   * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getPossibleParentTags()
   * @see #getAdtObjectTag()
   * @generated
   */
  EAttribute getAdtObjectTag_PossibleParentTags();

  /**
   * Returns the meta object for the reference
   * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getCorrectParentTag <em>Correct Parent
   * Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the reference '<em>Correct Parent Tag</em>'.
   * @see com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getCorrectParentTag()
   * @see #getAdtObjectTag()
   * @generated
   */
  EReference getAdtObjectTag_CorrectParentTag();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.atm.model.abaptags.ITagList <em>Tag List</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Tag List</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITagList
   * @generated
   */
  EClass getTagList();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.atm.model.abaptags.ITagList#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Tags</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITagList#getTags()
   * @see #getTagList()
   * @generated
   */
  EReference getTagList_Tags();

  /**
   * Returns the meta object for class '{@link com.devepos.adt.atm.model.abaptags.ITagPreviewInfo
   * <em>Tag Preview Info</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Tag Preview Info</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITagPreviewInfo
   * @generated
   */
  EClass getTagPreviewInfo();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.atm.model.abaptags.ITagPreviewInfo#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Tags</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITagPreviewInfo#getTags()
   * @see #getTagPreviewInfo()
   * @generated
   */
  EReference getTagPreviewInfo_Tags();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.atm.model.abaptags.ITagPreviewInfo#getAdtObjectRefs <em>Adt Object
   * Refs</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Adt Object Refs</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITagPreviewInfo#getAdtObjectRefs()
   * @see #getTagPreviewInfo()
   * @generated
   */
  EReference getTagPreviewInfo_AdtObjectRefs();

  /**
   * Returns the meta object for class '{@link com.devepos.adt.atm.model.abaptags.ITaggedObject
   * <em>Tagged Object</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Tagged Object</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObject
   * @generated
   */
  EClass getTaggedObject();

  /**
   * Returns the meta object for the containment reference
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObject#getObjectRef <em>Object Ref</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference '<em>Object Ref</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObject#getObjectRef()
   * @see #getTaggedObject()
   * @generated
   */
  EReference getTaggedObject_ObjectRef();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObject#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Tags</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObject#getTags()
   * @see #getTaggedObject()
   * @generated
   */
  EReference getTaggedObject_Tags();

  /**
   * Returns the meta object for class '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectList
   * <em>Tagged Object List</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Tagged Object List</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectList
   * @generated
   */
  EClass getTaggedObjectList();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectList#getTaggedObjects <em>Tagged
   * Objects</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Tagged Objects</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectList#getTaggedObjects()
   * @see #getTaggedObjectList()
   * @generated
   */
  EReference getTaggedObjectList_TaggedObjects();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest <em>Tagged Object Tree
   * Request</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Tagged Object Tree Request</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest
   * @generated
   */
  EClass getTaggedObjectTreeRequest();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest#getTagId <em>Tag Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Tag Id</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest#getTagId()
   * @see #getTaggedObjectTreeRequest()
   * @generated
   */
  EAttribute getTaggedObjectTreeRequest_TagId();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest#getParentObjectName
   * <em>Parent Object Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Parent Object Name</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest#getParentObjectName()
   * @see #getTaggedObjectTreeRequest()
   * @generated
   */
  EAttribute getTaggedObjectTreeRequest_ParentObjectName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest#getParentObjectType
   * <em>Parent Object Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Parent Object Type</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeRequest#getParentObjectType()
   * @see #getTaggedObjectTreeRequest()
   * @generated
   */
  EAttribute getTaggedObjectTreeRequest_ParentObjectType();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams <em>Tagged Object Search
   * Params</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @return the meta object for class '<em>Tagged Object Search Params</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams
   * @generated
   */
  EClass getTaggedObjectSearchParams();

  /**
   * Returns the meta object for the attribute list
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getTagIds <em>Tag
   * Ids</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute list '<em>Tag Ids</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getTagIds()
   * @see #getTaggedObjectSearchParams()
   * @generated
   */
  EAttribute getTaggedObjectSearchParams_TagIds();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getSearchScope <em>Search
   * Scope</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Search Scope</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getSearchScope()
   * @see #getTaggedObjectSearchParams()
   * @generated
   */
  EAttribute getTaggedObjectSearchParams_SearchScope();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getQuery <em>Query</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Query</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getQuery()
   * @see #getTaggedObjectSearchParams()
   * @generated
   */
  EAttribute getTaggedObjectSearchParams_Query();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getQueryType <em>Query
   * Type</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Query Type</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getQueryType()
   * @see #getTaggedObjectSearchParams()
   * @generated
   */
  EAttribute getTaggedObjectSearchParams_QueryType();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getResultGroupLevel
   * <em>Result Group Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Result Group Level</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getResultGroupLevel()
   * @see #getTaggedObjectSearchParams()
   * @generated
   */
  EAttribute getTaggedObjectSearchParams_ResultGroupLevel();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getQueryFocus <em>Query
   * Focus</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Query Focus</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getQueryFocus()
   * @see #getTaggedObjectSearchParams()
   * @generated
   */
  EAttribute getTaggedObjectSearchParams_QueryFocus();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getMaxResults <em>Max
   * Results</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Max Results</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getMaxResults()
   * @see #getTaggedObjectSearchParams()
   * @generated
   */
  EAttribute getTaggedObjectSearchParams_MaxResults();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isMatchesAllTags
   * <em>Matches All Tags</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Matches All Tags</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isMatchesAllTags()
   * @see #getTaggedObjectSearchParams()
   * @generated
   */
  EAttribute getTaggedObjectSearchParams_MatchesAllTags();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isWithTagInfo <em>With Tag
   * Info</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>With Tag Info</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isWithTagInfo()
   * @see #getTaggedObjectSearchParams()
   * @generated
   */
  EAttribute getTaggedObjectSearchParams_WithTagInfo();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getTagInfoType <em>Tag
   * Info Type</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Tag Info Type</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getTagInfoType()
   * @see #getTaggedObjectSearchParams()
   * @generated
   */
  EAttribute getTaggedObjectSearchParams_TagInfoType();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject <em>Tagged Object Tree
   * Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Tagged Object Tree Object</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject
   * @generated
   */
  EClass getTaggedObjectTreeObject();

  /**
   * Returns the meta object for the containment reference
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#getObjectRef <em>Object
   * Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference '<em>Object Ref</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#getObjectRef()
   * @see #getTaggedObjectTreeObject()
   * @generated
   */
  EReference getTaggedObjectTreeObject_ObjectRef();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#getTaggedObjectCount
   * <em>Tagged Object Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Tagged Object Count</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#getTaggedObjectCount()
   * @see #getTaggedObjectTreeObject()
   * @generated
   */
  EAttribute getTaggedObjectTreeObject_TaggedObjectCount();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#getParentTagId <em>Parent
   * Tag Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Parent Tag Id</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#getParentTagId()
   * @see #getTaggedObjectTreeObject()
   * @generated
   */
  EAttribute getTaggedObjectTreeObject_ParentTagId();

  /**
   * Returns the meta object for the attribute
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#isExpandable
   * <em>Expandable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Expandable</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeObject#isExpandable()
   * @see #getTaggedObjectTreeObject()
   * @generated
   */
  EAttribute getTaggedObjectTreeObject_Expandable();

  /**
   * Returns the meta object for class
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult <em>Tagged Object Tree
   * Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Tagged Object Tree Result</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult
   * @generated
   */
  EClass getTaggedObjectTreeResult();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult#getObjects
   * <em>Objects</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Objects</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult#getObjects()
   * @see #getTaggedObjectTreeResult()
   * @generated
   */
  EReference getTaggedObjectTreeResult_Objects();

  /**
   * Returns the meta object for the containment reference list
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Tags</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ITaggedObjectTreeResult#getTags()
   * @see #getTaggedObjectTreeResult()
   * @generated
   */
  EReference getTaggedObjectTreeResult_Tags();

  /**
   * Returns the meta object for enum '{@link com.devepos.adt.atm.model.abaptags.TagSearchScope
   * <em>Tag Search Scope</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Tag Search Scope</em>'.
   * @see com.devepos.adt.atm.model.abaptags.TagSearchScope
   * @generated
   */
  EEnum getTagSearchScope();

  /**
   * Returns the meta object for enum '{@link com.devepos.adt.atm.model.abaptags.TagQueryType
   * <em>Tag Query Type</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Tag Query Type</em>'.
   * @see com.devepos.adt.atm.model.abaptags.TagQueryType
   * @generated
   */
  EEnum getTagQueryType();

  /**
   * Returns the meta object for enum '{@link com.devepos.adt.atm.model.abaptags.TagInfoType <em>Tag
   * Info Type</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Tag Info Type</em>'.
   * @see com.devepos.adt.atm.model.abaptags.TagInfoType
   * @generated
   */
  EEnum getTagInfoType();

  /**
   * Returns the meta object for enum '{@link com.devepos.adt.atm.model.abaptags.TagQueryFocus
   * <em>Tag Query Focus</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Tag Query Focus</em>'.
   * @see com.devepos.adt.atm.model.abaptags.TagQueryFocus
   * @generated
   */
  EEnum getTagQueryFocus();

  /**
   * Returns the meta object for enum '{@link com.devepos.adt.atm.model.abaptags.ResultGroupLevel
   * <em>Result Group Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Result Group Level</em>'.
   * @see com.devepos.adt.atm.model.abaptags.ResultGroupLevel
   * @generated
   */
  EEnum getResultGroupLevel();

  /**
   * Returns the meta object for data type '{@link org.eclipse.swt.graphics.Image <em>Image</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for data type '<em>Image</em>'.
   * @see org.eclipse.swt.graphics.Image
   * @model instanceClass="org.eclipse.swt.graphics.Image"
   * @generated
   */
  EDataType getImage();

  /**
   * Returns the factory that creates the instances of the model. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the factory that creates the instances of the model.
   * @generated
   */
  IAbapTagsFactory getAbapTagsFactory();

  /**
   * <!-- begin-user-doc --> Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each operation of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   *
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.impl.TagBase
     * <em>Tag Base</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.impl.TagBase
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagBase()
     * @generated
     */
    EClass TAG_BASE = eINSTANCE.getTagBase();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAG_BASE__ID = eINSTANCE.getTagBase_Id();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAG_BASE__NAME = eINSTANCE.getTagBase_Name();

    /**
     * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAG_BASE__OWNER = eINSTANCE.getTagBase_Owner();

    /**
     * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.impl.Tag
     * <em>Tag</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.impl.Tag
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTag()
     * @generated
     */
    EClass TAG = eINSTANCE.getTag();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAG__DESCRIPTION = eINSTANCE.getTag_Description();

    /**
     * The meta object literal for the '<em><b>Child Tags</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TAG__CHILD_TAGS = eINSTANCE.getTag_ChildTags();

    /**
     * The meta object literal for the '<em><b>Created By</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAG__CREATED_BY = eINSTANCE.getTag_CreatedBy();

    /**
     * The meta object literal for the '<em><b>Created Date Time</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAG__CREATED_DATE_TIME = eINSTANCE.getTag_CreatedDateTime();

    /**
     * The meta object literal for the '<em><b>Changed By</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAG__CHANGED_BY = eINSTANCE.getTag_ChangedBy();

    /**
     * The meta object literal for the '<em><b>Changed Date Time</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAG__CHANGED_DATE_TIME = eINSTANCE.getTag_ChangedDateTime();

    /**
     * The meta object literal for the '<em><b>Tagged Object Count</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAG__TAGGED_OBJECT_COUNT = eINSTANCE.getTag_TaggedObjectCount();

    /**
     * The meta object literal for the '<em><b>Shared</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAG__SHARED = eINSTANCE.getTag_Shared();

    /**
     * The meta object literal for the '<em><b>Shared For Me</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAG__SHARED_FOR_ME = eINSTANCE.getTag_SharedForMe();

    /**
     * The meta object literal for the '<em><b>Changed</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAG__CHANGED = eINSTANCE.getTag_Changed();

    /**
     * The meta object literal for the '<em><b>Parent Tag Id</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAG__PARENT_TAG_ID = eINSTANCE.getTag_ParentTagId();

    /**
     * The meta object literal for the '<em><b>Shared Users</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TAG__SHARED_USERS = eINSTANCE.getTag_SharedUsers();

    /**
     * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag
     * <em>Adt Object Tag</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.impl.AdtObjectTag
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getAdtObjectTag()
     * @generated
     */
    EClass ADT_OBJECT_TAG = eINSTANCE.getAdtObjectTag();

    /**
     * The meta object literal for the '<em><b>Parent Object Name</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJECT_TAG__PARENT_OBJECT_NAME = eINSTANCE.getAdtObjectTag_ParentObjectName();

    /**
     * The meta object literal for the '<em><b>Parent Object Type</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJECT_TAG__PARENT_OBJECT_TYPE = eINSTANCE.getAdtObjectTag_ParentObjectType();

    /**
     * The meta object literal for the '<em><b>Parent Object Uri</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJECT_TAG__PARENT_OBJECT_URI = eINSTANCE.getAdtObjectTag_ParentObjectUri();

    /**
     * The meta object literal for the '<em><b>Parent Tag Id</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJECT_TAG__PARENT_TAG_ID = eINSTANCE.getAdtObjectTag_ParentTagId();

    /**
     * The meta object literal for the '<em><b>Parent Tag Name</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJECT_TAG__PARENT_TAG_NAME = eINSTANCE.getAdtObjectTag_ParentTagName();

    /**
     * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJECT_TAG__IMAGE = eINSTANCE.getAdtObjectTag_Image();

    /**
     * The meta object literal for the '<em><b>Possible Parent Tags</b></em>' attribute list
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute ADT_OBJECT_TAG__POSSIBLE_PARENT_TAGS = eINSTANCE
        .getAdtObjectTag_PossibleParentTags();

    /**
     * The meta object literal for the '<em><b>Correct Parent Tag</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference ADT_OBJECT_TAG__CORRECT_PARENT_TAG = eINSTANCE.getAdtObjectTag_CorrectParentTag();

    /**
     * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.impl.TagList
     * <em>Tag List</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.impl.TagList
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagList()
     * @generated
     */
    EClass TAG_LIST = eINSTANCE.getTagList();

    /**
     * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TAG_LIST__TAGS = eINSTANCE.getTagList_Tags();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.atm.model.abaptags.impl.TagPreviewInfo <em>Tag Preview Info</em>}'
     * class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.impl.TagPreviewInfo
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagPreviewInfo()
     * @generated
     */
    EClass TAG_PREVIEW_INFO = eINSTANCE.getTagPreviewInfo();

    /**
     * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TAG_PREVIEW_INFO__TAGS = eINSTANCE.getTagPreviewInfo_Tags();

    /**
     * The meta object literal for the '<em><b>Adt Object Refs</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TAG_PREVIEW_INFO__ADT_OBJECT_REFS = eINSTANCE.getTagPreviewInfo_AdtObjectRefs();

    /**
     * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObject
     * <em>Tagged Object</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObject
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObject()
     * @generated
     */
    EClass TAGGED_OBJECT = eINSTANCE.getTaggedObject();

    /**
     * The meta object literal for the '<em><b>Object Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TAGGED_OBJECT__OBJECT_REF = eINSTANCE.getTaggedObject_ObjectRef();

    /**
     * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TAGGED_OBJECT__TAGS = eINSTANCE.getTaggedObject_Tags();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectList <em>Tagged Object
     * List</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObjectList
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObjectList()
     * @generated
     */
    EClass TAGGED_OBJECT_LIST = eINSTANCE.getTaggedObjectList();

    /**
     * The meta object literal for the '<em><b>Tagged Objects</b></em>' containment reference list
     * feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TAGGED_OBJECT_LIST__TAGGED_OBJECTS = eINSTANCE.getTaggedObjectList_TaggedObjects();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeRequest <em>Tagged Object
     * Tree Request</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeRequest
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObjectTreeRequest()
     * @generated
     */
    EClass TAGGED_OBJECT_TREE_REQUEST = eINSTANCE.getTaggedObjectTreeRequest();

    /**
     * The meta object literal for the '<em><b>Tag Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_TREE_REQUEST__TAG_ID = eINSTANCE.getTaggedObjectTreeRequest_TagId();

    /**
     * The meta object literal for the '<em><b>Parent Object Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_NAME = eINSTANCE
        .getTaggedObjectTreeRequest_ParentObjectName();

    /**
     * The meta object literal for the '<em><b>Parent Object Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_TREE_REQUEST__PARENT_OBJECT_TYPE = eINSTANCE
        .getTaggedObjectTreeRequest_ParentObjectType();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams <em>Tagged Object
     * Search Params</em>}' class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObjectSearchParams()
     * @generated
     */
    EClass TAGGED_OBJECT_SEARCH_PARAMS = eINSTANCE.getTaggedObjectSearchParams();

    /**
     * The meta object literal for the '<em><b>Tag Ids</b></em>' attribute list feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_SEARCH_PARAMS__TAG_IDS = eINSTANCE
        .getTaggedObjectSearchParams_TagIds();

    /**
     * The meta object literal for the '<em><b>Search Scope</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_SEARCH_PARAMS__SEARCH_SCOPE = eINSTANCE
        .getTaggedObjectSearchParams_SearchScope();

    /**
     * The meta object literal for the '<em><b>Query</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_SEARCH_PARAMS__QUERY = eINSTANCE.getTaggedObjectSearchParams_Query();

    /**
     * The meta object literal for the '<em><b>Query Type</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_SEARCH_PARAMS__QUERY_TYPE = eINSTANCE
        .getTaggedObjectSearchParams_QueryType();

    /**
     * The meta object literal for the '<em><b>Result Group Level</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_SEARCH_PARAMS__RESULT_GROUP_LEVEL = eINSTANCE
        .getTaggedObjectSearchParams_ResultGroupLevel();

    /**
     * The meta object literal for the '<em><b>Query Focus</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_SEARCH_PARAMS__QUERY_FOCUS = eINSTANCE
        .getTaggedObjectSearchParams_QueryFocus();

    /**
     * The meta object literal for the '<em><b>Max Results</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_SEARCH_PARAMS__MAX_RESULTS = eINSTANCE
        .getTaggedObjectSearchParams_MaxResults();

    /**
     * The meta object literal for the '<em><b>Matches All Tags</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_SEARCH_PARAMS__MATCHES_ALL_TAGS = eINSTANCE
        .getTaggedObjectSearchParams_MatchesAllTags();

    /**
     * The meta object literal for the '<em><b>With Tag Info</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_SEARCH_PARAMS__WITH_TAG_INFO = eINSTANCE
        .getTaggedObjectSearchParams_WithTagInfo();

    /**
     * The meta object literal for the '<em><b>Tag Info Type</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_SEARCH_PARAMS__TAG_INFO_TYPE = eINSTANCE
        .getTaggedObjectSearchParams_TagInfoType();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeObject <em>Tagged Object Tree
     * Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeObject
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObjectTreeObject()
     * @generated
     */
    EClass TAGGED_OBJECT_TREE_OBJECT = eINSTANCE.getTaggedObjectTreeObject();

    /**
     * The meta object literal for the '<em><b>Object Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TAGGED_OBJECT_TREE_OBJECT__OBJECT_REF = eINSTANCE
        .getTaggedObjectTreeObject_ObjectRef();

    /**
     * The meta object literal for the '<em><b>Tagged Object Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_TREE_OBJECT__TAGGED_OBJECT_COUNT = eINSTANCE
        .getTaggedObjectTreeObject_TaggedObjectCount();

    /**
     * The meta object literal for the '<em><b>Parent Tag Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_TREE_OBJECT__PARENT_TAG_ID = eINSTANCE
        .getTaggedObjectTreeObject_ParentTagId();

    /**
     * The meta object literal for the '<em><b>Expandable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TAGGED_OBJECT_TREE_OBJECT__EXPANDABLE = eINSTANCE
        .getTaggedObjectTreeObject_Expandable();

    /**
     * The meta object literal for the
     * '{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeResult <em>Tagged Object Tree
     * Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.impl.TaggedObjectTreeResult
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTaggedObjectTreeResult()
     * @generated
     */
    EClass TAGGED_OBJECT_TREE_RESULT = eINSTANCE.getTaggedObjectTreeResult();

    /**
     * The meta object literal for the '<em><b>Objects</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TAGGED_OBJECT_TREE_RESULT__OBJECTS = eINSTANCE.getTaggedObjectTreeResult_Objects();

    /**
     * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EReference TAGGED_OBJECT_TREE_RESULT__TAGS = eINSTANCE.getTaggedObjectTreeResult_Tags();

    /**
     * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.TagSearchScope
     * <em>Tag Search Scope</em>}' enum.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.TagSearchScope
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagSearchScope()
     * @generated
     */
    EEnum TAG_SEARCH_SCOPE = eINSTANCE.getTagSearchScope();

    /**
     * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.TagQueryType
     * <em>Tag Query Type</em>}' enum.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.TagQueryType
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagQueryType()
     * @generated
     */
    EEnum TAG_QUERY_TYPE = eINSTANCE.getTagQueryType();

    /**
     * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.TagInfoType
     * <em>Tag Info Type</em>}' enum.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.TagInfoType
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagInfoType()
     * @generated
     */
    EEnum TAG_INFO_TYPE = eINSTANCE.getTagInfoType();

    /**
     * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.TagQueryFocus
     * <em>Tag Query Focus</em>}' enum.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.TagQueryFocus
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getTagQueryFocus()
     * @generated
     */
    EEnum TAG_QUERY_FOCUS = eINSTANCE.getTagQueryFocus();

    /**
     * The meta object literal for the '{@link com.devepos.adt.atm.model.abaptags.ResultGroupLevel
     * <em>Result Group Level</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.devepos.adt.atm.model.abaptags.ResultGroupLevel
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getResultGroupLevel()
     * @generated
     */
    EEnum RESULT_GROUP_LEVEL = eINSTANCE.getResultGroupLevel();

    /**
     * The meta object literal for the '<em>Image</em>' data type. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.eclipse.swt.graphics.Image
     * @see com.devepos.adt.atm.model.abaptags.impl.AbapTagsPackage#getImage()
     * @generated
     */
    EDataType IMAGE = eINSTANCE.getImage();

  }

} // IAbapTagsPackage
