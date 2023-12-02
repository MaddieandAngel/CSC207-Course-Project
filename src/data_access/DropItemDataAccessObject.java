package data_access;

import entity.ActivePlayer;
import use_case.DropItem.DropItemDataAccessInterface;

public class DropItemDataAccessObject implements DropItemDataAccessInterface {
    @Override
    public boolean dropItem(int potionType, ActivePlayer player) {
        boolean success = player.getBag().dropItem(potionType);
        return success;
    }
}
