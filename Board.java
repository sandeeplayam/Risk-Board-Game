import java.util.ArrayList;

public class Board {

    private Country[] countries = new Country[42];
    private ArrayList<Continent> continents;
    public ArrayList<Player> playerArray;
    private int players;

    public Board(int players) {
        this.players=players;

        playerArray = new ArrayList<Player>();
        createPlayer(players);
    }

    private void createPlayer(int players) {
        int i;

        for(i=0;i<players;i++){

            if (players == 2) {
                playerArray.add(new Player("player" + Integer.toString(i+1), 50));

            }else if (players == 3) {
                playerArray.add(new Player("player" + Integer.toString(i+1), 35));

            } else if (players == 4) {
                playerArray.add(new Player("player" + Integer.toString(i+1), 30));

            }else if (players == 5) {
                playerArray.add(new Player("player" + Integer.toString(i+1), 25));

            }else if (players == 6) {
                playerArray.add(new Player("player" + Integer.toString(i+1), 20));
            }
        }
    }

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

    //private createContinents() {} Sandeep

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

    private void setInitialRulers(int players) {
        int i;
        int playerNum=0;
        for(i=0; i<42;i++ ){
            playerArray.get(playerNum).addCountry(countries[i]);
            countries[i].setRuler(playerArray.get(playerNum));
            playerNum= (playerNum +1) % players;
        }
    }

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

    public int mapCountryToIndex(String country) {
        int i;
        for(i = 0; i < countries.length; i++) {
            if(countries[i].getName().equals(country)) {
                return i;
            }
        }
        return -1;
    }

    //public getAdjacentCountries() {} Sandeep

    //public ArrayList<Continent> getContinent() {} Sandeep

    //public ArrayList<Country> getCountriesByContinent(String continent) {} Sandeep

    public Country getCountries(int index) {
        return countries[index];
    }
}
