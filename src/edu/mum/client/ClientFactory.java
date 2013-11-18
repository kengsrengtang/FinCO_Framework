package edu.mum.client;

public interface ClientFactory {
	IClient createClient(String name, String street, String city, String state, String zip, String email);
}
