package edu.mum.account;

import edu.mum.entry.Transaction;

public interface IAccount {
	void getBalance();
	void addEntry(Transaction entry);
	void notifyCustomer();
}
