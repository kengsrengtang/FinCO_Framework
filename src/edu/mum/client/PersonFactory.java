package edu.mum.client;

public class PersonFactory implements ClientFactory {

	@Override
	public IClient createClient(String name, String street, String city,
			String state, String zip, String email) {
		return new Person(name, street, city, state, zip, email);
	}



}
