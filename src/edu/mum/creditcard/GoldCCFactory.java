package edu.mum.creditcard;

import edu.mum.client.IClient;

public class GoldCCFactory extends CreditCardFactory {

	@Override
	public CreditCardAccount createAccount(IClient client, String accountNo) {
		return new GoldCreditCardAccount(client, accountNo);
	}

}
