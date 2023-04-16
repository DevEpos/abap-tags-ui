package com.devepos.adt.atm.ui.internal.wizard.taggedobjectsdeletion;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.ImageUtil;
import com.devepos.adt.atm.ui.internal.util.IColorConstants;
import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.model.adtbase.MessageType;
import com.devepos.adt.base.ui.StylerFactory;
import com.devepos.adt.base.ui.util.AdtTypeUtil;

class TaggedObjectColumnLabelProvider extends CellLabelProvider implements
    DelegatingStyledCellLabelProvider.IStyledLabelProvider, IColorProvider {

  protected final ColumnViewerSpec colSpec;

  public TaggedObjectColumnLabelProvider(final ColumnViewerSpec colSpec) {
    this.colSpec = colSpec;
  }

  @Override
  public Color getBackground(final Object element) {
    return null;
  }

  @Override
  public Color getForeground(final Object element) {
    if ((colSpec != ColumnViewerSpec.ISSUES) && (element instanceof DeletableTaggedObject)) {
      if (!((DeletableTaggedObject) element).isDeletable(true)) {
        return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY);
      }
    }
    return null;
  }

  @Override
  public Image getImage(final Object element) {
    var taggedObject = (DeletableTaggedObject) element;
    return fillNodeImage(taggedObject);
  }

  @Override
  public StyledString getStyledText(final Object element) {
    var nodeText = new StyledString();
    fillNodeText((DeletableTaggedObject) element, nodeText);
    return nodeText;
  }

  @Override
  public void update(final ViewerCell cell) {
  }

  protected Image fillNodeImage(final DeletableTaggedObject taggedObject) {
    Image image = null;
    switch (colSpec) {
    case TAG:
      image = getTagImage(taggedObject);
      break;
    case OBJECT:
      image = getObjectImage(taggedObject);
      break;
    case PARENT_TAG:
      if (taggedObject.getParentTagId() != null) {
        image = getTagImage(taggedObject);
      }
      break;
    case PARENT_OBJECT:
      image = AdtTypeUtil.getInstance().getTypeImage(taggedObject.getParentObjectType());
      break;
    case ISSUES:
      image = getMessageImage(taggedObject.getMessageType());
    default:
      break;
    }
    return image;
  }

  protected void fillNodeText(final DeletableTaggedObject taggedObject,
      final StyledString nodeText) {
    switch (colSpec) {
    case TAG:
      nodeText.append(taggedObject.getTagName());
      break;
    case OBJECT:
      appendObjectName(taggedObject, nodeText);
      break;
    case PARENT_TAG:
      if (taggedObject.getParentTagName() != null) {
        nodeText.append(taggedObject.getParentTagName());
      }
      break;
    case PARENT_OBJECT:
      if (taggedObject.getParentObjectName() != null) {
        nodeText.append(taggedObject.getParentObjectName());
      }
      break;
    case ISSUES:
      if (taggedObject.getMessage() != null) {
        nodeText.append(taggedObject.getMessage());
      }
    default:
      break;
    }
  }

  private void appendObjectName(final DeletableTaggedObject taggedObject, final StyledString text) {
    if (taggedObject.getComponentName() != null) {
      text.append(taggedObject.getComponentName());
      text.append(String.format(" [%s]", taggedObject.getObjectName()), StylerFactory
          .createCustomStyler(SWT.NORMAL, IColorConstants.COMP_PARENT_COLOR, null));
    } else {
      text.append(taggedObject.getObjectName());
    }
  }

  private Image getMessageImage(final MessageType messageType) {
    if (messageType == null) {
      return null;
    }

    switch (messageType) {
    case ERROR:
      return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
    case WARNING:
      return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_WARN_TSK);
    default:
      return null;
    }
  }

  private Image getObjectImage(final DeletableTaggedObject taggedObject) {
    if (taggedObject.getComponentType() != null) {
      return taggedObject.getComponentType().equals(IAdtObjectTypeConstants.LOCAL_CLASS) ? ImageUtil
          .getLocalClassImage() : ImageUtil.getLocalInterfaceImage();
    }
    if (taggedObject.getObjectType() != null) {
      return AdtTypeUtil.getInstance().getTypeImage(taggedObject.getObjectType());
    }
    return null;
  }

  private Image getTagImage(final DeletableTaggedObject element) {
    switch (element.getTagType()) {
    case GLOBAL:
      return AbapTagsUIPlugin.getDefault().getImage(IImages.TAG);
    case USER:
      return AbapTagsUIPlugin.getDefault().getImage(IImages.USER_TAG);
    case SHARED:
      return AbapTagsUIPlugin.getDefault().getImage(IImages.SHARED_TAG);
    }
    return null;
  }

}