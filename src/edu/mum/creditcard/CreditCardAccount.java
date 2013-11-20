package edu.mum.creditcard;

import java.util.Date;
import java.util.Iterator;

import edu.mum.account.Account;
import edu.mum.client.IClient;
import edu.mum.entry.IEntry;

public abstract class CreditCardAccount extends Account{
	private double lastMonthBalance;
	private Date expDate;
	
	public CreditCardAccount(IClient client, String accountNo) {
		super(client, accountNo);
	}
	
	public double getTotalMonthlyCredit(){
		Iterator<IEntry> it = deposits.iterator();
		Predicate<Date> condition = new CheckDate();
		TotalMonthlyCharge functor = new TotalMonthlyCharge();
		
		while(it.hasNext()){
			IEntry entry = it.next();
			if(condition.check(entry.getDate()))
				functor.compu(entry.getAmount());
		}
		return functor.getResult();
	}
	
	public double getTotalMonthlyCharges(){
		Iterator<IEntry> it = withdrawals.iterator();
		Predicate<Date> condition = new CheckDate();
		TotalMonthlyCharge functor = new TotalMonthlyCharge();
		
		while(it.hasNext()){
			IEntry entry = it.next();
			if(condition.check(entry.getDate()))
				functor.compu(entry.getAmount());
		}
		return functor.getResult();
	}
	
	public double getLastMonthBalance() {
		return lastMonthBalance;
	}
	public void setLastMonthBalance(double lastMonthBalance) {
		this.lastMonthBalance = lastMonthBalance;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	
	abstract double getNewMonthlyBalance();
	abstract double getMonthlyAmountDue();
}
