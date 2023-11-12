package use_case.UseItem;
import entity.BagAndItems.Item;
import entity.BagAndItems.Bag;
import entity.Player;

public class UseItemInputData{
    final Item item;
    final Bag bag;
    final Player player;
    public UseItemInputData(Item item, Bag bag, Player player){
        this.item = item;
        this.bag = bag;
        this.player = player;
    }
    Item getItem(){return item;}
    Bag getBag(){return bag;}
}
