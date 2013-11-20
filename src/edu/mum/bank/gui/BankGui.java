package edu.mum.bank.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import edu.mum.account.IAccount;
import edu.mum.bank.Bank;
import edu.mum.client.IClient;
import edu.mum.gui.Gui;
import edu.mum.gui.JDialogAddAccount;

public class BankGui extends Gui{

	JButton btnAddInterest ;
	Bank myApplication;
	public BankGui(Bank application) {
		super(application);
		setUpBank();
		myApplication = application;
	}
	
	private void setUpBank() {
		setTitle("BankCo Application");
		addButtons();
		addRadioButtons();
		initializeAccountTable(new String[] { "A/C No.", "Name",
				"City", "P/C","Ch/S", "Amount" });
		loadAccounts();
		
	}

	private void addRadioButtons() {
		// TODO Auto-generated method stub
		
	}
	
	private void addButtons() {
		// TODO Auto-generated method stub
		btnAddInterest = new JButton();
		btnAddInterest.setText("Add Interest");
		btnAddInterest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				addInterestToAllAccounts();
			}
		});
		addButtonInTopPanel(btnAddInterest);
	}
	private void addInterestToAllAccounts() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(btnAddInterest,
				"Add interest to all accounts", "Add interest to all accounts",
				JOptionPane.WARNING_MESSAGE);
		
		//call application.addInterest();
		myApplication.addInterestToAllAccount();
		loadAccounts();
	}
	
	@Override
	public void updateAmount(String amount) {
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			model.setValueAt(amount, selection, 4);
		}
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
						client.getName(),address.getCity(),client.getType(),
						acc.getType(), acc.getBalance()};
				addAccount(rowData);
			}
		}
	}
	
	@Override
	protected void showDialogAddOrganizationAccount() {
		JDialogAddAccount pac = new JDialogAddOrganizationBankAccount(this);
		pac.setBounds(450, 20, 300, 380);
		pac.setVisible(true);
	};
	
	@Override
	protected void showDialogAddPersonalAccount() {
		JDialogAddAccount pac = new JDialogAddPersonalBankAccount(this);
		pac.setBounds(450, 20, 300, 380);
		pac.setVisible(true);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -6917032200127926561L;

}
