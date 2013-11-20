package edu.mum.bank;

import edu.mum.client.IClient;

public class SavingAccount extends BankAccount{
	static final double interestRate = 0.02;
	
	public SavingAccount(IClient client, String accountNo) {
		super(client, accountNo);

	}

	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public void addInterest() {
		double totalInterest;
		totalInterest = this.getBalance() * interestRate;
		this.setBalance(this.getBalance() + totalInterest);
	}

	@Override
	public AccountType getType() {
		// TODO Auto-generated method stub
		return AccountType.Saving;
	}

}
