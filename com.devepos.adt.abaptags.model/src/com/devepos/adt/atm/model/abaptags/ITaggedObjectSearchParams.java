/**
 */
package com.devepos.adt.atm.model.abaptags;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Tagged
 * Object Search Params</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getTagIds <em>Tag
 * Ids</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getSearchScope <em>Search
 * Scope</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getQuery
 * <em>Query</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getQueryType <em>Query
 * Type</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getResultGroupLevel
 * <em>Result Group Level</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getQueryFocus <em>Query
 * Focus</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getMaxResults <em>Max
 * Results</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isMatchesAllTags
 * <em>Matches All Tags</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isWithTagInfo <em>With
 * Tag Info</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getTagInfoType <em>Tag
 * Info Type</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isExcludeComponents
 * <em>Exclude Components</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams()
 * @model extendedMetaData="kind='elementOnly' name='taggedObjectSearchParams'"
 * @generated
 */
public interface ITaggedObjectSearchParams extends EObject {
  /**
   * Adds the given tag to the search params
   */
  void addTag(ITag tag);

  /**
   * Clears tags query and collected tag ids
   */
  void clearTags();

  /**
   * Retrieves the Tags as a separated String
   *
   * @return a separated list of tags
   */
  String getTags();

  /**
   * Returns the value of the '<em><b>Tag Ids</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @return the value of the '<em>Tag Ids</em>' attribute list.
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_TagIds()
   * @model extendedMetaData="kind='element' name='tagId' namespace='##targetNamespace'"
   * @generated
   */
  EList<String> getTagIds();

  /**
   * Returns the value of the '<em><b>Search Scope</b></em>' attribute. The
   * literals are from the enumeration
   * {@link com.devepos.adt.atm.model.abaptags.TagSearchScope}. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Search Scope</em>' attribute.
   * @see com.devepos.adt.atm.model.abaptags.TagSearchScope
   * @see #setSearchScope(TagSearchScope)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_SearchScope()
   * @model extendedMetaData="kind='attribute' name='searchScope'
   *        namespace='##targetNamespace'"
   * @generated
   */
  TagSearchScope getSearchScope();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getSearchScope
   * <em>Search Scope</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @param value the new value of the '<em>Search Scope</em>' attribute.
   * @see com.devepos.adt.atm.model.abaptags.TagSearchScope
   * @see #getSearchScope()
   * @generated
   */
  void setSearchScope(TagSearchScope value);

