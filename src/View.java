import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;

/**
 * This class is used to display the view of the game
 * @author Danish Butt, Sudarsana Sandeep
 */
public class View {

    private JFrame frame;
    private Controller controller;
    private JMenuItem mapState, mainMenu, help;
    int choice;
    public static final Color pink= new Color(255,153,255);
    public static final Color brown = new Color(168,126,40);
    public static final Color yellow = new Color(245,217,76);
    public static final Color green = new Color(84,207,68);
    public static final Color orange = new Color(255,163,43);
    public static final Color blue = new Color(153,153,255);


    /**
     * This method is used to create the an instance of the view.
     * @param args
     */
    public static void main(String[] args) {
        new View();
    }

    /**
     * This method is the constructor for the View class
     */
    public View() {

        controller = new Controller(this);

        //Create main frame
        frame = new JFrame("Risk");
        frame.setSize(1500, 1500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        //Create menu bar that includes various options such as rules, map state, help, quit
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);

        JMenu options = new JMenu("Options");
        menu.add(options);

        JMenuItem rules = new JMenuItem("Rules");
        mapState = new JMenuItem("Map State");
        help = new JMenuItem("Help");
        JMenuItem quit = new JMenuItem("Quit");
        mainMenu = new JMenuItem("Main Menu");

        options.add(help);
        options.add(rules);
        options.add(mapState);
        options.add(quit);

        rules.addActionListener(controller);
        mapState.addActionListener(controller);
        quit.addActionListener(controller);
        help.addActionListener(controller);
        help.setVisible(false);

        frame.setVisible(true);
        startMenu();

    }

    /**
     * This method creates the startMenu panel. This is the first screen that pops up and prompts
     * the user to either start a game or to display the rules
     */
    public void startMenu() {

        mapState.setVisible(false);
        mainMenu.setVisible(false);
        help.setVisible(false);

        frame.getContentPane().removeAll();

        //Create panel using borderlayout and add to frame
        JPanel startMenu = new JPanel(new BorderLayout());
        frame.add(startMenu);

        //Add image logo
        ImageIcon logoImage = new ImageIcon(getClass().getResource("res/riskLogo.png"));
        JLabel logo = new JLabel(logoImage);
        logo.setPreferredSize(new Dimension(300, 300));
        startMenu.add(logo, BorderLayout.NORTH);

        //Create Buttons
        JPanel buttons = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JButton start = new JButton("Start");
        start.setFont(new Font("Calibri", Font.PLAIN, 40));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 50;
        start.addActionListener(controller);

        JButton rules = new JButton("Rules");
        rules.setFont(new Font("Calibri", Font.PLAIN, 40));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.ipady = 50;
        rules.addActionListener(controller);

        //Add buttons to startMenu frame
        buttons.add(rules);
        buttons.add(start);
        startMenu.add(buttons, BorderLayout.CENTER);

        frame.validate();
        frame.repaint();

    }

    /**
     * This method creates the number of players panel which is used by the
     * user to select the number of players playing
     */
    public void createNumOfPlayers() {

        help.setVisible(false);
        frame.getContentPane().removeAll();

        //Create numOfPlayers panel
        JPanel numOfPlayers = new JPanel(new BorderLayout());
        frame.getContentPane().add(numOfPlayers);

        //Add logo image
        ImageIcon logoImage = new ImageIcon(getClass().getResource("res/riskLogo.png"));
        JLabel logo = new JLabel(logoImage);
        logo.setPreferredSize(new Dimension(300, 300));
        numOfPlayers.add(logo, BorderLayout.NORTH);

        //Create buttons layout
        JPanel playerButtons = new JPanel(new GridLayout(3, 2));

        //Add buttons
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

        JButton startGame = new JButton("Start Game");
        startGame.setFont(new Font("Calibri", Font.PLAIN, 20));
        startGame.addActionListener(controller);

        playerButtons.add(player2);
        playerButtons.add(player3);
        playerButtons.add(player4);
        playerButtons.add(player5);
        playerButtons.add(player6);
        playerButtons.add(startGame);

        //Add buttons to numOfPlayers frame
        numOfPlayers.add(playerButtons, BorderLayout.CENTER);

        frame.validate();
        frame.repaint();

    }

