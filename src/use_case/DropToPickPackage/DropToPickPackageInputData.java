package use_case.DropToPickPackage;

import entity.BagAndItems.Bag;
import entity.Player;

public class DropToPickPackageInputData {
    final Player player;
    final int potionType;
    public DropToPickPackageInputData(Player player, int num){
        this.player = player;
        this.potionType = num;
    }
    Bag getBag(){
        return player.getBag();
    }
}
