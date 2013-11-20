package edu.mum.account;

import java.util.Observer;

import edu.mum.bank.AccountType;
import edu.mum.client.IClient;
import edu.mum.entry.IEntry;

public interface IAccount {
	IClient getClient();
	double getBalance();
	String getAccountNo();
	void notifyClient(double amount);
	void deposit(IEntry entry);
	boolean withdraw(IEntry entry);
	AccountType getType();
	void addAObserver(Observer observer);
}
