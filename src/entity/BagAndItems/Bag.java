package entity.BagAndItems;

import entity.Player;

public interface Bag {
    public boolean addItem(Item newItem);
    public boolean isFull();
    public void levelUpBag();
    public boolean useItem(Item item, Player player);
    public boolean dropItem(Item item, Player player);

}
