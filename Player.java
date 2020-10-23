
import java.util.ArrayList;

public class Player {

      private ArrayList<Country> countries;

    public Player(ArrayList<Country> countries){
        this.countries= countries;
    }

    public void add(Country country){
        countries.add(country);
    }

    public void removeCountry(Country country){
        countries.remove(country);
    }



}