    /**
     * This method creates the main screen of the game. This includes the map, buttons for
     * all the countries and buttons for the different operations and the dice
     */
    public void mainScreen() {

        help.setVisible(true);
        mapState.setVisible(true);
        frame.getContentPane().removeAll();

        //Create main screen panel
        JPanel mainScreen = new JPanel(new BorderLayout());
        mapState.setVisible(true);

        frame.getContentPane().add(mainScreen);

        //Add map image
        ImageIcon logoImage = new ImageIcon(getClass().getResource("res/riskMap.jpg"));
        JLabel logo = new JLabel(logoImage);
        logo.setPreferredSize(new Dimension(300, 300));
        mainScreen.add(logo, BorderLayout.CENTER);

        //Create panel for country buttons
        JPanel countries = new JPanel(new GridLayout(15, 3));

        //Adding country buttons
        JButton EasternAustralia = new JButton("Eastern Australia");
        EasternAustralia.setBackground(pink);
        countries.add(EasternAustralia);
        EasternAustralia.addActionListener(controller);

        JButton Indonesia = new JButton("Indonesia");
        Indonesia.setBackground(pink);
        countries.add(Indonesia);
        Indonesia.addActionListener(controller);

        JButton NewGuinea = new JButton("New Guinea");
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

        JButton India = new JButton("India");
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

        JButton MiddleEast = new JButton("Middle East");
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

        JButton Ural = new JButton("Ural");
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

        JButton Egypt = new JButton("Egypt");
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

        JButton GreatBritain = new JButton("Great Britain");
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

        JButton SouthernEurope = new JButton("Southern Europe");
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

        JButton Brazil = new JButton("Brazil");
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

        JButton Alberta = new JButton("Alberta");
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

        JButton NorthwestTerritories = new JButton("Northwest Territories");
        countries.add(NorthwestTerritories);
        NorthwestTerritories.setBackground(orange);
        NorthwestTerritories.addActionListener(controller);

        JButton Ontario = new JButton("Ontario");
        countries.add(Ontario);
        Ontario.setBackground(orange);
        Ontario.addActionListener(controller);

        JButton Quebec = new JButton("Quebec");
        countries.add(Quebec);
        Quebec.setBackground(orange);
        Quebec.addActionListener(controller);

        JButton WesternUnitedStates = new JButton("Western United States");
        countries.add(WesternUnitedStates);
        WesternUnitedStates.setBackground(orange);
        WesternUnitedStates.addActionListener(controller);

        //Add country panel to main screen panel
        mainScreen.add(countries, BorderLayout.WEST);

        //Add panel for the different operatios and dice
        JPanel controls = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Add dice buttons
        JButton dice1 = new JButton("1 Die");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 30;
        dice1.setBackground(Color.red);
        dice1.addActionListener(controller);

        controls.add(dice1, c);

        JButton dice2 = new JButton("2 Dice");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        controls.add(dice2, c);
        dice2.setBackground(Color.red);
        dice2.addActionListener(controller);

        JButton dice3 = new JButton("3 Dice");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        controls.add(dice3, c);
        dice3.setBackground(Color.red);
        dice3.addActionListener(controller);

        //Add operation buttons
        JButton Attack = new JButton("ATTACK!!");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        controls.add(Attack, c);
        Attack.setBackground(Color.yellow);
        Attack.addActionListener(controller);

        JButton Fortify = new JButton("FORTIFY!!");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        controls.add(Fortify, c);
        Fortify.setBackground(Color.yellow);
        Fortify.addActionListener(controller);

        JButton Pass = new JButton(("PASS"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        controls.add(Pass, c);
        Pass.setBackground(Color.yellow);
        Pass.addActionListener(controller);

        //Adding controls to main screen frame
        mainScreen.add(controls, BorderLayout.EAST);
        frame.validate();
        frame.repaint();

        //Display starting game message
        JOptionPane.showMessageDialog(this.frame, "The game shall begin with Player 1",
                "Info",JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));


    }

    /**
     * This method shows the rules. This method is called when the user presses the rules button
     */
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
                "                                  ", "Rules", JOptionPane.INFORMATION_MESSAGE,

                new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    /**
     * This method is used to quit the game. This happens when the user presses quit.
     */
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

    /**
     * This method is used to confirm that the user would like to pass.
     */
    public void pass() {
        choice = JOptionPane.showConfirmDialog(null,
                "Are you sure you would like to pass?",
                "Pass",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    /**
     * This method is used to display that it is the next person's turn once the
     * previous player passes
     * @param playerNum
     */
    public void passForSure(int playerNum) {
        JOptionPane.showMessageDialog(this.frame,"It is now Player " + playerNum + "'s turn.", "Info",
                JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));

    }

    /**
     * This method is used to display a message when a user presses a
     * country they do not own
     * @param name
     */
    public void notYourCountry(String name) {
        JOptionPane.showMessageDialog(this.frame, "You do not rule " + name + ", please select a country" +
                        " that you rule.", "Warning",
                JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    /**
     * This method is used to display a message when a user tries to attack a country they rule
     * @param name
     */
    public void cannotAttack(String name) {
        JOptionPane.showMessageDialog(this.frame, "You rule " + name + " you cannot attack it.",
                "Warning", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    /**
     * This method is used display a message when a user tries to select a country that is not adjacent
     * to the first country they selected
     * @param name
     * @return : used to return whether a country is adjacent or not
     */
    public boolean notAdjacent(String name) {
        JOptionPane.showMessageDialog(this.frame,  name + " is not adjacent to the country you have selected" +
                        ", please restart your move.",
                "Warning", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));
        return true;
    }

    /**
     * This method is used to display a message when the user tries to attack before selecting a country
     * @param name
     */
    public void wrongChoice(String name) {
        JOptionPane.showMessageDialog(this.frame,  "You cannot " + name + ", please select country to attack" +
                        " from first, then country you would like to attack, then the amount of dice and finally choose to attack.",
                "Warning", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));

    }

    /**
     * This method is displayed when the user enters a incorrect number of dice
     * @param name
     * @param dice
     */
    public void notEnoughArmies(String name, int dice) {
        JOptionPane.showMessageDialog(this.frame, "You do not have enough armies in " + name + " to attack" +
                        ", must have a minimum of " + dice + " armies to attack.",
                "Warning", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    /**
     * This method is used to display the state of the map
     * @param info
     */
    public void stateOfTheMap(String info) {
        JTextArea j = new JTextArea(20, 25);
        j.setText(info);
        JScrollPane state = new JScrollPane(j);

        JOptionPane.showMessageDialog(this.frame, state, "State of the Map", JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }


    /**
     * This method is used to display a method if the user selects dice before selecting a country
     */
    public void wrongSelection() {
        JOptionPane.showMessageDialog(this.frame, "Please select countries before selecting dice, then select" +
                        " dice and finally attack.",
                "Warning", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    /**
     * This method is used to display a message if a user does not select a country and presses fortify
     */
    public void selectCountries() {
        JOptionPane.showMessageDialog(this.frame, "Please select countries before fortifying",
                "Warning", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    /**
     * This method is used to display message when the user presses help
     */
    public void help() {
        JOptionPane.showMessageDialog(this.frame,"1. The player has 3 options (Attack, Fortify, Pass)\n"
                + "2. To attack the user needs to first press the country they are attacking from, " +
                        "the country they want to attack, the number of dice to roll and then press Attack\n"
                + "3. To fortify the user needs to first press the country they are fortifying from, the country they " +
                        "want to fortify to, then press Fortify and finally input how many armies to fortify with\n"
                + "4. Important Note: If during attack or fortify a clause is triggered (example, country is not adjacent, " +
                        "you own the country, etc.) restart move from beginning.\n"
                +"5. To pass the user needs to press Pass. The game will then have a pop up which will st" +
                        "ate the next players turn\n" +
                "6. If the user clicks Rules the rules will be displayed\n" +
                "7. If the user clicks Map State, the state of the map will be displayed" +
                        " with which players owns which country and how many armies in each country\n"
                + "8. If the user clicks Quit, they exit the game\n"

                ,
                "Help", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    /**
     * This method is used to display a message after an attack has happened
     * @param result
     */
    public void attackResult(String result) {
        JOptionPane.showMessageDialog(this.frame, result ,
                "Result", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));

    }

    /**
     * This method is used to display a message asking the user for the number of armies they would
     * like to fortify with
     * @return
     */
    public int armyAmount() {

        return Integer.parseInt(JOptionPane.showInputDialog("How many armies would you like to FORTIFY!! with?"));

    }

    /**
     * This method is used to display a message when the user tries to fortify between 2 countries they
     * do not own
     */
    public void notRuled() {
        JOptionPane.showMessageDialog(this.frame, "You do not rule both countries, you must rule " +
                        "both countries to fortify.",
                "Warning", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    /**
     * This method is used to display the results of a fortify
     * @param details
     */
    public void fortifyResult(String details) {
        JOptionPane.showMessageDialog(this.frame, details,
                "Result", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    /**
     * This method is used to display a message when the user
     * chooses to exit from fortifying
     */
    public void cancelFortify() {
        JOptionPane.showMessageDialog(this.frame, "You have cancelled the fortification process.",
                "Warning", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    /**
     * This method is used to display a message when a user conquers a territory
     * @param b
     */
    public void conquered(String b) {
        JOptionPane.showMessageDialog(this.frame, b,
            "Message", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    /**
     * This method is used to display a message asking the user for the number of armies they would
     *  like to fortify with only when they have conquered a country
     * @return
     */
    public int armyToReinforce() {
        return Integer.parseInt(JOptionPane.showInputDialog("How many armies would you like to REINFORCE with?"));
    }

    /**
     * This method is used to display a message when the user selects a dice value
     * that is not one more than the number of armies they own in that country
     */

    public void notEnoughArmy() {
        JOptionPane.showMessageDialog(this.frame, "You must have one more army in the country you are" +
                        " attacking from than the amount of dice you want to roll.",
                "Warning", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    public void bonusArmies(String name, int numOfArmies){
        JOptionPane.showMessageDialog(this.frame, name + " receives " + numOfArmies + " bonus armies ",
                "Message", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    public String addArmyToCountry (){
        return String.valueOf(JOptionPane.showInputDialog("Which country would you like to add an army too?"));

    }

    public void notRuler(){
        JOptionPane.showMessageDialog(this.frame, "You do not own this country. Please try again.",
                "Message", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }

    public ArrayList selectAi(int numPlayers) {

        ArrayList aiPlayerList = new ArrayList<Boolean>();
        String msg = "Please select which players you would like for to be an AI player";
        Object[] content;

        JCheckBox p1 = null, p2 = null, p3 = null, p4 = null, p5 = null, p6 = null;

        if (numPlayers == 2) {
            p1 = new JCheckBox("Player 1");
            p2 = new JCheckBox("Player 2");
            content = new Object[]{msg, p1, p2};
        } else if (numPlayers == 3) {
            p1 = new JCheckBox("Player 1");
            p2 = new JCheckBox("Player 2");
            p3 = new JCheckBox("Player 3");
            content = new Object[]{msg, p1, p2, p3};
        } else if (numPlayers == 4) {
            p1 = new JCheckBox("Player 1");
            p2 = new JCheckBox("Player 2");
            p3 = new JCheckBox("Player 3");
            p4 = new JCheckBox("Player 4");
            content = new Object[]{msg, p1, p2, p3, p4};
        } else if (numPlayers == 5) {
            p1 = new JCheckBox("Player 1");
            p2 = new JCheckBox("Player 2");
            p3 = new JCheckBox("Player 3");
            p4 = new JCheckBox("Player 4");
            p5 = new JCheckBox("Player 5");
            content = new Object[]{msg, p1, p2, p3, p4, p5};
        } else {
            p1 = new JCheckBox("Player 1");
            p2 = new JCheckBox("Player 2");
            p3 = new JCheckBox("Player 3");
            p4 = new JCheckBox("Player 4");
            p5 = new JCheckBox("Player 5");
            p6 = new JCheckBox("Player 6");
            content = new Object[]{msg, p1, p2, p3, p4, p5, p6};
        }

        JOptionPane.showMessageDialog(this.frame,content, "AI", JOptionPane.OK_OPTION,
                new ImageIcon(getClass().getResource("res/riskLogo.png")));

        if (numPlayers == 2) {
            aiPlayerList.add(p1.isSelected());
            aiPlayerList.add(p2.isSelected());
        } else if (numPlayers == 3) {
            aiPlayerList.add(p1.isSelected());
            aiPlayerList.add(p2.isSelected());
            aiPlayerList.add(p3.isSelected());
        } else if (numPlayers == 4) {
            aiPlayerList.add(p1.isSelected());
            aiPlayerList.add(p2.isSelected());
            aiPlayerList.add(p3.isSelected());
            aiPlayerList.add(p4.isSelected());
        } else if (numPlayers == 5) {
            aiPlayerList.add(p1.isSelected());
            aiPlayerList.add(p2.isSelected());
            aiPlayerList.add(p3.isSelected());
            aiPlayerList.add(p4.isSelected());
            aiPlayerList.add(p5.isSelected());
        } else {
            aiPlayerList.add(p1.isSelected());
            aiPlayerList.add(p2.isSelected());
            aiPlayerList.add(p3.isSelected());
            aiPlayerList.add(p4.isSelected());
            aiPlayerList.add(p5.isSelected());
            aiPlayerList.add(p6.isSelected());
        }

        return aiPlayerList;
    }

    public void aiPlayerMoves(String info) {
        JTextArea infoArea = new JTextArea(20, 25);
        infoArea.setText(info);
        JScrollPane state = new JScrollPane(infoArea);

        UIManager.put("OptionPane.minimumSize", new Dimension(1000, 500));

        JOptionPane.showMessageDialog(this.frame, state, "AI Moves", JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(getClass().getResource("res/riskLogo.png")));
    }
}
