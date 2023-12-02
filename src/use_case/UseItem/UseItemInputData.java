package use_case.UseItem;
import entity.ActivePlayer;
import entity.BagAndItems.Bag;

public class UseItemInputData{

    final ActivePlayer player;
    final int potionType;
    public UseItemInputData(ActivePlayer player, int num){
        this.player = player;
        this.potionType = num;
    }
    Bag getBag(){
        return player.getBag();
    }
}
