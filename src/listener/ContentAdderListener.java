package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JTextField;

import exception.Month1FormatException;
import manager.MoneyManager;
import money.DateInput;
import money.Month;
import money.Month30;

public class ContentAdderListener implements ActionListener {	// add 눌렀을 때 save 누를 때
	JTextField fieldMonth;
	JTextField fieldDay;
	JTextField fieldIncome;
	JTextField fieldExpense;
	JTextField fieldContent;
	JTextField fieldPlace;
	
	MoneyManager moneyManager;
	
	public ContentAdderListener(JTextField fieldMonth, JTextField fieldDay,
			JTextField fieldIncome, JTextField fieldExpense, 
			JTextField fieldContent, JTextField fieldPlace, MoneyManager moneyManager) {
		this.fieldMonth = fieldMonth;
		this.fieldDay = fieldDay;
		this.fieldIncome = fieldIncome;
		this.fieldExpense = fieldExpense;
		this.fieldContent = fieldContent;
		this.fieldPlace = fieldPlace;
		this.moneyManager = moneyManager;
	}
	
	public void actionPerformed(ActionEvent e) {
		DateInput money = new Month30(Month.Month30);
		try {
			money.setMonth1(fieldMonth.getText());
			money.setDay(Integer.parseInt(fieldDay.getText()));
			money.setIncome(Integer.parseInt(fieldIncome.getText()));
			money.setExpense(Integer.parseInt(fieldExpense.getText()));
			money.setContent(fieldContent.getText());
			money.setPlace(fieldPlace.getText());
			moneyManager.addContent(money);
			putObject(moneyManager, "moneymanager.ser");
			money.printInfo();
		} catch (Month1FormatException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void putObject(MoneyManager moneyManager, String filename) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(moneyManager);
			
			out.close();
			file.close();
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
