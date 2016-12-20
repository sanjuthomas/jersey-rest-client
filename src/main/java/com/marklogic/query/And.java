package com.marklogic.query;

/**
 * 
 * @author Sanju Thomas
 * 
 * {"price" : { "$eq": 10.00 } }
 *
 */
public class And {
	
	private String key;
	private Object value;
	private Operator operator;
	
	public And(String key, Object value, Operator operator){
		this.key = key;
		this.value = value;
		this.operator = operator;
	}
	
	public String and(){
		
		StringBuilder builder = new StringBuilder();
		builder.append(" { ");
		builder.append(key);
		builder.append(" : ");
		builder.append(" { ");
		builder.append(operator);
		builder.append(" : ");
		builder.append(value);
		builder.append(" } ");
		builder.append(" } ");
		return builder.toString();
	}

}
