package com.marklogic.query;

/**
 * 
 * @author Sanju Thomas
 *
 */
public enum Operator {
	
	EQ ("$eq");
	
	private String symbol;
	
	private Operator(String symbol){
		this.symbol = symbol;
	}

	@Override
	public String toString(){
		return this.symbol;
	}
}
