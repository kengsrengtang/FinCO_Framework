package edu.mum.client;

import java.util.Observer;

import edu.mum.account.IAccount;


public interface IClient extends Observer{
	void addAccount(IAccount account);
	void addAccount(String accountNo);
	void removeAccount(IAccount account);
	void sendEmailToCustomer();
}
