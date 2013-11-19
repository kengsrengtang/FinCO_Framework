package edu.mum.bank;

import edu.mum.client.IClient;

public class SavingAccount extends BankAccount{
	private double interestRate;
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public SavingAccount(IClient client, String accountNo) {
		super(client, accountNo);
		this.interestRate = 0.02;
	}

	@Override
	void addInterest(double amount) {
		double totalInterest;
		totalInterest = this.getBalance() * interestRate;
		this.setBalance(this.getBalance() + totalInterest);
	}

}
