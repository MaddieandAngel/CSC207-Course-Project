package use_case.AttackButton;

public class AttackButtonOutputData {

    private int currentHealth;

    private int maxHealth;

    private String[] hand;

    public AttackButtonOutputData(int currentHealth, int maxHealth, String[] hand) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.hand = hand;
    }

    public void setHand(String[] newHand) {
        this.hand = newHand;
    }

    public String[] getHand() {
        return this.hand;
    }

    public int getMaxHealth() { return this.maxHealth;}

    public int getCurrentHealth() {return this.currentHealth;}

}
