package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import gui.ContentViewer;
import gui.WindowFrame;

public class ButtonShowListener implements ActionListener {
	WindowFrame frame;
	
	public ButtonShowListener(WindowFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		ContentViewer viewer = frame.getContentviewer();		// «¡∑π¿”¿« ≥ªøÎ¿ª πŸ≤„¡‹
		frame.setupPanel(viewer);
	}

}
