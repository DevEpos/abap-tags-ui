/**
 */
package com.devepos.adt.abaptags;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.devepos.adt.abaptags.IAbapTagsFactory
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
	String eNS_URI = "https://www.devepos.com/adt/atm";

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
	IAbapTagsPackage eINSTANCE = com.devepos.adt.abaptags.impl.AbapTagsPackage.init();

	/**
	 * The meta object id for the '{@link com.devepos.adt.abaptags.impl.Tags <em>Tags</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.abaptags.impl.Tags
	 * @see com.devepos.adt.abaptags.impl.AbapTagsPackage#getTags()
	 * @generated
	 */
	int TAGS = 0;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGS__TAGS = 0;

	/**
	 * The number of structural features of the '<em>Tags</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Tags</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.devepos.adt.abaptags.impl.Tag <em>Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.abaptags.impl.Tag
	 * @see com.devepos.adt.abaptags.impl.AbapTagsPackage#getTag()
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
	int TAG__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Child Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__CHILD_TAG = 3;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__IS_ROOT = 4;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__OWNER = 5;

	/**
	 * The feature id for the '<em><b>Created By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__CREATED_BY = 6;

	/**
	 * The feature id for the '<em><b>Created Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__CREATED_DATE_TIME = 7;

	/**
	 * The feature id for the '<em><b>Changed By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__CHANGED_BY = 8;

	/**
	 * The feature id for the '<em><b>Changed Date Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__CHANGED_DATE_TIME = 9;

	/**
	 * The feature id for the '<em><b>Parent Tag</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__PARENT_TAG = 10;

	/**
	 * The feature id for the '<em><b>Tagged Object Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__TAGGED_OBJECT_COUNT = 11;

	/**
	 * The feature id for the '<em><b>Changed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__CHANGED = 12;

	/**
	 * The number of structural features of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FEATURE_COUNT = 13;

	/**
	 * The number of operations of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.devepos.adt.abaptags.impl.AbapObjectWithTag <em>Abap Object With Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.abaptags.impl.AbapObjectWithTag
	 * @see com.devepos.adt.abaptags.impl.AbapTagsPackage#getAbapObjectWithTag()
	 * @generated
	 */
	int ABAP_OBJECT_WITH_TAG = 2;

	/**
	 * The feature id for the '<em><b>Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECT_WITH_TAG__OBJECT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Object Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECT_WITH_TAG__OBJECT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Parent Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_NAME = 2;

	/**
	 * The feature id for the '<em><b>Parent Object Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Tag Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECT_WITH_TAG__TAG_ID = 4;

	/**
	 * The number of structural features of the '<em>Abap Object With Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECT_WITH_TAG_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Abap Object With Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECT_WITH_TAG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.devepos.adt.abaptags.impl.AbapObjectWithTags <em>Abap Object With Tags</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.abaptags.impl.AbapObjectWithTags
	 * @see com.devepos.adt.abaptags.impl.AbapTagsPackage#getAbapObjectWithTags()
	 * @generated
	 */
	int ABAP_OBJECT_WITH_TAGS = 3;

	/**
	 * The feature id for the '<em><b>Object Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECT_WITH_TAGS__OBJECT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Object Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECT_WITH_TAGS__OBJECT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECT_WITH_TAGS__TAG = 2;

	/**
	 * The number of structural features of the '<em>Abap Object With Tags</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECT_WITH_TAGS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Abap Object With Tags</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECT_WITH_TAGS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.devepos.adt.abaptags.impl.AbapObjectsWithTags <em>Abap Objects With Tags</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.abaptags.impl.AbapObjectsWithTags
	 * @see com.devepos.adt.abaptags.impl.AbapTagsPackage#getAbapObjectsWithTags()
	 * @generated
	 */
	int ABAP_OBJECTS_WITH_TAGS = 4;

	/**
	 * The feature id for the '<em><b>Abap Object With Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECTS_WITH_TAGS__ABAP_OBJECT_WITH_TAGS = 0;

	/**
	 * The number of structural features of the '<em>Abap Objects With Tags</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECTS_WITH_TAGS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Abap Objects With Tags</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECTS_WITH_TAGS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.devepos.adt.abaptags.impl.AbapObjectsWithTag <em>Abap Objects With Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.devepos.adt.abaptags.impl.AbapObjectsWithTag
	 * @see com.devepos.adt.abaptags.impl.AbapTagsPackage#getAbapObjectsWithTag()
	 * @generated
	 */
	int ABAP_OBJECTS_WITH_TAG = 5;

	/**
	 * The feature id for the '<em><b>Abap Object With Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECTS_WITH_TAG__ABAP_OBJECT_WITH_TAG = 0;

	/**
	 * The number of structural features of the '<em>Abap Objects With Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECTS_WITH_TAG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Abap Objects With Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABAP_OBJECTS_WITH_TAG_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link com.devepos.adt.abaptags.ITags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tags</em>'.
	 * @see com.devepos.adt.abaptags.ITags
	 * @generated
	 */
	EClass getTags();

	/**
	 * Returns the meta object for the containment reference list '{@link com.devepos.adt.abaptags.ITags#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see com.devepos.adt.abaptags.ITags#getTags()
	 * @see #getTags()
	 * @generated
	 */
	EReference getTags_Tags();

	/**
	 * Returns the meta object for class '{@link com.devepos.adt.abaptags.ITag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag</em>'.
	 * @see com.devepos.adt.abaptags.ITag
	 * @generated
	 */
	EClass getTag();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.ITag#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.devepos.adt.abaptags.ITag#getId()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.ITag#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.devepos.adt.abaptags.ITag#getName()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.ITag#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.devepos.adt.abaptags.ITag#getDescription()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link com.devepos.adt.abaptags.ITag#getChildTag <em>Child Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child Tag</em>'.
	 * @see com.devepos.adt.abaptags.ITag#getChildTag()
	 * @see #getTag()
	 * @generated
	 */
	EReference getTag_ChildTag();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.ITag#isIsRoot <em>Is Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Root</em>'.
	 * @see com.devepos.adt.abaptags.ITag#isIsRoot()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_IsRoot();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.ITag#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see com.devepos.adt.abaptags.ITag#getOwner()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Owner();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.ITag#getCreatedBy <em>Created By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created By</em>'.
	 * @see com.devepos.adt.abaptags.ITag#getCreatedBy()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_CreatedBy();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.ITag#getCreatedDateTime <em>Created Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created Date Time</em>'.
	 * @see com.devepos.adt.abaptags.ITag#getCreatedDateTime()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_CreatedDateTime();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.ITag#getChangedBy <em>Changed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Changed By</em>'.
	 * @see com.devepos.adt.abaptags.ITag#getChangedBy()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_ChangedBy();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.ITag#getChangedDateTime <em>Changed Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Changed Date Time</em>'.
	 * @see com.devepos.adt.abaptags.ITag#getChangedDateTime()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_ChangedDateTime();

	/**
	 * Returns the meta object for the reference '{@link com.devepos.adt.abaptags.ITag#getParentTag <em>Parent Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Tag</em>'.
	 * @see com.devepos.adt.abaptags.ITag#getParentTag()
	 * @see #getTag()
	 * @generated
	 */
	EReference getTag_ParentTag();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.ITag#getTaggedObjectCount <em>Tagged Object Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tagged Object Count</em>'.
	 * @see com.devepos.adt.abaptags.ITag#getTaggedObjectCount()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_TaggedObjectCount();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.ITag#isChanged <em>Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Changed</em>'.
	 * @see com.devepos.adt.abaptags.ITag#isChanged()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Changed();

	/**
	 * Returns the meta object for class '{@link com.devepos.adt.abaptags.IAbapObjectWithTag <em>Abap Object With Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abap Object With Tag</em>'.
	 * @see com.devepos.adt.abaptags.IAbapObjectWithTag
	 * @generated
	 */
	EClass getAbapObjectWithTag();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getObjectName <em>Object Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Name</em>'.
	 * @see com.devepos.adt.abaptags.IAbapObjectWithTag#getObjectName()
	 * @see #getAbapObjectWithTag()
	 * @generated
	 */
	EAttribute getAbapObjectWithTag_ObjectName();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getObjectType <em>Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Type</em>'.
	 * @see com.devepos.adt.abaptags.IAbapObjectWithTag#getObjectType()
	 * @see #getAbapObjectWithTag()
	 * @generated
	 */
	EAttribute getAbapObjectWithTag_ObjectType();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getParentObjectName <em>Parent Object Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Object Name</em>'.
	 * @see com.devepos.adt.abaptags.IAbapObjectWithTag#getParentObjectName()
	 * @see #getAbapObjectWithTag()
	 * @generated
	 */
	EAttribute getAbapObjectWithTag_ParentObjectName();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getParentObjectType <em>Parent Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Object Type</em>'.
	 * @see com.devepos.adt.abaptags.IAbapObjectWithTag#getParentObjectType()
	 * @see #getAbapObjectWithTag()
	 * @generated
	 */
	EAttribute getAbapObjectWithTag_ParentObjectType();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.IAbapObjectWithTag#getTagId <em>Tag Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag Id</em>'.
	 * @see com.devepos.adt.abaptags.IAbapObjectWithTag#getTagId()
	 * @see #getAbapObjectWithTag()
	 * @generated
	 */
	EAttribute getAbapObjectWithTag_TagId();

	/**
	 * Returns the meta object for class '{@link com.devepos.adt.abaptags.IAbapObjectWithTags <em>Abap Object With Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abap Object With Tags</em>'.
	 * @see com.devepos.adt.abaptags.IAbapObjectWithTags
	 * @generated
	 */
	EClass getAbapObjectWithTags();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.IAbapObjectWithTags#getObjectName <em>Object Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Name</em>'.
	 * @see com.devepos.adt.abaptags.IAbapObjectWithTags#getObjectName()
	 * @see #getAbapObjectWithTags()
	 * @generated
	 */
	EAttribute getAbapObjectWithTags_ObjectName();

	/**
	 * Returns the meta object for the attribute '{@link com.devepos.adt.abaptags.IAbapObjectWithTags#getObjectType <em>Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Type</em>'.
	 * @see com.devepos.adt.abaptags.IAbapObjectWithTags#getObjectType()
	 * @see #getAbapObjectWithTags()
	 * @generated
	 */
	EAttribute getAbapObjectWithTags_ObjectType();

	/**
	 * Returns the meta object for the containment reference list '{@link com.devepos.adt.abaptags.IAbapObjectWithTags#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tag</em>'.
	 * @see com.devepos.adt.abaptags.IAbapObjectWithTags#getTag()
	 * @see #getAbapObjectWithTags()
	 * @generated
	 */
	EReference getAbapObjectWithTags_Tag();

	/**
	 * Returns the meta object for class '{@link com.devepos.adt.abaptags.IAbapObjectsWithTags <em>Abap Objects With Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abap Objects With Tags</em>'.
	 * @see com.devepos.adt.abaptags.IAbapObjectsWithTags
	 * @generated
	 */
	EClass getAbapObjectsWithTags();

	/**
	 * Returns the meta object for the containment reference list '{@link com.devepos.adt.abaptags.IAbapObjectsWithTags#getAbapObjectWithTags <em>Abap Object With Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Abap Object With Tags</em>'.
	 * @see com.devepos.adt.abaptags.IAbapObjectsWithTags#getAbapObjectWithTags()
	 * @see #getAbapObjectsWithTags()
	 * @generated
	 */
	EReference getAbapObjectsWithTags_AbapObjectWithTags();

	/**
	 * Returns the meta object for class '{@link com.devepos.adt.abaptags.IAbapObjectsWithTag <em>Abap Objects With Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abap Objects With Tag</em>'.
	 * @see com.devepos.adt.abaptags.IAbapObjectsWithTag
	 * @generated
	 */
	EClass getAbapObjectsWithTag();

	/**
	 * Returns the meta object for the containment reference list '{@link com.devepos.adt.abaptags.IAbapObjectsWithTag#getAbapObjectWithTag <em>Abap Object With Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Abap Object With Tag</em>'.
	 * @see com.devepos.adt.abaptags.IAbapObjectsWithTag#getAbapObjectWithTag()
	 * @see #getAbapObjectsWithTag()
	 * @generated
	 */
	EReference getAbapObjectsWithTag_AbapObjectWithTag();

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
		 * The meta object literal for the '{@link com.devepos.adt.abaptags.impl.Tags <em>Tags</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.abaptags.impl.Tags
		 * @see com.devepos.adt.abaptags.impl.AbapTagsPackage#getTags()
		 * @generated
		 */
		EClass TAGS = eINSTANCE.getTags();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAGS__TAGS = eINSTANCE.getTags_Tags();

		/**
		 * The meta object literal for the '{@link com.devepos.adt.abaptags.impl.Tag <em>Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.abaptags.impl.Tag
		 * @see com.devepos.adt.abaptags.impl.AbapTagsPackage#getTag()
		 * @generated
		 */
		EClass TAG = eINSTANCE.getTag();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__ID = eINSTANCE.getTag_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__NAME = eINSTANCE.getTag_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__DESCRIPTION = eINSTANCE.getTag_Description();

		/**
		 * The meta object literal for the '<em><b>Child Tag</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG__CHILD_TAG = eINSTANCE.getTag_ChildTag();

		/**
		 * The meta object literal for the '<em><b>Is Root</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__IS_ROOT = eINSTANCE.getTag_IsRoot();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__OWNER = eINSTANCE.getTag_Owner();

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
		 * The meta object literal for the '<em><b>Parent Tag</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG__PARENT_TAG = eINSTANCE.getTag_ParentTag();

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
		 * The meta object literal for the '{@link com.devepos.adt.abaptags.impl.AbapObjectWithTag <em>Abap Object With Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.abaptags.impl.AbapObjectWithTag
		 * @see com.devepos.adt.abaptags.impl.AbapTagsPackage#getAbapObjectWithTag()
		 * @generated
		 */
		EClass ABAP_OBJECT_WITH_TAG = eINSTANCE.getAbapObjectWithTag();

		/**
		 * The meta object literal for the '<em><b>Object Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABAP_OBJECT_WITH_TAG__OBJECT_NAME = eINSTANCE.getAbapObjectWithTag_ObjectName();

		/**
		 * The meta object literal for the '<em><b>Object Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABAP_OBJECT_WITH_TAG__OBJECT_TYPE = eINSTANCE.getAbapObjectWithTag_ObjectType();

		/**
		 * The meta object literal for the '<em><b>Parent Object Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_NAME = eINSTANCE.getAbapObjectWithTag_ParentObjectName();

		/**
		 * The meta object literal for the '<em><b>Parent Object Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_TYPE = eINSTANCE.getAbapObjectWithTag_ParentObjectType();

		/**
		 * The meta object literal for the '<em><b>Tag Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABAP_OBJECT_WITH_TAG__TAG_ID = eINSTANCE.getAbapObjectWithTag_TagId();

		/**
		 * The meta object literal for the '{@link com.devepos.adt.abaptags.impl.AbapObjectWithTags <em>Abap Object With Tags</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.abaptags.impl.AbapObjectWithTags
		 * @see com.devepos.adt.abaptags.impl.AbapTagsPackage#getAbapObjectWithTags()
		 * @generated
		 */
		EClass ABAP_OBJECT_WITH_TAGS = eINSTANCE.getAbapObjectWithTags();

		/**
		 * The meta object literal for the '<em><b>Object Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABAP_OBJECT_WITH_TAGS__OBJECT_NAME = eINSTANCE.getAbapObjectWithTags_ObjectName();

		/**
		 * The meta object literal for the '<em><b>Object Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABAP_OBJECT_WITH_TAGS__OBJECT_TYPE = eINSTANCE.getAbapObjectWithTags_ObjectType();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABAP_OBJECT_WITH_TAGS__TAG = eINSTANCE.getAbapObjectWithTags_Tag();

		/**
		 * The meta object literal for the '{@link com.devepos.adt.abaptags.impl.AbapObjectsWithTags <em>Abap Objects With Tags</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.abaptags.impl.AbapObjectsWithTags
		 * @see com.devepos.adt.abaptags.impl.AbapTagsPackage#getAbapObjectsWithTags()
		 * @generated
		 */
		EClass ABAP_OBJECTS_WITH_TAGS = eINSTANCE.getAbapObjectsWithTags();

		/**
		 * The meta object literal for the '<em><b>Abap Object With Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABAP_OBJECTS_WITH_TAGS__ABAP_OBJECT_WITH_TAGS = eINSTANCE.getAbapObjectsWithTags_AbapObjectWithTags();

		/**
		 * The meta object literal for the '{@link com.devepos.adt.abaptags.impl.AbapObjectsWithTag <em>Abap Objects With Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.devepos.adt.abaptags.impl.AbapObjectsWithTag
		 * @see com.devepos.adt.abaptags.impl.AbapTagsPackage#getAbapObjectsWithTag()
		 * @generated
		 */
		EClass ABAP_OBJECTS_WITH_TAG = eINSTANCE.getAbapObjectsWithTag();

		/**
		 * The meta object literal for the '<em><b>Abap Object With Tag</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABAP_OBJECTS_WITH_TAG__ABAP_OBJECT_WITH_TAG = eINSTANCE.getAbapObjectsWithTag_AbapObjectWithTag();

	}

} //IAbapTagsPackage
