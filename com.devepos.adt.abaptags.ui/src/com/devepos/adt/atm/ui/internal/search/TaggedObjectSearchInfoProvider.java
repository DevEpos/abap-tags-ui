package com.devepos.adt.atm.ui.internal.search;

import java.util.ArrayList;
import java.util.List;

import com.devepos.adt.atm.model.abaptags.IAbapTagsFactory;
import com.devepos.adt.atm.model.abaptags.IAdtObjectTag;
import com.devepos.adt.atm.model.abaptags.ITaggedObject;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectList;
import com.devepos.adt.atm.model.abaptags.ITaggedObjectSearchParams;
import com.devepos.adt.atm.model.abaptags.TagInfoType;
import com.devepos.adt.atm.model.abaptags.TagQueryFocus;
import com.devepos.adt.atm.model.abaptags.TagQueryType;
import com.devepos.adt.atm.search.ITaggedObjectSearchService;
import com.devepos.adt.atm.search.TaggedObjectSearchFactory;
import com.devepos.adt.atm.ui.AbapTagsUIPlugin;
import com.devepos.adt.atm.ui.internal.messages.Messages;
import com.devepos.adt.atm.ui.internal.util.IImages;
import com.devepos.adt.base.adtobject.AdtObjectReferenceModelFactory;
import com.devepos.adt.base.elementinfo.AdtObjectReferenceElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfo;
import com.devepos.adt.base.elementinfo.IElementInfoProvider;
import com.devepos.adt.base.elementinfo.ILazyLoadingElementInfo;
import com.devepos.adt.base.elementinfo.LazyLoadingElementInfo;
import com.devepos.adt.base.model.adtbase.IAdtObjRef;
import com.devepos.adt.base.util.StringUtil;

public class TaggedObjectSearchInfoProvider implements IElementInfoProvider {

    private final String destinationId;
    private final int maxResults;
    private final IAdtObjRef parentObjRef;
    private final IAdtObjectTag tag;

    public TaggedObjectSearchInfoProvider(final String destinationId, final IAdtObjRef adtObjRef,
            final IAdtObjectTag tag, final int maxResults) {
        this.destinationId = destinationId;
        parentObjRef = adtObjRef;
        this.tag = tag;
        this.maxResults = maxResults;
    }

    @Override
    public List<IElementInfo> getElements() {
        final List<IElementInfo> elements = new ArrayList<>();
        final ITaggedObjectSearchParams searchParams = IAbapTagsFactory.eINSTANCE.createTaggedObjectSearchParams();
        searchParams.setMaxResults(maxResults);
        searchParams.setWithTagInfo(true);
        searchParams.setTagInfoType(TagInfoType.CHILDREN);
        searchParams.setQuery(String.format("%s:%s", parentObjRef.getName(), parentObjRef.getTadirType())); //$NON-NLS-1$
        searchParams.setQueryType(TagQueryType.OBJECT_NAME_TYPE_COMBO);
        searchParams.setQueryFocus(TagQueryFocus.PARENT_OBJECT);

        searchParams.getTagIds().add(tag.getId());

        final ITaggedObjectSearchService searchService = TaggedObjectSearchFactory.createTaggedObjectSearchService();
        final ITaggedObjectList taggedObjectList = searchService.findObjects(destinationId, searchParams);
        if (taggedObjectList != null && !taggedObjectList.getTaggedObjects().isEmpty()) {
            for (final ITaggedObject taggedObject : taggedObjectList.getTaggedObjects()) {
                final IAdtObjRef objRef = taggedObject.getObjectRef();
                final AdtObjectReferenceElementInfo objRefElemeInfo = new AdtObjectReferenceElementInfo(objRef
                        .getName(), objRef.getName(), objRef.getDescription());
                objRefElemeInfo.setAdtObjectReference(AdtObjectReferenceModelFactory.createReference(destinationId,
                        objRef));

                for (final IAdtObjectTag tag : taggedObject.getTags()) {
                    final ILazyLoadingElementInfo lazyTagElemInfo = new LazyLoadingElementInfo(tag.getName(),
                            AbapTagsUIPlugin.getDefault()
                                    .getImage(StringUtil.isEmpty(tag.getOwner()) ? IImages.TAG : IImages.USER_TAG),
                            new TaggedObjectSearchInfoProvider(destinationId, objRef, tag, maxResults));
                    objRefElemeInfo.getChildren().add(lazyTagElemInfo);
                }
                objRefElemeInfo.setLazyLoadingSupport(false);
                elements.add(objRefElemeInfo);
            }
        }

        return elements;
    }

    @Override
    public String getProviderDescription() {
        return String.format(Messages.TaggedObjectSearchInfoProvider_LoadingTagsJob_xmsg, tag.getName());
    }

}
