package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ContentViewer extends JFrame {
	public ContentViewer() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Month");
		model.addColumn("Day");
		model.addColumn("Income");
		model.addColumn("Expense");
		model.addColumn("Content");
		model.addColumn("Place");		// 행의 내용을 add
		
				
		JTable table = new JTable(model);	// table에 model 저장
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
		
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
