package Controller;
import View.GuessWho;
import javax.swing.*;

public class Alert{
	GuessWho window = GuessWho.getGuessWho();
	private static Alert alerts;

    public static Alert getAlerts(){
		if(alerts == null){
			alerts = new Alert();
		}
		return alerts;

	}

	public void winMessage(){
		JOptionPane.showMessageDialog(window, "Congratulations, you guessed the right person!",
				"YOU WON GUESS WHO!", JOptionPane.PLAIN_MESSAGE);
	}

    
}
