package Model;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**Establishes and maintains a connection between the chats
 * */
public class ChatConnection implements Runnable {
	private static ChatConnection instance;
	private boolean isServer;
	
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
	
	@Override
	public void run() {
		try {
			//Set up connection
			Socket s;
			if(isServer) {
				ServerSocket ss = new ServerSocket(6666);
				s = ss.accept();
			} else {
				s = new Socket("localhost", 6666);
			}
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			//Main loop
			while(true) {
				String str = din.readUTF();
				System.out.println(str);
				if(str.equals("q")) {
					break;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
