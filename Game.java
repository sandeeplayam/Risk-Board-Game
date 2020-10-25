import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Board board;
    private boolean gameWon;

    public Game() {
    }

    public static void main(String[] args) {

        Game game = new Game();
        game.play();
    }

    public void play() {

        System.out.println("Welcome to a text-based version of Risk");

        Scanner s = new Scanner(System.in);
        String input;
        int number = 0;

        do {
            System.out.print("Enter Number of players: ");
            input = s.nextLine();

            if (input.equals("2")) {
                number = 2;
            } else if (input.equals("3")) {
                number = 3;
            } else if (input.equals("4")) {
                number = 4;
            } else if (input.equals("5")) {
                number = 5;
            } else if (input.equals("6")) {
                number = 6;
            }
        } while (number < 2 || number > 6);

        board = new Board(number);
        printRules();
        printCommands();


        this.gameWon = false;

        do {

            System.out.println("Enter a command:");
            String command;
            command = s.nextLine();
            commandWord(command);



        } while (!this.gameWon);


        if (this.gameWon) {

            System.out.println("Congratulations! You have won the game!");
        }


    }


    public void commandWord(String command) {

        Scanner sc = new Scanner(System.in);
        int a, b, e, f;
        String c, d;

        if (command.equals("attack")) {

            do {
                System.out.println("Enter attacking player number:");
                a = sc.nextInt();
            }while (a<1 || a> board.playerArray.size());

            //do{
            System.out.println("Enter country to attack:");
            c = sc.next();
            //}while();

            //do{
            System.out.println("Enter country attacking from:");
            d = sc.next();
            //}while();

            do {
                System.out.println("Choose number of dice to roll (attacker):");
                e = sc.nextInt();
            }while (e < 1 || e > 3) ;

            do {
                System.out.println("Choose number of dice to roll (defender):");
                f = sc.nextInt();
            }while (f < 1 || f > 2) ;

            //call attack (parameters: (playerArray[a-1], playerArray[b-1],c,d,e,f) //check passing country

            // if (this.board.checkWin){
            // this.gameWon == true;}


        }else if (command.equals("pass")) {
            System.out.println("The next player can start their turn");


        } else if (command.equals("fortify")) {
            int g;
            String h, j;

            //do {
            System.out.println("Enter player number");
            g = sc.nextInt();
            // }while (g<1 || g>board.playerArray.size()+1);

            //do{
            System.out.println("Enter country to fortify:");
            h = sc.next();
            //}while();

            //do{
            System.out.println("Enter country fortifying from:");
            j= sc.next();
            //while();

            //fortify(playerArray[g-1], h, j)


        } else if (command.equals("map")) {
            //print function from model

        } else if (command.equals("rules")) {
            printRules();

        } else if (command.equals("commands")) {
            printCommands();

        } else {
            System.out.println("This is not a valid command. Please try again");
        }


    }

    public void printRules () {
        System.out.println
                ("Rules \n" +
                        "1. The winner is the first player to eliminate every opponent by " +
                        "capturing all 42 territories on the board.\n"
                        + "2. You can only attack a country that is adjacent to a country you control.\n"
                        + "3. At the start of each turn you will receive at least 3 armies or the # of territories " +
                        "you own divided by 3 (which ever one is higher).\n"
                        + "4. You can only attack a country if you own at least 2 armies in the attacking country.\n"
                        + "5. When attacking the person who is attacking can choose to roll up to 3 dice.\n"
                        + "6. The person defending can roll up to 2 dice but must have at least 2 armies in the " +
                        "defending country (if not they can only roll one dice).\n"
                        + "7. When you capture a territory, you must move at least as many armies as " +
                        "dice you rolled in your last attack.\n" +
                        "                                  "
                );
    }


    public void printCommands(){

        System.out.println("These are the possible commands:\n" +
                "attack: attack another country\n" +
                "pass: pass your turn\n" +
                "fortify: fortify one of the countries you rule\n" +
                "map: print state of the map\n" +
                "rules: print rules\n" +
                "commands: print commands\n");
    }

}
