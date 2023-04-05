import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class random_number {

    Random random;
    Toolkit toolkit = Toolkit.getDefaultToolkit();

    public ImageIcon Dice1 = new ImageIcon("Dice1.png");
    public ImageIcon Dice2 = new ImageIcon("Dice2.png");
    public ImageIcon Dice3 = new ImageIcon("Dice3.png");
    public ImageIcon Dice4 = new ImageIcon("Dice4.png");
    public ImageIcon Dice5 = new ImageIcon("Dice5.png");
    public ImageIcon Dice6 = new ImageIcon("Dice6.png");


    JLabel mainDicelbl;


    private int Dice;
    random_number(){

        random = new Random();
        Dice = 6;
        mainDicelbl = new JLabel(Dice6);
       // Dice = random.nextInt(0,6);
        switch (Dice){
            case 1:
            mainDicelbl.setIcon((Icon) Dice1);
            break;
            case 2:
                mainDicelbl.setIcon((Icon) Dice2);
                break;
            case 3:
                mainDicelbl.setIcon((Icon) Dice3);
                break;
            case 4:
                mainDicelbl.setIcon((Icon) Dice4);
                break;
            case 5:
                mainDicelbl.setIcon((Icon) Dice5);
                break;
            case 6:
                mainDicelbl.setIcon((Icon) Dice6);
                break;

        }
        getDice();
    }

    public int getDice() {

        return Dice;
    }
}
