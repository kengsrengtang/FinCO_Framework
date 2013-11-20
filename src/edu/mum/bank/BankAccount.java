package edu.mum.bank;

import edu.mum.account.Account;
import edu.mum.client.ClientType;
import edu.mum.client.IClient;

public abstract class BankAccount extends Account {

	public BankAccount(IClient client, String accountNo) {
		super(client, accountNo);
	}
	public abstract void addInterest();
	
	public void notifyClient(double amount) {
		if(this.getClient().getType() == ClientType.ORGANIZATIONAL)
			super.notifyClient(amount);
		if(this.getClient().getType() == ClientType.PERSONAL && amount > 500)
			super.notifyClient(amount);
	}
	abstract public AccountType getType();
}