  /**
   * Returns the value of the '<em><b>Query</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Query</em>' attribute.
   * @see #setQuery(String)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_Query()
   * @model extendedMetaData="kind='attribute' name='query'
   *        namespace='##targetNamespace'"
   * @generated
   */
  String getQuery();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getQuery <em>Query</em>}'
   * attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Query</em>' attribute.
   * @see #getQuery()
   * @generated
   */
  void setQuery(String value);

  /**
   * Returns the value of the '<em><b>Query Type</b></em>' attribute.
   * The literals are from the enumeration {@link com.devepos.adt.atm.model.abaptags.TagQueryType}.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Query Type</em>' attribute.
   * @see com.devepos.adt.atm.model.abaptags.TagQueryType
   * @see #setQueryType(TagQueryType)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_QueryType()
   * @model extendedMetaData="kind='attribute' name='queryType' namespace='##targetNamespace'"
   * @generated
   */
  TagQueryType getQueryType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getQueryType
   * <em>Query Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @param value the new value of the '<em>Query Type</em>' attribute.
   * @see com.devepos.adt.atm.model.abaptags.TagQueryType
   * @see #getQueryType()
   * @generated
   */
  void setQueryType(TagQueryType value);

  /**
   * Returns the value of the '<em><b>Result Group Level</b></em>' attribute.
   * The literals are from the enumeration
   * {@link com.devepos.adt.atm.model.abaptags.ResultGroupLevel}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Result Group Level</em>' attribute.
   * @see com.devepos.adt.atm.model.abaptags.ResultGroupLevel
   * @see #setResultGroupLevel(ResultGroupLevel)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_ResultGroupLevel()
   * @model extendedMetaData="kind='attribute' name='resultGroupLevel'
   *        namespace='##targetNamespace'"
   * @generated
   */
  ResultGroupLevel getResultGroupLevel();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getResultGroupLevel
   * <em>Result Group Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Result Group Level</em>' attribute.
   * @see com.devepos.adt.atm.model.abaptags.ResultGroupLevel
   * @see #getResultGroupLevel()
   * @generated
   */
  void setResultGroupLevel(ResultGroupLevel value);

  /**
   * Returns the value of the '<em><b>Query Focus</b></em>' attribute.
   * The literals are from the enumeration {@link com.devepos.adt.atm.model.abaptags.TagQueryFocus}.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Query Focus</em>' attribute.
   * @see com.devepos.adt.atm.model.abaptags.TagQueryFocus
   * @see #setQueryFocus(TagQueryFocus)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_QueryFocus()
   * @model extendedMetaData="kind='attribute' name='queryFocus' namespace='##targetNamespace'"
   * @generated
   */
  TagQueryFocus getQueryFocus();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getQueryFocus
   * <em>Query Focus</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @param value the new value of the '<em>Query Focus</em>' attribute.
   * @see com.devepos.adt.atm.model.abaptags.TagQueryFocus
   * @see #getQueryFocus()
   * @generated
   */
  void setQueryFocus(TagQueryFocus value);

  /**
   * Returns the value of the '<em><b>Max Results</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Max Results</em>' attribute.
   * @see #setMaxResults(int)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_MaxResults()
   * @model extendedMetaData="kind='attribute' name='maxResults'
   *        namespace='##targetNamespace'"
   * @generated
   */
  int getMaxResults();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getMaxResults
   * <em>Max Results</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @param value the new value of the '<em>Max Results</em>' attribute.
   * @see #getMaxResults()
   * @generated
   */
  void setMaxResults(int value);

  /**
   * Returns the value of the '<em><b>Matches All Tags</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Matches All Tags</em>' attribute.
   * @see #setMatchesAllTags(boolean)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_MatchesAllTags()
   * @model extendedMetaData="kind='attribute' name='matchesAllTags'
   *        namespace='##targetNamespace'"
   * @generated
   */
  boolean isMatchesAllTags();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isMatchesAllTags
   * <em>Matches All Tags</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @param value the new value of the '<em>Matches All Tags</em>' attribute.
   * @see #isMatchesAllTags()
   * @generated
   */
  void setMatchesAllTags(boolean value);

  /**
   * Returns the value of the '<em><b>With Tag Info</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>With Tag Info</em>' attribute.
   * @see #setWithTagInfo(boolean)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_WithTagInfo()
   * @model extendedMetaData="kind='attribute' name='withTagInfo'
   *        namespace='##targetNamespace'"
   * @generated
   */
  boolean isWithTagInfo();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isWithTagInfo
   * <em>With Tag Info</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @param value the new value of the '<em>With Tag Info</em>' attribute.
   * @see #isWithTagInfo()
   * @generated
   */
  void setWithTagInfo(boolean value);

  /**
   * Returns the value of the '<em><b>Tag Info Type</b></em>' attribute.
   * The literals are from the enumeration {@link com.devepos.adt.atm.model.abaptags.TagInfoType}.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Tag Info Type</em>' attribute.
   * @see com.devepos.adt.atm.model.abaptags.TagInfoType
   * @see #setTagInfoType(TagInfoType)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_TagInfoType()
   * @model extendedMetaData="kind='attribute' name='tagInfoType' namespace='##targetNamespace'"
   * @generated
   */
  TagInfoType getTagInfoType();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#getTagInfoType
   * <em>Tag Info Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @param value the new value of the '<em>Tag Info Type</em>' attribute.
   * @see com.devepos.adt.atm.model.abaptags.TagInfoType
   * @see #getTagInfoType()
   * @generated
   */
  void setTagInfoType(TagInfoType value);

  /**
   * Returns the value of the '<em><b>Exclude Components</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Exclude Components</em>' attribute.
   * @see #setExcludeComponents(boolean)
   * @see com.devepos.adt.atm.model.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_ExcludeComponents()
   * @model extendedMetaData="kind='attribute' name='excludeComponents'
   *        namespace='##targetNamespace'"
   * @generated
   */
  boolean isExcludeComponents();

  /**
   * Sets the value of the
   * '{@link com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams#isExcludeComponents
   * <em>Exclude Components</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value the new value of the '<em>Exclude Components</em>' attribute.
   * @see #isExcludeComponents()
   * @generated
   */
  void setExcludeComponents(boolean value);

} // ITaggedObjectSearchParams
