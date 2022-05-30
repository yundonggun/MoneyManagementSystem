package gui;

import java.awt.*;
import javax.swing.*;

import listener.ButtonAddListener;
import listener.ButtonShowListener;

public class MenuSelection extends JPanel {
	WindowFrame frame;
	
	public MenuSelection(WindowFrame frame) {
		this.frame = frame;
		this.setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel label = new JLabel("Menu Selection");
		
		JButton button1 = new JButton("Add Content");
		JButton button2 = new JButton("Delete Content");
		JButton button3 = new JButton("Edit Content");
		JButton button4 = new JButton("Show Content");
		JButton button5 = new JButton("Exit Program");
		
		button1.addActionListener(new ButtonAddListener(frame));
		button4.addActionListener(new ButtonShowListener(frame));
		
		
		panel1.add(label); 
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);		
	}
}
