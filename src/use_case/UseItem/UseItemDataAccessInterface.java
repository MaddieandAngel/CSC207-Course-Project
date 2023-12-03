package use_case.UseItem;

import entity.ActivePlayer;
import entity.Player;

public interface UseItemDataAccessInterface {
    boolean useItem(int potionType, Player player);
}
