package use_case.AttackButton.BackButton;

import entity.BagAndItems.Bag;

public class BackButtonOutputData {

    private int currentHealth;

    private String[] hand;

    private int playerLevel;

    private Bag inventory;

    public BackButtonOutputData(int currentHealth, String[] hand, int playerLevel, Bag inventory) {
        this.currentHealth = currentHealth;
        this.hand = hand;
        this.playerLevel = playerLevel;
        this.inventory = inventory;
    }

    public int getCurrentHealth() { return this.currentHealth;}

    public int getPlayerLevel() { return this.playerLevel;}

    public String[] getHand() { return this.hand;}

    public Bag getInventory() { return this.inventory;}
}
