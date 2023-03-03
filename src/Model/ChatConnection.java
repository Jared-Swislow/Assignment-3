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
	private Socket s;
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
	
	public void setAsClient() {
		isServer = false;
	}
	
	//Sets up connection to other user
	public int connectToOtherUser() {
		try {
			if (isServer) {
				ServerSocket ss = new ServerSocket(6666);
				s = ss.accept();
			} else {
				s = new Socket("localhost", 6666);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
	
	@Override
	public void run() {
		try {
			
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
