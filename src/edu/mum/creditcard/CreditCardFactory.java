package edu.mum.creditcard;

import edu.mum.client.IClient;


public class CreditCardFactory {
	CreditCardAccount createCreditCard(IClient client, String accountNo, CreditCardType type){
		switch (type) {
		case Bronze:
			return new BronzeCreditCardAccount(client, accountNo);
		case Goal:
			return new GoalCreditCardAccount(client, accountNo);
		case Silver:
			return new SilverCreditCardAccount(client, accountNo);
		default:
			return null;
		}
	}
}
