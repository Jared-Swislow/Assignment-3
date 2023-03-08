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
    public List<Person> characters = new ArrayList<Person>();
    public ArrayList<String> charStrings = new ArrayList<>();
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
        File charactersFile = new File(Objects.requireNonNull(getClass().getResource("Characters.txt")).getFile());
        try{
            Scanner chars = new Scanner (charactersFile);
            while (chars.hasNextLine()){
                String data = chars.nextLine();
                System.out.println(data);
                Person character = new Person(data);
                characters.add(character);
            chars.close();
            }
            int personsIndex = (int)Math.random() * charStrings.size();
            String personsChar = charStrings.get(personsIndex);
            String[] name = personsChar.split(".bmp");
            String personName = name[0];
            String person = personName.substring(0, 1).toUpperCase() + personName.substring(1);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
