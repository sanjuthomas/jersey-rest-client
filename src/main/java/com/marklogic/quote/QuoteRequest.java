package com.marklogic.quote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sanju Thomas
 *
 */
@XmlRootElement(name="QuoteRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuoteRequest {

	public QuoteRequest(){}

	public QuoteRequest(final String id, final String symbol, final int quantity, final Client client){
		this.id = id;
		this.symbol = symbol;
		this.quantity = quantity;
		this.client = client;
	}

	@XmlElement(required=true)
	private String id;
	@XmlElement(required=true)
	private String symbol;
	@XmlElement(required=true)
	private int quantity;
	@XmlElement(required=true)
	private Client client;

	public Client getClient() {
		return this.client;
	}
	public void setClient(final Client client) {
		this.client = client;
	}
	public String getId() {
		return this.id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public String getSymbol() {
		return this.symbol;
	}
	public void setSymbol(final String symbol) {
		this.symbol = symbol;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(final int quantity) {
		this.quantity = quantity;
	}

	public String getURI(){
		final  StringBuilder builder = new StringBuilder();
		builder.append("/");
		builder.append(this.client.getId());
		builder.append("/");
		builder.append(this.client.getAccount().getId());
		builder.append("/");
		builder.append(this.getId());
		builder.append(".xml");
		return builder.toString();
	}

}
