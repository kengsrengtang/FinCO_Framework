package main;

import java.util.Date;

import edu.mum.account.Account;
import edu.mum.account.IAccount;
import edu.mum.client.IClient;
import edu.mum.client.Person;
import edu.mum.entry.Deposit;
import edu.mum.entry.Entry;
import edu.mum.entry.IEntry;
import edu.mum.entry.IOperation;
import edu.mum.entry.OperationManager;

public class FinCo {
	public static void main(String[] args){
		IClient client = new Person("Foo", "4th", "Fairfield", "IA", "2222", "foo@gmail.com");
		IAccount account = new Account(client, "222 5555");
		System.out.print(account);
		
		// deposite
		IEntry entry = new Entry(new Date(), 200);
		IOperation depositOperation = new Deposit(account, entry);
		OperationManager manager = new OperationManager();

		
		
	}
}
