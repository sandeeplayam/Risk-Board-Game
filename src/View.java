import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Color;


public class View {
    private JFrame frame;
    private Controller controller;
    private JMenuItem mapState, mainMenu;
    public static final Color pink= new Color(255,153,255);
    public static final Color brown = new Color(168,126,40);
    public static final Color yellow = new Color(245,217,76);
    public static final Color green = new Color(84,207,68);
    public static final Color orange = new Color(255,163,43);
    public static final Color blue = new Color(153,153,255);

    public JFrame getFrame() {
        return this.frame;
    }

    public static void main(String[] args) {
        new View();
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

        JPanel buttons = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JButton start = new JButton("Start");
        start.setFont(new Font("Calibri", Font.PLAIN, 40));
        c.fill =GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=0;
        c.ipady=50;
        start.addActionListener(controller);

        JButton rules = new JButton("Rules");
        rules.setFont(new Font("Calibri", Font.PLAIN, 40));
        c.fill =GridBagConstraints.HORIZONTAL;
        c.gridx=1;
        c.gridy=0;
        c.ipady=50;
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
        mapState.setVisible(true);
        frame.getContentPane().removeAll();
        JPanel mainScreen = new JPanel(new BorderLayout());
        mapState.setVisible(true);

        frame.getContentPane().add(mainScreen);

        ImageIcon logoImage = new ImageIcon(getClass().getResource("res/riskMap.jpg"));
        JLabel logo = new JLabel(logoImage);
        logo.setPreferredSize(new Dimension(300, 300));
        mainScreen.add(logo, BorderLayout.CENTER);


        JPanel countries = new JPanel(new GridLayout(15,3));

        //Adding country buttons
        JButton EasternAustralia = new JButton("Eastern Australia");
        EasternAustralia.setBackground(pink);
        countries.add(EasternAustralia);
        EasternAustralia.addActionListener(controller);


        JButton Indonesia = new JButton("Indonesia");
        Indonesia.setBackground(pink);
        countries.add(Indonesia);
        Indonesia.addActionListener(controller);

        JButton NewGuinea= new JButton("New Guinea");
        NewGuinea.setBackground(pink);
        countries.add(NewGuinea);
        NewGuinea.addActionListener(controller);

        JButton WesternAustralia = new JButton("Western Australia");
        WesternAustralia.setBackground(pink);
        countries.add(WesternAustralia);
        WesternAustralia.addActionListener(controller);

        JButton Afghanistan = new JButton("Afghanistan");
        countries.add(Afghanistan);
        Afghanistan.setBackground(green);
        Afghanistan.addActionListener(controller);

        JButton China = new JButton("China");
        countries.add(China);
        China.setBackground(green);
        China.addActionListener(controller);

        JButton India= new JButton("India");
        countries.add(India);
        India.setBackground(green);
        India.addActionListener(controller);

        JButton Irkutsk = new JButton("Irkutsk");
        countries.add(Irkutsk);
        Irkutsk.setBackground(green);
        Irkutsk.addActionListener(controller);

        JButton Japan = new JButton("Japan");
        countries.add(Japan);
        Japan.setBackground(green);
        Japan.addActionListener(controller);

        JButton Kamchatka = new JButton("Kamchatka");
        countries.add(Kamchatka);
        Kamchatka.setBackground(green);
        Kamchatka.addActionListener(controller);

        JButton MiddleEast= new JButton("Middle East");
        countries.add(MiddleEast);
        MiddleEast.setBackground(green);
        MiddleEast.addActionListener(controller);

        JButton Mongolia = new JButton("Mongolia");
        countries.add(Mongolia);
        Mongolia.setBackground(green);
        Mongolia.addActionListener(controller);

        JButton Siam = new JButton("Siam");
        countries.add(Siam);
        Siam.setBackground(green);
        Siam.addActionListener(controller);

        JButton Siberia = new JButton("Siberia");
        countries.add(Siberia);
        Siberia.setBackground(green);
        Siberia.addActionListener(controller);

        JButton Ural= new JButton("Ural");
        countries.add(Ural);
        Ural.setBackground(green);
        Ural.addActionListener(controller);

        JButton Yakutsk = new JButton("Yakutsk");
        countries.add(Yakutsk);
        Yakutsk.setBackground(green);
        Yakutsk.addActionListener(controller);

        JButton Congo = new JButton("Congo");
        countries.add(Congo);
        Congo.setBackground(brown);
        Congo.addActionListener(controller);

        JButton EastAfrica = new JButton("East Africa");
        countries.add(EastAfrica);
        EastAfrica.setBackground(brown);
        EastAfrica.addActionListener(controller);

        JButton Egypt= new JButton("Egypt");
        countries.add(Egypt);
        Egypt.setBackground(brown);
        Egypt.addActionListener(controller);

        JButton Madagascar = new JButton("Madagascar");
        countries.add(Madagascar);
        Madagascar.setBackground(brown);
        Madagascar.addActionListener(controller);

        JButton NorthAfrica = new JButton("North Africa");
        countries.add(NorthAfrica);
        NorthAfrica.setBackground(brown);
        NorthAfrica.addActionListener(controller);

        JButton SouthAfrica = new JButton("South Africa");
        countries.add(SouthAfrica);
        SouthAfrica.setBackground(brown);
        SouthAfrica.addActionListener(controller);

        JButton GreatBritain= new JButton("Great Britain");
        countries.add(GreatBritain);
        GreatBritain.setBackground(blue);
        GreatBritain.addActionListener(controller);

        JButton Iceland = new JButton("Iceland");
        countries.add(Iceland);
        Iceland.setBackground(blue);
        Iceland.addActionListener(controller);

        JButton NorthernEurope = new JButton("Northern Europe");
        countries.add(NorthernEurope);
        NorthernEurope.setBackground(blue);
        NorthernEurope.addActionListener(controller);

        JButton Scandinavia = new JButton("Scandinavia");
        countries.add(Scandinavia);
        Scandinavia.setBackground(blue);
        Scandinavia.addActionListener(controller);

        JButton SouthernEurope= new JButton("Southern Europe");
        countries.add(SouthernEurope);
        SouthernEurope.setBackground(blue);
        SouthernEurope.addActionListener(controller);

        JButton Ukraine = new JButton("Ukraine");
        countries.add(Ukraine);
        Ukraine.setBackground(blue);
        Ukraine.addActionListener(controller);

        JButton WesternEurope = new JButton("Western Europe");
        countries.add(WesternEurope);
        WesternEurope.setBackground(blue);
        WesternEurope.addActionListener(controller);

        JButton Argentina = new JButton("Argentina");
        countries.add(Argentina);
        Argentina.setBackground(yellow);
        Argentina.addActionListener(controller);

        JButton Brazil= new JButton("Brazil");
        countries.add(Brazil);
        Brazil.setBackground(yellow);
        Brazil.addActionListener(controller);

        JButton Peru = new JButton("Peru");
        countries.add(Peru);
        Peru.setBackground(yellow);
        Peru.addActionListener(controller);

        JButton Venezuela = new JButton("Venezuela");
        countries.add(Venezuela);
        Venezuela.setBackground(yellow);
        Venezuela.addActionListener(controller);

        JButton Alaska = new JButton("Alaska");
        countries.add(Alaska);
        Alaska.setBackground(orange);
        Alaska.addActionListener(controller);

        JButton Alberta= new JButton("Alberta");
        countries.add(Alberta);
        Alberta.setBackground(orange);
        Alberta.addActionListener(controller);

        JButton CentralAmerica = new JButton("Central America");
        countries.add(CentralAmerica);
        CentralAmerica.setBackground(orange);
        CentralAmerica.addActionListener(controller);

        JButton EasternUnitedStates = new JButton("Eastern United States");
        countries.add(EasternUnitedStates);
        EasternUnitedStates.setBackground(orange);
        EasternUnitedStates.addActionListener(controller);

        JButton Greenland = new JButton("Greenland");
        countries.add(Greenland);
        Greenland.setBackground(orange);
        Greenland.addActionListener(controller);

        JButton NorthwestTerritories= new JButton("Northwest Territories");
        countries.add(NorthwestTerritories);
        NorthwestTerritories.setBackground(orange);
        NorthwestTerritories.addActionListener(controller);

        JButton Ontario = new JButton("Ontario");
        countries.add(Ontario);
        Ontario.setBackground(orange);
        Ontario.addActionListener(controller);

        JButton Quebec= new JButton("Quebec");
        countries.add(Quebec);
        Quebec.setBackground(orange);
        Quebec.addActionListener(controller);

        JButton WesternUnitedStates = new JButton("Western United States");
        countries.add(WesternUnitedStates);
        WesternUnitedStates.setBackground(orange);
        WesternUnitedStates.addActionListener(controller);



        mainScreen.add(countries, BorderLayout.WEST);



        //Dice
        JPanel controls= new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JButton dice1 = new JButton("1 Die");
        c.fill =GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=0;
        c.ipady=30;
        dice1.setBackground(Color.red);
        dice1.addActionListener(controller);

        controls.add(dice1,c);

        JButton dice2 = new JButton("2 Dice");
        c.fill =GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        controls.add(dice2,c);
        dice2.setBackground(Color.red);
        dice2.addActionListener(controller);

        JButton dice3 = new JButton("3 Dice");
        c.fill =GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        controls.add(dice3,c);
        dice3.setBackground(Color.red);
        dice3.addActionListener(controller);

        JButton Attack = new JButton("ATTACK!!");
        c.fill =GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        controls.add(Attack,c);
        Attack.setBackground(Color.yellow);
        Attack.addActionListener(controller);

        JButton Fortify = new JButton("FORTIFY!!");
        c.fill =GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        controls.add(Fortify,c);
        Fortify.setBackground(Color.yellow);
        Fortify.addActionListener(controller);

        JButton Pass = new JButton(("PASS"));
        c.fill =GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        controls.add(Pass,c);
        Pass.setBackground(Color.yellow);
        Pass.addActionListener(controller);

        mainScreen.add(controls,BorderLayout.EAST);
        frame.validate();
        frame.repaint();
        JOptionPane.showMessageDialog(this.frame, "The game shall begin with Player 1",
                "Info",JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("res/riskLogo.png")));

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

