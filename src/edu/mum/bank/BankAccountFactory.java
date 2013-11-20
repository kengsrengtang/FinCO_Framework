package edu.mum.bank;

import edu.mum.account.AccountFactory;
import edu.mum.client.IClient;

public abstract class BankAccountFactory extends AccountFactory{
	public abstract BankAccount createAccount(IClient client,String accountNo);
}
