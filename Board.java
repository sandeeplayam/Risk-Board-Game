import java.util.ArrayList;

public class Board {

    private Country[] countries = new Country[42];
    private ArrayList<Continent> continents;
    int players;

    public Board(int players) {

    }

    //private createPlayer() {} Danish

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

    //private setInitialArmies() {} Danish

    //private setInitialRulers() {} Danish

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

        //setting adjacent countries for
        countries[5].setAdjacentCountries(countries[6]);
        countries[5].setAdjacentCountries(countries[12]);
        countries[5].setAdjacentCountries(countries[1]);
        countries[5].setAdjacentCountries(countries[1]);
        countries[5].setAdjacentCountries(countries[1]);
    }

    //public getAdjacentCountries() {} Sandeep

    //public ArrayList<Continent> getContinent() {} Sandeep

    //public ArrayList<Country> getCountriesByContinent(String continent) {} Sandeep

    //public ArrayList<Country> getCountries() {} Sandeep
}
