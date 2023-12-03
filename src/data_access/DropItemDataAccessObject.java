package data_access;

import entity.ActivePlayer;
import entity.Player;
import use_case.DropItem.DropItemDataAccessInterface;

public class DropItemDataAccessObject implements DropItemDataAccessInterface {
    @Override
    public boolean dropItem(int potionType, InBattleDataAccessObject inBattleDataAccessObject) {
        boolean success = inBattleDataAccessObject.getPlayer().getBag().dropItem(potionType);
        return success;
    }
}
