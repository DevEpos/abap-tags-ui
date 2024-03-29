package com.devepos.adt.atm.ui;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.IDecoration;
import org.osgi.framework.BundleContext;

import com.devepos.adt.atm.ui.internal.IImages;
import com.devepos.adt.base.ui.AdtBaseUIResources;
import com.devepos.adt.base.ui.IAdtBaseImages;
import com.devepos.adt.base.ui.plugin.AbstractAdtUIPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class AbapTagsUIPlugin extends AbstractAdtUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "com.devepos.adt.abaptags.ui"; // $NON-1$

  // The shared instance
  private static AbapTagsUIPlugin plugin;

  /**
   * The constructor
   */
  public AbapTagsUIPlugin() {
    super(PLUGIN_ID);
  }

  @Override
  public void start(final BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
  }

  @Override
  public void stop(final BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static AbapTagsUIPlugin getDefault() {
    return plugin;
  }

  @Override
  protected void initializeImageRegistry(final ImageRegistry reg) {
    registerImage(reg, IImages.TAG, "icons/Tag.png");
    registerImage(reg, IImages.USER_TAG, "icons/UserTag.png");
    registerImage(reg, IImages.USER_TAGS_FOLDER, "icons/UserTagsFolder.png");
    registerImage(reg, IImages.GLOBAL_TAGS_FOLDER, "icons/TagsFolder.png");
    registerImage(reg, IImages.TAGS_WIZBAN_DEFAULT,
        "icons/wizard/TaggingWizard_Banner_default.png");
    registerImage(reg, IImages.NEW_TAG_ASSIGN_WIZ, "icons/NewTag.png");
    registerImage(reg, IImages.ASSIGN_TAG, "icons/AssignTag.png");
    registerImage(reg, IImages.NEW_USER_TAG, "icons/NewUserTag.png");
    registerImage(reg, IImages.NEW_GLOBAL_TAG, "icons/NewTag.png");
    registerImage(reg, IImages.SHARED_TAG, "icons/SharedTag.png");
    registerImage(reg, IImages.SHARED_TAGS_FOLDER, "icons/SharedTagsFolder.png");
    registerImage(reg, IImages.DELETE_TAGS_WIZBAN, "icons/wizard/DeleteTagsWizard_Banner.png");
    registerImage(reg, IImages.DELETE_TAGS_FROM_OBJ_WIZBAN,
        "icons/wizard/UnassignTagsWizard_Banner_default.png");
    registerImage(reg, IImages.LOCAL_OBJECTS_FOLDER, "icons/LocalObjectsFolder.png");
    registerImage(reg, IImages.LOCAL_N_GLOBAL_TAG_COLL, "icons/LocalAndGlobalTagColl.png");
    registerImage(reg, IImages.REMOVE_ASSIGNED_TAGS, "icons/UnassignTag.png");

    overlayImage(reg.get(IImages.LOCAL_N_GLOBAL_TAG_COLL), IImages.LOCAL_N_GLOBAL_TAG_COLL_DEL_OVR,
        AdtBaseUIResources.getImage(IAdtBaseImages.DELETE_OVR), IDecoration.BOTTOM_RIGHT);
    registerUserTagSharedOverlayImage(reg);
  }

  private void registerUserTagSharedOverlayImage(final ImageRegistry reg) {
    overlayImage(reg.get(IImages.USER_TAG), IImages.USER_TAG_W_SHARED_OVERLAY, AdtBaseUIResources
        .getImage(IAdtBaseImages.SHARE_OVR), IDecoration.BOTTOM_RIGHT);
  }
}
