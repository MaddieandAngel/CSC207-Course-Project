package entity;


public class healingPotion implements Item{
    private final String itemName = "HealingPotion";
    private final double percentage;

    public healingPotion(Integer potionLevel, double percentage) {
        this.percentage = percentage;
    }

    @Override
    public void healingPotion(Player player) {
        int currentHealth = player.getMaxHealth();
        int addHealth = (int) Math.round(currentHealth * percentage);
        player.setHealth(currentHealth + addHealth);
    }
}
