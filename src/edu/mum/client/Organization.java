package edu.mum.client;

import java.util.Observable;

public class Organization extends Client implements IOrganization {
	private int noOfEmployees;
	public Organization(String name, String street, String city, String state,
			String zip, String email,int noOfEmployees) {
		super(name, street, city, state, zip, email);
		this.noOfEmployees = noOfEmployees;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.sendEmailToCustomer();
	}

	@Override
	public int getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	@Override
	public ClientType getType() {
		return ClientType.ORGANIZATIONAL;
	}
	
}
