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

public class ContentDeleteListener implements ActionListener {
	JTextField fieldMonth;
	JTextField fieldDay;
	MoneyManager moneyManager;
	
	public ContentDeleteListener(JTextField fieldMonth, JTextField fieldDay, MoneyManager moneyManager) {
		this.fieldMonth = fieldMonth;
		this.fieldDay = fieldDay;
		this.moneyManager = moneyManager;
	}
	
	public void actionPerformed(ActionEvent e) {
		DateInput money = new Month30(Month.Month30);
		try {
			money.setMonth1(fieldMonth.getText());
			money.setDay(Integer.parseInt(fieldDay.getText()));
			int index = moneyManager.findIndex(fieldMonth.getText(), Integer.parseInt(fieldDay.getText()));
			moneyManager.deleteContent(money, index);
			putObject(moneyManager, "moneymanager.ser");
			System.out.println("deleted");
		} catch (IndexOutOfBoundsException e1) {
			System.out.println("Check the Date.");
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
