package entity.BagAndItems;

import entity.Player;

import java.util.ArrayList;

public class Package implements Bag {
    private final ArrayList<Item> Items;
    private int MaxItems;
    private int level;
    Package(){
        this.Items = new ArrayList<>();
        this.MaxItems = 5;
        this.level = 0;
    }
    @Override
    public boolean isFull(){
        return Items.size() >= MaxItems;
    }
    @Override
    public boolean addItem(Item newItem){
        if (isFull()){
            return false;
        }
        Items.add(newItem);
        return true;
    }
    @Override
    public void levelUpBag(){
        level = level + 1;
        MaxItems = MaxItems + 2;
    }
    @Override
    public boolean useItem(Item item, Player player){
        item.heal(player);
        Items.remove(item);
        return true;
    }
    @Override
    public boolean dropItem(Item item, Player player){
        Items.remove(item);
        return true;
    }
    public String getLevel(){
        return Integer.toString(level);
    }
    public String getMaxItems(){
        return Integer.toString(MaxItems);
    }
    public String getItemName(Item item){
        return item.getName();
    }
    public  ArrayList<String> getItemNames(){
        ArrayList<String> names = new ArrayList<>();
        for (Item item : Items) {
            names.add(item.getName());
        }
        return names;
    }

}
