import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class View {
    private JFrame frame;


    public JFrame getFrame() {
        return this.frame;
    }

    public static void main(String[] args) {
        View window = new View();
    }

    public View(){

        frame = new JFrame("Risk");

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);



        JMenuBar menu= new JMenuBar();
        frame.setJMenuBar(menu);

        JMenu options = new JMenu("Options");
        menu.add(options);

        JMenuItem rules = new JMenuItem("Rules");
        JMenuItem mapState = new JMenuItem("Map State");
        JMenuItem quit = new JMenuItem("Quit");
        options.add(rules);
        options.add(mapState);
        options.add(quit);

        frame.setVisible(true);
        //startMenu();
        createNumOfPlayers();
    }

    public void startMenu(){

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

        JButton rules = new JButton("Rules");
        rules.setFont(new Font("Calibri", Font.PLAIN, 20));

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

        JButton player3 = new JButton("3 Players");
        player3.setFont(new Font("Calibri", Font.PLAIN, 20));

        JButton player4 = new JButton("4 Players");
        player4.setFont(new Font("Calibri", Font.PLAIN, 20));

        JButton player5 = new JButton("5 Players");
        player5.setFont(new Font("Calibri", Font.PLAIN, 20));

        JButton player6 = new JButton("6 Players");
        player6.setFont(new Font("Calibri", Font.PLAIN, 20));

        JButton startGame= new JButton("Start Game");
        startGame.setFont(new Font("Calibri", Font.PLAIN, 20));

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

}
