package interface_adapter.GameOver;

public class GameOverState {
    //this file might be unneeded
    private int playerLevel = 1;
    private int floorLevel = 1;
    private int playerCurrentHealth = 15;
    private int playerMaxHealth = 15;
    public GameOverState(){}

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getFloorLevel() {
        return floorLevel;
    }

    public void setFloorLevel(int floorLevel) {
        this.floorLevel = floorLevel;
    }

    public int getPlayerCurrentHealth() {
        return playerCurrentHealth;
    }

    public void setPlayerCurrentHealth(int playerCurrentHealth) {
        this.playerCurrentHealth = playerCurrentHealth;
    }

    public int getPlayerMaxHealth() {
        return playerMaxHealth;
    }

    public void setPlayerMaxHealth(int playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }
}
