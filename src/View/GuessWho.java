package View;

import javax.swing.*;
import java.awt.*;

public class GuessWho extends JFrame {

    public static void main(String[] args) {
        GuessWho g = new GuessWho();
        g.setSize(800, 600);
        g.setDefaultCloseOperation(EXIT_ON_CLOSE);
        g.setVisible(true);
    }
    
    GuessWho() {
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        
        Board board = new Board();
        add(board, BorderLayout.CENTER);
        
        Chat chat = new Chat();
        add(chat, BorderLayout.SOUTH);
        
    }
}
