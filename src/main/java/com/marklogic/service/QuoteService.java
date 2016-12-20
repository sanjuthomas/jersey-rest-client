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

		super.getDocumentWebTarget().queryParam(URI_PARAM, quoteRequest.getURI()).request()
		.put(Entity.entity(quoteRequest, MediaType.APPLICATION_ATOM_XML_TYPE));
	}

	public QuoteRequest get(final String uri) {

		return super.getDocumentWebTarget().queryParam(URI_PARAM, uri).request()
				.get(QuoteRequest.class);
	}

	public void delete(final String uri) {

		super.getDocumentWebTarget().queryParam(URI_PARAM, uri).request().delete();
	}
	
	public QuoteRequest findByElement(String key, String value){
		
		
		return null;
		
	}

}
