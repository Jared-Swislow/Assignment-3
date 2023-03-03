package Model;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**Establishes and maintains a connection between the chats
 * */
public class ChatConnection implements Runnable {
	@Override
	public void run() {
		try {
			//Set up connection
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			//Main loop
			while(true) {
				String str = din.readUTF();
				if(!str.equals("")) {
					System.out.println(str);
					if(str.equals("q")) {
						break;
					}
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
