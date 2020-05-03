/**
 */
package com.devepos.adt.abaptags.impl;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.devepos.adt.abaptags.IAbapTagsPackage;
import com.devepos.adt.abaptags.ITag;
import com.devepos.adt.abaptags.model.AbapTagsModelPlugin;
import com.devepos.adt.abaptags.model.internal.messages.Messages;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Tag</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.devepos.adt.abaptags.impl.Tag#getDescription <em>Description</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.Tag#getChildTags <em>Child Tags</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.Tag#isIsRoot <em>Is Root</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.Tag#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.Tag#getCreatedBy <em>Created By</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.Tag#getCreatedDateTime <em>Created Date Time</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.Tag#getChangedBy <em>Changed By</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.Tag#getChangedDateTime <em>Changed Date Time</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.Tag#getTaggedObjectCount <em>Tagged Object Count</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.Tag#isChanged <em>Changed</em>}</li>
 *   <li>{@link com.devepos.adt.abaptags.impl.Tag#getParentTagId <em>Parent Tag Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Tag extends TagBase implements ITag {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChildTags() <em>Child Tags</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildTags()
	 * @generated
	 * @ordered
	 */
	protected EList<ITag> childTags;

	/**
	 * The default value of the '{@link #isIsRoot() <em>Is Root</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsRoot()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ROOT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsRoot() <em>Is Root</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsRoot()
	 * @generated
	 * @ordered
	 */
	protected boolean isRoot = IS_ROOT_EDEFAULT;

	/**
	 * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see       #getOwner()
	 * @generated
	 * @ordered
	 */
	protected static final String OWNER_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see       #getOwner()
	 * @generated
	 * @ordered
	 */
	protected String owner = OWNER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreatedBy() <em>Created By</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreatedBy()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATED_BY_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getCreatedBy() <em>Created By</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreatedBy()
	 * @generated
	 * @ordered
	 */
	protected String createdBy = CREATED_BY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreatedDateTime() <em>Created Date Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreatedDateTime()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATED_DATE_TIME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getCreatedDateTime() <em>Created Date Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCreatedDateTime()
	 * @generated
	 * @ordered
	 */
	protected String createdDateTime = CREATED_DATE_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getChangedBy() <em>Changed By</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getChangedBy()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANGED_BY_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getChangedBy() <em>Changed By</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getChangedBy()
	 * @generated
	 * @ordered
	 */
	protected String changedBy = CHANGED_BY_EDEFAULT;

	/**
	 * The default value of the '{@link #getChangedDateTime() <em>Changed Date Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getChangedDateTime()
	 * @generated
	 * @ordered
	 */
	protected static final String CHANGED_DATE_TIME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getChangedDateTime() <em>Changed Date Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getChangedDateTime()
	 * @generated
	 * @ordered
	 */
	protected String changedDateTime = CHANGED_DATE_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTaggedObjectCount() <em>Tagged Object Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTaggedObjectCount()
	 * @generated
	 * @ordered
	 */
	protected static final int TAGGED_OBJECT_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTaggedObjectCount() <em>Tagged Object Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTaggedObjectCount()
	 * @generated
	 * @ordered
	 */
	protected int taggedObjectCount = TAGGED_OBJECT_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #isChanged() <em>Changed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChanged()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHANGED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isChanged() <em>Changed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChanged()
	 * @generated
	 * @ordered
	 */
	protected boolean changed = CHANGED_EDEFAULT;

	/**
	 * The default value of the '{@link #getParentTagId() <em>Parent Tag Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentTagId()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_TAG_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentTagId() <em>Parent Tag Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentTagId()
	 * @generated
	 * @ordered
	 */
	protected String parentTagId = PARENT_TAG_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Tag() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IAbapTagsPackage.Literals.TAG;
	}

	@Override
	public IStatus validate() {
		if (this.name == null || this.name.isBlank()) {
			return new Status(IStatus.ERROR, AbapTagsModelPlugin.PLUGIN_ID, Messages.Tag_NameInvalid_xmsg);
		}
		return Status.OK_STATUS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAG__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ITag> getChildTags() {
		if (childTags == null) {
			childTags = new EObjectContainmentEList<ITag>(ITag.class, this, IAbapTagsPackage.TAG__CHILD_TAGS);
		}
		return childTags;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsRoot() {
		return isRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsRoot(boolean newIsRoot) {
		boolean oldIsRoot = isRoot;
		isRoot = newIsRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAG__IS_ROOT, oldIsRoot, isRoot));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwner(String newOwner) {
		String oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAG__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreatedBy(String newCreatedBy) {
		String oldCreatedBy = createdBy;
		createdBy = newCreatedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAG__CREATED_BY, oldCreatedBy, createdBy));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreatedDateTime() {
		return createdDateTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreatedDateTime(String newCreatedDateTime) {
		String oldCreatedDateTime = createdDateTime;
		createdDateTime = newCreatedDateTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAG__CREATED_DATE_TIME, oldCreatedDateTime, createdDateTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getChangedBy() {
		return changedBy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setChangedBy(String newChangedBy) {
		String oldChangedBy = changedBy;
		changedBy = newChangedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAG__CHANGED_BY, oldChangedBy, changedBy));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getChangedDateTime() {
		return changedDateTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setChangedDateTime(String newChangedDateTime) {
		String oldChangedDateTime = changedDateTime;
		changedDateTime = newChangedDateTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAG__CHANGED_DATE_TIME, oldChangedDateTime, changedDateTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTaggedObjectCount() {
		return taggedObjectCount;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTaggedObjectCount(int newTaggedObjectCount) {
		int oldTaggedObjectCount = taggedObjectCount;
		taggedObjectCount = newTaggedObjectCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAG__TAGGED_OBJECT_COUNT, oldTaggedObjectCount, taggedObjectCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isChanged() {
		return changed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setChanged(boolean newChanged) {
		boolean oldChanged = changed;
		changed = newChanged;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAG__CHANGED, oldChanged, changed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getParentTagId() {
		return parentTagId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentTagId(String newParentTagId) {
		String oldParentTagId = parentTagId;
		parentTagId = newParentTagId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IAbapTagsPackage.TAG__PARENT_TAG_ID, oldParentTagId, parentTagId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IAbapTagsPackage.TAG__CHILD_TAGS:
				return ((InternalEList<?>)getChildTags()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IAbapTagsPackage.TAG__DESCRIPTION:
				return getDescription();
			case IAbapTagsPackage.TAG__CHILD_TAGS:
				return getChildTags();
			case IAbapTagsPackage.TAG__IS_ROOT:
				return isIsRoot();
			case IAbapTagsPackage.TAG__OWNER:
				return getOwner();
			case IAbapTagsPackage.TAG__CREATED_BY:
				return getCreatedBy();
			case IAbapTagsPackage.TAG__CREATED_DATE_TIME:
				return getCreatedDateTime();
			case IAbapTagsPackage.TAG__CHANGED_BY:
				return getChangedBy();
			case IAbapTagsPackage.TAG__CHANGED_DATE_TIME:
				return getChangedDateTime();
			case IAbapTagsPackage.TAG__TAGGED_OBJECT_COUNT:
				return getTaggedObjectCount();
			case IAbapTagsPackage.TAG__CHANGED:
				return isChanged();
			case IAbapTagsPackage.TAG__PARENT_TAG_ID:
				return getParentTagId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IAbapTagsPackage.TAG__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case IAbapTagsPackage.TAG__CHILD_TAGS:
				getChildTags().clear();
				getChildTags().addAll((Collection<? extends ITag>)newValue);
				return;
			case IAbapTagsPackage.TAG__IS_ROOT:
				setIsRoot((Boolean)newValue);
				return;
			case IAbapTagsPackage.TAG__OWNER:
				setOwner((String)newValue);
				return;
			case IAbapTagsPackage.TAG__CREATED_BY:
				setCreatedBy((String)newValue);
				return;
			case IAbapTagsPackage.TAG__CREATED_DATE_TIME:
				setCreatedDateTime((String)newValue);
				return;
			case IAbapTagsPackage.TAG__CHANGED_BY:
				setChangedBy((String)newValue);
				return;
			case IAbapTagsPackage.TAG__CHANGED_DATE_TIME:
				setChangedDateTime((String)newValue);
				return;
			case IAbapTagsPackage.TAG__TAGGED_OBJECT_COUNT:
				setTaggedObjectCount((Integer)newValue);
				return;
			case IAbapTagsPackage.TAG__CHANGED:
				setChanged((Boolean)newValue);
				return;
			case IAbapTagsPackage.TAG__PARENT_TAG_ID:
				setParentTagId((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case IAbapTagsPackage.TAG__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case IAbapTagsPackage.TAG__CHILD_TAGS:
				getChildTags().clear();
				return;
			case IAbapTagsPackage.TAG__IS_ROOT:
				setIsRoot(IS_ROOT_EDEFAULT);
				return;
			case IAbapTagsPackage.TAG__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case IAbapTagsPackage.TAG__CREATED_BY:
				setCreatedBy(CREATED_BY_EDEFAULT);
				return;
			case IAbapTagsPackage.TAG__CREATED_DATE_TIME:
				setCreatedDateTime(CREATED_DATE_TIME_EDEFAULT);
				return;
			case IAbapTagsPackage.TAG__CHANGED_BY:
				setChangedBy(CHANGED_BY_EDEFAULT);
				return;
			case IAbapTagsPackage.TAG__CHANGED_DATE_TIME:
				setChangedDateTime(CHANGED_DATE_TIME_EDEFAULT);
				return;
			case IAbapTagsPackage.TAG__TAGGED_OBJECT_COUNT:
				setTaggedObjectCount(TAGGED_OBJECT_COUNT_EDEFAULT);
				return;
			case IAbapTagsPackage.TAG__CHANGED:
				setChanged(CHANGED_EDEFAULT);
				return;
			case IAbapTagsPackage.TAG__PARENT_TAG_ID:
				setParentTagId(PARENT_TAG_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IAbapTagsPackage.TAG__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case IAbapTagsPackage.TAG__CHILD_TAGS:
				return childTags != null && !childTags.isEmpty();
			case IAbapTagsPackage.TAG__IS_ROOT:
				return isRoot != IS_ROOT_EDEFAULT;
			case IAbapTagsPackage.TAG__OWNER:
				return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
			case IAbapTagsPackage.TAG__CREATED_BY:
				return CREATED_BY_EDEFAULT == null ? createdBy != null : !CREATED_BY_EDEFAULT.equals(createdBy);
			case IAbapTagsPackage.TAG__CREATED_DATE_TIME:
				return CREATED_DATE_TIME_EDEFAULT == null ? createdDateTime != null : !CREATED_DATE_TIME_EDEFAULT.equals(createdDateTime);
			case IAbapTagsPackage.TAG__CHANGED_BY:
				return CHANGED_BY_EDEFAULT == null ? changedBy != null : !CHANGED_BY_EDEFAULT.equals(changedBy);
			case IAbapTagsPackage.TAG__CHANGED_DATE_TIME:
				return CHANGED_DATE_TIME_EDEFAULT == null ? changedDateTime != null : !CHANGED_DATE_TIME_EDEFAULT.equals(changedDateTime);
			case IAbapTagsPackage.TAG__TAGGED_OBJECT_COUNT:
				return taggedObjectCount != TAGGED_OBJECT_COUNT_EDEFAULT;
			case IAbapTagsPackage.TAG__CHANGED:
				return changed != CHANGED_EDEFAULT;
			case IAbapTagsPackage.TAG__PARENT_TAG_ID:
				return PARENT_TAG_ID_EDEFAULT == null ? parentTagId != null : !PARENT_TAG_ID_EDEFAULT.equals(parentTagId);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (description: ");
		result.append(description);
		result.append(", isRoot: ");
		result.append(isRoot);
		result.append(", owner: ");
		result.append(owner);
		result.append(", createdBy: ");
		result.append(createdBy);
		result.append(", createdDateTime: ");
		result.append(createdDateTime);
		result.append(", changedBy: ");
		result.append(changedBy);
		result.append(", changedDateTime: ");
		result.append(changedDateTime);
		result.append(", taggedObjectCount: ");
		result.append(taggedObjectCount);
		result.append(", changed: ");
		result.append(changed);
		result.append(", parentTagId: ");
		result.append(parentTagId);
		result.append(')');
		return result.toString();
	}

} // Tag
