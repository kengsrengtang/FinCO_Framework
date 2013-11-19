package edu.mum.bank;

import edu.mum.client.IClient;

public class CheckingAccount extends BankAccount{
	private double interestRate;
	public CheckingAccount(IClient client, String accountNo) {
		super(client, accountNo);
		this.interestRate = 0.01;
	}

	@Override
	void addInterest() {
		double totalInterest;
		totalInterest = this.getBalance() * interestRate;
		this.setBalance(this.getBalance() + totalInterest);
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
