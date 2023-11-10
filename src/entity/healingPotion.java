package entity;


public class healingPotion implements Item{
    private final String itemName;
    private final double percentage;

    public healingPotion(Integer potionLevel, double percentage) {
        this.percentage = percentage;
        this.itemName = "HealingPotion";
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
    @Override
    public  String getName(){
        return this.itemName;
    }
}
