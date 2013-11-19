package edu.mum.bank.entry;

import edu.mum.bank.BankAccount;
import edu.mum.entry.IOperation;

public class AddInterestOperation implements IOperation{
	private BankAccount account;
	
	public AddInterestOperation(BankAccount account){
		this.account = account;
	}
	
	@Override
	public void execute() {
		account.addInterest();
	}

}
