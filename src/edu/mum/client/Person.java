package edu.mum.client;

import java.util.Date;
import java.util.Observable;

public class Person extends Client implements IPerson {
	private Date birthDate;
	public Person(String name, String street, String city, String state,
			String zip, String email, Date birthDate) {
		super(name, street, city, state, zip, email);
		this.birthDate = birthDate;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.sendEmailToCustomer();
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}	
}
