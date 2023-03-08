package Model;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**Establishes and maintains a connection between the users
 * */
public class ChatConnection implements Runnable {
	private static ChatConnection instance;
	private boolean isServer;
	private DataInputStream din;
	private DataOutputStream dout;
	
	private ChatConnection() {
	
	}
	
	public static ChatConnection getInstance() {
		if(instance == null) {
			instance = new ChatConnection();
		}
		return instance;
	}
	
	public void setAsServer() {
		isServer = true;
	}
	
	public void setAsClient() {
		isServer = false;
	}
	
	//Sets up connection to other user
	public int connectToOtherUser() {
		Socket s;
		try {
			if (isServer) {
				ServerSocket ss = new ServerSocket(6666);
				s = ss.accept();
			} else {
				s = new Socket("localhost", 6666);
			}
			dout = new DataOutputStream(s.getOutputStream());
			din = new DataInputStream(s.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
	
	@Override
	public void run() {
		try {
			
			//Main loop
			while(true) {
				String str = din.readUTF();
				//Don't send an empty message
				if(!str.strip().equals("")) {
					ChatLog.getInstance().addMessage(new Message(str, false));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String msg) {
		try {
			dout.writeUTF(msg);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
