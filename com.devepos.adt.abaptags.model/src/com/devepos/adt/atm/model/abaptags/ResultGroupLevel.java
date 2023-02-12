/**
 */
package com.devepos.adt.atm.model.abaptags;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Result Group Level</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getResultGroupLevel()
 * @model
 * @generated
 */
public enum ResultGroupLevel implements Enumerator {
  /**
   * The '<em><b>BY OBJECT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #BY_OBJECT_VALUE
   * @generated
   * @ordered
   */
  BY_OBJECT(0, "BY_OBJECT", "byObject"),
  /**
   * The '<em><b>BY TAG AND OBJECT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #BY_TAG_AND_OBJECT_VALUE
   * @generated
   * @ordered
   */
  BY_TAG_AND_OBJECT(1, "BY_TAG_AND_OBJECT", "byTagAndObject");

  /**
   * The '<em><b>BY OBJECT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #BY_OBJECT
   * @model literal="byObject"
   * @generated
   * @ordered
   */
  public static final int BY_OBJECT_VALUE = 0;

  /**
   * The '<em><b>BY TAG AND OBJECT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #BY_TAG_AND_OBJECT
   * @model literal="byTagAndObject"
   * @generated
   * @ordered
   */
  public static final int BY_TAG_AND_OBJECT_VALUE = 1;

  /**
   * An array of all the '<em><b>Result Group Level</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private static final ResultGroupLevel[] VALUES_ARRAY = new ResultGroupLevel[] { BY_OBJECT,
      BY_TAG_AND_OBJECT, };

  /**
   * A public read-only list of all the '<em><b>Result Group Level</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final List<ResultGroupLevel> VALUES = Collections.unmodifiableList(Arrays.asList(
      VALUES_ARRAY));

  /**
   * Returns the '<em><b>Result Group Level</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ResultGroupLevel get(final String literal) {
    for (ResultGroupLevel result : VALUES_ARRAY) {
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Result Group Level</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ResultGroupLevel getByName(final String name) {
    for (ResultGroupLevel result : VALUES_ARRAY) {
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Result Group Level</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ResultGroupLevel get(final int value) {
    switch (value) {
    case BY_OBJECT_VALUE:
      return BY_OBJECT;
    case BY_TAG_AND_OBJECT_VALUE:
      return BY_TAG_AND_OBJECT;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  ResultGroupLevel(final int value, final String name, final String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getLiteral() {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    return literal;
  }

} // ResultGroupLevel
