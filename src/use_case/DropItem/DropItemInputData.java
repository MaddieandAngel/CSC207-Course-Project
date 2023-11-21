package use_case.DropItem;

import entity.BagAndItems.Bag;

public class DropItemInputData {
    final Player player;
    final int potionType;
    public DropItemInputData(Player player, int num){
        this.player = player;
        this.potionType = num;
    }
    Bag getBag(){
        return player.getBag();
    }
}
