package use_case.PickUpItem;

import entity.BagAndItems.Bag;
import entity.BagAndItems.Item;

public class PickUpItemOutputData {
    private Bag bag;
    public PickUpItemOutputData(Bag bag){
        this.bag = bag;
    }
    public Bag getBag(){
        return bag;
    }
}
