package data_access;

import entity.ActivePlayer;
import entity.Player;
import use_case.DropItem.DropItemDataAccessInterface;

public class DropItemDataAccessObject implements DropItemDataAccessInterface {
    @Override
    public boolean dropItem(int potionType, Player player) {
        boolean success = player.getBag().dropItem(potionType);
        return success;
    }
}
