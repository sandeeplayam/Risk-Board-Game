public class Country {

    private String armies;
    private String name;
    private Player ruler;

    public Country(String name, String armies, Player ruler){
        this.armies=armies;
        this.name=name;
        this.ruler=ruler;
    }

    public String getName(){
        return name;
    }

    public String getArmies(){
        return armies;
    }

    public void setRuler(Player ruler) {
        this.ruler = ruler;
    }

    public Player getRuler(){
        return ruler;
    }


}
