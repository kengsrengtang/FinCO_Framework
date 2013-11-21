package edu.mum.account;

import java.util.Observer;

import edu.mum.bank.AccountType;
import edu.mum.client.IClient;
import edu.mum.entry.IEntry;

public interface IAccount {
	IClient getClient();
	double getBalance();
	String getAccountNo();
	void deposit(IEntry entry);
	boolean withdraw(IEntry entry);
	String getType();
	void addAObserver(Observer observer);
	void addEntry(IEntry entry);
}
