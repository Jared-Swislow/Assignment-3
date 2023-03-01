package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**Maintains a log of messages sent - updates Chat when given a new message
 * */
public class ChatLog extends Observable {
	private static ChatLog chatLog;
	private List<Message> messages;
	
	private ChatLog() {
		messages = new ArrayList<Message>();
	}
	
	public static ChatLog getChatLog() {
		if(chatLog == null) {
			chatLog = new ChatLog();
		}
		return chatLog;
	}
	
	void addMessage(Message m) {
		messages.add(m);
		setChanged();
		notifyObservers();
	}
	
	public ArrayList<Message> getMessages() {
		return new ArrayList<Message>(messages);
	}
}
