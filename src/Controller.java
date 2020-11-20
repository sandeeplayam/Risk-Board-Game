import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The Controller class represents the Controller in the MVC pattern for this project, and this class acts as the
 * middleman between the View and Model.
 *
 * @Author: Sudarsana Sandeep, Danish Butt
 */

public class Controller implements ActionListener {

    private Board model;
    private View view;
    private int menu;

    private int numPlayers, numOfAttackDice, playerNumber, country1Index, country2Index;
    private String country1, country2, info, temp;

    /**
     * The constructor for the Controller class
     * @param view Takes in an instance of the view to invoke operations on it
     */
    public Controller(View view) {

        this.view = view;
        menu = 0;
        numPlayers = 0;
        numOfAttackDice = 0;
    }

    @Override
    /**
     * The actionPerformed method handles any action events which occur on the view, and based on the source of the
     * event will delegate to other performed methods
     * @param e An action event which is generated anytime something on the view occurs
     */
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


    /**
     * This method is a delegate method of actionPerformed, and will handle any events that occur on the first
     * screen/panel of the game
     * @param e An action event which is generated anytime something on the view occurs
     */
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


    /**
     * This method is a delegate method of actionPerformed, and will handle any events that occur on the menu bar in
     * the GUI
     * @param e An action event which is generated anytime something on the view occurs
     */
    private void jMenuBarPerformed(ActionEvent e) {
        String input;
        info = "";

        JMenuItem placeHolder = (JMenuItem) e.getSource();
        input = placeHolder.getText();
        System.out.println(input);

        if (input.equals("Rules")) {
            view.showRules();
        } else if (input.equals("Map State")) {
            for (Player p : model.playerArray) {
                temp = "\n" + p.getName() + " rules:\n";
                info = info.concat(temp);
                info = info.concat(p.getRuledCountriesInfo());
            }
            view.stateOfTheMap(info);

        } else if (input.equals("Quit")) {
            view.quit();
        } else if (input.equals("Help")) {
            view.help();
        }
    }


    /**
     * This method is a delegate method of actionPerformed, and will handle any events that occur on the second
     * screen/panel of the game
     * @param e An action event which is generated anytime something on the view occurs
     */
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
                playerNumber=0;

                //Assign bonus armies for first player
                int newArmies = (model.playerArray.get(playerNumber).getCountrySizes() / 3);
                model.playerArray.get(playerNumber).increaseArmyCount(newArmies);

                view.bonusArmies(model.playerArray.get(playerNumber).getName(),newArmies);

