package edu.mum.bank;

import java.util.Date;

import edu.mum.client.IClient;
import edu.mum.entry.Entry;
import edu.mum.entry.IEntry;

public class SavingAccount extends BankAccount{
	static final double interestRate = 0.02;
	
	public SavingAccount(IClient client, String accountNo) {
		super(client, accountNo);

	}

	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public void addInterest() {
		double totalInterest;
		totalInterest = this.getBalance() * interestRate;
		IEntry entry = new Entry(new Date(), totalInterest);
		addEntry(entry);
		this.setBalance(this.getBalance() + totalInterest);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return AccountType.SAVING;
	}

}
