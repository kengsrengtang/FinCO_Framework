package edu.mum.account;

import edu.mum.client.IClient;
import edu.mum.entry.IEntry;

public interface IAccount {
	IClient getClient();
	double getBalance();
	String getAccountNo();
	void notifyClient(double amount);
	void deposit(IEntry entry);
	boolean withdraw(IEntry entry);
}
