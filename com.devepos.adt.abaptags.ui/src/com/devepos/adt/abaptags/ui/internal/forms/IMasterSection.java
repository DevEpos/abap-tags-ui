package com.devepos.adt.abaptags.ui.internal.forms;

/**
 * Describes master section of Master Detail Form
 *
 * @author stockbal
 */
public interface IMasterSection {

	/**
	 * Enables/Disables the selection change in the master detail section
	 *
	 * @param enable if {@code true} the selection will be enabled
	 */
	void enableSelectionChange(boolean enable);

	/**
	 * Returns the difference in height between the text and the text client (if
	 * set). This difference can cause vertical alignment problems when two
	 * expandable composites are placed side by side, one with and one without the
	 * text client. Use this method obtain the value to add to either
	 * {@code descriptionVerticalSpacing} (if you have description) or
	 * {@code clientVerticalSpacing} to correct the alignment of the expandable
	 * without the text client.
	 *
	 * @return the difference in height between the text and the text client or 0 if
	 *         no corrective action is needed.
	 */
	int getTextClientHeightDifference();

	/**
	 * Returns the model of this Master Section
	 * 
	 * @return
	 */
	IModel getModel();
}
