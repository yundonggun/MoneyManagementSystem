package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.WindowFrame;

public class ButtonExitListener implements ActionListener {
	WindowFrame frame;
	
	public ButtonExitListener(WindowFrame frame) {
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		System.exit(0);		// 프로그램 종료
	}
}
