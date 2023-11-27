package entity.BagAndItems;

import entity.ActivePlayer;

public class revivePotion implements Item{
    private final String potionName;
    public revivePotion(){
        this.potionName = "RevivePotion";
    }

    @Override
    public void heal(ActivePlayer player) {
        player.setHealth(player.getMaxHealth());
    }
    @Override
    public String usage(){
        return "This potion will automatically be used when you failed, and will heal you to your max HP";
    }
    @Override
    public String getName(){
        return this.potionName;
    }
}
