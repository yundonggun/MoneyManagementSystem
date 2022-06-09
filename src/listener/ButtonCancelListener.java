package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.WindowFrame;

public class ButtonCancelListener implements ActionListener {		// add ������ �� ȭ�鿡�� cancel ��ư ���� ��
	WindowFrame frame;
	
	public ButtonCancelListener(WindowFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(frame.getMenuselection());
		frame.revalidate();
		frame.repaint();
	}
}
