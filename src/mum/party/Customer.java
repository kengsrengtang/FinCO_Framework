package mum.party;

public class Customer implements ICustomer{
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String email;

	public Customer(String name, String street, String city, String state, String zip, String email){
		this.city 	= city;
		this.name 	= name;
		this.state 	= state;
		this.street = street;
		this.zip 	= zip;
		this.email 	= email;
		
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
	public void addAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEmailToCustomer() {
		// TODO Auto-generated method stub
		
	}

}
