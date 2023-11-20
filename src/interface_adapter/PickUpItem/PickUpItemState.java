package interface_adapter.PickUpItem;

import entity.BagAndItems.Bag;
import entity.Player;
import interface_adapter.UseItems.UseItemState;

public class PickUpItemState {
    private Player player;
    private Bag bag;

    public PickUpItemState(PickUpItemState pickUpItemState){
        this.player = pickUpItemState.player;
        this.bag = pickUpItemState.bag;
    }
    public PickUpItemState(){}

    public Player getPlayer() {
        return player;
    }
    public Bag getBag(){
        return bag;
    }
    public void setPlayer(Player player){
        this.player = player;
    }
    public void setBag(Bag bag){
        this.bag = bag;
    }
}
