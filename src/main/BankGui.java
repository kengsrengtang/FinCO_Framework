package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.mum.gui.Gui;

public class BankGui extends Gui{
	public BankGui(){
		super();
		JButton myButton = new JButton();
		myButton.setText("Hello!");
		myButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello");
				
			}
		});
		
		addButtonInRightPanel(myButton);
	}
}
