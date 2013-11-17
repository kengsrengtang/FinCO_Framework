package edu.mum.account;

import edu.mum.client.IClient;
import edu.mum.entry.IEntry;

public interface IAccount {
	IClient getClient();
	double getBalance();
	void addEntry(IEntry entry);
	void notifyClient();
}
