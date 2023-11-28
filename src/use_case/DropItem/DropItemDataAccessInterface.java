package use_case.DropItem;

import entity.ActivePlayer;

public interface DropItemDataAccessInterface {
    boolean dropItem(int potionType, ActivePlayer player);
}

