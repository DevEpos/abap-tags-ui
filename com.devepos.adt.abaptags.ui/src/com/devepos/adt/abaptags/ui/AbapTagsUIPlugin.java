package com.devepos.adt.abaptags.ui;

import org.eclipse.jface.resource.ImageRegistry;
import org.osgi.framework.BundleContext;

import com.devepos.adt.abaptags.ui.internal.util.IImages;
import com.devepos.adt.tools.base.plugin.AbstractAdtUIPlugin;

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
		registerImage(reg, IImages.GLOBE, "icons/Globe.png");
		registerImage(reg, IImages.USER, "icons/User.png");
		registerImage(reg, IImages.USER_TAGS_FOLDER, "icons/UserTagsFolder.png");
		registerImage(reg, IImages.GLOBAL_TAGS_FOLDER, "icons/TagsFolder.png");
		registerImage(reg, IImages.TAGS_WIZBAN_DEFAULT, "icons/wizard/TaggingWizard_Banner_default.png");
	}

}
