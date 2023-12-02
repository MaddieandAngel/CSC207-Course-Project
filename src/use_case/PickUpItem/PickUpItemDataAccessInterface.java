package use_case.PickUpItem;

import entity.BagAndItems.Bag;
import entity.BagAndItems.Item;

public interface PickUpItemDataAccessInterface {
    public boolean addItem(Bag bag, Item item);
}
