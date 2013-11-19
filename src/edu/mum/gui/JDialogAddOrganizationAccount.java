package edu.mum.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.mum.client.ClientType;

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
		try {
			/*
			boolean success = parentframe.application.createAccountForClient(
					JTextField_NAME.getText(), JTextField_STR.getText(),
					JTextField_CT.getText(), JTextField_ST.getText(),
					JTextField_ZIP.getText(), JTextField_EM.getText(),
					new SimpleDateFormat("dd/MM/YYYY", Locale.ENGLISH).parse(txtBirthDate.getText()), ClientType.PERSONAL,
					JTextField_ACNR.getText());
			*/
			new SimpleDateFormat("dd/MM/YYYY", Locale.ENGLISH).parse("12/12/2013");
			boolean success =true;
			if(success){
				Object[] rowData = new Object[] { JTextField_ACNR.getText(),
						JTextField_NAME.getText(), JTextField_EM.getText(),
						ClientType.PERSONAL, "0" };
				parentframe.addAccount(rowData);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
