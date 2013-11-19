package edu.mum.creditcard;

import edu.mum.client.IClient;

public class SilverCreditCardAccount extends CreditCardAccount{
	private double mi,mp;
	public SilverCreditCardAccount(IClient client, String accountNo) {
		super(client, accountNo);
		this.mi = 0.08;
		this.mp = 0.12;
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
