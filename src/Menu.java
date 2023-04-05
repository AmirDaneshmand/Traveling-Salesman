import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Menu extends JFrame implements ActionListener, MouseListener {
        private JPanel centerPnl,topPnl,botPnl, secondCenterPnl;

        private JButton startGameBtn, twoPlayerBtn,onePlayerBtn;
        private JButton bakcBtn,exitBtn;
        private Font CormorantFont = new Font("Cormorant",Font.ITALIC,12);
        private Font AlegreyaFont = new Font("Alegreya",Font.BOLD,34);
        public Icon exitIcn = new ImageIcon("close-icon-11.png");

        private boolean secondMenuShow = true;

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

           // initSecondMenu();
            //secondCenterPnl.setVisible(secondMenuShow);
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



            startGameBtn = new JButton("New Game");
            startGameBtn.setBounds(800,150,430,60);
            startGameBtn.setFont(AlegreyaFont);
            startGameBtn.setBackground(new Color(0xBDB4AC56, true));
            startGameBtn.setForeground(new Color(219, 252, 3));
            startGameBtn.setBorder(null);
            startGameBtn.setBorderPainted(false);
            startGameBtn.setSelected(false);
            startGameBtn.addActionListener(this);
            startGameBtn.addMouseListener(this);



            exitBtn = new JButton("Exit");
            exitBtn.setBounds(800,300,430,60);
            exitBtn.setFont(AlegreyaFont);
            exitBtn.setForeground(new Color(219, 252, 3));
            exitBtn.setBackground(new Color(0xBDB4AC56, true));
            exitBtn.setBorder(null);
            exitBtn.setBorderPainted(false);
            exitBtn.setSelected(false);
            exitBtn.addActionListener(this);
            exitBtn.addMouseListener(this);



            centerPnl.add(StartMenuPng1);
            centerPnl.add(startGameBtn);
            centerPnl.add(exitBtn);

            add(centerPnl,BorderLayout.CENTER);


        }

        private void initSecondMenu(){
            secondCenterPnl = new JPanel(null);


            twoPlayerBtn = new JButton("two Players");
            twoPlayerBtn.setFont(AlegreyaFont);
            twoPlayerBtn.setBackground(new Color(0xBDB4AC56, true));
            twoPlayerBtn.setForeground(new Color(219, 252, 3));
            twoPlayerBtn.setBorder(null);
            twoPlayerBtn.setBorderPainted(false);
            twoPlayerBtn.setBounds(800,150,430,60);
            twoPlayerBtn.setSelected(false);
            twoPlayerBtn.addActionListener(this);
            twoPlayerBtn.addMouseListener(this);




            onePlayerBtn = new JButton("one Player");
            onePlayerBtn.setFont(AlegreyaFont);
            onePlayerBtn.setBackground(new Color(0xBDB4AC56, true));
            onePlayerBtn.setForeground(new Color(219, 252, 3));
            onePlayerBtn.setBorder(null);
            onePlayerBtn.setBorderPainted(false);
            onePlayerBtn.setBounds(800,250,430,60);
            onePlayerBtn.setSelected(false);
            onePlayerBtn.addActionListener(this);
            onePlayerBtn.addMouseListener(this);




            bakcBtn = new JButton("Back");
            bakcBtn.setFont(AlegreyaFont);
            bakcBtn.setBackground(new Color(0xBDB4AC56, true));
            bakcBtn.setForeground(new Color(219, 252, 3));
            bakcBtn.setBorder(null);
            bakcBtn.setBorderPainted(false);
            bakcBtn.setBounds(800,350,430,60);
            bakcBtn.setSelected(false);
            bakcBtn.addActionListener(this);
            bakcBtn.addMouseListener(this);

            StartMenuPng1.setBounds(0,0,1270,790);
            secondCenterPnl.add(StartMenuPng1);
            secondCenterPnl.add(bakcBtn);
            secondCenterPnl.add(onePlayerBtn);
            secondCenterPnl.add(twoPlayerBtn);



            add(secondCenterPnl,BorderLayout.CENTER);
        }



        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(startGameBtn)){
                if(secondMenuShow){
                    initSecondMenu();
                    secondMenuShow = false;
                }else{
                    secondCenterPnl.setVisible(true);
                }
                centerPnl.setVisible(false);
                secondCenterPnl.add(StartMenuPng1);

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

                secondCenterPnl.setVisible(false);
                centerPnl.setVisible(true);
                centerPnl.add(StartMenuPng1);

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


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource().equals(twoPlayerBtn)){
            twoPlayerBtn.setForeground(new Color(122, 1, 17));
            twoPlayerBtn.setBackground(new Color(0x964C8379, true));
        }
        if(e.getSource().equals(onePlayerBtn)){
            onePlayerBtn.setForeground(new Color(215, 105, 155));
            onePlayerBtn.setBackground(new Color(0x964C8379, true));

        }
        if(e.getSource().equals(bakcBtn)){
            bakcBtn.setForeground(new Color(75, 201, 57));
            bakcBtn.setBackground(new Color(0x964C8379, true));

        }
        if(e.getSource().equals(startGameBtn)){
            startGameBtn.setForeground(new Color(217, 111, 8));
            startGameBtn.setBackground(new Color(0x964C8379, true));

        }
        if(e.getSource().equals(exitBtn)){
            exitBtn.setForeground(new Color(4, 207, 222));
            exitBtn.setBackground(new Color(0x964C8379, true));

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource().equals(twoPlayerBtn)){
            twoPlayerBtn.setForeground(new Color(220,250,4));
            twoPlayerBtn.setBackground(new Color(0xBDB4AC56, true));

        }
        if(e.getSource().equals(onePlayerBtn)){
            onePlayerBtn.setForeground(new Color(220,250,4));
            onePlayerBtn.setBackground(new Color(0xBDB4AC56, true));

        }
        if(e.getSource().equals(bakcBtn)){
            bakcBtn.setForeground(new Color(220,250,4));
            bakcBtn.setBackground(new Color(0xBDB4AC56, true));

        }
        if(e.getSource().equals(startGameBtn)){
            startGameBtn.setForeground(new Color(220,250,4));
            startGameBtn.setBackground(new Color(0xBDB4AC56, true));

        }
        if(e.getSource().equals(exitBtn)){
            exitBtn.setForeground(new Color(220,250,4));
            exitBtn.setBackground(new Color(0xBDB4AC56, true));

        }
    }
}




