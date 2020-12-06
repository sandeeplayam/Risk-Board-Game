import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents the Country objects on the map
 * @author Sudarsana Sandeep
 */
public class Country implements Serializable {

    private int armies;
    private String name;
    //private String continent;
    private Player ruler;
    private boolean hasRuler;
    private ArrayList<Country> adjacentCountries;

    /**
     * Constructor for country object
     * @param name String representation of country object name
     */
    public Country(String name) {
        this.name = name;
        //this.continent = continent;
        hasRuler = false;
        armies = 0;
        adjacentCountries = new ArrayList<Country>();
    }

    /**
     * Getter method to retrieve name of country object
     * @return String
     */
    public String getName(){
        return name;
    }

    /**
     * Getter method to retrieve amount of armies in that particular country
     * @return integer
     */
    public int getArmies(){
        return armies;
    }

    public void setArmies(int army) {
        this.armies = army;
    }

    /**
     * Setter method to increment the number of armies on a country by a certain amount
     * @param numArmy Integer which represents the amount of armies
     */
    public void increaseArmyCount(int numArmy) {
        armies = numArmy + armies;
        //System.out.println();
    }

    /**
     * Setter method to decrement the number of armies on a country by a certain amount
     * @param numArmy Integer which represent the amount of armies
     */
    public void decreaseArmyCount(int numArmy) {
        armies = armies - numArmy;
        //System.out.println();
    }

    /**
     * This method lets one set the ruler of a particular country object
     * @param ruler Player object
     */
    public void setRuler(Player ruler) {
        this.ruler = ruler;
        hasRuler = true;
    }

    /**
     * This method gets the current ruler of a certain country
     * @return Player object
     */
    public Player getRuler(){
        return ruler;
    }

    /**
     * This method returns whether a particular country has a ruler
     * @return boolean
     */
    public boolean hasRuler() {
        return this.hasRuler;
    }

    /**
     * This method lets one set the adjacent countries for itself
     * @param country Country object
     */
    public void setAdjacentCountries(Country country) {
        this.adjacentCountries.add(country);
    }

    /**
     * This method returns the list of adjacent countries to the current country object
     * @return ArrayList of country objects
     */
    public ArrayList<Country> getAdjacentCountries() {
        return this.adjacentCountries;
    }

    public int getAdjacentCountrySize() {
        return this.adjacentCountries.size();
    }

    public boolean equals(String name) {
        if(this.name == name) {
            return true;
        } else {
            return false;
        }
    }

}