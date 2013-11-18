package edu.mum.client;

import java.util.Observable;

public class Person extends Client implements IPerson {

	public Person(String name, String street, String city, String state,
			String zip, String email) {
		super(name, street, city, state, zip, email);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable o, Object arg) {
		this.sendEmailToCustomer();
	}

}
