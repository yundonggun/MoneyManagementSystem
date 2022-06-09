package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.WindowFrame;

public class ButtonAddListener implements ActionListener {		// add 버튼 눌렀을 때 화면 변경
	WindowFrame frame;
	
	public ButtonAddListener(WindowFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(frame.getContentadder());
		frame.revalidate();
		frame.repaint();
	}
}
