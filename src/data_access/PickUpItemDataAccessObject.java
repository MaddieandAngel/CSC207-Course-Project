package data_access;

import entity.BagAndItems.Bag;
import entity.BagAndItems.Item;
import use_case.PickUpItem.PickUpItemDataAccessInterface;

public class PickUpItemDataAccessObject implements PickUpItemDataAccessInterface {
    @Override
    public boolean addItem(Bag bag, Item item) {
        return bag.addItem(item);
    }
}
