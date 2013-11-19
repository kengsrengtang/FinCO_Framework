package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

public class FinCo {
	Map<String, IAccount> accounts = new HashMap<>();
	List<IClient> clients = new ArrayList<>();

	public static void main(String[] args) {
		FinCo finCo = new FinCo();
		IClient client = ClientFactory.createClient("Foo", "4th", "Fairfield",
				"IA", "2222", "foo@gmail.com", new Date(), ClientType.PERSONAL);
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
		client[0] = ClientFactory.createClient("Keng","4th", "Fairfield", "Iowa", "34242", 
				"keng@sreng.tang", new Date(), ClientType.PERSONAL);
		client[1] = ClientFactory.createClient("John","4th street", "Des Moines", "Iowa", "34242", 
				"john@mail.gm", new Date(), ClientType.PERSONAL);
		client[2] = ClientFactory.createClient("Jimmy Kon","Nevile 3rd", "Chicago", "Illinois", "367676", 
				"kjimmy@yahoo.com", new Date(), ClientType.PERSONAL);
		client[3] = ClientFactory.createClient("Finco Ltd","1000N 4th", "Fairfield", "Iowa", "34242", 
				"manager@finco.com", null, ClientType.ORGANIZATIONAL);
		client[4] = ClientFactory.createClient("Getnet Info","Burlington", "Washington DC", "Washington", "89876", 
				"admin@getnet.info", null, ClientType.ORGANIZATIONAL);
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
	
	public boolean createAccountForClient(String name,String street,String city, String state, String zip,
				String email, Date birthDate,ClientType type,String accountNo) {
		IClient client = ClientFactory.createClient(name, street, city, state, zip, email, birthDate, type);
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
}
