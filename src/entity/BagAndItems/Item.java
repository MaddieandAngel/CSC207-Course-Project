package entity.BagAndItems;

import entity.ActivePlayer;

public interface Item {
    //TODO: implement

    void heal(ActivePlayer player);
    String usage();
    String getName();

}
