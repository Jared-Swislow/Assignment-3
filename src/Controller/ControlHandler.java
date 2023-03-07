package Controller;

import View.Person;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Handles controls from user
 * */
public class ControlHandler implements ActionListener {
	private static ControlHandler controls;
	Alert alert = Alert.getAlerts();

	public static ControlHandler getControls(){
		if(controls == null){
			controls = new ControlHandler();
		}
		return controls;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Person p1 = (Person) e.getSource();
		if(!p1.isEliminated()){
			int result = p1.guessPerson();
			if(result == 0){
				p1.setEliminatedTrue();
			}
			if(result == 1){
				// Check to see if guessed person is tagged as the correct one
				if(p1.isCorrect()){
					// If guess was correct display you win message
					alert.winMessage();

				}
			}
		}





	}
}
