/**
 */
package com.devepos.adt.abaptags.impl;

import com.devepos.adt.abaptags.IAbapTagsPackage;
import com.devepos.adt.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.abaptags.TagSearchScope;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Object Search Params</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.abaptags.impl.TaggedObjectSearchParams#getTagIds <em>Tag Ids</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.TaggedObjectSearchParams#getSearchScope <em>Search Scope</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.TaggedObjectSearchParams#getQuery <em>Query</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.TaggedObjectSearchParams#getMaxResults <em>Max Results</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.TaggedObjectSearchParams#isMatchesAllTags <em>Matches All Tags</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.TaggedObjectSearchParams#isWithTagInfo <em>With Tag Info</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.TaggedObjectSearchParams#isWithFullTagInfo <em>With Full Tag Info</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.TaggedObjectSearchParams#isQueryIsObjectUri <em>Query Is Object Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedObjectSearchParams extends MinimalEObjectImpl.Container implements ITaggedObjectSearchParams {
	/**
	 * The cached value of the '{@link #getTagIds() <em>Tag Ids</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagIds()
	 * @generated
	 * @ordered
	 */
	protected EList<String> tagIds;

	/**
	 * The default value of the '{@link #getSearchScope() <em>Search Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchScope()
	 * @generated
	 * @ordered
	 */
	protected static final TagSearchScope SEARCH_SCOPE_EDEFAULT = TagSearchScope.ALL;

	/**
	 * The cached value of the '{@link #getSearchScope() <em>Search Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchScope()
	 * @generated
	 * @ordered
	 */
	protected TagSearchScope searchScope = SEARCH_SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected String query = QUERY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxResults() <em>Max Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxResults()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_RESULTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxResults() <em>Max Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxResults()
	 * @generated
	 * @ordered
	 */
	protected int maxResults = MAX_RESULTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isMatchesAllTags() <em>Matches All Tags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMatchesAllTags()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MATCHES_ALL_TAGS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMatchesAllTags() <em>Matches All Tags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMatchesAllTags()
	 * @generated
	 * @ordered
	 */
	protected boolean matchesAllTags = MATCHES_ALL_TAGS_EDEFAULT;

	/**
	 * The default value of the '{@link #isWithTagInfo() <em>With Tag Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWithTagInfo()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WITH_TAG_INFO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWithTagInfo() <em>With Tag Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWithTagInfo()
	 * @generated
	 * @ordered
	 */
	protected boolean withTagInfo = WITH_TAG_INFO_EDEFAULT;

	/**
	 * The default value of the '{@link #isWithFullTagInfo() <em>With Full Tag Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWithFullTagInfo()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WITH_FULL_TAG_INFO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWithFullTagInfo() <em>With Full Tag Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWithFullTagInfo()
	 * @generated
	 * @ordered
	 */
	protected boolean withFullTagInfo = WITH_FULL_TAG_INFO_EDEFAULT;

	/**
	 * The default value of the '{@link #isQueryIsObjectUri() <em>Query Is Object Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isQueryIsObjectUri()
	 * @generated
	 * @ordered
	 */
	protected static final boolean QUERY_IS_OBJECT_URI_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isQueryIsObjectUri() <em>Query Is Object Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isQueryIsObjectUri()
	 * @generated
	 * @ordered
	 */
	protected boolean queryIsObjectUri = QUERY_IS_OBJECT_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaggedObjectSearchParams() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IAbapTagsPackage.Literals.TAGGED_OBJECT_SEARCH_PARAMS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getTagIds() {
		if (tagIds == null) {
			tagIds = new EDataTypeUniqueEList<String>(String.class, this, IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__TAG_IDS);
		}
		return tagIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TagSearchScope getSearchScope() {
		return searchScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSearchScope(TagSearchScope newSearchScope) {
		TagSearchScope oldSearchScope = searchScope;
		searchScope = newSearchScope == null ? SEARCH_SCOPE_EDEFAULT : newSearchScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__SEARCH_SCOPE, oldSearchScope, searchScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getQuery() {
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQuery(String newQuery) {
		String oldQuery = query;
		query = newQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY, oldQuery, query));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMaxResults() {
		return maxResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxResults(int newMaxResults) {
		int oldMaxResults = maxResults;
		maxResults = newMaxResults;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MAX_RESULTS, oldMaxResults, maxResults));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMatchesAllTags() {
		return matchesAllTags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatchesAllTags(boolean newMatchesAllTags) {
		boolean oldMatchesAllTags = matchesAllTags;
		matchesAllTags = newMatchesAllTags;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MATCHES_ALL_TAGS, oldMatchesAllTags, matchesAllTags));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isWithTagInfo() {
		return withTagInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWithTagInfo(boolean newWithTagInfo) {
		boolean oldWithTagInfo = withTagInfo;
		withTagInfo = newWithTagInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__WITH_TAG_INFO, oldWithTagInfo, withTagInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isWithFullTagInfo() {
		return withFullTagInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWithFullTagInfo(boolean newWithFullTagInfo) {
		boolean oldWithFullTagInfo = withFullTagInfo;
		withFullTagInfo = newWithFullTagInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__WITH_FULL_TAG_INFO, oldWithFullTagInfo, withFullTagInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isQueryIsObjectUri() {
		return queryIsObjectUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQueryIsObjectUri(boolean newQueryIsObjectUri) {
		boolean oldQueryIsObjectUri = queryIsObjectUri;
		queryIsObjectUri = newQueryIsObjectUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_IS_OBJECT_URI, oldQueryIsObjectUri, queryIsObjectUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__TAG_IDS:
				return getTagIds();
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__SEARCH_SCOPE:
				return getSearchScope();
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY:
				return getQuery();
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MAX_RESULTS:
				return getMaxResults();
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MATCHES_ALL_TAGS:
				return isMatchesAllTags();
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__WITH_TAG_INFO:
				return isWithTagInfo();
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__WITH_FULL_TAG_INFO:
				return isWithFullTagInfo();
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_IS_OBJECT_URI:
				return isQueryIsObjectUri();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__TAG_IDS:
				getTagIds().clear();
				getTagIds().addAll((Collection<? extends String>)newValue);
				return;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__SEARCH_SCOPE:
				setSearchScope((TagSearchScope)newValue);
				return;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY:
				setQuery((String)newValue);
				return;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MAX_RESULTS:
				setMaxResults((Integer)newValue);
				return;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MATCHES_ALL_TAGS:
				setMatchesAllTags((Boolean)newValue);
				return;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__WITH_TAG_INFO:
				setWithTagInfo((Boolean)newValue);
				return;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__WITH_FULL_TAG_INFO:
				setWithFullTagInfo((Boolean)newValue);
				return;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_IS_OBJECT_URI:
				setQueryIsObjectUri((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__TAG_IDS:
				getTagIds().clear();
				return;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__SEARCH_SCOPE:
				setSearchScope(SEARCH_SCOPE_EDEFAULT);
				return;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY:
				setQuery(QUERY_EDEFAULT);
				return;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MAX_RESULTS:
				setMaxResults(MAX_RESULTS_EDEFAULT);
				return;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MATCHES_ALL_TAGS:
				setMatchesAllTags(MATCHES_ALL_TAGS_EDEFAULT);
				return;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__WITH_TAG_INFO:
				setWithTagInfo(WITH_TAG_INFO_EDEFAULT);
				return;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__WITH_FULL_TAG_INFO:
				setWithFullTagInfo(WITH_FULL_TAG_INFO_EDEFAULT);
				return;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_IS_OBJECT_URI:
				setQueryIsObjectUri(QUERY_IS_OBJECT_URI_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__TAG_IDS:
				return tagIds != null && !tagIds.isEmpty();
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__SEARCH_SCOPE:
				return searchScope != SEARCH_SCOPE_EDEFAULT;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY:
				return QUERY_EDEFAULT == null ? query != null : !QUERY_EDEFAULT.equals(query);
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MAX_RESULTS:
				return maxResults != MAX_RESULTS_EDEFAULT;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MATCHES_ALL_TAGS:
				return matchesAllTags != MATCHES_ALL_TAGS_EDEFAULT;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__WITH_TAG_INFO:
				return withTagInfo != WITH_TAG_INFO_EDEFAULT;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__WITH_FULL_TAG_INFO:
				return withFullTagInfo != WITH_FULL_TAG_INFO_EDEFAULT;
			case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_IS_OBJECT_URI:
				return queryIsObjectUri != QUERY_IS_OBJECT_URI_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (tagIds: ");
		result.append(tagIds);
		result.append(", searchScope: ");
		result.append(searchScope);
		result.append(", query: ");
		result.append(query);
		result.append(", maxResults: ");
		result.append(maxResults);
		result.append(", matchesAllTags: ");
		result.append(matchesAllTags);
		result.append(", withTagInfo: ");
		result.append(withTagInfo);
		result.append(", withFullTagInfo: ");
		result.append(withFullTagInfo);
		result.append(", queryIsObjectUri: ");
		result.append(queryIsObjectUri);
		result.append(')');
		return result.toString();
	}

} //TaggedObjectSearchParams
