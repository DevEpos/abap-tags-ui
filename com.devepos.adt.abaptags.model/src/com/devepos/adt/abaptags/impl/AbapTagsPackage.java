/**
 */
package com.devepos.adt.abaptags.impl;

import com.devepos.adt.abaptags.IAbapTagsFactory;
import com.devepos.adt.abaptags.IAbapTagsPackage;
import com.devepos.adt.abaptags.IAdtObjectTag;
import com.devepos.adt.abaptags.ITag;
import com.devepos.adt.abaptags.ITagBase;
import com.devepos.adt.abaptags.ITagList;
import com.devepos.adt.abaptags.ITagPreviewInfo;
import com.devepos.adt.abaptags.ITaggedObject;
import com.devepos.adt.abaptags.ITaggedObjectList;

import com.devepos.adt.tools.base.model.adtbase.IAdtBasePackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AbapTagsPackage extends EPackageImpl implements IAbapTagsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adtObjectTagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagPreviewInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taggedObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taggedObjectListEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AbapTagsPackage() {
		super(eNS_URI, IAbapTagsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link IAbapTagsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IAbapTagsPackage init() {
		if (isInited) return (IAbapTagsPackage)EPackage.Registry.INSTANCE.getEPackage(IAbapTagsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredAbapTagsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AbapTagsPackage theAbapTagsPackage = registeredAbapTagsPackage instanceof AbapTagsPackage ? (AbapTagsPackage)registeredAbapTagsPackage : new AbapTagsPackage();

		isInited = true;

		// Initialize simple dependencies
		IAdtBasePackage.eINSTANCE.eClass();

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTagBase() {
		return tagBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTagBase_Id() {
		return (EAttribute)tagBaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTagBase_Name() {
		return (EAttribute)tagBaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTag() {
		return tagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_Description() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTag_ChildTags() {
		return (EReference)tagEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_IsRoot() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_Owner() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_CreatedBy() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_CreatedDateTime() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_ChangedBy() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_ChangedDateTime() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_TaggedObjectCount() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_Changed() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_ParentTagId() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAdtObjectTag() {
		return adtObjectTagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAdtObjectTag_ParentObjectName() {
		return (EAttribute)adtObjectTagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAdtObjectTag_ParentObjectType() {
		return (EAttribute)adtObjectTagEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAdtObjectTag_ParentObjectUri() {
		return (EAttribute)adtObjectTagEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTagList() {
		return tagListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTagList_Tags() {
		return (EReference)tagListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTagPreviewInfo() {
		return tagPreviewInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTagPreviewInfo_Tags() {
		return (EReference)tagPreviewInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTagPreviewInfo_AdtObjectRefs() {
		return (EReference)tagPreviewInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTaggedObject() {
		return taggedObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTaggedObject_Tags() {
		return (EReference)taggedObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTaggedObject_ObjectRef() {
		return (EReference)taggedObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTaggedObjectList() {
		return taggedObjectListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTaggedObjectList_TaggedObjects() {
		return (EReference)taggedObjectListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IAbapTagsFactory getAbapTagsFactory() {
		return (IAbapTagsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		tagBaseEClass = createEClass(TAG_BASE);
		createEAttribute(tagBaseEClass, TAG_BASE__ID);
		createEAttribute(tagBaseEClass, TAG_BASE__NAME);

		tagEClass = createEClass(TAG);
		createEAttribute(tagEClass, TAG__DESCRIPTION);
		createEReference(tagEClass, TAG__CHILD_TAGS);
		createEAttribute(tagEClass, TAG__IS_ROOT);
		createEAttribute(tagEClass, TAG__OWNER);
		createEAttribute(tagEClass, TAG__CREATED_BY);
		createEAttribute(tagEClass, TAG__CREATED_DATE_TIME);
		createEAttribute(tagEClass, TAG__CHANGED_BY);
		createEAttribute(tagEClass, TAG__CHANGED_DATE_TIME);
		createEAttribute(tagEClass, TAG__TAGGED_OBJECT_COUNT);
		createEAttribute(tagEClass, TAG__CHANGED);
		createEAttribute(tagEClass, TAG__PARENT_TAG_ID);

		adtObjectTagEClass = createEClass(ADT_OBJECT_TAG);
		createEAttribute(adtObjectTagEClass, ADT_OBJECT_TAG__PARENT_OBJECT_NAME);
		createEAttribute(adtObjectTagEClass, ADT_OBJECT_TAG__PARENT_OBJECT_TYPE);
		createEAttribute(adtObjectTagEClass, ADT_OBJECT_TAG__PARENT_OBJECT_URI);

		tagListEClass = createEClass(TAG_LIST);
		createEReference(tagListEClass, TAG_LIST__TAGS);

		tagPreviewInfoEClass = createEClass(TAG_PREVIEW_INFO);
		createEReference(tagPreviewInfoEClass, TAG_PREVIEW_INFO__TAGS);
		createEReference(tagPreviewInfoEClass, TAG_PREVIEW_INFO__ADT_OBJECT_REFS);

		taggedObjectEClass = createEClass(TAGGED_OBJECT);
		createEReference(taggedObjectEClass, TAGGED_OBJECT__OBJECT_REF);
		createEReference(taggedObjectEClass, TAGGED_OBJECT__TAGS);

		taggedObjectListEClass = createEClass(TAGGED_OBJECT_LIST);
		createEReference(taggedObjectListEClass, TAGGED_OBJECT_LIST__TAGGED_OBJECTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		IAdtBasePackage theAdtBasePackage = (IAdtBasePackage)EPackage.Registry.INSTANCE.getEPackage(IAdtBasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tagEClass.getESuperTypes().add(this.getTagBase());
		adtObjectTagEClass.getESuperTypes().add(this.getTagBase());

		// Initialize classes, features, and operations; add parameters
		initEClass(tagBaseEClass, ITagBase.class, "TagBase", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTagBase_Id(), ecorePackage.getEString(), "id", null, 0, 1, ITagBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTagBase_Name(), ecorePackage.getEString(), "name", "", 0, 1, ITagBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tagEClass, ITag.class, "Tag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTag_Description(), ecorePackage.getEString(), "description", "", 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTag_ChildTags(), this.getTag(), null, "childTags", null, 0, -1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_IsRoot(), ecorePackage.getEBoolean(), "isRoot", null, 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_Owner(), ecorePackage.getEString(), "owner", "", 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_CreatedBy(), ecorePackage.getEString(), "createdBy", "", 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_CreatedDateTime(), ecorePackage.getEString(), "createdDateTime", "", 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_ChangedBy(), ecorePackage.getEString(), "changedBy", "", 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_ChangedDateTime(), ecorePackage.getEString(), "changedDateTime", "", 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_TaggedObjectCount(), ecorePackage.getEInt(), "taggedObjectCount", null, 0, 1, ITag.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_Changed(), ecorePackage.getEBoolean(), "changed", null, 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_ParentTagId(), ecorePackage.getEString(), "parentTagId", null, 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adtObjectTagEClass, IAdtObjectTag.class, "AdtObjectTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdtObjectTag_ParentObjectName(), ecorePackage.getEString(), "parentObjectName", null, 0, 1, IAdtObjectTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdtObjectTag_ParentObjectType(), ecorePackage.getEString(), "parentObjectType", null, 0, 1, IAdtObjectTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdtObjectTag_ParentObjectUri(), ecorePackage.getEString(), "parentObjectUri", null, 0, 1, IAdtObjectTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tagListEClass, ITagList.class, "TagList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTagList_Tags(), this.getTag(), null, "tags", null, 0, -1, ITagList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tagPreviewInfoEClass, ITagPreviewInfo.class, "TagPreviewInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTagPreviewInfo_Tags(), this.getTag(), null, "tags", null, 0, -1, ITagPreviewInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTagPreviewInfo_AdtObjectRefs(), theAdtBasePackage.getAdtObjRef(), null, "adtObjectRefs", null, 0, -1, ITagPreviewInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taggedObjectEClass, ITaggedObject.class, "TaggedObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTaggedObject_ObjectRef(), theAdtBasePackage.getAdtObjRef(), null, "objectRef", null, 0, 1, ITaggedObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTaggedObject_Tags(), this.getAdtObjectTag(), null, "tags", null, 0, -1, ITaggedObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taggedObjectListEClass, ITaggedObjectList.class, "TaggedObjectList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTaggedObjectList_TaggedObjects(), this.getTaggedObject(), null, "taggedObjects", null, 0, -1, ITaggedObjectList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation
		  (tagBaseEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "tagBase"
		   });
		addAnnotation
		  (getTagBase_Id(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "id",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTagBase_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (tagEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "tag"
		   });
		addAnnotation
		  (getTag_Description(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "description",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTag_ChildTags(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "tag",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTag_IsRoot(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "isRoot",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTag_Owner(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "owner",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTag_CreatedBy(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "createdBy",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTag_CreatedDateTime(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "createdDateTime",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTag_ChangedBy(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "changedBy",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTag_ChangedDateTime(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "changedDateTime",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTag_TaggedObjectCount(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "taggedObjectCount",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTag_Changed(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "changed",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTag_ParentTagId(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "parentTagId",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (adtObjectTagEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "adtObjectTag"
		   });
		addAnnotation
		  (getAdtObjectTag_ParentObjectName(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "parentObjectName",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAdtObjectTag_ParentObjectType(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "parentObjectType",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAdtObjectTag_ParentObjectUri(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "parentObjectUri",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (tagListEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "tags"
		   });
		addAnnotation
		  (getTagList_Tags(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "tag",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (tagPreviewInfoEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "tagPreviewInfo"
		   });
		addAnnotation
		  (getTagPreviewInfo_Tags(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "tag",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTagPreviewInfo_AdtObjectRefs(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "adtObjRef",
			   "namespace", "http://www.devepos.com/adt/base"
		   });
		addAnnotation
		  (taggedObjectEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "taggedObject"
		   });
		addAnnotation
		  (getTaggedObject_ObjectRef(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "adtObjRef",
			   "namespace", "http://www.devepos.com/adt/base"
		   });
		addAnnotation
		  (getTaggedObject_Tags(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "adtObjectTag",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (taggedObjectListEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "taggedObjects"
		   });
		addAnnotation
		  (getTaggedObjectList_TaggedObjects(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "taggedObject",
			   "namespace", "##targetNamespace"
		   });
	}

} //AbapTagsPackage
