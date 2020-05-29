package com.devepos.adt.atm.ui.internal.preferences;

/**
 * Preference Id's for the ABAP Tags Search
 *
 * @author stockbal
 */
public interface ITaggedObjectSearchPrefs {

	/**
	 * Maximum results that the ABAP Tags Search will return
	 */
	String MAX_RESULTS = "com.devepos.adt.atm.ui.taggedObjectSearch.maxResults";
	/**
	 * Toggle the display of object types for results in the search view
	 */
	String DISPLAY_OBJECT_TYPES = "com.devepos.adt.atm.ui.taggedObjectSearch.displayObjectTypes";
	/**
	 * Toggle the display of packages for results in the search view
	 */
	String DISPLAY_PACKAGES = "com.devepos.adt.atm.ui.taggedObjectSearch.displayPackages";
	/**
	 * Toggle the display of short descriptions for results in the search view
	 */
	String DISPLAY_DESCRIPTIONS = "com.devepos.adt.atm.ui.taggedObjectSearch.displayDescriptions";
}
