import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
//-author Yusuf J
public class PlayerTest {
    private ArrayList<Country> ruleCountries;

    @Test
    public void addCountryTest() {

        //Created country
        Country c = new Country("Somalia");
       //Created player
        Player p = new Player("Yusuf",5);
        //added country to the player p
        p.addCountry(c);

        //Check if player owns that country that was recently added
        assertTrue(p.ownsCountry("Somalia"));
        assertFalse(p.ownsCountry("India"));

    }

    @Test
    public void removeCountryTest() {
        //Created country
        Country c = new Country("Somaliland");
        //Created player
        Player p = new Player("Alex",6);
        //added country to the player p
        p.addCountry(c);
        //Now removed the country
        p.removeCountry(c);
        //Check if player owns that country that was recently added
        assertFalse(p.ownsCountry("Somaliland"));
        //assertFalse(p.ownsCountry("India"));
    }

    @Test
    public void ownsCountryTest() {
        Country n = new Country("Canada");
        Player o = new Player("player",2);
        o.addCountry(n);
        assertTrue( o.ownsCountry("Canada"));
    }

    @Test
    public void getCountrySizesTest() {
        Country n = new Country("Canada");
        Player o = new Player("player",2);
        o.addCountry(n);
         assertTrue(o.getCountrySizes()==1);
         assertEquals(1,o.getCountrySizes());
         //now add another country to player o
        Country l = new Country("India");
        o.addCountry(l);
        assertEquals(2,o.getCountrySizes());

    }

    @Test
    public void getContinentSizeTest() {
        Continent c = new Continent("Somalia",5);
        //Created player
        Player p = new Player("Yusuf",5);
        p.addContinent(c);
        assertEquals(1,p.getContinentSize());
        assertTrue(p.getContinentSize()==1);
    }


    @Test
    public void getContinentTest() {
        Continent c = new Continent("Somalia",5);
        //Created player
        Player p = new Player("Yusuf",5);
        p.addContinent(c);
        assertEquals(c,p.getContinent(0));
        assertTrue(p.getContinent(0)==c);

    }

    @Test
    public void addContinentTest() {
        //Created continent
        Continent c = new Continent("Somalia",5);
        //Created player
        Player p = new Player("Yusuf",5);
        //added country to the player p
        p.addContinent(c);

        //Check if player owns that country that was recently added
        assertTrue(p.getContinent(0)==c);
        assertEquals(1,p.getContinentSize());
        Continent secondContinent = new Continent("UK",8);
        p.addContinent(secondContinent);
        assertEquals(2,p.getContinentSize());

    }

    @Test
    public void removeContinentTest() {

        Continent c = new Continent("Somalia",5);
        //Created player
        Player p = new Player("Yusuf",5);
        //added country to the player p
        p.addContinent(c);
        p.removeContinent(c);

        //Check if player owns that country that was recently added & removed
        assertTrue(p.getContinentSize()==0);

        assertEquals(0,p.getContinentSize());


    }

    @Test
    public void getNameTest() {
        Player player  = new Player("Yusuf",9);
        assertEquals("Yusuf",player.getName());

    }

    @Test
    public void getArmiesTest() {
        Country s = new Country("Taiwan");
        s.setArmies(5);
        assertEquals(5,s.getArmies());
        assertTrue(s.getArmies()==5);


    }

    @Test
    public void increaseArmyCountTest() {

        Player o = new Player("player",2);
        o.increaseArmyCount(2);
        assertEquals(4,o.getArmies());

    }

    @Test
    public void decreaseArmyCountTest() {
        Player o = new Player("player",10);
        o.decreaseArmyCount(2);
        assertEquals(8,o.getArmies());
        assertFalse(o.getArmies()==7);
        //decrease army by 4 now
        o.decreaseArmyCount(4);
        assertTrue(o.getArmies()==4);


    }
}