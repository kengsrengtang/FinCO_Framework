package edu.mum.creditcard;

import edu.mum.client.IClient;

public class GoalCreditCardFactory implements CreditCardFactory{

	@Override
	public CreditCardAccount createCreditCard(IClient client, String accountNo) {
		return new GoalCreditCard(client, accountNo);
	}

}
