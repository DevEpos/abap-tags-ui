/**
 */
package com.devepos.adt.abaptags.impl;

import com.devepos.adt.abaptags.IAbapObjectWithTag;
import com.devepos.adt.abaptags.IAbapObjectWithTags;
import com.devepos.adt.abaptags.IAbapObjectsWithTag;
import com.devepos.adt.abaptags.IAbapObjectsWithTags;
import com.devepos.adt.abaptags.IAbapTagsFactory;
import com.devepos.adt.abaptags.IAbapTagsPackage;
import com.devepos.adt.abaptags.ITag;
import com.devepos.adt.abaptags.ITags;

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
	private EClass tagsEClass = null;

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
	private EClass abapObjectWithTagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abapObjectWithTagsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abapObjectsWithTagsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abapObjectsWithTagEClass = null;

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
	public EClass getTags() {
		return tagsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTags_Tags() {
		return (EReference)tagsEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getTag_Id() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_Name() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_Description() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTag_ChildTag() {
		return (EReference)tagEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_IsRoot() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_Owner() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_CreatedBy() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_CreatedDateTime() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_ChangedBy() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_ChangedDateTime() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTag_ParentTag() {
		return (EReference)tagEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_TaggedObjectCount() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTag_Changed() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbapObjectWithTag() {
		return abapObjectWithTagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbapObjectWithTag_ObjectName() {
		return (EAttribute)abapObjectWithTagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbapObjectWithTag_ObjectType() {
		return (EAttribute)abapObjectWithTagEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbapObjectWithTag_ParentObjectName() {
		return (EAttribute)abapObjectWithTagEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbapObjectWithTag_ParentObjectType() {
		return (EAttribute)abapObjectWithTagEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbapObjectWithTag_TagId() {
		return (EAttribute)abapObjectWithTagEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbapObjectWithTags() {
		return abapObjectWithTagsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbapObjectWithTags_ObjectName() {
		return (EAttribute)abapObjectWithTagsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbapObjectWithTags_ObjectType() {
		return (EAttribute)abapObjectWithTagsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbapObjectWithTags_Tag() {
		return (EReference)abapObjectWithTagsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbapObjectsWithTags() {
		return abapObjectsWithTagsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbapObjectsWithTags_AbapObjectWithTags() {
		return (EReference)abapObjectsWithTagsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbapObjectsWithTag() {
		return abapObjectsWithTagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbapObjectsWithTag_AbapObjectWithTag() {
		return (EReference)abapObjectsWithTagEClass.getEStructuralFeatures().get(0);
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
		tagsEClass = createEClass(TAGS);
		createEReference(tagsEClass, TAGS__TAGS);

		tagEClass = createEClass(TAG);
		createEAttribute(tagEClass, TAG__ID);
		createEAttribute(tagEClass, TAG__NAME);
		createEAttribute(tagEClass, TAG__DESCRIPTION);
		createEReference(tagEClass, TAG__CHILD_TAG);
		createEAttribute(tagEClass, TAG__IS_ROOT);
		createEAttribute(tagEClass, TAG__OWNER);
		createEAttribute(tagEClass, TAG__CREATED_BY);
		createEAttribute(tagEClass, TAG__CREATED_DATE_TIME);
		createEAttribute(tagEClass, TAG__CHANGED_BY);
		createEAttribute(tagEClass, TAG__CHANGED_DATE_TIME);
		createEReference(tagEClass, TAG__PARENT_TAG);
		createEAttribute(tagEClass, TAG__TAGGED_OBJECT_COUNT);
		createEAttribute(tagEClass, TAG__CHANGED);

		abapObjectWithTagEClass = createEClass(ABAP_OBJECT_WITH_TAG);
		createEAttribute(abapObjectWithTagEClass, ABAP_OBJECT_WITH_TAG__OBJECT_NAME);
		createEAttribute(abapObjectWithTagEClass, ABAP_OBJECT_WITH_TAG__OBJECT_TYPE);
		createEAttribute(abapObjectWithTagEClass, ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_NAME);
		createEAttribute(abapObjectWithTagEClass, ABAP_OBJECT_WITH_TAG__PARENT_OBJECT_TYPE);
		createEAttribute(abapObjectWithTagEClass, ABAP_OBJECT_WITH_TAG__TAG_ID);

		abapObjectWithTagsEClass = createEClass(ABAP_OBJECT_WITH_TAGS);
		createEAttribute(abapObjectWithTagsEClass, ABAP_OBJECT_WITH_TAGS__OBJECT_NAME);
		createEAttribute(abapObjectWithTagsEClass, ABAP_OBJECT_WITH_TAGS__OBJECT_TYPE);
		createEReference(abapObjectWithTagsEClass, ABAP_OBJECT_WITH_TAGS__TAG);

		abapObjectsWithTagsEClass = createEClass(ABAP_OBJECTS_WITH_TAGS);
		createEReference(abapObjectsWithTagsEClass, ABAP_OBJECTS_WITH_TAGS__ABAP_OBJECT_WITH_TAGS);

		abapObjectsWithTagEClass = createEClass(ABAP_OBJECTS_WITH_TAG);
		createEReference(abapObjectsWithTagEClass, ABAP_OBJECTS_WITH_TAG__ABAP_OBJECT_WITH_TAG);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(tagsEClass, ITags.class, "Tags", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTags_Tags(), this.getTag(), null, "tags", null, 0, -1, ITags.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tagEClass, ITag.class, "Tag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTag_Id(), ecorePackage.getEString(), "id", null, 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_Name(), ecorePackage.getEString(), "name", "", 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_Description(), ecorePackage.getEString(), "description", "", 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTag_ChildTag(), this.getTag(), null, "childTag", null, 0, -1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_IsRoot(), ecorePackage.getEBoolean(), "isRoot", null, 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_Owner(), ecorePackage.getEString(), "owner", "", 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_CreatedBy(), ecorePackage.getEString(), "createdBy", "", 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_CreatedDateTime(), ecorePackage.getEString(), "createdDateTime", "", 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_ChangedBy(), ecorePackage.getEString(), "changedBy", "", 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_ChangedDateTime(), ecorePackage.getEString(), "changedDateTime", "", 0, 1, ITag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTag_ParentTag(), this.getTag(), null, "parentTag", null, 0, 1, ITag.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_TaggedObjectCount(), ecorePackage.getEInt(), "taggedObjectCount", null, 0, 1, ITag.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_Changed(), ecorePackage.getEBoolean(), "changed", null, 0, 1, ITag.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abapObjectWithTagEClass, IAbapObjectWithTag.class, "AbapObjectWithTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbapObjectWithTag_ObjectName(), ecorePackage.getEString(), "objectName", null, 0, 1, IAbapObjectWithTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbapObjectWithTag_ObjectType(), ecorePackage.getEString(), "objectType", null, 0, 1, IAbapObjectWithTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbapObjectWithTag_ParentObjectName(), ecorePackage.getEString(), "parentObjectName", null, 0, 1, IAbapObjectWithTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbapObjectWithTag_ParentObjectType(), ecorePackage.getEString(), "parentObjectType", null, 0, 1, IAbapObjectWithTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbapObjectWithTag_TagId(), ecorePackage.getEString(), "tagId", null, 0, 1, IAbapObjectWithTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abapObjectWithTagsEClass, IAbapObjectWithTags.class, "AbapObjectWithTags", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbapObjectWithTags_ObjectName(), ecorePackage.getEString(), "objectName", null, 0, 1, IAbapObjectWithTags.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbapObjectWithTags_ObjectType(), ecorePackage.getEString(), "objectType", null, 0, 1, IAbapObjectWithTags.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbapObjectWithTags_Tag(), this.getTag(), null, "tag", null, 0, -1, IAbapObjectWithTags.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abapObjectsWithTagsEClass, IAbapObjectsWithTags.class, "AbapObjectsWithTags", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbapObjectsWithTags_AbapObjectWithTags(), this.getAbapObjectWithTags(), null, "abapObjectWithTags", null, 1, -1, IAbapObjectsWithTags.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abapObjectsWithTagEClass, IAbapObjectsWithTag.class, "AbapObjectsWithTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbapObjectsWithTag_AbapObjectWithTag(), this.getAbapObjectWithTag(), null, "abapObjectWithTag", null, 1, -1, IAbapObjectsWithTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (tagsEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "tags"
		   });
		addAnnotation
		  (getTags_Tags(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "tag",
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
		  (getTag_Id(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "id",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getTag_Name(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "name",
			   "namespace", "##targetNamespace"
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
		  (getTag_ChildTag(),
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
		  (abapObjectWithTagEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "abapObjectWithTag"
		   });
		addAnnotation
		  (getAbapObjectWithTag_ObjectName(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "objectName",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAbapObjectWithTag_ObjectType(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "objectType",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAbapObjectWithTag_ParentObjectName(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "parentObjectName",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAbapObjectWithTag_ParentObjectType(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "parentObjectType",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAbapObjectWithTag_TagId(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "tagId",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (abapObjectWithTagsEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "abapObjectWithTags"
		   });
		addAnnotation
		  (getAbapObjectWithTags_ObjectName(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "objectName",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAbapObjectWithTags_ObjectType(),
		   source,
		   new String[] {
			   "kind", "attribute",
			   "name", "objectType",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (getAbapObjectWithTags_Tag(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "tag",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (abapObjectsWithTagsEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "abapObjectsWithTags"
		   });
		addAnnotation
		  (getAbapObjectsWithTags_AbapObjectWithTags(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "abapObjectWithTags",
			   "namespace", "##targetNamespace"
		   });
		addAnnotation
		  (abapObjectsWithTagEClass,
		   source,
		   new String[] {
			   "kind", "elementOnly",
			   "name", "abapObjectsWithTag"
		   });
		addAnnotation
		  (getAbapObjectsWithTag_AbapObjectWithTag(),
		   source,
		   new String[] {
			   "kind", "element",
			   "name", "abapObjectWithTag",
			   "namespace", "##targetNamespace"
		   });
	}

} //AbapTagsPackage
