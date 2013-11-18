package edu.mum.client;

import edu.mum.account.IAccount;


public interface IClient {
	void addAccount(IAccount account);
	void removeAccount(IAccount account);
	void sendEmailToCustomer();
}
