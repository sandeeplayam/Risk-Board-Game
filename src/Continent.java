
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents the Continent objects in the game of Risk
 * @author Sudarsana Sandeep
 */
public class Continent implements Serializable {

    private String name;
    private int bonusArmy;
    private ArrayList<Country> countries;

    public Continent(String name, int bonusArmy) {
        countries= new ArrayList<Country>();
        this.name = name;
        this.bonusArmy = bonusArmy;
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

    public void addCountry(Country country) {
        countries.add(country);
    }
}

