package edu.mum.creditcard;

import edu.mum.client.IClient;

public class GoldCreditCardAccount extends CreditCardAccount{
	private double mi,mp;
	public GoldCreditCardAccount(IClient client, String accountNo) {
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
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return CreditCardType.GOLD;
	}
}