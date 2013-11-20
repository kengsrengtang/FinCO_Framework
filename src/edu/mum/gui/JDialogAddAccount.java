package edu.mum.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.mum.util.FincoRandom;


public abstract class JDialogAddAccount extends javax.swing.JDialog
{
	private static final long serialVersionUID = 1L;
	private final static int textSize=20;
    protected Gui parentframe;
  //{{DECLARE_CONTROLS
    private JPanel topPanel,centerPanel,bottomPanel;
    
  	protected javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
  	protected javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();
  	protected javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
  	protected javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
  	protected javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
  	protected javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
  	protected javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
  	protected javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
  	protected javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
  	protected javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField(textSize);
  	protected javax.swing.JTextField JTextField_CT = new javax.swing.JTextField(textSize);
  	protected javax.swing.JTextField JTextField_ST = new javax.swing.JTextField(textSize);
  	protected javax.swing.JTextField JTextField_STR = new javax.swing.JTextField(textSize);
  	protected javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField(textSize);
  	protected javax.swing.JTextField JTextField_NoOfEmp = new javax.swing.JTextField(textSize);
  	protected javax.swing.JTextField JTextField_EM = new javax.swing.JTextField(textSize);
  	
  	protected javax.swing.JButton JButton_OK = new javax.swing.JButton();
  	protected javax.swing.JButton JButton_Calcel = new javax.swing.JButton();
  	protected javax.swing.JLabel JLabel8 = new javax.swing.JLabel();
  	protected javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField(textSize);
  	//}}
	public JDialogAddAccount(Gui parent)
	{
		super(parent);
		parentframe=parent;
		
		setTitle("Testing Add compamy account");
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		//setSize(298,339);
		setVisible(false);
		initializePanels();
		setRadioButtons();
		setEntryFields();
		setActionButtons();
		pack();
	}
	private void setActionButtons() {
		// TODO Auto-generated method stub
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		bottomPanel.add(JButton_OK);
		
		JButton_Calcel.setText("Cancel");
		JButton_Calcel.setActionCommand("Cancel");
		bottomPanel.add(JButton_Calcel);
		
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Calcel.addActionListener(lSymAction);
	}
	private void setEntryFields() {
		// TODO Auto-generated method stub
		JLabel8.setText(" Acc Nr");
		JLabel8.setForeground(java.awt.Color.black);
		JTextField_ACNR.setEditable(false);
		JTextField_ACNR.setText(""+FincoRandom.nextUniqueId());
		addEntryField(JLabel8, JTextField_ACNR);
		
		JLabel1.setText(" Name");
		JLabel1.setForeground(java.awt.Color.black);
		addEntryField(JLabel1, JTextField_NAME);
		
		JLabel2.setText(" Street");
		JLabel2.setForeground(java.awt.Color.black);
		addEntryField(JLabel2, JTextField_STR);
		
		JLabel3.setText(" City");
		JLabel3.setForeground(java.awt.Color.black);
		addEntryField(JLabel3, JTextField_CT);
		
		JLabel4.setText(" State");
		JLabel4.setForeground(java.awt.Color.black);
		addEntryField(JLabel4, JTextField_ST);
		
		JLabel5.setText(" Zip");
		JLabel5.setForeground(java.awt.Color.black);
		addEntryField(JLabel5, JTextField_ZIP);
		
		JLabel7.setText(" Email");
		JLabel7.setForeground(java.awt.Color.black);
		addEntryField(JLabel7, JTextField_EM);
	}
	private void setRadioButtons() {
		// TODO Auto-generated method stub
//		JRadioButton_Chk.setText("Checkings");
//		JRadioButton_Chk.setActionCommand("Checkings");
//		addRadioButtonOnTopPanel(JRadioButton_Chk);
//		
//		JRadioButton_Sav.setText("Savings");
//		JRadioButton_Sav.setActionCommand("Savings");
//		addRadioButtonOnTopPanel(JRadioButton_Sav);
	}
	private void initializePanels(){
		topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		getContentPane().add(BorderLayout.CENTER, centerPanel);
		getContentPane().add(BorderLayout.NORTH, topPanel);
		getContentPane().add(BorderLayout.SOUTH, bottomPanel);
	}
	public void addComponentOnTopPanel(JComponent component){
		topPanel.add(component);
	}
	abstract protected void addAccount();
	public void addEntryField(JLabel label, JTextField textField){
		JPanel panel = new JPanel(new GridLayout(1,2,0,10));
		panel.add(label);
		panel.add(textField);
		centerPanel.add(panel);
		centerPanel.add(Box.createVerticalStrut(5));
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Calcel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
	   addAccount();
	   dispose(); 
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose(); 
	}
}