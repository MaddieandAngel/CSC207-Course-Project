package entity;

public class revivePotion implements Item{
    private final String potionName = "RevivePotion";

    @Override
    public void heal(Player player) {
        player.setHealth(player.getMaxHealth());
    }
    @Override
    public String usage(){
        return "This potion will automatically be used when you failed, and will heal you to your max HP";
    }
}
