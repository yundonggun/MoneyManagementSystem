package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import listener.ButtonCancelListener;
import listener.ContentDeleteListener;
import manager.MoneyManager;

public class ContentDelete extends JPanel {
	WindowFrame frame;
	MoneyManager moneyManager;
	
	public ContentDelete(WindowFrame frame, MoneyManager moneyManager) {
		this.frame = frame;
		this.moneyManager = moneyManager;
		
		JPanel panel = new JPanel();
		panel.setLayout(new SpringLayout());
		
		JLabel labelMonth = new JLabel("Month: ", JLabel.TRAILING);		
		JTextField fieldMonth = new JTextField(10);		// label을 출력하고 입력 받는 부분을 만듬
		labelMonth.setLabelFor(fieldMonth);
		panel.add(labelMonth);
		panel.add(fieldMonth);
		
		JLabel labelDay = new JLabel("Day: ", JLabel.TRAILING);
		JTextField fieldDay = new JTextField(10);
		labelDay.setLabelFor(fieldDay);
		panel.add(labelDay);
		panel.add(fieldDay);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ContentDeleteListener(fieldMonth, fieldDay, moneyManager));
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ButtonCancelListener(frame));
		
		panel.add(deleteButton);
		panel.add(cancelButton);
		
		SpringUtilities.makeCompactGrid(panel, 3, 2, 6, 60, 6, 6);
		
		this.add(panel);
	}
}
