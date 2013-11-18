package edu.mum.bank;

import edu.mum.client.IClient;

public interface BankAccountFactory {
	BankAccount createAccount(IClient client, String accountNo);
}
