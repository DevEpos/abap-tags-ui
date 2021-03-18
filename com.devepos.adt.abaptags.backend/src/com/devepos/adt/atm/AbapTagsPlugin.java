package com.devepos.adt.atm;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class AbapTagsPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.devepos.adt.abaptags.backend"; //$NON-NLS-1$

	// The shared instance
	private static AbapTagsPlugin plugin;

	/**
	 * The constructor
	 */
	public AbapTagsPlugin() {
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
	public static AbapTagsPlugin getDefault() {
		return plugin;
	}

}
