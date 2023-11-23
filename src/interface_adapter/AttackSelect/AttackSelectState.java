package interface_adapter.AttackSelect;

public class AttackSelectState {

    private int playerHealth;

    private int playerMaxHealth;

    private String[] playerHand;

    AttackSelectState() {
    }

    public String[] getHand() {
        return this.playerHand;
    }

    public void setPlayerHand(String[] hand) { this.playerHand = hand; }

    public int getPlayerHealth() {
        return this.playerHealth;
    }

    public void setPlayerHealth(int health) { this.playerHealth = health; }

    public int getPlayerMaxHealth() {
        return this.playerMaxHealth;
    }

    public void setPlayerMaxHealth(int maxHealth) { this.playerMaxHealth = maxHealth; }
}
