package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import listener.ButtonCancelListener;
import manager.MoneyManager;
import money.DateInput;

public class ContentViewer extends JPanel {
	WindowFrame frame;
	MoneyManager moneyManager;
	
	public MoneyManager getMoneyManager() {
		return moneyManager;
	}

	public void setMoneyManager(MoneyManager moneyManager) {
		this.moneyManager = moneyManager;
		this.removeAll();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Month");
		model.addColumn("Day");
		model.addColumn("Income");
		model.addColumn("Expense");
		model.addColumn("Content");
		model.addColumn("Place");		// 행의 내용을 add
		
		for (int i = 0; i < moneyManager.size(); i++) {
			Vector row = new Vector();
			DateInput di = moneyManager.get(i);
			row.add(di.getMonth1());
			row.add(di.getDay());
			row.add(di.getIncome());
			row.add(di.getExpense());
			row.add(di.getContent());
			row.add(di.getPlace());
			model.addRow(row);
		}
		
		JTable table = new JTable(model);	// table에 model 저장
		table.setSize(400, 400);
		JScrollPane sp = new JScrollPane(table);	
		sp.setPreferredSize(new Dimension(400, 200));

		JPanel panel = new JPanel();
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ButtonCancelListener(frame));
		
		panel.add(cancelButton, BorderLayout.SOUTH);
		
		this.add(sp);	
		this.add(panel);
	}

	public ContentViewer(WindowFrame frame, MoneyManager moneyManager) {
		this.frame = frame;
		this.moneyManager = moneyManager;
		
		System.out.println("***" + moneyManager.size() + "***");
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Month");
		model.addColumn("Day");
		model.addColumn("Income");
		model.addColumn("Expense");
		model.addColumn("Content");
		model.addColumn("Place");		// 행의 내용을 add
		
		for (int i = 0; i < moneyManager.size(); i++) {
			Vector row = new Vector();
			DateInput di = moneyManager.get(i);
			row.add(di.getMonth1());
			row.add(di.getDay());
			row.add(di.getIncome());
			row.add(di.getExpense());
			row.add(di.getContent());
			row.add(di.getPlace());
			model.addRow(row);
		}
				
		JTable table = new JTable(model);	// table에 model 저장
		table.setSize(400, 400);
		JScrollPane sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(400, 200));
		
		JPanel panel = new JPanel();
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ButtonCancelListener(frame));
		
		panel.add(cancelButton);
		
		this.add(sp);
		this.add(panel);
	}
}
