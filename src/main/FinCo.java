package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.UIManager;

import edu.mum.account.Account;
import edu.mum.account.IAccount;
import edu.mum.client.ClientFactory;
import edu.mum.client.ClientType;
import edu.mum.client.IClient;
import edu.mum.entry.DepositOperation;
import edu.mum.entry.Entry;
import edu.mum.entry.IEntry;
import edu.mum.entry.IOperation;
import edu.mum.entry.OperationManager;
import edu.mum.entry.WithdrawOperation;
import edu.mum.gui.Gui;

public class FinCo {
	Map<String, IAccount> accounts = new HashMap<>();
	List<IClient> clients = new ArrayList<>();

	public static void main(String[] args) {
		FinCo finCo = new FinCo();
		IClient client = ClientFactory.createPerson("Foo", "4th", "Fairfield",
				"IA", "2222", "foo@gmail.com", new Date());
		IAccount account = new Account(client, "222 5555");
		finCo.addAccount(account);
		System.out.print(account);

		// deposit
		IEntry entry = new Entry(new Date(), 200);
		IOperation depositOperation = new DepositOperation(account, entry);
		OperationManager manager = new OperationManager();
		IOperation withDrawOperation = new WithdrawOperation(account, entry);
		finCo.setup();
		finCo.printAccounts();
		
		
		//ui
		
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
		    
			//Create a new instance of our application's frame, and make it visible.
			(new Gui(finCo)).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	public void addAccount(IAccount account) {
		accounts.put(account.getAccountNo(), account);
	}

	public void addClient(IClient client) {
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
			this.addClient(c);
			IAccount acc = new Account(c,prefix.append(i++).toString());
			c.addAccount(acc);
			this.addAccount(acc);
			prefix.deleteCharAt(prefix.length()-1);
		}
	}
	
	//Create personal account
	public boolean createAccountForPerson(String name,String street,String city, String state, String zip,
				String email, Date birthDate,String accountNo) {
		IClient client = ClientFactory.createPerson(name, street, city, state, zip, email, birthDate);
		if(client != null) {
			client.addAccount(accountNo);
			return true;
		}
		return false;
	}
	
	//Create organizational account
	public boolean createAccountForOrganization(String name,String street,String city, String state, String zip,
			String email, int noOfEmployees,String accountNo) {
			IClient client = ClientFactory.createOrganization(name, street, city, state, zip, email, noOfEmployees);
			if(client != null) {
				client.addAccount(accountNo);
				return true;
			}
			return false;
	}
	
	public void printAccounts() {
		Set<String> accNos = accounts.keySet();
		for(String no:accNos) {
			IAccount acc = accounts.get(no);
			System.out.println(acc);
		}
	}

	public Map<String, IAccount> getAccounts() {
		return accounts;
	}

	public List<IClient> getClients() {
		return clients;
	}
	
	
}
