package interface_adapter.UseItems;

import entity.BagAndItems.Bag;
import entity.Player;

public class UseItemState {
    private Player player;
    private Bag bag;

    public UseItemState(UseItemState useItemState){
        this.player = useItemState.player;
        this.bag = useItemState.bag;
    }
    public UseItemState(){}

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
