/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Object Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getId <em>Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getTagId <em>Tag Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getTagName <em>Tag
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getTagType <em>Tag
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getObjectName <em>Object
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getObjectAltName <em>Object Alt
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getObjectType <em>Object
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getComponentName <em>Component
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getComponentType <em>Component
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getParentTagId <em>Parent Tag
 * Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getParentTagName <em>Parent Tag
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getParentObjectName <em>Parent
 * Object Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getParentObjectAltName <em>Parent
 * Object Alt Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getParentObjectType <em>Parent
 * Object Type</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo()
 * @model extendedMetaData="kind='elementOnly' name='taggedObjectInfo'"
 * @generated
 */
public interface ITaggedObjectInfo extends EObject {
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo_Id()
   * @model extendedMetaData="kind='attribute' name='id' namespace='##targetNamespace'"
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getId
   * <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Tag Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tag Id</em>' attribute.
   * @see #setTagId(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo_TagId()
   * @model extendedMetaData="kind='attribute' name='tagId' namespace='##targetNamespace'"
   * @generated
   */
  String getTagId();

  /**
   * Sets the value of the '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getTagId
   * <em>Tag Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Tag Id</em>' attribute.
   * @see #getTagId()
   * @generated
   */
  void setTagId(String value);

  /**
   * Returns the value of the '<em><b>Tag Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tag Name</em>' attribute.
   * @see #setTagName(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo_TagName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='tagName' namespace='##targetNamespace'"
   * @generated
   */
  String getTagName();

  /**
   * Sets the value of the '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getTagName
   * <em>Tag Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Tag Name</em>' attribute.
   * @see #getTagName()
   * @generated
   */
  void setTagName(String value);

  /**
   * Returns the value of the '<em><b>Tag Type</b></em>' attribute.
   * The literals are from the enumeration {@link com.devepos.adt.atm.model.abaptags.TagType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tag Type</em>' attribute.
   * @see com.devepos.adt.atm.model.abaptags.TagType
   * @see #setTagType(TagType)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo_TagType()
   * @model extendedMetaData="kind='attribute' namespace='##targetNamespace'"
   * @generated
   */
  TagType getTagType();

  /**
   * Sets the value of the '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getTagType
   * <em>Tag Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Tag Type</em>' attribute.
   * @see com.devepos.adt.atm.model.abaptags.TagType
   * @see #getTagType()
   * @generated
   */
  void setTagType(TagType value);

  /**
   * Returns the value of the '<em><b>Object Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Object Name</em>' attribute.
   * @see #setObjectName(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo_ObjectName()
   * @model extendedMetaData="kind='attribute' name='objectName' namespace='##targetNamespace'"
   * @generated
   */
  String getObjectName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getObjectName <em>Object
   * Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Object Name</em>' attribute.
   * @see #getObjectName()
   * @generated
   */
  void setObjectName(String value);

  /**
   * Returns the value of the '<em><b>Object Alt Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Object Alt Name</em>' attribute.
   * @see #setObjectAltName(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo_ObjectAltName()
   * @model extendedMetaData="kind='attribute' name='objectAltName' namespace='##targetNamespace'"
   * @generated
   */
  String getObjectAltName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getObjectAltName <em>Object Alt
   * Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Object Alt Name</em>' attribute.
   * @see #getObjectAltName()
   * @generated
   */
  void setObjectAltName(String value);

  /**
   * Returns the value of the '<em><b>Object Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Object Type</em>' attribute.
   * @see #setObjectType(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo_ObjectType()
   * @model extendedMetaData="kind='attribute' name='objectType' namespace='##targetNamespace'"
   * @generated
   */
  String getObjectType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getObjectType <em>Object
   * Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Object Type</em>' attribute.
   * @see #getObjectType()
   * @generated
   */
  void setObjectType(String value);

  /**
   * Returns the value of the '<em><b>Component Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Component Name</em>' attribute.
   * @see #setComponentName(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo_ComponentName()
   * @model extendedMetaData="kind='attribute' name='componentName' namespace='##targetNamespace'"
   * @generated
   */
  String getComponentName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getComponentName <em>Component
   * Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Component Name</em>' attribute.
   * @see #getComponentName()
   * @generated
   */
  void setComponentName(String value);

  /**
   * Returns the value of the '<em><b>Component Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Component Type</em>' attribute.
   * @see #setComponentType(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo_ComponentType()
   * @model extendedMetaData="kind='attribute' name='componentType' namespace='##targetNamespace'"
   * @generated
   */
  String getComponentType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getComponentType <em>Component
   * Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Component Type</em>' attribute.
   * @see #getComponentType()
   * @generated
   */
  void setComponentType(String value);

  /**
   * Returns the value of the '<em><b>Parent Tag Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Parent Tag Id</em>' attribute.
   * @see #setParentTagId(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo_ParentTagId()
   * @model extendedMetaData="kind='attribute' name='parentTagId' namespace='##targetNamespace'"
   * @generated
   */
  String getParentTagId();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getParentTagId <em>Parent Tag
   * Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Parent Tag Id</em>' attribute.
   * @see #getParentTagId()
   * @generated
   */
  void setParentTagId(String value);

  /**
   * Returns the value of the '<em><b>Parent Tag Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Parent Tag Name</em>' attribute.
   * @see #setParentTagName(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo_ParentTagName()
   * @model extendedMetaData="kind='attribute' name='parentTagName' namespace='##targetNamespace'"
   * @generated
   */
  String getParentTagName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getParentTagName <em>Parent Tag
   * Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Parent Tag Name</em>' attribute.
   * @see #getParentTagName()
   * @generated
   */
  void setParentTagName(String value);

  /**
   * Returns the value of the '<em><b>Parent Object Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Parent Object Name</em>' attribute.
   * @see #setParentObjectName(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo_ParentObjectName()
   * @model extendedMetaData="kind='attribute' name='parentObjectName'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getParentObjectName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getParentObjectName <em>Parent
   * Object Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Parent Object Name</em>' attribute.
   * @see #getParentObjectName()
   * @generated
   */
  void setParentObjectName(String value);

  /**
   * Returns the value of the '<em><b>Parent Object Alt Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Parent Object Alt Name</em>' attribute.
   * @see #setParentObjectAltName(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo_ParentObjectAltName()
   * @model extendedMetaData="kind='attribute' name='parentObjectAltName'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getParentObjectAltName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getParentObjectAltName <em>Parent
   * Object Alt Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Parent Object Alt Name</em>' attribute.
   * @see #getParentObjectAltName()
   * @generated
   */
  void setParentObjectAltName(String value);

  /**
   * Returns the value of the '<em><b>Parent Object Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Parent Object Type</em>' attribute.
   * @see #setParentObjectType(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectInfo_ParentObjectType()
   * @model extendedMetaData="kind='attribute' name='parentObjectType'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getParentObjectType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo#getParentObjectType <em>Parent
   * Object Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Parent Object Type</em>' attribute.
   * @see #getParentObjectType()
   * @generated
   */
  void setParentObjectType(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Retrieves display name of object
   * <!-- end-model-doc -->
   *
   * @model kind="operation" dataType="org.eclipse.emf.ecore.xml.type.String"
   * @generated
   */
  String getObjectDisplayName();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Retrieves display name of parent object
   * <!-- end-model-doc -->
   *
   * @model kind="operation" dataType="org.eclipse.emf.ecore.xml.type.String"
   * @generated
   */
  String getParentObjectDisplayName();

} // ITaggedObjectInfo
