package entity.BagAndItems;

import entity.Player;

public class healingPotion45 implements Item{
    private final String itemName;
    private final double percentage;

    public healingPotion45() {
        this.percentage = 0.45;
        this.itemName = "HealingPotion(45%)";
    }

    @Override
    public void heal(Player player) {
        int currentHealth = player.getMaxHealth();
        int addHealth = (int) Math.round(currentHealth * percentage);
        player.setHealth(currentHealth + addHealth);
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
