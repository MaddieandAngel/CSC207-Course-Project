package entity.BagAndItems;

import entity.ActivePlayer;

public class healingPotion45 implements Item{
    private final String itemName;
    private final double percentage;

    public healingPotion45() {
        this.percentage = 0.45;
        this.itemName = "HealingPotion(45%)";
    }

    @Override
    public void heal(ActivePlayer player) {
        int currentHealth = player.getCurrentHealth();
        int addHealth = (int) Math.floor(player.getMaxHealth() * percentage);
        int set_health = currentHealth + addHealth;
        player.setHealth(set_health);
    }
    @Override
    public String usage(){
        return "This potion heals 45% of your maxHealth.";
    }
    @Override
    public  String getName(){
        return this.itemName;
    }
}
