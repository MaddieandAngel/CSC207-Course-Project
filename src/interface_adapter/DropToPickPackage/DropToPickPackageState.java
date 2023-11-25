package interface_adapter.DropToPickPackage;

import entity.BagAndItems.Bag;

public class DropToPickPackageState {
    private Player player;
    private Bag bag;

    public DropToPickPackageState(DropToPickPackageState dropToPickPackageState){
        this.player = dropToPickPackageState.player;
        this.bag = dropToPickPackageState.bag;
    }
    public DropToPickPackageState(){}

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
