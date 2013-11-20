package edu.mum.creditcard;

import java.util.Date;

import edu.mum.account.AccountFactory;
import edu.mum.account.IAccount;
import main.FinCo;
public class CreditCardCo extends FinCo {

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		super.setup();
	}

	@Override
	public IAccount createAccountForPerson(String name, String street,
			String city, String state, String zip, String email,
			Date birthDate, String accountNo, AccountFactory factory) {
		// TODO Auto-generated method stub
		return super.createAccountForPerson(name, street, city, state, zip, email,
				birthDate, accountNo, factory);
	}
	
}
