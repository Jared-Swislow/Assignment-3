package View;

import javax.imageio.ImageIO;
import javax.swing.*;

import Controller.ControlHandler;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**Displays the board
 * */
public class Board extends JPanel {
    public List<Person> characters = new ArrayList<Person>();
    public ArrayList<String> charStrings = new ArrayList<>();
    Board() {
        setBackground(Color.PINK);
        getCharacters();
        if (characters!=null){
            for (Person c: characters){
                c.setSize(150, 150);
                JLabel name = new JLabel(c.getName());
                name.setVerticalAlignment(SwingConstants.BOTTOM);
                c.add(name);
                this.add(c);
            }
        }

    }

    public void getCharacters(){
        File CharactersFile = new File(Objects.requireNonNull(getClass().getResource("Characters.txt")).getFile());
        try{
            Scanner Chars = new Scanner (CharactersFile);
            while (Chars.hasNextLine()){
                String data = Chars.nextLine();
                Person Character = new Person(data);
                characters.add(Character);
            }
            Chars.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
