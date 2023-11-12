package data_access;
import entity.BagAndItems.Bag;
import entity.BagAndItems.BagFactory;
import entity.BagAndItems.Item;
import use_case.UseItem.UseItemDataAccessInterface;
import entity.Player;
public class UseItemDataAccessObject implements UseItemDataAccessInterface{
//    private Item item;
//    private Bag bag;
//    private Player player;
//    public UseItemDataAccessObject(Item item, Bag bag, Player player){
//        this.item = item;
//        this.bag = bag;
//        this.player = player;
//    }
    @Override
    public void useItem(Item item, Bag bag, Player player) {
        bag.useItem(item, player);
    }
}
