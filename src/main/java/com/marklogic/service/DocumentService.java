package com.marklogic.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.filter.LoggingFilter;

/**
 *
 * @author Sanju Thomas
 *
 */
public class DocumentService {

	private static final String ML_SERVER = "http://localhost:12000";
	private static final String ML_DOCUMENT_ENDPOINT = "v1/documents";
	private static final String ML_QBE_ENDPOINT = "v1/qbe";
	private static final String ML_SEARCH_ENDPOINT = "v1/search";
	private static final String ML_USERNAME = "admin";
	private static final String ML_PASSWORD = "admin";
	protected static final String URI_PARAM = "uri";

	protected WebTarget getDocumentWebTarget(){

		final Client client = createHttpClient();
		return client.target(ML_SERVER).path(ML_DOCUMENT_ENDPOINT);
	}

	protected WebTarget getQBEWebTarget(){
		
		final Client client = createHttpClient();
		return client.target(ML_SERVER).path(ML_QBE_ENDPOINT);
	}

	protected WebTarget getSearchEndpoint(){
		
		final Client client = createHttpClient();
		return client.target(ML_SERVER).path(ML_SEARCH_ENDPOINT);
	}
	
	private Client createHttpClient() {
		
		final HttpAuthenticationFeature feature = HttpAuthenticationFeature.digest(ML_USERNAME, ML_PASSWORD);
		final Client client = ClientBuilder.newBuilder().build();
		client.register(feature);
		client.register(new LoggingFilter());
		return client;
	}
}
