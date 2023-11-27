package interface_adapter.DropItems;

import entity.ActivePlayer;
import entity.BagAndItems.Bag;

public class DropItemState {
    private ActivePlayer player;
    private Bag bag;

    public DropItemState(DropItemState dropItemState){
        this.player = dropItemState.player;
        this.bag = dropItemState.bag;
    }
    public DropItemState(){}

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
