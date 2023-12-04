package use_case.UseItem;

import data_access.InBattleDataAccessObject;
import entity.ActivePlayer;
import entity.Player;

public interface UseItemDataAccessInterface {
    boolean useItem(int potionType, InBattleDataAccessObject inBattleDataAccessObject);
}
