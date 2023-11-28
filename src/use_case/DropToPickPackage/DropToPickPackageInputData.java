package use_case.DropToPickPackage;

import entity.ActivePlayer;
import entity.BagAndItems.Bag;

public class DropToPickPackageInputData {
    final ActivePlayer player;
    final int potionType;
    public DropToPickPackageInputData(ActivePlayer player, int num){
        this.player = player;
        this.potionType = num;
    }
    Bag getBag(){
        return player.getBag();
    }
}