                for(int b = 0; b < newArmies; b++) {
                    String country = view.addArmyToCountry();
                    int g = model.mapCountryToIndex(country);

                    while((model.playerArray.get(playerNumber).ownsCountry(country))){
                        view.notRuler();
                        country = view.addArmyToCountry();
                    }

                    model.getCountries(g).increaseArmyCount(1);
                }
            }
        }
    }


    /**
     * This method is a delegate method of actionPerformed, and will handle any events that occur on the main game screen
     * where the board is located.
     * @param e An action event which is generated anytime something on the view occurs
     */
    private void mainScreenPerformed(ActionEvent e) {
        boolean notAdjacent = false;

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
                        notAdjacent = view.notAdjacent(placeHolder.getText());
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
                    view.wrongChoice(placeHolder.getText());
                    country1 = null;
                    country2 = null;
                    numOfAttackDice = 0;
                } else if (country2 == null) {
                    view.wrongChoice(placeHolder.getText());
                    country1 = null;
                    country2 = null;
                    numOfAttackDice = 0;
                } else if (numOfAttackDice == 0) {
                    view.wrongChoice(placeHolder.getText());
                    country1 = null;
                    country2 = null;
                    numOfAttackDice = 0;
                } else if (model.playerArray.get(playerNumber).ownsCountry(country2)) {
                    view.cannotAttack(country2);
                    country2 = null;
                    country1 = null;
                    numOfAttackDice = 0;
                } else if (model.getCountries(country1Index).getArmies() < 2) {
                    view.notEnoughArmies(country1, numOfAttackDice);
                    country1 = null;
                    country2 = null;
                    numOfAttackDice = 0;

                } else if (country1 != null && country2 != null && numOfAttackDice > 0) {
                    System.out.println(numOfAttackDice);
                    String attackMsg = model.attack(country1, country2, numOfAttackDice);
                    view.attackResult(attackMsg);

                    if (model.getCountries(country2Index).getArmies() == 0) {
                        String conquerInfo;
                        String fortifyInfo;
                        conquerInfo = model.conquered(country1, country2, numOfAttackDice);
                        view.conquered(conquerInfo);

                        int numOfArmyReinforce = view.armyToReinforce();

                        while (!(numOfArmyReinforce >= numOfAttackDice || numOfArmyReinforce < model.getCountries(country1Index).getArmies())) {
                            numOfArmyReinforce = view.armyToReinforce();
                        }
                        fortifyInfo = model.fortify(country1, country2, numOfArmyReinforce);
                        view.fortifyResult(fortifyInfo);
                    }
                    country1 = null;
                    country2 = null;
                    numOfAttackDice = 0;
                }

            }
        }

            if (placeHolder.getText().equals("1 Die")) {
                if (country1 == null || country2 == null) {
                    view.wrongSelection();
                } else {
                    numOfAttackDice = 1;
                }
            } else if (placeHolder.getText().equals("2 Dice")) {
                if (country1 == null || country2 == null) {
                    view.wrongSelection();
                } else {
                    numOfAttackDice = 2;
                    if (model.getCountries(country1Index).getArmies() <= numOfAttackDice) {
                        view.notEnoughArmy();
                        numOfAttackDice = 0;
                        country1 = null;
                        country2 = null;
                    }
                }
            } else if (placeHolder.getText().equals("3 Dice")) {
                if (country1 == null || country2 == null) {
                    view.wrongSelection();
                } else {
                    numOfAttackDice = 3;
                    if (model.getCountries(country1Index).getArmies() <= numOfAttackDice) {
                        view.notEnoughArmy();
                        numOfAttackDice = 0;
                        country1 = null;
                        country2 = null;
                    }
                }
            }


            if (placeHolder.getText().equals("PASS")) {
                view.pass();
                if (view.choice == 0) {
                    if (playerNumber == (model.playerArray.size() - 1)) {
                        playerNumber = 0;
                    } else {
                        playerNumber++;
                    }
                    view.passForSure(playerNumber + 1);
                }
                //Assign bonus armies (3 or more)
                int newArmies = (model.playerArray.get(playerNumber).getCountrySizes() / 3);
                model.playerArray.get(playerNumber).increaseArmyCount(newArmies);

                view.bonusArmies(model.playerArray.get(playerNumber).getName(),newArmies);

                for(int b = 0; b < newArmies; b++) {
                    String country = view.addArmyToCountry();
                    int g = model.mapCountryToIndex(country);

                    while((model.playerArray.get(playerNumber).ownsCountry(country))){
                        view.notRuler();
                        country = view.addArmyToCountry();
                    }

                    model.getCountries(g).increaseArmyCount(1);
                }
            }

            if (placeHolder.getText().equals("FORTIFY!!")) {
                if (country1 == null || country2 == null) {
                    view.selectCountries();
                } else if (!model.getCountries(country1Index).getRuler().getName().equals(model.getCountries(country2Index).getRuler().getName())) {
                    view.notRuled();
                    country1 = null;
                    country2 = null;
                } else {
                    try {
                        int amount = view.armyAmount();
                        String fortifyDetail = model.fortify(country1, country2, amount);
                        country1 = null;
                        country2 = null;
                        view.fortifyResult(fortifyDetail);
                    } catch (Exception exception) {
                        view.cancelFortify();
                        country1 = null;
                        country2 = null;
                    }

                }
            }

            if (country1 != null) {
                if (notAdjacent) {
                    country1 = null;
                }
            }
        }

}
