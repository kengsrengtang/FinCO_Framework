package edu.mum.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class JDialogAddOrganizationAccount extends JDialogAddAccount {
	JTextField txtNoOfEmployee = new JTextField(20);
	public JDialogAddOrganizationAccount(Gui parent) {
		super(parent);
		setTitle("Add Organization Account");
		addComponents();
		// TODO Auto-generated constructor stub
	}
	private void addComponents() {
		// TODO Auto-generated method stub
		JLabel lblNoOfEmployee = new JLabel();
		lblNoOfEmployee.setText("No. of Employee");
		addEntryField(lblNoOfEmployee, txtNoOfEmployee);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 3926433810730452948L;

	@Override
	protected void addAccount() {
		// TODO Auto-generated method stub
		Object[] rowData = new Object[]{JTextField_ACNR.getText(),
				JTextField_NAME.getText(),
				JTextField_EM.getText(),"C","0"};
		//parent.fincoApp.createAccountForClient();
		parentframe.loadData(rowData);
	}

}
