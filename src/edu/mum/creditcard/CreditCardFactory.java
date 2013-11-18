package edu.mum.creditcard;

import edu.mum.client.IClient;


public interface CreditCardFactory {
	CreditCardAccount createCreditCard(IClient client, String accountNo);
}
