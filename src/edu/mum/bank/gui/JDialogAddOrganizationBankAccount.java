package edu.mum.bank.gui;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import edu.mum.gui.Gui;
import edu.mum.gui.JDialogAddOrganizationAccount;
import edu.mum.gui.JDialogAddPersonalAccount;

public class JDialogAddOrganizationBankAccount extends JDialogAddOrganizationAccount{

	JRadioButton radioButtonChecking, radioButtonSaving;
	public JDialogAddOrganizationBankAccount(Gui parent) {
		super(parent);
		setupBankAccountForm();
		// TODO Auto-generated constructor stub
	}

	private void setupBankAccountForm() {
		// TODO Auto-generated method stub
		setTitle("Add Organization Bank Account");
		addRadioButtons();
	}

	private void addRadioButtons() {
		// TODO Auto-generated method stub
		ButtonGroup group = new ButtonGroup();
		
		radioButtonChecking = new JRadioButton();
		radioButtonChecking.setText("Checkings");
		radioButtonChecking.setSelected(true);
		addComponentOnTopPanel(radioButtonChecking);
		
		radioButtonSaving = new JRadioButton();
		radioButtonSaving.setText("Checkings");
		addComponentOnTopPanel(radioButtonSaving);
		
		group.add(radioButtonChecking);
		group.add(radioButtonSaving);
	}
	
	
	
	@Override
	protected void addAccount() {
		
	};
	/**
	 * 
	 */
	private static final long serialVersionUID = 3923935973635002311L;

}
