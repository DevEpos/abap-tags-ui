/**
 */
package com.devepos.adt.abaptags;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Object Search Params</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#getTagIds <em>Tag Ids</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#getSearchScope <em>Search Scope</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#getQuery <em>Query</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#getMaxResults <em>Max Results</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#isMatchesAllTags <em>Matches All Tags</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#isWithTagInfo <em>With Tag Info</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#isWithFullTagInfo <em>With Full Tag Info</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#isQueryIsObjectUri <em>Query Is Object Uri</em>}</li>
 * </ul>
 *
 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams()
 * @model extendedMetaData="kind='elementOnly' name='taggedObjectSearchParams'"
 * @generated
 */
public interface ITaggedObjectSearchParams extends EObject {
	/**
	 * Returns the value of the '<em><b>Tag Ids</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag Ids</em>' attribute list.
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_TagIds()
	 * @model extendedMetaData="kind='element' name='tagId' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getTagIds();

	/**
	 * Returns the value of the '<em><b>Search Scope</b></em>' attribute.
	 * The literals are from the enumeration {@link com.devepos.adt.abaptags.TagSearchScope}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Search Scope</em>' attribute.
	 * @see com.devepos.adt.abaptags.TagSearchScope
	 * @see #setSearchScope(TagSearchScope)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_SearchScope()
	 * @model extendedMetaData="kind='attribute' name='searchScope' namespace='##targetNamespace'"
	 * @generated
	 */
	TagSearchScope getSearchScope();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#getSearchScope <em>Search Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Search Scope</em>' attribute.
	 * @see com.devepos.adt.abaptags.TagSearchScope
	 * @see #getSearchScope()
	 * @generated
	 */
	void setSearchScope(TagSearchScope value);

	/**
	 * Returns the value of the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' attribute.
	 * @see #setQuery(String)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_Query()
	 * @model extendedMetaData="kind='attribute' name='query' namespace='##targetNamespace'"
	 * @generated
	 */
	String getQuery();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#getQuery <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' attribute.
	 * @see #getQuery()
	 * @generated
	 */
	void setQuery(String value);

	/**
	 * Returns the value of the '<em><b>Max Results</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Results</em>' attribute.
	 * @see #setMaxResults(int)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_MaxResults()
	 * @model extendedMetaData="kind='attribute' name='maxResults' namespace='##targetNamespace'"
	 * @generated
	 */
	int getMaxResults();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#getMaxResults <em>Max Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Results</em>' attribute.
	 * @see #getMaxResults()
	 * @generated
	 */
	void setMaxResults(int value);

	/**
	 * Returns the value of the '<em><b>Matches All Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matches All Tags</em>' attribute.
	 * @see #setMatchesAllTags(boolean)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_MatchesAllTags()
	 * @model extendedMetaData="kind='attribute' name='matchesAllTags' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isMatchesAllTags();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#isMatchesAllTags <em>Matches All Tags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matches All Tags</em>' attribute.
	 * @see #isMatchesAllTags()
	 * @generated
	 */
	void setMatchesAllTags(boolean value);

	/**
	 * Returns the value of the '<em><b>With Tag Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>With Tag Info</em>' attribute.
	 * @see #setWithTagInfo(boolean)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_WithTagInfo()
	 * @model extendedMetaData="kind='attribute' name='withTagInfo' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isWithTagInfo();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#isWithTagInfo <em>With Tag Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>With Tag Info</em>' attribute.
	 * @see #isWithTagInfo()
	 * @generated
	 */
	void setWithTagInfo(boolean value);

	/**
	 * Returns the value of the '<em><b>With Full Tag Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>With Full Tag Info</em>' attribute.
	 * @see #setWithFullTagInfo(boolean)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_WithFullTagInfo()
	 * @model extendedMetaData="kind='attribute' name='withFullTagInfo' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isWithFullTagInfo();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#isWithFullTagInfo <em>With Full Tag Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>With Full Tag Info</em>' attribute.
	 * @see #isWithFullTagInfo()
	 * @generated
	 */
	void setWithFullTagInfo(boolean value);

	/**
	 * Returns the value of the '<em><b>Query Is Object Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Is Object Uri</em>' attribute.
	 * @see #setQueryIsObjectUri(boolean)
	 * @see com.devepos.adt.abaptags.IAbapTagsPackage#getTaggedObjectSearchParams_QueryIsObjectUri()
	 * @model extendedMetaData="kind='attribute' name='queryIsObjectUri' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isQueryIsObjectUri();

	/**
	 * Sets the value of the '{@link com.devepos.adt.abaptags.ITaggedObjectSearchParams#isQueryIsObjectUri <em>Query Is Object Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Is Object Uri</em>' attribute.
	 * @see #isQueryIsObjectUri()
	 * @generated
	 */
	void setQueryIsObjectUri(boolean value);

} // ITaggedObjectSearchParams
