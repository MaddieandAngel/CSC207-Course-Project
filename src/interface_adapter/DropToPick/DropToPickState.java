package interface_adapter.DropToPick;

import entity.ActivePlayer;
import entity.BagAndItems.Bag;

public class DropToPickState {
    private ActivePlayer player;
    private Bag bag;

    public DropToPickState (DropToPickState  dropToPickState ){
        this.player = dropToPickState.player;
        this.bag = dropToPickState.bag;
    }
    public DropToPickState (){}

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
