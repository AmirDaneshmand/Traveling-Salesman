import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class random_number implements ActionListener {

    public JLabel DiceLbl;
    public JButton DiceBtn;
    private int Dice;
    JLabel mainDicelbl;
    Random random;
    Toolkit toolkit = Toolkit.getDefaultToolkit();

    public ImageIcon Dice1 = new ImageIcon("Dice1.png");
    public ImageIcon Dice2 = new ImageIcon("Dice2.png");
    public ImageIcon Dice3 = new ImageIcon("Dice3.png");
    public ImageIcon Dice4 = new ImageIcon("Dice4.png");
    public ImageIcon Dice5 = new ImageIcon("Dice5.png");
    public ImageIcon Dice6 = new ImageIcon("Dice6.png");






    public random_number(){

        DiceBtn = new JButton(Dice6);
        DiceBtn.addActionListener(this);

         Dice = getDice();
    }

    private void makeDiceNumber() {
        random = new Random();
        Dice = random.nextInt(0,6);
        switch (Dice){
            case 1:
                DiceBtn.setIcon((Icon) Dice1);
                break;
            case 2:
                DiceBtn.setIcon((Icon) Dice2);
                break;
            case 3:
                DiceBtn.setIcon((Icon) Dice3);
                break;
            case 4:
                DiceBtn.setIcon((Icon) Dice4);
                break;
            case 5:
                DiceBtn.setIcon((Icon) Dice5);
                break;
            case 6:
                DiceBtn.setIcon((Icon) Dice6);
                break;

        }
    }

    public int getDice() {

        return Dice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(DiceBtn)){
            makeDiceNumber();
        }
    }
}
