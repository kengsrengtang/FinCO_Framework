package edu.mum.creditcard.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import edu.mum.gui.Gui;
import edu.mum.gui.JDialogAddAccount;
import edu.mum.gui.JDialogAddPersonalAccount;
import edu.mum.account.IAccount;
import edu.mum.bank.Bank;
import edu.mum.client.IClient;
import edu.mum.creditcard.*;

public class CreditCardGui extends Gui {
	private static final long serialVersionUID = 6897916759996642759L;
	JButton btnGenerateMonthlyBill ;
	CreditCardCo capplication;
	public CreditCardGui(CreditCardCo application) {
		super(application);
		capplication = application;
		setTitle("Credit Card Co Application");
		JButton_CompAC.setVisible(false);
		addButtons();
		initializeAccountTable(new String[] { "CC No.", "Name",
				"Expiry Date", "Type","Balance"});
		loadAccounts();
	}
	@Override
	public void loadAccounts() {
		clearTable();
		List<IClient> clients = application.getClients();
		for (IClient client : clients) {
		    edu.mum.client.Address address = client.getAddress();
			List<IAccount> accounts = client.getAccounts();
			for(IAccount acc:accounts) {
				Object[] rowData = new Object[] {acc.getAccountNo(),
						client.getName(),((CreditCardAccount)acc).getExpDate(),
						acc.getType(), acc.getBalance()};
				addAccount(rowData);
			}
		}
	}
	private void addButtons() {
		// TODO Auto-generated method stub
		btnGenerateMonthlyBill = new JButton();
		btnGenerateMonthlyBill.setText("Generate Monthly Bill");
		btnGenerateMonthlyBill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				generateMonthlyBill();
			}

			
		});
		addButtonInTopPanel(btnGenerateMonthlyBill);
	}
	private void generateMonthlyBill() {
			String report  = capplication.generateMonthlyBill();
			loadReport(report);
	}
	private void loadReport(String report) {
		// TODO Auto-generated method stub
		JDialogGenBill dialogBill = new JDialogGenBill(this, report);
		dialogBill.setVisible(true);
	}
	@Override
	protected void showDialogAddPersonalAccount() {
		// TODO Auto-generated method stub
		JDialogAddAccount pac = new JDialogAddCreditCardAccount(this);
		pac.setBounds(450, 20, 320, 400);
		pac.setVisible(true);
	}
	
	
}
