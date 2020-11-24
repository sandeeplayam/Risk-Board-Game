
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Sudarsana Sandeep, Danish Butt
 * The Board class is the Model in the MVC pattern for this project,
 * and is where most of the data manipulation and game logic occurs.
 */
public class Board {

    private final Country[] countries = new Country[42];
    private final ArrayList<Continent> continents;
    public ArrayList<Player> playerArray;
    private Dice red1, red2, red3, white1, white2;


    /**
     * The constructor for the board class which takes an integer as a parameter to initialize the board with that
     * amount of players.
     *
     * @param players An integer which lets the board know the number of player
     */
    public Board(int players) {

        continents = new ArrayList<>();
        playerArray = new ArrayList<>();
        createPlayer(players);
        createCountries();
        createContinents();
        setAdjacentCountries();
        setInitialArmies(players);
        setInitialRulers(players);
        red1 = new Dice();
        red2 = new Dice();
        red3 = new Dice();
        white1 = new Dice();
        white2 = new Dice();
    }


    /**
     * This method creates all the player objects required for the game and adds them all to an arraylist
     *
     * @param players An integer which indicates the amount of players playing
     */
    private void createPlayer(int players) {
        int i;

        for (i = 0; i < players; i++) {

            if (players == 2) {
                playerArray.add(new Player("Player " + (i + 1), 50));

            } else if (players == 3) {
                playerArray.add(new Player("Player " + (i + 1), 35));

            } else if (players == 4) {
                playerArray.add(new Player("Player " + (i + 1), 30));

            } else if (players == 5) {
                playerArray.add(new Player("Player " + (i + 1), 25));

            } else if (players == 6) {
                playerArray.add(new Player("Player " + (i + 1), 20));
            }
        }
    }


    /**
     * This method creates all the country objects required for the game and places them into an array
     */
    private void createCountries() {

        //Australia
        countries[0] = new Country("Eastern Australia");
        countries[1] = new Country("Indonesia");
        countries[2] = new Country("New Guinea");
        countries[3] = new Country("Western Australia");

        //Asia
        countries[4] = new Country("Afghanistan");
        countries[5] = new Country("China");
        countries[6] = new Country("India");
        countries[7] = new Country("Irkutsk");
        countries[8] = new Country("Japan");
        countries[9] = new Country("Kamchatka");
        countries[10] = new Country("Middle East");
        countries[11] = new Country("Mongolia");
        countries[12] = new Country("Siam");
        countries[13] = new Country("Siberia");
        countries[14] = new Country("Ural");
        countries[15] = new Country("Yakutsk");

        //Africa
        countries[16] = new Country("Congo");
        countries[17] = new Country("East Africa");
        countries[18] = new Country("Egypt");
        countries[19] = new Country("Madagascar");
        countries[20] = new Country("North Africa");
        countries[21] = new Country("South Africa");

        //Europe
        countries[22] = new Country("Great Britain");
        countries[23] = new Country("Iceland");
        countries[24] = new Country("Northern Europe");
        countries[25] = new Country("Scandinavia");
        countries[26] = new Country("Southern Europe");
        countries[27] = new Country("Ukraine");
        countries[28] = new Country("Western Europe");

        //South America
        countries[29] = new Country("Argentina");
        countries[30] = new Country("Brazil");
        countries[31] = new Country("Peru");
        countries[32] = new Country("Venezuela");

        //North America
        countries[33] = new Country("Alaska");
        countries[34] = new Country("Alberta");
        countries[35] = new Country("Central America");
        countries[36] = new Country("Eastern United States");
        countries[37] = new Country("Greenland");
        countries[38] = new Country("Northwest Territories");
        countries[39] = new Country("Ontario");
        countries[40] = new Country("Quebec");
        countries[41] = new Country("Western United States");
    }


    /**
     * This method creates all the continent objects in the game and add them to an arraylist
     */
    private void createContinents() {

        //Australia
        continents.add(new Continent("Australia", 2));

        //Asia
        continents.add(new Continent("Asia", 7));

        //Africa
        continents.add(new Continent("Africa", 3));

        //Europe
        continents.add(new Continent("Europe", 5));

        //South America
        continents.add(new Continent("South America", 2));

        //North America
        continents.add(new Continent("North America", 5));

        //Adding all countries in Australia to the continent
        for (int j = 0; j < 4; j++) {
            continents.get(0).addCountry(countries[j]);
        }

        //Adding all countries in Asia to the continent
        for (int j = 4; j < 16; j++) {
            continents.get(1).addCountry(countries[j]);
        }

        //Adding all countries in Africa to the continent
        for (int j = 16; j < 22; j++) {
            continents.get(2).addCountry(countries[j]);
        }

        //Adding all countries in Europe to the continent
        for (int j = 22; j < 29; j++) {
            continents.get(3).addCountry(countries[j]);
        }

        //Adding all countries in South America to the continent
        for (int j = 29; j < 33; j++) {
            continents.get(4).addCountry(countries[j]);
        }

        //Adding all countries in North America to the continent
        for (int j = 33; j < 42; j++) {
            continents.get(5).addCountry(countries[j]);
        }
    }


