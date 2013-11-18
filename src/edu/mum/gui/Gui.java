package edu.mum.gui;

import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

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
	javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();
	
	private String[] dataHeader = {"AccountNr","Name","City","P/C","Ch/S","Amount"};

	String accountnr, clientName, street, city, zip, state, accountType,
			clientType, amountDeposit;
	boolean newaccount;
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	Gui myframe;
	private Object rowdata[];
	
	private void initializeTopPanel() {
		topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton_PerAC.setText("Add personal account");
		topPanel.add(JButton_PerAC);
		
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		topPanel.add(JButton_CompAC);
		
		JButton_Addinterest.setText("Add interest");
		topPanel.add(JButton_Addinterest);
	}

	private void initializeCenterPanel() {
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		
		setHeaderColumns(null);
		rowdata = new Object[8];
		newaccount = false;
		centerPanel = new JPanel();
		centerPanel.setLayout(null);
		//centerPanel.setBounds(0, 0, 575, 310);
		centerPanel.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);	
		// rowdata = new Object[8];
	}
	public void addButtonInTopPanel(JButton button){
		topPanel.add(button);
	}
	public void addButtonInRightPanel(JButton myButton){
		rightPanel.add(myButton);
	}
	private void initializeRightPanel() {
		rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		JButton_Deposit.setText("Deposit");
		//JButton_Deposit.setBounds(468, 104, 96, 33);
		rightPanel.add(JButton_Deposit);
		
		JButton_Withdraw.setText("Withdraw");
		rightPanel.add(JButton_Withdraw);
		
		JButton_Exit.setText("Exit");
		rightPanel.add(JButton_Exit);
	}

	public Gui() {
		myframe = this;
		setSize(590,340);
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("FinCo Application.");
		getContentPane().setLayout(new BorderLayout(0, 0));
		initializeTopPanel();
		initializeCenterPanel();
		initializeRightPanel();
		
		getContentPane().add(BorderLayout.CENTER, centerPanel);
		getContentPane().add(BorderLayout.NORTH, topPanel);
		getContentPane().add(BorderLayout.EAST, rightPanel);
		
		/*
		 * /Add five buttons on the pane /for Adding personal account, Adding
		 * company account /Deposit, Withdraw and Exit from the system
		 */


		
		
		
		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		// $$ lineBorder1.move(24,312);

		JButton_PerAC.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
		//pack();
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
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);

		}
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information
		 * construct a JDialog_AddPAcc type object set the boundaries and show
		 * it
		 */

		JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount) {
			// add row to table
			rowdata[0] = accountnr;
			rowdata[1] = clientName;
			rowdata[2] = city;
			rowdata[3] = "P";
			rowdata[4] = accountType;
			rowdata[5] = "0";
			model.addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newaccount = false;
		}

	}

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * construct a JDialog_AddCompAcc type object set the boundaries and
		 * show it
		 */

		JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount) {
			// add row to table
			rowdata[0] = accountnr;
			rowdata[1] = clientName;
			rowdata[2] = city;
			rowdata[3] = "C";
			rowdata[4] = accountType;
			rowdata[5] = "0";
			model.addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newaccount = false;
		}

	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(myframe, accnr);
			dep.setBounds(430, 15, 275, 140);
			dep.show();

			// compute new amount
			long deposit = Long.parseLong(amountDeposit);
			String samount = (String) model.getValueAt(selection, 5);
			long currentamount = Long.parseLong(samount);
			long newamount = currentamount + deposit;
			model.setValueAt(String.valueOf(newamount), selection, 5);
		}

	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding withdraw amount for the current mane
			JDialog_Withdraw wd = new JDialog_Withdraw(myframe, accnr);
			wd.setBounds(430, 15, 275, 140);
			wd.show();

			// compute new amount
			long deposit = Long.parseLong(amountDeposit);
			String samount = (String) model.getValueAt(selection, 5);
			long currentamount = Long.parseLong(samount);
			long newamount = currentamount - deposit;
			model.setValueAt(String.valueOf(newamount), selection, 5);
			if (newamount < 0) {
				JOptionPane.showMessageDialog(JButton_Withdraw,
						" Account " + accnr + " : balance is negative: $"
								+ String.valueOf(newamount) + " !",
						"Warning: negative balance",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		JOptionPane.showMessageDialog(JButton_Addinterest,
				"Add interest to all accounts", "Add interest to all accounts",
				JOptionPane.WARNING_MESSAGE);

	}
	
	public void setHeaderColumns(String[] header) {
		if(header != null) dataHeader = header;
		for(String e:dataHeader) {
			model.addColumn(e);
		}
	}
}
