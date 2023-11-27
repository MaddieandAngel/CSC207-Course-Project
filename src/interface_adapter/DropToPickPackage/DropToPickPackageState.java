package interface_adapter.DropToPickPackage;

import entity.ActivePlayer;
import entity.BagAndItems.Bag;

public class DropToPickPackageState {
    private ActivePlayer player;
    private Bag bag;

    public DropToPickPackageState(DropToPickPackageState dropToPickPackageState){
        this.player = dropToPickPackageState.player;
        this.bag = dropToPickPackageState.bag;
    }
    public DropToPickPackageState(){}

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
