import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private Board model;
    private View view;
    private int menu;
    private int numPlayers, numOfAttackDice, playerNumber;
    private String country1, country2;


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

                case 2:
                    mainScreenPerformed(e);
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
            } else if (input.equals("5 Players")) {
                numPlayers = 5;
            } else if (input.equals("6 Players")) {
                numPlayers = 6;
            } else if (input.equals("Start Game") && numPlayers != 0) {
                model = new Board(numPlayers);
                view.mainScreen();
                menu = 2;
            }
            playerNumber = 1;
        }
    }

    private void mainScreenPerformed(ActionEvent e) {

        JButton placeHolder = (JButton) e.getSource();

        if ((!placeHolder.getText().equals("ATTACK!!")) && (!placeHolder.getText().equals("FORTIFY!!"))
        && (!placeHolder.getText().equals("1 die")) && (!placeHolder.getText().equals("2 dice"))
                && (!placeHolder.getText().equals("3 dice"))) {
            country1 = placeHolder.getText();
            if((model.playerArray.get(playerNumber).ownsCountry(country1)) == false) {
                model.playerArray.get(playerNumber).getRuledCountriesInfo();
                view.notYourCountry(country1);
            }
        }

        if (country1 != null) {
            country2 = placeHolder.getText();
        }

        if (placeHolder.getText().equals("1 die")) {
            numOfAttackDice = 1;
        } else if (placeHolder.getText().equals("2 dice")) {
            numOfAttackDice = 2;
        } else {
            numOfAttackDice = 3;
        }

        if (placeHolder.getText().equals("ATTACK!!")) {
            if (country1.equals(null)) {

            }

            if (country2.equals(null)) {

            }
            model.attack(country1, country2, numOfAttackDice);
        }



    }

}
