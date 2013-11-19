package edu.mum.gui;

public class JDialogWithdraw extends JDialogEntry{

	public JDialogWithdraw(Gui parent, String aaccnr, String accName) {
		super(parent, aaccnr,accName);
		setTitle("Withdraw");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2027705903397166852L;

	@Override
	public void SumbitEntry() {
		// TODO Auto-generated method stub
		parentframe.updateAmount(JTextField_Deposit.getText());
	}

}
