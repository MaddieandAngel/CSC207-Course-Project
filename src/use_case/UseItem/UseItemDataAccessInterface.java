package use_case.UseItem;

import entity.ActivePlayer;

public interface UseItemDataAccessInterface {
    boolean useItem(int potionType, ActivePlayer player);
}
