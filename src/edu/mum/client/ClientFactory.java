package edu.mum.client;

import java.util.Date;

public class ClientFactory {
//	public static IClient createClient(String name, 
//							String street, 
//							String city, 
//							String state, 
//							String zip, 
//							String email,
//							Date birthDate,
//							ClientType type){
//		if(type == ClientType.ORGANIZATIONAL) {
//			return new Organization(name, street, city, state, zip, email);
//		}
//		return new Person(name,street,city,state,zip,email,birthDate);
//	}
	public static IPerson createPerson(String name, 
			String street, 
			String city, 
			String state, 
			String zip, 
			String email,
			Date birthDate) {
		return new Person(name,street,city,state,zip,email,birthDate);
	}
	
	public static IOrganization createOrganization(String name, 
			String street, 
			String city, 
			String state, 
			String zip, 
			String email,
			int noOfEmployees) {
		return new Organization(name,street,city,state,zip,email,noOfEmployees);
	}
}
