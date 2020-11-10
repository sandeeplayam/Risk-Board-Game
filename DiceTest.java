import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class DiceTest {
//author Yusuf J
    @Test
    /*
    Method genetates random number roll for dice
    Here its testing to see if the rolled dice is a number between 1 and 6
     */
    public void roll() {
        Dice d1 = new Dice();

        assertTrue(d1.roll() >= 1 && d1.roll() <= 6);

        Dice d2 = new Dice();
        assertTrue(d2.roll() >= 1 && d2.roll() <= 6);




    }
}