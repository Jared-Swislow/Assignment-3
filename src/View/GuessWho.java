package View;

import Model.ChatConnection;
import Model.ChatLog;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Controller.ControlHandler;
import java.awt.*;

/**
 * 
 * @author Jared Swislow
 * @author Liam Hyde
 * @author Anna Rosenberg
 * @author Sophie Martyrossian
 * @author Keila Mohan
 * @author Gavin Stoddard
 */

public class GuessWho extends JFrame {
    public static GuessWho guessFrame;

    /**
     * 
     * @param args
     *             Main method for the GuessWho game
     */
    public static void main(String[] args) {
        GuessWho g = getGuessWho();
        g.setSize(800, 600);
        g.setDefaultCloseOperation(EXIT_ON_CLOSE);
        g.setVisible(true);
    }

    private GuessWho() {
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        Board board = new Board();
        GridLayout grid = new GridLayout(3, 8);
        board.setLayout(grid);
        add(board, BorderLayout.CENTER);

        Chat chat = new Chat();
        chat.setBorder(new EmptyBorder(5, 5, 5, 5));
        JScrollPane displayWithScroll = new JScrollPane(chat.getDisplayArea(),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane writeWithScroll = new JScrollPane(chat.getWriteArea(),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ChatLog chatlog = ChatLog.getInstance();
        chatlog.addObserver(chat);

        add(chat, BorderLayout.SOUTH);
        chat.add(displayWithScroll, BorderLayout.NORTH);
        chat.add(writeWithScroll, BorderLayout.SOUTH);

        // UNCOMMENT THIS TO HAVE ACTUAL CLIENT-SERVER CONNECTION
        // Ask user if they want to be a server or a client
        String[] options = { "Server", "Client" };
        int result = JOptionPane.showOptionDialog(this, "Client or server?", "Client or Server",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        String serverIP = "";
        if (result == JOptionPane.YES_OPTION) {
            // Reach here if the user clicked Server
            ChatConnection.getInstance().setAsServer();
        } else {
            // Reach here if the user didn't click Server
            ChatConnection.getInstance().setAsClient();
            // Prompt user for server IP
            serverIP = JOptionPane.showInputDialog("Enter server's IP address");
            if (serverIP == null) {
                System.out.println("No server IP specified");
                return;
            }
        }

        // Explain how the game works
        final String explanationString = "To play this game, each player receives a random character.\nYou and your opponent must take turns asking each other 'yes' or 'no' questions in order to guess each other's character.\nKnock down characters that you rule out based on your opponent's answer to the question.\nBest of five.";
        JOptionPane.showMessageDialog(this, explanationString, "How to play", JOptionPane.INFORMATION_MESSAGE);

        // Connect to other person
        if (ChatConnection.getInstance().connectToOtherUser(serverIP) != 0) {
            // Reach here if connection didn't work
            JOptionPane.showMessageDialog(this, "Could not connect to other user. Exiting...", "Couldn't connect",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        Thread chatConnectionThread = new Thread(ChatConnection.getInstance());
        chatConnectionThread.start();

        String correctPerson = board.getRandom();
        ChatConnection.getInstance().send(correctPerson + "\n");
    }

    /**
     * 
     * @return new game of GuessWho
     */
    public static GuessWho getGuessWho() {
        if (guessFrame == null) {
            guessFrame = new GuessWho();
        }
        return guessFrame;
    }
}
