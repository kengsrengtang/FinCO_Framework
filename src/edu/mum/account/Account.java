package edu.mum.account;

import java.util.ArrayList;
import java.util.List;

import edu.mum.entry.IEntry;

public class Account implements IAccount {
	protected List<IEntry> entries = new ArrayList<IEntry>();
	private String accountNo;
	private double balance;
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public double getBalance() {
		return balance;

	}
	
	@Override
	public void addEntry(IEntry entry) {
		entries.add(entry);
	}

	@Override
	public void notifyCustomer() {
		// TODO Auto-generated method stub
	}

}
