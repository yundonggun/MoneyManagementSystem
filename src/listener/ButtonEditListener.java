package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.WindowFrame;

public class ButtonEditListener implements ActionListener {		// add ��ư ������ �� ȭ�� ����
	WindowFrame frame;
	
	public ButtonEditListener(WindowFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(frame.getContentedit());
		frame.revalidate();
		frame.repaint();
	}
}
