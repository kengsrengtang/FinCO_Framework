package edu.mum.credit_card;

import edu.mum.client.IClient;

public class BronzeCreditCardFactory implements CreditCardFactory{

	@Override
	public CreditCardAccount createCreditCard(IClient client, String accountNo) {
		return new BronzeCreditCardAccount(client, accountNo);
	}

}
