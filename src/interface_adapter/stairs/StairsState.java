package interface_adapter.stairs;

public class StairsState {

    private int playerLevel = 1;
    private int floorLevel = 1;
    private int playerCurrentHealth = 15;
    private int playerMaxHealth = 15;

    public StairsState(){}

    public int getPlayerLevel() {
        return playerLevel;
    }
    public int getFloorLevel() {
        return floorLevel;
    }
    public int getPlayerCurrentHealth() {
        return playerCurrentHealth;
    }
    public int getPlayerMaxHealth() {
        return playerMaxHealth;
    }
    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }
    public void setFloorLevel(int floorLevel) {
        this.floorLevel = floorLevel;
    }
    public void setPlayerCurrentHealth(int playerCurrentHealth) {
        this.playerCurrentHealth = playerCurrentHealth;
    }
    public void setPlayerMaxHealth(int playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }
}
