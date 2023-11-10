package entity;

import java.util.ArrayList;

public class Package implements Bag{
    private final ArrayList<Item> Items;
    private int MaxItems;
    Package(){
        this.Items = new ArrayList<>();
        this.MaxItems = 5;
    }
    public boolean isFull(){
        return Items.size() >= MaxItems;
    }
    public boolean addItem(Item newItem){
        if (isFull()){
            return false;
        }
        Items.add(newItem);
        return true;
    }
    public void levelUpBag(){
        MaxItems = MaxItems + 2;
    }
    public void useItem(Item item, Player player){
        item.heal(player);
        Items.remove(item);
    }
}
