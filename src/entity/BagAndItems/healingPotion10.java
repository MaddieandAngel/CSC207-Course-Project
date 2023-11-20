package entity.BagAndItems;


public class healingPotion10 implements Item{
    private final String itemName;
    private final double percentage;

    public healingPotion10() {
        this.percentage = 0.1;
        this.itemName = "HealingPotion(10%)";
    }

    @Override
    public void heal(Player player) {
        int currentHealth = player.getCurrentHealth();
        int addHealth = (int) Math.floor(player.getMaxHealth() * percentage);
        int set_health = currentHealth + addHealth;
        player.setHealth(set_health);
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
