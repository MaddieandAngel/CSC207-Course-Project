package interface_adapter.turn_select;

public class TurnSelectState {

    private int playerHealth = 15;
    private int playerMaxHealth = 15;
    private int playerLevel = 1;
    private String enemyName = "";
    private int enemyLevel = 1;
    // I'm not implementing that "copy" constructor right now, it seems useless in week5ca

    public TurnSelectState(){}

    public int getPlayerHealth(){
        return playerHealth;
    }
    public int getPlayerMaxHealth() {
        return playerMaxHealth;
    }
    public int getPlayerLevel(){
        return playerLevel;
    }
    public String getEnemyName() {
        return enemyName;
    }
    public int getEnemyLevel() {
        return enemyLevel;
    }
    public void setPlayerHealth(int current_health){
        this.playerHealth = current_health;
    }
    public void setPlayerMaxHealth(int playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }
    public void setPlayerLevel(int level){
        this.playerLevel = level;
    }
    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }
    public void setEnemyLevel(int enemyLevel) {
        this.enemyLevel = enemyLevel;
    }
}
