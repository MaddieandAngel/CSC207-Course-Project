package use_case.UseItem;
import entity.BagAndItems.Item;
import entity.BagAndItems.Bag;
import entity.Player;

public interface UseItemDataAccessInterface {
    boolean useItem(int potionType, Player player);
}