    /**
     * Since our implementation of the game is always auto setup, this method sets up the initial armies for each
     * player based on the amount of players that are playing
     *
     * @param players An integer which lets the board know the number of player
     */
    private void setInitialArmies(int players) {
        int i;

        if (players == 2) {
            for (i = 0; i < 26; i++) {
                countries[i].increaseArmyCount(2);
            }
            for (i = 26; i < 42; i++) {
                countries[i].increaseArmyCount(3);
            }
        } else if (players == 3) {
            for (i = 0; i < 21; i++) {
                countries[i].increaseArmyCount(3);
            }
            for (i = 21; i < 42; i++) {
                countries[i].increaseArmyCount(2);
            }
        } else if (players == 4) {
            for (i = 0; i < 36; i++) {
                countries[i].increaseArmyCount(3);
            }
            countries[36].increaseArmyCount(2);
            countries[37].increaseArmyCount(2);
            countries[38].increaseArmyCount(3);
            countries[39].increaseArmyCount(3);
            countries[40].increaseArmyCount(1);
            countries[41].increaseArmyCount(1);

        } else if (players == 5) {
            for (i = 0; i < 35; i++) {
                countries[i].increaseArmyCount(3);
            }
            countries[35].increaseArmyCount(2);
            countries[36].increaseArmyCount(2);
            countries[37].increaseArmyCount(4);
            countries[38].increaseArmyCount(4);
            countries[39].increaseArmyCount(4);
            countries[40].increaseArmyCount(2);
            countries[41].increaseArmyCount(2);
        } else if (players == 6) {
            for (i = 0; i < 36; i++) {
                countries[i].increaseArmyCount(3);
            }
            for (i = 36; i < 42; i++) {
                countries[i].increaseArmyCount(2);
            }
        }
    }


    /**
     * Since our implementation of the game is always auto setup, this method sets up the initial rulers/owners of each
     * country
     *
     * @param players An integer which lets the board know the number of player
     */
    private void setInitialRulers(int players) {
        int i;
        int playerNum = 0;
        for (i = 0; i < 42; i++) {
            playerArray.get(playerNum).addCountry(countries[i]);
            countries[i].setRuler(playerArray.get(playerNum));
            playerNum = (playerNum + 1) % players;
        }
    }


