package edu.mum.creditcard;

import edu.mum.client.IClient;

public class SilverCCFactory extends CreditCardFactory {

	@Override
	public CreditCardAccount createAccount(IClient client, String accountNo) {
		// TODO Auto-generated method stub
		return new SilverCreditCardAccount(client, accountNo);
	}

}
