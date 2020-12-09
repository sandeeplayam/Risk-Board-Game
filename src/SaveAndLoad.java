import java.io.*;
import java.util.ArrayList;

public class SaveAndLoad implements Serializable{

    public SaveAndLoad(){

    };

    public void saveCustomCountriesView(ArrayList<String> countries) throws IOException {
        FileOutputStream fout = new FileOutputStream("SaveCustomCountriesView.ser");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(countries);
        oout.close();
        fout.close();

    }

    public ArrayList<String> loadCustomCountriesView() throws IOException, ClassNotFoundException {
        ArrayList<String> countries;

        FileInputStream fin = new FileInputStream ("SaveCustomCountriesView.ser");
        ObjectInputStream oin = new ObjectInputStream(fin);
        countries = (ArrayList<String>) oin.readObject();
        oin.close();
        fin.close();

        return countries;
    }

    public void saveCustomCountriesModel(ArrayList<Country> countries) throws IOException {
        FileOutputStream fout = new FileOutputStream("SaveCustomCountriesModel.ser");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(countries);
        oout.close();
        fout.close();

    }

    public ArrayList<Country> loadCustomCountriesModel() throws IOException, ClassNotFoundException {
        ArrayList<Country> countries;

        FileInputStream fin = new FileInputStream ("SaveCustomCountriesModel.ser");
        ObjectInputStream oin = new ObjectInputStream(fin);
        countries = (ArrayList<Country>) oin.readObject();
        oin.close();
        fin.close();

        return countries;
    }

    public void saveCustomContinents(ArrayList<Continent> continent) throws IOException {
        FileOutputStream fout = new FileOutputStream("SaveCustomContinent.ser");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(continent);
        oout.close();
        fout.close();

    }

    public ArrayList<Continent> loadCustomContinents() throws IOException, ClassNotFoundException {
        ArrayList<Continent> continent;

        FileInputStream fin = new FileInputStream ("SaveCustomContinent.ser");
        ObjectInputStream oin = new ObjectInputStream(fin);
        continent = (ArrayList<Continent>) oin.readObject();
        oin.close();
        fin.close();

        return continent;
    }


    public void saveBoard(Board b, int n) throws IOException {
        FileOutputStream fout = new FileOutputStream("SaveBoard" + n +".ser");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(b);
        oout.close();
        fout.close();

    }

    public Board loadBoard(int n) throws IOException, ClassNotFoundException {
        Board board;

        FileInputStream fin = new FileInputStream ("SaveBoard" + n +".ser");
        ObjectInputStream oin = new ObjectInputStream(fin);
        board = (Board) oin.readObject();
        oin.close();
        fin.close();

        return board;
    }


    public void savePlayerNum(int number, int n) throws IOException {

        FileOutputStream fout = new FileOutputStream("SavePlayerNumber" + n +".ser");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(number);
        oout.close();
        fout.close();
    }


    public int loadPlayerNum(int n) throws IOException, ClassNotFoundException {
        int number;

        FileInputStream fin = new FileInputStream("SavePlayerNumber" + n +".ser");
        ObjectInputStream oin = new ObjectInputStream(fin);
        number = (int) oin.readObject();
        oin.close();
        fin.close();

        return number;
    }
}
