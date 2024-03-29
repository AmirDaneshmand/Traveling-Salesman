import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Game extends JFrame implements ActionListener{
    GameBoard board;

    private Random random;
    private Game me;
    private int cellSize;
    private int topMargin,leftMargin;
    public Image castleIcn = new ImageIcon("castle.png").getImage();
    public Image marketIcn = new ImageIcon("market.png").getImage();
    public Image unknownIcn  = new ImageIcon("unknown.png").getImage();


    public Image treasureIcn = new ImageIcon("treasure.png").getImage();


    public int[][] treasureLoc = new int[8][2];
    int[] usedTreasure = new int[8];
    int usedTreasureNumber;
    /*
    1 = angoshtar
    2 = shamshir
    3 = livan
    4 = jamm
    5 = kaman
    6 = separ
    7 = kid
    8 = tomar
     */
    public int[][] MarketLocVar = new int[5][2];


    public int[][] ValuableObjectsLoc = new int[13][2];
    public int[] usedValuableObjects = new int[13];
    int usedValuableObjectsNumber;



    final int maxUsedNumberInt = 35;
    public  int[][] UsedNumberInt = new int[maxUsedNumberInt][2];
    int UsedNumberIntArrey = 0;
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
        initObjectLoc();



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

    private void initObjectLoc() {
        random = new Random();

        for (int i = 1; i < maxUsedNumberInt; i++) {
            for (int j = 1; j < 2; j++) {
                UsedNumberInt[i][j] = -1;
            }
        }

        UsedNumberInt[UsedNumberIntArrey][0] = 5;
        UsedNumberInt[UsedNumberIntArrey][1] = 5;
        UsedNumberIntArrey++;

        initMakeMarket();

        initMakeTreasure();

        initMakeValuableObjects();






        /*
        --------------------------------------------------------------
        */




        for (int i = 0; i < UsedNumberIntArrey; i++) {
            System.out.println(UsedNumberInt[i][0]);
            System.out.println(UsedNumberInt[i][1]);
            System.out.println("UsedNumberInt[i][1]");


        }    }

    private void initMakeValuableObjects() {

        for (int i = 0; i < 13; i++) {
            ValuableObjectsLoc[i][0] = -1;
            ValuableObjectsLoc[i][1] = -1;
        }

        usedValuableObjectsNumber = 0;

        for (int i = 0; i < 13; i++) {
            usedValuableObjects[i] = -1;
        }

        //random select for Valuable Objects

        for (int j = 0; j <13; j++) {

            while (true) {
                boolean outOfLoopTreasure = true;
                int SelectValuableObjects = random.nextInt(0, 13);
                for (int i = 0; i < 13; i++) {
                    if (SelectValuableObjects != usedValuableObjects[i]) {
                        continue;
                    } else {
                        outOfLoopTreasure = false;
                        break;
                    }
                }

                if (outOfLoopTreasure) {
                    usedValuableObjects[usedValuableObjectsNumber] = SelectValuableObjects;
                    usedValuableObjectsNumber++;
                    break;
                }

            }

        }

        //random insert for Valuable Objects
        while (true){
            boolean OutOfLoop = true;
            ValuableObjectsLoc[usedValuableObjects[0]][0] = random.nextInt(0,6);
            ValuableObjectsLoc[usedValuableObjects[0]][1] = random.nextInt(0,6);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( ValuableObjectsLoc[usedValuableObjects[0]][0] != UsedNumberInt[i][0]
                        || ValuableObjectsLoc[usedValuableObjects[0]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = ValuableObjectsLoc[usedValuableObjects[0]];
                UsedNumberIntArrey++;

                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            ValuableObjectsLoc[usedValuableObjects[1]][0] = random.nextInt(0,6);
            ValuableObjectsLoc[usedValuableObjects[1]][1] = random.nextInt(0,6);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( ValuableObjectsLoc[usedValuableObjects[1]][0] != UsedNumberInt[i][0]
                        || ValuableObjectsLoc[usedValuableObjects[1]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = ValuableObjectsLoc[usedValuableObjects[1]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            ValuableObjectsLoc[usedValuableObjects[2]][0] = random.nextInt(7,11);
            ValuableObjectsLoc[usedValuableObjects[2]][1] = random.nextInt(0,6);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( ValuableObjectsLoc[usedValuableObjects[2]][0] != UsedNumberInt[i][0]
                        || ValuableObjectsLoc[usedValuableObjects[2]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = ValuableObjectsLoc[usedValuableObjects[2]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            ValuableObjectsLoc[usedValuableObjects[3]][0] = random.nextInt(7,11);
            ValuableObjectsLoc[usedValuableObjects[3]][1] = random.nextInt(2,6);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( ValuableObjectsLoc[usedValuableObjects[3]][0] != UsedNumberInt[i][0]
                        || ValuableObjectsLoc[usedValuableObjects[3]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = ValuableObjectsLoc[usedValuableObjects[3]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            ValuableObjectsLoc[usedValuableObjects[4]][0] = random.nextInt(0,6);
            ValuableObjectsLoc[usedValuableObjects[4]][1] = random.nextInt(7,11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( ValuableObjectsLoc[usedValuableObjects[4]][0] != UsedNumberInt[i][0]
                        || ValuableObjectsLoc[usedValuableObjects[4]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = ValuableObjectsLoc[usedValuableObjects[4]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            ValuableObjectsLoc[usedValuableObjects[5]][0] = random.nextInt(0,6);
            ValuableObjectsLoc[usedValuableObjects[5]][1] = random.nextInt(7,11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( ValuableObjectsLoc[usedValuableObjects[5]][0] != UsedNumberInt[i][0]
                        || ValuableObjectsLoc[usedValuableObjects[5]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = ValuableObjectsLoc[usedValuableObjects[5]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            ValuableObjectsLoc[usedValuableObjects[6]][0] = random.nextInt(7,11);
            ValuableObjectsLoc[usedValuableObjects[6]][1] = random.nextInt(7,11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( ValuableObjectsLoc[usedValuableObjects[6]][0] != UsedNumberInt[i][0]
                        || ValuableObjectsLoc[usedValuableObjects[6]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = ValuableObjectsLoc[usedValuableObjects[6]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            ValuableObjectsLoc[usedValuableObjects[7]][0] = random.nextInt(7,11);
            ValuableObjectsLoc[usedValuableObjects[7]][1] = random.nextInt(7,11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( ValuableObjectsLoc[usedValuableObjects[7]][0] != UsedNumberInt[i][0]
                        || ValuableObjectsLoc[usedValuableObjects[7]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = ValuableObjectsLoc[usedValuableObjects[7]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            ValuableObjectsLoc[usedValuableObjects[8]][0] = random.nextInt(0,11);
            ValuableObjectsLoc[usedValuableObjects[8]][1] = random.nextInt(0,11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( ValuableObjectsLoc[usedValuableObjects[8]][0] != UsedNumberInt[i][0]
                        || ValuableObjectsLoc[usedValuableObjects[8]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = ValuableObjectsLoc[usedValuableObjects[8]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            ValuableObjectsLoc[usedValuableObjects[9]][0] = random.nextInt(0,11);
            ValuableObjectsLoc[usedValuableObjects[9]][1] = random.nextInt(0,11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( ValuableObjectsLoc[usedValuableObjects[9]][0] != UsedNumberInt[i][0]
                        || ValuableObjectsLoc[usedValuableObjects[9]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = ValuableObjectsLoc[usedValuableObjects[9]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            ValuableObjectsLoc[usedValuableObjects[10]][0] = random.nextInt(0,11);
            ValuableObjectsLoc[usedValuableObjects[10]][1] = random.nextInt(0,11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( ValuableObjectsLoc[usedValuableObjects[10]][0] != UsedNumberInt[i][0]
                        || ValuableObjectsLoc[usedValuableObjects[10]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = ValuableObjectsLoc[usedValuableObjects[10]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            ValuableObjectsLoc[usedValuableObjects[11]][0] = random.nextInt(0,11);
            ValuableObjectsLoc[usedValuableObjects[11]][1] = random.nextInt(0,11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( ValuableObjectsLoc[usedValuableObjects[11]][0] != UsedNumberInt[i][0]
                        || ValuableObjectsLoc[usedValuableObjects[11]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = ValuableObjectsLoc[usedValuableObjects[11]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            ValuableObjectsLoc[usedValuableObjects[12]][0] = random.nextInt(0,11);
            ValuableObjectsLoc[usedValuableObjects[12]][1] = random.nextInt(0,11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( ValuableObjectsLoc[usedValuableObjects[12]][0] != UsedNumberInt[i][0]
                        || ValuableObjectsLoc[usedValuableObjects[12]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = ValuableObjectsLoc[usedValuableObjects[12]];
                UsedNumberIntArrey++;
                break;
            }
        }


    }

    private void initMakeTreasure() {

        for (int i = 0; i < 8; i++) {
            treasureLoc[i][0] = -1;
            treasureLoc[i][1] = -1;
        }


        usedTreasureNumber = 0;

        for (int i = 0; i < 8; i++) {
            usedTreasure[i] = -1;
        }
        //random select for treasure

        for (int j = 0; j <8; j++) {

            while (true) {
                boolean outOfLoopTreasure = true;
                int SelectTreasure = random.nextInt(0, 8);
                for (int i = 0; i < 8; i++) {
                    if (SelectTreasure != usedTreasure[i]) {
                        continue;
                    } else {
                        outOfLoopTreasure = false;
                        break;
                    }
                }
                System.out.println(outOfLoopTreasure);
                if (outOfLoopTreasure) {
                    usedTreasure[usedTreasureNumber] = SelectTreasure;
                    usedTreasureNumber++;
                    break;
                }

            }

        }



        //random insert for random treasure
        while (true){
            boolean OutOfLoop = true;
            treasureLoc[usedTreasure[0]][0] = random.nextInt(0,6);
            treasureLoc[usedTreasure[0]][1] = random.nextInt(0,6);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( treasureLoc[usedTreasure[0]][0] != UsedNumberInt[i][0]
                        || treasureLoc[usedTreasure[0]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = treasureLoc[usedTreasure[0]];
                UsedNumberIntArrey++;

                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            treasureLoc[usedTreasure[1]][0] = random.nextInt(0,6);
            treasureLoc[usedTreasure[1]][1] = random.nextInt(0,6);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( treasureLoc[usedTreasure[1]][0] != UsedNumberInt[i][0]
                        || treasureLoc[usedTreasure[1]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = treasureLoc[usedTreasure[1]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            treasureLoc[usedTreasure[2]][0] = random.nextInt(7,11);
            treasureLoc[usedTreasure[2]][1] = random.nextInt(0,6);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( treasureLoc[usedTreasure[2]][0] != UsedNumberInt[i][0]
                        || treasureLoc[usedTreasure[2]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = treasureLoc[usedTreasure[2]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            treasureLoc[usedTreasure[3]][0] = random.nextInt(7,11);
            treasureLoc[usedTreasure[3]][1] = random.nextInt(2,6);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( treasureLoc[usedTreasure[3]][0] != UsedNumberInt[i][0]
                        || treasureLoc[usedTreasure[3]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = treasureLoc[usedTreasure[3]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            treasureLoc[usedTreasure[4]][0] = random.nextInt(0,6);
            treasureLoc[usedTreasure[4]][1] = random.nextInt(7,11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( treasureLoc[usedTreasure[4]][0] != UsedNumberInt[i][0]
                        || treasureLoc[usedTreasure[4]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = treasureLoc[usedTreasure[4]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            treasureLoc[usedTreasure[5]][0] = random.nextInt(0,6);
            treasureLoc[usedTreasure[5]][1] = random.nextInt(7,11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( treasureLoc[usedTreasure[5]][0] != UsedNumberInt[i][0]
                        || treasureLoc[usedTreasure[5]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = treasureLoc[usedTreasure[5]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            treasureLoc[usedTreasure[6]][0] = random.nextInt(7,11);
            treasureLoc[usedTreasure[6]][1] = random.nextInt(7,11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( treasureLoc[usedTreasure[6]][0] != UsedNumberInt[i][0]
                        || treasureLoc[usedTreasure[6]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = treasureLoc[usedTreasure[6]];
                UsedNumberIntArrey++;
                break;
            }
        }

        while (true){
            boolean OutOfLoop = true;
            treasureLoc[usedTreasure[7]][0] = random.nextInt(7,11);
            treasureLoc[usedTreasure[7]][1] = random.nextInt(7,11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if ( treasureLoc[usedTreasure[7]][0] != UsedNumberInt[i][0]
                        || treasureLoc[usedTreasure[7]][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = treasureLoc[usedTreasure[7]];
                UsedNumberIntArrey++;
                break;
            }
        }
    }

    private void initMakeMarket() {
        while (true) {
            boolean OutOfLoop = true;

            MarketLocVar[0][0] = random.nextInt(0, 6);
            MarketLocVar[0][1] = random.nextInt(0, 6);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if (MarketLocVar[0][0] != UsedNumberInt[i][0]
                        || MarketLocVar[0][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = MarketLocVar[0];
                UsedNumberIntArrey++;
                break;
            }

        }

        while (true) {
            boolean OutOfLoop = true;

            MarketLocVar[1][0] = random.nextInt(0, 6);
            MarketLocVar[1][1] = random.nextInt(0, 6);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if (MarketLocVar[1][0] != UsedNumberInt[i][0]
                        || MarketLocVar[1][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = MarketLocVar[1];
                UsedNumberIntArrey++;

                break;
            }

        }

        while (true) {
            boolean OutOfLoop = true;

            MarketLocVar[2][0] = random.nextInt(7, 11);
            MarketLocVar[2][1] = random.nextInt(0, 6);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if (MarketLocVar[2][0] != UsedNumberInt[i][0]
                        || MarketLocVar[2][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = MarketLocVar[2];
                UsedNumberIntArrey++;

                break;
            }

        }

        while (true) {
            boolean OutOfLoop = true;

            MarketLocVar[3][0] = random.nextInt(0, 6);
            MarketLocVar[3][1] = random.nextInt(7, 11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if (MarketLocVar[3][0] != UsedNumberInt[i][0]
                        || MarketLocVar[3][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = MarketLocVar[3];
                UsedNumberIntArrey++;

                break;
            }

        }

        while (true) {
            boolean OutOfLoop = true;

            MarketLocVar[4][0] = random.nextInt(7, 11);
            MarketLocVar[4][1] = random.nextInt(7, 11);
            for (int i = 0; i < maxUsedNumberInt; i++) {
                if (MarketLocVar[4][0] != UsedNumberInt[i][0]
                        || MarketLocVar[4][1] != UsedNumberInt[i][1]) {
                    continue;
                } else {
                    OutOfLoop = false;
                    break;
                }
            }
            if (OutOfLoop) {
                UsedNumberInt[UsedNumberIntArrey] = MarketLocVar[4];
                UsedNumberIntArrey++;

                break;
            }

        }
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

        diceRand.DiceBtn.setBounds(20,610,100,100);
        add(diceRand.DiceBtn);



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



        g2.setStroke(new BasicStroke(3));
        for (int i = 0;i<11;i++){
            for(int j = 0;j<11;j++){
                g2.setColor(new Color(
                         random.nextInt(0,255)
                        ,random.nextInt(0,255)
                        ,random.nextInt(0,255)
                        ));
                g2.fillRect(rectangle[i][j].x
                        ,rectangle[i][j].y
                        ,rectangle[i][j].width
                        ,rectangle[i][j].height);
            }
        }
        g2.drawImage(castleIcn,800,380,60,60,null);

        for (int i = 0; i < 5; i++) {
            g2.drawImage(marketIcn,MarketLocVar[i][1]*cellSize+leftMargin
                    , MarketLocVar[i][0]*cellSize+topMargin
                    , cellSize,cellSize,null
            );
        }
        for (int i = 0; i < 8; i++) {
            g2.drawImage(treasureIcn,treasureLoc[i][1]*cellSize+leftMargin
                    , treasureLoc[i][0]*cellSize+topMargin
                    , cellSize,cellSize,null
            );
        }

        for (int i = 0; i < 13; i++) {
            g2.drawImage(unknownIcn,ValuableObjectsLoc[i][1]*cellSize+leftMargin
                    , ValuableObjectsLoc[i][0]*cellSize+topMargin
                    , cellSize,cellSize,null
            );
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

