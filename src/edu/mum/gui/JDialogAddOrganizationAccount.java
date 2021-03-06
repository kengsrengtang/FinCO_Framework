package edu.mum.gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.mum.account.AccountFactory;
import edu.mum.account.IAccount;
import edu.mum.client.ClientType;

public class JDialogAddOrganizationAccount extends JDialogAddAccount {
	protected JTextField txtNoOfEmployee = new JTextField(20);

	public JDialogAddOrganizationAccount(Gui parent) {
		super(parent);
		setTitle("Add Organization Account");
		addComponents();
		// TODO Auto-generated constructor stub
	}

	private void addComponents() {
		// TODO Auto-generated method stub
		JLabel lblNoOfEmployee = new JLabel();
		lblNoOfEmployee.setText(" No. of Employee");
		addEntryField(lblNoOfEmployee, txtNoOfEmployee);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3926433810730452948L;

	@Override
	protected void addAccount() {
		AccountFactory factory = new AccountFactory();
		addAccount(factory);
	}
	
	protected void addAccount(AccountFactory factory) {
		try {
			IAccount account = parentframe.getApplication()
					.createAccountForOrganization(JTextField_NAME.getText(),
							JTextField_STR.getText(), JTextField_CT.getText(),
							JTextField_ST.getText(), JTextField_ZIP.getText(),
							JTextField_EM.getText(),
							Integer.parseInt(txtNoOfEmployee.getText()),
							JTextField_ACNR.getText(), factory);

			if (account != null) {
				Object[] rowData = new Object[] { JTextField_ACNR.getText(),
						JTextField_NAME.getText(), JTextField_EM.getText(),
						ClientType.ORGANIZATIONAL, "0" };
				parentframe.addAccount(rowData);
				parentframe.getApplication().addAccountToList(account);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this,
					"Please enter number for number of Employee");
		}
	}

}
