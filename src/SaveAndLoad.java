import java.io.*;

public class SaveAndLoad implements Serializable{

    public SaveAndLoad(){

    };

    public void saveBoard(Board b, int n) throws IOException {
        FileOutputStream fout = new FileOutputStream("Save Board" + n +".ser");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(b);
        oout.close();
        fout.close();

    }

    public Board loadBoard(int n) throws IOException, ClassNotFoundException {
        Board board;

        FileInputStream fin = new FileInputStream ("Save Board" + n +".ser");
        ObjectInputStream oin = new ObjectInputStream(fin);
        board = (Board) oin.readObject();
        oin.close();
        fin.close();

        return board;
    }


    public void savePlayerNum(int number, int n) throws IOException {

        FileOutputStream fout = new FileOutputStream("Save PlayerNumber" + n +".ser");
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(number);
        oout.close();
        fout.close();
    }




    public int loadPlayerNum(int n) throws IOException, ClassNotFoundException {
        int number;

        FileInputStream fin = new FileInputStream("Save PlayerNumber" + n +".ser");
        ObjectInputStream oin = new ObjectInputStream(fin);
        number = (int) oin.readObject();
        oin.close();
        fin.close();

        return number;
    }
}
