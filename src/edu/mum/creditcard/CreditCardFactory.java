package edu.mum.creditcard;

import edu.mum.account.AccountFactory;
import edu.mum.client.IClient;


public abstract class CreditCardFactory extends AccountFactory{
	@Override
	public abstract CreditCardAccount createAccount(IClient client, String accountNo);
}
