/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.swt.graphics.Image;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;
import com.devepos.adt.atm.model.abaptags.ITag;
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

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class AbapTagsFactory extends EFactoryImpl implements IAbapTagsFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  public static IAbapTagsFactory init() {
    try {
      IAbapTagsFactory theAbapTagsFactory = (IAbapTagsFactory) EPackage.Registry.INSTANCE
          .getEFactory(IAbapTagsPackage.eNS_URI);
      if (theAbapTagsFactory != null) {
        return theAbapTagsFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AbapTagsFactory();
  }

  /**
   * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   */
  public AbapTagsFactory() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EObject create(final EClass eClass) {
    switch (eClass.getClassifierID()) {
    case IAbapTagsPackage.TAG:
      return createTag();
    case IAbapTagsPackage.TAG_LIST:
      return createTagList();
    case IAbapTagsPackage.ADT_OBJECT_TAG:
      return createAdtObjectTag();
    case IAbapTagsPackage.TAG_PREVIEW_INFO:
      return createTagPreviewInfo();
    case IAbapTagsPackage.TAGGED_OBJECT:
      return createTaggedObject();
    case IAbapTagsPackage.TAGGED_OBJECT_LIST:
      return createTaggedObjectList();
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_REQUEST:
      return createTaggedObjectTreeRequest();
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS:
      return createTaggedObjectSearchParams();
    case IAbapTagsPackage.TAG_DELETION_CHECK_RESULT:
      return createTagDeletionCheckResult();
    case IAbapTagsPackage.TAG_DELETION_CHECK_OBJECT:
      return createTagDeletionCheckObject();
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_OBJECT:
      return createTaggedObjectTreeObject();
    case IAbapTagsPackage.TAGGED_OBJECT_TREE_RESULT:
      return createTaggedObjectTreeResult();
    case IAbapTagsPackage.TAGGED_OBJECT_LIST_REQUEST:
      return createTaggedObjectListRequest();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO:
      return createTaggedObjectInfo();
    case IAbapTagsPackage.TAGGED_OBJECT_INFO_LIST:
      return createTaggedObjectInfoList();
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_REQUEST:
      return createTaggedObjectDeletionCheckRequest();
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_RESULT:
      return createTaggedObjectDeletionCheckResult();
    case IAbapTagsPackage.TAGGED_OBJECT_DELETION_CHECK_OBJECT:
      return createTaggedObjectDeletionCheckObject();
    case IAbapTagsPackage.TAGGED_OBJECT_DELETE_REQUEST:
      return createTaggedObjectDeleteRequest();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName()
          + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object createFromString(final EDataType eDataType, final String initialValue) {
    switch (eDataType.getClassifierID()) {
    case IAbapTagsPackage.TAG_SEARCH_SCOPE:
      return createTagSearchScopeFromString(eDataType, initialValue);
    case IAbapTagsPackage.TAG_QUERY_TYPE:
      return createTagQueryTypeFromString(eDataType, initialValue);
    case IAbapTagsPackage.TAG_INFO_TYPE:
      return createTagInfoTypeFromString(eDataType, initialValue);
    case IAbapTagsPackage.TAG_QUERY_FOCUS:
      return createTagQueryFocusFromString(eDataType, initialValue);
    case IAbapTagsPackage.RESULT_GROUP_LEVEL:
      return createResultGroupLevelFromString(eDataType, initialValue);
    case IAbapTagsPackage.TAG_TYPE:
      return createTagTypeFromString(eDataType, initialValue);
    case IAbapTagsPackage.IMAGE:
      return createImageFromString(eDataType, initialValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName()
          + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String convertToString(final EDataType eDataType, final Object instanceValue) {
    switch (eDataType.getClassifierID()) {
    case IAbapTagsPackage.TAG_SEARCH_SCOPE:
      return convertTagSearchScopeToString(eDataType, instanceValue);
    case IAbapTagsPackage.TAG_QUERY_TYPE:
      return convertTagQueryTypeToString(eDataType, instanceValue);
    case IAbapTagsPackage.TAG_INFO_TYPE:
      return convertTagInfoTypeToString(eDataType, instanceValue);
    case IAbapTagsPackage.TAG_QUERY_FOCUS:
      return convertTagQueryFocusToString(eDataType, instanceValue);
    case IAbapTagsPackage.RESULT_GROUP_LEVEL:
      return convertResultGroupLevelToString(eDataType, instanceValue);
    case IAbapTagsPackage.TAG_TYPE:
      return convertTagTypeToString(eDataType, instanceValue);
    case IAbapTagsPackage.IMAGE:
      return convertImageToString(eDataType, instanceValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName()
          + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITag createTag() {
    Tag tag = new Tag();
    return tag;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IAdtObjectTag createAdtObjectTag() {
    AdtObjectTag adtObjectTag = new AdtObjectTag();
    return adtObjectTag;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITagList createTagList() {
    TagList tagList = new TagList();
    return tagList;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITagPreviewInfo createTagPreviewInfo() {
    TagPreviewInfo tagPreviewInfo = new TagPreviewInfo();
    return tagPreviewInfo;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITaggedObject createTaggedObject() {
    TaggedObject taggedObject = new TaggedObject();
    return taggedObject;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITaggedObjectList createTaggedObjectList() {
    TaggedObjectList taggedObjectList = new TaggedObjectList();
    return taggedObjectList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITaggedObjectTreeRequest createTaggedObjectTreeRequest() {
    TaggedObjectTreeRequest taggedObjectTreeRequest = new TaggedObjectTreeRequest();
    return taggedObjectTreeRequest;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITaggedObjectSearchParams createTaggedObjectSearchParams() {
    TaggedObjectSearchParams taggedObjectSearchParams = new TaggedObjectSearchParams();
    return taggedObjectSearchParams;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITagDeletionCheckResult createTagDeletionCheckResult() {
    TagDeletionCheckResult tagDeletionCheckResult = new TagDeletionCheckResult();
    return tagDeletionCheckResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITagDeletionCheckObject createTagDeletionCheckObject() {
    TagDeletionCheckObject tagDeletionCheckObject = new TagDeletionCheckObject();
    return tagDeletionCheckObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITaggedObjectTreeObject createTaggedObjectTreeObject() {
    TaggedObjectTreeObject taggedObjectTreeObject = new TaggedObjectTreeObject();
    return taggedObjectTreeObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITaggedObjectTreeResult createTaggedObjectTreeResult() {
    TaggedObjectTreeResult taggedObjectTreeResult = new TaggedObjectTreeResult();
    return taggedObjectTreeResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITaggedObjectListRequest createTaggedObjectListRequest() {
    TaggedObjectListRequest taggedObjectListRequest = new TaggedObjectListRequest();
    return taggedObjectListRequest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITaggedObjectInfo createTaggedObjectInfo() {
    TaggedObjectInfo taggedObjectInfo = new TaggedObjectInfo();
    return taggedObjectInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITaggedObjectInfoList createTaggedObjectInfoList() {
    TaggedObjectInfoList taggedObjectInfoList = new TaggedObjectInfoList();
    return taggedObjectInfoList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITaggedObjectDeletionCheckRequest createTaggedObjectDeletionCheckRequest() {
    TaggedObjectDeletionCheckRequest taggedObjectDeletionCheckRequest = new TaggedObjectDeletionCheckRequest();
    return taggedObjectDeletionCheckRequest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITaggedObjectDeletionCheckResult createTaggedObjectDeletionCheckResult() {
    TaggedObjectDeletionCheckResult taggedObjectDeletionCheckResult = new TaggedObjectDeletionCheckResult();
    return taggedObjectDeletionCheckResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITaggedObjectDeletionCheckObject createTaggedObjectDeletionCheckObject() {
    TaggedObjectDeletionCheckObject taggedObjectDeletionCheckObject = new TaggedObjectDeletionCheckObject();
    return taggedObjectDeletionCheckObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ITaggedObjectDeleteRequest createTaggedObjectDeleteRequest() {
    TaggedObjectDeleteRequest taggedObjectDeleteRequest = new TaggedObjectDeleteRequest();
    return taggedObjectDeleteRequest;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public TagSearchScope createTagSearchScopeFromString(final EDataType eDataType,
      final String initialValue) {
    TagSearchScope result = TagSearchScope.get(initialValue);
    if (result == null) {
      throw new IllegalArgumentException("The value '" + initialValue
          + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertTagSearchScopeToString(final EDataType eDataType,
      final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public TagQueryType createTagQueryTypeFromString(final EDataType eDataType,
      final String initialValue) {
    TagQueryType result = TagQueryType.get(initialValue);
    if (result == null) {
      throw new IllegalArgumentException("The value '" + initialValue
          + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertTagQueryTypeToString(final EDataType eDataType, final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public TagInfoType createTagInfoTypeFromString(final EDataType eDataType,
      final String initialValue) {
    TagInfoType result = TagInfoType.get(initialValue);
    if (result == null) {
      throw new IllegalArgumentException("The value '" + initialValue
          + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertTagInfoTypeToString(final EDataType eDataType, final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public TagQueryFocus createTagQueryFocusFromString(final EDataType eDataType,
      final String initialValue) {
    TagQueryFocus result = TagQueryFocus.get(initialValue);
    if (result == null) {
      throw new IllegalArgumentException("The value '" + initialValue
          + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertTagQueryFocusToString(final EDataType eDataType,
      final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public ResultGroupLevel createResultGroupLevelFromString(final EDataType eDataType,
      final String initialValue) {
    ResultGroupLevel result = ResultGroupLevel.get(initialValue);
    if (result == null) {
      throw new IllegalArgumentException("The value '" + initialValue
          + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    }
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertResultGroupLevelToString(final EDataType eDataType,
      final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public TagType createTagTypeFromString(final EDataType eDataType, final String initialValue) {
    TagType result = TagType.get(initialValue);
    if (result == null) {
      throw new IllegalArgumentException("The value '" + initialValue
          + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    }
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertTagTypeToString(final EDataType eDataType, final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public Image createImageFromString(final EDataType eDataType, final String initialValue) {
    return (Image) super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertImageToString(final EDataType eDataType, final Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public IAbapTagsPackage getAbapTagsPackage() {
    return (IAbapTagsPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @deprecated
   * @generated
   */
  @Deprecated
  public static IAbapTagsPackage getPackage() {
    return IAbapTagsPackage.eINSTANCE;
  }

} // AbapTagsFactory
