package edu.mum.account;

import edu.mum.entry.Entry;

public interface IAccount {
	void getBalance();
	void addEntry(Entry entry);
	void notifyCustomer();
}
