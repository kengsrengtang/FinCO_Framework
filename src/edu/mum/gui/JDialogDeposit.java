package edu.mum.gui;

public class JDialogDeposit extends JDialogEntry{

	public JDialogDeposit(Gui parent, String aaccnr, String accName) {
		super(parent, aaccnr,accName);
		setTitle("Deposit");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4601572589749890045L;

	@Override
	public void SumbitEntry() {
		double currentBalance = parentframe.getApplication().depositing(accnr, 
										Double.parseDouble(JTextField_Deposit.getText()));
		parentframe.loadAccounts();
		//parentframe.updateAmount(String.valueOf(currentBalance));
	}

}
