package edu.mum.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class JDialogAddCustomerAccount extends JDialogAddAccount{
	JTextField txtBirthDate = new JTextField(20);
	public JDialogAddCustomerAccount(Gui parent) {
		super(parent);
		setTitle("Add Customer Account");
		addComponents();
		// TODO Auto-generated constructor stub
	}

	private void addComponents() {
		// TODO Auto-generated method stub
		JLabel lblBirthdate = new JLabel();
		lblBirthdate.setText("Birth Date");
		addEntryField(lblBirthdate, txtBirthDate);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2511422332206031915L;

	@Override
	protected void addAccount() {
		// TODO Auto-generated method stub
		Object[] rowData = new Object[]{JTextField_ACNR.getText(),
									JTextField_NAME.getText(),
									JTextField_EM.getText(),"P","0"};
		//parent.fincoApp.createAccountForClient();
		parentframe.loadData(rowData);
	}
}
