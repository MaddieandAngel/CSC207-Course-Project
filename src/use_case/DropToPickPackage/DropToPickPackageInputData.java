package use_case.DropToPickPackage;

import entity.ActivePlayer;
import entity.BagAndItems.Bag;
import entity.Player;

public class DropToPickPackageInputData {
    final int potionType;
    public DropToPickPackageInputData(int num){
        this.potionType = num;
    }
    int getPotionType(){return potionType;}
}
