package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import gui.ContentViewer;
import gui.WindowFrame;
import manager.MoneyManager;

public class ButtonShowListener implements ActionListener {		// show 버튼 눌렀을 때 화면 변경
	WindowFrame frame;
	
	public ButtonShowListener(WindowFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		MoneyManager moneyManager = getObject("moneymanager.ser");
		ContentViewer contentViewer = frame.getContentviewer();
		contentViewer.setMoneyManager(moneyManager);
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(contentViewer);
		frame.revalidate();
		frame.repaint();
	}

	public static MoneyManager getObject(String filename) {
		MoneyManager moneyManager = null;
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			
			moneyManager = (MoneyManager)in.readObject();
			
			in.close();
			file.close();
		} catch (FileNotFoundException e) {	
			return moneyManager;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return moneyManager; 
	}
}
