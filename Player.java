
import java.util.ArrayList;

public class Player {

    private ArrayList<Country> ruleCountries;
    private ArrayList<Continent> ruleContinent;
    private int armies;
    private String name;

    public Player(String name, int armies){

        ruleCountries = new ArrayList<Country>();
        ruleContinent = new ArrayList<Continent>();
        this.name = name;
        this.armies = armies;

    }

    public void addCountry(Country country){
        ruleCountries.add(country);
    }

    public void removeCountry(Country country){
        ruleCountries.remove(country);
    }

    public void getRuledCountriesInfo() {
        for (int i = 0; i < getCountrySizes(); i++) {
            System.out.println(ruleCountries.get(i).getName() + " has " + ruleCountries.get(i).getArmies() + " armies");
        }
    }

    public int getCountrySizes() {
        return ruleCountries.size();
    }

    public int getContinentSize() {
        return ruleContinent.size();
    }

    public Continent getContinent(int index) {
        return ruleContinent.get(index);
    }

    public void addContinent(Continent continent) {
        ruleContinent.add(continent);
    }

    public void removeContinent(Continent continent) {
        ruleContinent.remove(continent);
    }

    public String getName() {
        return this.name;
    }

    public int getArmies() {
        return this.armies;
    }

    public void increaseArmyCount(int numArmy) {
        armies = numArmy + armies;
        //System.out.println();
    }

    public void decreaseArmyCount(int numArmy) {
        armies = armies - numArmy;
        //System.out.println();
    }

}
