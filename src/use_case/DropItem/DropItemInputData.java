package use_case.DropItem;

import entity.ActivePlayer;
import entity.BagAndItems.Bag;
import entity.Player;

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
