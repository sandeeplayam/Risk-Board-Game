import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


/**
 * The Controller class represents the Controller in the MVC pattern for this project, and this class acts as the
 * middleman between the View and Model.
 *
 * @Author: Sudarsana Sandeep, Danish Butt
 */

public class Controller implements ActionListener {

    private Board model;
    private boolean customMap;
    private View view;
    private int menu;
    private SaveAndLoad saveLoad;
    private final ArrayList<String> countries;
    private final ArrayList<Country> countriesBoard;
    private final ArrayList<Continent> continents;

    private int numPlayers, numOfAttackDice, playerNumber, country1Index, country2Index;
    private String country1, country2, info, temp, temp1, temp2, info1, info2, countryName, continentName;

    /**
     * The constructor for the Controller class
     * @param view Takes in an instance of the view to invoke operations on it
     */
    public Controller(View view) {
        saveLoad = new SaveAndLoad();

        this.view = view;
        menu = 0;
        numPlayers = 0;
        numOfAttackDice = 0;
        info="";
        info1="";
        info2="";
        temp="";
        temp1="";
        temp2="";
        customMap = false;
        continents = new ArrayList<Continent>();
        countries = new ArrayList<>();
        countriesBoard = new ArrayList<Country>();

    }



    @Override
    /**
     * The actionPerformed method handles any action events which occur on the view, and based on the source of the
     * event will delegate to other performed methods
     * @param e An action event which is generated anytime something on the view occurs
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().getClass() == JMenuItem.class) {
            try {
                jMenuBarPerformed(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else {

            switch (menu) {
                case 0:
                    try {
                        startPerformed(e);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
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
    private void startPerformed(ActionEvent e) throws IOException, ClassNotFoundException {
        String input;
        File file1, file2, file3;

        if (e.getSource().getClass() == JButton.class) {
            JButton placeHolder = (JButton) e.getSource();
            input = placeHolder.getText();

            if (input.equals("Start New Game")) {
                view.createNumOfPlayers();
                menu = 1;
            } else if (input.equals("Rules")) {
                view.showRules();
            } else if (input.equals ("Load Game 1")){

                try {
                    BufferedReader in = new BufferedReader(new FileReader("SaveBoard1.ser"));
                    model= saveLoad.loadBoard(1);

                    view.mainScreen();
                    playerNumber=saveLoad.loadPlayerNum(1);

                    view.playerTurn(playerNumber+1);
                    menu = 2;
                } catch (FileNotFoundException file) {
                    view.noLoad();
                }

            } else if (input.equals("Load Game 2")){

                try {
                    BufferedReader in = new BufferedReader(new FileReader("SaveBoard2.ser"));
                    model= saveLoad.loadBoard(2);

                    view.mainScreen();
                    playerNumber=saveLoad.loadPlayerNum(2);

                    view.playerTurn(playerNumber+1);
                    menu = 2;
                } catch (FileNotFoundException file) {
                    view.noLoad();
                }

            } else if(input.equals("Load Game 3")){

                try {
                    BufferedReader in = new BufferedReader(new FileReader("SaveBoard3.ser"));
                    model= saveLoad.loadBoard(3);

                    view.mainScreen();
                    playerNumber=saveLoad.loadPlayerNum(3);

                    view.playerTurn(playerNumber+1);
                    menu = 2;
                } catch (FileNotFoundException file) {
                    view.noLoad();
                }
            } else if(input.equals("Create Custom Map")){
                view.customMap();
                customMap = true;

                int numOfCont= view.numberOfContinent();

                for(int i=0; i<numOfCont;i++){
                    String continentName=view.continentName();
                    int numOfBonus = view.bonusContinent();

                    while(numOfBonus<0 || numOfBonus >5){
                        view.toManyArmy();
                        numOfBonus = view.bonusContinent();
                    }
                    continents.add(new Continent(continentName,numOfBonus));
                }
            }
        }
    }


    /**
     * This method is a delegate method of actionPerformed, and will handle any events that occur on the menu bar in
     * the GUI
     * @param e An action event which is generated anytime something on the view occurs
     */
    private void jMenuBarPerformed(ActionEvent e) throws IOException {
        String input;

        JMenuItem placeHolder = (JMenuItem) e.getSource();
        input = placeHolder.getText();
        System.out.println(input);

        if (input.equals("Rules")) {
            view.showRules();
        } else if (input.equals("Map State")) {
            temp="";
            info="";
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
        } else if(input.equals("Save")){

            int saveValue = view.saveValue();

            while(saveValue<1 || saveValue>3){
                view.invalidSave();
                saveValue=view.saveValue();
            }
                saveLoad.saveBoard(model,saveValue);
                saveLoad.savePlayerNum(playerNumber,saveValue);
                view.saveConfirmed();

        } else if(input.equals("Add Country")){
                countryName = view.addCountry().toUpperCase();

                while(countries.contains(countryName)) {
                    view.countryExists();
                    countryName= view.addCountry().toUpperCase();
                }

                countries.add(countryName);
                Country c1 = new Country(countryName);
                countriesBoard.add(c1);

                CustomCountry m1 = new CustomCountry(countryName);

                view.addNewCountry(m1);

                continentName = view.continent();

                int indexContinent= mapContinentToIndex(continentName);


                while(indexContinent==-1){
                    view.continentNotExist();
                    continentName= view.continent();
                }

                indexContinent= mapContinentToIndex(continentName);
                continents.get(indexContinent).addCountry(c1);
                c1.setContinent(continentName);

        } else if (input.equals("Done")){
                view.AdjacentRules();

                for(int i =0; i<countries.size();i++){
                    int numAdjacent= view.numAdjacent(countries.get(i));

                    for(int j =0; j<numAdjacent; j++){
                        String countryAdjacent = view.countryAdjacent(countries.get(i)).toUpperCase();

                        while(!countries.contains(countryAdjacent)){
                            view.countryNotExists();
                            countryAdjacent = view.countryAdjacent(countries.get(i)).toUpperCase();
                        }
                        countriesBoard.get(i).setAdjacentCountries(countriesBoard.get(mapCountryToIndex(countryAdjacent)));
                    }
                }

                customMap=true;

                if (checkValidMap()) {
                    view.createNumOfPlayers();
                } else {
                    view.notValidMap();
                }

               /* model = new Board(continents,countriesBoard);

                if(model.validMap()==true){
                view.createNumOfPlayers();

                }else{
                view.notValidMap();
                //ADD EXIT
                }*/


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
                if (customMap) {
                    //model = new Board(continents,countriesBoard,numPlayers);

                } else {
                    model = new Board(numPlayers);
                }

                //view.selectAi(numPlayers);
                model.setAi(view.selectAi(numPlayers));
                view.mainScreen();
                view.gameShallBegin();
                menu = 2;
                playerNumber=0;


                if (!model.playerArray.get(playerNumber).isPlayerAi()) {

                    //Assign bonus armies (3 or more)
                    int newArmies = (model.playerArray.get(playerNumber).getCountrySizes() / 3);
                    model.playerArray.get(playerNumber).increaseArmyCount(newArmies);

                    view.bonusArmies(model.playerArray.get(playerNumber).getName(),newArmies);

                    for(int b = 0; b < newArmies; b++) {

                        temp2="";
                        info2="";
                        for (Player p : model.playerArray) {
                            temp2 = "\n" + p.getName() + " rules:\n";
                            info2 = info2.concat(temp2);
                            info2 = info2.concat(p.getRuledCountriesInfo());
                        }
                        view.stateOfTheMap(info2);

                        String country = view.addArmyToCountry().toUpperCase();
                        int g = model.mapCountryToIndex(country);
                        System.out.print(country);
                        //System.out.print(model.playerArray.get(playerNumber).getRuledCountriesInfo());

                        while (model.playerArray.get(playerNumber).ownsCountry(country) == false || g == -1) {

                            if (g == -1) {
                                view.invalidValue();
                                country = view.addArmyToCountry().toUpperCase();
                                g = model.mapCountryToIndex(country);

                            } else {
                                view.notRuler();

                                temp2="";
                                info2="";
                                for (Player p : model.playerArray) {
                                    temp2 = "\n" + p.getName() + " rules:\n";
                                    info2 = info2.concat(temp2);
                                    info2 = info2.concat(p.getRuledCountriesInfo());
                                }
                                view.stateOfTheMap(info2);

                                country = view.addArmyToCountry().toUpperCase();
                                g = model.mapCountryToIndex(country);

                            }

                        }
                        model.getCountries(g).increaseArmyCount(1);
                        int newNum= newArmies-b-1;
                        if(newNum!=0){
                            view.addAdditionalArmies(model.playerArray.get(playerNumber).getName(),newNum);
                        }else {
                        view.bonusArmySuccess();
                    }

                    }
                } else {
                    aiPlayerLoop();

                    temp1="";
                    info1="";
                    for (Player p : model.playerArray) {
                        temp1 = "\n" + p.getName() + " rules:\n";
                        info1 = info1.concat(temp1);
                        info1 = info1.concat(p.getRuledCountriesInfo());
                    }
                    view.stateOfTheMap(info1);

                    //Continent Bonus
                    int newArmies =0;
                    ArrayList<String> continentOwned;
                    continentOwned=model.ownContinent(playerNumber);

                    if(continentOwned.size()>0){
                        for(int i =0;i<continentOwned.size();i++){
                            newArmies= newArmies + model.continentBonus(continentOwned.get(i));
                        }
                    }

                    //Assign bonus armies (3 or more)
                    newArmies = (model.playerArray.get(playerNumber).getCountrySizes() / 3);
                    model.playerArray.get(playerNumber).increaseArmyCount(newArmies);

                    view.bonusArmies(model.playerArray.get(playerNumber).getName(),newArmies);

                    for(int b = 0; b < newArmies; b++) {

                        temp2 = "";
                        info2 = "";
                        for (Player p : model.playerArray) {
                            temp2 = "\n" + p.getName() + " rules:\n";
                            info2 = info2.concat(temp2);
                            info2 = info2.concat(p.getRuledCountriesInfo());
                        }
                        view.stateOfTheMap(info2);

                        String country = view.addArmyToCountry().toUpperCase();
                        int g = model.mapCountryToIndex(country);
                        System.out.print(country);
                        //System.out.print(model.playerArray.get(playerNumber).getRuledCountriesInfo());

                        while (model.playerArray.get(playerNumber).ownsCountry(country) == false || g == -1) {

                            if (g == -1) {
                                view.invalidValue();
                                country = view.addArmyToCountry().toUpperCase();
                                g = model.mapCountryToIndex(country);
                            } else {
                                view.notRuler();

                                temp2="";
                                info2="";
                                for (Player p : model.playerArray) {
                                    temp2 = "\n" + p.getName() + " rules:\n";
                                    info2 = info2.concat(temp2);
                                    info2 = info2.concat(p.getRuledCountriesInfo());
                                }
                                view.stateOfTheMap(info2);

                                country = view.addArmyToCountry().toUpperCase();
                                g = model.mapCountryToIndex(country);

                            }

                        }
                        model.getCountries(g).increaseArmyCount(1);
                        int newNum = newArmies - b - 1;
                        if (newNum != 0) {
                            view.addAdditionalArmies(model.playerArray.get(playerNumber).getName(), newNum);
                        } else {
                            view.bonusArmySuccess();
                        }

                    }
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

                    //Troupe Movement
                    String troupe = view.troupeMovement();

                    if (troupe.equals("yes")) {
                        String countryA = view.troupeCountryA().toUpperCase();
                        int a = model.mapCountryToIndex(countryA);

                        //Check if first country is valid/owned by the player
                        while (model.playerArray.get(playerNumber).ownsCountry(countryA) == false || a == -1) {
                            if (a == -1) {
                                view.invalidValue();
                                countryA = view.troupeCountryA().toUpperCase();
                                a = model.mapCountryToIndex(countryA);
                            } else {
                                view.notRuler();
                                countryA = view.troupeCountryA().toUpperCase();
                                a = model.mapCountryToIndex(countryA);
                            }
                        }

                        String countryB = view.troupeCountryB().toUpperCase();
                        int b = model.mapCountryToIndex(countryB);

                        //Check if second country is valid/owned by the player and that the same country was not entered
                        while (model.playerArray.get(playerNumber).ownsCountry(countryB) == false || b == -1 || b == a) {

                            if (b == -1) {
                                view.invalidValue();
                                countryB = view.troupeCountryB().toUpperCase();
                                b = model.mapCountryToIndex(countryB);
                            } else if (b == a) {
                                view.bothSameCountry();
                                countryB = view.troupeCountryB().toUpperCase();
                                b = model.mapCountryToIndex(countryB);

                            } else {
                                view.notRuler();
                                countryB = view.troupeCountryB().toUpperCase();
                                b = model.mapCountryToIndex(countryB);
                            }
                        }


                        int numOfTroupeArmies = view.numOfTroupeArmies();

                        //Check number of armies given is valid(according to rules)
                        while (numOfTroupeArmies > model.getCountries(a).getArmies() || numOfTroupeArmies == model.getCountries(a).getArmies() - 1) {

                            //check if armies is not greater than armies owned in country
                            if (numOfTroupeArmies > model.getCountries(a).getArmies()) {
                                view.armiesGreater();
                                numOfTroupeArmies = view.numOfTroupeArmies();

                                //Must leave 1 army behind in the country that they are moving armies from
                            } else {
                                view.leaveOne();
                                numOfTroupeArmies = view.numOfTroupeArmies();
                            }
                        }

                        //Call Troupe Movement
                        String r = model.runDFS(countryA, countryB);

                        if (r == "t") {
                            view.TroupeDone();
                            model.getCountries(model.mapCountryToIndex(countryA)).decreaseArmyCount(numOfTroupeArmies);
                            model.getCountries(model.mapCountryToIndex(countryB)).increaseArmyCount(numOfTroupeArmies);
                        } else {
                            view.noTroupeDone();
                        }
                    }

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

                    if (!model.playerArray.get(playerNumber).isPlayerAi()) {


                        //Continent Bonus
                        int newArmies =0;
                        ArrayList<String> continentOwned;
                        continentOwned=model.ownContinent(playerNumber);

                        if(continentOwned.size()>0){
                            for(int i =0;i<continentOwned.size();i++){
                                newArmies= newArmies + model.continentBonus(continentOwned.get(i));
                            }
                        }

                        //Assign bonus armies (3 or more)
                        newArmies = (model.playerArray.get(playerNumber).getCountrySizes() / 3) + newArmies;
                        model.playerArray.get(playerNumber).increaseArmyCount(newArmies);

                        view.bonusArmies(model.playerArray.get(playerNumber).getName(),newArmies);

                        for(int b = 0; b < newArmies; b++) {

                            info1="";
                            temp1="";
                            for (Player p : model.playerArray) {
                                temp1 = "\n" + p.getName() + " rules:\n";
                                info1 = info1.concat(temp1);
                                info1 = info1.concat(p.getRuledCountriesInfo());
                            }
                            view.stateOfTheMap(info1);
                            String country = view.addArmyToCountry().toUpperCase();
                            int g = model.mapCountryToIndex(country);

                            while(model.playerArray.get(playerNumber).ownsCountry(country)==false || g==-1){

                                if(g==-1){
                                    view.invalidValue();
                                    country = view.addArmyToCountry().toUpperCase();
                                    g=model.mapCountryToIndex(country);
                                }else{
                                    view.notRuler();

                                    temp2="";
                                    info2="";
                                    for (Player p : model.playerArray) {
                                        temp2 = "\n" + p.getName() + " rules:\n";
                                        info2 = info2.concat(temp2);
                                        info2 = info2.concat(p.getRuledCountriesInfo());
                                    }
                                    view.stateOfTheMap(info2);

                                    country = view.addArmyToCountry().toUpperCase();
                                    g=model.mapCountryToIndex(country);
                                }
                            }
                            model.getCountries(g).increaseArmyCount(1);
                            int newNum1= newArmies-b-1;
                            if(newNum1!=0){
                                view.addAdditionalArmies(model.playerArray.get(playerNumber).getName(),newNum1);
                            }else {
                                view.bonusArmySuccess();
                            }
                        }
                    } else {
                        aiPlayerLoop();
                        
                        temp1="";
                        info1="";
                        for (Player p : model.playerArray) {
                            temp1 = "\n" + p.getName() + " rules:\n";
                            info1 = info1.concat(temp1);
                            info1 = info1.concat(p.getRuledCountriesInfo());
                        }
                        view.stateOfTheMap(info1);

                        //Continent Bonus
                        int newArmies =0;
                        ArrayList<String> continentOwned;
                        continentOwned=model.ownContinent(playerNumber);

                        if(continentOwned.size()>0){
                            for(int i =0;i<continentOwned.size();i++){
                                newArmies= newArmies + model.continentBonus(continentOwned.get(i));
                            }
                        }

                        //Assign bonus armies (3 or more)
                        newArmies = (model.playerArray.get(playerNumber).getCountrySizes() / 3) + newArmies;
                        model.playerArray.get(playerNumber).increaseArmyCount(newArmies);

                        view.bonusArmies(model.playerArray.get(playerNumber).getName(),newArmies);

                        for(int b = 0; b < newArmies; b++) {

                            info1 = "";
                            temp1 = "";
                            for (Player p : model.playerArray) {
                                temp1 = "\n" + p.getName() + " rules:\n";
                                info1 = info1.concat(temp1);
                                info1 = info1.concat(p.getRuledCountriesInfo());
                            }
                            view.stateOfTheMap(info1);
                            String country = view.addArmyToCountry().toUpperCase();
                            int g = model.mapCountryToIndex(country);

                            while (model.playerArray.get(playerNumber).ownsCountry(country) == false || g == -1) {

                                if (g == -1) {
                                    view.invalidValue();
                                    country = view.addArmyToCountry().toUpperCase();
                                    g = model.mapCountryToIndex(country);
                                } else {
                                    view.notRuler();

                                    temp2="";
                                    info2="";
                                    for (Player p : model.playerArray) {
                                        temp2 = "\n" + p.getName() + " rules:\n";
                                        info2 = info2.concat(temp2);
                                        info2 = info2.concat(p.getRuledCountriesInfo());
                                    }
                                    view.stateOfTheMap(info2);

                                    country = view.addArmyToCountry().toUpperCase();
                                    g = model.mapCountryToIndex(country);

                                }
                            }
                            model.getCountries(g).increaseArmyCount(1);
                            int newNum1 = newArmies - b - 1;
                            if (newNum1 != 0) {
                                view.addAdditionalArmies(model.playerArray.get(playerNumber).getName(), newNum1);
                            } else {
                                view.bonusArmySuccess();
                            }
                        }
                    }


                }
                //System.out.println(playerNumber);


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

    private void aiPlayerLoop() {
        int newArmies =0;
        ArrayList<String> continentOwned;
        continentOwned=model.ownContinent(playerNumber);

        if(continentOwned.size()>0){
            for(int i =0;i<continentOwned.size();i++){
                newArmies= newArmies + model.continentBonus(continentOwned.get(i));
            }
        }

        //Assign bonus armies (3 or more)
        newArmies = (model.playerArray.get(playerNumber).getCountrySizes() / 3) + newArmies;
        //model.playerArray.get(playerNumber).increaseArmyCount(newArmies);
        String aiMove = "";

        for (int i = 0; i < newArmies; i++) {
            aiMove = aiMove.concat(model.aiAddBonusArmies(playerNumber) + "\n");
        }

        aiMove = aiMove.concat(model.aiAttackMove(playerNumber));
        view.aiPlayerMoves(aiMove);
        if (playerNumber == (model.playerArray.size() - 1)) {
            playerNumber = 0;
        } else {
            playerNumber++;
        }
        view.passForSure(playerNumber + 1);

        if (model.playerArray.get(playerNumber).isPlayerAi()) {
            aiPlayerLoop();
        }
    }

    public int mapContinentToIndex(String continent) {
        int i;
        for (i = 0; i < continents.size(); i++) {
            if (continents.get(i).getName().equals(continent)) {
                return i;
            }
        }
        return -1;
    }

    public int mapCountryToIndex(String country) {
        int i;
        for (i = 0; i < countries.size(); i++) {
            if (countriesBoard.get(i).getName().equals(country)) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkValidMap(){
        ArrayList<String> continentList = new ArrayList<>();

        for(int i=0; i< continents.size();i++){

            for(int j=0; j<continents.get(i).getSize();j++){

                for (int k = 0; k < continents.get(i).getCountries().get(j).getAdjacentCountries().size(); k++) {
                    if (!continentList.contains(continents.get(i).getCountries().get(j).getAdjacentCountries().get(k).getContinent())) {
                        continentList.add(continents.get(i).getCountries().get(j).getAdjacentCountries().get(k).getContinent());
                    }
                }

            }
        }

        if (continentList.size() == continents.size()) {
            return true;
        } else {
            return false;
        }
    }


}
