package interface_adapter.AttackSelect;

public class AttackSelectState {

    // private String hand;

    private int playerHealth;

    private int playerMaxHealth;

    private String hand;

    AttackSelectState(String hand, int playerHealth, int playerMaxHealth) {
        this.hand = hand;
        this.playerHealth = playerHealth;
        this.playerMaxHealth = playerMaxHealth;
    }

    public String getHand() {
        return this.hand;
    }

    public int getPlayerHealth() {
        return this.playerHealth;
    }

    public int getPlayerMaxHealth() {
        return this.playerMaxHealth;
    }
}
