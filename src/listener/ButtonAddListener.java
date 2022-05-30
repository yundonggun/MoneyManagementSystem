package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.ContentAdder;
import gui.ContentViewer;
import gui.WindowFrame;

public class ButtonAddListener implements ActionListener {
	WindowFrame frame;
	
	public ButtonAddListener(WindowFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		ContentAdder adder = frame.getContentadder();		// «¡∑π¿”¿« ≥ªøÎ¿ª πŸ≤„¡‹
		frame.setupPanel(adder);
	}
}
