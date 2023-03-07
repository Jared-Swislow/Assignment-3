
package View;
import javax.swing.*;
import java.util.*;
import javax.imageio.*;
import java.awt.*;

public class Person extends JButton {
    private boolean correct;
    private boolean eliminated;
    private Image img;

    public Person(String imagePath){
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResource("resources/"+imagePath)));
            Image newimg = img.getScaledInstance( 150, 150,  java.awt.Image.SCALE_SMOOTH ) ;

            setIcon(new ImageIcon(newimg));
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
}
