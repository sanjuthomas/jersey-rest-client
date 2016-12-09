package com.marklogic.service;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import com.marklogic.quote.QuoteRequest;

/**
 *
 * @author Sanju Thomas
 *
 */
public class QuoteService extends DocumentService {

	public void insertOrUpdate(final QuoteRequest quoteRequest) {

		super.getWebTarget().queryParam(URI_PARAM, quoteRequest.getURI()).request()
		.put(Entity.entity(quoteRequest, MediaType.APPLICATION_ATOM_XML_TYPE));
	}

	public QuoteRequest find(final String uri) {

		return super.getWebTarget().queryParam(URI_PARAM, uri).request(MediaType.APPLICATION_XML)
				.get(QuoteRequest.class);
	}

	public void delete(final String uri) {

		super.getWebTarget().queryParam(URI_PARAM, uri).request().delete();
	}

}
