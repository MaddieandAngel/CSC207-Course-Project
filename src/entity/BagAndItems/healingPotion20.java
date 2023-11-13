package entity.BagAndItems;

import entity.Player;

public class healingPotion20 implements Item{
    private final String itemName;
    private final double percentage;

    public healingPotion20() {
        this.percentage = 0.2;
        this.itemName = "HealingPotion(20%)";
    }

    @Override
    public void heal(Player player) {
        int currentHealth = player.getMaxHealth();
        int addHealth = (int) Math.round(currentHealth * percentage);
        player.setHealth(currentHealth + addHealth);
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
