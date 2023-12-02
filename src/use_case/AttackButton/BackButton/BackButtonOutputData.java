package use_case.AttackButton.BackButton;

import entity.BagAndItems.Bag;

public class BackButtonOutputData {

    private int currentHealth;

    private int maxHealth;

    private int playerLevel;

    public BackButtonOutputData(int currentHealth, int maxHealth, int playerLevel) {
        this.currentHealth = currentHealth;
        this.playerLevel = playerLevel;
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public int getPlayerLevel() {
        return this.playerLevel;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }
}
