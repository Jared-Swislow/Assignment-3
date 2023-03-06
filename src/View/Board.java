package View;

import javax.swing.*;
import java.awt.*;

/**Displays the board
 * */
public class Board extends JPanel {
	Board() {
		setBackground(Color.PINK);
		GridLayout layout = new GridLayout(3, 8);
		setLayout(layout);
		for (int i = 0; i < 24; i++){
			add(new JButton());
		}
	}
}
