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

    public Person(String imagePath, int id){
        try {
            //img = ImageIO.read(Objects.requireNonNull(getClass().getResource(imagePath)));
            setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.id = id;
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
}
