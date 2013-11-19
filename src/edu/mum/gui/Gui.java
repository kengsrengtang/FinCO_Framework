package edu.mum.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.FinCo;
import edu.mum.client.IClient;

/**
 * A basic JFC based application.
 */
public class Gui extends javax.swing.JFrame {
	/****
	 * init variables in the object
	 ****/
	javax.swing.JPanel topPanel, rightPanel;
	javax.swing.JPanel centerPanel = new javax.swing.JPanel();
	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	private Object rowdata[];
	public FinCo application;

	private void initializeTopPanel() {
		topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton_PerAC.setText("Add personal account");
		topPanel.add(JButton_PerAC);

		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		topPanel.add(JButton_CompAC);
	}

	private void initializeCenterPanel() {
		JScrollPane1 = new JScrollPane();
		initializeTableModelWithHeader(new String[] { "A/C No.", "Name",
				"Email", "P/C", "Amount" });
		JTable1 = new JTable(model);
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		// centerPanel.setBounds(0, 0, 575, 310);
		centerPanel.add(JScrollPane1);
		//JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
		
	}

	public void addButtonInTopPanel(JButton button) {
		topPanel.add(button);
	}

	public void addButtonInRightPanel(JButton myButton) {
		rightPanel.add(myButton);
	}

	private void initializeRightPanel() {
		rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		JButton_Deposit.setText("Deposit");
		// JButton_Deposit.setBounds(468, 104, 96, 33);
		rightPanel.add(JButton_Deposit);

		JButton_Withdraw.setText("Withdraw");
		rightPanel.add(JButton_Withdraw);

		JButton_Exit.setText("Exit");
		rightPanel.add(JButton_Exit);
	}

	public Gui(FinCo application) {
		this.application = application;
		setSize(590, 340);
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("FinCo Application.");
		getContentPane().setLayout(new BorderLayout(0, 0));
		initializeTopPanel();
		initializeCenterPanel();
		initializeRightPanel();

		getContentPane().add(BorderLayout.CENTER, centerPanel);
		getContentPane().add(BorderLayout.NORTH, topPanel);
		getContentPane().add(BorderLayout.EAST, rightPanel);

		JButton_PerAC.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		// pack();
	}

	void exitApplication() {
		try {
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == Gui.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
		// to do: code goes here.

		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);

		}
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {

		showDialogAddPersonalAccount();
	}

	public void updateAmount(String amount) {
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			model.setValueAt(amount, selection, 4);
		}
	}
	public void loadAccount(){
		List<IClient> clients=new ArrayList<>();
		// = application.getClients();
		for(IClient client : clients){
			Object[] rowData = new Object[]{client};
		}
	}
	public void addAccount(Object[] rowData) {
		model.addRow(rowData);
		JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
	}

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		showDialogAddOrganizationAccount();
	}

	private void showDialogAddPersonalAccount() {
		// TODO Auto-generated method stub
		JDialogAddAccount pac = new JDialogAddCustomerAccount(this);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);
	}

	private void showDialogAddOrganizationAccount() {
		// TODO Auto-generated method stub
		JDialogAddAccount pac = new JDialogAddOrganizationAccount(this);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);
	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		deposit();
	}

	private void deposit() {
		// TODO Auto-generated method stub

		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);
			String accname = (String) model.getValueAt(selection, 1);
			JDialogEntry wd = new JDialogDeposit(this, accnr, accname);
			wd.setVisible(true);
		}
	}

	private void withdraw() {
		// TODO Auto-generated method stub
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);
			String accname = (String) model.getValueAt(selection, 1);
			JDialogEntry wd = new JDialogWithdraw(this, accnr, accname);
			wd.setVisible(true);
		}
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		withdraw();
	}
//
//	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
//		JOptionPane.showMessageDialog(JButton_Addinterest,
//				"Add interest to all accounts", "Add interest to all accounts",
//				JOptionPane.WARNING_MESSAGE);
//		reloadAccount();
//	}

	public void initializeTableModelWithHeader(String[] header) {
		model = new DefaultTableModel();
		if (header != null) {
			for (String e : header) {
				model.addColumn(e);
			}
		}
	}
}
