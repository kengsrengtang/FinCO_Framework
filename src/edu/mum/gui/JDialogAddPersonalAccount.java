package edu.mum.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.mum.account.AccountFactory;
import edu.mum.account.IAccount;
import edu.mum.client.ClientType;

public class JDialogAddPersonalAccount extends JDialogAddAccount {
	protected JTextField txtBirthDate = new JTextField(20);

	public JDialogAddPersonalAccount(Gui parent) {
		super(parent);
		setTitle("Add Client Account");
		addComponents();
		// TODO Auto-generated constructor stub
	}

	private void addComponents() {
		// TODO Auto-generated method stub
		JLabel lblBirthdate = new JLabel();
		lblBirthdate.setText(" Birth Date");
		txtBirthDate.setText("5/20/1987");
		addEntryField(lblBirthdate, txtBirthDate);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2511422332206031915L;

	@Override
	protected void addAccount() {
		AccountFactory factory = new AccountFactory();
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
						ClientType.PERSONAL, "0" };
				parentframe.addAccount(rowData);
				parentframe.getApplication().addAccountToList(account);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
