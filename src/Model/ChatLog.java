package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

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
}
