package entity.BagAndItems;

import entity.ActivePlayer;

public class healingPotion20 implements Item{
    private final String itemName;
    private final double percentage;

    public healingPotion20() {
        this.percentage = 0.2;
        this.itemName = "HealingPotion(20%)";
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
        return "This potion heals 20% of your maxHealth.";
    }
    @Override
    public  String getName(){
        return this.itemName;
    }
}
