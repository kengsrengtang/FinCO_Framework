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
		// TODO Auto-generated method stub
		parentframe.updateAmount(JTextField_Deposit.getText());
	}

}
