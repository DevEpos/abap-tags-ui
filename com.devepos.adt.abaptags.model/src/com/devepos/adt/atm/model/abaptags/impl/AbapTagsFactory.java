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
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.ITagPreviewInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.model.abaptags.ResultGroupLevel;
import com.devepos.adt.atm.model.abaptags.TagInfoType;
import com.devepos.adt.atm.model.abaptags.TagQueryFocus;
import com.devepos.adt.atm.model.abaptags.TagQueryType;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;

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
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS:
      return createTaggedObjectSearchParams();
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
