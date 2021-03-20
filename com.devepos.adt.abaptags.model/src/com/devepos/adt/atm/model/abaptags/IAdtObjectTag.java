/**
 */
package com.devepos.adt.atm.model.abaptags;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Adt
 * Object Tag</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectName
 * <em>Parent Object Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectType
 * <em>Parent Object Type</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectUri
 * <em>Parent Object Uri</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagId
 * <em>Parent Tag Id</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagName
 * <em>Parent Tag Name</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#isUserTag
 * <em>User Tag</em>}</li>
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
     * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectName
     * <em>Parent Object Name</em>}' attribute. <!-- begin-user-doc --> <!--
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
     * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectType
     * <em>Parent Object Type</em>}' attribute. <!-- begin-user-doc --> <!--
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
     * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentObjectUri
     * <em>Parent Object Uri</em>}' attribute. <!-- begin-user-doc --> <!--
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
     * Sets the value of the
     * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#getParentTagName
     * <em>Parent Tag Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value the new value of the '<em>Parent Tag Name</em>' attribute.
     * @see #getParentTagName()
     * @generated
     */
    void setParentTagName(String value);

    /**
     * Returns the value of the '<em><b>User Tag</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>User Tag</em>' attribute.
     * @see #setUserTag(boolean)
     * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getAdtObjectTag_UserTag()
     * @model transient="true"
     * @generated
     */
    boolean isUserTag();

    /**
     * Sets the value of the
     * '{@link com.devepos.adt.atm.model.abaptags.IAdtObjectTag#isUserTag <em>User
     * Tag</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>User Tag</em>' attribute.
     * @see #isUserTag()
     * @generated
     */
    void setUserTag(boolean value);

} // IAdtObjectTag
