package data_access;
import entity.ActivePlayer;
import entity.Player;
import use_case.UseItem.UseItemDataAccessInterface;

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
    public boolean useItem(int potionType, Player player) {
        boolean success = player.getBag().useItem(potionType, player);
        return success;
    }
}
