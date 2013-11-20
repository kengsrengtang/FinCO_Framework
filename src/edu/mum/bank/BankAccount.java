package edu.mum.bank;

import edu.mum.account.Account;
import edu.mum.client.IClient;

public abstract class BankAccount extends Account {

	public BankAccount(IClient client, String accountNo) {
		super(client, accountNo);
	}
	public abstract void addInterest();
	
	
	abstract public String getType();
}
