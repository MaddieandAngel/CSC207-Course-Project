package interface_adapter.PickUpItem;

import entity.ActivePlayer;
import entity.BagAndItems.Bag;

public class PickUpItemState {
    private ActivePlayer player;
    private Bag bag;

    public PickUpItemState(PickUpItemState pickUpItemState){
        this.player = pickUpItemState.player;
        this.bag = pickUpItemState.bag;
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
}
