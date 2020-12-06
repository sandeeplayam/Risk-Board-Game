import java.io.*;

public class SaveAndLoad implements Serializable{


    public SaveAndLoad(){

    };

    public void saveBoard(Board b) throws IOException {
        FileOutputStream fout = new FileOutputStream("Save Board.ser");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(b);
        oout.close();
        fout.close();

    }

    public Board loadBoard() throws IOException, ClassNotFoundException {
        Board board;

        FileInputStream fin = new FileInputStream("Save Board.ser");
        ObjectInputStream oin = new ObjectInputStream(fin);
        board = (Board) oin.readObject();
        oin.close();
        fin.close();

        return board;
    }

    public void saveMapState(Country[] countries) {

        try {
            FileOutputStream fout = new FileOutputStream("Save MapState.ser");
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(countries);
            oout.close();
            fout.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public Country[] loadMapState() throws IOException, ClassNotFoundException {
        Country[] countries;

        FileInputStream fin = new FileInputStream("Save MapState.ser");
        ObjectInputStream oin = new ObjectInputStream(fin);
        countries = (Country[]) oin.readObject();
        oin.close();
        fin.close();

        return countries;
    }

    public void savePlayerNum(int number) throws IOException {

        FileOutputStream fout = new FileOutputStream("Save PlayerNumber.ser");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(number);
        oout.close();
        fout.close();
    }

    public int loadPlayerNum() throws IOException, ClassNotFoundException {
        int number;

        FileInputStream fin = new FileInputStream("Save PlayerNumber.ser");
        ObjectInputStream oin = new ObjectInputStream(fin);
        number = (int) oin.readObject();
        oin.close();
        fin.close();

        return number;
    }
}
