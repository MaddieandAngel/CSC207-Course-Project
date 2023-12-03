package use_case.DropItem;

import entity.ActivePlayer;
import entity.Player;

public interface DropItemDataAccessInterface {
    boolean dropItem(int potionType, Player player);
}

