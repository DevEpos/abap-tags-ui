package com.devepos.adt.atm.ui.internal.wizard.tagdeletion;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.wizard.AbstractWizardBase;
import com.devepos.adt.base.destinations.DestinationUtil;

public class DeleteTagsWizard extends AbstractWizardBase {

  private final ITagList tagsForDeletion;
  private boolean deletionOccurred;
  private final Set<String> selectedTagsForDeletion = new HashSet<>();

  public DeleteTagsWizard(final ITagList tagList) {
    tagsForDeletion = tagList;
    setWindowTitle(Messages.DeleteTagsWizard_WizardTitle_xtit);
    setDefaultPageImageDescriptor(AbapTagsUIPlugin.getDefault()
        .getImageDescriptor(IImages.DELETE_TAGS_WIZBAN));
    setNeedsProgressMonitor(true);
  }

  @Override
  public void addPages() {
    addPage(new DeleteTagsWizardPage());
  }

  public ITagList getTagsForDeletion() {
    return tagsForDeletion;
  }

  public boolean hasDeletionOccurred() {
    return deletionOccurred;
  }

  @Override
  public boolean performFinish() {
    var tagsService = AbapTagsServiceFactory.createTagsService();
    final IStatus status = tagsService.deleteTags(getFinalizedTagsForDeletion(), DestinationUtil
        .getDestinationId(getProject()), TagSearchScope.ALL);
    if (status.isOK()) {
      deletionOccurred = true;
      return true;
    }
    Display.getDefault().asyncExec(() -> {
      MessageDialog.openError(getShell(), Messages.AbapTagManagerView_ErrorMessageTitle_xtit,
          Messages.AbapTagManagerView_ErrorDuringTagDeletion_xmsg + status.getMessage());
    });
    return false;
  }

  public void setTagCheckedForDeletion(final String tagId, final boolean checked) {
    if (checked) {
      selectedTagsForDeletion.add(tagId);
    } else {
      selectedTagsForDeletion.remove(tagId);
    }
  }

  private ITagList getFinalizedTagsForDeletion() {
    var tagList = IAbapTagsFactory.eINSTANCE.createTagList();
    for (var tag : tagsForDeletion.getTags()) {
      if (selectedTagsForDeletion.contains(tag.getId())) {
        var tagToBeDeleted = IAbapTagsFactory.eINSTANCE.createTag();
        tagToBeDeleted.setId(tag.getId());
        tagList.getTags().add(tagToBeDeleted);
      }

    }
    return tagList;
  }

}