    /**
     * This method sets all the adjacent countries for every single country object on the map
     */
    private void setAdjacentCountries() {

        //setting adjacent countries for Eastern Australia
        countries[0].setAdjacentCountries(countries[2]);
        countries[0].setAdjacentCountries(countries[3]);

        //setting adjacent countries for Indonesia
        countries[1].setAdjacentCountries(countries[2]);
        countries[1].setAdjacentCountries(countries[3]);

        //setting adjacent countries for New Guinea
        countries[2].setAdjacentCountries(countries[0]);
        countries[2].setAdjacentCountries(countries[1]);
        countries[2].setAdjacentCountries(countries[3]);

        //setting adjacent countries for Western Australia
        countries[3].setAdjacentCountries(countries[0]);
        countries[3].setAdjacentCountries(countries[1]);
        countries[3].setAdjacentCountries(countries[2]);

        //setting adjacent countries for Afghanistan
        countries[4].setAdjacentCountries(countries[5]);
        countries[4].setAdjacentCountries(countries[6]);
        countries[4].setAdjacentCountries(countries[10]);
        countries[4].setAdjacentCountries(countries[14]);
        countries[4].setAdjacentCountries(countries[27]);

        //setting adjacent countries for China
        countries[5].setAdjacentCountries(countries[6]);
        countries[5].setAdjacentCountries(countries[12]);
        countries[5].setAdjacentCountries(countries[1]);
        countries[5].setAdjacentCountries(countries[11]);
        countries[5].setAdjacentCountries(countries[13]);
        countries[5].setAdjacentCountries(countries[14]);

        //setting adjacent countries for India
        countries[6].setAdjacentCountries(countries[4]);
        countries[6].setAdjacentCountries(countries[5]);
        countries[6].setAdjacentCountries(countries[10]);
        countries[6].setAdjacentCountries(countries[12]);

        //setting adjacent countries for Irkutsk
        countries[7].setAdjacentCountries(countries[9]);
        countries[7].setAdjacentCountries(countries[11]);
        countries[7].setAdjacentCountries(countries[13]);
        countries[7].setAdjacentCountries(countries[15]);

        //setting adjacent countries for Japan
        countries[8].setAdjacentCountries(countries[9]);
        countries[8].setAdjacentCountries(countries[11]);

        //setting adjacent countries for Kamchatka
        countries[9].setAdjacentCountries(countries[7]);
        countries[9].setAdjacentCountries(countries[8]);
        countries[9].setAdjacentCountries(countries[11]);
        countries[9].setAdjacentCountries(countries[15]);
        countries[9].setAdjacentCountries(countries[33]);

        //setting adjacent countries for Middle East
        countries[10].setAdjacentCountries(countries[4]);
        countries[10].setAdjacentCountries(countries[6]);
        countries[10].setAdjacentCountries(countries[17]);
        countries[10].setAdjacentCountries(countries[18]);
        countries[10].setAdjacentCountries(countries[26]);
        countries[10].setAdjacentCountries(countries[27]);

        //setting adjacent countries for Mongolia
        countries[11].setAdjacentCountries(countries[5]);
        countries[11].setAdjacentCountries(countries[7]);
        countries[11].setAdjacentCountries(countries[8]);
        countries[11].setAdjacentCountries(countries[9]);
        countries[11].setAdjacentCountries(countries[13]);

        //setting adjacent countries for Siam
        countries[12].setAdjacentCountries(countries[1]);
        countries[12].setAdjacentCountries(countries[5]);
        countries[12].setAdjacentCountries(countries[6]);

        //setting adjacent countries for Siberia
        countries[13].setAdjacentCountries(countries[5]);
        countries[13].setAdjacentCountries(countries[7]);
        countries[13].setAdjacentCountries(countries[11]);
        countries[13].setAdjacentCountries(countries[14]);
        countries[13].setAdjacentCountries(countries[15]);

        //setting adjacent countries for Ural
        countries[14].setAdjacentCountries(countries[4]);
        countries[14].setAdjacentCountries(countries[5]);
        countries[14].setAdjacentCountries(countries[13]);
        countries[14].setAdjacentCountries(countries[27]);

        //setting adjacent countries for Yakutsk
        countries[15].setAdjacentCountries(countries[7]);
        countries[15].setAdjacentCountries(countries[9]);
        countries[15].setAdjacentCountries(countries[13]);

        //setting adjacent countries for Congo
        countries[16].setAdjacentCountries(countries[17]);
        countries[16].setAdjacentCountries(countries[20]);
        countries[16].setAdjacentCountries(countries[21]);

        //setting adjacent countries for East Africa
        countries[17].setAdjacentCountries(countries[16]);
        countries[17].setAdjacentCountries(countries[20]);
        countries[17].setAdjacentCountries(countries[21]);
        countries[17].setAdjacentCountries(countries[19]);
        countries[17].setAdjacentCountries(countries[10]);
        countries[17].setAdjacentCountries(countries[18]);

        //setting adjacent countries for Egypt
        countries[18].setAdjacentCountries(countries[26]);
        countries[18].setAdjacentCountries(countries[10]);
        countries[18].setAdjacentCountries(countries[17]);
        countries[18].setAdjacentCountries(countries[20]);

        //setting adjacent countries for Madagascar
        countries[19].setAdjacentCountries(countries[17]);
        countries[19].setAdjacentCountries(countries[21]);

        //setting adjacent countries for North Africa
        countries[20].setAdjacentCountries(countries[26]);
        countries[20].setAdjacentCountries(countries[28]);
        countries[20].setAdjacentCountries(countries[17]);
        countries[20].setAdjacentCountries(countries[16]);
        countries[20].setAdjacentCountries(countries[18]);
        countries[15].setAdjacentCountries(countries[30]);

        //setting adjacent countries for South Africa
        countries[21].setAdjacentCountries(countries[17]);
        countries[21].setAdjacentCountries(countries[16]);
        countries[21].setAdjacentCountries(countries[19]);

        //setting adjacent countries for Great Britain
        countries[22].setAdjacentCountries(countries[23]);
        countries[22].setAdjacentCountries(countries[24]);
        countries[22].setAdjacentCountries(countries[25]);
        countries[22].setAdjacentCountries(countries[28]);

        //setting adjacent countries for Iceland
        countries[23].setAdjacentCountries(countries[37]);
        countries[23].setAdjacentCountries(countries[22]);
        countries[23].setAdjacentCountries(countries[25]);

        //setting adjacent countries for Northern Europe
        countries[24].setAdjacentCountries(countries[22]);
        countries[24].setAdjacentCountries(countries[25]);
        countries[24].setAdjacentCountries(countries[28]);
        countries[24].setAdjacentCountries(countries[27]);
        countries[24].setAdjacentCountries(countries[26]);

        //setting adjacent countries for Scandinavia
        countries[25].setAdjacentCountries(countries[22]);
        countries[25].setAdjacentCountries(countries[23]);
        countries[25].setAdjacentCountries(countries[27]);
        countries[25].setAdjacentCountries(countries[24]);

        //setting adjacent countries for Southern Europe
        countries[26].setAdjacentCountries(countries[18]);
        countries[26].setAdjacentCountries(countries[20]);
        countries[26].setAdjacentCountries(countries[10]);
        countries[26].setAdjacentCountries(countries[24]);
        countries[26].setAdjacentCountries(countries[27]);
        countries[26].setAdjacentCountries(countries[28]);

        //setting adjacent countries for Ukraine
        countries[27].setAdjacentCountries(countries[4]);
        countries[27].setAdjacentCountries(countries[10]);
        countries[27].setAdjacentCountries(countries[14]);
        countries[27].setAdjacentCountries(countries[24]);
        countries[27].setAdjacentCountries(countries[25]);
        countries[27].setAdjacentCountries(countries[26]);

        //setting adjacent countries for Western Europe
        countries[28].setAdjacentCountries(countries[20]);
        countries[28].setAdjacentCountries(countries[26]);
        countries[28].setAdjacentCountries(countries[24]);
        countries[28].setAdjacentCountries(countries[22]);

        //setting adjacent countries for Argentina
        countries[29].setAdjacentCountries(countries[30]);
        countries[29].setAdjacentCountries(countries[31]);

        //setting adjacent countries for Brazil
        countries[30].setAdjacentCountries(countries[29]);
        countries[30].setAdjacentCountries(countries[31]);
        countries[30].setAdjacentCountries(countries[32]);
        countries[30].setAdjacentCountries(countries[24]);

        //setting adjacent countries for Peru
        countries[31].setAdjacentCountries(countries[29]);
        countries[31].setAdjacentCountries(countries[30]);
        countries[31].setAdjacentCountries(countries[32]);

        //setting adjacent countries for Venezuela
        countries[32].setAdjacentCountries(countries[30]);
        countries[32].setAdjacentCountries(countries[31]);
        countries[32].setAdjacentCountries(countries[35]);

        //setting adjacent countries for Alaska
        countries[33].setAdjacentCountries(countries[34]);
        countries[33].setAdjacentCountries(countries[38]);
        countries[33].setAdjacentCountries(countries[9]);

        //setting adjacent countries for Alberta
        countries[34].setAdjacentCountries(countries[33]);
        countries[34].setAdjacentCountries(countries[38]);
        countries[34].setAdjacentCountries(countries[39]);
        countries[34].setAdjacentCountries(countries[41]);

        //setting adjacent countries for Central America
        countries[35].setAdjacentCountries(countries[32]);
        countries[35].setAdjacentCountries(countries[36]);
        countries[35].setAdjacentCountries(countries[41]);

        //setting adjacent countries for Eastern United States
        countries[36].setAdjacentCountries(countries[35]);
        countries[36].setAdjacentCountries(countries[39]);
        countries[36].setAdjacentCountries(countries[40]);
        countries[36].setAdjacentCountries(countries[41]);

        //setting adjacent countries for Greenland
        countries[37].setAdjacentCountries(countries[23]);
        countries[37].setAdjacentCountries(countries[40]);
        countries[37].setAdjacentCountries(countries[39]);
        countries[37].setAdjacentCountries(countries[38]);

        //setting adjacent countries for Northwest Territories
        countries[38].setAdjacentCountries(countries[33]);
        countries[38].setAdjacentCountries(countries[34]);
        countries[38].setAdjacentCountries(countries[39]);
        countries[38].setAdjacentCountries(countries[37]);

        //setting adjacent countries for Ontario
        countries[39].setAdjacentCountries(countries[38]);
        countries[39].setAdjacentCountries(countries[40]);
        countries[39].setAdjacentCountries(countries[41]);
        countries[39].setAdjacentCountries(countries[34]);
        countries[39].setAdjacentCountries(countries[36]);
        countries[39].setAdjacentCountries(countries[37]);

        //setting adjacent countries for Quebec
        countries[40].setAdjacentCountries(countries[37]);
        countries[40].setAdjacentCountries(countries[39]);
        countries[40].setAdjacentCountries(countries[36]);

        //setting adjacent countries for Western United States
        countries[41].setAdjacentCountries(countries[36]);
        countries[41].setAdjacentCountries(countries[34]);
        countries[41].setAdjacentCountries(countries[39]);
        countries[41].setAdjacentCountries(countries[35]);
    }


