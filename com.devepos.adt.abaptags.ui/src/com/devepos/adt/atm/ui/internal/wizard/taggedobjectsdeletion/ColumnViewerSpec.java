package com.devepos.adt.atm.ui.internal.wizard.taggedobjectsdeletion;

import com.devepos.adt.atm.ui.internal.messages.Messages;

enum ColumnViewerSpec {
  TAG(150, Messages.DeleteTagsWizardPage_TagColumn_xtit),
  OBJECT(225, Messages.ColumnViewerSpec_ObjectColumn_xtit),
  PARENT_TAG(150, Messages.ColumnViewerSpec_ParentTagColumn_xtit),
  PARENT_OBJECT(225, Messages.ColumnViewerSpec_ParentObjectColumn_xtit),
  ISSUES(150, Messages.ColumnViewerSpec_IssuesColumn_xtit);

  public final int defaultWidth;
  public final String headerText;

  ColumnViewerSpec(final int width, final String headerText) {
    defaultWidth = width;
    this.headerText = headerText;
  }
}
