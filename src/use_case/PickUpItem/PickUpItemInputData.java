package use_case.PickUpItem;

import entity.BagAndItems.Bag;
import entity.BagAndItems.Item;

public class PickUpItemInputData {
    final Player player;
    final Item item;

    public PickUpItemInputData(Player player, Item item) {
        this.player = player;
        this.item = item;
    }
    public Bag getBag(){
        return player.getBag();
    }
}
