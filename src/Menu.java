import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




    public class Menu extends JFrame implements ActionListener {
        private JPanel centerPnl,topPnl,botPnl,secondCentrelPnl;
        private JButton startGameBtn, twoPlayerBtn,onePlayerBtn;
        private JButton bakcBtn,exitBtn;
        private Font CormorantFont = new Font("Cormorant",Font.ITALIC,12);
        private Font AlegreyaFont = new Font("Alegreya",Font.BOLD,34);
        public Icon exitIcn = new ImageIcon("close-icon-11.png");


        public JLabel StartMenuPng1 = new JLabel(new ImageIcon("StartMenu.png"));
        public JLabel StartMenuPng2 = new JLabel(new ImageIcon("StartMenu1.png"));
        public ImageIcon StartMenuPng11 = new ImageIcon("StartMenu.png");
        public ImageIcon StartMenuPng21 = new ImageIcon("StartMenu1.png");

        private Menu me;
        private Listener listener;


        public Menu(){


            setTitle("Traveling Salesman");
            setSize(1280,800);
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            setLayout(new BorderLayout());
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    int a = JOptionPane.showConfirmDialog(me,
                            "Are you sure??"
                            , "Exit"
                            ,JOptionPane.YES_NO_OPTION
                            ,JOptionPane.QUESTION_MESSAGE,
                            exitIcn
                    );
                    if(a==JOptionPane.YES_OPTION){
                        setDefaultCloseOperation(EXIT_ON_CLOSE);
                    }
                }
            });


            initCenterPanel();
            initTopPanel();
            initBotPnl();


            setResizable(false);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        private void initBotPnl() {
            botPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel uni = new JLabel("Ferdowsi University");
            uni.setForeground(Color.gray);
            botPnl.add(uni);
            add(botPnl,BorderLayout.PAGE_END);

        }

        private void initTopPanel() {
            topPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel OwnerLbl = new JLabel("AmirReza Daneshmand");
            OwnerLbl.setFont(CormorantFont);
            topPnl.add(OwnerLbl);
            add(topPnl,BorderLayout.PAGE_START);
        }

        private void initCenterPanel() {
            centerPnl = new JPanel(null);



            StartMenuPng1.setBounds(0,0,1270,790);
            centerPnl.add(StartMenuPng1);



            startGameBtn = new JButton("New Game");
            startGameBtn.setBounds(800,150,430,60);
            startGameBtn.setFont(AlegreyaFont);
            centerPnl.add(startGameBtn);
            startGameBtn.setFocusable(false);
            startGameBtn.addActionListener(this);

            exitBtn = new JButton("Exit");
            exitBtn.setBounds(800,300,430,60);
            exitBtn.setFont(AlegreyaFont);
            centerPnl.add(exitBtn);
            exitBtn.setFocusable(false);
            exitBtn.addActionListener(this);



            add(centerPnl,BorderLayout.CENTER);


        }

        private void initSecondMenu(){
            secondCentrelPnl = new JPanel(null);


            twoPlayerBtn = new JButton("two Players");
            twoPlayerBtn.setBounds(800,150,430,60);
            twoPlayerBtn.setFont(AlegreyaFont);
            twoPlayerBtn.addActionListener(this);
            twoPlayerBtn.setFocusable(false);


            onePlayerBtn = new JButton("one Player");
            onePlayerBtn.setBounds(800,250,430,60);
            onePlayerBtn.setFont(AlegreyaFont);
            onePlayerBtn.addActionListener(this);
            onePlayerBtn.setFocusable(false);


            bakcBtn = new JButton("Back");
            bakcBtn.setBounds(800,350,430,60);
            bakcBtn.setFont(AlegreyaFont);
            bakcBtn.addActionListener(this);
            bakcBtn.setFocusable(false);

            StartMenuPng1.setBounds(0,0,1270,790);
            secondCentrelPnl.add(StartMenuPng1);
            secondCentrelPnl.add(bakcBtn);
            secondCentrelPnl.add(onePlayerBtn);
            secondCentrelPnl.add(twoPlayerBtn);
            secondCentrelPnl.setFocusable(false);

            add(secondCentrelPnl,BorderLayout.CENTER);
        }


        public void setListener(Listener listener) {
            this.listener = listener;
        }

        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(startGameBtn)){
                centerPnl.setVisible(false);
                initSecondMenu();

            }
            if(e.getSource().equals(exitBtn)){


                       int a= JOptionPane.showConfirmDialog(me,
                                "Are you sure??"
                                , "Exit"
                                ,JOptionPane.YES_NO_OPTION
                                ,JOptionPane.QUESTION_MESSAGE
                        );
                        if(a==JOptionPane.YES_OPTION){
                            System.exit(0);
                        }
                    }




            if(e.getSource().equals(bakcBtn)){

                secondCentrelPnl.setVisible(false);
                initCenterPanel();

            }

            if(e.getSource().equals(onePlayerBtn)) {
                GameBoard gameBoard = new GameBoard();
                Game game = new Game(gameBoard);
                setVisible(false);
                game.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {

                        setVisible(true);
                    }
                });
            }
            if(e.getSource().equals(twoPlayerBtn)) {
                GameBoard gameBoard = new GameBoard();
                Game game = new Game(gameBoard);
                setVisible(false);
                game.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {

                        setVisible(true);
                    }
                });
            }
        }


    }




