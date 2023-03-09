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
                this.add(c);
            }
        }

    }

    public void getCharacters(){
        File charactersFile = new File(System.getProperty("user.dir") + "/src/View/characters.txt");
        ControlHandler controls = ControlHandler.getControls();
        try{
            Scanner chars = new Scanner (charactersFile);
            while (chars.hasNextLine()){
                String data = chars.nextLine();
                Person character = new Person(data);
                character.addActionListener(controls);
                characters.add(character);
            }
            chars.close();
            int personsIndex = (int)Math.random() * charStrings.size();
            String personsChar = charStrings.get(personsIndex);
            String[] name = personsChar.split(".");
            String personName = name[0];
            String person = personName.substring(0, 1).toUpperCase() + personName.substring(1);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
