package edu.mum.creditcard;

import java.util.Date;

import edu.mum.account.Account;
import edu.mum.client.IClient;

public abstract class CreditCardAccount extends Account{
	private double lastMonthBalance;
	private Date expDate;
	
	public CreditCardAccount(IClient client, String accountNo) {
		super(client, accountNo);
	}
	
	public double getTotalMonthlyCredit(){
		return 0;
	}
	
	public double getTotalMonthlyCharges(){
		return 0;
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
