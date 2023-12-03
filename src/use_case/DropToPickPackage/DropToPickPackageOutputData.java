package use_case.DropToPickPackage;
import entity.Player;

public class DropToPickPackageOutputData {
    private Player player;
    public DropToPickPackageOutputData(Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
