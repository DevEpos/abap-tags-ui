/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.graphics.Image;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Adt
 * Object Tag</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectName <em>Parent Object
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectType <em>Parent Object
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectUri <em>Parent Object
 * Uri</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagId <em>Parent Tag
 * Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagName <em>Parent Tag
 * Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getImage <em>Image</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getPossibleParentTags <em>Possible
 * Parent Tags</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getCorrectParentTag <em>Correct
 * Parent Tag</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getAdtObjectTag()
 * @model extendedMetaData="kind='elementOnly' name='adtObjectTag'"
 * @generated
 */
public interface IAdtObjectTag extends ITagBase {
  /**
   * Returns the value of the '<em><b>Parent Object Name</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Parent Object Name</em>' attribute.
   * @see #setParentObjectName(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getAdtObjectTag_ParentObjectName()
   * @model extendedMetaData="kind='attribute' name='parentObjectName'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getParentObjectName();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectName <em>Parent Object
   * Name</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @param value the new value of the '<em>Parent Object Name</em>' attribute.
   * @see #getParentObjectName()
   * @generated
   */
  void setParentObjectName(String value);

  /**
   * Returns the value of the '<em><b>Parent Object Type</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Parent Object Type</em>' attribute.
   * @see #setParentObjectType(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getAdtObjectTag_ParentObjectType()
   * @model extendedMetaData="kind='attribute' name='parentObjectType'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getParentObjectType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectType <em>Parent Object
   * Type</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @param value the new value of the '<em>Parent Object Type</em>' attribute.
   * @see #getParentObjectType()
   * @generated
   */
  void setParentObjectType(String value);

  /**
   * Returns the value of the '<em><b>Parent Object Uri</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Parent Object Uri</em>' attribute.
   * @see #setParentObjectUri(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getAdtObjectTag_ParentObjectUri()
   * @model extendedMetaData="kind='attribute' name='parentObjectUri'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getParentObjectUri();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectUri <em>Parent Object
   * Uri</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @param value the new value of the '<em>Parent Object Uri</em>' attribute.
   * @see #getParentObjectUri()
   * @generated
   */
  void setParentObjectUri(String value);

  /**
   * Returns the value of the '<em><b>Parent Tag Id</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Parent Tag Id</em>' attribute.
   * @see #setParentTagId(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getAdtObjectTag_ParentTagId()
   * @model transient="true"
   * @generated
   */
  String getParentTagId();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagId
   * <em>Parent Tag Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @param value the new value of the '<em>Parent Tag Id</em>' attribute.
   * @see #getParentTagId()
   * @generated
   */
  void setParentTagId(String value);

  /**
   * Returns the value of the '<em><b>Parent Tag Name</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Parent Tag Name</em>' attribute.
   * @see #setParentTagName(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getAdtObjectTag_ParentTagName()
   * @model transient="true"
   * @generated
   */
  String getParentTagName();

  /**
   * Sets the value of the '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagName
   * <em>Parent Tag Name</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @param value the new value of the '<em>Parent Tag Name</em>' attribute.
   * @see #getParentTagName()
   * @generated
   */
  void setParentTagName(String value);

  /**
   * Returns the value of the '<em><b>Image</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Image</em>' attribute.
   * @see #setImage(Image)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getAdtObjectTag_Image()
   * @model dataType="com.devepos.adt.atm.model.abaptags.Image" transient="true"
   * @generated
   */
  Image getImage();

  /**
   * Sets the value of the '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getImage
   * <em>Image</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Image</em>' attribute.
   * @see #getImage()
   * @generated
   */
  void setImage(Image value);

  /**
   * Returns the value of the '<em><b>Possible Parent Tags</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Possible Parent Tags</em>' attribute list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getAdtObjectTag_PossibleParentTags()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" transient="true"
   * @generated
   */
  EList<String> getPossibleParentTags();

  /**
   * Returns the value of the '<em><b>Correct Parent Tag</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Correct Parent Tag</em>' reference.
   * @see #setCorrectParentTag(ITag)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getAdtObjectTag_CorrectParentTag()
   * @model transient="true"
   * @generated
   */
  ITag getCorrectParentTag();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getCorrectParentTag <em>Correct Parent
   * Tag</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Correct Parent Tag</em>' reference.
   * @see #getCorrectParentTag()
   * @generated
   */
  void setCorrectParentTag(ITag value);

} // IAdtObjectTag
