package gui;

import java.awt.*;
import javax.swing.*;

public class ContentAdder extends JPanel {
	WindowFrame frame;
	
	public ContentAdder(WindowFrame frame) {
		this.frame = frame;
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
		
		JLabel labelIncome = new JLabel("Income: ", JLabel.TRAILING);
		JTextField fieldIncome = new JTextField(10);
		labelIncome.setLabelFor(fieldIncome);
		panel.add(labelIncome);
		panel.add(fieldIncome);
		
		JLabel labelExpense = new JLabel("Expense: ", JLabel.TRAILING);
		JTextField fieldExpense = new JTextField(10);
		labelExpense.setLabelFor(fieldExpense);
		panel.add(labelExpense);
		panel.add(fieldExpense);
		
		JLabel labelContent = new JLabel("Content: ", JLabel.TRAILING);
		JTextField fieldContent = new JTextField(10);
		labelContent.setLabelFor(fieldContent);
		panel.add(labelContent);
		panel.add(fieldContent);
		
		JLabel labelPlace = new JLabel("Place: ", JLabel.TRAILING);
		JTextField fieldPlace = new JTextField(10);
		labelPlace.setLabelFor(fieldPlace);
		panel.add(labelPlace);
		panel.add(fieldPlace);
		
		panel.add(new JButton("Save"));
		panel.add(new JButton("Cancel"));
		
		SpringUtilities.makeCompactGrid(panel, 7, 2, 6, 6, 6, 6);
		// panel을 격자 모양으로 나타냄

		this.add(panel);
	}
}
