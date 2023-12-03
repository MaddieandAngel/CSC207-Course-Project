package use_case.DropItem;

import entity.ActivePlayer;
import entity.BagAndItems.Bag;
import entity.Player;

public class DropItemInputData {
    final int potionType;
    public DropItemInputData(int num){
        this.potionType= num;
    }
    int getPotionType(){
        return potionType;
    }
}
