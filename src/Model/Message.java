package Model;

/**Stores message data
 * */
public class Message {
	String message;
	boolean fromMe;
	
	public Message(String msg, boolean fromMe) {
		this.message = msg;
		this.fromMe = fromMe;
	}
	
	public String toString() {
		return (fromMe ? "Me" : "Other") + ": " + message;
	}
}
