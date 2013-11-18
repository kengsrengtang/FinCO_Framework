package edu.mum.creditcard;

import edu.mum.client.IClient;

public class SilverCreditCardFactory implements CreditCardFactory{

	@Override
	public CreditCardAccount createCreditCard(IClient client, String accountNo) {
		return new SilverCreditCardAccount(client, accountNo);
	}

}
