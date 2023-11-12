package use_case.UseItem;
import entity.BagAndItems.Item;
import entity.BagAndItems.Bag;
import entity.Player;

public interface UseItemDataAccessInterface {
    void useItem(Item item, Bag bag, Player player);
}
