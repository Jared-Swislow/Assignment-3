package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**Displays the board
 * */
public class Board extends JPanel {
    public List<Person> Characters = new ArrayList<Person>();
    Board() {
        setBackground(Color.PINK);
        getCharacters();
        if (Characters!=null){
            for (Person c: Characters){
                c.setSize(150, 150);
                this.add(c);
            }
        }

    }

    public void getCharacters(){
        JButton button = new JButton();
        System.out.println(new File("Characters.txt").getAbsolutePath());
        File CharactersFile = new File(Objects.requireNonNull(getClass().getResource("Characters.txt")).getFile());
        try{
            Scanner Chars = new Scanner (CharactersFile);
            while (Chars.hasNextLine()){
                String data = Chars.nextLine();
                System.out.println(data);
                Person Character = new Person(data);
                Characters.add(Character);

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }




    }

}
