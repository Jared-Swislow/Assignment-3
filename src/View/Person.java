package View;

import javax.swing.*;
import java.util.*;
import javax.imageio.*;
import java.awt.*;

public class Person extends JButton {
    private boolean correct;
    private boolean eliminated;
    private Image img;
    private String name;

    /**
     * Prints out the images to the screen so the player can play the game
     * @param imagePath
     */
    public Person(String imagePath) {
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResource("resources/" + imagePath)));
            img = img.getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.correct = false;
        this.eliminated = false;
        this.name = imagePath.split(".bmp")[0];
    }

    /**
     * Eliminates the person if they are clicked
     * @return boolean representing if the character has been eliminated
     */
    public boolean isEliminated() {
        return eliminated;
    }

    public String getName() {
        return this.name;
    }

    public void setEliminatedTrue() {
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResource("resources/yellow.bmp")));
            img = img.getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.eliminated = true;
    }

    /**
     * 
     * Sets the 'correct' boolean if the user chose correctly
     * @param correct
     */
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isCorrect() {
        return this.correct;
    }
}
