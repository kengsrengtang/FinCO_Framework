package edu.mum.bank;

import edu.mum.client.IClient;

public class CheckingAccount extends BankAccount{
	static final double interestRate = 0.01;
	public CheckingAccount(IClient client, String accountNo) {
		super(client, accountNo);
	}

	@Override
	public void addInterest() {
		double totalInterest;
		totalInterest = this.getBalance() * interestRate;
		this.setBalance(this.getBalance() + totalInterest);
	}

	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return AccountType.CHECKING;
	}
}
