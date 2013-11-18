package edu.mum.creditcard;

import edu.mum.client.IClient;

public class BronzeCreditCardAccount extends CreditCardAccount{
	private double x,y;
	public BronzeCreditCardAccount(IClient client, String accountNo) {
		super(client, accountNo);
		this.x = 0.06;
		this.y = 0.12;
		// TODO Auto-generated constructor stub
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
