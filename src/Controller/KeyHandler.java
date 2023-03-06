package Controller;

import Model.ChatConnection;
import Model.ChatLog;
import Model.Message;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyHandler implements KeyListener {
	private static KeyHandler instance;
	private JTextArea writeArea;
	
	private KeyHandler() {
	
	}
	
	public static KeyHandler getInstance() {
		if(instance == null) {
			instance = new KeyHandler();
		}
		return instance;
	}
	
	public void setWriteArea(JTextArea newArea) {
		writeArea = newArea;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//If they pressed the enter key, send their message
		if(e.getKeyChar() == KeyEvent.VK_ENTER) {
			if(writeArea == null) {
				System.err.println("KeyHandler's write area was not set");
			} else {
				ChatLog.getInstance().addMessage(new Message(writeArea.getText(), true));
				ChatConnection.getInstance().send(writeArea.getText());
				writeArea.setText("");
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
	
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	
	}
}
