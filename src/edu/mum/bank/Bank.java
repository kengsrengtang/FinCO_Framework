package edu.mum.bank;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.swing.UIManager;

import main.FinCo;
import edu.mum.account.IAccount;
import edu.mum.bank.entry.AddInterestOperation;
import edu.mum.bank.gui.BankGui;
import edu.mum.client.ClientFactory;
import edu.mum.client.IClient;
import edu.mum.entry.IOperation;

public class Bank extends FinCo {
	public Bank(){
		setup();
	}
	
	public static void main(String[] args) {
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it
			// visible.
			(new BankGui(new Bank())).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}


	public void setup(){
		//Creating clients and accounts
		IClient[] clients = new IClient[5];
		clients[0] = ClientFactory.createPerson("Keng","4th", "Fairfield", "Iowa", "34242", 
				"keng@sreng.tang", new Date());
		clients[1] = ClientFactory.createPerson("John","4th street", "Des Moines", "Iowa", "34242", 
				"john@mail.gm", new Date());
		clients[2] = ClientFactory.createPerson("Jimmy Kon","Nevile 3rd", "Chicago", "Illinois", "367676", 
				"kjimmy@yahoo.com", new Date());
		clients[3] = ClientFactory.createOrganization("Finco Ltd","1000N 4th", "Fairfield", "Iowa", "34242", 
				"manager@finco.com", 12);
		clients[4] = ClientFactory.createOrganization("Getnet Info","Burlington", "Washington DC", "Washington", "89876", 
				"admin@getnet.info", 5);
		int i=1;
		int index=0;
		StringBuilder prefix = new StringBuilder("2224");
		for(IClient c:clients){
			this.addClient(c);
			IAccount acc;
			if(index++%2==0){
				acc = new CheckingAccount(c,prefix.append(i++).toString());
			}
			else{
				acc = new SavingAccount(c,prefix.append(i++).toString());
			}
			c.addAccount(acc);
			this.addAccount(acc);
			prefix.deleteCharAt(prefix.length()-1);
		}
	}

	// adding interest to all account
	public void addInterestToAllAccount() {
		Iterator<Map.Entry<String, IAccount>> it = accounts.entrySet()
				.iterator();
		while (it.hasNext()) {
			Map.Entry<String, IAccount> entry = it.next();
			BankAccount account = (BankAccount) entry.getValue();
			IOperation addInterestOperation = new AddInterestOperation(account);
			this.opManager.submit(addInterestOperation);
		}
	}
}
