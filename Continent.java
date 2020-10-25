import java.util.ArrayList;

public class Continent {

    private String name;
    private int bonusArmy;
    private ArrayList<Country> countries;

    public Continent(String name, int bonusArmy) {
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
