package interface_adapter.turn_select;

public class TurnSelectState {

    private int playerHealth = 15;
    private int playerLevel = 1;
    // I'm not implementing that "copy" constructor right now, it seems useless in week5ca

    public TurnSelectState(){}

    public int getPlayerHealth(){
        return playerHealth;
    }
    public int getPlayerLevel(){
        return playerLevel;
    }
    public void setPlayerHealth(int current_health){
        this.playerHealth = current_health;
    }
    public void setPlayerLevel(int level){
        this.playerLevel = level;
    }
}
