package Controller;
import javax.swing.*;

public class Alert{
    private static Alert alerts;

    public static void getAlerts(){
		JFrame frame = new JFrame("Main Window");
      
    	JOptionPane.showMessageDialog(frame, "Congratulations, you guessed the right person!","YOU WON GUESS WHO!", JOptionPane.PLAIN_MESSAGE);
		
    	frame.setSize(350,350);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
	}
    
}
