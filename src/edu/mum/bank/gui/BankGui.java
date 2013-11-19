package edu.mum.bank.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import main.FinCo;
import edu.mum.gui.Gui;

public class BankGui extends Gui{

	JButton btnAddInterest ;
	public BankGui(FinCo application) {
		super(application);
		setUpBank();
	}
	
	private void setUpBank() {
		setTitle("BankCo Application");
		addButtons();
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
	/**
	 * 
	 */
	private static final long serialVersionUID = -6917032200127926561L;

}
