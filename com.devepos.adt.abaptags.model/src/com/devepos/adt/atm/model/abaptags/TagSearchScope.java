/**
 */
package com.devepos.adt.atm.model.abaptags;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Tag Search Scope</b></em>', and utility methods for working with
 * them. <!-- end-user-doc -->
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagSearchScope()
 * @model
 * @generated
 */
public enum TagSearchScope implements Enumerator {
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
     * The '<em><b>GLOBAL</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #GLOBAL_VALUE
     * @generated
     * @ordered
     */
    GLOBAL(1, "GLOBAL", "global"),

    /**
     * The '<em><b>USER</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #USER_VALUE
     * @generated
     * @ordered
     */
    USER(2, "USER", "user"),
    /**
     * The '<em><b>SHARED</b></em>' literal object. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #SHARED_VALUE
     * @generated
     * @ordered
     */
    SHARED(3, "SHARED", "SHARED");

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
     * The '<em><b>GLOBAL</b></em>' literal value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #GLOBAL
     * @model literal="global"
     * @generated
     * @ordered
     */
    public static final int GLOBAL_VALUE = 1;

    /**
     * The '<em><b>USER</b></em>' literal value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #USER
     * @model literal="user"
     * @generated
     * @ordered
     */
    public static final int USER_VALUE = 2;

    /**
     * The '<em><b>SHARED</b></em>' literal value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #SHARED
     * @model
     * @generated
     * @ordered
     */
    public static final int SHARED_VALUE = 3;

    /**
     * An array of all the '<em><b>Tag Search Scope</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static final TagSearchScope[] VALUES_ARRAY = new TagSearchScope[] { ALL, GLOBAL, USER, SHARED, };

    /**
     * A public read-only list of all the '<em><b>Tag Search Scope</b></em>'
     * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final List<TagSearchScope> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Tag Search Scope</b></em>' literal with the specified
     * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static TagSearchScope get(final String literal) {
        for (TagSearchScope result : VALUES_ARRAY) {
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Tag Search Scope</b></em>' literal with the specified
     * name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static TagSearchScope getByName(final String name) {
        for (TagSearchScope result : VALUES_ARRAY) {
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Tag Search Scope</b></em>' literal with the specified
     * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static TagSearchScope get(final int value) {
        switch (value) {
        case ALL_VALUE:
            return ALL;
        case GLOBAL_VALUE:
            return GLOBAL;
        case USER_VALUE:
            return USER;
        case SHARED_VALUE:
            return SHARED;
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
    TagSearchScope(final int value, final String name, final String literal) {
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

} // TagSearchScope
