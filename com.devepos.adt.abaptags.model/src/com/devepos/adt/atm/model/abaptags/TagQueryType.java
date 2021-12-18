/**
 */
package com.devepos.adt.atm.model.abaptags;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration
 * '<em><b>Tag Query Type</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTagQueryType()
 * @model
 * @generated
 */
public enum TagQueryType implements Enumerator {
  /**
   * The '<em><b>OBJECT NAME</b></em>' literal object. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #OBJECT_NAME_VALUE
   * @generated
   * @ordered
   */
  OBJECT_NAME(0, "OBJECT_NAME", "objectName"),

  /**
   * The '<em><b>OBJECT URI</b></em>' literal object. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #OBJECT_URI_VALUE
   * @generated
   * @ordered
   */
  OBJECT_URI(1, "OBJECT_URI", "objectUri"),

  /**
   * The '<em><b>OBJECT NAME TYPE COMBO</b></em>' literal object. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #OBJECT_NAME_TYPE_COMBO_VALUE
   * @generated
   * @ordered
   */
  OBJECT_NAME_TYPE_COMBO(2, "OBJECT_NAME_TYPE_COMBO", "objectNameTypeCombo");

  /**
   * The '<em><b>OBJECT NAME</b></em>' literal value. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #OBJECT_NAME
   * @model literal="objectName"
   * @generated
   * @ordered
   */
  public static final int OBJECT_NAME_VALUE = 0;

  /**
   * The '<em><b>OBJECT URI</b></em>' literal value. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @see #OBJECT_URI
   * @model literal="objectUri"
   * @generated
   * @ordered
   */
  public static final int OBJECT_URI_VALUE = 1;

  /**
   * The '<em><b>OBJECT NAME TYPE COMBO</b></em>' literal value. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #OBJECT_NAME_TYPE_COMBO
   * @model literal="objectNameTypeCombo"
   * @generated
   * @ordered
   */
  public static final int OBJECT_NAME_TYPE_COMBO_VALUE = 2;

  /**
   * An array of all the '<em><b>Tag Query Type</b></em>' enumerators. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private static final TagQueryType[] VALUES_ARRAY = new TagQueryType[] { OBJECT_NAME, OBJECT_URI,
      OBJECT_NAME_TYPE_COMBO, };

  /**
   * A public read-only list of all the '<em><b>Tag Query Type</b></em>'
   * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public static final List<TagQueryType> VALUES = Collections.unmodifiableList(Arrays.asList(
      VALUES_ARRAY));

  /**
   * Returns the '<em><b>Tag Query Type</b></em>' literal with the specified
   * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TagQueryType get(final String literal) {
    for (TagQueryType result : VALUES_ARRAY) {
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Tag Query Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TagQueryType getByName(final String name) {
    for (TagQueryType result : VALUES_ARRAY) {
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Tag Query Type</b></em>' literal with the specified
   * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TagQueryType get(final int value) {
    switch (value) {
    case OBJECT_NAME_VALUE:
      return OBJECT_NAME;
    case OBJECT_URI_VALUE:
      return OBJECT_URI;
    case OBJECT_NAME_TYPE_COMBO_VALUE:
      return OBJECT_NAME_TYPE_COMBO;
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
  TagQueryType(final int value, final String name, final String literal) {
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

} // TagQueryType
