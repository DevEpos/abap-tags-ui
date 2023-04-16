package com.devepos.adt.atm.ui.internal.search;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.RowLayoutFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.abaptags.ITagList;
import com.devepos.adt.atm.model.abaptags.TagSearchScope;
import com.devepos.adt.atm.tags.AbapTagsServiceFactory;
import com.devepos.adt.atm.tags.IAbapTagsService;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.atm.ui.internal.ImageUtil;
import com.devepos.adt.atm.ui.internal.dialogs.TagSelectionDialog;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.base.destinations.DestinationUtil;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.MessageLine;
import com.devepos.adt.base.ui.search.ext.ISearchPageParameterSection;

/**
 * Parameter section to allow the selection of tags.<br>
 * This class can be used to extend other
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class TagSearchParameterSection implements ISearchPageParameterSection {

  private static final List<String> EMPTY_LIST = new ArrayList<>();
  private static final int MIN_WIDTH_TAGS_CONTAINER = 300;

  private Composite tagsContainer;
  private Composite main;
  private String parameterId;
  private IProject project;
  private List<ITag> tags;
  private List<String> selectedTagIds;
  private Job loadTagsJob;
  private ToolItem browseTagsItem;
  private Set<ITag> selectedTags;
  private IStatus enabledStatus;
  private ToolBar toolBar;
  private final IAbapTagsService tagsService;
  private ScrolledComposite scroller;

  public TagSearchParameterSection() {
    tagsService = AbapTagsServiceFactory.createTagsService();
  }

  private class ClosableTag extends Composite {
    private final CLabel tagContent;

    public ClosableTag(final Composite parent, final ITag tag) {
      super(parent, SWT.NONE);
      GridLayoutFactory.swtDefaults().margins(0, 0).numColumns(2).applyTo(this);

      tagContent = new CLabel(this, SWT.NONE);
      tagContent.setImage(ImageUtil.getImageForTag(tag, false));
      tagContent.setText(tag.getName());

      ToolBar toolBar = new ToolBar(this, SWT.FLAT);
      ToolItem item = new ToolItem(toolBar, SWT.PUSH);

      item.addSelectionListener(widgetSelectedAdapter(l -> {
        dispose();
        selectedTags.remove(tag);
        updateTagsScrollerSize();
      }));
      item.setImage(AdtBaseUIResources.getImage(IAdtBaseImages.CLOSE));
    }

  }

  @Override
  public void addLayoutChangeListener(final ILayoutChangeListener l) {
    // not necessary
  }

  @Override
  public void createControl(final Composite parent) {
    main = new Composite(parent, SWT.NONE);

    GridDataFactory.fillDefaults().grab(true, false).applyTo(main);
    GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).applyTo(main);

    Group tagsGroup = new Group(main, SWT.NONE);
    tagsGroup.setText(Messages.TagSearchParameterSection_group_xtit);
    tagsGroup.setLayout(new FillLayout());
    GridDataFactory.fillDefaults()
        .grab(true, false)
        .hint(MIN_WIDTH_TAGS_CONTAINER, 55)
        .applyTo(tagsGroup);

    scroller = new ScrolledComposite(tagsGroup, SWT.V_SCROLL);
    tagsContainer = new Composite(scroller, SWT.NONE);
    RowLayoutFactory.swtDefaults().applyTo(tagsContainer);

    toolBar = new ToolBar(main, SWT.FLAT | SWT.VERTICAL);
    GridDataFactory.fillDefaults()
        .align(SWT.FILL, SWT.BEGINNING)
        .indent(SWT.DEFAULT, 6)
        .applyTo(toolBar);

    scroller.setContent(tagsContainer);
    scroller.setMinSize(MIN_WIDTH_TAGS_CONTAINER, SWT.DEFAULT);
    scroller.setExpandVertical(true);
    scroller.setExpandHorizontal(true);
    scroller.addControlListener(ControlListener.controlResizedAdapter(e -> {
      updateTagsScrollerSize();
    }));

    browseTagsItem = new ToolItem(toolBar, SWT.PUSH);
    browseTagsItem.setToolTipText(Messages.TagSearchParameterSection_selectTags_xbtn);
    browseTagsItem.setImage(AbapTagsUIPlugin.getDefault().getImage(IImages.GLOBAL_TAGS_FOLDER));
    browseTagsItem.addSelectionListener(widgetSelectedAdapter(l -> {
      selectTags();
    }));

    ToolItem clearTags = new ToolItem(toolBar, SWT.PUSH);
    clearTags.setToolTipText(Messages.TagSearchParameterSection_clearTags_xbtn);
    clearTags.setImage(PlatformUI.getWorkbench()
        .getSharedImages()
        .getImage(ISharedImages.IMG_ELCL_REMOVEALL));
    clearTags.addSelectionListener(widgetSelectedAdapter(l -> {
      removeAllTags();
    }));
  }

  @Override
  public String getParameterId() {
    return parameterId;
  }

  @Override
  public List<String> getParameterValues() {
    return selectedTags != null ? selectedTags.stream()
        .map(ITag::getId)
        .collect(Collectors.toList()) : EMPTY_LIST;
  }

  @Override
  public void removeLayoutChangeListener(final ILayoutChangeListener l) {
    // not necessary
  }

  @Override
  public void setEnabledStatus(final IStatus status) {
    enabledStatus = status;
    updateUiEnablement();
  }

  @Override
  public void setParameterId(final String parameterId) {
    this.parameterId = parameterId;
  }

  @Override
  public void setParameterValues(final List<String> paramValues) {
    selectedTagIds = paramValues != null ? new ArrayList<>(paramValues) : null;

    if (tags != null && !tags.isEmpty() && tagsContainer != null && !tagsContainer.isDisposed()) {
      determineSelectedTags();
    }
  }

  @Override
  public void setProject(final IProject project) {
    if (project == null || project != this.project) {
      removeAllTags();
      this.project = project;
      browseTagsItem.setEnabled(false);

      if (project != null && tagsService.testTagsFeatureAvailability(project).isOK()) {
        loadTags();
      }
    }
  }

  private void clearTagsContainer() {
    Control[] tags = tagsContainer.getChildren();
    for (Control tag : tags) {
      tag.dispose();
    }
  }

  private void determineSelectedTags() {
    if (selectedTagIds == null || selectedTagIds.isEmpty()) {
      return;
    }
    if (selectedTags != null) {
      selectedTags.clear();
    } else {
      selectedTags = new HashSet<>();
    }
    determineTagsFromIds(tags);

    for (ITag selectedTag : selectedTags) {
      new ClosableTag(tagsContainer, selectedTag);
    }

    if (selectedTags != null) {
      updateTagsScrollerSize();
    }
  }

  private void determineTagsFromIds(final List<ITag> tags) {
    for (ITag tag : tags) {
      if (selectedTagIds.isEmpty()) {
        break;
      }
      if (selectedTagIds.remove(tag.getId())) {
        selectedTags.add(tag);
      }
      if (selectedTagIds.isEmpty()) {
        break;
      }
      if (!tag.getChildTags().isEmpty()) {
        determineTagsFromIds(tag.getChildTags());
      }
    }

  }

  private boolean isUiAvailable() {
    return main != null && !main.isDisposed();
  }

  private void loadTags() {
    if (loadTagsJob != null && loadTagsJob.getResult() == null) {
      loadTagsJob.cancel();
    }
    tags = null;
    loadTagsJob = Job.createSystem(Messages.TaggedObjectSearchPage_LoadingTagsJob_xmsg, monitor -> {
      final ITagList tagList = tagsService.readTags(DestinationUtil.getDestinationId(project),
          TagSearchScope.ALL, false);
      monitor.done();
      if (tagList != null) {
        tags = tagList.getTags();
        loadTagsJob = null;
      }
      if (browseTagsItem != null) {
        Display.getDefault().asyncExec(() -> {
          browseTagsItem.setEnabled(tags != null && !tags.isEmpty());
          determineSelectedTags();
        });
      }
    });
    loadTagsJob.schedule();
  }

  private void removeAllTags() {
    selectedTags = null;
    if (!isUiAvailable()) {
      return;
    }
    clearTagsContainer();
    tagsContainer.layout();
    updateTagsScrollerSize();
  }

  private void selectTags() {
    while (loadTagsJob != null && loadTagsJob.getResult() == null) {
      continue;
    }

    List<String> currentlySelectedTagIds = null;
    if (selectedTags != null && !selectedTags.isEmpty()) {
      currentlySelectedTagIds = selectedTags.stream().map(ITag::getId).collect(Collectors.toList());
    }
    TagSelectionDialog selectionDialog = new TagSelectionDialog(main.getShell(),
        currentlySelectedTagIds, tags);
    if (selectionDialog.open() == Window.OK) {
      removeAllTags();
      selectedTags = selectionDialog.getSelectedTags();
      if (selectedTags != null) {
        for (ITag tag : selectedTags) {
          new ClosableTag(tagsContainer, tag);
        }
        updateTagsScrollerSize();
      }
    }
  }

  private void updateTagsScrollerSize() {
    tagsContainer.layout();
    Rectangle r = scroller.getClientArea();
    scroller.setMinSize(tagsContainer.computeSize(r.width, SWT.DEFAULT));
  }

  private void updateUiEnablement() {
    if (!isUiAvailable()) {
      return;
    }
    clearTagsContainer();

    if (enabledStatus != null && !enabledStatus.isOK()) {
      toolBar.setEnabled(false);
      MessageLine ml = new MessageLine(tagsContainer);
      ml.setStatus(enabledStatus);
    } else {
      toolBar.setEnabled(true);
    }

    updateTagsScrollerSize();
  }
}
