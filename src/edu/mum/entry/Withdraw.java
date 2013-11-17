package edu.mum.entry;

import edu.mum.account.IAccount;

public class Withdraw implements IOperation{

	private IAccount account;
	private IEntry entry;
	
	public Withdraw(IAccount account, IEntry entry) {
		super();
		this.account = account;
		this.entry = entry;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		account.withdraw(entry);
	}

}
