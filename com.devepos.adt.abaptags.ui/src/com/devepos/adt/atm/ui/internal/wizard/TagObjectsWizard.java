package com.devepos.adt.atm.ui.internal.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
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
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.model.adtbase.IAdtBaseFactory;
import com.devepos.adt.base.model.adtbase.IAdtObjRefList;
import com.devepos.adt.base.ui.wizard.IBaseWizardPage;

/**
 * Wizard for managing the tags of one or several ADT Objects
 *
 * @author stockbal
 */
public class TagObjectsWizard extends Wizard implements ITagObjectsWizard {

    private final ITaggedObjectList taggedObjectList = IAbapTagsFactory.eINSTANCE.createTaggedObjectList();
    private IAdtObjRefList selectedAdtObjRefList = IAdtBaseFactory.eINSTANCE.createAdtObjRefList();
    private ITagPreviewInfo tagPreviewInfo = IAbapTagsFactory.eINSTANCE.createTagPreviewInfo();
    private IProject project;
    private boolean canFinish;
    private final boolean skipObjectSelection;
    private List<ITag> selectedTags;
    private boolean success;

    public TagObjectsWizard() {
        this(false);
    }

    public TagObjectsWizard(final boolean skipObjectSelection) {
        setDefaultPageImageDescriptor(AbapTagsUIPlugin.getDefault().getImageDescriptor(IImages.TAGS_WIZBAN_DEFAULT));
        setWindowTitle(Messages.TagObjectsWizard_WizardTitle_xtit);
        setNeedsProgressMonitor(true);
        this.skipObjectSelection = skipObjectSelection;
    }

    @Override
    public void addPages() {
        if (!skipObjectSelection) {
            addObjectSelectionPage();
        }
        addTagSelectionPage();
        addParentObjectSelectionPage();
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
            if (e.getTargetException() instanceof RuntimeException) {
                throw (RuntimeException) e.getTargetException();
            }
            Display.getDefault().asyncExec(() -> {
                final String message = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
                MessageDialog.openError(getShell(), Messages.AbapTagsView_ErrorMessageTitle_xtit, message);
            });
            return false;
        } catch (final InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean canFinish() {
        return canFinish;
    }

    @Override
    public void setCanFinish(final boolean canFinish) {
        this.canFinish = canFinish;
    }

    @Override
    public void completePreviousPage(final IBaseWizardPage page) {
        final IWizardPage prev = page.getPreviousPage();
        if (prev == null || !(prev instanceof IBaseWizardPage)) {
            return;
        }
        final IBaseWizardPage previousPage = (IBaseWizardPage) prev;

        if (previousPage.isDirty()) {
            previousPage.completePage();
        }
    }

    @Override
    public boolean isPreviousPageDirty(final IBaseWizardPage page) {
        final IWizardPage prev = page.getPreviousPage();
        if (prev == null || !(prev instanceof IBaseWizardPage)) {
            return false;
        }
        return ((IBaseWizardPage) prev).isDirty();
    }

    @Override
    public void clearTaggedObjects() {
        taggedObjectList.getTaggedObjects().clear();
    }

    @Override
    public IAdtObjRefList getSelectedObjects() {
        return selectedAdtObjRefList;
    }

    @Override
    public void setSelectedObjects(final IAdtObjRefList selectedObjects) {
        if (selectedObjects == null) {
            selectedAdtObjRefList.getObjectReferences().clear();
        } else {
            selectedAdtObjRefList = selectedObjects;
        }

    }

    @Override
    public ITaggedObjectList getTaggedObjectList() {
        return taggedObjectList;
    }

    @Override
    public ITagPreviewInfo getCurrentTagPreviewInfo() {
        return tagPreviewInfo;
    }

    @Override
    public void setCurrentTagPreviewInfo(final ITagPreviewInfo tagPreviewInfo) {
        if (tagPreviewInfo != null) {
            this.tagPreviewInfo = tagPreviewInfo;
        } else {
            this.tagPreviewInfo.getTags().clear();
            this.tagPreviewInfo.getAdtObjectRefs().clear();
        }
    }

    @Override
    public IProject getProject() {
        return project;
    }

    @Override
    public void setProject(final IProject project) {
        this.project = project;
    }

    @Override
    public void setSelectedTags(final List<ITag> tags) {
        selectedTags = tags;

    }

    @Override
    public List<ITag> getSelectedTags() {
        if (selectedTags == null) {
            selectedTags = new ArrayList<>();
        }
        return selectedTags;
    }

    private void addTagSelectionPage() {
        final IWizardPage page = new TagSelectionWizardPage();
        addPage(page);
    }

    private void addObjectSelectionPage() {
        final IWizardPage page = new TaggableObjectSelectionWizardPage();
        addPage(page);
    }

    private void addParentObjectSelectionPage() {
        final IWizardPage page = new TagParentObjectSelectionWizardPage();
        addPage(page);
    }
}
