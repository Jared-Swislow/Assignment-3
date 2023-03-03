package View;

import javax.swing.*;
import java.util.*;
import javax.imageio.*;
import java.awt.*;

public class Person extends JButton {
    private boolean correct = false;
    private boolean eliminated = false;
    private Image img;

    public Person(String imagePath){
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResource(imagePath)));
            setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public boolean isEliminated() {
        return eliminated;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isCorrect() {
        return this.correct;
    }
}
