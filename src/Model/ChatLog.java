package Model;

import java.util.ArrayList;
import java.util.List;

public class ChatLog {
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
