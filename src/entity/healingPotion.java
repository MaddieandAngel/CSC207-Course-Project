package entity;


import entity.BagAndItems.Item;

public class healingPotion implements Item {
    private final String itemName = "HealingPotion";
    private final double percentage;

    public healingPotion(Integer potionLevel, double percentage) {
        this.percentage = percentage;
    }

    @Override
    public void heal(Player player) {
        int currentHealth = player.getMaxHealth();
        int addHealth = (int) Math.round(currentHealth * percentage);
        player.setHealth(currentHealth + addHealth);
    }
    @Override
    public String usage(){
        return "This potion heals " + percentage + " of your max HP.";
    }
}
