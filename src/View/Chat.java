package View;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Chat extends JPanel implements Observer {
	Chat() {
		setBackground(Color.BLUE);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 50, 20);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO: 3/1/2023  
	}
}
