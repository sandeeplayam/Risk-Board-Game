import java.util.ArrayList;

/**
 * This class is for the Player objects being used in the model
 * @author Sudarsana Sandeep
 */
public class Player {

    private ArrayList<Country> ruleCountries;
    private ArrayList<Continent> ruleContinent;
    private int armies;
    private String name;

    /**
     * Constructor to create the Player object
     * @param name String representation of players name
     * @param armies Integer amount of armies player will have initially
     */
    public Player(String name, int armies){

        ruleCountries = new ArrayList<Country>();
        ruleContinent = new ArrayList<Continent>();
        this.name = name;
        this.armies = armies;

    }

    /**
     * This method adds a country to the list of countries the player rules
     * @param country Country object
     */
    public void addCountry(Country country){
        ruleCountries.add(country);
    }

    /**
     * This method removes a country from the list of countries the player rules
     * @param country Country object
     */
    public void removeCountry(Country country){
        ruleCountries.remove(country);
    }

    /**
     * Method returns a string of all the countries the player currently rules
     * @return String
     */
    public String getRuledCountriesInfo() {
        String n = "";
        for (int i = 0; i < getCountrySizes(); i++) {
            n = n.concat(ruleCountries.get(i).getName() + " has " + ruleCountries.get(i).getArmies() + " armies\n");
        }
        return n;
    }

    /**
     * This method returns a boolean value depending on if the player currently rules the a particular Country object
     * @param name String representation of Country object
     * @return boolean
     */
    public boolean ownsCountry(String name) {
        for (int i = 0; i < getCountrySizes(); i++) {
            if(ruleCountries.get(i).equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method returns the size of the list of countries the player rules
     * @return integer
     */
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

    /**
     * Method returns the name of the player as a String
     * @return String
     */
    public String getName() {
        return this.name;
    }

    public int getArmies() {
        return this.armies;
    }

    /**
     * This method increments the army count for a player
     * @param numArmy Integer representation of army to increment by
     */
    public void increaseArmyCount(int numArmy) {
        armies = numArmy + armies;
        //System.out.println();
    }

    /**
     * This method decrements the army count for a player
     * @param numArmy Integer representation of army to decrement by
     */
    public void decreaseArmyCount(int numArmy) {
        armies = armies - numArmy;
        //System.out.println();
    }

}
