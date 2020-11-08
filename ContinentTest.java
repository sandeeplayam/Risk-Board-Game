//@author yasin jaamac
import org.junit.Test;
import static org.junit.Assert.*;

public class ContinentTest {


    @Test
    public void getName() {
        Player player  = new Player("Mo",7);
        assertEquals("Mo",player.getName());

    }


    @Test
    public void addCountry() {
        //Created country
        Country c = new Country("Canada");
        //Created player
        Player p = new Player("jaa",6);

        //added country to the player p
        p.addCountry(c);

        //Check if player owns that country that was recently added
        assertTrue(p.ownsCountry("Canada"));
        assertFalse(p.ownsCountry("India"));
    }
}