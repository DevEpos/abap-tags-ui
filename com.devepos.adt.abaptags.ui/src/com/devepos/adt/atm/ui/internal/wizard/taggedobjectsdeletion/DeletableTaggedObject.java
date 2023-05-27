package com.devepos.adt.atm.ui.internal.wizard.taggedobjectsdeletion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.CheckboxTableViewer;

import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeletionCheckObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectInfo;
import com.devepos.adt.atm.model.abaptags.TagType;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.model.adtbase.MessageType;

public class DeletableTaggedObject {

  private ITaggedObjectInfo objectInfo;
  private ITaggedObjectDeletionCheckObject deletionCheckInfo;
  private final List<DeletableTaggedObject> childObjects = new ArrayList<>();
  private final Set<DeletableTaggedObject> parentObjects = new HashSet<>();
  private final Set<DeletableTaggedObject> selectedObjectsForDeletion;
  private final CheckboxTableViewer viewer;
  private MessageType transientMessageType;
  private String transientMessage;

  public DeletableTaggedObject(final CheckboxTableViewer viewer,
      final Set<DeletableTaggedObject> selectedObjects) {
    if (viewer == null) {
      throw new IllegalArgumentException("'viewer' must not be null"); //$NON-NLS-1$
    }
    if (selectedObjects == null) {
      throw new IllegalArgumentException("'selectedObjects' must not be null"); //$NON-NLS-1$
    }
    this.viewer = viewer;
    selectedObjectsForDeletion = selectedObjects;
  }

  public void addChildObject(final DeletableTaggedObject object) {
    childObjects.add(object);
  }

  public void addParentObject(final DeletableTaggedObject object) {
    parentObjects.add(object);
  }

  public void clearTransientMessage() {
    transientMessage = null;
    transientMessageType = null;
  }

  public String getComponentName() {
    return objectInfo.getComponentName();
  }

  public String getComponentType() {
    return objectInfo.getComponentType();
  }

  public List<String> getDependentObjectIds() {
    return deletionCheckInfo.getDependentObjectIds();
  }

  public String getId() {
    return objectInfo.getId();
  }

  public String getMessage() {
    var message = deletionCheckInfo.getMessage();
    return message != null ? message : transientMessage;
  }

  public MessageType getMessageType() {
    var messageType = deletionCheckInfo.getMessageType();
    return messageType != null && messageType != MessageType.NONE ? messageType
        : transientMessageType;
  }

  public String getObjectName() {
    return objectInfo.getObjectDisplayName();
  }

  public String getObjectType() {
    return objectInfo.getObjectType();
  }

  public List<String> getParentIds() {
    return null;
  }

  public String getParentObjectName() {
    return objectInfo.getParentObjectDisplayName();
  }

  public String getParentObjectType() {
    return objectInfo.getParentObjectType();
  }

  public String getParentTagId() {
    return objectInfo.getParentTagId();
  }

  public String getParentTagName() {
    return objectInfo.getParentTagName();
  }

  public String getTagId() {
    return objectInfo.getTagId();
  }

  public String getTagName() {
    return objectInfo.getTagName();
  }

  public TagType getTagType() {
    return objectInfo.getTagType();
  }

  public String getTransientMessage() {
    return transientMessage;
  }

  public MessageType getTransientMessageType() {
    return transientMessageType;
  }

  public boolean isDeletable() {
    return deletionCheckInfo.isDeletable();
  }

  public boolean isDeletable(final boolean checkChildren) {
    if (!checkChildren) {
      return deletionCheckInfo.isDeletable();
    }
    if (deletionCheckInfo.isDeletable()) {
      return areChildrenMarkedForDeletion();
    }
    return false;
  }

  public boolean areChildrenMarkedForDeletion() {
    if (childObjects.isEmpty()) {
      return true;
    }
    for (var child : childObjects) {
      if (!selectedObjectsForDeletion.contains(child)) {
        return false;
      }
    }
    return true;
  }

  public void setDeletionCheckInfo(final ITaggedObjectDeletionCheckObject deletionCheckInfo) {
    this.deletionCheckInfo = deletionCheckInfo;
  }

  public void setObjectInfo(final ITaggedObjectInfo objectInfo) {
    this.objectInfo = objectInfo;
  }

  public void setTransientMessage(final String transientMessage) {
    this.transientMessage = transientMessage;
  }

  public void setTransientMessageType(final MessageType transientMessageType) {
    this.transientMessageType = transientMessageType;
  }

  public void uncheckChildren() {
    for (var child : childObjects) {
      selectedObjectsForDeletion.remove(child);
      viewer.setChecked(child, false);
    }

    if (!childObjects.isEmpty()) {
      transientMessageType = MessageType.ERROR;
      transientMessage = String.format(Messages.DeletableTaggedObject_UsedByChildObjectsError_xmsg,
          childObjects.size(), childObjects.size() > 1 ? "s" : ""); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  public void uncheckParents() {
    for (var parent : parentObjects) {
      selectedObjectsForDeletion.remove(parent);
      viewer.setChecked(parent, false);

      parent.uncheckParents();
    }
  }

  public void updateParents() {
    for (var parent : parentObjects) {
      var uncheckedChildCount = parent.getUncheckedChildCount();
      if (uncheckedChildCount > 0) {
        parent.transientMessageType = MessageType.ERROR;
        parent.transientMessage = String.format(
            Messages.DeletableTaggedObject_UsedByChildObjectsError_xmsg, uncheckedChildCount, // $NON-NLS-1$
            uncheckedChildCount > 1 ? "s" : ""); //$NON-NLS-1$ //$NON-NLS-2$
      } else {
        parent.clearTransientMessage();
      }
      viewer.refresh(parent);
      parent.updateParents();
    }
  }

  private int getUncheckedChildCount() {
    int unCheckedCount = 0;
    for (var child : childObjects) {
      if (!selectedObjectsForDeletion.contains(child)) {
        unCheckedCount++;
      }
    }
    return unCheckedCount;
  }
}
