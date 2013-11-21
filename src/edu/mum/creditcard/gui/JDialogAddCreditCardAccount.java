package edu.mum.creditcard.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import edu.mum.account.AccountFactory;
import edu.mum.account.IAccount;
import edu.mum.client.ClientType;
import edu.mum.creditcard.BronzeCCFactory;
import edu.mum.creditcard.CreditCardFactory;
import edu.mum.creditcard.GoldCCFactory;
import edu.mum.creditcard.SilverCCFactory;
import edu.mum.gui.JDialogAddPersonalAccount;

public class JDialogAddCreditCardAccount extends JDialogAddPersonalAccount {
	private static final long serialVersionUID = -50320285834880679L;
	protected JRadioButton radioButtonGold;
	protected JRadioButton radioButtonBronze;
	protected JRadioButton radioButtonSilver;
	protected JTextField txtExpiryDate = new JTextField();

	public JDialogAddCreditCardAccount(CreditCardGui parent) {
		super(parent);
		JLabel8.setText("CC Number");
		
		setTitle("Add CreditCard Account");
		addRadioButtons();
		addExpiryDateField();
	}
	
	private void addRadioButtons() {
		// TODO Auto-generated method stub
		ButtonGroup group = new ButtonGroup();

		radioButtonGold = new JRadioButton();
		radioButtonGold.setText("Gold");
		radioButtonGold.setSelected(true);
		addComponentOnTopPanel(radioButtonGold);

		radioButtonSilver = new JRadioButton();
		radioButtonSilver.setText("Silver");
		addComponentOnTopPanel(radioButtonSilver);
		
		radioButtonBronze = new JRadioButton();
		radioButtonBronze.setText("Bronze");
		addComponentOnTopPanel(radioButtonBronze);
		
		group.add(radioButtonGold);
		group.add(radioButtonSilver);
		group.add(radioButtonBronze);
	}
	
	private void addExpiryDateField() {
		// TODO Auto-generated method stub
		JLabel lblExpiryDate = new JLabel();
		lblExpiryDate.setText("Card Expiry Date");
		txtExpiryDate.setText("12/31/2015");
		addEntryField(lblExpiryDate, txtExpiryDate);
	}
	
 	@Override
	protected void addAccount() {
 		AccountFactory factory = new AccountFactory();
		if(radioButtonGold.isSelected()) {
			factory = new GoldCCFactory();
		}else if(radioButtonSilver.isSelected()) {
			factory = new SilverCCFactory();
		}else if(radioButtonBronze.isSelected()) {
			factory = new BronzeCCFactory();
		}
		addAccount(factory);
	}
 	
 	protected void addAccount(AccountFactory factory) {
		try {
			IAccount account = parentframe.getApplication().createAccountForPerson(
					JTextField_NAME.getText(), JTextField_STR.getText(),
					JTextField_CT.getText(), JTextField_ST.getText(),
					JTextField_ZIP.getText(), JTextField_EM.getText(),
					new SimpleDateFormat("dd/MM/YYYY", Locale.ENGLISH).parse(txtBirthDate.getText()),
					JTextField_ACNR.getText(),factory);
			if(account != null){
				Object[] rowData = new Object[] { JTextField_ACNR.getText(),
						JTextField_NAME.getText(), JTextField_CT.getText(),
						account.getType(), "0.0" };
				parentframe.addAccount(rowData);
				parentframe.getApplication().addAccountToList(account);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
