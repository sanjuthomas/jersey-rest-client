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

		super.getInvocationBuilder().queryParam("uri", quoteRequest.getURI()).request()
		.put(Entity.entity(quoteRequest, MediaType.APPLICATION_ATOM_XML_TYPE));
	}

	public QuoteRequest find(final String uri) {

		return super.getInvocationBuilder().queryParam("uri", "C1-A1-Q1").request(MediaType.APPLICATION_JSON)
				.get(QuoteRequest.class);
	}

	public void delete(final String uri) {

		super.getInvocationBuilder().queryParam("uri", uri).request().delete();
	}

}
