package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.UIManager;

import edu.mum.account.Account;
import edu.mum.account.AccountFactory;
import edu.mum.account.IAccount;
import edu.mum.client.ClientFactory;
import edu.mum.client.IClient;
import edu.mum.entry.DepositOperation;
import edu.mum.entry.Entry;
import edu.mum.entry.OperationManager;
import edu.mum.entry.WithdrawOperation;
import edu.mum.gui.Gui;

public class FinCo {
	protected Map<String, IAccount> accounts = new HashMap<>();
	protected List<IClient> clients = new ArrayList<>();
	protected OperationManager opManager = new OperationManager();
	public FinCo(){
		setup();
//		printAccounts();
	}
	
	public static void main(String[] args) {
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
		    
			//Create a new instance of our application's frame, and make it visible.
			(new Gui(new FinCo())).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	public void addAccountToList(IAccount account) {
		accounts.put(account.getAccountNo(), account);
	}

	public void addClientToList(IClient client) {
		clients.add(client);
	}

	public void setup(){
		//Creating clients and accounts
		IClient[] client = new IClient[5];
		client[0] = ClientFactory.createPerson("Keng","4th", "Fairfield", "Iowa", "34242", 
				"keng@sreng.tang", new Date());
		client[1] = ClientFactory.createPerson("John","4th street", "Des Moines", "Iowa", "34242", 
				"john@mail.gm", new Date());
		client[2] = ClientFactory.createPerson("Jimmy Kon","Nevile 3rd", "Chicago", "Illinois", "367676", 
				"kjimmy@yahoo.com", new Date());
		client[3] = ClientFactory.createOrganization("Finco Ltd","1000N 4th", "Fairfield", "Iowa", "34242", 
				"manager@finco.com", 12);
		client[4] = ClientFactory.createOrganization("Getnet Info","Burlington", "Washington DC", "Washington", "89876", 
				"admin@getnet.info", 5);
		int i=1;
		StringBuilder prefix = new StringBuilder("2224");
		for(IClient c:client){
			this.addClientToList(c);
			IAccount acc = new Account(c,prefix.append(i++).toString());
			c.addAccount(acc);
			this.addAccountToList(acc);
			prefix.deleteCharAt(prefix.length()-1);
		}
	}
	
	//Create personal account
	public IAccount createAccountForPerson(String name,String street,String city, String state, String zip,
				String email, Date birthDate,String accountNo, AccountFactory factory) {
		IClient client = ClientFactory.createPerson(name, street, city, state, zip, email, birthDate);
		if(client != null) {
			addClientToList(client);
			IAccount acc = factory.createAccount(client, accountNo);
			client.addAccount(acc);
			return acc;
		}
		return null;
	}
	
	//Create organizational account
	public IAccount createAccountForOrganization(String name,String street,String city, String state, String zip,
			String email, int noOfEmployees,String accountNo,AccountFactory factory) {
			IClient client = ClientFactory.createOrganization(name, street, city, state, zip, email, noOfEmployees);
			if(client != null) {
				addClientToList(client);
				IAccount acc = factory.createAccount(client, accountNo);
				client.addAccount(acc);
				return acc;
			}
			return null;
	}
	
	public void printAccounts() {
		Set<String> accNos = accounts.keySet();
		for(String no:accNos) {
			IAccount acc = accounts.get(no);
			System.out.println(acc);
		}
	}
	
	//Depositing
	public double depositing(String accountNo,double amount) {
		//Get account
		IAccount account = accounts.get(accountNo);
		//Create deposit operation and submit it.
		opManager.submit(new DepositOperation(account,new Entry(new Date(),amount)));
		return account.getBalance();
	}
	
	//Withdrawing
	public double withdrawing(String accountNo,double amount) {
		IAccount account = accounts.get(accountNo);
		opManager.submit(new WithdrawOperation(account,new Entry(new Date(),amount)));
		return account.getBalance();
	}
	//Getters
	public Map<String, IAccount> getAccounts() {
		return accounts;
	}

	public List<IClient> getClients() {
		return clients;
	}
}
