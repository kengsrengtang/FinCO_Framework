package edu.mum.entry;

import edu.mum.account.IAccount;

public class DepositOperation implements IOperation{

	private IAccount account;
	private IEntry entry;
	public DepositOperation(IAccount account, IEntry entry) {
		this.account = account;
		this.entry = entry;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		account.deposit(entry);
	}

}
