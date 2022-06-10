package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.WindowFrame;

public class ButtonDeleteListener implements ActionListener {
	WindowFrame frame;
	
	public ButtonDeleteListener(WindowFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(frame.getContentdelete());
		frame.revalidate();
		frame.repaint();
	}
}
