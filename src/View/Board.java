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
    JButton button = new JButton();
    public List<JButton> characters = new ArrayList<JButton>();
    Board() {
        setBackground(Color.PINK);

        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("resources/Alex.bmp")));
            button.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        this.add(button);
    }
}
