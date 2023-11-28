package entity.BagAndItems;

import entity.ActivePlayer;

public interface Bag {
    public boolean addItem(Item newItem);
    public boolean isFull();
    public void levelUpBag();
    public boolean useItem(int potionType, ActivePlayer player);
    public boolean dropItem(int potionType);
    public int numOfItemsTotal();
    public int numOfHeal10();
    public int numOfHeal20();
    public int numOfHeal45();
    public int numOfRevive();

}
