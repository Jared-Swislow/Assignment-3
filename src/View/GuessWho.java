package View;

import Model.ChatConnection;
import Model.ChatLog;
import Model.Message;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**Main file for Assignment 3
 * */
public class GuessWho extends JFrame{

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
        chat.setBorder(new EmptyBorder(5, 5, 5, 5));
        JScrollPane displayWithScroll = new JScrollPane (chat.getDisplayArea(),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane writeWithScroll = new JScrollPane (chat.getWriteArea(),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        ChatLog chatlog = ChatLog.getChatLog();
        chatlog.addObserver(chat);
        
        add(chat, BorderLayout.SOUTH);
        chat.add(displayWithScroll, BorderLayout.NORTH);
        chat.add(writeWithScroll, BorderLayout.SOUTH);
        
        Thread chatConnectionThread = new Thread(ChatConnection.getInstance());
        chatConnectionThread.start();
    }
}
