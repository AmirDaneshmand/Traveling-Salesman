import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame implements ActionListener{
    GameBoard board;
    private Game me;
    private int cellSize;
    private int topMargin,leftMargin;
    public Image castleIcn = new ImageIcon("castle.png").getImage();


    public static JButton backBtnGame;
    random_number diceRand = new random_number();

    Image backImg = new ImageIcon("backGround3.png").getImage();
    Image exitImg = new ImageIcon("close-icon-11").getImage();

    public Rectangle[][] rectangle;
    public Game(GameBoard board){
        this.board = board;
        setTitle("Traveling Salesman");
        setSize(1280,800);
        setResizable(false);
        cellSize = 60;
        topMargin = 80;
        leftMargin = 500;

       initTable();
       initPanle();




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


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    private void initPanle() {
        backBtnGame = new JButton();
        backBtnGame.setBackground(Color.gray);
        backBtnGame.setForeground(Color.orange);
        backBtnGame.setFont(new Font("Cormorant",Font.ITALIC,24));
        backBtnGame.setText("Back");
        backBtnGame.setBounds(17,10,95,42);
        add(backBtnGame);
        backBtnGame.addActionListener(this);






    }

    public void initTable() {

        rectangle = new Rectangle[11][11];
        for (int i = 0;i<11;i++){
            for(int j = 0;j<11;j++){
                rectangle[i][j]=new Rectangle(j*cellSize+leftMargin
                        ,i*cellSize+topMargin
                        ,cellSize , cellSize);
            }
        }


    }





    @Override
    public void paint(Graphics g){

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(backImg,0,0,null);
        g2.drawImage(castleIcn,800,380,60,60,null);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.lightGray);
        for (int i = 0;i<11;i++){
            for(int j = 0;j<11;j++){

                g2.drawRect(rectangle[i][j].x,rectangle[i][j].y,rectangle[i][j].width,rectangle[i][j].height);
            }
        }



    }




    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        new Game(gameBoard);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(backBtnGame)){

            int a= JOptionPane.showConfirmDialog(me,
                    "Are you sure??"
                    , "Exit"
                    ,JOptionPane.YES_NO_OPTION
                    ,JOptionPane.QUESTION_MESSAGE
            );
            if(a==JOptionPane.YES_OPTION){
                setVisible(false);
                new Menu();
            }
        }
        }
    }

