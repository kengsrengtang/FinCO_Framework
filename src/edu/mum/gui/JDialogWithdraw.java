package edu.mum.gui;

public class JDialogWithdraw extends JDialogEntry{
	private static final long serialVersionUID = 2027705903397166852L;
	public JDialogWithdraw(Gui parent, String aaccnr, String accName) {
		super(parent, aaccnr,accName);
		setTitle("Withdraw");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SumbitEntry() {
		Double currentBalance = parentframe.application.withdrawing(accnr,
							Double.parseDouble(JTextField_Deposit.getText()));
		parentframe.updateAmount(String.valueOf(currentBalance));
	}

}
