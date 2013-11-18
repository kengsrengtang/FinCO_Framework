package edu.mum.bank;

import edu.mum.client.IClient;

public class SavingAccount extends BankAccount{

	public SavingAccount(IClient client, String accountNo) {
		super(client, accountNo);
		// TODO Auto-generated constructor stub
	}

	@Override
	void addInterest(double amount) {
		this.setBalance(amount);
	}

}
