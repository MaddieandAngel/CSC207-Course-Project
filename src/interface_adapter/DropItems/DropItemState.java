package interface_adapter.DropItems;

import entity.BagAndItems.Bag;

public class DropItemState {
    private Player player;
    private Bag bag;

    public DropItemState(DropItemState dropItemState){
        this.player = dropItemState.player;
        this.bag = dropItemState.bag;
    }
    public DropItemState(){}

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
