/**
 */
package com.devepos.adt.atm.model.abaptags;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Tag Info Type</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagInfoType()
 * @model
 * @generated
 */
public enum TagInfoType implements Enumerator {
    /**
     * The '<em><b>ALL</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #ALL_VALUE
     * @generated
     * @ordered
     */
    ALL(0, "ALL", "all"),

    /**
     * The '<em><b>CHILDREN</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #CHILDREN_VALUE
     * @generated
     * @ordered
     */
    CHILDREN(1, "CHILDREN", "children");

    /**
     * The '<em><b>ALL</b></em>' literal value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #ALL
     * @model literal="all"
     * @generated
     * @ordered
     */
    public static final int ALL_VALUE = 0;

    /**
     * The '<em><b>CHILDREN</b></em>' literal value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #CHILDREN
     * @model literal="children"
     * @generated
     * @ordered
     */
    public static final int CHILDREN_VALUE = 1;

    /**
     * An array of all the '<em><b>Tag Info Type</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static final TagInfoType[] VALUES_ARRAY = new TagInfoType[] { ALL, CHILDREN, };

    /**
     * A public read-only list of all the '<em><b>Tag Info Type</b></em>'
     * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final List<TagInfoType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Tag Info Type</b></em>' literal with the specified
     * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static TagInfoType get(final String literal) {
        for (TagInfoType result : VALUES_ARRAY) {
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Tag Info Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static TagInfoType getByName(final String name) {
        for (TagInfoType result : VALUES_ARRAY) {
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Tag Info Type</b></em>' literal with the specified
     * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static TagInfoType get(final int value) {
        switch (value) {
        case ALL_VALUE:
            return ALL;
        case CHILDREN_VALUE:
            return CHILDREN;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    TagInfoType(final int value, final String name, final String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string
     * representation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }

} // TagInfoType
