//-@author yasin jaamac
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
        Player p1 = new Player("player",10);
        p1.decreaseArmyCount(2);
        assertEquals(8,p1.getArmies());
        assertFalse(p1.getArmies()==7);
        //decrease army by 4 now
        p1.decreaseArmyCount(4);
        assertTrue(p1.getArmies()==4);
    }

    @Test
    public void setRuler() {
        Country a = new Country("Canada");
        Player p = new Player("Al",6);
        a.setRuler(p);
        assertEquals(p,a.getRuler());
        assertTrue(a.getRuler()==p);



    }

    @Test
    public void getRuler() {
        Country a = new Country("Canada");
        Player p = new Player(" Al", 6);
        a.setRuler(p);
        assertTrue(a.getRuler() ==p);
        assertEquals(p,a.getRuler());




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
        Country u = new Country("Canada");
        Country v = new Country("USA");
        Continent e = new Continent("Alaska",5);

        u.setAdjacentCountries(v);
        assertEquals(v,u.getAdjacentCountries().get(0));
        assertTrue(u.getAdjacentCountries().get(0)==v);
    }

}
