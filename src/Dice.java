
//@author Yasin Jamaac

import java.util.*;

public class Dice {

    /*
     /there is 5 dice in total, 2 white(defender) and 3 red(attacker)
     */
    private int Dice;
    //private int colour;


    //constructor constructs a dice object
    public Dice() {
        //this.colour = colour;

        //randomly set a number when dice is brought out of box, generator
        Random r = new Random();
    }

    public int roll() {
        // get a random int value for the dice b/w 1 and 6, random number gonna be displayed

        Dice = (int) (Math.random() * 6) + 1;
        return Dice;
    }
    public static void main(String[] args){

    }


}
