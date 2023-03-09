package Controller;

import Model.ChatConnection;
import Model.ChatLog;
import Model.Message;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * Singleton class to handles key input for the chat
 */
public class KeyHandler implements KeyListener {
	private static KeyHandler instance;
	private JTextArea writeArea;

	/** Private constructor to implement singleton */
	private KeyHandler() {
	}

	/**
	 * 
	 * Gets the singleton instance of KeyHandler
	 * 
	 * @return The single KeyHandler object
	 */
	public static KeyHandler getInstance() {
		if (instance == null) {
			instance = new KeyHandler();
		}
		return instance;
	}

	public void setWriteArea(JTextArea newArea) {
		writeArea = newArea;
	}

	/**
	 * Is called when a key is typed into the chat box
	 * If the enter key was pressed, sends the message using ChatConnection
	 * Uses the writeArea field to get the text to write; this field is set in
	 * Chat's constructor
	 *
	 * @param e Event to act on
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// If they pressed the enter key, send their message
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			if (writeArea == null) {
				System.err.println("KeyHandler's write area was not set");
			} else {
				if (!writeArea.getText().strip().equals("")) {
					ChatLog.getInstance().addMessage(new Message(writeArea.getText(), true));
					ChatConnection.getInstance().send(writeArea.getText());
				}
				writeArea.setText("");
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}
