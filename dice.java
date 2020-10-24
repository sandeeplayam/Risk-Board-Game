import java.util.*;

public class dice {

    /*
     /5 dice in total, 2 white(defender) and 3 red(attacker)
     */
    private int dice;
    private int colour;


    //constructor constructs a dice object
    public dice( String Colour) {
        this.colour = colour;

        //randomly set a number when dice is brought out of box, generator
        Random r = new Random();
    }

    public void roll() {
        // get a random int value for the dice b/w 1 and 6, random number gonna be displayed

        dice = (int) (Math.random() * 6) + 1;
    }

    public static void main(String[] args){

    }
}