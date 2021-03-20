package com.devepos.adt.atm.model.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.devepos.adt.atm.model.AbapTagsModelPlugin;
import com.devepos.adt.atm.model.abaptags.ITag;
import com.devepos.adt.atm.model.internal.messages.Messages;
import com.devepos.adt.base.util.StringUtil;

/**
 * Validator for a List of {@link ITag}s
 *
 * @author stockbal
 */
public class TagListValidator {

    private final List<ITag> tagList;

    /**
     * Creates new validator for the given {@code tagList}
     *
     * @param tagList the list of the tags that should be validated
     */
    public TagListValidator(final List<ITag> tagList) {
        this.tagList = tagList;
    }

    /**
     * Validates the current list of {@link ITag}s
     *
     * @param rootOnly only the tags on the first layer will be validated. Child
     *                 Tags will be ignored
     * @param newOnly  only tags without tag Id will be validated
     * @return the status of the validation
     */
    public IStatus validate(final boolean rootOnly, final boolean newOnly) {
        return validateTags(tagList, rootOnly, newOnly);
    }

    private IStatus validateTags(final List<ITag> tags, final boolean rootOnly, final boolean newOnly) {
        final Set<String> uniqueTagNames = new HashSet<>();
        final Set<String> uniqueUserTagNames = new HashSet<>();
        for (final ITag tag : tags) {
            if (StringUtil.isBlank(tag.getName())) {
                return new Status(IStatus.ERROR, AbapTagsModelPlugin.PLUGIN_ID,
                        Messages.TagListValidator_NoTagName_xmsg);
            }
            if (tag.getName().length() > 60) {
                return new Status(IStatus.ERROR, AbapTagsModelPlugin.PLUGIN_ID, NLS.bind(
                        Messages.TagListValidator_TagLengthInvalid_xmsg, 60));
            }
            if (tag.getName().contains(">")) { //$NON-NLS-1$
                return new Status(IStatus.ERROR, AbapTagsModelPlugin.PLUGIN_ID, NLS.bind(
                        Messages.TagListValidator_InvalidCharactersInTag_xmsg, ">"));
            }
            boolean tagWasAdded = false;
            boolean addTag = false;
            if (newOnly) {
                if (!StringUtil.isEmpty(tag.getId())) {
                    addTag = true;
                }
            } else {
                addTag = true;
            }
            if (addTag) {
                if (StringUtil.isEmpty(tag.getOwner())) {
                    tagWasAdded = uniqueTagNames.add(tag.getName().toUpperCase());
                } else {
                    tagWasAdded = uniqueUserTagNames.add(tag.getName().toUpperCase());
                }
            }
            if (!tagWasAdded) {
                return new Status(IStatus.ERROR, AbapTagsModelPlugin.PLUGIN_ID, NLS.bind(
                        Messages.TagListValidator_DuplicateTagNameFound_xmsg, tag.getName().toUpperCase()));
            }
        }

        if (!rootOnly) {
            for (final ITag tag : tags) {
                if (!tag.getChildTags().isEmpty()) {
                    final IStatus childTagStatus = validateTags(tag.getChildTags(), false, newOnly);
                    if (!childTagStatus.isOK()) {
                        return childTagStatus;
                    }
                }
            }
        }
        return Status.OK_STATUS;
    }
}
