import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Player player1, player2, player3, player4, player5, player6;
    private Country Alaska, Alberta, CentralAmerica, EasterUnitedStates, Greenland, NorthwestTerritory, Ontario, Quebec;
    private Country WesternUnitedStates, Argentina, Brazil, Peru, Venezuela, GreatBritain, Iceland, NorthernEurope, Scandinavia;
    private Country SouthernEurope, Ukraine, WesternEurope, Congo, EastAfrica, Egypt, Madagascar, NorthAfrica, SouthAfrica;
    private Country Afghanistan, China, India, Irkutsk, Japan, Kamchatka, MiddleEast, Mongolia, Siam, Siberia, Ural, Yakutsk;
    private Country EasternAustralia, Indonesia, NewGuinea, WesternAustralia;
    private ArrayList<Country> player1Countries;
    private ArrayList<Country> player2Countries;
    private ArrayList<Country> player3Countries;
    private ArrayList<Country> player4Countries;
    private ArrayList<Country> player5Countries;
    private ArrayList<Country> player6Countries;
    private boolean quitGame;

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
        int number;

        do {

            this.quitGame = false;
            number = 0;

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
            }while(number<2 || number >6);

            createMap(number);
            printRules();
            this.quitGame = true;

        } while(this.quitGame=false);
    }

    public void createMap (int numOfPlayers){

        if (numOfPlayers == 2){

            //2 PLAYERS-Each player gets 50 armies and 21 countries
            player1Countries = new ArrayList<Country>();
            player2Countries = new ArrayList<Country>();
            player1 = new Player(player1Countries);
            player2 = new Player(player2Countries);

            //Player 1
            Alaska = new Country("Alaska","2", player1 );
            EasterUnitedStates = new Country("EasternUnitedStates","2", player1);
            Ontario = new Country("Ontario","2", player1);
            Argentina = new Country("Argentina","2", player1);
            Venezuela = new Country("Venezuela","2", player1);
            NorthernEurope = new Country(" NorthernEurope","2", player1);
            WesternEurope = new Country("WesternEurope","2", player1);
            Egypt = new Country("Egypt","2", player1);
            SouthAfrica = new Country("Scandinavia","2", player1);
            India = new Country("India","2", player1);
            Kamchatka = new Country("Kamchatka","2", player1);
            Siam = new Country("Siam","2", player1);
            Yakutsk = new Country("Yakutsk","2", player1);
            NewGuinea = new Country("NewGuinea","3", player1);
            CentralAmerica = new Country("CentralAmerica","3", player1);
            NorthwestTerritory = new Country("NorthwestTerritory","3", player1);
            WesternUnitedStates = new Country("WesternUnitedStates","3", player1);
            Peru = new Country("Peru","3", player1);
            Iceland = new Country("Iceland","3", player1);
            SouthernEurope = new Country("SouthernEurope","3", player1);
            EastAfrica = new Country("EastAfrica","3", player1);

            player1.add(Alaska);
            player1.add(EasterUnitedStates);
            player1.add(Ontario);
            player1.add(Argentina);
            player1.add(Venezuela);
            player1.add(NorthernEurope);
            player1.add(WesternEurope);
            player1.add(Egypt);
            player1.add(SouthAfrica);
            player1.add(India);
            player1.add(Kamchatka);
            player1.add(Siam);
            player1.add(Yakutsk);
            player1.add(NewGuinea);
            player1.add(CentralAmerica);
            player1.add(NorthwestTerritory);
            player1.add(WesternUnitedStates);
            player1.add(Peru);
            player1.add(Iceland);
            player1.add(SouthernEurope);
            player1.add(EastAfrica);


            //Player2
            Alberta = new Country("Alberta","2", player2);
            Greenland = new Country("Greenland","2", player2);
            Quebec = new Country("Quebec","2", player2);
            Brazil = new Country("Brazil","2", player2);
            GreatBritain = new Country("GreatBritain","2", player2);
            Ukraine = new Country("Ukraine","2", player2);
            Congo = new Country("Congo","2", player2);
            Madagascar = new Country("Madagascar","2", player2);
            Afghanistan = new Country("Afghanistan","2", player2);
            Irkutsk = new Country("Irkutsk","2", player2);
            MiddleEast = new Country("MiddleEast","2", player2);
            Ural = new Country("Ural","2", player2);
            EasternAustralia = new Country("EasternAustralia","2", player2);
            WesternAustralia = new Country("WesternAustralia","3", player2);
            NorthAfrica = new Country("NorthAfrica","3", player2);
            China = new Country("China","3", player2);
            Japan = new Country("Japan","3", player2);
            Mongolia = new Country("Mongolia","3", player2);
            Siberia = new Country("Siberia","3", player2);
            Indonesia = new Country("Indonesia","3", player2);
            Scandinavia = new Country("Scandinavia","3", player2);

            player2.add(Alberta);
            player2.add(Greenland);
            player2.add(Quebec);
            player2.add(Brazil);
            player2.add(GreatBritain);
            player2.add(Ukraine);
            player2.add(Congo);
            player2.add(Madagascar);
            player2.add(Afghanistan);
            player2.add(Irkutsk);
            player2.add(MiddleEast);
            player2.add(Ural);
            player2.add(EasternAustralia);
            player2.add(WesternAustralia);
            player2.add(NorthAfrica);
            player2.add(China);
            player2.add(Japan);
            player2.add(Mongolia);
            player2.add(Siberia);
            player2.add(Indonesia);
            player2.add(Scandinavia);


        }else if (numOfPlayers ==3){

            //3 PLAYERS-Each player gets 35 armies and 14 countries
            player1Countries = new ArrayList<Country>();
            player2Countries = new ArrayList<Country>();
            player3Countries = new ArrayList<Country>();
            player1 = new Player(player1Countries);
            player2 = new Player(player2Countries);
            player3 = new Player(player3Countries);

            //Player 1
            Alaska = new Country("Alaska","2", player1 );
            EasterUnitedStates = new Country("EasternUnitedStates","2", player1);
            Ontario = new Country("Ontario","2", player1);
            Argentina = new Country("Argentina","2", player1);
            Venezuela = new Country("Venezuela","2", player1);
            NorthernEurope = new Country(" NorthernEurope","2", player1);
            WesternEurope = new Country("WesternEurope","2", player1);
            Egypt = new Country("Egypt","3", player1);
            SouthAfrica = new Country("Scandinavia","3", player1);
            India = new Country("India","3", player1);
            Kamchatka = new Country("Kamchatka","3", player1);
            Siam = new Country("Siam","3", player1);
            Yakutsk = new Country("Yakutsk","3", player1);
            NewGuinea = new Country("NewGuinea","3", player1);

            player1.add(Alaska);
            player1.add(EasterUnitedStates);
            player1.add(Ontario);
            player1.add(Argentina);
            player1.add(Venezuela);
            player1.add(NorthernEurope);
            player1.add(WesternEurope);
            player1.add(Egypt);
            player1.add(SouthAfrica);
            player1.add(India);
            player1.add(Kamchatka);
            player1.add(Siam);
            player1.add(Yakutsk);
            player1.add(NewGuinea);


            //Player2
            Alberta = new Country("Alberta","2", player2);
            Greenland = new Country("Greenland","2", player2);
            Quebec = new Country("Quebec","2", player2);
            Brazil = new Country("Brazil","2", player2);
            GreatBritain = new Country("GreatBritain","2", player2);
            Ukraine = new Country("Ukraine","2", player2);
            Congo = new Country("Congo","2", player2);
            Madagascar = new Country("Madagascar","3", player2);
            Afghanistan = new Country("Afghanistan","3", player2);
            Irkutsk = new Country("Irkutsk","3", player2);
            MiddleEast = new Country("MiddleEast","3", player2);
            Ural = new Country("Ural","3", player2);
            EasternAustralia = new Country("EasternAustralia","3", player2);
            WesternAustralia = new Country("WesternAustralia","3", player2);

            player2.add(Alberta);
            player2.add(Greenland);
            player2.add(Quebec);
            player2.add(Brazil);
            player2.add(GreatBritain);
            player2.add(Ukraine);
            player2.add(Congo);
            player2.add(Madagascar);
            player2.add(Afghanistan);
            player2.add(Irkutsk);
            player2.add(MiddleEast);
            player2.add(Ural);
            player2.add(EasternAustralia);
            player2.add(WesternAustralia);


            //Player3
            CentralAmerica = new Country("CentralAmerica","2", player3);
            NorthwestTerritory = new Country("NorthwestTerritory","2", player3);
            WesternUnitedStates = new Country("WesternUnitedStates","2", player3);
            Peru = new Country("Peru","2", player3);
            Iceland = new Country("Iceland","2", player3);
            SouthernEurope = new Country("SouthernEurope","2", player3);
            EastAfrica = new Country("EastAfrica","2", player3);
            NorthAfrica = new Country("NorthAfrica","3", player3);
            China = new Country("China","3", player3);
            Japan = new Country("Japan","3", player3);
            Mongolia = new Country("Mongolia","3", player3);
            Siberia = new Country("Siberia","3", player3);
            Indonesia = new Country("Indonesia","3", player3);
            Scandinavia = new Country("Scandinavia","3", player3);

            player3.add(CentralAmerica);
            player3.add(NorthwestTerritory);
            player3.add(WesternUnitedStates);
            player3.add(Peru);
            player3.add(Iceland);
            player3.add(SouthernEurope);
            player3.add(EastAfrica);
            player3.add(NorthAfrica);
            player3.add(China);
            player3.add(Japan);
            player3.add(Mongolia);
            player3.add(Siberia);
            player3.add(Indonesia);
            player3.add(Scandinavia);

        }else if (numOfPlayers ==4){

            //4 PLAYERS-Each player gets 30 armies. Two players get 10 territories each and the other two get 11.
            player1Countries = new ArrayList<Country>();
            player2Countries = new ArrayList<Country>();
            player3Countries = new ArrayList<Country>();
            player4Countries = new ArrayList<Country>();
            player1 = new Player(player1Countries);
            player2 = new Player(player2Countries);
            player3 = new Player(player3Countries);
            player4 = new Player(player4Countries);

            //Player 1
            Alaska = new Country("Alaska","3", player1 );
            EasterUnitedStates = new Country("EasternUnitedStates","3", player1);
            Ontario = new Country("Ontario","3", player1);
            Argentina = new Country("Argentina","3", player1);
            Venezuela = new Country("Venezuela","3", player1);
            NorthernEurope = new Country(" NorthernEurope","3", player1);
            WesternEurope = new Country("WesternEurope","3", player1);
            Egypt = new Country("Egypt","3", player1);
            SouthAfrica = new Country("Scandinavia","3", player1);
            India = new Country("India","2", player1);
            Kamchatka = new Country("Kamchatka","1", player1);

            player1.add(Alaska);
            player1.add(EasterUnitedStates);
            player1.add(Ontario);
            player1.add(Argentina);
            player1.add(Venezuela);
            player1.add(NorthernEurope);
            player1.add(WesternEurope);
            player1.add(Egypt);
            player1.add(SouthAfrica);
            player1.add(India);
            player1.add(Kamchatka);


            //Player2
            Alberta = new Country("Alberta","3", player2);
            Greenland = new Country("Greenland","3", player2);
            Quebec = new Country("Quebec","3", player2);
            Brazil = new Country("Brazil","3", player2);
            GreatBritain = new Country("GreatBritain","3", player2);
            Ukraine = new Country("Ukraine","3", player2);
            Congo = new Country("Congo","3", player2);
            Madagascar = new Country("Madagascar","3", player2);
            Afghanistan = new Country("Afghanistan","3", player2);
            Irkutsk = new Country("Irkutsk","2", player2);
            MiddleEast = new Country("MiddleEast","1", player2);

            player2.add(Alberta);
            player2.add(Greenland);
            player2.add(Quebec);
            player2.add(Brazil);
            player2.add(GreatBritain);
            player2.add(Ukraine);
            player2.add(Congo);
            player2.add(Madagascar);
            player2.add(Afghanistan);
            player2.add(Irkutsk);
            player2.add(MiddleEast);


            //Player3
            CentralAmerica = new Country("CentralAmerica","3", player3);
            NorthwestTerritory = new Country("NorthwestTerritory","3", player3);
            WesternUnitedStates = new Country("WesternUnitedStates","3", player3);
            Peru = new Country("Peru","3", player3);
            Iceland = new Country("Iceland","3", player3);
            SouthernEurope = new Country("SouthernEurope","3", player3);
            EastAfrica = new Country("EastAfrica","3", player3);
            NorthAfrica = new Country("NorthAfrica","3", player3);
            China = new Country("China","3", player3);
            Japan = new Country("Japan","3", player3);

            player3.add(CentralAmerica);
            player3.add(NorthwestTerritory);
            player3.add(WesternUnitedStates);
            player3.add(Peru);
            player3.add(Iceland);
            player3.add(SouthernEurope);
            player3.add(EastAfrica);
            player3.add(NorthAfrica);
            player3.add(China);
            player3.add(Japan);

            //Player 4
            Siam = new Country("Siam","3", player4);
            Yakutsk = new Country("Yakutsk","3", player4);
            NewGuinea = new Country("NewGuinea","3", player4);
            Ural = new Country("Ural","3", player4);
            EasternAustralia = new Country("EasternAustralia","3", player4);
            WesternAustralia = new Country("WesternAustralia","3", player4);
            Mongolia = new Country("Mongolia","3", player4);
            Siberia = new Country("Siberia","3", player4);
            Indonesia = new Country("Indonesia","3", player4);
            Scandinavia = new Country("Scandinavia","3", player4);

            player4.add(Siam);
            player4.add(Yakutsk);
            player4.add(NewGuinea);
            player4.add(Ural);
            player4.add(EasternAustralia);
            player4.add(WesternAustralia);
            player4.add(Mongolia);
            player4.add(Siberia);
            player4.add(Indonesia);
            player4.add(Scandinavia);


        }else if (numOfPlayers ==5){

            //5 PLAYERS-Each player gets 25 armies. Two players get 9 territories each and the other three get 8.
            player1Countries = new ArrayList<Country>();
            player2Countries = new ArrayList<Country>();
            player3Countries = new ArrayList<Country>();
            player4Countries = new ArrayList<Country>();
            player5Countries = new ArrayList<Country>();

            player1 = new Player(player1Countries);
            player2 = new Player(player2Countries);
            player3 = new Player(player3Countries);
            player4 = new Player(player4Countries);
            player5 = new Player(player5Countries);

            //Player 1
            Alaska = new Country("Alaska","3", player1 );
            EasterUnitedStates = new Country("EasternUnitedStates","3", player1);
            Ontario = new Country("Ontario","3", player1);
            Argentina = new Country("Argentina","3", player1);
            Venezuela = new Country("Venezuela","3", player1);
            NorthernEurope = new Country(" NorthernEurope","3", player1);
            WesternEurope = new Country("WesternEurope","3", player1);
            Egypt = new Country("Egypt","2", player1);
            SouthAfrica = new Country("Scandinavia","2", player1);

            player1.add(Alaska);
            player1.add(EasterUnitedStates);
            player1.add(Ontario);
            player1.add(Argentina);
            player1.add(Venezuela);
            player1.add(NorthernEurope);
            player1.add(WesternEurope);
            player1.add(Egypt);
            player1.add(SouthAfrica);

            //Player2
            Alberta = new Country("Alberta","3", player2);
            Greenland = new Country("Greenland","3", player2);
            Quebec = new Country("Quebec","3", player2);
            Brazil = new Country("Brazil","3", player2);
            GreatBritain = new Country("GreatBritain","3", player2);
            Ukraine = new Country("Ukraine","3", player2);
            Congo = new Country("Congo","3", player2);
            Madagascar = new Country("Madagascar","2", player2);
            Afghanistan = new Country("Afghanistan","2", player2);

            player2.add(Alberta);
            player2.add(Greenland);
            player2.add(Quebec);
            player2.add(Brazil);
            player2.add(GreatBritain);
            player2.add(Ukraine);
            player2.add(Congo);
            player2.add(Madagascar);
            player2.add(Afghanistan);

            //Player3
            CentralAmerica = new Country("CentralAmerica","3", player3);
            NorthwestTerritory = new Country("NorthwestTerritory","3", player3);
            WesternUnitedStates = new Country("WesternUnitedStates","3", player3);
            Peru = new Country("Peru","3", player3);
            Iceland = new Country("Iceland","3", player3);
            SouthernEurope = new Country("SouthernEurope","3", player3);
            EastAfrica = new Country("EastAfrica","3", player3);
            NorthAfrica = new Country("NorthAfrica","4", player3);


            player3.add(CentralAmerica);
            player3.add(NorthwestTerritory);
            player3.add(WesternUnitedStates);
            player3.add(Peru);
            player3.add(Iceland);
            player3.add(SouthernEurope);
            player3.add(EastAfrica);
            player3.add(NorthAfrica);


            //Player 4
            Siam = new Country("Siam","3", player4);
            Yakutsk = new Country("Yakutsk","3", player4);
            NewGuinea = new Country("NewGuinea","3", player4);
            Ural = new Country("Ural","3", player4);
            EasternAustralia = new Country("EasternAustralia","3", player4);
            WesternAustralia = new Country("WesternAustralia","3", player4);
            Mongolia = new Country("Mongolia","3", player4);
            Siberia = new Country("Siberia","4", player4);

            player4.add(Siam);
            player4.add(Yakutsk);
            player4.add(NewGuinea);
            player4.add(Ural);
            player4.add(EasternAustralia);
            player4.add(WesternAustralia);
            player4.add(Mongolia);
            player4.add(Siberia);

            //Player 5
            India = new Country("India","3", player5);
            Kamchatka = new Country("Kamchatka","3", player5);
            Irkutsk = new Country("Irkutsk","3", player5);
            MiddleEast = new Country("MiddleEast","3", player5);
            China = new Country("China","3", player5);
            Japan = new Country("Japan","3", player5);
            Indonesia = new Country("Indonesia","3", player5);
            Scandinavia = new Country("Scandinavia","4", player5);

            player5.add(India);
            player5.add(Kamchatka);
            player5.add(Irkutsk);
            player5.add(MiddleEast);
            player5.add(China);
            player5.add(Japan);
            player5.add(Indonesia);
            player5.add(Scandinavia);

        }else if (numOfPlayers ==6){

            //6 PLAYERS-Each player gets 20 armies. Each player gets 7 territories

            player1Countries = new ArrayList<Country>();
            player2Countries = new ArrayList<Country>();
            player3Countries = new ArrayList<Country>();
            player4Countries = new ArrayList<Country>();
            player5Countries = new ArrayList<Country>();
            player6Countries = new ArrayList<Country>();

            player1 = new Player(player1Countries);
            player2 = new Player(player2Countries);
            player3 = new Player(player3Countries);
            player4 = new Player(player4Countries);
            player5 = new Player(player5Countries);
            player6 = new Player(player6Countries);

            //Player 1
            Alaska = new Country("Alaska","3", player1 );
            EasterUnitedStates = new Country("EasternUnitedStates","3", player1);
            Ontario = new Country("Ontario","3", player1);
            Argentina = new Country("Argentina","3", player1);
            Venezuela = new Country("Venezuela","3", player1);
            NorthernEurope = new Country(" NorthernEurope","3", player1);
            WesternEurope = new Country("WesternEurope","2", player1);

            player1.add(Alaska);
            player1.add(EasterUnitedStates);
            player1.add(Ontario);
            player1.add(Argentina);
            player1.add(Venezuela);
            player1.add(NorthernEurope);
            player1.add(WesternEurope);

            //Player2
            Alberta = new Country("Alberta","3", player2);
            Greenland = new Country("Greenland","3", player2);
            Quebec = new Country("Quebec","3", player2);
            Brazil = new Country("Brazil","3", player2);
            GreatBritain = new Country("GreatBritain","3", player2);
            Ukraine = new Country("Ukraine","3", player2);
            Congo = new Country("Congo","2", player2);

            player2.add(Alberta);
            player2.add(Greenland);
            player2.add(Quebec);
            player2.add(Brazil);
            player2.add(GreatBritain);
            player2.add(Ukraine);
            player2.add(Congo);

            //Player3
            CentralAmerica = new Country("CentralAmerica","3", player3);
            NorthwestTerritory = new Country("NorthwestTerritory","3", player3);
            WesternUnitedStates = new Country("WesternUnitedStates","3", player3);
            Peru = new Country("Peru","3", player3);
            Iceland = new Country("Iceland","3", player3);
            SouthernEurope = new Country("SouthernEurope","3", player3);
            EastAfrica = new Country("EastAfrica","2", player3);

            player3.add(CentralAmerica);
            player3.add(NorthwestTerritory);
            player3.add(WesternUnitedStates);
            player3.add(Peru);
            player3.add(Iceland);
            player3.add(SouthernEurope);
            player3.add(EastAfrica);

            //Player 4
            Siam = new Country("Siam","3", player4);
            Yakutsk = new Country("Yakutsk","3", player4);
            NewGuinea = new Country("NewGuinea","3", player4);
            Ural = new Country("Ural","3", player4);
            EasternAustralia = new Country("EasternAustralia","3", player4);
            WesternAustralia = new Country("WesternAustralia","3", player4);
            Mongolia = new Country("Mongolia","2", player4);

            player4.add(Siam);
            player4.add(Yakutsk);
            player4.add(NewGuinea);
            player4.add(Ural);
            player4.add(EasternAustralia);
            player4.add(WesternAustralia);
            player4.add(Mongolia);


            //Player 5
            India = new Country("India","3", player5);
            Kamchatka = new Country("Kamchatka","3", player5);
            Irkutsk = new Country("Irkutsk","3", player5);
            MiddleEast = new Country("MiddleEast","3", player5);
            China = new Country("China","3", player5);
            Japan = new Country("Japan","3", player5);
            Indonesia = new Country("Indonesia","2", player5);

            player5.add(India);
            player5.add(Kamchatka);
            player5.add(Irkutsk);
            player5.add(MiddleEast);
            player5.add(China);
            player5.add(Japan);
            player5.add(Indonesia);

            //Player 6
            Egypt = new Country("Egypt","3", player6);
            SouthAfrica = new Country("Scandinavia","3", player6);
            Madagascar = new Country("Madagascar","3", player6);
            Afghanistan = new Country("Afghanistan","3", player6);
            NorthAfrica = new Country("NorthAfrica","3", player6);
            Siberia = new Country("Siberia","3", player6);
            Scandinavia = new Country("Scandinavia","2", player6);

            player6.add(Egypt);
            player6.add(SouthAfrica);
            player6.add(Madagascar);
            player6.add(Afghanistan);
            player6.add(Scandinavia);
            player6.add(Siberia);
            player6.add(NorthAfrica);
        }

    }

    public void printRules(){
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
                        "dice you rolled in your last attack."
                );
    }
}
