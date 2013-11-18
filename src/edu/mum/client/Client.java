package edu.mum.client;

import java.util.ArrayList;

import edu.mum.account.IAccount;


public abstract class Client implements IClient{
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String email;
	private ArrayList<IAccount> list;

	Client(String name, String street, String city, String state, String zip, String email){
		this.city 	= city;
		this.name 	= name;
		this.state 	= state;
		this.street = street;
		this.zip 	= zip;
		this.email 	= email;
		list = new ArrayList<>();
		
	}
	
	public String getName() {
		return name;
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

	public String getEmail() {
		return email;
	}

	@Override
	public void addAccount(IAccount account) {
		this.list.add(account);
		
	}

	@Override
	public void removeAccount(IAccount account) {
		this.list.remove(account);
	}

	@Override
	public void sendEmailToCustomer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", email=" + email + "]";
	}

}
