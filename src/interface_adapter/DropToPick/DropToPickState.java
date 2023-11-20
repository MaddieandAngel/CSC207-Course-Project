package interface_adapter.DropToPick;

import entity.BagAndItems.Bag;

public class DropToPickState {
    private Player player;
    private Bag bag;

    public DropToPickState (DropToPickState  dropToPickState ){
        this.player = dropToPickState.player;
        this.bag = dropToPickState.bag;
    }
    public DropToPickState (){}

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
