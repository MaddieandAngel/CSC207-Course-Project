package interface_adapter.UseItems;

import entity.ActivePlayer;
import entity.BagAndItems.Bag;

public class UseItemState {
    private ActivePlayer player;
    private Bag bag;

    public UseItemState(UseItemState useItemState){
        this.player = useItemState.player;
        this.bag = useItemState.bag;
    }
    public UseItemState(){}

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
