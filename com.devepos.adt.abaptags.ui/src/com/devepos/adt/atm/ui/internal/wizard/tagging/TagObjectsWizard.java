package com.devepos.adt.atm.ui.internal.wizard.tagging;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagPreviewInfo;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.tagging.AdtObjTaggingServiceFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.wizard.AbstractWizardBase;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.base.ui.wizard.IBaseWizardPage;

/**
 * Wizard for managing the tags of one or several ADT Objects
 *
 * @author stockbal
 */
public class TagObjectsWizard extends AbstractWizardBase {

  private final ITaggedObjectList taggedObjectList = IAbapTagsFactory.eINSTANCE
      .createTaggedObjectList();
  private IAdtObjRefList selectedAdtObjRefList = IAdtBaseFactory.eINSTANCE.createAdtObjRefList();
  private ITagPreviewInfo tagPreviewInfo = IAbapTagsFactory.eINSTANCE.createTagPreviewInfo();
  private final boolean skipObjectSelection;
  private List<ITag> selectedTags;
  private boolean success;

  public TagObjectsWizard() {
    this(false);
  }

  public TagObjectsWizard(final boolean skipObjectSelection) {
    setDefaultPageImageDescriptor(AbapTagsUIPlugin.getDefault()
        .getImageDescriptor(IImages.TAGS_WIZBAN_DEFAULT));
    setWindowTitle(Messages.TagObjectsWizard_WizardTitle_xtit);
    setNeedsProgressMonitor(true);
    this.skipObjectSelection = skipObjectSelection;
  }

  @Override
  public void addPages() {
    if (!skipObjectSelection) {
      addPage(new TaggableObjectSelectionWizardPage());
    }
    addPage(new TagSelectionWizardPage());
    addPage(new TagParentObjectSelectionWizardPage());
  }

  /**
   * Returns {@code true} if the tagging wizard completed with success
   *
   * @return {@code true} if the tagging wizard completed with success
   */
  public boolean wasSuccessful() {
    return success;
  }

  @Override
  public void createPageControls(final Composite pageContainer) {
    /*
     * page controls will be initialized on demand. This ensures that the wizard
     * dialog will not be unnecessarily big at initial open due to some pages
     * needing more space
     */
  }

  @Override
  public boolean performFinish() {
    var project = getProject();
    if (project == null) {
      return false;
    }
    // complete current page
    final IWizardPage currentPage = getContainer().getCurrentPage();
    if (currentPage instanceof IBaseWizardPage) {
      ((IBaseWizardPage) currentPage).completePage();
    }
    try {
      getContainer().run(true, false, monitor -> {
        monitor.beginTask(Messages.TagObjectsWizard_AddTagsToObjectsJob_xmsg, -1);
        try {
          AdtObjTaggingServiceFactory.createTaggingService()
              .saveTaggedObjects(DestinationUtil.getDestinationId(project), taggedObjectList);
          success = true;
        } catch (final CoreException e) {
          throw new InvocationTargetException(e);
        }
      });
    } catch (final InvocationTargetException e) {
      Display.getDefault().asyncExec(() -> {
        final String message = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
        MessageDialog.openError(getShell(), Messages.AbapTagManagerView_ErrorMessageTitle_xtit,
            message);
      });
      return false;
    } catch (final InterruptedException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public void clearTaggedObjects() {
    taggedObjectList.getTaggedObjects().clear();
  }

  public IAdtObjRefList getSelectedObjects() {
    return selectedAdtObjRefList;
  }

  public void setSelectedObjects(final IAdtObjRefList selectedObjects) {
    if (selectedObjects == null) {
      selectedAdtObjRefList.getObjectReferences().clear();
    } else {
      selectedAdtObjRefList = selectedObjects;
    }

  }

  public ITaggedObjectList getTaggedObjectList() {
    return taggedObjectList;
  }

  public ITagPreviewInfo getCurrentTagPreviewInfo() {
    return tagPreviewInfo;
  }

  public void setCurrentTagPreviewInfo(final ITagPreviewInfo tagPreviewInfo) {
    if (tagPreviewInfo != null) {
      this.tagPreviewInfo = tagPreviewInfo;
    } else {
      this.tagPreviewInfo.getTags().clear();
      this.tagPreviewInfo.getAdtObjectRefs().clear();
    }
  }

  public void setSelectedTags(final List<ITag> tags) {
    selectedTags = tags;

  }

  public List<ITag> getSelectedTags() {
    if (selectedTags == null) {
      selectedTags = new ArrayList<>();
    }
    return selectedTags;
  }
}
