package edu.mum.client;

import java.util.ArrayList;
import java.util.List;

import edu.mum.account.Account;
import edu.mum.account.IAccount;


public abstract class Client implements IClient{
	private String name;
	private String email;
	private ArrayList<IAccount> accountList;
	private Address address;

	Client(String name, String street, String city, String state, String zip, String email){
//		this.city 	= city;
		this.name 	= name;
//		this.state 	= state;
//		this.street = street;
//		this.zip 	= zip;
		this.email 	= email;
		this.address = new Address(street, city, state, zip);
		this.accountList = new ArrayList<>();	
	}
	
	public String getName() {
		return name;
	}

	
	public String getEmail() {
		return email;
	}
	
	@Override
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void addAccount(IAccount account) {
		this.accountList.add(account);
		
	}
	@Override
	public void addAccount(String accountNo) {
		this.accountList.add(new Account(this, accountNo));
	}
	
	@Override
	public void removeAccount(IAccount account) {
		this.accountList.remove(account);
	}

	@Override
	public void sendEmailToCustomer() {
		System.out.println("send email to Mr/Ms" + this.name );
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", email=" + email + "]";
	}
	
	@Override
	public List<IAccount> getAccounts() {
		return accountList;
	}
}
