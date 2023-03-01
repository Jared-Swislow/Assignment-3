package View;

import javax.swing.*;
import java.awt.*;

public class Chat extends JPanel {
	Chat() {
		setBackground(Color.BLUE);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 50, 20);
	}
}
