import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

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

        System.out.println("The game will start with Player 1");

        do {
            for (int i = 0; i < board.playerArray.size(); i++) {

                System.out.println("It is " + board.playerArray.get(i).getName() + "'s turn");

                System.out.println("At the start of each turn each player receives 3 or more armies and" +
                        " if you rule a whole continent you will get more bonus armies.");

                int bonusArmies = 0;

                if(board.playerArray.get(i).getContinentSize() > 0) {
                    for(int j = 0; j < board.playerArray.get(i).getContinentSize(); j++) {
                        bonusArmies = bonusArmies + board.playerArray.get(i).getContinent(j).getBonusArmy();
                    }
                }

                int newArmies = (board.playerArray.get(i).getCountrySizes() / 3) + bonusArmies;
                board.playerArray.get(i).increaseArmyCount(newArmies);

                System.out.println(board.playerArray.get(i).getName() +" receives " + newArmies +" armies");

                for(int b = 0; i < newArmies; i++) {
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

                String command;
                System.out.println("Enter a command:");
                command = s.nextLine();



                while(!command.equals("pass")) {
                    commandWord(command);
                    System.out.println("Enter a command:");
                    command = s.nextLine();
                }
                System.out.println(board.playerArray.get(i).getName() + " passes");
            }
        }while (!this.gameWon);

    }

    public void commandWord(String command) {

        Scanner sc = new Scanner(System.in);
        int e, f;
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
            }while(i == -1);

            do {
                System.out.println("Choose number of dice to roll (attacker):");
                e = sc.nextInt();
                i = board.mapCountryToIndex(attackFrom);
                if(board.getCountries(i).getArmies() <= e) {
                    System.out.println("Must have one more army in the country you are attacking from" +
                            " than the amount of dice you are rolling.");
                }
            }while ((e < 1 || e > 3) && (board.getCountries(i).getArmies() <= e)) ;

            do {
                System.out.println("Choose number of dice to roll (defender):");
                f = sc.nextInt();
                i = board.mapCountryToIndex(defendFrom);
                if(board.getCountries(i).getArmies() < f) {
                    System.out.println("Must have the same amount or more armies in the country you are defending" +
                            " from than the amount of dice you are rolling.");
                }
            }while ((f < 1 || f > 2) && (board.getCountries(i).getArmies() < f));

            board.attack(c,d,e,f);

            if (board.playerArray.size()==0){
                System.out.println("Congratulations You won the game!");
                exit(0);
            }

        }else if (command.equals("pass")) {

            System.out.println("The next player can start their turn");


        } else if (command.equals("fortify")) {
            String h, j;

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




