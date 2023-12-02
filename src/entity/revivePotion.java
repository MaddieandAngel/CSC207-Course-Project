package entity;

import entity.BagAndItems.Item;

public class revivePotion implements Item {
    private final String potionName = "RevivePotion";

    @Override
    public void heal(Player player) {
        player.setHealth(player.getMaxHealth());
    }
    @Override
    public String usage(){
        return "This potion will be used when you fail a game, and will heal you with your max hp";
    }

    @Override
    public String getName() {
        return "RevivePotion";
    }
}
