package edu.mum.entry;

import edu.mum.account.IAccount;

public class Withdraw implements IOperation{

	IAccount account;
	IEntry entry;
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		account.withdraw(entry);
	}

}
