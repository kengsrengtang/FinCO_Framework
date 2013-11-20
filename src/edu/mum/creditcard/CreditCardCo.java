package edu.mum.creditcard;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.swing.UIManager;

import main.FinCo;
import edu.mum.account.AccountFactory;
import edu.mum.account.IAccount;
import edu.mum.client.ClientFactory;
import edu.mum.client.IClient;
import edu.mum.creditcard.gui.CreditCardGui;
public class CreditCardCo extends FinCo {

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
			(new CreditCardGui(new CreditCardCo())).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}
	
	@Override
	public IAccount createAccountForPerson(String name, String street,
			String city, String state, String zip, String email,
			Date birthDate, String accountNo, AccountFactory factory) {
		// TODO Auto-generated method stub
		return super.createAccountForPerson(name, street, city, state, zip, email,
				birthDate, accountNo, factory);
	}

	public String generateMonthlyBill() {
		// TODO Auto-generated method stub
		Iterator<Map.Entry<String, IAccount>> it = accounts.entrySet()
				.iterator();
		StringBuilder report = new StringBuilder();
		while (it.hasNext()) {
			Map.Entry<String, IAccount> entry = it.next();
			CreditCardAccount account = (CreditCardAccount) entry.getValue();
			report.append("\n\n"+account.getMonthlyBill());
		}
		return report.toString();
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
			this.addClientToList(c);
			IAccount acc;
			if(index++%2==0){
				acc = new BronzeCreditCardAccount(c,prefix.append(i++).toString());
			}
			else{
				acc = new GoldCreditCardAccount(c,prefix.append(i++).toString());
			}
			c.addAccount(acc);
			this.addAccountToList(acc);
			prefix.deleteCharAt(prefix.length()-1);
		}
	}
}
