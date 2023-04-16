package com.devepos.adt.atm.ui.internal.util;

import org.eclipse.jface.viewers.StyledString;

import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.IAdtObjectTypeConstants;
import com.devepos.adt.base.ui.tree.IAdtObjectReferenceNode;
import com.devepos.adt.base.ui.util.AdtTypeUtil;
import com.sap.adt.project.IProjectProvider;

public class AdtObjectUtil {

  /**
   * Appends type description to the given styled string
   *
   * @param objRefNode Object reference Node
   * @param text       styled string for display in a Viewer
   */
  public static void appendAdtTypeDescription(final IAdtObjectReferenceNode objRefNode,
      final StyledString text) {
    var type = objRefNode.getAdtObjectType();
    if (type != null) {
      AdtTypeUtil typeUtil = AdtTypeUtil.getInstance();
      String typeLabel = null;
      if (type.equals(IAdtObjectTypeConstants.LOCAL_CLASS)) {
        typeLabel = Messages.TypeLabels_LocalClass_xlbl;
      } else if (type.equals(IAdtObjectTypeConstants.LOCAL_INTERFACE)) {
        typeLabel = Messages.TypeLabels_LocalInterface_xlbl;
      } else {
        typeLabel = typeUtil.getTypeDescription(type);
        if (typeLabel == null) {
          var projectProvider = objRefNode.getAdapter(IProjectProvider.class);
          if (projectProvider != null) {
            typeLabel = typeUtil.getTypeDescriptionByProject(type, projectProvider.getProject());
            if (typeLabel == null) {
              // finally try to read the type of the TADIR type
              typeLabel = typeUtil.getTypeDescriptionByProject(type.substring(0, 4), projectProvider
                  .getProject());
            }
          }
        }
      }
      if (typeLabel != null) {
        text.append(String.format(" (%s)", typeLabel), StyledString.QUALIFIER_STYLER);
      }
    }
  }
}
