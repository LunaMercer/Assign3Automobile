package model;

import java.io.Serializable;

public class Option implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private float price;

	/* Default constructor */
	public Option() {
		name = "NULL";
		price = 0;
	}
	
	/* Default constructor */
	public Option(String name, float price) {
		this.name = name;
		this.price = price;
	}

	/* Retrives current option name */
	public String getName() {
		return name;
	}

	/* Sets current option name */
	public void setName(String name) {
		this.name = name;
	}

	/* Gets current option price */
	public float getPrice() {
		return price;
	}

	/* Sets current option price */
	public void setPrice(float price) {
		this.price = price;
	}

	// toString() converts buffered string to a string
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Option Name: ").append(name).append(", Price $").append(price);
		String str = stringBuffer.toString();
		return str;
	}

	// print() prints Option object's attributes
	protected void print() {
		System.out.println(toString());
	}
}
