package edu.mum.credit_card;

import edu.mum.client.IClient;

public class SilverCreditCardAccount extends CreditCardAccount{
	private double x,y;
	public SilverCreditCardAccount(IClient client, String accountNo) {
		super(client, accountNo);
		x = 0.055;
		y = 0.11;
	}

	@Override
	double getNewMonthlyBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getMonthlyAmountDue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
