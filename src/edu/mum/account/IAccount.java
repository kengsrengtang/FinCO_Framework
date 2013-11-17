package edu.mum.account;

import edu.mum.entry.IEntry;

public interface IAccount {
	double getBalance();
	void addEntry(IEntry entry);
	void notifyCustomer();
}
