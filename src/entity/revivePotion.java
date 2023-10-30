package entity;

public class revivePotion implements Item{
    private final String potionName = "RevivePotion";

    @Override
    public void healingPotion(Player player) {
        player.setHealth(player.getMaxHealth());
    }
}
