package com.devepos.adt.abaptags.internal.tags.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.devepos.adt.abaptags.ITags;
import com.devepos.adt.abaptags.util.AbapTagsResourceFactory;
import com.sap.adt.communication.content.AdtMediaType;
import com.sap.adt.communication.content.ContentHandlerException;
import com.sap.adt.communication.content.IContentHandler;
import com.sap.adt.communication.message.AbstractMessageBody;
import com.sap.adt.communication.message.IMessageBody;

public class AbapTagsContentHandler implements IContentHandler<ITags> {
	private static final String RESOURCE_NAME = "abaptags-resource";
	private final URI virtualResourceUri = URI.createURI(RESOURCE_NAME);

	@Override
	public ITags deserialize(final IMessageBody body, final Class<? extends ITags> tags) {
		try {
			final InputStream content = body.getContent();
			final Resource resource = new AbapTagsResourceFactory().createResource(this.virtualResourceUri);
			resource.load(content, getOptions());
			return loadEmf(resource);
		} catch (final IOException e) {
			throw new ContentHandlerException("Error while loading ABAP Tags", e);
		}
	}

	@Override
	public String getSupportedContentType() {
		return AdtMediaType.APPLICATION_XML;
	}

	@Override
	public Class<ITags> getSupportedDataType() {
		return ITags.class;
	}

	@Override
	public IMessageBody serialize(final ITags tags, final Charset charset) {
		Resource resource = tags.eResource();
		if (resource == null) {
			resource = new AbapTagsResourceFactory().createResource(this.virtualResourceUri);
			final EList<EObject> resourceContents = resource.getContents();
			resourceContents.add(tags);
		}
		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(4096);
		try {
			resource.save(outputStream, getOptions());
		} catch (final IOException e) {
			throw new ContentHandlerException("Error while saving ABAP Tags", e);
		}
		return new MessageBody(outputStream);
	}

	/**
	 * Gets options for EMF resource loading/saving
	 *
	 * @return
	 */
	protected Map<String, Object> getOptions() {
		final Map<String, Object> options = new HashMap<>();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");
		return options;
	}

	public ITags loadEmf(final Resource resource) {
		final EObject documentRoot = resource.getContents().get(0);
		if (documentRoot != null && documentRoot instanceof ITags) {
			return (ITags) documentRoot;
		}
		throw new IllegalArgumentException("Invalid XML content - root model entity not found");
	}

	private class MessageBody extends AbstractMessageBody {
		ByteArrayInputStream stream;

		protected MessageBody(final ByteArrayOutputStream outputStream) {
			super(AdtMediaType.APPLICATION_XML);
			this.stream = new ByteArrayInputStream(outputStream.toByteArray(), 0, outputStream.size());
		}

		@Override
		public InputStream getContent() throws IOException {
			return this.stream;
		}
	}
}
