import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private Board model;
    private View view;
    private int menu;
    private int numPlayers;

    public Controller(View view) {

        this.view = view;
        menu = 0;
        numPlayers = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().getClass() == JMenuItem.class) {
            jMenuBarPerformed(e);
        } else {

            switch (menu) {
                case 0:
                    startPerformed(e);
                    break;

                case 1:
                    selectLevelPerformed(e);
                    break;

            }
        }

    }

    private void startPerformed(ActionEvent e) {
        String input;

        if (e.getSource().getClass() == JButton.class) {
            JButton placeHolder = (JButton) e.getSource();
            input = placeHolder.getText();

            if (input.equals("Start")) {
                view.createNumOfPlayers();
                menu = 1;
            } else if (input.equals("Rules")) {
                view.showRules();
            }
        }
    }

    private void jMenuBarPerformed(ActionEvent e) {
        String input;

        JMenuItem placeHolder = (JMenuItem) e.getSource();
        input = placeHolder.getText();

        if (input.equals("Rules")) {
            view.showRules();
        } else if (input.equals("Map State")) {
            //add this later when completed
        } else if (input.equals("Quit")) {
            view.quit();
        }
    }

    private void selectLevelPerformed(ActionEvent e) {
        String input;

        if (e.getSource().getClass() == JButton.class) {
            JButton placeHolder = (JButton) e.getSource();
            input = placeHolder.getText();

            if (input.equals("2 Players")) {
                numPlayers = 2;
            } else if (input.equals("3 Players")) {
                numPlayers = 3;
            } else if (input.equals("4 Players")) {
                numPlayers = 4;
            } else if (input.equals("5 players")) {
                numPlayers = 5;
            } else if (input.equals("6 players")) {
                numPlayers = 6;
            } else if (input.equals("Start Game") && numPlayers != 0) {
                model = new Board(numPlayers);
                view.mainScreen();
                menu = 2;
            }
        }
    }

}
