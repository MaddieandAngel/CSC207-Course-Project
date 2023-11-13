package use_case.UseItem;
import entity.BagAndItems.Item;
import entity.BagAndItems.Bag;
import entity.Player;

public class UseItemInputData{

    final Player player;
    final int potionType;
    public UseItemInputData(Player player, int num){
        this.player = player;
        this.potionType = num;
    }
    Bag getBag(){
        return player.getBag();
    }
}
