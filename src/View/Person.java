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

    public Person(String imagePath){
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

    public boolean isEliminated() {
        return eliminated;
    }

    public String getName(){
        return this.name;
    }

    public void setEliminatedTrue() {
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/yellow.jpg")));
            setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.eliminated = true;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isCorrect() {
        return this.correct;
    }
}
