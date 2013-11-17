package edu.mum.account;

import java.util.ArrayList;
import java.util.List;

import edu.mum.client.IClient;
import edu.mum.entry.IEntry;

public class Account implements IAccount {
	protected List<IEntry> deposits = new ArrayList<IEntry>();
	protected List<IEntry> withdrawals = new ArrayList<IEntry>();
	private String accountNo;
	private double balance;
	private IClient client;
	
	public Account(IClient client,String accountNo) {
		this.client = client;
		this.accountNo = accountNo;
	}

	public String getAccountNo() {
		return accountNo;
	}
	
	public IClient getClient() {
		return client;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public double getBalance() {
		return balance;

	}

	@Override
	public void notifyClient() {
		// TODO Auto-generated method stub
	}

	@Override
	public void deposit(IEntry entry) {
		deposits.add(entry);
		this.balance += entry.getAmount();
		notifyClient();
	}

	@Override
	public boolean withdraw(IEntry entry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", balance=" + balance
				+ ", client=" + client + "]";
	}
}
