package com.devepos.adt.atm.ui.internal.wizard.taggedobjectsdeletion;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectDeleteRequest;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectListRequest;
import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.wizard.AbstractWizardBase;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.wizard.IBaseWizardPage;

/**
 * Wizard to remove Tags from Repository Objects
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class DeleteTaggedObjectsWizard extends AbstractWizardBase {

  private ITaggedObjectListRequest taggedObjectListRequest;
  private ITaggedObjectDeleteRequest deleteRequest;
  private boolean deletionOccurred;

  public DeleteTaggedObjectsWizard() {
    setWindowTitle(Messages.DeleteTaggedObjectsWizard_Title_xtit);
    setDefaultPageImageDescriptor(AbapTagsUIPlugin.getDefault()
        .getImageDescriptor(IImages.DELETE_TAGS_FROM_OBJ_WIZBAN));
    setNeedsProgressMonitor(true);

  }

  @Override
  public void addPages() {
    if (taggedObjectListRequest == null || taggedObjectListRequest.getTaggedObjectIds().isEmpty()
        && taggedObjectListRequest.getTagIds().isEmpty() && taggedObjectListRequest
            .getTaggedObjectInfos()
            .isEmpty()) {
      addPage(new TagSelectionWizardPage());
    }
    addPage(new DeleteTaggedObjectsWizardPage());
  }

  @Override
  public void createPageControls(final Composite pageContainer) {
    /*
     * page controls will be initialized on demand. This ensures that the wizard
     * dialog will not be unnecessarily big at initial open due to some pages
     * needing more space
     */
  }

  public ITaggedObjectListRequest getTaggedObjectListRequest() {
    if (taggedObjectListRequest == null) {
      taggedObjectListRequest = IAbapTagsFactory.eINSTANCE.createTaggedObjectListRequest();
    }
    return taggedObjectListRequest;
  }

  public boolean hasDeletionOccurred() {
    return deletionOccurred;
  }

  @Override
  public boolean performFinish() {
    final IWizardPage currentPage = getContainer().getCurrentPage();
    if (currentPage instanceof IBaseWizardPage) {
      ((IBaseWizardPage) currentPage).completePage();
    }

    try {
      getContainer().run(true, false, monitor -> {
        monitor.beginTask(Messages.DeleteTaggedObjectsWizard_RemovingTagsJobTitle_xmsg, -1);
        var taggingService = AdtObjTaggingServiceFactory.createTaggingService();
        final IStatus status = taggingService.deleteTaggedObjects(DestinationUtil.getDestinationId(
            getProject()), deleteRequest);
        monitor.done();
        if (status.isOK()) {
          deletionOccurred = true;
        } else {
          Display.getDefault().asyncExec(() -> {
            MessageDialog.openError(getShell(), Messages.DeleteTaggedObjectsWizard_ErrorDialog_xtit,
                status.getMessage());
          });
        }
      });
    } catch (final InvocationTargetException e) {
      if (e.getTargetException() instanceof RuntimeException) {
        throw (RuntimeException) e.getTargetException();
      }
      Display.getDefault().asyncExec(() -> {
        final String message = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
        MessageDialog.openError(getShell(), Messages.DeleteTaggedObjectsWizard_ErrorDialog_xtit,
            message);
      });
      return false;
    } catch (final InterruptedException e) {
      return false;
    }
    return true;
  }

  public void setTaggedObjectIdsForDeletion(final List<String> taggedObjectIdsForDeletion) {
    if (deleteRequest == null) {
      deleteRequest = IAbapTagsFactory.eINSTANCE.createTaggedObjectDeleteRequest();
    }
    deleteRequest.getObjectId().clear();
    if (taggedObjectIdsForDeletion != null) {
      deleteRequest.getObjectId().addAll(taggedObjectIdsForDeletion);
    }
  }

}
