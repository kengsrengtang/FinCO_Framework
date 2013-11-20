package edu.mum.bank;

import java.util.Iterator;
import java.util.Map;

import javax.swing.UIManager;

import main.FinCo;
import edu.mum.account.IAccount;
import edu.mum.bank.entry.AddInterestOperation;
import edu.mum.bank.gui.BankGui;
import edu.mum.entry.IOperation;

public class Bank extends FinCo {
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
