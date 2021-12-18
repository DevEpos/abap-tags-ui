/**
 */
package com.devepos.adt.atm.model.abaptags;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Tag Query Focus</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagQueryFocus()
 * @model
 * @generated
 */
public enum TagQueryFocus implements Enumerator {
  /**
   * The '<em><b>OBJECT</b></em>' literal object. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #OBJECT_VALUE
   * @generated
   * @ordered
   */
  OBJECT(0, "OBJECT", "object"),

  /**
   * The '<em><b>PARENT OBJECT</b></em>' literal object. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #PARENT_OBJECT_VALUE
   * @generated
   * @ordered
   */
  PARENT_OBJECT(1, "PARENT_OBJECT", "parentObject");

  /**
   * The '<em><b>OBJECT</b></em>' literal value. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #OBJECT
   * @model literal="object"
   * @generated
   * @ordered
   */
  public static final int OBJECT_VALUE = 0;

  /**
   * The '<em><b>PARENT OBJECT</b></em>' literal value. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #PARENT_OBJECT
   * @model literal="parentObject"
   * @generated
   * @ordered
   */
  public static final int PARENT_OBJECT_VALUE = 1;

  /**
   * An array of all the '<em><b>Tag Query Focus</b></em>' enumerators. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private static final TagQueryFocus[] VALUES_ARRAY = new TagQueryFocus[] { OBJECT,
      PARENT_OBJECT, };

  /**
   * A public read-only list of all the '<em><b>Tag Query Focus</b></em>'
   * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public static final List<TagQueryFocus> VALUES = Collections.unmodifiableList(Arrays.asList(
      VALUES_ARRAY));

  /**
   * Returns the '<em><b>Tag Query Focus</b></em>' literal with the specified
   * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TagQueryFocus get(final String literal) {
    for (TagQueryFocus result : VALUES_ARRAY) {
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Tag Query Focus</b></em>' literal with the specified
   * name. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TagQueryFocus getByName(final String name) {
    for (TagQueryFocus result : VALUES_ARRAY) {
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Tag Query Focus</b></em>' literal with the specified
   * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TagQueryFocus get(final int value) {
    switch (value) {
    case OBJECT_VALUE:
      return OBJECT;
    case PARENT_OBJECT_VALUE:
      return PARENT_OBJECT;
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
  TagQueryFocus(final int value, final String name, final String literal) {
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

} // TagQueryFocus
