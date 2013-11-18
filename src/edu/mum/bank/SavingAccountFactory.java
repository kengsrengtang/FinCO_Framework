package edu.mum.bank;

import edu.mum.client.IClient;

public class SavingAccountFactory implements BankAccountFactory{

	@Override
	public BankAccount createAccount(IClient client, String accountNo) {
		return new SavingAccount(client, accountNo);
	}

}
