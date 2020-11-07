import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class View {
    private JFrame frame;
    private Controller controller;
    private JMenuItem mapState, mainMenu;


    public JFrame getFrame() {
        return this.frame;
    }

    public static void main(String[] args) {
        View window = new View();
    }

    public View(){

        controller = new Controller(this);
        frame = new JFrame("Risk");

        frame.setSize(1500, 1500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);



        JMenuBar menu= new JMenuBar();
        frame.setJMenuBar(menu);

        JMenu options = new JMenu("Options");
        menu.add(options);

        JMenuItem rules = new JMenuItem("Rules");
        mapState = new JMenuItem("Map State");
        JMenuItem quit = new JMenuItem("Quit");
        mainMenu = new JMenuItem("Main Menu");
        options.add(rules);
        options.add(mapState);
        options.add(quit);
        rules.addActionListener(controller);
        mapState.addActionListener(controller);
        quit.addActionListener(controller);

        frame.setVisible(true);
        startMenu();
        //mainScreen();
    }

    public void startMenu(){

        mapState.setVisible(false);
        mainMenu.setVisible(false);

        frame.getContentPane().removeAll();

        JPanel startMenu = new JPanel(new BorderLayout());
        frame.add(startMenu);


        ImageIcon logoImage = new ImageIcon(getClass().getResource("res/riskLogo.png"));
        JLabel logo = new JLabel(logoImage);
        logo.setPreferredSize(new Dimension(300, 300));
        startMenu.add(logo, BorderLayout.NORTH);

        JPanel buttons = new JPanel(new GridLayout(1,1));

        JButton start = new JButton("Start");
        start.setFont(new Font("Calibri", Font.PLAIN, 20));
        start.addActionListener(controller);

        JButton rules = new JButton("Rules");
        rules.setFont(new Font("Calibri", Font.PLAIN, 20));
        rules.addActionListener(controller);

        buttons.add(rules);
        buttons.add(start);
        startMenu.add(buttons, BorderLayout.CENTER);

        frame.validate();
        frame.repaint();

    }

    public void createNumOfPlayers(){

        frame.getContentPane().removeAll();
        JPanel numOfPlayers = new JPanel(new BorderLayout());


        frame.getContentPane().add(numOfPlayers);

        ImageIcon logoImage = new ImageIcon(getClass().getResource("res/riskLogo.png"));
        JLabel logo = new JLabel(logoImage);
        logo.setPreferredSize(new Dimension(300, 300));
        numOfPlayers.add(logo, BorderLayout.NORTH);


        JPanel playerButtons = new JPanel(new GridLayout(3,2));

        JButton player2 = new JButton("2 Players");
        player2.setFont(new Font("Calibri", Font.PLAIN, 20));
        player2.addActionListener(controller);

        JButton player3 = new JButton("3 Players");
        player3.setFont(new Font("Calibri", Font.PLAIN, 20));
        player3.addActionListener(controller);

        JButton player4 = new JButton("4 Players");
        player4.setFont(new Font("Calibri", Font.PLAIN, 20));
        player4.addActionListener(controller);

        JButton player5 = new JButton("5 Players");
        player5.setFont(new Font("Calibri", Font.PLAIN, 20));
        player5.addActionListener(controller);

        JButton player6 = new JButton("6 Players");
        player6.setFont(new Font("Calibri", Font.PLAIN, 20));
        player6.addActionListener(controller);

        JButton startGame= new JButton("Start Game");
        startGame.setFont(new Font("Calibri", Font.PLAIN, 20));
        startGame.addActionListener(controller);

        playerButtons.add(player2);
        playerButtons.add(player3);
        playerButtons.add(player4);
        playerButtons.add(player5);
        playerButtons.add(player6);
        playerButtons.add(startGame);
        numOfPlayers.add(playerButtons, BorderLayout.CENTER);

        frame.validate();
        frame.repaint();

    }

    public void mainScreen(){
        frame.getContentPane().removeAll();
        JPanel mainScreen = new JPanel(new BorderLayout());

        frame.getContentPane().add(mainScreen);

        ImageIcon logoImage = new ImageIcon(getClass().getResource("res/riskMap.jpg"));
        JLabel logo = new JLabel(logoImage);
        logo.setPreferredSize(new Dimension(300, 300));
        mainScreen.add(logo, BorderLayout.CENTER);

        JPanel countries = new JPanel(new GridLayout(15,3));

        //Adding country buttons
        JButton EasternAustralia = new JButton("Eastern Australia");
        countries.add(EasternAustralia);

        JButton Indonesia = new JButton("Indonesia");
        countries.add(Indonesia);

        JButton NewGuinea= new JButton("New Guinea");
        countries.add(NewGuinea);

        JButton WesternAustralia = new JButton("Western Australia");
        countries.add(WesternAustralia);

        JButton Afghanistan = new JButton("Afghanistan");
        countries.add(Afghanistan);

        JButton China = new JButton("China");
        countries.add(China);

        JButton India= new JButton("India");
        countries.add(India);

        JButton Irkutsk = new JButton("Irkutsk");
        countries.add(Irkutsk);

        JButton Japan = new JButton("Japan");
        countries.add(Japan);

        JButton Kamchatka = new JButton("Kamchatka");
        countries.add(Kamchatka);

        JButton MiddleEast= new JButton("Middle East");
        countries.add(MiddleEast);

        JButton Mongolia = new JButton("Mongolia");
        countries.add(Mongolia);

        JButton Siam = new JButton("Siam");
        countries.add(Siam);

        JButton Siberia = new JButton("Siberia");
        countries.add(Siberia);

        JButton Ural= new JButton("Ural");
        countries.add(Ural);

        JButton Yakutsk = new JButton("Yakutsk");
        countries.add(Yakutsk);

        JButton Congo = new JButton("Congo");
        countries.add(Congo);

        JButton EastAfrica = new JButton("East Africa");
        countries.add(EastAfrica);

        JButton Egypt= new JButton("Egypt");
        countries.add(Egypt);

        JButton Madagascar = new JButton("Madagascar");
        countries.add(Madagascar);

        JButton NorthAfrica = new JButton("North Africa");
        countries.add(NorthAfrica);

        JButton SouthAfrica = new JButton("South Africa");
        countries.add(SouthAfrica);

        JButton GreatBritain= new JButton("Great Britain");
        countries.add(GreatBritain);

        JButton Iceland = new JButton("Iceland");
        countries.add(Iceland);

        JButton NorthernEurope = new JButton("Northern Europe");
        countries.add(NorthernEurope);

        JButton Scandinavia = new JButton("Scandinavia");
        countries.add(Scandinavia);

        JButton SouthernEurope= new JButton("Southern Europe");
        countries.add(SouthernEurope);

        JButton Ukraine = new JButton("Ukraine");
        countries.add(Ukraine);

        JButton WesternEurope = new JButton("Western Europe");
        countries.add(WesternEurope);

        JButton Argentina = new JButton("Argentina");
        countries.add(Argentina);

        JButton Brazil= new JButton("Brazil");
        countries.add(Brazil);

        JButton Peru = new JButton("Peru");
        countries.add(Peru);

        JButton Venezuela = new JButton("Venezuela");
        countries.add(Venezuela);

        JButton Alaska = new JButton("Alaska");
        countries.add(Alaska);

        JButton Alberta= new JButton("Alberta");
        countries.add(Alberta);

        JButton CentralAmerica = new JButton("Central America");
        countries.add(CentralAmerica);

        JButton EasternUnitedStates = new JButton("EasternUnitedStates");
        countries.add(EasternUnitedStates);

        JButton Greenland = new JButton("Greenland");
        countries.add(Greenland);

        JButton NorthwestTerritories= new JButton("Northwest Territories");
        countries.add(NorthwestTerritories);

        JButton Ontario = new JButton("Ontario");
        countries.add(Ontario);

        JButton Quebec= new JButton("Quebec");
        countries.add(Quebec);

        JButton WesternUnitedStates = new JButton("Western United States");
        countries.add(WesternUnitedStates);

        JButton Attack = new JButton("ATTACK!!");
        countries.add(Attack);

        JButton Fortify = new JButton("FORTIFY!!");
        countries.add(Fortify);

        mainScreen.add(countries, BorderLayout.EAST);


        frame.validate();
        frame.repaint();

    }

    public void showRules() {
        JOptionPane.showMessageDialog(this.frame,
                "1. The winner is the first player to eliminate every opponent by " +
                "capturing all 42 territories on the board.\n"
                + "2. You can only attack a country that is adjacent to a country you control.\n"
                + "3. At the start of each turn you will receive at least 3 armies or the # of territories " +
                "you own divided by 3 (which ever one is higher).\n"
                + "4. You can only attack a country if you own at least 2 armies in the attacking country.\n"
                + "5. When attacking the person who is attacking can choose to roll up to 3 dice.\n"
                + "6. The person defending can roll up to 2 dice but must have at least 2 armies in the " +
                "defending country (if not they can only roll one dice).\n"
                + "7. When you capture a territory, you must move at least as many armies as " +
                "dice you rolled in your last attack.\n" +
                "                                  ", "Rules", JOptionPane.OK_OPTION,
                new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    public void quit() {

        int choice = JOptionPane.showConfirmDialog(null,
                "Are you sure you would like to quit?",
                "Quit",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(getClass().getResource("res/riskLogo.png")));

        if (choice == 0) {
            System.exit(0);
        }
    }

}
