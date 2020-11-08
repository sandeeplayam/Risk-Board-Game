import org.junit.Test;


import static org.junit.Assert.*;
//-author Yusuf J
public class BoardTest {

    @Test
    public void createPlayersTest() {
       Player p = new Player("alex",8);
       assertEquals("alex",p.getName());
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
    public void setAdjacentCountries() {
        Country a1 = new Country("China");
        Country a2 = new Country("Russia");
        Continent e = new Continent("Alaska",5);

        a1.setAdjacentCountries(a2);
        assertEquals(a2,a1.getAdjacentCountries().get(0));
        assertTrue(a1.getAdjacentCountries().get(0)==a2);


    }




}