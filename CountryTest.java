//@author yasin jaamac
import org.junit.Test;

import static org.junit.Assert.*;

public class CountryTest {

    @Test
    public void getName() {
        Country w = new Country("USA");
        assertEquals("USA", w.getName());

    }

    @Test
    public void getArmies() {

        Country s = new Country("Canada");
        s.setArmies(6);
        assertEquals(6, s.getArmies());
        assertFalse(s.getArmies()==7);


    }

    @Test
    public void setArmies() {
        int x=2;
        Country s = new Country("Canada");
        s.setArmies(x);
        assertEquals(2, s.getArmies());
        assertTrue(s.getArmies()==2);


    }

    @Test
    public void increaseArmyCount() {
        Player o = new Player("player",2);
        o.increaseArmyCount(2);
        assertEquals(4,o.getArmies());
    }

    @Test
    public void decreaseArmyCount() {
        Player o = new Player("player",10);
        o.decreaseArmyCount(2);
        assertEquals(8,o.getArmies());
        assertFalse(o.getArmies()==7);
        //decrease army by 4 now
        o.decreaseArmyCount(4);
        assertTrue(o.getArmies()==4);
    }

    @Test
    public void setRuler() {
        Country s = new Country("Canada");
        Player p = new Player("Al",6);
        s.setRuler(p);
        assertEquals(p,s.getRuler());
        assertTrue(s.getRuler()==p);



    }

    @Test
    public void getRuler() {
        Country s = new Country("Canada");
        Player p = new Player(" Al", 6);
        s.setRuler(p);
        assertTrue(s.getRuler() ==p);
        assertEquals(p,s.getRuler());




    }

    @Test
    public void hasRuler() {
        Country s = new Country("Canada");
        Player p = new Player("Al", 6);
        s.setRuler(p);
        assertTrue(s.hasRuler());



    }

    @Test
    public void setAdjacentCountries() {
        Country a1 = new Country("Canada");
        Country a2 = new Country("USA");
        Continent e = new Continent("Alaska",5);

        a1.setAdjacentCountries(a2);
        assertEquals(a2,a1.getAdjacentCountries().get(0));
        assertTrue(a1.getAdjacentCountries().get(0)==a2);
    }

}