    public int pass(int playerNum) {
        int choice = JOptionPane.showConfirmDialog(null,
                "Are you sure you would like to pass?",
                "Pass",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(getClass().getResource("res/riskLogo.png")));

        if (choice == 0) {
            JOptionPane.showMessageDialog(this.frame,"It is now Player" + playerNum + "'s turn.", "Info",
                    JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("res/riskLogo.png")));
        }

        return choice;
    }

    public void notYourCountry(String name) {
        JOptionPane.showMessageDialog(this.frame, "You do not rule " + name + ", please select a country" +
                        " that you rule.", "Warning",
                JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    public void cannotAttack(String name) {
        JOptionPane.showMessageDialog(this.frame, "You rule " + name + " you cannot attack it.",
                "Warning", JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    public void cannotFortify(String name) {

    }

    public void notAdjacent(String name) {
        JOptionPane.showMessageDialog(this.frame,  name + " is not adjacent to the country you are attacking" +
                        " from, please select a country that is adjacent to the country you are attacking from.",
                "Warning", JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    public void pickAttackFromCountry(String name) {
        JOptionPane.showMessageDialog(this.frame,  "You cannot " + name + ", please select country to attack from first.",
                "Warning", JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    public void pickAttackToCountry(String name) {
        JOptionPane.showMessageDialog(this.frame,  "You cannot " + name + ", please select country to attack first.",
                "Warning", JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    public void selectDice() {
        JOptionPane.showMessageDialog(this.frame, "Please select number of dice before attacking.",
                "Warning", JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    public void notEnoughArmies(String name, int dice) {
        JOptionPane.showMessageDialog(this.frame, "You do not have enough armies in " + name + " to attack" +
                        ", must have a minimum of " + dice + " armies to attack.",
                "Warning", JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    public void stateOfTheMap(String info) {
        JOptionPane.showMessageDialog(this.frame,info,"State of the Map",JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

}
