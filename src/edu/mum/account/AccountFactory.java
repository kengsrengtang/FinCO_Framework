package edu.mum.account;

import edu.mum.client.IClient;

public class AccountFactory {
	public IAccount createAccount(IClient client,String accountNo) {
		return new Account(client,accountNo);
	}
}
