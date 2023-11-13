package entity.BagAndItems;


import entity.Player;

public class healingPotion10 implements Item{
    private final String itemName;
    private final double percentage;

    public healingPotion10() {
        this.percentage = 0.1;
        this.itemName = "HealingPotion(10%)";
    }

    @Override
    public void heal(Player player) {
        int currentHealth = player.getMaxHealth();
        int addHealth = (int) Math.round(currentHealth * percentage);
        player.setHealth(currentHealth + addHealth);
    }
    @Override
    public String usage(){
        return "This potion heals 10% of your maxHealth.";
    }
    @Override
    public  String getName(){
        return this.itemName;
    }
}
