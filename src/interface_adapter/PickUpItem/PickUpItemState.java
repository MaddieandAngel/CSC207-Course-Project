package interface_adapter.PickUpItem;

import entity.ActivePlayer;
import entity.BagAndItems.Bag;
import entity.BagAndItems.Item;

public class PickUpItemState {
    private ActivePlayer player;
    private Bag bag;
    private Item item;

    public PickUpItemState(PickUpItemState pickUpItemState){
        this.player = pickUpItemState.player;
        this.bag = pickUpItemState.bag;
        this.item = null;
    }
    public PickUpItemState(){}

    public ActivePlayer getPlayer() {
        return player;
    }
    public Bag getBag(){
        return bag;
    }
    public void setPlayer(ActivePlayer player){
        this.player = player;
    }
    public void setBag(Bag bag){
        this.bag = bag;
    }
    public void setItem(Item item){
        this.item = item;
    }
    public Item getItem(){
        return item;
    }
}
