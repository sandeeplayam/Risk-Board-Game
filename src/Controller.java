import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private Board model;
    private View view;
    private int menu;
    private int numPlayers, numOfAttackDice, playerNumber, country1Index, country2Index;
    private String country1, country2;


    public Controller(View view) {

        this.view = view;
        menu = 0;
        numPlayers = 0;
        numOfAttackDice = 0;
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
            playerNumber = 0;
        }
    }

    private void mainScreenPerformed(ActionEvent e) {
        model.stateOfMap();
        JButton placeHolder = (JButton) e.getSource();

        if ((!placeHolder.getText().equals("PASS")) && (!placeHolder.getText().equals("FORTIFY!!"))
        && (!placeHolder.getText().equals("1 Die")) && (!placeHolder.getText().equals("2 Dice"))
                && (!placeHolder.getText().equals("3 Dice"))) {

                if (!placeHolder.getText().equals("ATTACK!!")) {

                    if (country1 != null) {
                        country1Index = model.mapCountryToIndex(country1); //will be used to represent attacking country
                        country2Index = model.mapCountryToIndex(placeHolder.getText()); //will be used to represent country that is being attacked

                        if (model.checkAdjacentCountries(model.getCountries(country1Index), model.getCountries(country2Index))) {
                            country2 = placeHolder.getText();
                        } else {
                            view.notAdjacent(placeHolder.getText());
                        }
                    }

                    if (country1 == null) {
                        if (!(model.playerArray.get(playerNumber).ownsCountry(placeHolder.getText()))) {
                            view.notYourCountry(placeHolder.getText());
                        } else {
                            country1 = placeHolder.getText();
                        }
                    }
                }

                if (placeHolder.getText().equals("ATTACK!!")) {
                    if (country1 == null) {
                        view.pickAttackFromCountry(placeHolder.getText());
                    } else if (country2 == null) {
                        view.pickAttackToCountry(placeHolder.getText());
                    } else if (numOfAttackDice == 0) {
                        view.selectDice();
                    } else if (model.getCountries(country1Index).getArmies() < 2) {
                        view.notEnoughArmies(country1, numOfAttackDice);
                    } else if (model.playerArray.get(playerNumber).ownsCountry(country2)) {
                        view.cannotAttack(country2);
                        country2 = null;
                    } else if (country1 != null && country2 != null && numOfAttackDice > 0){
                        System.out.println(numOfAttackDice);
                        model.attack(country1, country2, numOfAttackDice);
                        //display attack info
                        country1 = null;
                        country2 = null;
                    }
                }
        }


        if (placeHolder.getText().equals("1 Die")) {
            numOfAttackDice = 1;
        } else if (placeHolder.getText().equals("2 Dice")) {
            numOfAttackDice = 2;
        } else if (placeHolder.getText().equals("3 Dice")){
            numOfAttackDice = 3;
        }


        if (placeHolder.getText().equals("PASS")) {

                if (playerNumber == (model.playerArray.size() - 1)) {
                    playerNumber = 0;
                } else {
                    playerNumber++;
                }

        }

    }

}
