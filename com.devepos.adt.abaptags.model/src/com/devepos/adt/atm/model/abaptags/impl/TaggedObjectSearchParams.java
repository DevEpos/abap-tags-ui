/**
 */
package com.devepos.adt.atm.model.abaptags.impl;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.devepos.adt.atm.model.abaptags.IAbapTagsPackage;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.model.abaptags.ResultGroupLevel;
import com.devepos.adt.atm.model.abaptags.TagInfoType;
import com.devepos.adt.atm.model.abaptags.TagQueryFocus;
import com.devepos.adt.atm.model.abaptags.TagQueryType;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Tagged
 * Object Search Params</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams#getTagIds <em>Tag
 * Ids</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams#getSearchScope
 * <em>Search Scope</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams#getQuery
 * <em>Query</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams#getQueryType
 * <em>Query Type</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams#getResultGroupLevel
 * <em>Result Group Level</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams#getQueryFocus
 * <em>Query Focus</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams#getMaxResults <em>Max
 * Results</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams#isMatchesAllTags
 * <em>Matches All Tags</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams#isWithTagInfo
 * <em>With Tag Info</em>}</li>
 * <li>{@link com.devepos.adt.atm.model.abaptags.impl.TaggedObjectSearchParams#getTagInfoType
 * <em>Tag Info Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaggedObjectSearchParams extends MinimalEObjectImpl.Container implements
    ITaggedObjectSearchParams {
  private final Set<String> tags = new TreeSet<>();
  /**
   * The cached value of the '{@link #getTagIds() <em>Tag Ids</em>}' attribute list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getTagIds()
   * @generated
   * @ordered
   */
  protected EList<String> tagIds;

  /**
   * The default value of the '{@link #getSearchScope() <em>Search Scope</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getSearchScope()
   * @generated
   * @ordered
   */
  protected static final TagSearchScope SEARCH_SCOPE_EDEFAULT = TagSearchScope.ALL;

  /**
   * The cached value of the '{@link #getSearchScope() <em>Search Scope</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getSearchScope()
   * @generated
   * @ordered
   */
  protected TagSearchScope searchScope = SEARCH_SCOPE_EDEFAULT;

  /**
   * The default value of the '{@link #getQuery() <em>Query</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getQuery()
   * @generated
   * @ordered
   */
  protected static final String QUERY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getQuery() <em>Query</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getQuery()
   * @generated
   * @ordered
   */
  protected String query = QUERY_EDEFAULT;

  /**
   * The default value of the '{@link #getQueryType() <em>Query Type</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getQueryType()
   * @generated
   * @ordered
   */
  protected static final TagQueryType QUERY_TYPE_EDEFAULT = TagQueryType.OBJECT_NAME;
  /**
   * The cached value of the '{@link #getQueryType() <em>Query Type</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getQueryType()
   * @generated
   * @ordered
   */
  protected TagQueryType queryType = QUERY_TYPE_EDEFAULT;
  /**
   * The default value of the '{@link #getResultGroupLevel() <em>Result Group Level</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getResultGroupLevel()
   * @generated
   * @ordered
   */
  protected static final ResultGroupLevel RESULT_GROUP_LEVEL_EDEFAULT = ResultGroupLevel.BY_OBJECT;
  /**
   * The cached value of the '{@link #getResultGroupLevel() <em>Result Group Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getResultGroupLevel()
   * @generated
   * @ordered
   */
  protected ResultGroupLevel resultGroupLevel = RESULT_GROUP_LEVEL_EDEFAULT;
  /**
   * The default value of the '{@link #getQueryFocus() <em>Query Focus</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getQueryFocus()
   * @generated
   * @ordered
   */
  protected static final TagQueryFocus QUERY_FOCUS_EDEFAULT = TagQueryFocus.OBJECT;
  /**
   * The cached value of the '{@link #getQueryFocus() <em>Query Focus</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getQueryFocus()
   * @generated
   * @ordered
   */
  protected TagQueryFocus queryFocus = QUERY_FOCUS_EDEFAULT;
  /**
   * The default value of the '{@link #getMaxResults() <em>Max Results</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getMaxResults()
   * @generated
   * @ordered
   */
  protected static final int MAX_RESULTS_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMaxResults() <em>Max Results</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getMaxResults()
   * @generated
   * @ordered
   */
  protected int maxResults = MAX_RESULTS_EDEFAULT;

  /**
   * The default value of the '{@link #isMatchesAllTags() <em>Matches All Tags</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #isMatchesAllTags()
   * @generated
   * @ordered
   */
  protected static final boolean MATCHES_ALL_TAGS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMatchesAllTags() <em>Matches All Tags</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #isMatchesAllTags()
   * @generated
   * @ordered
   */
  protected boolean matchesAllTags = MATCHES_ALL_TAGS_EDEFAULT;

  /**
   * The default value of the '{@link #isWithTagInfo() <em>With Tag Info</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #isWithTagInfo()
   * @generated
   * @ordered
   */
  protected static final boolean WITH_TAG_INFO_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isWithTagInfo() <em>With Tag Info</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #isWithTagInfo()
   * @generated
   * @ordered
   */
  protected boolean withTagInfo = WITH_TAG_INFO_EDEFAULT;

  /**
   * The default value of the '{@link #getTagInfoType() <em>Tag Info Type</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getTagInfoType()
   * @generated
   * @ordered
   */
  protected static final TagInfoType TAG_INFO_TYPE_EDEFAULT = TagInfoType.ALL;
  /**
   * The cached value of the '{@link #getTagInfoType() <em>Tag Info Type</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #getTagInfoType()
   * @generated
   * @ordered
   */
  protected TagInfoType tagInfoType = TAG_INFO_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected TaggedObjectSearchParams() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return IAbapTagsPackage.Literals.TAGGED_OBJECT_SEARCH_PARAMS;
  }

  @Override
  public void addTag(final ITag tag) {
    getTagIds().add(tag.getId());
    tags.add(tag.getName());
  }

  @Override
  public void clearTags() {
    getTagIds().clear();
    tags.clear();
  }

  @Override
  public String getTags() {
    if (tags.isEmpty()) {
      return null;
    }
    return tags.stream().collect(Collectors.joining(", "));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EList<String> getTagIds() {
    if (tagIds == null) {
      tagIds = new EDataTypeUniqueEList<>(String.class, this,
          IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__TAG_IDS);
    }
    return tagIds;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public TagSearchScope getSearchScope() {
    return searchScope;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setSearchScope(final TagSearchScope newSearchScope) {
    TagSearchScope oldSearchScope = searchScope;
    searchScope = newSearchScope == null ? SEARCH_SCOPE_EDEFAULT : newSearchScope;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__SEARCH_SCOPE, oldSearchScope, searchScope));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getQuery() {
    return query;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setQuery(final String newQuery) {
    String oldQuery = query;
    query = newQuery;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY, oldQuery, query));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public TagQueryType getQueryType() {
    return queryType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setQueryType(final TagQueryType newQueryType) {
    TagQueryType oldQueryType = queryType;
    queryType = newQueryType == null ? QUERY_TYPE_EDEFAULT : newQueryType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_TYPE, oldQueryType, queryType));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ResultGroupLevel getResultGroupLevel() {
    return resultGroupLevel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setResultGroupLevel(final ResultGroupLevel newResultGroupLevel) {
    ResultGroupLevel oldResultGroupLevel = resultGroupLevel;
    resultGroupLevel = newResultGroupLevel == null ? RESULT_GROUP_LEVEL_EDEFAULT
        : newResultGroupLevel;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__RESULT_GROUP_LEVEL, oldResultGroupLevel,
          resultGroupLevel));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public TagQueryFocus getQueryFocus() {
    return queryFocus;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setQueryFocus(final TagQueryFocus newQueryFocus) {
    TagQueryFocus oldQueryFocus = queryFocus;
    queryFocus = newQueryFocus == null ? QUERY_FOCUS_EDEFAULT : newQueryFocus;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_FOCUS, oldQueryFocus, queryFocus));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getMaxResults() {
    return maxResults;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setMaxResults(final int newMaxResults) {
    int oldMaxResults = maxResults;
    maxResults = newMaxResults;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MAX_RESULTS, oldMaxResults, maxResults));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isMatchesAllTags() {
    return matchesAllTags;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setMatchesAllTags(final boolean newMatchesAllTags) {
    boolean oldMatchesAllTags = matchesAllTags;
    matchesAllTags = newMatchesAllTags;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MATCHES_ALL_TAGS, oldMatchesAllTags,
          matchesAllTags));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isWithTagInfo() {
    return withTagInfo;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setWithTagInfo(final boolean newWithTagInfo) {
    boolean oldWithTagInfo = withTagInfo;
    withTagInfo = newWithTagInfo;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__WITH_TAG_INFO, oldWithTagInfo,
          withTagInfo));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public TagInfoType getTagInfoType() {
    return tagInfoType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setTagInfoType(final TagInfoType newTagInfoType) {
    TagInfoType oldTagInfoType = tagInfoType;
    tagInfoType = newTagInfoType == null ? TAG_INFO_TYPE_EDEFAULT : newTagInfoType;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET,
          IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__TAG_INFO_TYPE, oldTagInfoType,
          tagInfoType));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__TAG_IDS:
      return getTagIds();
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__SEARCH_SCOPE:
      return getSearchScope();
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY:
      return getQuery();
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_TYPE:
      return getQueryType();
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__RESULT_GROUP_LEVEL:
      return getResultGroupLevel();
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_FOCUS:
      return getQueryFocus();
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MAX_RESULTS:
      return getMaxResults();
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MATCHES_ALL_TAGS:
      return isMatchesAllTags();
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__WITH_TAG_INFO:
      return isWithTagInfo();
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__TAG_INFO_TYPE:
      return getTagInfoType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__TAG_IDS:
      getTagIds().clear();
      getTagIds().addAll((Collection<? extends String>) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__SEARCH_SCOPE:
      setSearchScope((TagSearchScope) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY:
      setQuery((String) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_TYPE:
      setQueryType((TagQueryType) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__RESULT_GROUP_LEVEL:
      setResultGroupLevel((ResultGroupLevel) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_FOCUS:
      setQueryFocus((TagQueryFocus) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MAX_RESULTS:
      setMaxResults((Integer) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MATCHES_ALL_TAGS:
      setMatchesAllTags((Boolean) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__WITH_TAG_INFO:
      setWithTagInfo((Boolean) newValue);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__TAG_INFO_TYPE:
      setTagInfoType((TagInfoType) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eUnset(final int featureID) {
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
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_TYPE:
      setQueryType(QUERY_TYPE_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__RESULT_GROUP_LEVEL:
      setResultGroupLevel(RESULT_GROUP_LEVEL_EDEFAULT);
      return;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_FOCUS:
      setQueryFocus(QUERY_FOCUS_EDEFAULT);
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
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__TAG_INFO_TYPE:
      setTagInfoType(TAG_INFO_TYPE_EDEFAULT);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__TAG_IDS:
      return tagIds != null && !tagIds.isEmpty();
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__SEARCH_SCOPE:
      return searchScope != SEARCH_SCOPE_EDEFAULT;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY:
      return QUERY_EDEFAULT == null ? query != null : !QUERY_EDEFAULT.equals(query);
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_TYPE:
      return queryType != QUERY_TYPE_EDEFAULT;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__RESULT_GROUP_LEVEL:
      return resultGroupLevel != RESULT_GROUP_LEVEL_EDEFAULT;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__QUERY_FOCUS:
      return queryFocus != QUERY_FOCUS_EDEFAULT;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MAX_RESULTS:
      return maxResults != MAX_RESULTS_EDEFAULT;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__MATCHES_ALL_TAGS:
      return matchesAllTags != MATCHES_ALL_TAGS_EDEFAULT;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__WITH_TAG_INFO:
      return withTagInfo != WITH_TAG_INFO_EDEFAULT;
    case IAbapTagsPackage.TAGGED_OBJECT_SEARCH_PARAMS__TAG_INFO_TYPE:
      return tagInfoType != TAG_INFO_TYPE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (tagIds: ");
    result.append(tagIds);
    result.append(", searchScope: ");
    result.append(searchScope);
    result.append(", query: ");
    result.append(query);
    result.append(", queryType: ");
    result.append(queryType);
    result.append(", resultGroupLevel: ");
    result.append(resultGroupLevel);
    result.append(", queryFocus: ");
    result.append(queryFocus);
    result.append(", maxResults: ");
    result.append(maxResults);
    result.append(", matchesAllTags: ");
    result.append(matchesAllTags);
    result.append(", withTagInfo: ");
    result.append(withTagInfo);
    result.append(", tagInfoType: ");
    result.append(tagInfoType);
    result.append(')');
    return result.toString();
  }

} // TaggedObjectSearchParams
