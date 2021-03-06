package edu.mum.bank;

import edu.mum.client.IClient;

public class CheckingAccountFactory extends BankAccountFactory {

	@Override
	public BankAccount createAccount(IClient client, String accountNo) {
		return new CheckingAccount(client, accountNo);
	}
	
}
