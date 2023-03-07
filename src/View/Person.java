package View;

import javax.swing.*;
import java.util.*;
import javax.imageio.*;
import java.awt.*;

public class Person extends JButton {
    private boolean correct;
    private boolean eliminated;
    private Image img;
    private int id;
    GuessWho window = GuessWho.getGuessWho();


    public Person(String imagePath){
        try {
            //img = ImageIO.read(Objects.requireNonNull(getClass().getResource(imagePath)));
            setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.correct = false;
        this.eliminated = false;
    }

    public boolean isEliminated() {
        return eliminated;
    }


    public void setEliminatedTrue() {
        this.eliminated = true;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isCorrect() {
        return this.correct;
    }

    public int guessPerson(){
        String[] options = {"Guess", "Eliminate"};
        int result = JOptionPane.showOptionDialog(window, "Guess or Eliminate this person", "Person Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if(result == JOptionPane.YES_OPTION) {
            //Guess was clicked
            return 1;
        }
        else{
            // Eliminate was clicked
            return 0;
        }
    }


}
