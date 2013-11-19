package edu.mum.bank;

import java.util.Date;

import javax.swing.UIManager;

import main.FinCo;

import edu.mum.bank.gui.BankGui;
import edu.mum.client.ClientFactory;
import edu.mum.client.IClient;
import edu.mum.gui.Gui;

public class BankCo extends FinCo{
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
			(new BankGui(new BankCo())).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}
	
	public boolean createSavingsAccountForPerson(String name,String street,String city, String state, String zip,
				String email, Date birthDate,String accountNo, AccountType type) {
		IClient client = ClientFactory.createPerson(name, street, city, state, zip, email, birthDate);
		if(client != null) {
			BankAccount bAccount = BankAccountFactory.createBankAccount(client, accountNo, type);
		}
		return false;
	}
}
