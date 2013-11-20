package edu.mum.bank;

import edu.mum.account.AccountFactory;
import edu.mum.account.IAccount;
import edu.mum.client.IClient;

public class CheckingAccountFactory extends AccountFactory {

	@Override
	public IAccount createAccount(IClient client, String accountNo) {
		return new CheckingAccount(client, accountNo);
	}
	
}
