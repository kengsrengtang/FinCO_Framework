package edu.mum.credit_card;

import edu.mum.client.IClient;

public class GoalCreditCard extends CreditCardAccount{
	private double x,y;
	public GoalCreditCard(IClient client, String accountNo) {
		super(client, accountNo);
		x = 0.05;
		y = 0.1;
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
