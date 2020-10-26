//@author Danish Butt, Sudarsana Sandeep, Yusuf Jamaac

/** This is the game class for the Risk game. This class
 *  creates the main method which creates an instance of the game
 */

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Game {

    private Board board;
    private boolean gameWon;

    public Game() {
    }

    /**
     * Constructor of the game class that initializes the variables
     */
    public static void main(String[] args) {

        Game game = new Game();
        game.play();
    }

    /**
     * This method contains a loop where the game keeps on going until someone wins
     */
    public void play() {

        System.out.println("Welcome to a text-based version of Risk");

        Scanner s = new Scanner(System.in);
        String input;
        int number = 0;

        do {
            System.out.print("Enter Number of players: ");  //Enter number of players and create board
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

        //create Board
        board = new Board(number);
        printRules();
        printCommands();

        this.gameWon = false;

        System.out.println("The game will start with Player 1");

        //This is the main loop of the game
        do {

            System.out.println("At the start of each turn each player receives 3 or more armies and" +
                    " if you rule a whole continent you will get more bonus armies.");

            board.stateOfMap();

            //This loops to each of the players
            for (int i = 0; i < board.playerArray.size(); i++) {

                System.out.println("It is " + board.playerArray.get(i).getName() + "'s turn");

                int bonusArmies = 0;

                //Assign continent bonus
                if(board.playerArray.get(i).getContinentSize() > 0) {
                    for(int j = 0; j < board.playerArray.get(i).getContinentSize(); j++) {
                        bonusArmies = bonusArmies + board.playerArray.get(i).getContinent(j).getBonusArmy();
                    }
                }

                //Assign 3 or more armies at each turn
                int newArmies = (board.playerArray.get(i).getCountrySizes() / 3) + bonusArmies;
                board.playerArray.get(i).increaseArmyCount(newArmies);

                System.out.println(board.playerArray.get(i).getName() +" receives " + newArmies +" armies");

                for(int b = 0; b < newArmies; b++) {
                    System.out.println("Enter country to add armies to:");
                    String countryToAdd;
                    countryToAdd = s.nextLine();
                    int g = board.mapCountryToIndex(countryToAdd);

                    while(g == -1){
                        System.out.println("You have entered an invalid country");
                        System.out.println("Enter a country to add armies too");
                        countryToAdd = s.nextLine();
                        g = board.mapCountryToIndex(countryToAdd);
                    }

                    board.getCountries(g).increaseArmyCount(1);

                }

                //Asks the user for a command
                String command;
                System.out.println("Enter a command:");
                command = s.nextLine();   //execute command


                //if pass is entered cycle to the next player
                while(!command.equals("pass")) {
                    commandWord(command);
                    System.out.println("Enter a command:");
                    command = s.nextLine();
                }
                System.out.println(board.playerArray.get(i).getName() + " passes");

            }
        }while (!this.gameWon);

    }

    /**
     * This method accepts a command and executes/prints out the result
     * @param command command entered by player
     */
    public void commandWord(String command) {

        Scanner sc = new Scanner(System.in);
        int e, f, v;
        String c, d;

        if (command.equals("attack")) {
            int i;
            String attackFrom;
            String defendFrom;

            do {
                System.out.println("Enter country to attack:");
                c = sc.next();
                defendFrom = c;
                i = board.mapCountryToIndex(c);
                if(i == -1) {
                    System.out.println("You have entered an invalid country, try again.");
                }

            }while(i == -1);


            do{
                System.out.println("Enter country attacking from:");
                d = sc.next();
                attackFrom = d;
                i = board.mapCountryToIndex(d);
                if(i == -1) {
                    System.out.println("You have entered an invalid country, try again.");
                }
                if(attackFrom.equals(defendFrom)){
                    System.out.println("You can not attack the same country you are attacking from");
                }

            }while((i == -1) || (attackFrom.equals(defendFrom)));


            do {
                System.out.println("Choose number of dice to roll (attacker):");
                e = sc.nextInt();
                i = board.mapCountryToIndex(attackFrom);
                if(board.getCountries(i).getArmies() <= e) {
                    System.out.println("Must have one more army in the country you are attacking from" +
                            " than the amount of dice you are rolling.");
                }
            }while ((e < 1) && (e > 3) && (board.getCountries(i).getArmies() > e)) ;

            do {
                System.out.println("Choose number of dice to roll (defender):");
                f = sc.nextInt();
                i = board.mapCountryToIndex(defendFrom);
                if(board.getCountries(i).getArmies() < f) {
                    System.out.println("Must have the same amount or more armies in the country you are defending" +
                            " from than the amount of dice you are rolling.");
                }
            }while ((f < 1 || f > 2) ||  (board.getCountries(i).getArmies() < f));

            board.attack(d,c,e,f);

            if (board.playerArray.size()==0){
                System.out.println("Congratulations You won the game!");
                exit(0);
            }

        }else if (command.equals("pass")) {

            System.out.println("The next player can start their turn");


        } else if (command.equals("fortify")) {
            String h, j;

            int x;

            // do{
            System.out.println("Enter country to fortify:");
            h = sc.next();

            System.out.println("Enter country fortifying from:");
            j= sc.next();
            // }while(board.);


            System.out.println("Number of armies to move");
            x =sc.nextInt();

            //while();

            board.fortify(j,h,x);


        } else if (command.equals("map")) {
            board.stateOfMap();

        } else if (command.equals("rules")) {
            printRules();

        } else if (command.equals("commands")) {
            printCommands();

        } else if(command.equals("adjacent countries")){
            String k;
            System.out.println("Enter country:");
            k= sc.next();

            int o=board.mapCountryToIndex(k);
            ArrayList<Country> countryList;
            countryList= board.getCountries(o).getAdjacentCountries();

            for(int i=0; i< countryList.size();i++){
                System.out.println(countryList.get(i).getName());
            }


        } else {
            System.out.println("This is not a valid command. Please try again");
        }


    }

    /**
     * This method prints the rules of the games
     */
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

    /**
     * This method prints the commands for the game
     */
    public void printCommands(){

        System.out.println("These are the possible commands:\n" +
                "attack: attack another country\n" +
                "pass: pass your turn\n" +
                "fortify: fortify one of the countries you rule\n" +
                "map: print state of the map\n" +
                "rules: print rules\n" +
                "commands: print commands\n"+
                "adjacent countries: print adjacent countries\n");
    }

}

