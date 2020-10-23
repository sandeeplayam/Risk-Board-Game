import java.util.ArrayList;

public class Continent {

    private String name;
    private int bonusArmy;
    private ArrayList<Country> countries;

    public Continent(String name, int bonusArmy, ArrayList<Country> countriesInContinent) {
        this.name = name;
        this.bonusArmy = bonusArmy;
        this.countries = countriesInContinent;
    }

    public int getBonusArmy() {
        return this.bonusArmy;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Country> getCountries() {
        return this.countries;
    }
}
