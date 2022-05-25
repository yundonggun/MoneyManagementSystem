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
		model.addColumn("Place");		// ���� ������ add
		
				
		JTable table = new JTable(model);	// table�� model ����
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
		
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
