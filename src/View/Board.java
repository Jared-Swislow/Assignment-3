package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**Displays the board
 * */
public class Board extends JPanel {
    public List<JButton> characters = new ArrayList<JButton>();
    Board() {
        setBackground(Color.PINK);
        getCharacters();
        if (characters!=null){
            for (JButton c: characters){
                this.add(c);
            }
        }

    }

    public void getCharacters(){
        JButton button = new JButton();

        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("resources/Alex.bmp")));
            button.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        characters.add(button);

    }

}
