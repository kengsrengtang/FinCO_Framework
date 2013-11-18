package edu.mum.client;

public class OrganizationFactory implements ClientFactory {

	@Override
	public IClient createClient(String name, String street, String city,
			String state, String zip, String email) {
		return new Organization(name, street, city, state, zip, email);
	}



}
