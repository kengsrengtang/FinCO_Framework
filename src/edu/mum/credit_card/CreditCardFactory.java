package edu.mum.credit_card;

import edu.mum.client.IClient;


public interface CreditCardFactory {
	CreditCardAccount createCreditCard(IClient client, String accountNo);
}
