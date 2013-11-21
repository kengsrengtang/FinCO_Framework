package edu.mum.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import edu.mum.bank.AccountType;
import edu.mum.client.IClient;
import edu.mum.entry.IEntry;

public class Account extends Observable implements IAccount {
	protected List<IEntry> deposits = new ArrayList<IEntry>();
	protected List<IEntry> withdrawals = new ArrayList<IEntry>();
	private String accountNo;
	private double balance;
	private IClient client;
	
	public Account(IClient client,String accountNo) {
		this.client = client;
		this.accountNo = accountNo;
//		this.client.addAccount(this);
	}

	public String getAccountNo() {
		return accountNo;
	}
	
	public IClient getClient() {
		return client;
	}

	public void setBalance(double amount) {
		this.balance = amount;
		this.setChanged();
		notifyObservers();
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void deposit(IEntry entry) {
		deposits.add(entry);
		this.setBalance(this.getBalance() + entry.getAmount());
		
	}

	@Override
	public boolean withdraw(IEntry entry) {
		if(entry.getAmount()>balance) {
			return false;
		}
		this.setBalance(this.getBalance() - entry.getAmount());
		withdrawals.add(entry);
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", balance=" + balance
				+ ", client=" + client + "]";
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAObserver(Observer observer) {
		// TODO Auto-generated method stub
		addObserver(observer);
	}
	
	public void addEntry(IEntry entry) {
		deposits.add(entry);
	}
}
