package use_case.DropItem;

import entity.ActivePlayer;
import entity.BagAndItems.Bag;

public class DropItemInputData {
    final ActivePlayer player;
    final int potionType;
    public DropItemInputData(ActivePlayer player, int num){
        this.player = player;
        this.potionType = num;
    }
    Bag getBag(){
        return player.getBag();
    }
}
