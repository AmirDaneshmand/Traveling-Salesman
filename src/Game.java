import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game extends JFrame {
    GameBoard board;
    private Game me;
    public Game(GameBoard board){
        this.board = board;
        setTitle("Traveling Salesman");
        setSize(1280,800);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(me,
                        "Are you sure??"
                        , "Exit"
                        ,JOptionPane.YES_NO_OPTION
                        ,JOptionPane.QUESTION_MESSAGE
                );
                if(a==JOptionPane.YES_OPTION){
                    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                }
            }
        });



        setLocationRelativeTo(null);
        setVisible(true);


    }

}
