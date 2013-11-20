package edu.mum.client;

import java.util.List;
import java.util.Observer;

import edu.mum.account.IAccount;


public interface IClient extends Observer{
	void addAccount(IAccount account);
	void addAccount(String accountNo);
	void removeAccount(IAccount account);
	void sendEmailToCustomer();
	Address getAddress();
	String getName();
	String getEmail();
	String getType();
	List<IAccount> getAccounts();
}
