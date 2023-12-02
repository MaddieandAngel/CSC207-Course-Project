package entity.BagAndItems;

import entity.Player;

public interface Item {
    void heal(Player player);
    String usage();
    String getName();

}
