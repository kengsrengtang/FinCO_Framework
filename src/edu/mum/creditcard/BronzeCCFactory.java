package edu.mum.creditcard;

import edu.mum.client.IClient;

public class BronzeCCFactory extends CreditCardFactory {

	@Override
	public CreditCardAccount createAccount(IClient client, String accountNo) {
		return new BronzeCreditCardAccount(client, accountNo);
	}

}
