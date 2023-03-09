package Controller;

import View.Person;
import View.GuessWho;
import Model.ChatConnection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**Handles controls from user
 * */
public class ControlHandler implements ActionListener {
	private static ControlHandler controls;
	// Alert alert = Alert.getAlerts();

	private ControlHandler(){}

	public static ControlHandler getControls(){
		if(controls == null){
			controls = new ControlHandler();
		}
		return controls;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		GuessWho window = GuessWho.getGuessWho();
		Person p1 = (Person) e.getSource();
		if(!p1.isEliminated()){
			String[] options = {"Guess", "Eliminate"};
			int result = JOptionPane.showOptionDialog(window, "Guess or Eliminate this person", "Person Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			if(result == JOptionPane.YES_OPTION) {
				if(p1.isCorrect()){
					// If guess was correct display you win message
					JOptionPane.showMessageDialog(window, "Congratulations, you guessed the right person!",
				"YOU WON GUESS WHO!", JOptionPane.PLAIN_MESSAGE);
					// Send the lost message to the other player
					ChatConnection.getInstance().send("You Lost Guess Who.");
				} else {
					JOptionPane.showMessageDialog(window, "Wrong guess",
							"Nope", JOptionPane.PLAIN_MESSAGE);
					p1.setEliminatedTrue();
				}
			}
			else{
				p1.setEliminatedTrue();
			}
		}
	}
}
