package use_case.PickUpItem;

import entity.ActivePlayer;
import entity.BagAndItems.Bag;
import entity.BagAndItems.Item;

public class PickUpItemInputData {
    final ActivePlayer player;
    final Item item;

    public PickUpItemInputData(ActivePlayer player, Item item) {
        this.player = player;
        this.item = item;
    }
    public Bag getBag(){
        return player.getBag();
    }
}
