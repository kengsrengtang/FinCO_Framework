package edu.mum.creditcard;

import edu.mum.client.IClient;

public class BronzeCreditCardAccount extends CreditCardAccount{
	private double mi,mp;
	public BronzeCreditCardAccount(IClient client, String accountNo) {
		super(client, accountNo);
		this.mi = 0.10;
		this.mp = 0.14;
		// TODO Auto-generated constructor stub
	}

	@Override
	double getNewMonthlyBalance() {
		return this.getLastMonthBalance() - this.getTotalMonthlyCredit() + this.getTotalMonthlyCharges() + this.mi*(this.getLastMonthBalance() -this.getTotalMonthlyCredit());
	}

	@Override
	double getMonthlyAmountDue() {
		return this.mp * this.getNewMonthlyBalance();
	}

}
