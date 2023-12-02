package entity.BagAndItems;

import entity.Player;

public interface Bag {
    public boolean addItem(Item newItem);
    public boolean isFull();
    public void levelUpBag();
    public boolean useItem(int potionType, Player player);
    public boolean dropItem(int potionType);
    public int numOfItemsTotal();
    public int numOfHeal10();
    public int numOfHeal20();
    public int numOfHeal45();
    public int numOfRevive();

}
