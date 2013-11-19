package edu.mum.creditcard;

import edu.mum.client.IClient;

public class GoalCreditCardAccount extends CreditCardAccount{
	private double mi,mp;
	public GoalCreditCardAccount(IClient client, String accountNo) {
		super(client, accountNo);
		this.mi = 0.06;
		this.mp = 0.1;
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
