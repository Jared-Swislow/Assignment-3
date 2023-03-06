package View;

import Controller.KeyHandler;
import Model.ChatLog;
import Model.Message;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**Displays chat
 * */
public class Chat extends JPanel implements Observer {
	private static final String noChatYet = "No Chat yet...";
	
	private final JTextArea displayArea;
	private final JTextArea writeArea;
	Chat() {
		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);
		
		setBackground(Color.GRAY);
		
		displayArea = new JTextArea(noChatYet);
		displayArea.setEditable(false);
		displayArea.setRows(5);
		displayArea.setLineWrap(true);

		JButton sendButton = new JButton("Send");
		add(sendButton, BorderLayout.EAST);

		add(displayArea, BorderLayout.NORTH);
		
		writeArea = new JTextArea();
		writeArea.setBackground(Color.lightGray);
		writeArea.setRows(4);
		writeArea.addKeyListener(KeyHandler.getInstance());
		writeArea.setLineWrap(true);
		KeyHandler.getInstance().setWriteArea(writeArea);
		
		add(writeArea, BorderLayout.SOUTH);

	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		// TODO: 3/1/2023  
	}
	
	//Updates the displayed messages by adding the last one
	@Override
	public void update(Observable o, Object arg) {
		//Empty the display area if this is the first message
		if(displayArea.getText().equals(noChatYet)) {
			displayArea.setText("");
		}
		ArrayList<Message> m = ChatLog.getInstance().getMessages();
		displayArea.append(m.get(m.size() - 1).toString());
		//repaint();
	}
	
	JTextArea getDisplayArea() {
		return displayArea;
	}
	
	JTextArea getWriteArea() {
		return writeArea;
	}
}
