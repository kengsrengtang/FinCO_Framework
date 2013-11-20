package edu.mum.client;

import java.text.Format;

public class Address {
	private String street;
	private String city;
	private String state;
	private String zip;
	
	
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}
	@Override
	public String toString(){
		return String.format("%s, %s, %s, %s",street, city, state, zip);
	}
}
