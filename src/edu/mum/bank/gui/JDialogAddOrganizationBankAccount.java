package edu.mum.bank.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import edu.mum.account.AccountFactory;
import edu.mum.bank.CheckingAccountFactory;
import edu.mum.bank.SavingAccountFactory;
import edu.mum.client.ClientType;
import edu.mum.gui.Gui;
import edu.mum.gui.JDialogAddOrganizationAccount;
import edu.mum.gui.JDialogAddPersonalAccount;

public class JDialogAddOrganizationBankAccount extends JDialogAddOrganizationAccount{
	private static final long serialVersionUID = 3923935973635002311L;
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
		addComponentOnTopPanel(radioButtonChecking);
		
		radioButtonSaving = new JRadioButton();
		radioButtonSaving.setText("Checkings");
		addComponentOnTopPanel(radioButtonSaving);
		
		group.add(radioButtonChecking);
		group.add(radioButtonSaving);
	}
	
	@Override
	protected void addAccount() {
		AccountFactory factory = new AccountFactory();
		if (radioButtonChecking.isSelected()) {
			factory = new CheckingAccountFactory();
		} else if (radioButtonSaving.isSelected()) {
			factory = new SavingAccountFactory();
		}
		super.addAccount();
	}
}
