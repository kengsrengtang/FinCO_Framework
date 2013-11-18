package main;

import java.util.Date;

import edu.mum.account.Account;
import edu.mum.account.IAccount;
import edu.mum.client.ClientFactory;
import edu.mum.client.IClient;
import edu.mum.client.Person;
import edu.mum.client.PersonFactory;
import edu.mum.entry.DepositOperation;
import edu.mum.entry.Entry;
import edu.mum.entry.IEntry;
import edu.mum.entry.IOperation;
import edu.mum.entry.OperationManager;
import edu.mum.entry.WithdrawOperation;

public class FinCo {
	public static void main(String[] args){
		ClientFactory factory = new PersonFactory();
		IClient client = factory.createClient("Foo", "4th", "Fairfield", "IA", "2222", "foo@gmail.com");
		IAccount account = new Account(client, "222 5555");
		System.out.print(account);
		
		// deposite
		IEntry entry = new Entry(new Date(), 200);
		IOperation depositOperation = new DepositOperation(account, entry);
		OperationManager manager = new OperationManager();
		IOperation withDrawOperation = new WithdrawOperation(account, entry);
		
		manager.submit(depositOperation);
		manager.submit(withDrawOperation);
	}
}
