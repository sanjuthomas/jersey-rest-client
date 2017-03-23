package org.sanju.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sanju.quote.Account;
import org.sanju.quote.Client;
import org.sanju.quote.QuoteRequest;
import org.sanju.service.QuoteService;

/**
 *
 * @author Sanju Thomas
 *
 */
public class TestQuoteService {

	private QuoteRequest quoteRequest;
	private QuoteService quoteService;

	@Before
	public void setUp(){
		this.quoteService = new QuoteService();
		final Account account = new Account("A1");
		final Client client = new Client("C1", account);
		this.quoteRequest = new QuoteRequest("Q1", "APPL", 100, client);
	}

	@After
	public void tearDown(){
		this.quoteService.delete("/C1/A1/Q1.xml");
	}

	/**
	 * This test method insert read and delete the document.
	 */

	@Test
	public void shouldInsertOrUpdateQuoteRequest(){

		this.quoteService.insertOrUpdate(this.quoteRequest);
		final QuoteRequest quoteRequest = this.quoteService.get("/C1/A1/Q1.xml");
		Assert.assertEquals("Q1", quoteRequest.getId());
		Assert.assertEquals("C1", quoteRequest.getClient().getId());
		Assert.assertEquals("A1", quoteRequest.getClient().getAccount().getId());
	}

}