    /**
     * This method converts the name of a country into an index so that the country object can be retrieved when given
     * a String
     *
     * @param country
     * @return The index which represent a particular country in the array
     */
    public int mapCountryToIndex(String country) {
        int i;
        for (i = 0; i < countries.length; i++) {
            if (countries[i].getName().equals(country)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * This method retrieves the continent object from the arraylist when given a name as a String
     *
     * @param name String representation of the continent object
     * @return The continent object
     */
    public Continent getContinent(String name) {
        switch (name) {
            case "Australia":
                return continents.get(0);
            case "Asia":
                return continents.get(1);
            case "Africa":
                return continents.get(2);
            case "Europe":
                return continents.get(3);
            case "South America":
                return continents.get(4);
            default:
                return continents.get(5);
        }
    }


    /**
     * This method gets a country object from the array when given an index
     *
     * @param index An integer which will be used as a index in an array
     * @return Country object
     */

    public Country getCountries(int index) {
        return countries[index];
    }


    /**
     * This method checks if two countries are adjacent
     *
     * @param country  First country object
     * @param country2 Second country object
     * @return boolean True if adjacent, false otherwise
     */

    public boolean checkAdjacentCountries(Country country, Country country2) {
        return country.getAdjacentCountries().contains(country2);
    }


    /**
     * This is the method which handles the attack function in the game of Risk
     *
     * @param attackFrom Country that one is attacking from
     * @param attackTo   Country that is going to be attacked
     * @param attackDice Number of dice the attacker has chosen
     * @return String representation of the attack details
     */
    public String attack(String attackFrom, String attackTo, int attackDice) {
        String result = "";
        int a = mapCountryToIndex(attackFrom); //will be used to represent attacker
        int b = mapCountryToIndex(attackTo); //will be used represent defender
        int defendDice;
        int r1, r2, r3, w1, w2, reinforceNumber;
        Scanner s = new Scanner(System.in);

        if (countries[b].getArmies() >= 2) {
            defendDice = 2;
        } else {
            defendDice = 1;
        }

        if ((countries[a].getArmies() >= 2)) {
            if (attackDice == 1 && defendDice == 1) {
                r1 = red1.roll();
                w1 = white1.roll();
                if (r1 < w1) {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = countries[b].getRuler().getName() + " has won the attack";

                } else if (r1 > w1) {
                    countries[b].decreaseArmyCount(1);
                    countries[b].getRuler().decreaseArmyCount(1);
                    countries[a].increaseArmyCount(1);
                    countries[a].getRuler().increaseArmyCount(1);
                    result = (countries[a].getRuler().getName() + " has won the attack");
                } else {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = (countries[b].getRuler().getName() + " has won the attack");
                }
            } else if (attackDice == 2 && defendDice == 1) {
                r1 = red1.roll();
                r2 = red2.roll();
                w1 = white1.roll();
                if ((r1 > w1) || (r2 > w1)) {
                    countries[b].decreaseArmyCount(1);
                    countries[b].getRuler().decreaseArmyCount(1);
                    countries[a].increaseArmyCount(1);
                    countries[a].getRuler().increaseArmyCount(1);
                    result = (countries[a].getRuler().getName() + " has won the attack");
                } else if ((r1 < w1) && (r2 < w1)) {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = (countries[b].getRuler().getName() + " has won the attack");
                } else {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = (countries[b].getRuler().getName() + " has won the attack");
                }
            } else if (attackDice == 1 && defendDice == 2) {
                r1 = red1.roll();
                w2 = white2.roll();
                w1 = white1.roll();
                if ((r1 < w1) || (r1 < w2)) {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = (countries[b].getRuler().getName() + " has won the attack");
                } else if ((r1 > w1) && (r1 > w2)) {
                    countries[b].decreaseArmyCount(1);
                    countries[b].getRuler().decreaseArmyCount(1);
                    countries[a].increaseArmyCount(1);
                    countries[a].getRuler().increaseArmyCount(1);
                    result = (countries[a].getRuler().getName() + " has won the attack");
                } else {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = (countries[b].getRuler().getName() + " has won the attack");
                }
            } else if (attackDice == 2 && defendDice == 2) {
                r1 = red1.roll();
                r2 = red2.roll();
                w1 = white1.roll();
                w2 = white2.roll();
                int h1r, h2r, h1w, h2w;

                if (r1 > r2) {
                    h1r = r1;
                    h2r = r2;
                } else if (r2 > r1) {
                    h1r = r2;
                    h2r = r1;
                } else {
                    h1r = r1;
                    h2r = r2;
                }

                if (w1 > w2) {
                    h1w = w1;
                    h2w = w2;
                } else if (w2 > w1) {
                    h1w = w2;
                    h2w = w1;
                } else {
                    h1w = w1;
                    h2w = w2;
                }

                if (h1r > h1w) {
                    countries[b].decreaseArmyCount(1);
                    countries[b].getRuler().decreaseArmyCount(1);
                    countries[a].increaseArmyCount(1);
                    countries[a].getRuler().increaseArmyCount(1);
                    result = (countries[a].getRuler().getName() + " has won the first part of the attack");
                } else if (h1w > h1r) {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = (countries[b].getRuler().getName() + " has won the first part of the attack");
                } else {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = (countries[b].getRuler().getName() + " has won the first part of the attack");
                }

                if (h2r > h2w) {
                    countries[b].decreaseArmyCount(1);
                    countries[b].getRuler().decreaseArmyCount(1);
                    countries[a].increaseArmyCount(1);
                    countries[a].getRuler().increaseArmyCount(1);
                    result = result + " and " + (countries[a].getRuler().getName() + " has won the second part of the attack");
                } else if (h2w > h2r) {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = result + " and " + (countries[b].getRuler().getName() + " has won the second part of the attack");
                } else {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = result + " and " + (countries[b].getRuler().getName() + " has won the second part of the attack");
                }
            } else if (attackDice == 3 && defendDice == 1) {
                r1 = red1.roll();
                r2 = red2.roll();
                r3 = red3.roll();
                w1 = white1.roll();
                if ((r1 > w1) || (r2 > w1) || (r3 > w1)) {
                    countries[b].decreaseArmyCount(1);
                    countries[b].getRuler().decreaseArmyCount(1);
                    countries[a].increaseArmyCount(1);
                    countries[a].getRuler().increaseArmyCount(1);

                    result = (countries[a].getRuler().getName() + " has won the attack");

                } else if ((r1 < w1) && (r2 < w1) && (r3 < w1)) {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = (countries[b].getRuler().getName() + " has won the attack");
                } else {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = (countries[b].getRuler().getName() + " has won the attack");
                }
            } else if (attackDice == 3 && defendDice == 2) {
                r1 = red1.roll();
                r2 = red2.roll();
                r3 = red3.roll();
                w1 = white1.roll();
                w2 = white2.roll();
                int h1r, h2r, h3r, h1w, h2w;

                if (r1 > r2 && r1 > r3) {
                    h1r = r1;
                    if (r2 > r3) {
                        h2r = r2;
                        h3r = r3;
                    } else {
                        h2r = r3;
                        h3r = r2;
                    }
                } else if (r2 > r1 && r2 > r3) {
                    h1r = r2;
                    if (r1 > r3) {
                        h2r = r1;
                        h3r = r3;
                    } else {
                        h2r = r3;
                        h3r = r1;
                    }
                } else if (r3 > r1 && r3 > r2) {
                    h1r = r2;
                    if (r2 > r1) {
                        h2r = r2;
                        h3r = r1;
                    } else {
                        h2r = r1;
                        h3r = r2;
                    }
                } else {
                    h1r = r1;
                    h2r = r2;
                    h3r = r3;
                }

                if (w1 > w2) {
                    h1w = w1;
                    h2w = w2;
                } else if (w2 > w1) {
                    h1w = w2;
                    h2w = w1;
                } else {
                    h1w = w1;
                    h2w = w2;
                }

                if (h1r > h1w) {
                    countries[b].decreaseArmyCount(1);
                    countries[b].getRuler().decreaseArmyCount(1);
                    countries[a].increaseArmyCount(1);
                    countries[a].getRuler().increaseArmyCount(1);
                    result = (countries[a].getRuler().getName() + " has won the first part of the attack");
                } else if (h1w > h1r) {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = (countries[b].getRuler().getName() + " has won the first part of the attack");
                } else {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = (countries[b].getRuler().getName() + " has won the first part of the attack");
                }

                if (h2r > h2w) {
                    countries[b].decreaseArmyCount(1);
                    countries[b].getRuler().decreaseArmyCount(1);
                    countries[a].increaseArmyCount(1);
                    countries[a].getRuler().increaseArmyCount(1);
                    result = result + " and " + (countries[a].getRuler().getName() + " has won the second part of the attack");
                } else if (h2w > h2r) {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = result + " and " + (countries[b].getRuler().getName() + " has won the second part of the attack");
                } else {
                    countries[a].decreaseArmyCount(1);
                    countries[a].getRuler().decreaseArmyCount(1);
                    countries[b].increaseArmyCount(1);
                    countries[b].getRuler().increaseArmyCount(1);
                    result = result + " and " + (countries[b].getRuler().getName() + " has won the second part of the attack");
                }
            }

        }
        return result + "\n";
    }

    /**
     * This method handles the fortify function in the game
     *
     * @param moveFrom   Country that armies are being moved from
     * @param moveTo     Country that armies are being moved to
     * @param armyAmount Amount of armies being moved/fortified
     * @return String representation of fortify details
     */
    public String fortify(String moveFrom, String moveTo, int armyAmount) {
        int m = mapCountryToIndex(moveFrom);
        int n = mapCountryToIndex(moveTo);

        if (armyAmount + 1 <= countries[m].getArmies()) {

            countries[m].decreaseArmyCount(armyAmount);
            countries[n].increaseArmyCount(armyAmount);
            return "Successful Fortify \n";

        } else {
            return "Army transfer amount exceeds the amount of armies in the origin country.";
        }
    }

    /**
     * This method concatenates multiple strings which must be displayed when a country is conquered by a player
     *
     * @param c1
     * @param c2
     * @param dice Number of dice
     * @return
     */
    public String conquered(String c1, String c2, int dice) {
        String info;
        int a, b;
        a = mapCountryToIndex(c1);
        b = mapCountryToIndex(c2);

        info = (countries[b].getRuler().getName() + " you have no armies remaining in "
                + countries[b].getName());

        info = info + " " + (countries[a].getRuler().getName() + " has conquered your country.");

        countries[b].getRuler().removeCountry(countries[b]);
        countries[b].setRuler(countries[a].getRuler());
        countries[a].getRuler().addCountry(countries[b]);

        info = info + " " + (countries[a].getRuler().getName() + " you must reinforce the country you have just" +
                " conquered with a minimum of " + dice + " armies.");
        //System.out.println(info);
        return info;
    }

    public ArrayList<String> ownContinent(int player) {
        ArrayList<String> continent = new ArrayList<>();

        //Australia
        if (playerArray.get(player).ownsCountry(countries[0].getName()) && playerArray.get(player).ownsCountry(countries[1].getName())
                && playerArray.get(player).ownsCountry(countries[2].getName()) && playerArray.get(player).ownsCountry(countries[3].getName())) {

            continent.add("Australia");

            //Asia
        } else if (playerArray.get(player).ownsCountry(countries[4].getName()) && playerArray.get(player).ownsCountry(countries[5].getName())
                && playerArray.get(player).ownsCountry(countries[6].getName()) && playerArray.get(player).ownsCountry(countries[7].getName())
                && playerArray.get(player).ownsCountry(countries[8].getName()) && playerArray.get(player).ownsCountry(countries[9].getName())
                && playerArray.get(player).ownsCountry(countries[10].getName()) && playerArray.get(player).ownsCountry(countries[11].getName())
                && playerArray.get(player).ownsCountry(countries[12].getName()) && playerArray.get(player).ownsCountry(countries[13].getName())
                && playerArray.get(player).ownsCountry(countries[14].getName()) && playerArray.get(player).ownsCountry(countries[15].getName())) {

            continent.add("Asia");

            //Africa
        } else if (playerArray.get(player).ownsCountry(countries[16].getName()) && playerArray.get(player).ownsCountry(countries[17].getName())
                && playerArray.get(player).ownsCountry(countries[18].getName()) && playerArray.get(player).ownsCountry(countries[19].getName())
                && playerArray.get(player).ownsCountry(countries[20].getName()) && playerArray.get(player).ownsCountry(countries[21].getName())) {

            continent.add("Africa");

            //Europe
        } else if (playerArray.get(player).ownsCountry(countries[22].getName()) && playerArray.get(player).ownsCountry(countries[23].getName())
                && playerArray.get(player).ownsCountry(countries[24].getName()) && playerArray.get(player).ownsCountry(countries[25].getName())
                && playerArray.get(player).ownsCountry(countries[26].getName()) && playerArray.get(player).ownsCountry(countries[27].getName()) &&
                playerArray.get(player).ownsCountry(countries[28].getName())) {

            continent.add("Europe");

            //South America
        }else if(playerArray.get(player).ownsCountry(countries[29].getName()) && playerArray.get(player).ownsCountry(countries[30].getName())
                && playerArray.get(player).ownsCountry(countries[31].getName()) && playerArray.get(player).ownsCountry(countries[32].getName())){

            continent.add("South America");

            //North America
        }else if(playerArray.get(player).ownsCountry(countries[33].getName()) && playerArray.get(player).ownsCountry(countries[34].getName())
                && playerArray.get(player).ownsCountry(countries[35].getName()) && playerArray.get(player).ownsCountry(countries[36].getName())
                && playerArray.get(player).ownsCountry(countries[37].getName()) && playerArray.get(player).ownsCountry(countries[38].getName())
                && playerArray.get(player).ownsCountry(countries[39].getName()) && playerArray.get(player).ownsCountry(countries[40].getName())
                && playerArray.get(player).ownsCountry(countries[41].getName())){
            continent.add("North America");
        }
        return continent;
    }

    public int continentBonus(String continent){
        int armies=0;

        if(continent=="Australia"){
            armies= 2;
        }else if(continent=="Asia"){
            armies= 7;
        }else if(continent=="Africa"){
            armies= 3;
        }else if(continent=="Europe"){
            armies= 5;
        }else if(continent=="South America"){
            armies= 2;
        }else if (continent=="North America"){
            armies=5;
        }
        return armies;
    }

    public void setAi(ArrayList<Boolean> aiChoices) {
        int i = 0;
        for (Player p: playerArray) {
            if (aiChoices.get(i)) {
                p.setPlayerAsAi();
            }
            i++;
            //System.out.println("Is Player " + i + " AI?: " + p.isPlayerAi());
        }
    }

    public String aiAddBonusArmies(int currentPlayer) {
        float countryArmyCount, sum;
        float ratio, difference = 0, tempDifference;
        Country tempCountry, countryToIncrement = null;

        for (int i = 0; i < playerArray.get(currentPlayer).getCountrySizes(); i++) {
            tempCountry = playerArray.get(currentPlayer).getCountry(i);
            countryArmyCount = playerArray.get(currentPlayer).getCountry(i).getArmies();

            sum = 0;

            for (int j = 0; j < tempCountry.getAdjacentCountrySize(); j++) {
                sum = sum + tempCountry.getAdjacentCountries().get(j).getArmies();
            }

            ratio = sum / tempCountry.getAdjacentCountrySize();
            tempDifference = ratio - countryArmyCount;

            if (tempDifference >= difference) {
                difference = tempDifference;
                countryToIncrement = tempCountry;
            }
        }

        countryToIncrement.increaseArmyCount(1);

        return "AI Player " + (currentPlayer + 1) + " added an army to " + countryToIncrement.getName();
    }

    public String aiAttackMove(int currentPlayer) {
        String info = "";
        double ratio, difference = 0, tempDifference;
        Country tempMyCountry, tempEnemyCountry, myCountry = null, enemyCountry = null,
                bestToAttack = null, bestToAttackFrom = null;
        int numOfAttackDice = 0;

        Map<Country, Country> prospectCountriesToAttack = new HashMap<>();

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < playerArray.get(currentPlayer).getCountrySizes(); i++) {
                tempMyCountry = playerArray.get(currentPlayer).getCountry(i);

                if (tempMyCountry.getArmies() > 2) {
                    for (int j = 0; j < tempMyCountry.getAdjacentCountrySize(); j++) {

                        if (!tempMyCountry.getRuler().getName()
                                .equals(tempMyCountry.getAdjacentCountries().get(j).getRuler().getName())) {

                            tempEnemyCountry = tempMyCountry.getAdjacentCountries().get(j);
                            tempDifference = tempMyCountry.getArmies() - tempEnemyCountry.getArmies();

                            if (tempDifference >= difference) {
                                difference = tempDifference;
                                myCountry = tempMyCountry;
                                enemyCountry = tempEnemyCountry;
                            }
                        }

                    }
                    prospectCountriesToAttack.put(myCountry, enemyCountry);
                }

            }

            difference = 0;

            for (int i = 0; i < prospectCountriesToAttack.size(); i++) {

                tempMyCountry = playerArray.get(currentPlayer).getCountry(i);

                if (prospectCountriesToAttack.containsKey(tempMyCountry)) {

                    tempEnemyCountry = prospectCountriesToAttack.get(tempMyCountry);
                    tempDifference = tempMyCountry.getArmies() - tempEnemyCountry.getArmies();

                    if (tempDifference >= difference) {
                        difference = tempDifference;
                        bestToAttack = tempEnemyCountry;
                        bestToAttackFrom = tempMyCountry;
                    }
                }

            }

            //assert bestToAttackFrom != null;
            if (bestToAttackFrom.getArmies() > 3) {
                numOfAttackDice = 3;

                info = info.concat("AI Player " + (currentPlayer + 1) + " chose to attack " + bestToAttack.getName()
                        + " from " + bestToAttackFrom.getName() + " with " + numOfAttackDice + " armies" + "\n");

                info = info.concat(attack(bestToAttackFrom.getName(), bestToAttack.getName(), numOfAttackDice));

            } else if (bestToAttackFrom.getArmies() > 2) {
                numOfAttackDice = 2;

                info = info.concat("AI Player " + (currentPlayer + 1) + " chose to attack " + bestToAttack.getName()
                        + " from " + bestToAttackFrom.getName() + " with " + numOfAttackDice + " armies" + "\n");

                info = info.concat(attack(bestToAttackFrom.getName(), bestToAttack.getName(), numOfAttackDice));

            } else if (bestToAttackFrom.getArmies() == 2) {
                numOfAttackDice = 1;

                info = info.concat("AI Player " + (currentPlayer + 1) + " chose to attack " + bestToAttack.getName()
                        + " from " + bestToAttackFrom.getName() + " with " + numOfAttackDice + " armies" + "\n");

                info = info.concat(attack(bestToAttackFrom.getName(), bestToAttack.getName(), numOfAttackDice));
            }

            int index = mapCountryToIndex(bestToAttack.getName());
            bestToAttack = countries[index];
            index = mapCountryToIndex(bestToAttackFrom.getName());
            bestToAttackFrom = countries[index];

            if (bestToAttack.getArmies() == 0) {
                info = info.concat(conquered(bestToAttackFrom.getName(), bestToAttack.getName(), numOfAttackDice));
                info = info.concat(fortify(bestToAttackFrom.getName(), bestToAttack.getName(), numOfAttackDice));
            }

            prospectCountriesToAttack.clear();
//            bestToAttack = null;
//            bestToAttackFrom = null;

            aiFortifyMove(currentPlayer);
        }

        aiFortifyMove(currentPlayer);
        return info;
    }

    public String aiFortifyMove(int currentPlayer) {
        String info = "";
        Country originCountry, destCountry;

        for (int i = 0; i < playerArray.get(currentPlayer).getCountrySizes(); i++) {

            if (playerArray.get(currentPlayer).getCountry(i).getArmies() >= 3) {
                originCountry = playerArray.get(currentPlayer).getCountry(i);

                for (int j = 0; j < originCountry.getAdjacentCountrySize(); j++) {
                    destCountry = originCountry.getAdjacentCountries().get(j);

                    if (originCountry.getRuler().getName().equals(destCountry.getRuler().getName())) {
                        if ((destCountry.getArmies() < 2) && (originCountry.getArmies() >= 5)) {

                            info = info.concat(fortify(originCountry.getName(), destCountry.getName(), 2));
                            info = info.concat("AI Player " + (currentPlayer + 1) + " fortified from "
                                    + originCountry.getName() + " to " + destCountry.getName()
                                    + " with 2 armies");

                        } else if ((destCountry.getArmies() <= 2) && (originCountry.getArmies() >= 3)) {

                            info = info.concat(fortify(originCountry.getName(), destCountry.getName(), 1));
                            info = info.concat("AI Player " + (currentPlayer + 1) + " fortified from "
                                    + originCountry.getName() + " to " + destCountry.getName()
                                    + " with 1 army");

                        }
                    }

                }
            }
        }

        return info;
    }

    /**
     * This method performs a depth search path to find all possible paths from one country
     * to another country
     * @param CountryA
     * @param CountryB
     * @param visitedIndex
     * @param paths
     */
    public void dfsSearch(String CountryA, String CountryB, boolean[] visitedIndex, ArrayList<String> paths) {

        //Mark first country as visited
        int a = mapCountryToIndex(CountryA);
        visitedIndex[a] = true;

        int i;

        for (i = 0; i < countries[a].getAdjacentCountries().size(); i++) {
            System.out.println("H:" + i);

            if ((!visitedIndex[mapCountryToIndex(countries[a].getAdjacentCountries().get(i).getName())])
                    && (countries[a].getAdjacentCountries().get(i).getRuler().equals(countries[a].getRuler()))) {

                //if destination country reached
                if ((countries[a].getAdjacentCountries().get(i).getName().equals(CountryB))) {
                    paths.add("t");

                } else {
                    dfsSearch(countries[a].getAdjacentCountries().get(i).getName(), CountryB, visitedIndex, paths);
                }

            } else {
                paths.add("f");
            }
        }

    }

    /**
     * This method takes in 2 countries and runs the dfs search
     * It contains the paths array which will return which paths are valid (based on the
     * counties the player owns)
     * @param CountryA
     * @param CountryB
     * @return
     */
    public String runDFS(String CountryA, String CountryB){
        boolean[] visitedIndex= new boolean[42];
        ArrayList<String> paths = new ArrayList<>();
        String Result;

        dfsSearch(CountryA,CountryB,visitedIndex,paths);

        if(paths.contains("t")){
            return Result = "true";
        }else{
            return Result ="false";
        }

    }
}
