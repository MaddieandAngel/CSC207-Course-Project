package entity.BagAndItems;

import entity.ActivePlayer;

public interface Item {
    void heal(ActivePlayer player);
    String usage();
    String getName();

}
