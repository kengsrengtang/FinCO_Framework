package edu.mum.bank;

import edu.mum.client.IClient;

public class BankAccountFactory {
	public static BankAccount createBankAccount(IClient client, String accountNo,AccountType type){
		if(type == AccountType.Checking)
			return new CheckingAccount(client, accountNo);
		else if(type == AccountType.Saving)
			return new SavingAccount(client, accountNo);
		else
			return null;
	}
}
