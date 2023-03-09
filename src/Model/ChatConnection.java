package Model;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;

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
	public int connectToOtherUser(String serverIP) {
		Socket s;
		try {
			if (isServer) {
				ServerSocket ss = new ServerSocket(6666);
				s = ss.accept();
			} else {
				if(!serverIP.equals("")) {
					s = new Socket(serverIP, 6666);
				} else {
					System.err.println("connectToOtherUser() called on a client without server IP address");
					return -1;
				}
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
