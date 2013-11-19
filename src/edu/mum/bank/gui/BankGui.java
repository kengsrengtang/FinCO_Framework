package edu.mum.bank.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import main.FinCo;
import edu.mum.gui.Gui;
import edu.mum.gui.JDialogAddAccount;
import edu.mum.gui.JDialogAddOrganizationAccount;

public class BankGui extends Gui{

	JButton btnAddInterest ;
	
	public BankGui(FinCo application) {
		super(application);
		setUpBank();
	}
	
	private void setUpBank() {
		setTitle("BankCo Application");
		addButtons();
		addRadioButtons();
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
		loadAccounts();
	}
	
	@Override
	protected void showDialogAddOrganizationAccount() {
		JDialogAddAccount pac = new JDialogAddOrganizationBankAccount(this);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);
	};
	
	@Override
	protected void showDialogAddPersonalAccount() {
		JDialogAddAccount pac = new JDialogAddPersonalBankAccount(this);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -6917032200127926561L;

}
