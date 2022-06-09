package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import manager.MoneyManager;


public class WindowFrame extends JFrame {
	MoneyManager moneyManager;
	MenuSelection menuselection;
	ContentAdder contentadder;
	ContentViewer contentviewer;
	ContentDelete contentdelete;
	ContentEdit contentedit;
	
	public WindowFrame(MoneyManager moneyManager) {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.moneyManager = moneyManager;
		menuselection = new MenuSelection(this);
		contentadder = new ContentAdder(this, this.moneyManager);
		contentdelete = new ContentDelete(this, this.moneyManager);
		contentedit = new ContentEdit(this, this.moneyManager);
		contentviewer = new ContentViewer(this, this.moneyManager);
		
		this.setupPanel(menuselection);
		
		this.setVisible(true);
	}
	
	public void setupPanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.revalidate();
		this.repaint();
	}
	
	public MenuSelection getMenuselection() {
		return menuselection;
	}

	public void setMenuselection(MenuSelection menuselection) {
		this.menuselection = menuselection;
	}

	public ContentAdder getContentadder() {
		return contentadder;
	}

	public void setContentadder(ContentAdder contentadder) {
		this.contentadder = contentadder;
	}

	public ContentViewer getContentviewer() {
		return contentviewer;
	}

	public void setContentviewer(ContentViewer contentviewer) {
		this.contentviewer = contentviewer;
	}
	
	public ContentDelete getContentdelete() {
		return contentdelete;
	}
	
	public void setContentdelete(ContentDelete contentdelete) {
		this.contentdelete = contentdelete;
	}
	
	public ContentEdit getContentedit() {
		return contentedit;
	}
	
	public void setContentedit(ContentEdit contentedit) {
		this.contentedit = contentedit;
	}
}
