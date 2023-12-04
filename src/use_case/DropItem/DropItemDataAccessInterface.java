package use_case.DropItem;

import data_access.InBattleDataAccessObject;
import entity.ActivePlayer;
import entity.Player;

public interface DropItemDataAccessInterface {
    boolean dropItem(int potionType, InBattleDataAccessObject inBattleDataAccessObject);
}

